import * as table from './table.js'
import * as rpg from '../rpg.js'

export var tables=[]

const RANKS = new table.Table("Instant game, trait, rank")
RANKS.add("Super", 1);
RANKS.add( "Exceptional",2);
RANKS.add( "Advanced",4);
RANKS.add("Basic",8);
RANKS.add("Average",10);

const SKILL = new table.Table("Instant game, trait, skill", ["Accounting", "Carpenter", "Firearms",
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
    "Listening deeply", "Riding", "Zero-G Maneuvering"])
const ATTRIBUTE = new table.Table("Instant game, trait, attribute",
    ["agility", "aim", "appearance", "beauty", "constitution", "damage capacity", "drive", "ego",
        "empathy", "endurance", "health", "intuition", "magical aptitude", "mechanicalaptitude", "memory",
        "power", "presence", "psi-strength", "psyche", "quickness", "reasoning", "sanity", "speed",
        "spirituality", "strength", "willpower", "wisdom", "wit"])
const OTHER = new table.Table("Instant game, trait, others",
    ["Contacts", "Wealth", "Affiliations", "Reputation"])

class Trait extends table.Table {
	constructor() {
		super("Instant game, trait");
		this.add(SKILL, 1);
		this.add(ATTRIBUTE, 1);
		this.add("power", 1);
		this.add("possession", 1);
		this.add(OTHER, 1);
	}

  roll() {
		return super.roll().toLowerCase();
	}
}

var trait=new Trait()
tables.push(...[RANKS,SKILL,ATTRIBUTE,OTHER,trait])

const DESCRIPTOR = new table.Table("Instant game, thing, descriptor",
    ["Abandoned", "Alien", "Anachronistic", "Ancient", "Angry", "Appealing", "Artsy", "Awesome",
        "Awkward", "Balanced", "Battle-Scarred", "Beautiful", "Bizarre", "Bright", "Charming", "Classy",
        "Clean", "Clear", "Cold", "Cruel", "Curious", "Dead", "Deadly", "Deviant", "Dubious", "Dumb",
        "Efficient", "Elegant", "Enduring", "Epic", "Extravagant", "Famous", "Fantasy", "Fateful", "Feared",
        "Firm", "Flexible", "Forceful", "Fortunate", "Funky", "Giant", "Gloomy", "Glorious", "Grave",
        "Guarded", "Guiding", "Harmonious", "Healthy", "Hearty", "Hip", "iptors", "Historical", "Hi-Tech",
        "Illusory", "Inappropriate", "Infested", "Informative", "Inspiring", "Legendary", "Magical",
        "Malignant", "Mature", "Medieval", "Mercurial", "Military", "Miniature", "Misdirecting", "Mobile",
        "Newly-Restored", "Noble", "Occult", "Polluted", "Precise", "Prophetic", "Quick", "Recognizable",
        "Religious", "Reputable", "Resilient", "Rigid", "Ritualistic", "Rough", "Sacrificial", "Savage",
        "Sci-Fi", "Secret", "Shiny", "Silent", "Sloppy", "Spiritual", "Steady", "Stiff", "Strong", "Subtle",
        "Supernatural", "Theatrical", "Thorough", "Tough", "Tricky", "Virtuous", "Wealthy"])

 class Thing extends table.Table {
	constructor() {
		super("Instant game, thing");
		this.lines.push(...["Advanced Intelligence", "Afterlife", "Alien", "Alliance", "Alternate History", "Animal",
				"Anthropomorphic Objects", "Artificial Intelligence", "Atomic Monster", "Big Business", "Blood",
				"Bogeyman", "Castle", "Church", "Computers", "Conspiracy", "Correctional System", "Dam", "Demon",
				"Deity", "Disaster", "Disease", "Dragons", "Dungeon", "Elves", "Empire", "Epic Heroes", "Espionage",
				"Exploration", "Fairy", "Fire", "Frontier", "Furry", "Gang Warfare", "Garbage", "Genetic Engineering",
				"Ghost Town", "Giant", "Heaven & Hell", "High Magic", "Hotel", "Immortals", "Insanity",
				"Invaders/Outsiders", "Limbo", "Lost Tribe", "Low Magic", "Mass Transit", "Mecha", "Military",
				"Monkeys", "Movie Monsters", "Music", "Mutants/Mutations", "Mysterious Energy", "Nanotech",
				"Neutral Ground", "Neutrality", "Ninjas", "Occult", "Organized Crime", "Pirate", "Political Intrigue",
				"Pollution", "Powers", "Prophesy", "Psychic Ability", "Realm of the Gods", "Robots/Automatons",
				"Royal Bloodline", "Ruins", "Sci-Fi", "Secret Society", "Serial Killer", "Ship", "Space", "Special Ops",
				"Spy", "Steampunk", "Street Gangs", "Stronghold", "Suburb", "The Supernatural", "Supers", "Territory",
				"Time Travel", "Trade", "Troubled Youth", "Ultimate Weapon", "Undead", "Underground Pariahs",
				"Unusual Phenomena", "Vampire", "Virtual Reality", "War", "Water", "Werewolf", "Wild Animals",
				"Wilderness", "World Domination", "Armory", "Artifact", "Auditorium", "Blackmail", "Brains", "Bugs",
				"Burrow", "Business Office", "Cannonfodder", "Child", "Confinement", "Cover Up", "Crash Site",
				"Disguise", "Docks", "Door", "Dreams", "Duel", "Elected Official", "Election", "Elvis", "Faith", "Farm",
				"Festival", "Fight", "Gambling", "Government Agents", "Government Office", "Grave", "Grudge", "Guard",
				"Guide", "Heir", "Heist", "Hired Muscle", "Honor", "Horseman", "Hostage", "Hunt", "Illness", "Intrigue",
				"Invention", "Island", "Janitor", "Kingpin", "Lair", "Launch", "Law Enforcement", "Lawyer", "Leader",
				"Marketplace", "Martial Arts", "Mask", "Mechanic", "Mercenaries", "Mindless Horde", "Mob", "Murder",
				"Mystery", "Natural Disaster", "Newborn", "Nightclub/Rave", "Noble", "Note", "Park", "People", "Poison",
				"Political Group", "Prayer", "Prisoner", "Prostitute", "Rebels", "Red Herring", "Religious Fanatics",
				"Research", "Restaurant", "Revenge", "Road", "Romance", "School", "Secret", "Security Forces", "Sleep",
				"Soldier", "Sporting Event", "Store", "Student", "Survival", "Tavern", "Teacher", "Theatre",
				"Town Square", "Traitor", "Travel", "Treasure", "Treaty", "Untimely Death", "Vehicle", "Warehouse",
				"Wedding"])
	}

	roll(withdescriptors=true) {
		let thing = super.roll();
		if (withdescriptors) {
			let descriptors = new Set()
			while (rpg.roll(1,2) == 1)
				descriptors.add(DESCRIPTOR.roll().toLowerCase());
			if (descriptors.size>0)
				thing += " (" + Array.from(descriptors).join(', ') + ")";
		}
		return thing;
	}
}

var thing=new Thing()
tables.push(...[DESCRIPTOR,thing])

const TONE = new table.Table("Instant game, setting, tone",
    ["Action/Adventure", "B-movie", "Campy", "Conspiracy", "Despair", "Epic", "Fantasy", "Gothic",
        "Heroic", "Horror", "Intrigue", "Mystery", "Mythic", "Parable/Moralistic", "Pulp", "Realistic",
        "Romance", "Suspense", "Swashbuckling", "Tactical"])
const PLACE = new table.Table("Instant game, setting, place", ["Afterlife", "Amusement Park",
    "Arcade", "Armory", "Auction", "Auditorium", "Bank", "Barracks", "Bathhouse", "Beach", "Bordello", "Bridge",
    "Burrow", "Business Office", "Camping Out", "Carnival", "Castle", "Cave", "Charitable Shelter", "Church",
    "Control Room", "Correctional System", "Crash Site", "Crater", "Crossroads", "Dam", "Docks", "Dormitory",
    "Dungeon", "Farm", "Festival", "Forest", "Foundry", "Frontier", "Government Office", "Graveyard",
    "Headquarters", "Home", "Hospital", "Hotel", "Hovel", "Institution", "Island", "Junkyard", "Lair",
    "Landmark", "Law Enforcement Office", "Library", "Limbo", "Locked Out", "Lost/Stranded", "Magic Shop",
    "Mansion", "Marketplace", "Maze", "Military Installation", "Moon", "Morgue", "Mountain", "Neutral Ground",
    "News Office", "Nightclub/Rave", "Oasis", "Orphanage", "Outpost", "Park", "Parking Lot",
    "Port/Transport Hub", " Forum", "Refuse Dump", "Resort/Spa", "Restaurant", "Restroom", "River",
    "Road", "Rooftop", "Ruins", "Safehouse", "School", "Sewer", "Ship", "Space", "Stadium", "Stage", "Store",
    "Stronghold", "Suburb", "Suburban Retail Center", "Tavern", "Theatre", "Tower", "Town Square",
    "Underground", "Underwater", "Vehicle", "Volcano", "Warehouse", "Wilderness", "Wildlife Preserve", "Zoo"])
const POPULATION = new table.Table("Instant game, setting, population", ["<20", "100", "600",
    "3,000", "15,000", "80,000", "400,000", "2,000,000", "10,000,000", ">10,000,000"])
const TECH = new table.Table("Instant game, setting, tech",
    ["Agriculture", "Alchemy", "Alien Supertech", "Artificial Intelligence", "Automobiles", "Bronze",
        "Computers", "Contemporary", "Cybertech", "Domesticated Animals", "Early Space Exploration",
        "Electricity", "Electronics", "Flight", "Fossil Fuels", "Frankentech", "FTL Travel",
        "Galactic Empires", "Genetic Engineering", "High Magic", "Hydro-power", "Industrial Revolution",
        "Information Age", "Iron", "Lighter Than Air Travel", "Lost Technology", "Low Magic", "Macrotech",
        "Magitech", "Nanotech", "Near Future", "No Tech", "Nuclear Power", "Ocean Going Ships",
        "Post-Apocalyptic", "Printing Press", "Psychic Abilities", "Renaissance", "Robots/Automatons",
        "Rube Goldberg", "Scientific Method", "Solar Energy", "Space Colonies", "Steam Power", "Steampunk",
        "Stone Age", "Teleportation", "Time Travel", "Virtual Reality", "Wheel"])

class InstantSetting extends table.Table {
	constructor() {
		super("Instant game, setting");
		this.lines.push(...["Alien Occupied Earth", "All Supers World", "Alternate History", "Ancient Egypt", "Ape World",
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
				"Wild West", "Wilderness", "Wildlife Preserve", "WWI", "WWII", "WWIII", "Your Place"])
	}

  roll() {
		let setting = super.roll();
		setting += "<br/>Tone: " + TONE.roll();
		for (var i = 0; i < 2; i++)
			setting += "<br/>Thing: " + thing.roll();
		if (rpg.roll(1,6) == 1)
			setting += "<br/>Place: " + PLACE.roll();
		if (rpg.roll(1,6) == 1)
			setting += "<br/>Population: " + POPULATION.roll();
		if (rpg.roll(1,6) == 1)
			setting += "<br/>Tech: " + TECH.roll();
		return setting;
	}
}

let setting=new InstantSetting()
tables.push(...[TONE,PLACE,POPULATION,TECH,setting])

const OPPOSITION = new table.Table("Instant game, plot, opposition",
  ["Artifact", "Big Business", "Charismatic Leader", "Common Criminal", "Conspiracy", "Crazed Loner",
      "Demon", "Desperate Citizen", "Deity", "Disease", "Divine Creation", "Doppelganger",
      "Evil Mastermind", "Family", "Force of Nature", "Government Agents", "Hired Muscle", "Immortals",
      "Infestation", "Invaders/Outsiders", "Kingpin", "Law Enforcement", "Machines Gone Mad",
      "Mercenaries", "Military", "Mindless Horde", "Misguided Hero", "Mob", "Movie Monsters", "Mutants",
      "Mythical Legend", "Organized Crime", "Political Group", "Rebels", "Religious Fanatics",
      "Security Forces", "Serial Killer", "Societal Pressure/Custom", "Spy", "Street Gang/Gang Member",
      "The System", "Ticking Time Bomb", "Tragic Villain", "Traitor", "Troubled Youth", "Undead",
      "Underground Pariahs", "Warlord", "Wild Animals", "Yourself"])
const ACTION = new table.Table("Instant game, plot, action",
  ["Alert", "Assassinate", "Blackmail", "Brainwash", "Build", "Celebrate", "Clean", "Clear", "Collect",
      "Convince", "Cover Up", "Defend", "Deliver", "Destroy", "Discover", "Disguise", "Duel", "Escape",
      "Explore", "Fight", "Fire", "Guard", "Guide", "Hide", "Humiliate", "Hunt", "Infiltrate",
      "Intimidate", "Kidnap", "Launch", "Liberate", "Lose", "Mimic", "Murder", "Negotiate", "Poison",
      "Purchase", "Recover", "Reject", "Rescue", "Research", "Scare", "Seduce", "Spy", "Steal", "Survive",
      "Teach", "Trade", "Travel", "Win"])

class InstantPlot extends table.Table {
	constructor() {
		super("Instant game, plot");
	}

  roll() {
		let plot = "Opposition: " + OPPOSITION.roll();
		plot += "<br/>" + ACTION.roll() + " " + thing.roll(false).toLowerCase();
		plot += "<br/>" + ACTION.roll() + " " + thing.roll(false).toLowerCase();
		return plot;
	}
}

var plot=new InstantPlot()
tables.push(...[OPPOSITION,ACTION,plot])

const PEOPLE = new table.Table("Instant game, character, people",
    ["Actor", "Advisor", "Agent", "Anthropomorphic Object", "Aristocrat", "Artificial Intelligence",
        "Artisan", "Athlete", "Author", "Banker", "Bar Fly", "Bounty Hunter", "Bully", "Cannonfodder",
        "Caretaker", "Carpenter", "Casanova", "Child", "Clergy", "Collector", "Common Criminal",
        "Concerned Parent", "Conspiracy Theorist", "Crazed Loner", "Demon", "Desperate Citizen",
        "Devil's Advocate", "Driver", "Eccentric Millionaire", "Elder", "Elected Official", "Expert",
        "Farmer", "Fixer", "Gambler", "Genius", "Government Agent", "Guard", "Guide", "Healer", "Heir",
        "Hired Muscle", "Historian", "Horseman", "Hostage", "Hunter", "Idiot Savant", "Immortals",
        "Informant", "Janitor", "Judge", "Kingpin", "Law Enforcement Officer", "Lawyer", "Leader",
        "Local Legend", "Magician", "Mason", "Mechanic", "Mercenaries", "Musician", "Ninjas", "Noble",
        "Philosopher", "Pirate", "Prisoner", "Private Investigator", "Prophet", "Prostitute", "Pundit",
        "Rebel", "Recluse", "Red Shirt", "Relative", "Religious Fanatics", "Repairman", "Robot/Automaton",
        "Sailor", "Salesman", "Scribe", "Security Forces", "Serial Killer", "Servant", "Shopkeep", "Slave",
        "Smith", "Soldier", "Speaker", "Sportsman", "Spy", "Student", "Swindler", "Teacher", "Technician",
        "Thief", "Thug", "Troubled Youth", "Undertaker", "Vagrant", "Village Idiot"])
const PERSONALITY = new table.Table("Instant game, character, personality", ["Affectionate",
    "Aloof", "Ambitious", "Angry", "Apathetic", "Argumentative", "Arrogant", "Artsy", "Athletic", "Attentive",
    "Battle-Scarred", "Beautiful", "Belligerent", "Boastful", "Calm", "Cautious", "Charming", "Chaste",
    "Chauvinistic", "Chivalrous", "Clever", "Confident", "Cruel", "Curious", "Cynical", "Deceitful",
    "Defensive", "Defiant", "Detached", "Deviant", "Devil's Advocate", "Distracted", "Ditzy", "Dumb", "Eager",
    "Egomaniacal", "Evasive", "Extravagant", "Famous", "Flexible", "Generous", "Gloomy", "Greedy", "Hasty",
    "Healthy", "Hedonistic", "Honest", "Humble", "Humorous", "Hyper", "Hypochondriac", "Ignorant", "Ill",
    "Imaginative", "Impatient", "Impulsive", "Independent", "Innocent", "Insane", "Insecure", "Intelligent",
    "Introverted", "Judgmental", "Juvenile", "Lazy", "Logical", "Mischievous", "Nervous", "Obnoxious",
    "Obsessive-Compulsive", "Organized", "Paranoid", "Passive-Aggressive", "Popular", "Quixotic", "Reasonable",
    "Relentless", "Resourceful", "Restless", "Rich", "Rude", "Sadistic", "Sensitive", "Serious", "Shrewd",
    "Shy", "Sloppy", "Snobby", "Spiritual", "Spontaneous", "Stubborn", "Sympathetic", "Tongue-Tied", "Tough",
    "Ungrateful", "Virtuous", "Vulgar", "Whiny", "Wise", "Xenophobic"])
const FLAW = new table.Table("Instant game, character, flaw",
    ["Addiction of any sort", "Ambitious", "Cannot lose an argument", "Can't turnaway a person in need",
        "Code of Honor", "Compulsivebehavior", "Cowardly", "Easily distracted", "Enemy",
        "Fanatically loyal", "Foolishly brave", "Greedy", "Gullible", "Angry",
        "Incompetence in a specific skillarea", "Intolerant", "Lazy", "Massive debt", "Mental illness",
        "Obese", "Obsessive", "Overconfident", "Overly generous", "Pacifism", "Painfully shy", "Phobia",
        "Physically weak", "Poor", "Progammed with Asimov's Laws of Robotics", "Prone tobattle rage",
        "Racist", "Slow learner", "Stubborn", "Thin skinned", "Unlucky", "Vain", "Wanted by the law",
        "Zealous behavior"])

class InstantCharacter extends table.Table {
	constructor(title="character", basic=5, advanced=3, exceptional=1, flaws=1) {
		super(`Instant game, ${title}`);
		this.basic = basic;
		this.advanced = advanced;
		this.exceptional = exceptional;
		this.flaws = flaws;
	}

	gettraits(basic, advanced, exceptional) {
		let traits = [] // cannot use set unless possession an power table is added
		while (traits.length < basic + advanced + exceptional)
			traits.push(trait.roll());
		for (var i = 0; i < traits.length; i++) {
			let t = traits[i].toLowerCase();
			if (exceptional > 0) {
				t = "exceptional " + t;
				exceptional -= 1;
			} else if (advanced > 0) {
				t = "advanced " + t;
				advanced -= 1;
			} else if (basic > 0) {
				t = "basic " + t;
				basic -= 1;
			}
			traits[i]=t;
		}
		return traits;
	}

	roll() {
		let personality = new Set()
		while (personality.size==0 || rpg.roll(1,2) == 1)
			personality.add(PERSONALITY.roll().toLowerCase());
		let character = PEOPLE.roll() + " (" + Array.from(personality).join(", ") + ")";
		let basic = this.basic;
		let advanced = this.advanced;
		let exceptional = this.exceptional;
		let nflaws = this.flaws;
		let roll = rpg.roll(1,8);
		if (roll == 1 || roll == 2) {
			nflaws += 1;
			basic += 1;
		} else if (roll == 3) {
			nflaws += 2;
			basic += 2;
		} else if (roll == 4) {
			nflaws += 2;
			advanced += 1;
		}
		character += "<br/>Traits: " + this.gettraits(basic, advanced, exceptional).join(", ");
		let flaws = new Set()
		while (flaws.size < nflaws)
			flaws.add(FLAW.roll().toLowerCase());
		character += "<br/>Flaws: " + Array.from(flaws).join(", ");
		return character;
	}
}

const NORMAL = new InstantCharacter();
const WEAK = new InstantCharacter("weak character", 4, 2, 1, 1);
const FLAMBOYANT = new InstantCharacter("flamboyant character", 6, 4, 2, 1);

tables.push(...[PEOPLE,PERSONALITY,FLAW,NORMAL,WEAK,FLAMBOYANT])

class InstantChallenge extends table.Table {
	constructor() {
		super("Instant game, challenge");
	}

	roll() {
		let challenge = "Settting:<br/>" + setting.roll();
		challenge += "<br/><br/>Plot:<br/>" + plot.roll();
		challenge += "<br/><br/>Extras: " + thing.roll() + ", " + thing.roll(false);
		return challenge;
	}
}

tables.push(new InstantChallenge())
