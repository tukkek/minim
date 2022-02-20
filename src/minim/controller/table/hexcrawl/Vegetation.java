package minim.controller.table.hexcrawl;

import java.util.List;

import minim.controller.table.Table;

public class Vegetation extends Table {
	public static final String SPARSER = "Sparser";
	public static final String DENSER = "Denser";
	public static final Table NEXT = new Table("Vegetation (next)") {
		@Override
		public void build() {
			add(1, 4, DENSER);
			add(5, 8, "Same");
			add(9, 12, SPARSER);
		}
	};
	public static final Table SINGLETON = new Vegetation();

	Vegetation() {
		super("Vegeration");
	}

	@Override
	public void build() {
		add(List.of("Dense", "Forest", "Grassland", "Scrubland", "Barren"));
	}
}
