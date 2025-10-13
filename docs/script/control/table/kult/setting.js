import * as table from '../table.js'
import * as rpg from '../../rpg.js'

export var tables=[]

const KETHER = "Kether, the Ruler";
const MALKUTH = "Malkuth, the Rebel";
const ARCHONS = new table.Table("Kult, character, archons", [KETHER, "Binah, the Black Madonna",
  "Geburah, the Judge", "Tiphareth, the Spider", "Netzach, the Victor", MALKUTH])
const ASTAROTH = new table.Table("Kult, character, Astaroth form",
    ["Antichrist, the Warlord", "The Seducer", "The Beast"])
const NAHEMOTH = "Nahemoth, the Defiled";
const ANGELS = new table.Table("Kult, character, Angels of Death",
    ["Thaumiel, the unjust ruler", "Chagidiel, the Bloodstained Patriarch",
        "Sathariel, the Devastating Mother", "Gamichicoth, the False Rescuer", "Golab, the Torturer",
        "Togarini, Protector of the Death Conjurers", "Hareb-Sepap, the Raven of the Battlefields",
        "Samael, the Avenger", "Gamaliel, the Perverted", NAHEMOTH])
const HELL = "Hell (a sinner's personal purgatory, ruled by a nepharite, always metaphysically super-imposed to the sinner's place of death)";
const RAZIDE = "Razide of %s (tall, half-living humanoids with a black iron and glass exoskeleton, yellow-red eyes and a metal jaw)";
const BEING = new table.Table("Kult, character, Inferno")
for (let a of ANGELS.rows)
  BEING.add(RAZIDE.replace('%s',a));
BEING.add("Nepharite (run personal hells for sinners, shape-changing but usually mutilated humans)");
BEING.add("Purgatide (tormented human sinner)", 10);

tables.push(...[ARCHONS,ASTAROTH,ANGELS,BEING])

class Inferno extends table.Table {
	constructor() {
		super("Kult, Inferno");
		for (let circle of ["First circle", "Second circle", "Third circle", "Fourth circle", "Fifth circle","Sixth circle", "Seventh circle", "Eigth circle", "Ninth circle"])
			this.add(circle, 10);
		this.add(HELL, 10);
		this.rows.push(...BEING.rows);
		for (let a of ANGELS.rows)
			this.add(`Black palace of ${a} (dark labyrinths down into the deep undeerground)`, 1);
		this.add("Dead sun (terrifying black sun that is rarely glimpsed in Inferno's starless sky)", 1);
	}
}
var inferno=new Inferno()
tables.push(inferno)

class Exposed extends table.Table{
  constructor(){
    super("Kult, The City, exposed place") 
  }
  
  roll(){
    this.rows=[]
    let p = portal.roll();
    let i = inferno.roll();
    let m = metropolis.roll();
    let c = TYPE.roll();
    this.add("Slum to " + m);
    this.add("Prison to " + i);
    this.add("Crime scene to " + (rpg.roll(2) == 1 ? i : m));
    this.add("Cult grounds of " + c);
    this.add("Corporation headquarters of " + c);
    this.add("Battlefield to " + i);
    this.add("Disaster area to " + m);
    this.add(`Mental institution to ${i}`);
    this.add(`Industrial district to ${MACHINECITY}`);
    this.add(`Realm of Madmen (a homeless commune for the insane) to ${p}`);
    return super.roll()
  }
};
var exposed=new Exposed()

const UNDERGROUND = new table.Table("Kult, The City, underground",
  ["Sewers", "Subway", "Service tunnels", "Bomb shelter", "Military base"]);
const TRANSPORT = new table.Table("Kult, The City, transport",
  ["Taxi", "Car ride", "Road tunnel", "Night bus", "The subway", "Train station"]);
const COMMUNICATION = new table.Table("Kult, The City, communication",
  ["Phone booth", "Grafitti"]);
const INSTITUTION = new table.Table("Kult, The City, institution",
  ["Police station", "University", "Hospital"]);

tables.push(...[exposed,UNDERGROUND,TRANSPORT,COMMUNICATION,INSTITUTION])

const MISSINGARCHONS = ["Chokmah", "Chesed", "Hod", "Yesod"];
const CITADELS = new table.Table("Kult, Metropolis, citadels")
for (let a of ARCHONS.rows) {
  CITADELS.add(`Citadel lower floors, ${a} (mostly empty)`, 10);
  CITADELS.add(`Citadel higher floors, ${a} (modern or holy, sparsely guarded by lictors and acrotides)`
      , 30);
  CITADELS.add(`Citadel top floors, ${a} (the Archon's own shape-shifting body, densely populated)`, 1);
}
for (let a of MISSINGARCHONS)
  CITADELS.add(`Abandoned citadel, ${a}`, 10);
const PLATOON = "Platoon (more tired and hopeless than hostile, has an insane leader)";
const LABYRINTH = new table.Table("Kult, Metropolis, underground", [
  "Hatching chamber (for Razide larvae, black worms coming out of blackeggs in low-ceiling, bare-rock rooms deep in Metropolis and near Inferno)",
  "Ktonor (eternally-dark-city underneath where the formless Blind Bull guards the entrance to the Inner Labyrinth)",
  "Metromorte (all encompassing subway necro-train)",
  "Cave (partially submerged in poisonous and radioactive pools))", "Military checkpoint",
  "Catacombs (inhabited by undead skeletons and zombies, often entombed and reaching out)",
  "Genetide (radioactive tentacled-humanoids)",
  "agentii (radioactive soldiers, either killed by or victims of radiation, or those who spread it to the enemy)",
  "Fekkuzer mating grounds (parasites that can possess and manipulate individual body parts, driving prey to their pools)",
  PLATOON]) 
LABYRINTH.rows.push(...UNDERGROUND.rows);
const LIVINGCITY = new table.Table("Kult, Metropolis, The Living City", [
  "The Slums (closest are of Metropolis to the real-world with deformed animals, crime and police, everything much more distant than it seems)",
  "The Bazaar (crowded eastern market district, with aritfacts, information and weapons; artists and pick-pockets; drugs, sex and slaves)",
  "Trench Town (close to reality as The Slums but darker, with crime lords, diseases and no infrastructure)",
  "The Garbage Dump (inhabited by semi-humans and monstrous vermin)",
  "Industrial Site (desolate concrete, steel and hammering machinery, workers come in the morning and leave at night going deep into the dark undergroud, mafia and stolen goods)",
  "The pub"])
const RUINS = new table.Table("Kult, Metropolis, The Ruins", ["Wrecking yard ruin",
  "Construction site ruin",
  "Harbor (where a mysterious lighthouse guarded by the Watchmen attracts lost ships from the real-world)",
  "Wartorn citiscape ruin", "Ruin of ancient buildings", "Car graveyeard", "Radioactive zone",
  "Tribal salt desert", "Bombed highway", "Collapsing bridge", "Collapsing building", "Minefield",
  "Trench battlefield",
  "Melting street (the concrete slowly turns into lava, potentially devouring the buildings nearby)",
  "Earthquake ritual (shamanic dance that generates real-world quakes that bring victims to be eaten)", "War",
  "Sudden hunger kicks in", "Fire, arson, inferno", "Hard-to-access cable car leading to an uppper plane",
  "Hard-to-access cable car leading to a lower plane",
  "Urban swamp (pavement decays into a mud-like substance)", PLATOON])
const AZGHOUL = "Azghoul (humanity's name-bound, armed and fully-armored ancient slaves";
const UNDEADSERVANT = "Undead servant of the Dead Gods (looking for a victim to bring to the City of the Dead)";
const METROPOLITAN = new table.Table("Kult, character, metropolitan", [
  "Metropolitan human (feral hunter-scavenger, often lost from our world)", AZGHOUL,
  "Wolven (semi-reptilian dire-wolves)", "Ferroco (largy, clumsy camouflaging felines)",
  "Techrones (meek spider-like humans made of steel and plastic, carrying industrial tools for Mechine City maintenance)",
  UNDEADSERVANT, "Achlytides (half-human, half-caterpillar)",
  "Zeloth (skinless humanoids who live in the tunnels beneath the strets and communicate through rattles and clanks on its metal, waiting to ambush surface-dwellers)",
  "Erinyae (swarming pteradons of flesh and black glass, more common near huge structures like the Citadels or the Abyss)",
  "Crustacz (very quick, meter-long, eleven-legged flies that come out of the Abyss during the night and hunt prey with a paralyzing poison)"])
const CITYOFTHEDEAD = "City of the dead (necropolis inhabited by the shadows of humans who have truly died, inside or among enormous tombstones, mausoleums...)";
const MACHINECITY = "The Machine City (one huge factory that goes for thousands of miles, mostly shut down, inhabited by Techrones)";

tables.push(...[CITADELS,LABYRINTH,LIVINGCITY,RUINS,METROPOLITAN])

const DEITIES = new table.Table("Kult, character, deity",
  [ARCHONS, ASTAROTH, ANGELS])
const BORDERLINER = new table.Table("Kult, character, borderliner", ["Borderliner human",
  "Nachtkäfer (giant, insect-like portal-dwellers)", "Child of the underworld (mole people)",
  "Razid larvae (eats organic matter, phase through inorganic matter)",
  "Psilocites (eyeless giants with metal exo-skeletons and atrophied appendages)", AZGHOUL,
  UNDEADSERVANT,
  "Amentoraz (slowly consumes mentallly-ill people, looks like a darker shadow during the day and assumes forms relevant to their victim at night to torment them)",
  "Madman (physically-altered mentally-negative insane person)",
  "Fury (large, extremely insane human with several body alterations, can sometimes be controlled as minions)",
  "Cairath (large bipedal, four-armed sewer predators with a metallic head and bodies made of junk, refuse, vermin and their victims)",
  "Libith (shape-changing succcubus looking to madden and degrade their victims, or drive them to suicide)",
  "Darthea (possesses humans and influence them into sexual acts, often into exhaustion and starvation)",
  "Gynachide (dark-grey creatures with metallic teeths and nails that impregnate women with their offspring, as romantic, loyal and protective as they are alien)",
  "Aetats (murderous \"time-police\" with distorded, long, curved bodies and eight legs - if perceived, can be thrown off by \"laying low\" long enough)",
  "Aspecti (thin, flickering, color-changing, distorted Medusa-looking creatures with flowing space-perception, may appear to humans when ni the same wavelengthm, often causing madness and system shock)",
  "The homeless (the Bag Lady)", "The police (well-armed and paranoid, prowling in vehicles)",
  "Garbage symbiosis (semi-organic creature followed by smaller, suicidal compostats)", "Police stand-off",
  "Gang brutality",
  "Scavenger (usually found in an area with potential to find equipment, will usually avoid others but can also attack from stealth)",
  "Soldier", "Human hunter (generally hostile, paranoid)", "Artillery barrage", "Hunting squad"])
const UNDEAD = new table.Table("Kult, character, undead", [
  "Undead (ghost on the borderline of death, by their own will or bound to something)",
  "Corpophagus (usually a broken dead spirit, with deadly, inch-long corpophagi parasites in the vicinity)",
  "Living dead (usually insane and aggressive, unless very recent)",
  "Nosferatu (vampire, often extroverted and artsy or seclusive and magic)",
  "Specters (semi-physical living dead who are bound to a thing or a goal, usually driven insane after a decade)"])

tables.push(...[DEITIES,BORDERLINER,UNDEAD])

class Metropolis extends table.Table {
	constructor() {
		super("Kult, Metropolis",[
				"Abyss (surrounded by the 10 citadels, a 30-mile-long square hole in the center of Metropolis where the Demiurge's citadel used to be, from where only Astaroth has returned)",
				"Mirror HAlls (arabic section made of glass and mirrors, high above the rest of the city, where time and matter are malleable)",
				"Empty Chapel (white building in the City of the Dead where a shadow Guardian appearead after the Demiurge's disapparance)",
				"Mausoleum of the Dead Gods (located in the City of the Dead, the trapped gods will lure victims in and befriend them - but sooner or later be overtaken by desire, rape, kill and eat them",
				"The Cube (100-meter long cube, with liquids and energy fed to ir via tubes, maintained and venerated by a hundred Achlytides)"]);
		for (let t of [CITADELS, BORDERLINER, METROPOLITAN, LIVINGCITY, RUINS])
			this.add(t);
		for (let section of ["Anachronistic city", "Real-world city", "The Maze (Escher-like)",
				"Hunting Grounds (most worn part of Metropolis, full of Wolvens and some Ferocci)", MACHINECITY,
				CITYOFTHEDEAD])
			this.add(section, 10);
		this.add(LABYRINTH,10);
	}
}
var metropolis=new Metropolis()
tables.push(metropolis)

class Being extends table.Table {
	constructor() {
		super("Kult, character");
	}
	
	roll(){
    this.rows=[]
    this.add(`Astaroth incarnate (form: ${ASTAROTH.roll()}, immune to magic and controls beings with negative mental balance)`, 1);
		for (let a of ARCHONS.rows) {
			if (a == KETHER)
				continue;
			this.add(`Archon incarnate (${a})`, 10);
			this.add(`Archon manifestation (${a})`, 20);
			this.add(`${a == MALKUTH ? "Human servant" : "Lictor (jailer)"} of ${a}`, 30);
		}
		for (let a of ANGELS.rows) {
			if (a != NAHEMOTH)
				this.add(`Angel of Death incarnate (${a})`, 4);
			this.add(`Angel of Death manifestation (${a})`, 20);
			this.add(RAZIDE.replace('%s',a), 30);
		}
		this.add(BORDERLINER,40);
		this.add(UNDEAD,40);
    return super.roll()
  }
}
export var being=new Being()
tables.push(being)

const LENSES = new table.Table("Kult, artifact, lenses",
  ["Eye-glass", "Enlargment lens", "Camera", "Binocular"])
const NONE = "None";
const PASSWORD = new table.Table("Kult, artifact, portal, password",
  [NONE, "Time-sensitive", "Password", "Ritual"])
const DESTINATION = new table.Table("Kult, artifact, portal, destination",
  ["Another time", "Another place", "Chaotic"]) 
DESTINATION.add(portal,DESTINATION.rows.length/10)

class PortalArtifact extends table.Table {
  constructor(){
    super("Kult, artifact, portal")
  }
  
  roll() {
    let characteristics = []
    let p = PASSWORD.roll();
    if (p != NONE)
      characteristics.push(p);
    characteristics.push(rpg.roll(1,3) == 1 ? "two-way" : "one-way");
    let r = `portal to ${DESTINATION}`
    if (characteristics.length>0) {
      r = characteristics.join(", ") + " " + r;
    }
    return r;
  }
};
class Clockwork extends table.Table{
  constructor(){
    super("Kult, artifact, clockwork",["Large clock", "Wristwatch"])
  }

  roll() {
    let effect = rpg.roll(1,3) == 1 ? portal : period;
    return super.roll() + ", " + effect.roll();
  }
};

const PORTAL=new PortalArtifact()
const CLOCKWORK=new Clockwork()

class KultArtifact extends table.Table {
	constructor() {
		super("Kult, artifact");
	}

  roll() {
		this.rows=[]
		let p = portal.roll();
		this.add(PORTAL);
		this.add(`Mirror to ${p}`, 2);
		this.add(`Puzzle to ${rpg.roll(1,2) == 1 ? inferno.roll() : p}`, 3);
		this.add(rpg.roll(1,2) == 1 ? "Statuette" : "Nepharite statuette", 4);
		this.add(LENSES,5);
		this.add("Mirror", 6);
		this.add(CLOCKWORK,7);
		this.add("Software (roll for madness effect)", 8);
    return super.roll()
	}
}
export var artifact=new KultArtifact()
tables.push(...[LENSES,PASSWORD,DESTINATION,PORTAL,CLOCKWORK,artifact])

var elysium=new table.Table("Kult, elysium",["An empty paradise"])
tables.push(elysium)

const PLOT = new table.Table("Kult, adventure, plot",
    ["Stop a bad thing from happening", "Find someone", "Find something", "Revenge", "Solve a riddle",
        "Travel", "Gather information and wisdom", "Expose and stop a cult", "Make something happen",
        "Run for your life"]);
const MOTIVATION = new table.Table("Kult, adventure, motivation",
    ["False accusations", "Prevent something", "Revenge", "Loyalty to a person",
        "Loyalty to an organization", "Curiosity", "Money", "Religion", "A favor", "Character advantage",
        "Character disadvantage", "An objective", "Blackmail"]);
const CHARACTERS = new table.Table("Kult, adventure, characters",
    ["Friends", "Colleagues", "Neighbors", "Hobbyists", "Relatives", "Students", "Common friend",
        "Present at the same past event", "Common enemies", "Coincidence"]);
const BEGINNING = new table.Table("Kult, adventure, beginning",
    ["Murder", "Disappearance", "Comission", "Attack", "Curse", "Dreams", "Disease", "Tricked", "Object",
        "Stranger", "Place", "Help", "Pursuit"]);
const EVENT = new table.Table("Kult, adventure, event",
    ["Ambush", "Possession", "Surveillance", "Car chase", "Forensic investigation at a crime scene",
        "Dreams", "Death", "Escape", "Curse", "Captivity", "Interrogation", "Love", "Seduction",
        "Illusion shatters", "Burglary", "Infiltration", "Research", "Chased by monsters",
        "Chased by killers", "Hijacking", "Raid", "Confrontation", "Ritual", "New NPC", "Disaster",
        "Accident", "Travel", "Sex", "Illness", "Combat", "Lost"]);
const COMPLICATION = new table.Table("Kult, adventure, complication",
    ["Possession", "Wrong person", "Torn between goals", "Torn between impulses", "False information",
        "Adversary", "Loyalty changes", "Separated", "Illusion shatters", "More complexity", "New enemies",
        "New friends", "New information", "Lies", "Outsiders"]);

class KultAdventure extends table.Table {
	constructor() {
		super("Kult, adventure");
	}

	roll() {
		let l = [];
		l.push("Plot: "+ PLOT);
		l.push("Motivation: "+ MOTIVATION);
		l.push("Characters: "+ CHARACTERS);
		l.push("Beginning: "+ BEGINNING);
		let r = [rpg.roll(1,5), rpg.roll(1,5)]
		r.sort();
		let complications = r[0];
		let events = r[1];
		let story = []
		for (let i = 0; i < events; i++)
			story.push(EVENT);
		for (let i = 0; i < complications; i++)
			story.push(COMPLICATION);
		rpg.shuffle(story);
		for (let s of story)
			l.push(`${s == EVENT ? "Event" : "Complication"}: ${s}`);
		return l.join('<br/>')
	}
}
tables.push(...[PLOT,MOTIVATION,CHARACTERS,BEGINNING,EVENT,COMPLICATION,new KultAdventure()])

const TYPE = new table.Table("Kult, cult, type", [
  "Religious cult (worship an occult being, an awakened or ordinary human or a principle)",
  "Guardian cult (protect an Artifact, of real or imagined value)",
  "Knowledge-seeking cult (rarely-violent cult trying to obtain a piece of information)",
  "Power group (business, religious or political gruup that act as a cult, sometimes extremists, not necessarily tied to the occult)",
  "Illuminati (loose world-wide net of awakened humans trying to achieve and guide toward vivinity)",
  "Perversion cult (deranged group that seeks out to fulfill their dark carnal desires)"]);
const CHARACTERISTIC = new table.Table("Kult, cult, characteristic",
  ["Minimal", "Low", "Average", "High", "Extreme"]);

const ANCIENT = new table.Table("Kult, time period, ancient",
  ["Bronze age", "Iron age", "Classical antiquity", "Late antiquity"]);
const MODERN = new table.Table("Kult, time period, modern",
  ["Renaissance", "Age of Discovery", "Industrial revolution"]);

class Period extends table.Table {
	constructor() {
		super("Kult, time period");
		this.add("Pre-historic", 1);
		this.add(ANCIENT,2);
		this.add("Middle-ages", 3);
		this.add(MODERN,4);
		this.add("Present-day", 5);
	}
}
var period=new Period()

tables.push(...[TYPE,CHARACTERISTIC,ANCIENT,MODERN,period])

const NORMAL = "Normal";
const SPEED = new table.Table("Kult, dream, speed")
SPEED.add("Very slow (frozen time)", 1);
SPEED.add(NORMAL, 10);
SPEED.add("Very fast (a week passes every five minutes)", 1);
const DREAMTYPE = new table.Table("Kult, dream, type")
DREAMTYPE.add(NORMAL, 10);
DREAMTYPE.add("Nightmare", 10);
DREAMTYPE.add("Precognitive (about something that will happen in the future)", 1);
const DREAMBEING = new table.Table("Kult, character, dream", [
  "Dream wanderer (a freely-wandering human who transferred his whole life force into dreams, often serves of a Dream Prince)",
  "Ichtyrian (a long shell with red eyes and large jaw with 20 spider legs, can devour people in dreams and reality at the same time)",
  "Psyphagus (usually inhabiting their own dreams, they are shadow-looking dreamers who lost access to their bodies and are looking to subdue someone in their dream and take over their body)"]);
const PRINCE = new table.Table("Kult, character, dream prince", [
  "Hammad al-Sufi, oldest prince with a rock-city empire ranging from the Vortex to the Middle-East waking world",
  "Deride Aristides, prince from the future with an empire of cyberpunk cities, cyberspace, space-ships and space-stations",
  "Aaron Greenberg, rules over a fascist dream of military law and bureaucracy, often bringing waking people as inhabitants",
  "Friedich Köpfel, alchemist prince with an empire full of tempels and occult treasures, curses and the undead",
  "Nikolai Makarov, christian monk with an empire of hells, cathedrals and monasteries",
  "Samara Nyeme, wandering african princess of an empire of villages, famine, disasters, wars and dark gods",
  "Nicolette Pasteur, sickly princess of a chaotic empire of paranoia and nightmares",
  "Caren Birchlime, researcher of narcotics, youngest princess who lacked caution and was driven insane by the Vortex, now killing or maddening her citizens"]);

class Dream extends table.Table {
	constructor() {
		super("Kult, dream");
	}

  roll() {
    this.rows=[]
		let p = portal.roll();
		this.add("Real dream (happens in some aspect of reality) in " + p, 10);
		this.add(DREAMBEING,10);
		let characteristics = [
      SPEED.roll(),
      DREAMTYPE.roll()
    ]
		let suffix = characteristics.filter(c => c != NORMAL).join(", ").toLowerCase();
		if (suffix.length>0)
			suffix = ", " + suffix;
		this.add("Realistic dream (close to reality)" + suffix, 100);
		this.add("Abstract dream (distant from reality)" + suffix, 10);
		for (let prince of PRINCE.rows)
			this.add("Realm of a Dream Prince (powerful dreaming entitier who built vast empires near the Vortex, which they hope to control and wage war over), "
					+ prince, 1);
		this.add("Vortex (origin of all dreams, source of the collective subconscious)", 1);
    return super.roll()
	}
}
export var dream=new Dream()

tables.push(...[SPEED,DREAMTYPE,DREAMBEING,PRINCE,dream])

export const ACHLYS = "Achlys (void beyond timespace, chaos)";
class Portal extends table.Table {
	constructor(name='Kult, portal') {
		super(name);
		this.add(ACHLYS);
		for (let to of [inferno, LABYRINTH, metropolis, CITADELS,
				dream, elysium])
			this.add(to);
	}
}
export var portal=new Portal()
class Lower extends Portal {
  constructor(){
    super("Kult, portal, lower")
  }

  roll() {
    return this.rows[rpg.low(0,this.rows.length-1)]
  }
};
class Higher extends Portal {
  constructor(){
    super("Kult, portal, higher")
  }

  roll() {
    return this.rows[rpg.high(0,this.rows.length-1)]
  }
}
tables.push(...[portal,new Lower(),new Higher()])

/**
 * {@link #TYPE} is used over a static instance so as to avoid generating a
 * brand-new Cult every time one is needed/referened in another table. Instead,
 * the idea is to have one or two of {@link #TYPE} that a GM can refer to when a
 * type is rolled in another table - those instances can then be fully generated
 * with a manual roll on {@link Cult} proper.
 */
class Cult extends table.Table {
	constructor() {
		super("Kult, cult");
	}

  roll() {
		let l = [];
		l.push(TYPE);
		for (let characteristic of ["Size", "Structure", "Membership requirements", "Resources",
				"Geographical presence", "Luxury", "Ease to identify", "Prone to violence", "Secrecy"])
			l.push(characteristic+': '+ CHARACTERISTIC.roll());
		let d = DEITIES;
		if (rpg.roll(1,d.rows.length) != 1)
			l.push("Affiliation"+': '+ d.roll());
		while (rpg.roll(1,4) == 1)
			l.push("Ally"+': '+ TYPE.roll());
		while (rpg.roll(1,4) == 1)
			l.push("Enemy"+': '+ TYPE.roll());
		return l.join('<br/>')
	}
}

export var cult=new Cult()
tables.push(cult)

class City extends table.Table {
	 constructor() {
		super("Kult, The City");
	}

  roll() {
    this.rows=[exposed, being, UNDERGROUND, TRANSPORT, COMMUNICATION, INSTITUTION]
		this.add("Front to " + metropolis.roll());
		this.add("Lictor residence of " + ARCHONS.roll());
		this.add("Hidden temple of " + TYPE.roll());
		this.add("Graveyeard, which may lead to " + CITYOFTHEDEAD);
		this.add("Permanent portal to to " + portal.roll());
		this.add("Real-world counterpart of " + LIVINGCITY.roll());
    return super.roll()
	}
}

tables.push(new City())
