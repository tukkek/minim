package minim.controller.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import minim.Minim;
import minim.controller.Cancel;
import minim.controller.action.base.SimpleAction;
import minim.model.Character;
import minim.model.Group;
import minim.view.Output;
import minim.view.UnitList;

public class DetermineOrder extends SimpleAction {
	Group g;

	public DetermineOrder(Group g) {
		super(g);
		this.g = g;
	}

	@Override
	public void run() throws Cancel {
		determineorder(g.group);
	}

	public void determineorder(ArrayList<Character> group) throws Cancel {
		HashMap<Object, Integer> initiatives = new HashMap<>();
		HashMap<Object, Integer> perceptions = new HashMap<>();
		for (Character c : group) {
			initiatives.put(c, c.roll("social", "perception", this));
			perceptions.put(c, c.getstat("perception"));
		}
		group = new ArrayList<>(group);
		Collections.shuffle(group);
		group.sort((a, b) -> {
			int delta = initiatives.get(b) - initiatives.get(a);
			if (delta != 0) {
				return delta;
			}
			return perceptions.get(a) - perceptions.get(b);
		});
		String result = "Initiative order:\n";
		var u = UnitList.singleton;
		u.units.removeAll(group);
		u.units.addAll(0, group);
		u.updateunits();
		for (Character c : group) {
			String roll = Minim.DEBUG ? " (" + initiatives.get(c) + ")" : "";
			result += "  " + c + roll + "\n";
		}
		Output.print(result);
	}
}
