package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable;
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
	public static final Table COMPACT = new SimpleTable("Hunter (organization, compact)",
			List.of("Ahl al-Jabal", "Ashwood Abbey", "The Bear Lodge", "Barrett Commission", "Division Six",
					"Habibti Ma", "The Hunt Club", "The Illuminated Brotherhood", "Keepers of the Source", "Long Night",
					"Loyalists of Thule", "Maiden's Blood Sisterhood", "Network Zero", "Night Watch", "Null Mysteriis",
					"The Promethean Brotherhood", "Talbot Group", "The Union", "Utopia Now"));
	public static final Table CONSPIRACY = new SimpleTable("Hunter (organization, conspiracy)",
			List.of("Aegis Kai Doru", "Ascending Ones", "The Cainite Heresy", "The Cheiron Group",
					"The Faithful of Shulpae", "Knights of Saint Adrian", "The Knights of Saint George", "Les Mystères",
					"Lucifuge", "Malleus Maleficarum", "Task Force: VALKYRIE", "Vanguard Serial Crimes Unit"));
	public static final Table ORGANIZATION = new MetaTable("Hunter (organization)") {
		@Override
		public void build() {
			add(1, CONSPIRACY);
			add(2, COMPACT);
			add(4, "Independent cell");
		}
	};

	public Hunter() {
		super("Hunter");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Creed", CREED);
		l.add("Organization", ORGANIZATION);
		return l.toString();
	}
}
