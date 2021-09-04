package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Kuejin extends Table {
	public static final Table INSTANCE = new Kuejin();
	public static final Table ORTHODOX = new SimpleTable("Kue-jin (dharma, orthodox)",
			List.of("Devil-tiger", "Song of shadow", "Resplendent crane", "Thrashing dragon", "Thousand whispers"));
	public static final Table HERETICAL = new SimpleTable("Kue-jin (dharma, heretical)",
			List.of("Spirit of the living earth", "Face of the gods", "Flame of the rising phoenix",
					"Tempest of inward focus"));
	public static final Table DHARMA = new MetaTable("Kue-jin (dharma)") {
		@Override
		public void build() {
			add(1, "Scorpion eater");
			add(2, HERETICAL);
			add(4, ORTHODOX);
		}
	};
	public static final Table CHI = new Table("Kue-jin (chi)") {
		@Override
		public void build() {
			add(2, "Yin (black)");
			add(2, "Yang (scarlet)");
			add(1, "P'o (demon)");
		}
	};

	Kuejin() {
		super("Kue-jin");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Dharma", DHARMA);
		l.add("Chi", CHI);
		return l.toString();
	}

}
