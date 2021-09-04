package minim.controller.table.chronicles;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Wraith extends Table {
	public static final Table LEGIONS = new SimpleTable("Wraith (faction, hierarchy legions)",
			List.of("Emerald legion", "Legion of fate", "Grim legion", "Iron legion", "Legion of paupers",
					"Penitent legion", "Silent legion", "Skeletal legion"));
	public static final Table HERETICS = new SimpleTable("Wraith (faction, heretics)",
			List.of("The host", "Children of the green", "Riders of the wheel"));
	public static final Table RENEGADES = new SimpleTable("Wraith (faction, renegades)",
			List.of("Protesters", "Idealists", "Outlaws", "Drop-outs"));
	public static final Table FACTIONS = new MetaTable("Wraith (faction)", List.of(LEGIONS, HERETICS, RENEGADES)) {
		@Override
		public void build() {
			add(2, LEGIONS);
			add(1, HERETICS);
			add(1, RENEGADES);
			add(1, "Ferrymen");
		}
	};
	public static final Table GUILDS = new SimpleTable("Wraith (guilds)",
			List.of("Alchemists", "Artificers", "Chanteur", "Harbingers", "Haunters", "Masquers", "Mnemoi", "Monitors",
					"Oracles", "Pardoners", "Proctors", "Sandmen", "Solicitors", "Sppoks", "Usurers"));

	public Wraith() {
		super("Wraith");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Faction", FACTIONS);
		l.add("Guild", GUILDS);
		return l.toString();
	}
}
