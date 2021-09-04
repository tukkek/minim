package minim.controller.table.darkness;

import minim.controller.table.Table;

public class Monster extends Table {
	public Monster() {
		super("Monster");
	}

	@Override
	public void build() {
		add(500, "Wraith");
		add(500, "Hunter");
		add(300, "Werewolf");
		add(300, "Changeling");
		add(200, "Beast");
		add(200, "Demon");
		add(100, "Vampire");
		add(50, "Hedge mage");
		add(30, "Mage");
		add(30, "Kue-jin");
		add(10, "Sin-eater");
		add(5, "Promethean");
		add(1, "Mummy");
	}
}
