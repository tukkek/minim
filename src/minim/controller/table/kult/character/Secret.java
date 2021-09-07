package minim.controller.table.kult.character;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import minim.controller.table.SimpleTable;

public class Secret extends SimpleTable {
	public static final String VICTIM = "Victim";
	public static final String SUPERNATURAL_EXPERIENCE = "Supernatural experience";
	public static final String HAUNTED = "Haunted";
	public static final String PESSESSED = "Possessed";
	public static final String PACT = "Dark pact";
	public static final String OCCULT_EXPERIENCE = "Occult experience";
	public static final String INSANITY = "Insanity";
	public static final String GUILTY = "Guilty";
	public static final String KNOWLEDGE = "Knowledge";
	public static final String FAMILY = "Family secret";
	public static final String CURSE = "Curse";
	public static final Secret INSTANCE = new Secret();

	static final Map<String, List<String>> DISADVANTAGES = new HashMap<>();

	static {
		DISADVANTAGES.put(CURSE,
				List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA,
						Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.PERSECUTED,
						Disadvantage.NIGHTMARES, Disadvantage.ADDICTION, Disadvantage.LIAR, Disadvantage.SCHIZOPHRENIA,
						Disadvantage.RATIONALIST, Disadvantage.NYMPHOMANIA, Disadvantage.COMPULSION));
		DISADVANTAGES.put(KNOWLEDGE,
				List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
						Disadvantage.PHOBIA, Disadvantage.PARANOIA, Disadvantage.PERSECUTED, Disadvantage.NIGHTMARES,
						Disadvantage.ADDICTION, Disadvantage.LUCK, Disadvantage.RATIONALIST, Disadvantage.COMPULSION));
		DISADVANTAGES.put(GUILTY,
				List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA,
						Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.PERSECUTED, Disadvantage.WANTED,
						Disadvantage.LIAR, Disadvantage.NIGHTMARES, Disadvantage.ADDICTION, Disadvantage.LUCK,
						Disadvantage.SCHIZOPHRENIA, Disadvantage.RATIONALIST, Disadvantage.COMPULSION));
		DISADVANTAGES.put(INSANITY,
				List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION,
						Disadvantage.PARANOIA, Disadvantage.HAUNTED, Disadvantage.MANIA, Disadvantage.NIGHTMARES,
						Disadvantage.ADDICTION, Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA,
						Disadvantage.COMPULSION));
		DISADVANTAGES.put(OCCULT_EXPERIENCE,
				List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.PARANOIA,
						Disadvantage.HAUNTED, Disadvantage.WANTED, Disadvantage.NIGHTMARES, Disadvantage.ADDICTION,
						Disadvantage.LUCK, Disadvantage.RATIONALIST, Disadvantage.SCHIZOPHRENIA,
						Disadvantage.NYMPHOMANIA, Disadvantage.COMPULSION));
		DISADVANTAGES.put(PACT,
				List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.CURSE,
						Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.GREED, Disadvantage.HAUNTED,
						Disadvantage.PERSECUTED, Disadvantage.LIAR, Disadvantage.ADDICTION, Disadvantage.LUCK,
						Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA, Disadvantage.EGOTIST,
						Disadvantage.COMPULSION));
		DISADVANTAGES.put(HAUNTED,
				List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION,
						Disadvantage.PARANOIA, Disadvantage.HAUNTED, Disadvantage.NIGHTMARES, Disadvantage.ADDICTION,
						Disadvantage.RATIONALIST, Disadvantage.COMPULSION));
		DISADVANTAGES.put(SUPERNATURAL_EXPERIENCE,
				List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION,
						Disadvantage.PARANOIA, Disadvantage.HAUNTED, Disadvantage.WANTED, Disadvantage.NIGHTMARES,
						Disadvantage.ADDICTION, Disadvantage.LUCK, Disadvantage.RATIONALIST, Disadvantage.SCHIZOPHRENIA,
						Disadvantage.NYMPHOMANIA, Disadvantage.COMPULSION));
		DISADVANTAGES.put(VICTIM,
				List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
						Disadvantage.REVENGE, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION, Disadvantage.PARANOIA,
						Disadvantage.PERSECUTED, Disadvantage.NIGHTMARES, Disadvantage.LIAR, Disadvantage.ADDICTION,
						Disadvantage.LUCK, Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA,
						Disadvantage.COMPULSION));
	}

	Secret() {
		super("Character (dark secret)", List.of(CURSE, FAMILY, KNOWLEDGE, GUILTY, INSANITY, OCCULT_EXPERIENCE, PACT,
				PESSESSED, HAUNTED, SUPERNATURAL_EXPERIENCE, VICTIM));
	}

	public String roll(List<String> secrets, List<String> disadvantages) {
		var count = new HashMap<String, Integer>();
		var high = 0;
		for (var s : secrets) {
			var hits = 0;
			for (var d : disadvantages) {
				var related = DISADVANTAGES.get(s);
				if (related != null && related.contains(d))
					hits += 1;
			}
			count.put(s, hits);
			if (hits > high)
				high = hits;
		}
		var finalhigh = high;
		var best = count.keySet().stream().filter(k -> count.get(k) == finalhigh).collect(Collectors.toList());
		Collections.shuffle(best);
		return best.get(0);
	}
}
