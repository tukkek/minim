package minim.controller.table.chronicles.mage.social;

import java.util.ArrayList;

import minim.controller.table.Table;
import minim.model.Character;

public class Labyrinth extends Table {
	public static final Table FACTION = new Table("Mage (social, nephandi labyrinth, type)") {
		@Override
		public void build() {
			add(4, "Infernal");
			add(3, "Wyrm");
			add(1, "Deep Umbra");
			add(2, "Freelance");
		}
	};

	public Labyrinth() {
		super("Mage (social, nephandi labyrinth)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var lines = new ArrayList<String>();
		lines.add("Mages: " + (Character.roll(10) + Character.roll(10)));
		lines.add("Faction: " + FACTION.roll().toLowerCase());
		return String.join(".\n", lines);
	}
}
