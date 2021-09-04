package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Hunter extends Table {
	public static final Table MERCY = new SimpleTable("Hunter (creed, mercy)",
			List.of("Innocents", "Martyrs", "Redeemers"));
	public static final Table VISION = new SimpleTable("Hunter (creed, vision)",
			List.of("Hermits", "Visionaries", "Waywards"));
	public static final Table ZEAL = new SimpleTable("Hunter (creed, zeal)",
			List.of("Avengers", "Defenders", "Judges"));
	public static final Table CREED = new SimpleMetaTable("Hunter (creed)", List.of(MERCY, VISION, ZEAL));

	public Hunter() {
		super("Hunter");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return CREED.roll();
	}
}
