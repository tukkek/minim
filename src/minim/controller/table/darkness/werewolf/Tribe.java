package minim.controller.table.darkness.werewolf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Tribe extends Table {
	public static final Table FORSAKEN = new SimpleTable("Werewolf (tribe, forsaken)",
			List.of("Blood talons", "Bone shadows", "Hunters in darkness", "Iron masters", "Storm lords"));
	public static final Table PURE = new SimpleTable("Werewolf (tribe, pure)",
			List.of("Fire-touched", "Ivory claws", "Predator kings"));
	public static final Table OTHER = new SimpleTable("Werewolf (tribe, other)",
			List.of("Ghost wolves", "Bale hounds"));
	public static final Tribe INSTANCE = new Tribe();

	static final Map<String, Table> TRIBES = new HashMap<>();

	static {
		for (var t : List.of(FORSAKEN, PURE, OTHER)) {
			TRIBES.put(t.title, t);
		}
	}

	Tribe() {
		super("Werewolf (tribe)");
	}

	@Override
	public void build() {
		add(2, FORSAKEN.title);
		add(3, PURE.title);
		add(1, OTHER.title);
	}

	@Override
	public String roll() {
		return TRIBES.get(super.roll()).roll();
	}
}
