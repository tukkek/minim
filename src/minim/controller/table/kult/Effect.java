package minim.controller.table.kult;

import minim.controller.table.Table;

public class Effect extends Table {
	public static final Effect INSTANCE = new Effect();

	Effect() {
		super("Effect");
	}

	@Override
	public void build() {
		add("Bad");
		add(1, 5, "Acceptable");
		add(6, 15, "Normal");
		add(16, 20, "Good");
		add(21, 25, "very good");
		add(26, 29, "Exceptionally good");
		add(30, 30, "Impossibly good!");
	}
}
