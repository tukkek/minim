package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Bound extends Table {
	public static final Table BURDEN = new SimpleTable("Bound (burden)",
			List.of("Abiding", "Bereaved", "Hungry", "Kindly", "Vengeful"));
	public static final Table HAUNT = new SimpleTable("Bound (haunt)", List.of("Boneyard", "Caul", "Curse", "Dirge",
			"Marionette", "Memoria", "Oracle", "Pit", "Rage", "Shroud", "Tomb", "Void", "Well"));
	public static final Table KEY = new SimpleTable("Bound (key)", List.of("Beasts", "Blood", "Chance", "Cold wind",
			"Deep waters", "Disease", "Grave dirt", "Pyre flame", "Stillness"));

	public Bound() {
		super("Bound");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Burden", BURDEN);
		l.add("Haunt", HAUNT);
		l.add("Key", KEY);
		return l.toString();
	}
}
