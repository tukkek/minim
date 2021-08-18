package minim.controller.table.hexcrawl;

import minim.controller.table.Table;

public class PointOfInterest extends Table {
	public static final String NONE = "None";
	public static final Table TYPES = new Table("Point of interest (types)") {
		@Override
		public void build() {
			add(1, 3, "Ruins");
			add(4, 6, "Cave");
			add(7, 9, "Natural formation");
			add(10, 10, "Monster lair");
			add(11, 11, "NPC lair");
			add(12, 14, "Campsite");
			add(15, 16, "Settlement");
			add(17, 17, "Magic");
			add(18, 20, "Unusual terrain");
		}
	};
	public static final Table SINGLETON = new PointOfInterest();

	PointOfInterest() {
		super("Point of interest");
	}

	@Override
	public void build() {
		add(1, 14, NONE);
		add(15, 19, "Minor");
		add(20, 20, "Major");
	}
}
