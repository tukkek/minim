package minim.controller.table.kult.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.SimpleTable;

public class Advantage extends SimpleTable {
	public static final Advantage INSTANCE = new Advantage();
	public static final String ARTISTIC = "Artistic talent";
	public static final String HONOR = "Code of honor";
	public static final String AWARENESS = "Awareness";
	public static final String FLEXIBILITY = "Cultural flexiblity";
	public static final String SENSATE = "Sixth sense";
	public static final String ENDURANCE = "Endurance";
	public static final String INFLUENCE = "Influential friends";
	public static final String EMPATHY = "Empathy";
	public static final String INTUITION = "Intuition";
	public static final String LUCK = "Luck";
	public static final String ANIMALS = "Animal empathy";
	public static final String LANGUAGES = "Gift for languages";
	public static final String CHIVALRY = "Chivalry";
	public static final String PACIFISM = "Pacifism";
	public static final String REPUTATION = "Reputation";
	public static final String MATH = "Mathematical talent";
	public static final String HONESTY = "Honesty";
	public static final String ALTRUIST = "Altruist";
	public static final Map<String, Integer> BALANCE = new HashMap<>();

	static {
		BALANCE.put(ALTRUIST, 5);
		BALANCE.put(ANIMALS, 20);
		BALANCE.put(ARTISTIC, 10);
		BALANCE.put(AWARENESS, 30);
		BALANCE.put(CHIVALRY, 5);
		BALANCE.put(HONOR, 5);
		BALANCE.put(FLEXIBILITY, 10);
		BALANCE.put(EMPATHY, 20);
		BALANCE.put(ENDURANCE, 20);
		BALANCE.put(LANGUAGES, 10);
		BALANCE.put(REPUTATION, 10);
		BALANCE.put(HONESTY, 5);
		BALANCE.put(INFLUENCE, 20);
		BALANCE.put(INTUITION, 20);
		BALANCE.put(LUCK, 20);
		BALANCE.put(MATH, 10);
		BALANCE.put(PACIFISM, 5);
		BALANCE.put(SENSATE, 20);
		for (var a : INSTANCE.lines)
			if (BALANCE.get(a) == null)
				throw new RuntimeException("No balance for " + a);
	}

	Advantage() {
		super("Character (advantage)", List.of(ARTISTIC, HONOR, AWARENESS, FLEXIBILITY, SENSATE, ENDURANCE, INFLUENCE,
				EMPATHY, INTUITION, LUCK, ANIMALS, LANGUAGES, CHIVALRY, PACIFISM, REPUTATION, MATH, HONESTY, ALTRUIST));
	}
}
