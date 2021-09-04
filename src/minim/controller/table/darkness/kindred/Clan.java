package minim.controller.table.darkness.kindred;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import minim.controller.table.Table;

public class Clan extends Table {
	public static final String ANTITRIBU = "antitribu";
	public static final Table CAMARILLA = new Table("Kindred (clan, camarilla)") {
		@Override
		public void build() {
			add(10, "Ventrue");
			add(10, "Toreador");
			add(8, "Tremere");
			add(9, "Nosferatu");
			add(7, "Malkavian");
			add(6, "Lasombra");
		}
	};
	public static final Table INDEPENDENT = new Table("Kindred (clan, independent)") {
		@Override
		public void build() {
			add(4, "Giovanni");
			add(3, "Ravnos");
		}
	};
	public static final Table SABBAT = new Table("Kindred (clan, sabbat)") {
		@Override
		public void build() {
			add(3, "Assamite");
			add(6, "Tzimisce");
			var antitribu = CAMARILLA.getunique();
			antitribu.addAll(INDEPENDENT.getunique());
			for (var a : antitribu)
				add(a + " " + ANTITRIBU);
		}
	};
	public static final Table ANARCH = new Table("Kindred (clan, anarch)") {
		@Override
		public void build() {
			add(20, "Brujah");
			add(8, "Gangrel");
			add(3, "Setites");
			add(3, "Caitiff");
			var others = CAMARILLA.getunique();
			others.addAll(INDEPENDENT.getunique());
			others.addAll(SABBAT.getunique());
			System.out.println(others.size());
			add(others.stream().filter(o -> !o.contains(ANTITRIBU)).map(o -> o + " anarch")
					.collect(Collectors.toList()));
		}
	};
	public static final Table URBAN = new Clan("Kindred (clan, urban)", 4, 2);
	public static final Table RURAL = new Clan("Kindred (clan, rural)", 2, 4);

	static final Map<String, Table> FACTIONS = new HashMap<>();

	static {
		for (var f : List.of(ANARCH, CAMARILLA, INDEPENDENT, SABBAT)) {
			FACTIONS.put(f.title, f);
		}
	}

	int camarilla;
	int sabbat;

	Clan(String title, int camarilla, int sabbat) {
		super(title);
		this.camarilla = camarilla;
		this.sabbat = sabbat;
	}

	@Override
	public void build() {
		add(3, ANARCH.title);
		add(camarilla, CAMARILLA.title);
		add(3, INDEPENDENT.title);
		add(sabbat, SABBAT.title);
	}

	@Override
	public String roll() {
		return FACTIONS.get(super.roll()).roll();
	}
}
