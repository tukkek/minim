package minim.controller.table.adventure.dungeon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Motif extends Table {
	public static final Table SINGLETON = new Motif();

	static final Table MONSTROUS = new SimpleTable("Monstrous", List.of("Aberrant", "Giant", "Undead", "Vermin"));
	static final Table ENVIRONMENTS = new SimpleTable("Environments", List.of("Aquatic", "Desert", "Underdark"));
	static final Table ARCANA = new SimpleTable("Arcana", List.of("Arcane", "Fire", "Cold", "Abyssal", "Infernal"));
	static final Map<String, Table> MOTIFS = new HashMap<>(5);

	static {
		MOTIFS.put("None", null);
		MOTIFS.put("Abandoned", null);
		for (var m : List.of(MONSTROUS, ENVIRONMENTS, ARCANA))
			MOTIFS.put(m.title, m);
	}

	Motif() {
		super("Dungeon (motif)");
	}

	@Override
	public void build() {
		add(MOTIFS.keySet());
	}

	@Override
	public String roll() {
		var r = super.roll();
		var m = MOTIFS.get(r);
		r = m == null ? r : r + ", " + m.roll().toLowerCase();
		return r.toLowerCase();
	}
}
