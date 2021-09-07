package minim.controller.table.kult.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.SimpleTable;

public class Disadvantage extends SimpleTable {
	public static final Disadvantage INSTANCE = new Disadvantage();
	public static final String DEPRESSION = "Depression";
	public static final String REPUTATION = "Bad reputation";
	public static final String DEATHWISH = "Death wish";
	public static final String PHOBIA = "Phobia";
	public static final String CONSTRICTION = "Cognitive dissonance";
	public static final String PARANOIA = "Paranoia";
	public static final String PERSECUTED = "Persecuted";
	public static final String NIGHTMARES = "Nightmares";
	public static final String ADDICTION = "Drug addiction";
	public static final String LIAR = "Habitual liar";
	public static final String SCHIZOPHRENIA = "Schizophrenia";
	public static final String RATIONALIST = "Rationalist";
	public static final String NYMPHOMANIA = "Sexual neurosis";
	public static final String COMPULSION = "Mental compulsion";
	public static final String REVENGE = "Oath of revenge";
	public static final String ENEMY = "Mortal enemy";
	public static final String LUCK = "Bad luck";
	public static final String WANTED = "Wanted";
	public static final String HAUNTED = "Haunted";
	public static final String MANIA = "Mania";
	public static final String FANATICISM = "Fanaticism";
	public static final String INTOLERANCE = "Intolerance";
	public static final String TOUCHY = "Touchy";
	public static final String EGOTIST = "Narcissist";
	public static final String MAIMED = "Maimed";
	public static final String GREED = "Greed";
	public static final String GAMBLER = "Reckless gambler";
	public static final String CURSE = "Curse";
	public static final String MANICDEPRESSIVE = "Manic-depressive";
	public static final Map<String, Integer> BALANCE = new HashMap<>();

	static {
		BALANCE.put(LUCK, 5);
		BALANCE.put(REPUTATION, 10);
		BALANCE.put(CURSE, 20);
		BALANCE.put(DEATHWISH, 10);
		BALANCE.put(DEPRESSION, 20);
		BALANCE.put(ADDICTION, 20);
		BALANCE.put(EGOTIST, 5);
		BALANCE.put(FANATICISM, 10);
		BALANCE.put(GAMBLER, 20);
		BALANCE.put(GREED, 10);
		BALANCE.put(LIAR, 10);
		BALANCE.put(HAUNTED, 10);
		BALANCE.put(MANIA, 20);
		BALANCE.put(MANICDEPRESSIVE, 20);
		BALANCE.put(COMPULSION, 10);
		BALANCE.put(CONSTRICTION, 10);
		BALANCE.put(ENEMY, 20);
		BALANCE.put(NIGHTMARES, 10);
		BALANCE.put(REVENGE, 5);
		BALANCE.put(PARANOIA, 20);
		BALANCE.put(PHOBIA, 10);
		BALANCE.put(RATIONALIST, 20);
		BALANCE.put(SCHIZOPHRENIA, 20);
		BALANCE.put(NYMPHOMANIA, 10);
		BALANCE.put(TOUCHY, 5);
		BALANCE.put(WANTED, 10);
		BALANCE.put(INTOLERANCE, 10);
		BALANCE.put(PERSECUTED, 10);
		BALANCE.put(MAIMED, 15);
		for (var d : INSTANCE.lines)
			if (BALANCE.get(d) == null)
				throw new RuntimeException("No balance for " + d);
	}

	Disadvantage() {
		super("Character (disadvantage)",
				List.of(DEPRESSION, REPUTATION, DEATHWISH, PHOBIA, CONSTRICTION, PARANOIA, PERSECUTED, NIGHTMARES,
						ADDICTION, LIAR, SCHIZOPHRENIA, RATIONALIST, NYMPHOMANIA, COMPULSION, REVENGE, ENEMY, LUCK,
						WANTED, HAUNTED, MANIA, FANATICISM, INTOLERANCE, TOUCHY, EGOTIST, MAIMED, GREED, GAMBLER, CURSE,
						MANICDEPRESSIVE));
	}
}
