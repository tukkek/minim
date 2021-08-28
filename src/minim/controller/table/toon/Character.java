package minim.controller.table.toon;

import minim.controller.table.Table;

public class Character extends Table {
	public static final Character SINGLETON = new Character();

	Character() {
		super("Character");
	}

	@Override
	public void build() {
		add("themselves");
		add("daughter");
		add("son");
		add("Professor");
		add("Granny");
		add("boss");
	}
}
