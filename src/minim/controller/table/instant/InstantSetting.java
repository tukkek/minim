package minim.controller.table.instant;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class InstantSetting extends Table {
	static final public Table TONE = new SimpleTable("Instant setting (tone)",
			List.of("Action/Adventure", "B-movie", "Campy", "Conspiracy", "Despair", "Epic", "Fantasy", "Gothic",
					"Heroic", "Horror", "Intrigue", "Mystery", "Mythic", "Parable/Moralistic", "Pulp", "Realistic",
					"Romance", "Suspense", "Swashbuckling", "Tactical"));
	static final public Table PLACE = new SimpleTable("Instant setting (place)", List.of("Afterlife", "Amusement Park",
			"Arcade", "Armory", "Auction", "Auditorium", "Bank", "Barracks", "Bathhouse", "Beach", "Bordello", "Bridge",
			"Burrow", "Business Office", "Camping Out", "Carnival", "Castle", "Cave", "Charitable Shelter", "Church",
			"Control Room", "Correctional System", "Crash Site", "Crater", "Crossroads", "Dam", "Docks", "Dormitory",
			"Dungeon", "Farm", "Festival", "Forest", "Foundry", "Frontier", "Government Office", "Graveyard",
			"Headquarters", "Home", "Hospital", "Hotel", "Hovel", "Institution", "Island", "Junkyard", "Lair",
			"Landmark", "Law Enforcement Office", "Library", "Limbo", "Locked Out", "Lost/Stranded", "Magic Shop",
			"Mansion", "Marketplace", "Maze", "Military Installation", "Moon", "Morgue", "Mountain", "Neutral Ground",
			"News Office", "Nightclub/Rave", "Oasis", "Orphanage", "Outpost", "Park", "Parking Lot",
			"Port/Transport Hub", "Public Forum", "Refuse Dump", "Resort/Spa", "Restaurant", "Restroom", "River",
			"Road", "Rooftop", "Ruins", "Safehouse", "School", "Sewer", "Ship", "Space", "Stadium", "Stage", "Store",
			"Stronghold", "Suburb", "Suburban Retail Center", "Tavern", "Theatre", "Tower", "Town Square",
			"Underground", "Underwater", "Vehicle", "Volcano", "Warehouse", "Wilderness", "Wildlife Preserve", "Zoo"));
	static final public Table POPULATION = new SimpleTable("Instant setting (population)", List.of("<20", "100", "600",
			"3,000", "15,000", "80,000", "400,000", "2,000,000", "10,000,000", ">10,000,000"));
	static final public Table TECH = new SimpleTable("Instant setting (tech)",
			List.of("Agriculture", "Alchemy", "Alien Supertech", "Artificial Intelligence", "Automobiles", "Bronze",
					"Computers", "Contemporary", "Cybertech", "Domesticated Animals", "Early Space Exploration",
					"Electricity", "Electronics", "Flight", "Fossil Fuels", "Frankentech", "FTL Travel",
					"Galactic Empires", "Genetic Engineering", "High Magic", "Hydro-power", "Industrial Revolution",
					"Information Age", "Iron", "Lighter Than Air Travel", "Lost Technology", "Low Magic", "Macrotech",
					"Magitech", "Nanotech", "Near Future", "No Tech", "Nuclear Power", "Ocean Going Ships",
					"Post-Apocalyptic", "Printing Press", "Psychic Abilities", "Renaissance", "Robots/Automatons",
					"Rube Goldberg", "Scientific Method", "Solar Energy", "Space Colonies", "Steam Power", "Steampunk",
					"Stone Age", "Teleportation", "Time Travel", "Virtual Reality", "Wheel"));
	public static final InstantSetting SINGLETON = new InstantSetting();

	InstantSetting() {
		super("Instant setting");
	}

	@Override
	public void build() {
		add(List.of("Alien Occupied Earth", "All Supers World", "Alternate History", "Ancient Egypt", "Ape World",
				"Arabian Nights", "Archaic/Biblical", "Arkship", "Artificial World", "Atlantis", "Barbarian Europe",
				"Bizarro World", "Boston, 1770s", "Camping Out", "City Under Siege",
				"Classical (Greek/Roman/Peloponnesian)", "Cloud City", "Cold War", "Contemporary",
				"Correctional System", "Cyberpunk", "Darkworld", "Dawn of civilization", "Depopulated Earth",
				"Desert Planet", "Dreamworld", "Dungeon", "Dying World", "Dystopia", "Early Space Exploration",
				"Elizabethan England", "Fallen Civilization", "Farm", "Festival", "First Alien Contact", "Forest",
				"French Revolution", "Frontier", "Frozen Wasteland", "Future Earth", "Galactic Empires",
				"Golden Age of Comics", "Grimm’s Fairy Tales", "Historical", "Industrial Revolution",
				"Institution/Institutionalized", "Isolated Space Probe", "Jungle World", "Limbo", "London",
				"Lost Civilization", "Lost/Stranded", "Mars", "Mechanized Planet", "Medieval", "Microworld",
				"Military Installation", "Modern Day Las Vegas", "Modern-Day Amusement Park", "Modern-Day Milwaukee",
				"Moon", "Mystical Orient", "Near Future", "Near Future World Government HQ", "Neverland/Childworld",
				"Orwellian Future", "Outpost", "Post-Apocalyptic", "Pre-European Americas", "Psychic Near-Future",
				"Realm of the Gods", "Remote Future", "Renaissance", "Resort/Spa", "School of Magic", "Sea Adventures",
				"Skyscraper", "Snowed-In Town", "Space Colony", "Steampunk", "Stone Age", "Suburban Retail Center",
				"Sword & Sorcery", "Tiny People", "Tokyo/Near-Future", "Traveling Circus", "Tree-top Civilization",
				"Tropical Paradise", "Underground", "Underwater", "Viking explorers", "Virtual Reality", "War",
				"Wild West", "Wilderness", "Wildlife Preserve", "WWI", "WWII", "WWIII", "Your Place"));
	}

	@Override
	public String roll() {
		var setting = super.roll();
		setting += "\nTone: " + TONE.roll();
		for (var i = 0; i < 2; i++)
			setting += "\nThing: " + Thing.SINGLETON.roll();
		if (Character.roll(6) == 1)
			setting += "\nPlace: " + PLACE.roll();
		if (Character.roll(6) == 1)
			setting += "\nPopulation: " + POPULATION.roll();
		if (Character.roll(6) == 1)
			setting += "\nTech: " + TECH.roll();
		return setting;
	}
}
