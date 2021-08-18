package minim.controller.table.hexcrawl;

import java.util.List;

import minim.controller.table.Table;

public class Water extends Table {
	public static final Table NEXT = new Table("Water (next)") {
		@Override
		public void build() {
			add(1, 2, "Wetter");
			add(5, 8, "Same");
			add(9, 12, "Dryer");
		}
	};
	public static final Table SINGLETON = new Water();

	Water() {
		super("Water");
	}

	@Override
	public void build() {
		add(List.of("Sea", "Lake", "River", "Dry"));
	}
}
