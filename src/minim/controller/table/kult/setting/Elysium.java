package minim.controller.table.kult.setting;

import minim.controller.table.Table;

public class Elysium extends Table {
	public static final Elysium INSTANCE = new Elysium();

	Elysium() {
		super("Elysium");
	}

	@Override
	public void build() {
		// TODO Auto-generated method stub
		add("An empty paradise");
	}
}
