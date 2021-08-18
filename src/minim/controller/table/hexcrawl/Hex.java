package minim.controller.table.hexcrawl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import minim.controller.table.Table;

public class Hex extends Table {
	public static final Table NEXT = new Table("Hex (next)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			return Hex.roll(List.of(Elevation.NEXT, Vegetation.NEXT, Water.NEXT, PointOfInterest.SINGLETON));
		}
	};
	static final List<String> CHARACTERISTICS = List.of("Elevation", "Vegetation", "Water", "Point of interest");

	public Hex() {
		super("Hex");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return roll(List.of(Elevation.SINGLETON, Vegetation.SINGLETON, Water.SINGLETON, PointOfInterest.SINGLETON));
	}

	static String roll(List<Table> tables) {
		var rolls = new LinkedList<>(tables.stream().map(t -> t.roll()).collect(Collectors.toList()));
		if (rolls.getLast() == PointOfInterest.NONE) {
			rolls.removeLast();
		} else {
			var poi = rolls.removeLast();
			rolls.add("%s (%s)".formatted(poi, PointOfInterest.TYPES.roll()));
		}
		var r = "";
		for (var i = 0; i < rolls.size(); i++) {
			r += "%s: %s.\n".formatted(CHARACTERISTICS.get(i), rolls.get(i).toLowerCase());
		}
		return r.substring(0, r.length() - 2);
	}
}
