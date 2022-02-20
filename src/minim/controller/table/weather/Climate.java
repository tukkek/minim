package minim.controller.table.weather;

import minim.controller.table.Table;

public class Climate extends Table {
	public static final String DESERT = "Desert";
	public static final String SUMMER = "Permanent summer";
	public static final String SEASONS = "Four seasons";
	public static final String COLD = "Cold";
	public static final Climate SINGLETON = new Climate();

	Climate() {
		super("Climate");
	}

	@Override
	public void build() {
		add(1 * 2, COLD);
		add(2 * 2, SEASONS);
		add(1, SUMMER);
		add(1, DESERT);
	}
}
