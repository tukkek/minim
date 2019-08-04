package minim.controller.table.ironsworn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class CharacterGenerator extends Table {
	public static final Table ROLE = new Table("Character role") {
		@Override
		public void build() {
			for (var i : List.of("Criminal", "Healer", "Bandit"))
				add(1, 2, i);
			for (var i : List.of("Traveler", "Mystic", "Priest", "Sailor", "Pilgrim", "Thief", "Adventurer", "Forager",
					"Leader", "Guide", "Performer", "Miner", "Mercenary", "Outcast", "Vagrant", "Forester"))
				add(1, 3, i);
			for (var i : List.of("Guard", "Artisan", "Scout", "Herder", "Fisher"))
				add(1, 4, i);
			for (var i : List.of("Warrior", "Hunter", "Raider", "Trader", "Farmer"))
				add(1, 5, i);
			add("Unusual role");
		}
	};
	public static final Table GOAL = new Table("Character goal") {
		@Override
		public void build() {
			add(List.of("Obtain an object", "Make an agreement", "Build a relationship", "Undermine a relationship",
					"Seek a truth", "Pay a debt", "Refute a falsehood", "Harm a rival", "Cure an ill", "Find a person",
					"Find a home", "Seize power", "Restore a relationship", "Create an item", "Travel to a place",
					"Secure provisions", "Rebel against power", "Collect a debt", "Protect a secret", "Spread faith",
					"Enrich themselves", "Protect a person", "Protect the status quo", "Advance status",
					"Defend a place", "Avenge a wrong", "Fulfill a duty", "Gain knowledge", "Prove worthiness",
					"Find redemption", "Escape from something", "Resolve a dispute"));
		}

		@Override
		public String roll() {
			var result = super.roll();
			if (Character.roll(20) == 1)
				result += " and " + super.roll().toLowerCase();
			return result;
		}
	};
	public static final Table DESCRIPTOR = new SimpleTable("Character descriptor", List.of("Stoic", "Attractive",
			"Passive", "Aloof", "Affectionate", "Generous", "Smug", "Armed", "Clever", "Brave", "Ugly", "Sociable",
			"Doomed", "Connected", "Bold", "Jealous", "Angry", "Active", "Suspicious", "Hostile", "Hardhearted",
			"Successful", "Talented", "Experienced", "Deceitful", "Ambitious", "Aggressive", "Conceited", "Proud",
			"Stern", "Dependent", "Wary", "Strong", "Insightful", "Dangerous", "Quirky", "Cheery", "Disfigured",
			"Intolerant", "Skilled", "Stingy", "Timid", "Insensitive", "Wild", "Bitter", "Cunning", "Remorseful",
			"Kind", "Charming", "Oblivious", "Critical", "Cautious", "Resourceful", "Weary", "Wounded", "Anxious",
			"Powerful", "Athletic", "Driven", "Cruel", "Quiet", "Honest", "Infamous", "Dying", "Reclusive", "Artistic",
			"Disabled", "Confused", "Manipulative", "Relaxed", "Stealthy", "Confident", "Weak", "Friendly", "Wise",
			"Influential", "Young", "Adventurous", "Oppressed", "Vengeful", "Cooperative", "Armored", "Apathetic",
			"Determined", "Loyal", "Sick", "Religious", "Selfish", "Old", "Fervent", "Violent", "Agreeable",
			"Hot-tempered", "Stubborn", "Incompetent", "Greedy", "Cowardly", "Obsessed", "Careless", "Ironsworn"));

	static final List<String> ATTRIBUTES = new ArrayList<>(List.of("Edge", "Heart", "Iron", "Shadow", "Wits"));

	public CharacterGenerator() {
		super("Character");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		Collections.shuffle(ATTRIBUTES);
		var character = String.join(" > ", ATTRIBUTES);
		character += "\nRole: " + ROLE.roll().toLowerCase();
		character += "\nGoal: " + GOAL.roll().toLowerCase();
		character += "\nDescriptor: " + DESCRIPTOR.roll().toLowerCase();
		return character;
	}
}
