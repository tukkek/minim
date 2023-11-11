import * as table from './table.js'
import * as rpg from '../rpg.js'

const  WHO = new table.Table("Cyberpunk, enemy, who",
  ["Ex-friend", "Ex-lover", "Relative", "Childhood foe", "Subordinate", "Superior", "Colleague",
      "Gang member", "Corporate executive", "Government official"])
const  WHY = new table.Table("Cyberpunk, enemy, why",
  ["Hurt reputation", "Loss of someone important", "Embarassment", "Insult", "Physical injury",
      "Desertion or betrayal", "Turned down offer", "Didn't like each other", "Romantic competitor",
      "Foiled a plan"])

const DIRECTION = new table.Table("Cyberpunk, enemy, direction")
DIRECTION.add("They hate you",4);
DIRECTION.add("You hate them",7-5);
DIRECTION.add("Mutual hatred",10-8);

const  ENEMYACTION = new table.Table("Cyberpunk, enemy, what you gonna do?",
  ["Kill enemy", "Avoid enemy", "Backstab enemy", "Ignore enemy", "Humiliate enemy"])

const  FORCES = new table.Table("Cyberpunk, enemy, forces")
FORCES.add("Just himself",3);
FORCES.add("A few friends",5-4);
FORCES.add("A gang",7-6);
FORCES.add( "Small corporation");
FORCES.add( "Large corporation");
FORCES.add("Government agency");

class Enemy extends table.Table {
	 constructor() {
		super("Cyberpunk, enemy");
	}

	 roll() {
		let enemy = WHO.roll();
		enemy += "<br/>Why? " + WHY.roll();
		enemy += "<br/>" + DIRECTION.roll();
		enemy += "<br/>What you gonna do about it? " + ENEMYACTION.roll();
		enemy += "<br/>Enemy forces: " + FORCES.roll();
		return enemy;
	}
}

var enemy=new Enemy()

const  RANKING = new table.Table("Cyberpunk, family, ranking",
  ["Corporate executive", "Corporate manager", "Corporate technician", "Nomad pack", "Pirate fleet",
      "Gang", "Crime lord", "Warzone inhabitants", "Urban homeless", "Arcology"])
const  CHILDHOOD = new table.Table("Cyberpunk, family, childhood environment",
  ["Streets, unsupervised", "Corporate suburbs", "Nomad pack", "Once-upscale decaying neighborhood",
      "Defnded corporate zone", "Combat zone", "Village", "Arcology", "Pirates", "Farm",
      "Research facility"])
const  TRAGEDY = new table.Table("Cyberpunk, family, tragedy",
  ["Betrayed, lost everything", "Mismanaged, lost everything", "Exiled", "Imprisoned", "Vanished",
      "Dead", "Involed in conspiracy or organization", "Scattered by misfortune", "Feud", "Debt"])
const  NOPARENTS = new table.Table("Cyberpunk, family, something happened to your parents",
  ["Died in war", "Died in accident", "Murdered", "Amnesiacs", "Never met them", "In hiding",
      "Raised by relatives", "Never had parents", "Adopted", "They sold you"])


class Family extends table.Table {
	constructor() {
		super("Cyberpunk, family");
	}

	 roll() {
		let family = "Ranking: " + RANKING.roll();
		if (rpg.roll(1,10) >= 7)
			family += "<br/>Something happened to your parents: " + NOPARENTS.roll();
		if (rpg.roll(1,10) <= 6)
			family += "<br/>Tragedy: " + TRAGEDY.roll();
		family += "<br/>Childhood environment: " + CHILDHOOD.roll();
		let siblings = rpg.roll(1,10) - 3;
		if (siblings > 0)
			for (let i = 1; i <= siblings; i++) {
				family += "<br/>Sibling: " + sibling.roll();
			}
		return family;
	}
}

var family=new Family()

const ACTION = new table.Table("Cyberpunk, life events, what are you gonna do about it?",
    ["Clear your name;", "Forget it.", "Take tevenge.", "Get what's yours.", "Save everyone involved."])

class Disaster extends table.Table{
  constructor(){
    super("Cyberpunk, life events, disaster",
        ["Debt", "Imprisonment", "Illness", "Addiction", "Betrayal", "Accident",
        "Lover, friend or relative killed", "False accusation", "Hunted by the law",
        "Hunted by corporation", "Mental or physical incapacitation"])
  }
  
  roll() {
    return super.roll() + ". You're gonna " + ACTION.roll().toLowerCase();
  }
}

const DISASTER=new Disaster()

const LUCKY = new table.Table("Cyberpunk, life events, luck",
    ["Powerful connection", "Windfall", "Big score", "Found a mentor", "Found a sensei",
      "Friend in corporation", "Friend in nomad pack", "Friend in the police", "Friend in gang"])

const BIGPROBLEMSBIGWINS = new table.Table("Cyberpunk, life events, big-problems-big-wins",[DISASTER,LUCKY])

const FRIEND = new table.Table("Cyberpunk, life events, friend",
    ["Like an older sibling", "Like a younger sibling", "Mentor", "Colleague", "Past lover",
        "Past enemy", "Guardian", "Relative", "Past friend", "Through common interest"])
        
class FriendFoe extends table.Table{
  constructor(){
    super("Cyberpunk, life events, friend or foe")
  }
  
  roll(){
    this.lines=[]
    var gender = rpg.roll(1,10) % 2 == 0 ? "Male" : "Female";
    this.add(gender+" friend (" + FRIEND.roll().toLowerCase() + ")");
    this.add(gender+" foe: (roll table)");
    return super.roll()
  }
}

var friendfoe=new FriendFoe()

class LifeEvent extends table.Table {
	constructor() {
		super("Cyberpunk, life event");
		this.add(BIGPROBLEMSBIGWINS,3);
		this.add( friendfoe,6-4);
		this.add("Romance (roll table)");
		this.add("");
	}
}

const  ETHNICITY = new table.Table("Cyberpunk, ethnicity", ["Anglo-american", "African", "Asian",
  "East european / russian", "Polynesian", "Indian", "South american", "Hispanic", "European"])

class Lifepath extends table.Table {
	 constructor() {
		super("Cyberpunk, lifepath");
	}

	 roll() {
		let lifepath = style.roll();
		lifepath += "<br/>Ethnicity: " + ETHNICITY.roll();
		let age = 16 + rpg.roll(1,6) + rpg.roll(1,6);
		lifepath += "<br/>Age: " + age;
		lifepath += "<br/><br/>Family<br/>" + family.roll();
		lifepath += "<br/><br/>Motivation<br/>" + motivation.roll() + "<br/>";
		for (let year = 17; year <= age; year++) {
			let e = lifeevent.roll();
			if (e) lifepath += "<br/>Life event at " + year + ": " + e;
		}
		return lifepath;
	}
}

var lifeevent=new LifeEvent()
var lifepath=new Lifepath()

const PERSONALITY = new table.Table("Cyberpunk, motivation, personality",
  ["Shy and secretive", "Rebelious, antisocial, violent", "Arrogant, proud, aloof",
      "Moody, rash, headstrong", "Picky, fussy, nervous", "Stable, serious", "Silly", "Deceptive",
      "Intellectual, detached", "Friendly, outgoing"])
const  VALUED = new table.Table("Cyberpunk, motivation, valued person", ["Parent", "Sibling",
  "Lover", "Friend", "Yourself", "Pet", "Mentor", "Celebrity", "Personal hero", "No one"])
const  VALUES = new table.Table("Cyberpunk, motivation, values", ["Money", "Honor", "Trust",
  "Honesty", "Knowledge", "Vengeance", "Love", "Power", "Pleasure", "Friendship"])
const  RELATIONS = new table.Table("Cyberpunk, motivation, relations",
  ["Neutral", "Neutral", "Like everyone", "Hate everyone", "People are tools", "Everyone is valuable",
      "Can be obstacles to destroy", "People are not to be trusted", "Wipe everyone out",
      "People are wonderful"])
const  POSSESSION = new table.Table("Cyberpunk, motivation, possession", ["Weapon", "Tool",
  "Clothing", "Photo", "Book or diary", "Recording", "Instrument", "Jewelry", "Toy", "Letter"])
      
class Motivation extends table.Table {
	constructor() {
		super("Cyberpunk, motivation");
	}

	 roll() {
		let motivations = "Personality: " + PERSONALITY.roll();
		motivations += "<br/>Valued person: " + VALUED.roll();
		motivations += "<br/>Values: " + VALUES.roll();
		motivations += "<br/>Relations: " + RELATIONS.roll();
		motivations += "<br/>Possession: " + POSSESSION.roll();
		return motivations;
	}
}

var motivation=new Motivation()

const TRAGIC = new table.Table("Cyberpunk, romance, tragic",
    ["Died accidently", "Vanished", "Didn't work out", "Goal or vendetta came in-between", "Kidnapped",
        "Insanity", "Suicide", "Left for another", "Imrposned or exiled"])
const ROMANCEFEELINGS = new table.Table("Cyberpunk, romance, residual feelings",
    ["They love you", "You love them", "You still love each other", "You hate them", "They hate you",
        "You hate each other", "You're friends now", "It's over for both of you",
        "You like them, they hate you", "You hate them, they like you"])

class Problematic extends table.Table{
  constructor(){
    super("Cyberpunk, romance, problematic",
    ["Their friends/family hate you", "Their friends/family want to get rid of you",
        "Your family/friends hate your lover", "One of you has a romantic rival",
        "You are somehow separated", "Constant fights", "You two compete professionaly", "Jealousy",
        "One of you has an affair(s)", "Conflicting backgrounds"])
  }
  
  roll() {
    return super.roll() + ". " + ROMANCEFEELINGS.roll();
  }
}

var problematic=new Problematic()

class Romance extends table.Table {
	 constructor() {
		super("Cyberpunk, romance");
	}

	 roll() {
    this.lines=[]
		this.add("Happy love affair",4);
		this.add( TRAGIC.roll());
		this.add(problematic.roll(),1);
		this.add("Affairs and hot dates",10-8);
    return super.roll()
	}
}

var romance=new Romance()

const  GENDER = new table.Table("Cyberpunk, sibling, gender", ["brother", "sister"])

const  AGE = new table.Table("Cyberpunk, sibling, age") 
AGE.add( "Younger",5);
AGE.add( "Older",9-6);
AGE.add("Twin");

const  FEELINGS = new table.Table("Cyberpunk, sibling, feelings",
  ["dislikes you", "likes you", "neutral", "hates you", "adores you"])

class Sibling extends table.Table {
	constructor() {
		super("Cyberpunk, sibling");
	}

	 roll() {
		return AGE.roll() + " " + GENDER.roll() + " " + FEELINGS.roll();
	}
}

var sibling=new Sibling()

const  CLOTHES = new table.Table("Cyberpunk, style, clothes", ["Leather", "Jeans", "Suit",
  "Jumpsuit", "Miniskirt", "Fashionable", "Camouflage", "Casual", "Nude", "X-large"])
const  HAIR = new table.Table("Cyberpunk, style, hair", ["Mohawk", "Long (ratty)", "Spiked", "Wild",
  "Bald", "Striped", "Tinted", "Neat", "Curly", "Long (straight)"])
const  AFFECTATION = new table.Table("Cyberpunk, style, affectation", ["Tatoos", "Mirrorshades",
  "Scarification", "Gloves", "Piercing", "Earring", "Fingernails", "Boots", "Contact lens"])

class Style extends table.Table {
	constructor() {
		super("Cyberpunk, style");
	}

	 roll() {
		let style = "Clothes: " + CLOTHES.roll();
		style += "<br/>Hair: " + HAIR.roll();
		style += "<br/>Affectation: " + AFFECTATION.roll();
		return style;
	}
}

var style=new Style()

export var tables=[WHO,WHY]
  .concat([DIRECTION,ENEMYACTION,FORCES,enemy])
  .concat([RANKING,CHILDHOOD,TRAGEDY,NOPARENTS,family])
  .concat([ACTION,DISASTER,LUCKY,BIGPROBLEMSBIGWINS,FRIEND])
  .concat([lifepath,ETHNICITY,lifeevent])
  .concat([PERSONALITY,VALUED,VALUES,RELATIONS,POSSESSION,motivation])
  .concat([TRAGIC,ROMANCEFEELINGS,problematic,romance])
  .concat([GENDER,AGE,FEELINGS,sibling])
  .concat([CLOTHES,HAIR,AFFECTATION,style])
  
