import * as table from './table.js'
import * as rpg from '../rpg.js'

 class ArcedWaylay extends table.Table {
	 constructor() {
		super("Bold, arced waylay");
	}

	 roll() {
		var arc = "Theme: " + waylay.roll(false);
		arc += "<br/><br/>Exposition: " + waylay.roll();
		arc += "<br/><br/>Rising action and conflict: " + waylay.roll();
		arc += "<br/><br/>Climax :" + waylay.roll();
		return arc;
	}
}

const ACTION = new table.Table("Bold, connection, action",
["proclaim", "protest", "resolve", "interject", "demand", "impart", "commend", "muse", "examine",
    "digress", "assure", "reminisce", "ponder", "scrutinize", "address", "deceive", "negotiate",
    "guide", "endorse", "speculate"])
const GERUND = new table.Table("Bold, connection, gerund",
["exposing", "weakening", "divulging", "lying", "confronting", "detailing", "avoiding", "working",
    "negating", "preparing", "training", "enjoying", "discussing", "obsessing", "repairing",
    "improving", "understanding", "connecting", "concluding", "excluding"])
const SUBJECT = new table.Table("Bold, connection, subject",
["a dislike", "an attribute", "a desire", "friends or family", "an annoyance", "a skill", "a fear",
    "wealth", "home or hearth", "an ability", "a decision", "a love", "personal qualities",
    "your nature", "a like", "enemies", "party member", "a core belief", "a possession", "allies"])



const ROWS = 3;
 class Connection extends table.Table {
	 constructor() {
		super("Bold, connections table");
	}

	pick(table) {
		let list = [];
		while (list.length < ROWS) {
			let line = table.roll();
			if (!list.includes(line))
				list.push(line);
		}
		let pad = list.map(l => l.length).reduce((a, b) => a>b?a:b)
		for (let i = 0; i < list.length; i++) {
			let l = list[i]
			while (l.length < pad)
				l += " ";
			list[i]=l
		}
		return list;
	}

	 roll() {
		let table = "";
		let actions = this.pick(ACTION);
		let gerund = this.pick(GERUND);
		let subject = this.pick(SUBJECT);
		for (let i = 0; i < ROWS; i++)
			table += actions[i] + " | " + gerund[i] + " | " + subject[i] + "<br/>";
		return table;
	}
}

var connection=new Connection()


const EASYFOES = new table.Table("Bold, arced waylay, waylay, easy foes",
  ["Animals", "Mooks", "Mob", "Bandits", "Deputies"])
const HARDFOES = new table.Table("Bold, arced waylay, waylay, hard foes",
  ["Bounty hunter", "Soldiers", "Monster", "Villain", "Horror"])
const KNOWLEDGE = new table.Table("Bold, arced waylay, waylay, knowledge",
  ["Ascetic", "Research", "Occult", "Enigma", "Science"])
const PHYSICAL = new table.Table("Bold, arced waylay, waylay, physical",
  ["Pursuit", "Trap", "Struggle", "Illness", "Labor"])
const FACTIONAL = new table.Table("Bold, arced waylay, waylay, factional",
  ["Army", "Invader", "Holdings", "Authority", "Rebels"])
const HAVEN = new table.Table("Bold, arced waylay, waylay, haven",
  ["Festival", "Hermit", "Tavern", "Hamlet", "Conclave"])
const PARTY = new table.Table("Bold, arced waylay, waylay, party",
  ["Misunderstanding", "Accusations", "Power play", "Friend-in-need", "Disappearance"])
const PERSONAL = new table.Table("Bold, arced waylay, waylay, personal",
  ["Traitor", "Lover", "Death", "Relative", "Rival"])
const EPIC = new table.Table("Bold, arced waylay, waylay, epic",
  ["Heaven / hell", "Afterlife", "Myth", "Otherworldly", "The strange"])
const NATURAL = new table.Table("Bold, arced waylay, waylay, natural",
  ["Weather", "Straying / lost", "Social environ", "Deprivation", "The wild"])
const MODIFIER = new table.Table("Bold, arced waylay, waylay, modifier",
  ["futile", "impassioned", "hesitant", "benign", "revered", "pedantic", "grim", "common", "bitter",
      "impassioned", "perceiving", "selfish", "prohibited", "brusque", "prosperous", "depraved",
      "comforting", "hopeless", "waning", "regimental", "harsh", "leeching", "tranquil", "inclusive",
      "righteous", "attentive", "inexplicable", "corrupt", "roaring", "unmistakable", "sudden",
      "impending", "fragile", "painless", "haphazard", "foreign", "ravenous", "adept", "barbaric",
      "disputable", "binding", "noble", "copious", "retired", "provoking", "ordinary", "prolonged",
      "deceiving", "savage", "drowsy", "mundane", "abrupt", "unforeseen", "peaceful", "steady",
      "abetting", "stale", "regular", "dubious", "exclusive", "unreliable", "altruistic", "storied",
      "tapped", "tedious", "quiet", "exotic", "impervious", "fledgling", "fixated", "illuminating",
      "exhausting", "honorable", "exclusive", "apparent", "valuable", "haunting", "migrant", "pleasant",
      "incompetent", "abnormal", "abstract", "irritating", "hidden", "hallowed", "illusory", "legendary",
      "prolonged", "meek", "proficient", "forbidden", "fantastic", "accidental", "malevolent", "unlikely",
      "problematic", "eccentric", "lethargic", "amusing", "afflicting"])

class Solution extends table.Table{
  constructor(){
    super("Bold, arced waylay, waylay, solution",[false,"legendary help", "act of nature", "the people", "enemy help", "avoidance",
					"scarce-used ability", "personal resources", "close friend", "strong attribute", "favored ability",
					"favored skill", "on accident", "weak attribute", "counteraction", "faction intervention",
					"the authority", "fate", "change of heart", "deus ex"])
  }
  
  roll(){
    return this.lines[rpg.roll(1,10) + rpg.roll(1,10)]
  }
}

var solution=new Solution()

class Waylay extends table.Table {
	constructor() {
		super("Bold, arced waylay, waylay",[EASYFOES, HARDFOES, KNOWLEDGE, PHYSICAL, FACTIONAL, HAVEN, PARTY, PERSONAL, EPIC, NATURAL]);
	}

  roll(solutionp=true) {
		let waylay = super.roll() + ".";
		waylay += "<br/>Modifier: " + MODIFIER.roll() + ".";
		if (solutionp)
			waylay += "<br/>Solution: " + solution.roll() + ".";
		return waylay;
	}
}

export var waylay=new Waylay()


export var tables=[new ArcedWaylay()]
  .concat([ACTION,GERUND,SUBJECT])
  .concat([connection])
  .concat([EASYFOES,HARDFOES,KNOWLEDGE,PHYSICAL,FACTIONAL,HAVEN,PARTY,PERSONAL,EPIC,NATURAL,MODIFIER])
  .concat([solution,waylay])

