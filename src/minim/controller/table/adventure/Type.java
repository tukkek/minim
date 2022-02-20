package minim.controller.table.adventure;

import java.util.List;

import minim.controller.table.Table;

public class Type extends Table {
	public static final Type SINGLETON = new Type();
	public static final String URBAN = "Urban";
	public static final String HEXCRAWL = "Wilderness";
	public static final String DUNGEON = "Dungeon";

	Type() {
		super("Adventure type");
	}

	@Override
	public void build() {
		add(List.of(DUNGEON, HEXCRAWL, URBAN));
	}
}
