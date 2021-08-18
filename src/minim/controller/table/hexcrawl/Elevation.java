package minim.controller.table.hexcrawl;

import java.util.List;

import minim.controller.table.Table;

public class Elevation extends Table {
	public static final Table NEXT = new Table("Elevation (next)") {
		@Override
		public void build() {
			add(1, 4, "Higher");
			add(5, 8, "Same");
			add(9, 12, "Lower");
		}
	};
	public static final Table SINGLETON = new Elevation();

	Elevation() {
		super("Elevation");
	}

	@Override
	public void build() {
		add(List.of("Mountain", "Hill", "Plain", "Valley", "Lowland"));
	}
}
