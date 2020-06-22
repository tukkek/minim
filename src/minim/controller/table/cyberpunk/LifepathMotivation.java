package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class LifepathMotivation extends Table {
	public static final Table PERSONALITY = new SimpleTable("Motivation (personality)",
			List.of("Shy and secretive", "Rebelious, antisocial, violent", "Arrogant, proud, aloof",
					"Moody, rash, headstrong", "Picky, fussy, nervous", "Stable, serious", "Silly", "Deceptive",
					"Intellectual, detached", "Friendly, outgoing"));
	public static final Table VALUED = new SimpleTable("Motivation (valued person)", List.of("Parent", "Sibling",
			"Lover", "Friend", "Yourself", "Pet", "Mentor", "Celebrity", "Personal hero", "No one"));
	public static final Table VALUES = new SimpleTable("Motivation (values)", List.of("Money", "Honor", "Trust",
			"Honesty", "Knowledge", "Vengeance", "Love", "Power", "Pleasure", "Friendship"));
	public static final Table RELATIONS = new SimpleTable("Motivation (relations)",
			List.of("Neutral", "Neutral", "Like everyone", "Hate everyone", "People are tools", "Everyone is valuable",
					"Can be obstacles to destroy", "People are not to be trusted", "Wipe everyone out",
					"People are wonderful"));
	public static final Table POSSESSION = new SimpleTable("Motivation (possession)", List.of("Weapon", "Tool",
			"Clothing", "Photo", "Book or diary", "Recording", "Instrument", "Jewelry", "Toy", "Letter"));
	public static final LifepathMotivation SINGLETON = new LifepathMotivation();

	LifepathMotivation() {
		super("Motivation");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var motivations = "Personality: " + PERSONALITY.roll();
		motivations += "\nValued person: " + VALUED.roll();
		motivations += "\nValues: " + VALUES.roll();
		motivations += "\nRelations: " + RELATIONS.roll();
		motivations += "\nPossession: " + POSSESSION.roll();
		return motivations;
	}
}
