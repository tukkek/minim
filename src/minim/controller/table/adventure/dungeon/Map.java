package minim.controller.table.adventure.dungeon;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Map extends Table {
	public static final Table SINGLETON = new Map();

	static final Table BASIC = new SimpleTable("Basic", List.of("Standard", "Classic"));
	static final Table PNP = new SimpleTable("Pen-and-paper", List.of("Crosshatch", "Graph paper", "Parchment"));
	static final Table STONEWORK = new SimpleTable("Stonework", List.of("Marble", "Sandstone", "Slate"));
	static final Table EXOTIC = new SimpleTable("Exotic", List.of("Aquatic", "Infernal", "Glacial", "Wooden"));
	static final Table OTHER = new SimpleTable("Other", List.of("Asylum", "Steampunk", "Gamma"));
	static final List<Table> MAPS = List.of(BASIC, PNP, STONEWORK, EXOTIC, OTHER);

	Map() {
		super("Dungeon (map)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var m = MAPS.get(Character.roll(MAPS.size() - 1));
		return m.roll().toLowerCase();
	}
}
