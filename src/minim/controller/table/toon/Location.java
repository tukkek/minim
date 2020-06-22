package minim.controller.table.toon;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Location extends Table {
	public static final Location SINGLETON = new Location();
	public static final Table ANYTOWN = new SimpleTable("Location (Anytown)",
			List.of("Jail", "Bank", "General store", "Bakery", "library", "costume shop", "grocery store", "city hall",
					"hotel", "restaurant", "doctor's office", "pet store", "stable", "barber shop", "railroad station",
					"bar", "gas station", "blacksmith", "school", "post office", "dentist's office", "diner",
					"pool hall", "park", "gold course", "construction site", "opera house", "football stadium",
					"baseball park", "museum", "zoo", "scientist's laboratory", "mad scientist's laboratory",
					"thug's hideout", "ace mail-order company warehouse", "$")) {
		@Override
		public String roll() {
			String result = super.roll();
			if (result == "$")
				return OUTSIDEOFTOWN.roll();
			return result;
		}
	};
	public static final Table THECITY = new SimpleTable("Location (The city)",
			List.of("construction site", "subway station", "subway tunnel", "sewer", "rush-hour traffic jam",
					"sumphony hall", "opera house", "department store", "grocery store", "bakery", "bank", "city hall",
					"restaurant", "jewelry store", "warehouse", "gas station", "laundromat", "museum", "record store",
					"bar", "post office", "hospital", "sporting goods store", "hardware store", "car dealer", "hotel",
					"skyscraper", "beauty parlor", "florist", "zoo", "robot factory", "bookstore", "dentist's office",
					"bowling alley", "television station"));
	public static final Table OUTERSPACE = new SimpleTable("Location (Outer space)",
			List.of("moon", "mars", "planet eclair", "planer prune", "saturn's rings", "milky way",
					"space station zero", "edge of the universe", "black hole", "anti-matter universe",
					"galactic dust cloud", "planet of deadly ducks", "outer-space hardware store",
					"outer-space carnival", "outer-space zoo", "orbital robot factory", "green martian convention",
					"living, intelligent planet", "spaceport", "tiny spaceship", "huge spaceship", "haunted spaceship",
					"asteroid field", "sun", "meteor shower", "time warp", "martian slave world",
					"light-gravity planet", "heavy-gravity planet", "swamps of venus", "planet of giant everything",
					"planet of teeny-tiny things", "anti-matter universe", "gas cloud", "lightning gas cloud",
					"black hole", "non-green martian convention"));
	public static final Table OUTSIDEOFTOWN = new SimpleTable("Location (Outside of town)",
			List.of("The stone age", "Arthurian england", "Rocket base", "Farm", "Haunted house", "Atlantis",
					"Ali Baba's cave", "desert south sea island (with cannibals)", "sherwood forest", "transylvania",
					"darkest africa", "lighest africa", "sahara desert", "oil well", "indian reservation", "airport",
					"railroad station", "blacksmith", "middle of the ocean", "north pole", "asia", "movie studio",
					"pirate cove", "pirate ship", "cave", "old west", "diamond mine", "ranch", "insane asylum",
					"army base", "bridge", "center of the earth", "hell", "national park", "fort", "alpha complex",
					"tv station", "real world"));

	Location() {
		super("Location");
	}

	@Override
	public void build() {
		add(1, 2, ANYTOWN.title);
		add(2, 4, THECITY.title);
		add(5, OUTERSPACE.title);
		add(5, OUTSIDEOFTOWN.title);
	}

	@Override
	public String roll() {
		var table = super.roll();
		if (table == ANYTOWN.title)
			return ANYTOWN.roll();
		;
		if (table == THECITY.title)
			return THECITY.roll();
		;
		if (table == OUTERSPACE.title)
			return OUTERSPACE.roll();
		;
		return OUTSIDEOFTOWN.roll();
	}
}
