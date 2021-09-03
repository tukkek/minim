package minim.controller.table.chronicles.kindred;

import minim.controller.table.Table;

public class Generation extends Table {
	public static final Table INSTANCE = new Generation();

	Generation() {
		super("Kindred (generation)");
	}

	@Override
	public void build() {
		add(3, "4th");
		add(6, "5th");
		add(10, "6th");
		add(20, "7th");
		add(20, "8th");
		add(20, "9th");
		add(9, "10th");
		add(4, "11th");
		add(5, "12th");
		add(4, "13th");
		add(1, "14th");
	}
}
