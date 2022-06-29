package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Beast extends Table {
	public static final Table INSTANCE = new Beast();
	public static final Table FAMILIES = new SimpleTable("Beast (family)", List.of("Anakim, giants", "Eshmaki, lurkers",
			"Inguma, outsiders", "Makara, leviathans", "Namtaru, gorgoms", "Talassii, captors", "Ugallu, raptors"));
	public static final Table HUNGER = new SimpleTable("Beast (hunger)",
			List.of("Predator (prey)", "Tyrant (power)", "Nemesies (punishment)", "Ravager (ruin)",
					"Collectors (hoard)", "Whispers (secrets)", "Enablers (transgression)"));

	Beast() {
		super("Beast");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Family", FAMILIES);
		l.add("Hunger", HUNGER);
		return l.toString();
	}
}
