package minim.controller.table.une;

import minim.controller.table.Table;

public class PowerLevel extends Table {
	public static final PowerLevel SINGLETON = new PowerLevel();

	PowerLevel() {
		super("NPC power level");
	}

	@Override
	public void build() {
		add(1, 5, "much weaker");
		add(6, 20, "weaker");
		add(21, 80, "comparable");
		add(81, 95, "stronger");
		add(96, 100, "much stronger");
	}
}
