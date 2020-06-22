package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.Table;

public class WaterLocation extends Table {
	public WaterLocation() {
		super("Water location");
	}

	@Override
	public void build() {
		add(List.of("Fleet", "Sargussum", "Floatsam", "Mystical site", "Lair", "Anomaly"));
		add(6, 10, "Wreck");
		add(11, 15, "Harbor");
		add(16, 23, "Ship");
		add(24, 30, "Rocks");
		add(31, 38, "Fjord");
		add(39, 46, "Estuary");
		add(47, 54, "Cove");
		add(55, 62, "Bay");
		add(63, 70, "Ice");
		add(71, 85, "Island");
		add(86, 92, "Open water");
		add(93, 99, "Submerged");
	}
}
