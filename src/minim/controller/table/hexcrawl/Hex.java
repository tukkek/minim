package minim.controller.table.hexcrawl;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.Table;

public class Hex extends Table {
	public static final Hex SINGLETON = new Hex();
	public static final Table NEXT = new SimpleMetaTable("Hex (next)",
			List.of(Elevation.NEXT, Vegetation.NEXT, Water.NEXT, PointOfInterest.SINGLETON));
	static final List<String> CHARACTERISTICS = List.of("Elevation", "Vegetation", "Water", "Point of interest");

	public static class Hexagon {
		String feature = PointOfInterest.SINGLETON.roll();
		String elevation;
		String vegetation;
		String water;

		protected Hexagon(String elevationp, String vegetationp, String waterp) {
			elevation = elevationp;
			vegetation = vegetationp;
			water = waterp;
			if (interest()) {
				feature = PointOfInterest.TYPES.roll();
			}
		}

		public Hexagon() {
			this(Elevation.SINGLETON.roll(), Vegetation.SINGLETON.roll(), Water.SINGLETON.roll());
		}

		public boolean interest() {
			return feature != PointOfInterest.NONE;
		}

		@Override
		public String toString() {
			var s = vegetation + " " + elevation.toLowerCase();
			if (water != Water.DRY)
				s += " by " + water.toLowerCase();
			if (interest())
				s += " (point of interest: " + feature.toLowerCase() + ")";
			return s;
		}

		static String next(String current, Table t, Table next, String lower, String higher) {
			var nexte = next.roll();
			var l = t.lines;
			var i = l.indexOf(current);
			if (nexte == higher && i > 0) {
				i -= 1;
			} else if (nexte == lower && i < l.size() - 1) {
				i += 1;
			}
			return l.get(i);
		}

		public Hexagon next() {
			var e = next(elevation, Elevation.SINGLETON, Elevation.NEXT, Elevation.LOWER, Elevation.HIGHER);
			var v = next(vegetation, Vegetation.SINGLETON, Vegetation.NEXT, Vegetation.SPARSER, Vegetation.DENSER);
			var w = next(water, Water.SINGLETON, Water.NEXT, Water.WETTER, Water.DRYER);
			return new Hexagon(e, v, w);
		}
	}

	Hex() {
		super("Hex");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
//		return roll(List.of(Elevation.SINGLETON, Vegetation.SINGLETON, Water.SINGLETON, PointOfInterest.SINGLETON));
		return new Hexagon().toString();
	}

//	static String roll(List<Table> tables) {
//		var rolls = new LinkedList<>(tables.stream().map(t -> t.roll()).collect(Collectors.toList()));
//		if (rolls.getLast() == PointOfInterest.NONE) {
//			rolls.removeLast();
//		} else {
//			var poi = rolls.removeLast();
//			rolls.add("%s (%s)".formatted(poi, PointOfInterest.TYPES.roll()));
//		}
//		var r = "";
//		for (var i = 0; i < rolls.size(); i++) {
//			r += "%s: %s.\n".formatted(CHARACTERISTICS.get(i), rolls.get(i).toLowerCase());
//		}
//		return r.substring(0, r.length() - 2);
//	}
}
