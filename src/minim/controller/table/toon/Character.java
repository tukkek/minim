package minim.controller.table.toon;

import minim.controller.table.Table;

public class Character extends Table {
	public static final Character SINGLETON = new Character();

	Character() {
		super("Character");
	}

	@Override
	public void build() {
		add(1, "themselves");
		add(2, "daughter");
		add(3, "son");
		add(4, "Professor");
		add(5, "Granny");
		add(6, "boss");
	}
}
