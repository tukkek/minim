package minim.controller.table.adventure.weather;

import minim.controller.table.Table;

public class Type extends Table {
	public Type() {
		super("Type");
	}

	@Override
	public void build() {
		add(1 * 2, "Cold");
		add(2 * 2, "Four seasons");
		add(1, "Permanent summer");
		add(1, "Desert");
	}
}
