package minim.controller.table.chronicles.mage.social;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

import minim.controller.table.Table;
import minim.controller.table.chronicles.mage.Tradition;
import minim.model.Character;

public class Chantry extends Table {
	public Chantry() {
		super("Mage (social, tradtitions chantry)");
	}

	@Override
	public void build() {
		// don't
	}

	String rolltype() {
		var r = Character.roll(3);
		String type;
		int ntraditions;
		if (r == 1) {
			type = "unified";
			ntraditions = 1;
		} else if (r == 2) {
			type = "mixed";
			ntraditions = Character.roll(2) + 1;
		} else {
			type = "open";
			ntraditions = 4;
			while (Character.roll(2) == 1)
				ntraditions += 1;
		}
		var traditions = new TreeSet<String>();
		while (traditions.size() < ntraditions) {
			traditions.add(Tradition.INSTANCE.roll().toLowerCase());
		}
		return "Type: %s (%s)".formatted(type, String.join(", ", traditions));
	}

	@Override
	public String roll() {
		var lines = new ArrayList<String>();
		lines.add("Cabals: " + Character.roll(6));
		lines.add("Mages: " + (Character.roll(20) + Character.roll(20)));
		lines.add(rolltype());
		var nnodes = Character.roll(6);
		var nodes = new ArrayList<Integer>(nnodes);
		var power = 0;
		for (var i = 0; i < nnodes; i++) {
			var n = Character.roll(3);
			nodes.add(n);
			power += n;
		}
		lines.add("Power: %s (nodes: %s)".formatted(power,
				nodes.stream().map(n -> n.toString()).collect(Collectors.joining(", "))));
		if (power >= 13) {
			lines.add("Has Doissetep-class Horizon Realms");
		} else if (power >= 10) {
			lines.add("Has Horizon Realms");
		}
		return String.join(".\n", lines);
	}
}
