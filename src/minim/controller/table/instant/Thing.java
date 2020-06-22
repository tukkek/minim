package minim.controller.table.instant;

import java.util.HashSet;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Thing extends Table {
	static final public Table DESCRIPTOR = new SimpleTable("Thing (descriptor)",
			List.of("Abandoned", "Alien", "Anachronistic", "Ancient", "Angry", "Appealing", "Artsy", "Awesome",
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
					"Supernatural", "Theatrical", "Thorough", "Tough", "Tricky", "Virtuous", "Wealthy"));
	public static final Thing SINGLETON = new Thing();

	Thing() {
		super("Thing");
	}

	@Override
	public void build() {
		add(List.of("Advanced Intelligence", "Afterlife", "Alien", "Alliance", "Alternate History", "Animal",
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
				"Wedding"));
	}

	@Override
	public String roll() {
		return roll(true);
	}

	public String roll(boolean withdescriptors) {
		var thing = super.roll();
		if (withdescriptors) {
			var descriptors = new HashSet<String>(0);
			while (Character.roll(2) == 1)
				descriptors.add(DESCRIPTOR.roll().toLowerCase());
			if (!descriptors.isEmpty())
				thing += " (" + String.join(", ", descriptors) + ")";
		}
		return thing;
	}
}
