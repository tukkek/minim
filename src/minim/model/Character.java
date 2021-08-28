package minim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import minim.Minim;
import minim.controller.Cancel;
import minim.controller.action.base.Action;
import minim.view.Output;
import minim.view.UnitList;
import minim.view.dialog.LazyInputDialog;

public class Character implements Unit, Serializable {
	public static final Random RANDOM = new Random();
	public static final List<String> HEALTH = Arrays
			.asList(new String[] { "Unhurt", "Scratched", "Hurt", "Wounded (-1)", "Injured (-2)", "Dead" });

	public class ConfirmDeathDialog extends LazyInputDialog {
		public ConfirmDeathDialog(Character c) {
			super("Confirm " + c + "'s death?", false,
					Arrays.asList(new String[] { "Yes, remove from game.", "No, keep alive." }));
			title = "Dead";
		}

		public boolean confirm() throws Cancel {
			return getvalue() == 0;
		}
	}

	public class StatDialog extends LazyInputDialog {
		Integer previous;

		public StatDialog(String prompt, String stat, boolean multiple, Integer previous) {
			super(prompt, multiple, Arrays.asList(new String[] { "terrrible", "poor", "mediocre", "good", "amazing" }));
			this.previous = previous;
			title = name;
			numbered = true;
		}

		@Override
		public int getvalue() throws Cancel {
			return super.getvalue() + 1;
		}

		@Override
		protected boolean isselected(Object s, int i) {
			return previous == null ? i == 2 : i == previous - 1;
		}
	}

	public static class ModifierDialog extends LazyInputDialog {
		public ModifierDialog(String title) {
			super("Select the appropriate modifier:", false,
					Arrays.asList(new String[] { "Very difficult", "Difficult", "Normal", "Easy", "Very easy" }));
			this.title = title;
			numbered = true;
		}

		@Override
		public int getvalue() throws Cancel {
			return super.getvalue() - 2;
		}

		@Override
		protected boolean isselected(Object s, int i) {
			return i == 2;
		}
	}

	public String name;
	Map<String, Integer> stats = new HashMap<>();
	public int damage = 0;

	public Character(String name) {
		this.name = name;
	}

	@Override
	public String getname() {
		return name;
	}

	@Override
	public void run(Action action) throws Cancel {
		action.run(this);
	}

	public int getstat(String stat, boolean forceprompt) throws Cancel {
		Integer value = stats.get(stat.toLowerCase());
		if (!forceprompt && value != null) {
			return value;
		}
		final String prompt = "What should be the value for " + stat + "?";
		value = new StatDialog(prompt, stat, false, value).getvalue();
		stats.put(stat, value);
		return value;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void setname(String name) {
		this.name = name;
	}

	public int roll(String attribute, String skill, Action a) throws Cancel {
		int attributevalue = getstat(attribute);
		int skillvalue = getstat(skill);
		int attributeroll = roll();
		int skillroll = roll();
		int damage = Math.max(0, this.damage - 2);
		int modifier = 0;
		if (a.applymodifier) {
			modifier += Group.modifier == null ? new ModifierDialog(name).getvalue() : Group.modifier;
		}
		if (Minim.DEBUG) {
			String info;
			info = printroll(this, attribute, attributevalue, attributeroll);
			info += printroll(this, skill, skillvalue, skillroll);
			info += ">Modifier: " + modifier + " - " + damage + " damage";
			Output.print(info);
		}
		modifier = bind(modifier - damage, -2, +2);
		attributevalue = bind(attributevalue + modifier, 1, 5);
		skillvalue = bind(skillvalue + modifier, 1, 5);
		int result = 0;
		result += attributeroll <= attributevalue ? +1 : -1;
		result += skillroll <= skillvalue ? +1 : -1;
		if (result == 2 && Math.min(attributeroll, skillroll) != 1) {
			result = 1;
		} else if (result == -2 && Math.max(attributeroll, skillroll) != 6) {
			result = -1;
		}
		return result;
	}

	public int getstat(String name) throws Cancel {
		return getstat(name, false);
	}

	public static int roll() {
		return roll(6);
	}

	public static int roll(int sides) {
		return RANDOM.nextInt(sides) + 1;
	}

	private int bind(int value, int min, int max) {
		if (value < min) {
			return min;
		}
		if (value > max) {
			return max;
		}
		return value;
	}

	String printroll(minim.model.Character c, String name, int value, int roll) {
		return ">" + c + " rolls " + name + " (" + value + "). " + roll + "\n";
	}

	@Override
	public void remove(ArrayList<Unit> units) {
		units.remove(this);
		for (Unit u : new ArrayList<>(units)) {
			if (u instanceof Group) {
				Group g = (Group) u;
				g.remove(this);
				if (g.group.isEmpty()) {
					g.remove(units);
				}
			}
		}
		UnitList.singleton.updateunits();
	}

	public void damage(int d) throws Cancel {
		damage += d;
		if (damage <= 4) {
			return;
		}
		if (!new ConfirmDeathDialog(this).confirm()) {
			damage = 4;
			return;
		}
		damage = 5;
		remove(UnitList.singleton.units);
	}

	public String describehealth() {
		return HEALTH.get(damage);
	}
}
