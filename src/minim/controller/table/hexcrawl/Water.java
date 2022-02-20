package minim.controller.table.hexcrawl;

import java.util.List;

import minim.controller.table.Table;

public class Water extends Table {
	public static final String DRY = "Dry";
	public static final String DRYER = "Dryer";
	public static final String WETTER = "Wetter";
	public static final Table NEXT = new Table("Water (next)") {
		@Override
		public void build() {
			add(1, 2, WETTER);
			add(5, 8, "Same");
			add(9, 12, DRYER);
		}
	};
	public static final Table SINGLETON = new Water();

	Water() {
		super("Water");
	}

	@Override
	public void build() {
		add(List.of("Sea", "Lake", "River", DRY));
	}
}
