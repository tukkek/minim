import * as table from '../table.js'
import * as rpg from '../../rpg.js'

export var tables=[]

class BadGuy extends table.Table {
	constructor() {
		super("Adventure, cartoon, bad guy");
		this.add("mobster with tough guy");
		this.add("Foogle");
		this.add("spy");
		this.add("mastermind");
		this.add("witch");
		this.add("monster");
	}
}

const BADGUY=new BadGuy()

const OBJECT=new table.Table("Adventure, cartoon, object",["One of the other characters", "Steamroler", "Bucket of water", "oil can", "lit light bulb",
				"bagpipes", "toupee", "elephant", "charging bull", "spaceship", "boy choir", "safety pin", "tuba",
				"broom", "rope", "ostrich", "jack-in-the-box", "cannon", "magnifying glass", "cigar", "pie", "banana",
				"bow tie", "spring", "revolving door", "needle and thread", "propellor beanie", "seltzer bottle",
				"fake moustache", "sail boat", "penguin", "butterfly", "boxing gloves", "confetti",
				"character's clone"])
const MOTIVE=new table.Table("Adventure, cartoon, motive")
MOTIVE.add("money");
MOTIVE.add("fame");
MOTIVE.add("fun");
MOTIVE.add("love");
MOTIVE.add("food");
MOTIVE.add("all of the above");

tables.push(...[BADGUY,OBJECT,MOTIVE])

const THECITY = new table.Table("Adventure, cartoon, location, the city",
    ["construction site", "subway station", "subway tunnel", "sewer", "rush-hour traffic jam",
        "sumphony hall", "opera house", "department store", "grocery store", "bakery", "bank", "city hall",
        "restaurant", "jewelry store", "warehouse", "gas station", "laundromat", "museum", "record store",
        "bar", "post office", "hospital", "sporting goods store", "hardware store", "car dealer", "hotel",
        "skyscraper", "beauty parlor", "florist", "zoo", "robot factory", "bookstore", "dentist's office",
        "bowling alley", "television station"]);
const OUTERSPACE = new table.Table("Adventure, cartoon, location, outer space",
    ["moon", "mars", "planet eclair", "planer prune", "saturn's rings", "milky way",
        "space station zero", "edge of the universe", "black hole", "anti-matter universe",
        "galactic dust cloud", "planet of deadly ducks", "outer-space hardware store",
        "outer-space carnival", "outer-space zoo", "orbital robot factory", "green martian convention",
        "living, intelligent planet", "spaceport", "tiny spaceship", "huge spaceship", "haunted spaceship",
        "asteroid field", "sun", "meteor shower", "time warp", "martian slave world",
        "light-gravity planet", "heavy-gravity planet", "swamps of venus", "planet of giant everything",
        "planet of teeny-tiny things", "anti-matter universe", "gas cloud", "lightning gas cloud",
        "black hole", "non-green martian convention"]);
const OUTSIDEOFTOWN = new table.Table("Adventure, cartoon, location, outside of town",
    ["The stone age", "Arthurian england", "Rocket base", "Farm", "Haunted house", "Atlantis",
        "Ali Baba's cave", "desert south sea island (with cannibals)", "sherwood forest", "transylvania",
        "darkest africa", "lighest africa", "sahara desert", "oil well", "indian reservation", "airport",
        "railroad station", "blacksmith", "middle of the ocean", "north pole", "asia", "movie studio",
        "pirate cove", "pirate ship", "cave", "old west", "diamond mine", "ranch", "insane asylum",
        "army base", "bridge", "center of the earth", "hell", "national park", "fort", "alpha complex",
        "tv station", "real world"]);
const ANYTOWN = new table.Table("Adventure, cartoon, location, Anytown",
    ["Jail", "Bank", "General store", "Bakery", "library", "costume shop", "grocery store", "city hall",
        "hotel", "restaurant", "doctor's office", "pet store", "stable", "barber shop", "railroad station",
        "bar", "gas station", "blacksmith", "school", "post office", "dentist's office", "diner",
        "pool hall", "park", "gold course", "construction site", "opera house", "football stadium",
        "baseball park", "museum", "zoo", "scientist's laboratory", "mad scientist's laboratory",
        "thug's hideout", "ace mail-order company warehouse", OUTSIDEOFTOWN])

const LOCATION=new table.Table("Adventure, cartoon, location",[ANYTOWN,THECITY,OUTERSPACE,OUTSIDEOFTOWN])

tables.push(...LOCATION.lines.concat([LOCATION]))

class Character extends table.Table {
	constructor() {
		super("Adventure, cartoon, character");
		this.add("themselves");
		this.add("daughter");
		this.add("son");
		this.add("Professor");
		this.add("Granny");
		this.add("boss");
	}
}
var character=new Character()

tables.push(character)

var mysterysecret=new table.Table('Adventure, cartoon, mystery, secret')
mysterysecret.add("location is plagued by Species");
mysterysecret.add("object is cursed", 3);
mysterysecret.add("object has monstrous guardian", 4);
mysterysecret.add("villain has cartoony thing of your choice");
        
class Mystery extends table.Table{
  constructor(){
    super("Adventure, cartoon, mystery")
  }

  roll() {
    let c = character.roll();
    let location = LOCATION.roll();
    let object = OBJECT.roll();
    let badguy = BADGUY.roll();
    let secret = mysterysecret.roll();
    return "Players sent by " + c + " to investigate " + location + " and find " + object + " before "+ badguy + " does.<br/>" + secret
  }
};
var mystery=new Mystery()
tables.push(...[mysterysecret,mystery])

var objectsecret = new table.Table("Adventure, cartoon, situation, theft, secret, object",
  ["changed into another object", "changed into a trap", "changed into a living thing",
          "hidden", "occupied by species", "eating by species"])

class Secret extends table.Table{
  constructor(){
    super("Adventure, cartoon, situation, theft, secret")
    this.add("<br/>Object has been " + objectsecret.roll());
    this.add("<br/>Object is held by " + BADGUY.roll());
    this.add("<br/>" + this.lines.join(". "));
    this.add("");
  }
}

let secret = new Secret()

class Theft extends table.Table{
  constructor(){
    super("Adventure, cartoon, situation, theft")
  }
  
  roll() {
    let location = LOCATION.roll();
    let object = OBJECT.roll();
    let motive = MOTIVE.roll();
    return "Players go to " + location + " to steal " + object + " thereby gaining " + motive + "." + secret.roll()
  }
}

var theft=new Theft()
tables.push(...[objectsecret,secret,theft])

var chasesecret=new table.Table("Adventure, cartoon, situation, chase, secret")
chasesecret.add("villain has multiple personalities");
chasesecret.add("villain has strange companion or familiar");
chasesecret.add("location changes from scene to scene");
chasesecret.add("object is really strange");
rpg.shuffle(chasesecret.lines);
chasesecret.add(chasesecret.lines.slice(0, rpg.roll(1,chasesecret.lines.length-1)).join(" "));

class Chase extends table.Table{
  constructor(){
    super("Adventure, cartoon, situation, chase")
  }
  
  roll() {
    let badguy = BADGUY.roll();
    let location = LOCATION.roll();
    let object = OBJECT.roll();
    let character = rpg.roll(1,6);
    let secret = chasesecret.roll();
    return "Players chase " + badguy + " to " + location + " to get " + object + " for " + character + ".<br/>"+ secret
  }
}

var chase=new Chase()
tables.push(...[chasesecret,chase])

var over=new table.Table("Adventure, cartoon, situation, battle, over",["ownership of location" , "possession of " + OBJECT,
            "competing business", "personal feud",
            "relationship with " + character,
            "desire for " + MOTIVE.roll()])

class Battle extends table.Table{
  constructor(){
    super("Adventure, cartoon, situation, battle")
  }

  roll() {
    let badguy = BADGUY.roll();
    let location = LOCATION.roll();
    let o =  over.roll()
    return "Players fight " + badguy + " in " + location + " over " + o
  }
};

var battle=new Battle()
tables.push(...[over,battle])

var rescuesecret=new table.Table("Adventure, cartoon, rescue, secret")
rescuesecret.add("<br/>rescuee doesn't want to be rescued");
rescuesecret.add("<br/>rescuee owns location");
rescuesecret.add("<br/>rescuee is another villain");
rescuesecret.add("<br/>rescuee is actually holding villain hostage");
rescuesecret.add("");

class Rescue extends table.Table{
  constructor(){
    super("Adventure, cartoon, rescue")
  }

  roll() {
    var c = character.roll();
    var badguy = BADGUY.roll();
    var location = LOCATION.roll();
    var secret =  rescuesecret.roll();
    return "Players must rescue " + c + " held by " + badguy + " in " + location + "." + secret
  }
};

var rescue=new Rescue()
tables.push(...[rescuesecret,rescue])

var goal = new table.Table("Adventure, cartoon, survival, goal", ["survive", "get home"])

class Survival extends table.Table{
  constructor(){
    super("Adventure, cartoon, survival")
  }

  roll() {
    var location = LOCATION.roll();
    var badguy = BADGUY.roll();
    var secret = ""
    if(rpg.roll(1,2)==2)
      secret="<br/>" + badguy + " wants " + OBJECT.roll() + " in player's posession"
    return "Players trapped in a " + location + " are bothered by " + badguy + " as they attempt to " + goal + "." + secret
  }
};

var survival=new Survival()
tables.push(...[goal,survival])

class CartoonAdventure extends table.Table {
	constructor() {
		super("Adventure, cartoon");
	}

	roll() {
		let die = rpg.roll(1,6);
		if (die == 1)
			return survival.roll();
		if (die == 2)
			return rescue.roll();
		if (die == 3)
			return battle.roll();
		if (die == 4)
			return chase.roll();
		if (die == 5)
			return theft.roll();
		return mystery.roll();
	}
}

export var adventure=new CartoonAdventure()
tables.push(adventure)
