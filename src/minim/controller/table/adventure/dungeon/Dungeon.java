package minim.controller.table.adventure.dungeon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import minim.controller.table.Table;
import minim.controller.table.adventure.dungeon.lore.Backstory;
import minim.controller.table.adventure.dungeon.lore.Information;
import minim.controller.table.adventure.dungeon.lore.Occupant;
import minim.controller.table.adventure.dungeon.lore.Purpose;
import minim.model.Character;

public class Dungeon extends Table {
	public static final Dungeon SINGLETON = new Dungeon();

	static final LinkedHashMap<String, Table> CHARACTERISTICS = new LinkedHashMap<>(3);
	static final String FORMAT = "  %s: %s.";

	static {
		CHARACTERISTICS.put("Location", Location.SINGLETON);
		CHARACTERISTICS.put("Motif", Motif.SINGLETON);
		CHARACTERISTICS.put("Map", Map.SINGLETON);
		CHARACTERISTICS.put("Grid", Grid.SINGLETON);
		CHARACTERISTICS.put("Backstory", Backstory.SINGLETON);
		CHARACTERISTICS.put("Original purpose", Purpose.SINGLETON);
		CHARACTERISTICS.put("Original occupant", Occupant.SINGLETON);
	}

	Dungeon() {
		super("Dungeon");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var c = CHARACTERISTICS.keySet().stream()
				.map(t -> FORMAT.formatted(t, CHARACTERISTICS.get(t).roll().toLowerCase()))
				.collect(Collectors.toCollection(() -> new ArrayList<>()));
		if (Character.roll(10) == 1) {
			c.add(FORMAT.formatted("Current purpose", Purpose.SINGLETON.roll()));
			c.add(FORMAT.formatted("Current occupant", Occupant.SINGLETON.roll()));
		}
		var information = Character.roll(4);
		for (var i = 0; i < information; i++)
			c.add(FORMAT.formatted("Information", Information.SINGLETON.roll().toLowerCase()));
		return String.join("\n", c);
	}
}
