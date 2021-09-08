package minim.controller.table.kult.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.SimpleTable;

public class Advantage extends SimpleTable {
	public static final Advantage INSTANCE = new Advantage();
	public static final Map<String, Integer> BALANCE = new HashMap<>();
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
	public static final String ALERTNESS = AWARENESS;
	public static final String MECHANIC = "Mechanically-inclined";
	public static final String FORGIVING = "Forgiving";
	public static final String MOTHERLINESS = "Motherliness";
	public static final String GOAL = "Goal-driven";
	public static final String STATUS = "Status";
	public static final String FAITH = "Faith";
	public static final String LARGESSE = "Largesse";
	public static final String OPTIMIST = "Optimist";
	public static final String MENTOR = "Mentor";
	public static final String WILL = "Iron will";

	Advantage() {
		super("Character (advantage)",
				List.of(ARTISTIC, HONOR, AWARENESS, FLEXIBILITY, SENSATE, ENDURANCE, INFLUENCE, EMPATHY, INTUITION,
						LUCK, ANIMALS, LANGUAGES, CHIVALRY, PACIFISM, REPUTATION, MATH, HONESTY, ALTRUIST, MECHANIC,
						FORGIVING, MOTHERLINESS, GOAL, STATUS, FAITH, LARGESSE, OPTIMIST, MENTOR, WILL));
	}

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
		BALANCE.put(MECHANIC, 10);
		BALANCE.put(FORGIVING, 5);
		BALANCE.put(MOTHERLINESS, 5);
		BALANCE.put(GOAL, 5);
		BALANCE.put(STATUS, 10);
		BALANCE.put(FAITH, 5);
		BALANCE.put(LARGESSE, 5);
		BALANCE.put(OPTIMIST, 5);
		BALANCE.put(MENTOR, 10);
		BALANCE.put(WILL, 10);
		for (var a : INSTANCE.lines)
			if (BALANCE.get(a) == null)
				throw new RuntimeException("No balance for " + a);
	}
}
