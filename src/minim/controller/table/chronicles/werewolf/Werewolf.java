package minim.controller.table.chronicles.werewolf;

import java.util.ArrayList;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Werewolf extends Table {
	public static final Table AUSPICE = new SimpleTable("Werewolf (auspice)",
			List.of("Warrior", "Visinary", "Walker-between", "Spirit master", "Stalker"));

	public Werewolf() {
		super("Werewolf");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var lines = new ArrayList<String>();
		lines.add("Tribe: " + Tribe.INSTANCE.roll().toLowerCase());
		lines.add("Auspice: " + AUSPICE.roll().toLowerCase());
		return String.join(".\n", lines);
	}
}
