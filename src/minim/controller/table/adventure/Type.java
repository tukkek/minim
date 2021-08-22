package minim.controller.table.adventure;

import java.util.List;

import minim.controller.table.Table;

public class Type extends Table {
	public Type() {
		super("Adventure type");
	}

	@Override
	public void build() {
		add(List.of("Dungeon", "Wilderness (hexcrawl)", "Urban"));
	}
}
