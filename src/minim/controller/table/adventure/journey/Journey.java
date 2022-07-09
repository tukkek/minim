package minim.controller.table.adventure.journey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import minim.controller.table.Lines;
import minim.controller.table.Table;
import minim.model.Character;

/**
 * My version of a narrative framework game using tarot cards. First, a setup is
 * generated using major arcana as characters/archeetypes, minor arcana
 * representing their details. Then story beats are generated on-demand, while
 * court cards are used to select plot points from the hero's journey (knight of
 * clubs to king of cups). Pages are separated, drawing one per stage to select
 * a row or column of characters (middle always available).
 * 
 * @author alex
 */
public class Journey extends Table {
	static final List<String> MINOR = Stream.concat(Arrays.stream(Character.QUALITY), Arrays.stream(Character.QUALITY))
			.toList();
	static final Map<String, String> MAJOR = new HashMap<>();
	static final List<String> ALIGNMENTS = new ArrayList<>(List.of("Idealist", "Pacifist", "Free-spirited", "Honorable",
			"Bystander", "Roamer", "Proud", "Pragmatic", "Monster"));
	static final List<String> NUMERALS = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
			"XII");
	static final List<List<Integer>> PAGES = new ArrayList<>(
			List.of(List.of(7, 8, 9, 5), List.of(1, 4, 7, 5), List.of(3, 6, 9, 5), List.of(1, 2, 3, 5)));

	static {
		MAJOR.put("Trickery", "Innocent");
		MAJOR.put("Manipulation", "Alchemist");
		MAJOR.put("Mysticism", "Oracle");
		MAJOR.put("Compassion", "Mother");
		MAJOR.put("Leadership", "Father");
		MAJOR.put("Religion", "Saint");
		MAJOR.put("Love", "Lover");
		MAJOR.put("Control", "Warrior");
		MAJOR.put("Virtue", "Hero");
		MAJOR.put("Wisdom", "Mentor");
		MAJOR.put("Luck", "Gambler");
		MAJOR.put("Reason", "Advocate");
		MAJOR.put("Sacrifice", "Seeker");
		MAJOR.put("Change", "Rebel");
		MAJOR.put("Balance", "Mediator");
		MAJOR.put("Darkness", "Deviant");
		MAJOR.put("Demise", "Destroyer");
		MAJOR.put("Faith", "Divine");
		MAJOR.put("Madness", "Poet");
		MAJOR.put("Hope", "Child");
		MAJOR.put("Redemption", "Knight");
		MAJOR.put("Union", "Guide");
	}

	class Deck {
		LinkedList<String> clubs = new LinkedList<>(MINOR);
		LinkedList<String> spades = new LinkedList<>(MINOR);
		LinkedList<String> cups = new LinkedList<>(MINOR);
		LinkedList<String> coins = new LinkedList<>(MINOR);
		LinkedList<String> court = new LinkedList<>(List.of("Summon", "Refusal", "Aid", "Threshold", "Trials",
				"Atonement", "Apotheosis", "Boon", "Flight", "Rescue", "Return", "Transcendence"));
		LinkedList<String> major = new LinkedList<>(MAJOR.keySet());

		public Deck() {
			for (var list : List.of(clubs, spades, cups, coins, court, major))
				Collections.shuffle(list);
		}

	}

	public Journey() {
		super("Journey");
	}

	@Override
	public void build() {
		// don't
	}

	String characterize(String character, Deck d) {
		String format = "%s (%s body, %s mind, %s soul, %s wealth).";
		return format.formatted(character, d.clubs.pop(), d.spades.pop(), d.cups.pop(), d.coins.pop());
	}

	@Override
	public String roll() {
		var l = new Lines();
		var d = new Deck();
		l.add("Protagonist", characterize(MAJOR.get(d.major.pop()), d));
		l.add();
		var characters = new ArrayList<String>(ALIGNMENTS.size());
		for (var a : ALIGNMENTS) {
			var character = a + " " + MAJOR.get(d.major.pop()).toLowerCase();
			l.add(characterize(character, d));
			characters.add(character);
		}
		l.add();
		Collections.shuffle(PAGES);
		for (var p : PAGES.subList(0, 2)) {
			var faction = new ArrayList<>(p.stream().map(i -> characters.get(i - 1)).toList());
			faction.remove(3);
			l.add("Faction: %s.".formatted(String.join(", ", faction)));
		}
		l.add();
		l.add("Stages:");
		var numerals = new LinkedList<>(NUMERALS);
		while (!d.court.isEmpty()) {
			String beat = "- %s. %s (%s).".formatted(numerals.poll(), d.court.pop(), d.major.pop().toLowerCase());
			Collections.shuffle(PAGES);
			var character = PAGES.get(0).stream().map(i -> i - 1).filter(i -> characters.get(i) != null).findAny()
					.orElse(null);
			if (character != null) {
				var c = characters.get(character);
				characters.set(character, null);
				beat += " %s.".formatted(c);
			}
			l.add(beat);
		}
		return l.toString();
	}
}
