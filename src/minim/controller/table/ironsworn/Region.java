package minim.controller.table.ironsworn;

import minim.controller.table.Table;

public class Region extends Table {
	public Region() {
		super("Region");
	}

	@Override
	public void build() {
		add(1, 12, "Islands");
		add(13, 24, "Coast");
		add(25, 34, "Forest");
		add(35, 46, "Marsh");
		add(47, 60, "Urban");
		add(61, 72, "Plains");
		add(73, 84, "Hills");
		add(85, 94, "Mountains");
		add(95, 99, "Desert/wasteland");
	}
}
