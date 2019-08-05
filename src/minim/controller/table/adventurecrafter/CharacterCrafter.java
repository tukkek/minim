package minim.controller.table.adventurecrafter;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class CharacterCrafter extends Table {
	public static final Table TRAIT = new Table("Character generator (trait)") {
		@Override
		public void build() {
			add(1, 50, "Individual");
			for (var l : List.of("Organization", "Object", "Connected to plotline", "Not connected to plotline",
					"Resolves this plotline", "Hinders this plotline", "Connected to another character"))
				add(1, 7, l);
		}
	};
	public static final Table IDENTITY = new SimpleTable("Character generator (identity)",
			List.of("Warrior", "Healer", "Protector", "Assistant", "Dependent", "Ruler", "Administrator", "Victim",
					"Scholar", "Expert", "Elite", "Investigator", "Criminal", "Supporter", "Helpless", "Outsider",
					"Mediator", "Entertainer", "Socialite", "Athlete", "Performer", "Representative", "Merchant",
					"Trader", "Creator", "Artist", "Servant", "Laborer", "Religious", "Hunter", "Leader", "Fighter",
					"Crafter", "Thief", "Radical", "Executive", "Thug", "Guard", "Guardian", "Explorer", "Hero",
					"Villain", "Deceiver", "Engineer", "Scout", "Fixer", "Wanderer", "Subverter", "Soldier",
					"Law Enforcement", "Scientist", "Gatherer", "Foreigner", "Survivor", "Gambler", "Rogue", "Farmer",
					"Killer", "Professional", "Driver/Pilot", "Student", "Organizer", "Deliverer", "Lackey", "Teacher",
					"Exotic", "Exotic")) {
		@Override
		public String roll() {
			return Character.roll(3) == 1 ? super.roll() + ", " + super.roll().toLowerCase() : super.roll();
		}
	};
	public static final Table DESCRIPTOR = new SimpleTable("Character generator (descriptor)",
			List.of("Ugly", "Beautiful", "Foul", "Sweet", "Unusual", "Common", "Intelligent", "Ignorant", "Educated",
					"Skilled", "Trained", "Rude", "Polite", "Fancy", "Rough", "Dirty", "Clean", "Wealthy", "Poor",
					"Small", "Large", "Quiet", "Loud", "Fast", "Slow", "Exotic", "Uniformed", "Interesting", "Colorful",
					"Informative", "Dangerous", "Inept", "Clumsy", "Capable", "Intrusive", "Respectful", "Primitive",
					"Sophisticated", "Elegant", "Armed", "Different", "Young", "Old", "Difficult", "Helpful", "Harmful",
					"Disciplined", "Erratic", "Wild", "Crazy", "Commanding", "Meek", "Humorous", "Frightened", "Brave",
					"Strong", "Weak", "Impulsive", "Strategic", "Naive", "Confident", "Surprising", "Passive", "Bold",
					"Careless", "Cautious", "Sneaky", "Intimidating", "Powerful", "Powerless", "Hurt", "Rough",
					"Gentle", "Caring", "Principled", "Arrogant", "Curious", "Supportive", "Heroic")) {
		@Override
		public String roll() {
			return Character.roll(5) == 1 ? super.roll() + ", " + super.roll().toLowerCase() : super.roll();
		}
	};

	public CharacterCrafter() {
		super("Character generator");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var character = "Trait: " + TRAIT.roll();
		character += "\nIdentity: " + IDENTITY.roll();
		character += "\nDescriptor: " + DESCRIPTOR.roll();
		return character;
	}
}
