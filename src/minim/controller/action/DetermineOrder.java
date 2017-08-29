package minim.controller.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import minim.Minim;
import minim.controller.action.base.SimpleAction;
import minim.model.Character;
import minim.model.Group;
import minim.view.Output;

public class DetermineOrder extends SimpleAction {
	Group g;

	public DetermineOrder(Group g) {
		super(g);
		this.g = g;
		applymodifier = false;
	}

	@Override
	public void run() {
		determineorder(g.group);
	}

	public void determineorder(ArrayList<Character> group) {
		HashMap<Object, Integer> initiatives = new HashMap<>();
		for (Character c : group) {
			initiatives.put(c, c.roll("social", "perception", this));
		}
		group = new ArrayList<>(group);
		Collections.shuffle(group);
		group.sort((a, b) -> {
			int delta = initiatives.get(b) - initiatives.get(a);
			if (delta != 0) {
				return delta;
			}
			return b.getstat("perception") - a.getstat("perception");
		});
		String result = "Initiative order:\n";
		for (Character c : group) {
			String roll = Minim.DEBUG ? " (" + initiatives.get(c) + ")" : "";
			result += "  " + c + roll + "\n";
		}
		Output.print(result);
	}
}
