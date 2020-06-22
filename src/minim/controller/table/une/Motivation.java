package minim.controller.table.une;

import java.util.ArrayList;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Motivation extends Table {
	public static final Table VERB = new SimpleTable("NPC motivation (verb)",
			List.of("advise", "obtain", "attempt", "spoil", "oppress", "interact", "create", "abduct", "promote",
					"conceive", "blight", "progress", "distress", "possess", "record", "embrace", "contact", "pursue",
					"associate", "prepare", "shepherd", "abuse", "indulge", "chronicle", "fulfill", "drive", "review",
					"aid", "follow", "advance", "guard", "conquer", "hinder", "plunder", "construct", "encourage",
					"agonize", "comprehend", "administer", "relate", "take", "discover", "deter", "acquire", "damage",
					"publicize", "burden", "advocate", "implement", "understand", "collaborate", "strive", "complete",
					"compel", "join", "assist", "defile", "produce", "institute", "account", "work", "accompany",
					"offend", "guide", "learn", "persecute", "communicate", "process", "report", "develop", "steal",
					"suggest", "weaken", "achieve", "secure", "inform", "patronize", "depress", "determine", "seek",
					"manage", "suppress", "proclaim", "operate", "access", "refine", "compose", "undermine", "explain",
					"discourage", "attend", "detect", "execute", "maintain", "realize", "convey", "rob", "establish",
					"overthrow", "support"));
	public static final Table NOUN = new SimpleTable("NPC motivation (noun)",
			List.of("wealth", "hardship", "affluence", "resources", "prosperity", "poverty", "opulence", "deprivation",
					"success", "distress", "contraband", "music", "literature", "technology", "alcohol", "medicines",
					"beauty", "strength", "intelligence", "force", "the wealthy", "the populous", "enemies",
					"the public", "religion", "the poor", "family", "the elite", "academia", "the forsaken", "the law",
					"the government", "the oppressed", "friends", "criminals", "allies", "secret societies",
					"the world", "military", "the church", "dreams", "discretion", "love", "freedom", "pain", "faith",
					"slavery", "enlightenment", "racism", "sensuality", "dissonance", "peace", "discrimination",
					"disbelief", "pleasure", "hate", "happiness", "servitude", "harmony", "justice", "gluttony", "lust",
					"envy", "greed", "laziness", "wrath", "pride", "purity", "moderation", "vigilance", "zeal",
					"composure", "charity", "modesty", "atrocities", "cowardice", "narcissism", "compassion", "valor",
					"patience", "advice", "propaganda", "science", "knowledge", "communications", "lies", "myths",
					"riddles", "stories", "legends", "industry", "new religions", "progress", "animals", "ghosts",
					"magic", "nature", "old religions", "expertise", "spirits"));
	public static final Motivation SINGLETON = new Motivation();

	static final int ROLLS = 3;

	Motivation() {
		super("NPC motivation");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var verbs = new ArrayList<String>(ROLLS);
		while (verbs.size() < ROLLS)
			verbs.add(VERB.roll());
		var nouns = new ArrayList<String>(ROLLS);
		while (nouns.size() < ROLLS) {
			var n = NOUN.roll();
			if (!nouns.contains(n))
				nouns.add(n);
		}
		var motivations = new ArrayList<String>(ROLLS);
		for (var i = 0; i < ROLLS; i++)
			motivations.add(verbs.get(i) + " " + nouns.get(i));
		return String.join(", ", motivations);
	}
}
