package minim.controller.action.attack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import minim.controller.Cancel;
import minim.controller.action.base.BasicAction;
import minim.model.Character;
import minim.model.Unit;
import minim.view.Output;
import minim.view.UnitList;
import minim.view.dialog.LazyInputDialog;

public class Attack extends BasicAction {
	public static final String[] ATTACKS = new String[] { "&brawl", "&fire",
			"&shooting", };
	public static final String[] FUMBLES = new String[] {
			"is distracted (attackers get +1 to hit until next turn)",
			"falls to the ground", "moves back", "is disarmed or drops an item",
			"is now grappling", "is stunned for one turn",
			"is flat-footed (cannot move next turn)",
			"interacts with the surrounding environment" };

	public class TargetDialog extends LazyInputDialog {
		List<Character> targets;
		Character attacker;

		public TargetDialog(Character attacker, List<Character> targets) {
			super("Choose the target of this attack:", false, targets);
			this.attacker = attacker;
			this.targets = targets;
			title = attacker + "'s " + skill;
			numbered = true;
		}

		public Character gettarget() throws Cancel {
			return targets.get(getvalue());
		}

		@Override
		protected boolean isselected(Object o, int i) {
			return o == lasttarget && o != attacker;
		}
	}

	class ApplyDamageDialog extends LazyInputDialog {
		public ApplyDamageDialog(String skill) {
			super("Should this attack deal damage?", false, Arrays
					.asList(new String[] { "Apply damage", "Ignore damage" }));
		}

		boolean applydamage() throws Cancel {
			return getvalue() == 0;
		}

		@Override
		protected boolean isselected(Object o, int i) {
			return i == 0;
		}
	}

	Boolean damage = null;
	Character lasttarget = null;

	public Attack(String skill, Unit u) {
		super("physical", skill, u);
	}

	@Override
	protected void prepare() {
		damage = null;
	}

	@Override
	public int run(Character c) throws Cancel {
		int result = super.run(c);
		if (result == 0) {
			fumble(gettarget(c));
			return result;
		} else if (result == -2) {
			fumble(c);
		} else if (result > 0) {
			if (damage == null) {
				damage = new ApplyDamageDialog(skill).applydamage();
			}
			if (!damage) {
				return result;
			}
			Character target = gettarget(c);
			final int weapon = c.getstat("weapon", true);
			final int armor = target.getstat("armor", true);
			int damage = result + weapon - armor;
			damage = Math.max(1, damage);
			target.damage(damage);
			final String health = target.describehealth().toLowerCase();
			Output.print(target + " is " + health + ".");
		}
		return result;
	}

	void fumble(Character c) {
		final int fumble = Character.RANDOM.nextInt(FUMBLES.length);
		Output.print(c + " " + FUMBLES[fumble] + ".");
	}

	Character gettarget(Character attacker) throws Cancel {
		ArrayList<Character> targets = UnitList.singleton.getcharacters();
		lasttarget = new TargetDialog(attacker, targets).gettarget();
		return lasttarget;
	}
}
