package minim.controller.table.adventure.dungeon;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Grid extends SimpleTable {
	public static final Table SINGLETON = new Grid();

	Grid() {
		super("Dungeon (grid)", List.of("None", "Square", "Hex", "Vert-hex"));
	}

}
