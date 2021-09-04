package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Demon extends Table {
	public static final Table INSTANCE = new Demon();
	public static final Table HOUSE = new SimpleTable("Demon (houses)",
			List.of("Devils", "Scourges", "Malefactors", "Fiends", "Defilers", "Devourers", "Slayers"));
	public static final Table FACTION = new SimpleTable("Demon (factions)",
			List.of("Faustian", "Cryptics", "Luciferans", "Raveners", "Reconcilers"));

	Demon() {
		super("Demon");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("House", HOUSE);
		l.add("Faction", FACTION);
		return l.toString();
	}
}
