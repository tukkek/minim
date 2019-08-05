package minim.controller.table.instant;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Trait extends Table {
	public static final Table RANKS = new Table("Trait (ranks)") {
		@Override
		public void build() {
			add(1, "Super");
			add(1, 2, "Exceptional");
			add(1, 4, "Advanced");
			add(1, 8, "Basic");
			add(1, 16, "Average");
		}
	};
	public static final Table SKILL = new SimpleTable("Trait (skill)", List.of("Accounting", "Carpenter", "Firearms",
			"Literacy", "Rituals", "Acrobatics", "Chemistry", "First Aid", "Literature", "Running", "Acting",
			"Climbing", "Fishing", "Locate Traps", "Salesmanship", "Aeronautics", "Commune with Spirits", "Fisticuffs",
			"Lockpicking", "Sculpting", "Alchemy", "Composition", "Flattery", "Lying", "Seamanship", "Alien Culture",
			"Computer Build/Repair", "Flirting", "Magic Lore", "Seduction", "Anatomy", "Computer Programming",
			"Folklore", "Marketing", "Servant", "Animal Calls", "Computer Use", "Forage", "Masonry", "Shield",
			"Animal Care", "Con", "Forensics", "Mathematics", "Shiphandling", "Animal Training", "Cooking", "Forgery",
			"Mechanic", "Shopkeeping", "Antidotes", "Cosmetology", "Fortune Telling", "Medicine", "Singing", "Appraise",
			"Costuming", "Gambling", "Meditation", "Sleight of Hand", "Arcane Lore", "Courtly Ways", "Game Playing",
			"Move Quietly", "Smith", "Archery", "Criminology", "Geography", "Musical Instruments", "Sociology",
			"Armory", "Cryptography", "Ghost Tracking", "Nature Lore", "Spell Casting", "Astrogation", "Culinary Arts",
			"Gunnery", "Navigation", "Starship Repair", "Astrology", "Current Events", "Heraldry", "Negotiation",
			"Stealth", "Astronomy", "Dance", "Herbology", "Nursing", "Storytelling", "Avoid Traps", "Demolitions",
			"Herding", "Occultism", "Streetwise", "Balance", "Detect Lies", "History", "Oratory", "Surgery", "Barter",
			"Diplomacy", "Hunting", "Painting", "Survival", "Basket Making", "Disguise", "Infiltrate", "Pantomime",
			"Swimming", "Bee-keeping", "Doctoring", "Innkeeping", "Persuade", "Tactics", "Begging", "Dodge",
			"Interrogate", "Photography", "Tailor", "Biology", "Drawing", "Interviewing", "Physics", "Tall Tales",
			"Blacksmith", "Driving", "Intimidate", "Pick Locks", "Teamster", "Bladed Weapons", "Drug Knowledge",
			"Juggling", "Pickpocketing", "Theology", "Bluff", "Economics", "Jumping", "Piloting", "Throwing", "Boating",
			"Electronics", "Knots", "Poisoning", "Tracking", "Boost Morale", "Engineer", "Languages", "Pottery",
			"Ventriloquism", "Boot-licking", "Escape Artist", "Law", "Prostitution", "Veterinarian", "Bowyer/Fletcher",
			"Etiquette", "Law Enforcement", "Psychology", "Vintner", "Breaking & Entering", "Falconry",
			"Leatherworking", "Quick-Draw", "Weaving", "Bribery", "Farming", "Levitate", "Religion", "Witty Insults",
			"Bureaucracy", "Fast-Talk", "Library Skills", "Research", "Wrestling", "Camouflage", "Fight",
			"Listening deeply", "Riding", "Zero-G Maneuvering"));

	public static final Table ATTRIBUTE = new SimpleTable("Trait (attribute)",
			List.of("agility", "aim", "appearance", "beauty", "constitution", "damage capacity", "drive", "ego",
					"empathy", "endurance", "health", "intuition", "magical aptitude", "mechanicalaptitude", "memory",
					"power", "presence", "psi-strength", "psyche", "quickness", "reasoning", "sanity", "speed",
					"spirituality", "strength", "willpower", "wisdom", "wit"));
	public static final Table OTHER = new SimpleTable("Trait (others)",
			List.of("Contacts", "Wealth", "Affiliations", "Reputation"));
	public static final Trait SINGLETON = new Trait();

	Trait() {
		super("Trait");
		rebuild = true;
	}

	@Override
	public void build() {
		add(1, SKILL.roll());
		add(1, ATTRIBUTE.roll());
		add(1, "power");
		add(1, "possession");
		add(1, OTHER.roll());
	}

	@Override
	public String roll() {
		return super.roll().toLowerCase();
	}
}
