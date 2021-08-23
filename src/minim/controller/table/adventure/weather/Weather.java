package minim.controller.table.adventure.weather;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public abstract class Weather extends Table {
	public static final Table SEASONS = new SimpleTable("Season (temperate)",
			List.of("Summer", "Auturmn", "Winter", "Spring"));

	protected String normal = "Normal";
	protected int normalodds = 70;
	protected String abnormal1 = "Abnormal";
	protected int abnormal1odds = 5;
	protected String abnormal2 = "Abnormal";
	protected int abnormal2odds = 5;
	protected String inclement = "Inclement";
	protected int inclementodds = 10;
	protected String storm = "Storm";
	protected int stormodds = 9;
	protected String hazard = "Powerful storm";
	protected int hazardodds = 1;

	protected Weather(String title) {
		super(title);
	}

	@Override
	public void build() {
		add(normalodds, normal);
		add(abnormal1odds, abnormal1);
		add(abnormal2odds, abnormal2);
		add(inclementodds, inclement);
		add(stormodds, storm);
		add(hazardodds, hazard);
	}
}
