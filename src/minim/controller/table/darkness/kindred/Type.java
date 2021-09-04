package minim.controller.table.darkness.kindred;

import minim.controller.table.Table;

public class Type extends Table {
	public static final Table INSTANCE = new Type();

	Type() {
		super("Kindred (type)");
	}

	@Override
	public void build() {
		add(7, "Vampire");
		add(2, "Ghoul");
		add(1, "Revenant");
	}
}
