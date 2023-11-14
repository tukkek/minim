import * as table from './table.js'
import * as rpg from '../rpg.js'

export var tables=[]

const VERB = new table.Table("UNE, character, motivation, verb",
  ["advise", "obtain", "attempt", "spoil", "oppress", "interact", "create", "abduct", "promote",
      "conceive", "blight", "progress", "distress", "possess", "record", "embrace", "contact", "pursue",
      "associate", "prepare", "shepherd", "abuse", "indulge", "chronicle", "fulfill", "drive", "review",
      "aid", "follow", "advance", "guard", "conquer", "hinder", "plunder", "construct", "encourage",
      "agonize", "comprehend", "administer", "relate", "take", "discover", "deter", "acquire", "damage",
      "ize", "burden", "advocate", "implement", "understand", "collaborate", "strive", "complete",
      "compel", "join", "assist", "defile", "produce", "institute", "account", "work", "accompany",
      "offend", "guide", "learn", "persecute", "communicate", "process", "report", "develop", "steal",
      "suggest", "weaken", "achieve", "secure", "inform", "patronize", "depress", "determine", "seek",
      "manage", "suppress", "proclaim", "operate", "access", "refine", "compose", "undermine", "explain",
      "discourage", "attend", "detect", "execute", "maintain", "realize", "convey", "rob", "establish",
      "overthrow", "support"]);
const MOTIVATIONNOUN = new table.Table("UNE, character, motivation, noun",
  ["wealth", "hardship", "affluence", "resources", "prosperity", "poverty", "opulence", "deprivation",
      "success", "distress", "contraband", "music", "literature", "technology", "alcohol", "medicines",
      "beauty", "strength", "intelligence", "force", "the wealthy", "the populous", "enemies",
      "the ", "religion", "the poor", "family", "the elite", "academia", "the forsaken", "the law",
      "the government", "the oppressed", "friends", "criminals", "allies", "secret societies",
      "the world", "military", "the church", "dreams", "discretion", "love", "freedom", "pain", "faith",
      "slavery", "enlightenment", "racism", "sensuality", "dissonance", "peace", "discrimination",
      "disbelief", "pleasure", "hate", "happiness", "servitude", "harmony", "justice", "gluttony", "lust",
      "envy", "greed", "laziness", "wrath", "pride", "purity", "moderation", "vigilance", "zeal",
      "composure", "charity", "modesty", "atrocities", "cowardice", "narcissism", "compassion", "valor",
      "patience", "advice", "propaganda", "science", "knowledge", "communications", "lies", "myths",
      "riddles", "stories", "legends", "industry", "new religions", "progress", "animals", "ghosts",
      "magic", "nature", "old religions", "expertise", "spirits"]);

const ROLLS = 3;

class Motivation extends table.Table {
	constructor() {
		super("UNE, character, motivation");
	}

  roll() {
		let verbs = []
		while (verbs.length < ROLLS)
			verbs.push(VERB.roll());
		let nouns = []
		while (nouns.length < ROLLS) {
			let n = MOTIVATIONNOUN.roll();
			if (!nouns.includes(n))
				nouns.push(n);
		}
		let motivations = []
		for (let i = 0; i < ROLLS; i++)
			motivations.push(verbs[i] + " " + nouns[i]);
		return motivations.join(", ");
	}
}
var motivation=new Motivation()
tables.push(...[motivation,VERB,MOTIVATIONNOUN])

class PowerLevel extends table.Table {
	constructor() {
		super("UNE, character, power level");
		this.add("much weaker",4);
		this.add( "weaker",20);
		this.add( "comparable",60);
		this.add( "stronger",10);
		this.add( "much stronger");
	}
}
var powerlevel=new PowerLevel()
tables.push(powerlevel)

const FRIENDLY = new table.Table("UNE, character, mood, friendly") 
FRIENDLY.add("hostile",8);
FRIENDLY.add( "cautious",20);
FRIENDLY.add( "neutral",20);
FRIENDLY.add( "sociable",30);
FRIENDLY.add( "friendly",30);
const NEUTRAL = new table.Table("UNE, character, mood, neutral") 
NEUTRAL.add( "hostile",10);
NEUTRAL.add( "cautious",20);
NEUTRAL.add( "neutral",30);
NEUTRAL.add("sociable",20);
NEUTRAL.add("friendly",20);
const HOSTILE = new table.Table("UNE, character, mood, hostile") 
HOSTILE.add("hostile",20);
HOSTILE.add("cautious",40);
HOSTILE.add("neutral",20);
HOSTILE.add("sociable",10);
HOSTILE.add("friendly",10);
tables.push(...[FRIENDLY,NEUTRAL,HOSTILE])

const DEMEANOR = new table.Table("UNE, character, importance, demeanor",
    ["scheming", "insane", "friendly", "hostile", "inquisitive", "knowing", "mysterious", "prejudiced"])
const BEARINGS = new Map([
  ["scheming", new table.Table("UNE, character, importance, NPC bearing, scheming", ["intent", "bargain", "means",
      "proposition", "plan", "compromise", "agenda", "arrangement", "negotiation", "plot"])],
  ["insane", new table.Table("UNE, character, importance, NPC bearing, insane", ["madness", "fear", "accident", "chaos",
      "idiocy", "illusion", "turmoil", "confusion", "façade", "bewilderment"])],
  ["friendly", new table.Table("UNE, character, importance, NPC bearing, friendly", ["alliance", "comfort", "gratitude",
      "shelter", "happiness", "support", "promise", "delight", "aid", "celebration"])],
  ["hostile", new table.Table("UNE, character, importance, NPC bearing, hostile", ["death", "capture", "judgment",
      "combat", "surrender", "rage", "resentment", "submission", "injury", "destruction"])],
  ["inquisitive", new table.Table("UNE, character, importance, NPC bearing, inquisitive", ["questions", "investigation",
      "interest", "demand", "suspicion", "request", "curiosity", "skepticism", "command", "petition"])],
  ["knowing", new table.Table("UNE, character, importance, NPC bearing, knowing", ["report", "effects", "examination",
      "records", "account", "news", "history", "telling", "discourse", "speech"])],
  ["mysterious", new table.Table("UNE, character, importance, NPC bearing, mysterious", ["rumor", "uncertainty",
      "secrets", "misdirection", "whispers", "lies", "shadows", "enigma", "obscurity", "conundrum"])],
  ["prejudiced", new table.Table("UNE, character, importance, NPC bearing, prejudiced", ["reputation", "doubt", "bias",
      "dislike", "partiality", "belief", "view", "discrimination", "assessment", "difference"])]
])

const FOCUS = new table.Table("UNE, character, importance, focus",
    ["current scene", "parents", "wealth", "skills", "campaign", "allies", "flaws", "experience",
        "community", "current story", "weapons", "last story", "history", "relics", "superiors",
        "future action", "last scene", "antagonist", "knowledge", "treasure", "family", "previous scene",
        "equipment", "retainers", "last action", "fame", "friends", "contacts", "rewards", "recent scene",
        "the character", "power", "enemy"])

 class Importance extends table.Table {
	constructor() {
		super("UNE, character, importance");
	}

	roll() {
		let demeanor = DEMEANOR.roll();
		let bearing = BEARINGS.get(demeanor).roll();
		let focus = FOCUS.roll();
		return "The " + demeanor + " NPC speaks of " + bearing + " regarding " + focus;
	}
}
var importance=new Importance()
tables.push(...[DEMEANOR,FOCUS,importance].concat(Array.from(BEARINGS.values())))

const MODIFIER = new table.Table("UNE, character, modifier",
["superfluous", "addicted", "conformist", "nefarious", "sensible", "untrained", "romantic",
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
    "established", "unseemly", "dependable", "righteous", "confident"]);
const NOUN = new table.Table("UNE, character, noun",
["gypsy", "witch", "merchant", "expert", "commoner", "judge", "ranger", "occultist", "reverend",
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
]);
 
class Npc extends table.Table {
	 constructor() {
		super("UNE, character");
	}

  roll() {
		let npc = "Concept: " + MODIFIER.roll() + " " + NOUN.roll() + ".";
		npc += "<br/>Power level: " + powerlevel.roll() + ".";
		npc += "<br/>Motivations: " + motivation.roll() + ".";
		npc += "<br/>Importance: " + importance.roll() + ".";
		let mood = [FRIENDLY, NEUTRAL, HOSTILE][rpg.roll(1,3) - 1];
		npc += "<br/>Mood: " + mood.roll() + ".";
		return npc;
	}
}
var npc=new Npc()
tables.push(...[MODIFIER,NOUN,npc])
