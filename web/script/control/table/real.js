import * as table from './table.js'
import * as rpg from '../rpg.js'

export var tables=[]

/** Based on big-five demographics. Differences between sexes are minor. */
class Trait extends table.Table {
   constructor(title, common, rare,ncommon=4,nrare=2) {
    super('Realistic, personality, traits, '+title.toLowerCase());
    this.common = common;
    this.rare = rare;
    this.add(common, ncommon);
    this.add(rare, nrare);
  }

  israre() {
    return this.roll() == this.rare;
  }
}

const OPENNESS = new Trait("Openess", "Curious", "Cautious");
const CONSCIOUSNESS = new Trait("Consciousness", "Competent", "Careless");
const EXTRAVERSION = new Trait("Extraversion", "Outgoing", "Reserved");
const AGREEABLENESS = new Trait("Agreeableness", "Friendly", "Harsh");
const NEUROTICISM = new Trait("Neuroticism", "Nervous", "Confident")

const TRAITS = [OPENNESS, CONSCIOUSNESS, EXTRAVERSION, AGREEABLENESS, NEUROTICISM];

tables.push(...TRAITS)

class Personality extends table.Table {
	constructor() {
		super("Realistic, personality");
	}

  roll() {
		return TRAITS.map(t => t.roll().toLowerCase()).join(", ");
	}
}
tables.push(new Personality())

const ATHEIST = "Atheist";
const STRAIGHT = "Straight";
const ABLE = "Able";
const NEUROTYPICAL = "Neurotypical";
const HEALTHY = "Healthy";
const INTERMEDIATE = "Intermediate";
const TYPICAL = new Set([ATHEIST, STRAIGHT, ABLE, NEUROTYPICAL, HEALTHY, INTERMEDIATE]);

const AGE = new table.Table("Realistic, age")
AGE.add("Baby", 1);
AGE.add("Child", 1);
AGE.add("Teenager", 1);
AGE.add("Adult", 4);
AGE.add("Middle-aged adult", 2);
AGE.add("Elder", 1);

const SEX = new table.Table("Realistic, sex",["Male", "Female"]);

const RACE = new table.Table("Realistic, race")
RACE.add("White", 3);
RACE.add("Latino", 2);
RACE.add("Asian", 2);
RACE.add("Black", 1);
RACE.add("Indian", 1);
RACE.add("Arab", 1);

const SEXUALITY = new table.Table("Realistic, sexuality")
SEXUALITY.add(STRAIGHT, 9 * 2);
SEXUALITY.add("Homosexual", 1);
SEXUALITY.add("Bisexual", 1);

const RELIGION = new table.Table("Realistic, religion")
RELIGION.add("Christian", 3);
RELIGION.add("Muslim", 2);
RELIGION.add(ATHEIST, 2);
RELIGION.add("Hindu", 1);
RELIGION.add("Shamanic", 1);
RELIGION.add("Buddhist", 1);

const DISABILITY = new table.Table("Realistic, disability")
DISABILITY.add("Difficulty walking", 5);
DISABILITY.add("Blind", 1);
DISABILITY.add("Deaf", 1);
DISABILITY.add("Wheelchair", 1);
DISABILITY.add(ABLE, DISABILITY.lines.length * 4);

const MENTALISSUE = new table.Table("Realistic, mental issues")
MENTALISSUE.add("Depression", 5);
MENTALISSUE.add("Substance abuse", 4);
MENTALISSUE.add("Anxiety", 2);
MENTALISSUE.add("Schizophrenia", 1);
MENTALISSUE.add("Bipolar", 1);
MENTALISSUE.add(NEUROTYPICAL, MENTALISSUE.lines.length * 9);


/*
  * As of August 2021 (cases per year, relative to population):
  * 
  * - Cold: 300%.
  * 
  * - Flu: 0.01%.
  * 
  * - CoVid: 0.02%.
  */
const HEALTH = new table.Table("Realistic, health issues")
HEALTH.add("Hypertension", 3);
HEALTH.add("Diabetes", 1);
HEALTH.add("Cardiovascular disease", 1);
HEALTH.add("Common cold (if cold weather)", 1);
HEALTH.add(HEALTHY, 10 - HEALTH.lines.length);

const CHRONOTYPE = new table.Table("Chronotype")
CHRONOTYPE.add("Early bird", 2);
CHRONOTYPE.add("Night owl", 3);
CHRONOTYPE.add(INTERMEDIATE, 10 - CHRONOTYPE.lines.length);

tables.push(...[AGE,SEX,RACE,SEXUALITY,RELIGION,DISABILITY,MENTALISSUE,HEALTH,CHRONOTYPE])

/**
 * Built using semi-extensive real-world data.
 * 
 * TODO simple height (something like average/tall/short)
 * 
 * @author alex
 */
class WorldNpc extends table.Table {
	constructor(name="Realistic, NPC",s=false) {
		super(name);
    this.simple=s
	}

	roll() {
		let basic = [SEX,RACE,AGE].map(b=>b.roll())
		let details = []
		for (let table of [RELIGION, SEXUALITY, DISABILITY, MENTALISSUE, HEALTH, CHRONOTYPE]) {
			let line = table.roll();
			if (!TYPICAL.has(line))
				details.push(line.toLowerCase());
		}
		let traits=TRAITS.filter(t => t.israre()).map(t => t.rare.toLowerCase())
    details.push(...traits)
		if (this.simple) details=rpg.shuffle(details).slice(0,2)
		details.sort();
		let npc = basic.join(" ") + " - " + details.join(", ");
		return npc.toLowerCase();
	}
}

const SIMPLE = new WorldNpc("Realistic, simple NPC", true);

tables.push(...[new WorldNpc(),SIMPLE])
