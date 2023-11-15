import * as table from './table.js'
import * as rpg from '../rpg.js'
import * as unit from '../../model/unit.js'

export var tables=[]

const ETHEREAL = "Ethereal";
const CORPOREA = "Corporeal";
const CELESTIAL = "Celestial";
const TYPE = new table.Table("In Nomine, character, song, type", [CELESTIAL, CORPOREA, ETHEREAL])
const TONGUES = "Tongues";
const THUNDER = "Thunder";
const SHIELDS = "Shields";
const PROJECTION = "Projection";
const POSSESSION = "Possession";
const CORPUS = "Numinous Corpus";
const MOTION = "Motion";
const LIGHT = "Light";
const HEALING = "Healing";
const HARMONY = "Harmony";
const FORM = "Form";
const ENTROPY = "Entropy";
const DREAMS = "Dreams";
const CHARM = "Charm";
const ATTRACTION = "Attraction";
const AFFINITY = "Affinity";
const SONGS = [AFFINITY, ATTRACTION, CHARM, DREAMS, ENTROPY, FORM, HARMONY,
  HEALING, LIGHT, MOTION, CORPUS, POSSESSION, PROJECTION, SHIELDS, THUNDER, TONGUES]

class Song extends table.Table {
	 constructor(songs, types=TYPE.lines) {
		super("In Nomine, character, song");
		for (let s of songs)
			for (let t of types)
				this.add(t + " " + s.toLowerCase())
	}

	 roll(amount=false) {
     if(!amount) return super.roll()
		if (this.lines.length==0)
			roll();
		if (amount > this.lines.length)
			throw "Too few songs!"
		let songs = new Set()
		while (songs.length < amount) {
			songs.add(this.roll())
		}
		return songs;
	}
}

var song=new Song(SONGS)

const DISCORDTYPE = new table.Table("In Nomine, character, discord, type",
    ["Celestial discord", "Etherial discord", "Corporeal discord"])
const YES = "Yes";
class Discord extends table.Table {
	constructor() {
		super("In Nomine, character, discord");
		this.add(YES, 1);
		this.add("None", 300);
	}

	roll() {
		let r = super.roll();
		return r == YES ? DISCORDTYPE.roll() : r;
	}
}

var discord=new Discord()
tables.push(...[TYPE,DISCORDTYPE,discord])

const STATUS = new table.Table("In Nomine, character, role, status")
STATUS.add("Very low", 2);
STATUS.add("Low", 4);
STATUS.add("Average", 8);
STATUS.add("High", 4);
STATUS.add("Very high", 2);
STATUS.add("Extremey high", 1);
const FAME = new table.Table("In Nomine, character, role, fame") 
FAME.add("Nobody", 20);
FAME.add("Small group", 8);
FAME.add("Large group", 4);
FAME.add("Almost everyone", 2);
FAME.add("Everyone", 1);

class Role extends table.Table {
	 constructor() {
		super("In Nomine, character, role");
	}

	 roll() {
		return `${STATUS.roll().toLowerCase()} status, famous to ${FAME.roll().toLowerCase()}`
	}
}

var role=new Role()
tables.push(...[STATUS,FAME,role])


class Character extends table.Table {
  constructor(title, forces,s=song) {
    super(title);
    this.forces = forces;
    this.songs = s;
  }

  define(){throw 'unimplemented'}

  roll() {
    let l = [];
    this.define(l);
    l.push("Role: "+ role);
    if (rpg.roll(1,10) == 10)
      l.push(discord.roll())
    l.push(...this.songs.roll(1,this.forces - 5))
    return l.join('<br/>')
  }
}

class Soldier extends Character {
	constructor(type) {
		super(`In Nomine, character, ${type.toLowerCase()}`, 6, new Song(SONGS, [CORPOREA]))
		this.type = type;
	}
	
	define(l) {
		l.push(this.type);
	}
}

class Reliever extends Character {
	constructor() {
		super("In Nomine, character, reliever", 7);
	}

	define(l) {
		l.push("Reliever");
	}
}

const CHOIR = new table.Table("In Nomine, character, angel, choir",
  ["Seraphim (most-holy)", "Cherubim (guardians)", "Ofanim (wheels)", "Elohim (powers)",
      "Malakim (virtues)", "Kyriotates (dominations)", "Mercurians (friends-of-man)"])

const PLEDGE = new Reliever();
PLEDGE.forces = 9;

tables.push(...[CHOIR,PLEDGE,song])

function pledge(die) {
  let pledges = 0;
  while (rpg.roll(1,2) == 1) {
    pledges += rpg.roll(1,die);
  }
  return pledges;
}

class Angel extends Character {
	constructor() {
		super("In Nomine, character, angel", 9);
	}

	
  define(l) {
		l.push("Angel");
		l.push("Choir: "+CHOIR);
	}

  roll() {
		let r = super.roll();
		for (let i = 0; i < pledge(1); i++) {
			r += "<br/><br/>Pledge: " + PLEDGE.roll();
		}
		return r;
	}
}

export const GOD = new Soldier("Soldier of god");
export const HELL = new Soldier("Soldier of hell");

var angel=new Angel()
tables.push(...[angel,GOD,HELL])

const BALSERAPH = "Balseraph";
const DJINN = "Djinn";
const CALABIM = "Calabim";
const HABBALAH = "Habbalah";
const LILIM = "Lilim";
const SHEDIM = "Shedim";
const IMPUDITES = "Impudites";
const BAND = new table.Table("In Nomine, character, demon, band",
  [BALSERAPH, DJINN, CALABIM, HABBALAH, LILIM, SHEDIM, IMPUDITES])
const TITLES = new Map()
TITLES.set(BALSERAPH, "liars");
TITLES.set(DJINN, "stalkers");
TITLES.set(CALABIM, "destroyers");
TITLES.set(HABBALAH, "punishers");
TITLES.set(LILIM, "tempters");
TITLES.set(SHEDIM, "corrupters");
TITLES.set(IMPUDITES, "takers");
for (let t of PLEDGE.lines) t.forces = 7;

var band=false

class Demon extends Character {
	constructor() {
		super("In Nomine, character, demon", 9);
	}

	define(l) {
		l.push("Demon");
		band = BAND.roll();
		l.push("Band", `${band} (${TITLES.get(band)})`);
	}

  roll() {
		let r = super.roll();
		for (let i = 0; i < pledge(2); i++) {
			r += "<br/><br/>Pledge: " + PLEDGE.roll(band);
		}
		return r;
	}
}

var demon=new Demon()
tables.push(...[BAND,demon])

class Fiend extends Character {
  constructor(type, songs, pledge) {
    super("In Nomine, character, lesser fiend, "+type.toLowerCase(), 5, new Song(songs));
    this.type = type;
    this.pledge = new table.Table("In Nomine, character, lesser fiend, pledge", pledge);
  }

  define(l) {
    l.push(this.pledge.roll() + " " + this.type.toLowerCase());
  }
}

class Imp extends Fiend {
  constructor() {
    super("Imp", [DREAMS, FORM, LIGHT, MOTION, POSSESSION],
        [DJINN, SHEDIM, IMPUDITES])
  }
}

class Gremlin extends Fiend {
  constructor() {
    super("Gremlin", [ENTROPY, MOTION, THUNDER, CORPUS],
        [BALSERAPH, CALABIM, HABBALAH])
  }
}

class Familiar extends Fiend {
  constructor() {
    super("Familiar", SONGS, BAND.lines);
  }
}


class Fiends extends table.Table {
	constructor() {
		super("In Nomine, character, lesser fiend", [new Familiar(), new Gremlin(), new Imp()]);
	}

	roll(band=false) {
    if(!band) return super.roll()
		let r = null;
		while (r == null || !r.pledge.lines.includes(band)) {
			r = rpg.pick(this.lines)
		}
		return r.roll();
	}
}

var fiends=new Fiends()

tables.push(...fiends.lines.concat([fiends]))


class Talisman extends table.Table{
  constructor(){
    super("In Nomine, artifact, talisman")
  }
  
  roll(){
    let skills=Array.from(unit.values.values()).flatMap(v=>v)
    return `Talisman of ${rpg.pick(skills).toLowerCase()} (skill bonus)`
  }
}
const TALISMAN=new Talisman()
const RELIC = new table.Table("In Nomine, artifact, relic")
TYPE.roll();
for (let s of TYPE.lines)
  RELIC.add(`Relic of ${s.toLowerCase()} (song)`)
const COMPASS = new table.Table("In Nomine, artifact, compass") 
CHOIR.roll();
var attunements = Array.from(CHOIR.lines);
for (let b of BAND.lines)
  attunements.push(`${b} (${TITLES.get(b)})`)
for (let s of attunements)
  COMPASS.add("Compass of the "+s)
const VESSEL = new table.Table("In Nomine, artifact, vessel")
for (let t of TYPE.lines)
  VESSEL.add(`Vessel (${t.toLowerCase()} elemental)`)
const LEVEL = new table.Table("In Nomine, artifact, level")
LEVEL.add("Level 1", 5);
LEVEL.add("Level 2", 4);
LEVEL.add("Level 3", 3);
LEVEL.add("Level 4", 2);
LEVEL.add("Level 5", 1);

class Artifact extends table.Table {
	constructor() {
		super("In Nomine, artifact");
		this.add("Corporeal artifact (reduces paradox)", 6);
		this.add( TALISMAN,3);
		this.add("Reliquary (generates 1 willpower/level, rate of 1/day)", 2);
		this.add( RELIC,2);
		this.add( COMPASS,2);
		this.add("Fiery sword (+1/level)", 2);
		this.add(VESSEL,2);
		this.add("Holy pistol (+1/level)", 1);
		this.add("Unholy pistol (+1/level)", 1);
	}

	
	 roll() {
		return super.roll() + ", " + LEVEL.roll().toLowerCase();
	}
}
export var artifact=new Artifact()
tables.push(...[TALISMAN,RELIC,COMPASS,VESSEL,LEVEL,artifact])

class Characters extends table.Table {
	constructor() {
		super("In Nomine, character");
		this.add(PLEDGE,100);
		this.add(GOD,60);
		this.add(HELL,20);
		this.add(angel,2);
		this.add(demon);
	}
}

export var characters=new Characters()
tables.push(characters)
