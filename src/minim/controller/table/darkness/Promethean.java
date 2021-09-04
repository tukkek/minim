package minim.controller.table.darkness;

import java.util.HashMap;
import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Promethean extends Table {
	public static class Athanor {
		public static final Table FRANKENSTEIN = new SimpleTable("Promethean (athanor, frankenstein)",
				List.of("Basilisk", "Caladrius", "Griffon", "Lion", "Manticore"));
		public static final Table GALATEA = new SimpleTable("Promethean (athanor, galatea)",
				List.of("Dove", "Gorgon", "Seraph", "Swan", "Unicorn"));
		public static final Table OSIRIS = new SimpleTable("Promethean (athanor, osiris)",
				List.of("Ant", "Dragon", "Eagle", "Eel", "Honeybee", "Owl", "Sphinx"));
		public static final Table TAMMUZ = new SimpleTable("Promethean (athanor, tammuz)",
				List.of("Cerberus", "Crab", "Humbaba", "Pelican", "Phoenix"));
		public static final Table ULGAN = new SimpleTable("Promethean (athanor, ulgan)",
				List.of("Chimera", "Crane", "Dragon", "Fox", "La llorona", "Raven", "Salamander", "Toad"));
	}

	public static final Table INSTANCE = new Promethean();
	private static final String FRANKENSTEIN = "Frankenstein";
	private static final String GALATEA = "Galatea";
	private static final String OSIRIS = "Osiris";
	private static final String TAMMUZ = "Tammuz";
	private static final String ULGAN = "Ulgan";
	public static final Table LINEAGE = new SimpleTable("Promethean (lineage)",
			List.of(FRANKENSTEIN, GALATEA, OSIRIS, TAMMUZ, ULGAN));
	public static final String AES = "Aes (aid)";
	public static final String ARGENTUM = "Argentum (mystery)";
	public static final String COBALUS = "Cobalus (impurity)";
	public static final String MERCURIUS = "Mercurius (pyros)";
	public static final String PHOSPORUM = "Phosporum (ephemerality)";
	public static final String CENTIMANTI = "Centimanti (flux)";
	public static final Table REFINEMENT = new Table("Promethean (simple refinement)") {
		@Override
		public void build() {
			for (var r : List.of("Aurum (mortality)", "Coprum (self)", "Ferrum (corpus)", "Plumbum (Source)",
					"Stannum (torment)"))
				add(100, r);
			for (var r : List.of(AES, ARGENTUM, COBALUS, MERCURIUS, PHOSPORUM))
				add(10, r);
			add(1, CENTIMANTI);
		}
	};
	public static final Table TRANSMUTATION = new SimpleTable("Promethean (transmutations)",
			List.of("Consortium", "Corporeum", "Deception", "Disquietism", "Electrification", "Mesmerism",
					"Metamorphosis", "Saturminus", "Sensorium", "Vitality", "Vulcanus"));

	static final HashMap<String, String> COMPLEX = new HashMap<>();
	static final HashMap<String, Table> ATHANOR = new HashMap<>();
	static final HashMap<String, String> DISQUIET = new HashMap<>();

	static {
		COMPLEX.put(AES, "Benefice");
		COMPLEX.put(ARGENTUM, "Spiritus");
		COMPLEX.put(COBALUS, "Contamination");
		COMPLEX.put(MERCURIUS, "Alchemicus");
		COMPLEX.put(PHOSPORUM, "Luciferius");
		COMPLEX.put(CENTIMANTI, "Flux");
		ATHANOR.put(FRANKENSTEIN, Athanor.FRANKENSTEIN);
		ATHANOR.put(GALATEA, Athanor.GALATEA);
		ATHANOR.put(OSIRIS, Athanor.OSIRIS);
		ATHANOR.put(TAMMUZ, Athanor.TAMMUZ);
		ATHANOR.put(ULGAN, Athanor.ULGAN);
		DISQUIET.put(FRANKENSTEIN, "makes them the scapegoat of the Disquieted");
		DISQUIET.put(GALATEA, "mix of of revulsion and lustful obsession");
		DISQUIET.put(OSIRIS, "sparks an obsessive curiousity about the Promethean.");
		DISQUIET.put(TAMMUZ, "disrupts communication between the Promethean and the Disquieted");
		DISQUIET.put(ULGAN, "causes intense paranoia");
	}

	Promethean() {
		super("Promethean");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		var lineage = l.add("Lineage", LINEAGE);
		var r = l.add("Refinement", REFINEMENT);
		var t = COMPLEX.get(r);
		if (t == null)
			t = TRANSMUTATION.roll();
		else
			t += " (complex)";
		l.add("Transmutation", t.toLowerCase());
		l.add("Athanor", ATHANOR.get(lineage));
		l.add("Disquiet", DISQUIET.get(lineage));
		return l.toString();
	}
}
