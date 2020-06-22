package minim.controller.table.adventurecrafter;

import minim.controller.table.Table;

public class Character extends Table {
	public Character() {
		super("Character");
	}

	@Override
	public void build() {
		add(1, "Choose most logical character");
		add(2, 4, "New Character");
	}
}
