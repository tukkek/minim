package minim.controller.table.une;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Npc extends Table {
	public static final Table MODIFIER = new SimpleTable("NPC generator (modifier)",
			List.of("superfluous", "addicted", "conformist", "nefarious", "sensible", "untrained", "romantic",
					"unreasonable", "skilled", "neglectful", "lively", "forthright", "idealistic", "unsupportive",
					"rational", "coarse", "foolish", "cunning", "delightful", "miserly", "inept", "banal", "logical",
					"subtle", "reputable", "wicked", "lazy", "pessimistic", "solemn", "habitual", "meek", "helpful",
					"unconcerned", "generous", "docile", "cheery", "pragmatic", "serene", "thoughtful", "hopeless",
					"pleasant", "insensitive", "titled", "inexperienced", "prying", "oblivious", "refined",
					"indispensable", "scholarly", "conservative", "uncouth", "willful", "indifferent", "fickle",
					"elderly", "sinful", "naive", "privileged", "glum", "likable", "lethargic", "defiant", "obnoxious",
					"insightful", "tactless", "fanatic", "plebeian", "childish", "pious", "uneducated", "inconsiderate",
					"cultured", "revolting", "curious", "touchy", "needy", "dignified", "pushy", "kind", "corrupt",
					"jovial", "shrewd", "liberal", "compliant", "destitute", "conniving", "careful", "alluring",
					"defective", "optimistic", "affluent", "despondent", "mindless", "passionate", "devoted",
					"established", "unseemly", "dependable", "righteous", "confident"));
	public static final Table NOUN = new SimpleTable("NPC generator (noun)",
			List.of("gypsy", "witch", "merchant", "expert", "commoner", "judge", "ranger", "occultist", "reverend",
					"thug", "drifter", "journeyman", "statesman", "astrologer", "duelist", "jack-of-all-trades",
					"aristocrat", "preacher", "artisan", "rogue", "missionary", "outcast", "mercenary", "caretaker",
					"hermit", "orator", "chieftain", "pioneer", "burglar", "vicar", "officer", "explorer", "warden",
					"outlaw", "adept", "bum", "sorcerer", "laborer", "master", "ascendant", "villager", "magus",
					"conscript", "worker", "actor", "herald", "highwayman", "fortune-hunter", "governor", "scrapper",
					"monk", "homemaker", "recluse", "steward", "polymath", "magician", "traveler", "vagrant",
					"apprentice", "politician", "mediator", "crook", "civilian", "activist", "hero", "champion",
					"cleric", "slave", "gunman", "clairvoyant", "patriarch", "shopkeeper", "crone", "adventurer",
					"soldier", "entertainer", "craftsman", "scientist", "ascetic", "superior", "performer", "magister",
					"serf", "brute", "inquisitor", "lord", "villain", "professor", "servant", "charmer", "globetrotter",
					"sniper", "courtier", "priest", "tradesman", "hitman", "wizard", "beggar", "tradesman", "warrior"

			));

	public Npc() {
		super("NPC generator");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var npc = "Concept: " + MODIFIER.roll() + " " + NOUN.roll() + ".";
		npc += "\nPower level: " + PowerLevel.SINGLETON.roll() + ".";
		npc += "\nMotivations: " + Motivation.SINGLETON.roll() + ".";
		npc += "\nImportance: " + Importance.SINGLETON.roll() + ".";
		var mood = List.of(Mood.FRIENDLY, Mood.NEUTRAL, Mood.HOSTILE).get(Character.roll(3) - 1);
		npc += "\n" + mood + ": " + mood.roll() + ".";
		return npc;
	}
}
