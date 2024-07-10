import * as table from './table.js'
import * as rpg from '../rpg.js'

export var tables=[]

/** Based on big-five demographics. Differences between sexes are minor. */
class Trait extends table.Table{
   constructor(title, common, rare,ncommon=4,nrare=2){
    super('Realistic, character, personality, traits, '+title.toLowerCase())
    this.common=common
    this.rare=rare
    this.add(common, ncommon)
    this.add(rare, nrare)
  }

  israre(){return this.roll()==this.rare}
}

const OPENNESS=new Trait('Openess', 'Curious', 'Cautious')
const CONSCIOUSNESS=new Trait('Consciousness', 'Competent', 'Careless')
const EXTRAVERSION=new Trait('Extraversion', 'Outgoing', 'Reserved')
const AGREEABLENESS=new Trait('Agreeableness', 'Friendly', 'Harsh')
const NEUROTICISM=new Trait('Neuroticism', 'Nervous', 'Confident')

const TRAITS=[OPENNESS, CONSCIOUSNESS, EXTRAVERSION, AGREEABLENESS, NEUROTICISM]

tables.push(...TRAITS)

class Personality extends table.Table{
	constructor(){
		super('Realistic, character, personality')
	}

  roll(){
    let traits=TRAITS.filter(t=>t.israre()).map(t=>t.rare.toLowerCase())
    if(traits.length==0) traits.push('normal')
		return traits.join(', ')
	}
}
var personality=new Personality()
tables.push(personality)

const ATHEIST='Atheist'
const STRAIGHT='Straight'
const ABLE='Able'
const NEUROTYPICAL='Neurotypical'
const HEALTHY='Healthy'
const INTERMEDIATE='Intermediate'
const AVERAGE='Average'
const NORMAL='Normal'
const TYPICAL=new Set([ATHEIST, STRAIGHT, ABLE, NEUROTYPICAL, HEALTHY, INTERMEDIATE,AVERAGE,NORMAL])

const AGE=new table.Table('Realistic, character, age')
AGE.add('Baby', 1)
AGE.add('Child', 1)
AGE.add('Teenager', 1)
AGE.add('Adult', 4)
AGE.add('Middle-aged', 2)
AGE.add('Elder', 1)

const SEX=new table.Table('Realistic, character, sex',['Male', 'Female'])

const RACE=new table.Table('Realistic, character, race')
RACE.add('White', 3)
RACE.add('Latino', 2)
RACE.add('Asian', 2)
RACE.add('Black', 1)
RACE.add('Indian', 1)
RACE.add('Arab', 1)

const SEXUALITY=new table.Table('Realistic, character, sexuality')
SEXUALITY.add(STRAIGHT, 9 * 2)
SEXUALITY.add('Homosexual', 1)
SEXUALITY.add('Bisexual', 1)

const RELIGION=new table.Table('Realistic, character, religion')
RELIGION.add('Christian', 3)
RELIGION.add('Muslim', 2)
RELIGION.add(ATHEIST, 2)
RELIGION.add('Hindu', 1)
RELIGION.add('Shamanic', 1)
RELIGION.add('Buddhist', 1)

const DISABILITY=new table.Table('Realistic, character, disability')
DISABILITY.add('Difficulty walking', 5)
DISABILITY.add('Blind', 1)
DISABILITY.add('Deaf', 1)
DISABILITY.add('Wheelchair', 1)
DISABILITY.add(ABLE, DISABILITY.lines.length * 4)

const MENTALISSUE=new table.Table('Realistic, character, mental issues')
MENTALISSUE.add('Depression', 5)
MENTALISSUE.add('Substance abuse', 4)
MENTALISSUE.add('Anxiety', 2)
MENTALISSUE.add('Schizophrenia', 1)
MENTALISSUE.add('Bipolar', 1)
MENTALISSUE.add(NEUROTYPICAL, MENTALISSUE.lines.length * 9)


/*
  * As of August 2021 (cases per year, relative to population):
  * 
  * - Cold: 300%.
  * 
  * - Flu: 0.01%.
  * 
  * - CoVid: 0.02%.
  */
const HEALTH=new table.Table('Realistic, character, health issues')
HEALTH.add('Hypertension', 3)
HEALTH.add('Diabetes', 1)
HEALTH.add('Cardiovascular disease', 1)
HEALTH.add('Common cold (if cold weather)', 1)
HEALTH.add(HEALTHY, 10 - HEALTH.lines.length)

const CHRONOTYPE=new table.Table('Realistic, character, chronotype')
CHRONOTYPE.add('Early bird', 2)
CHRONOTYPE.add('Night owl', 3)
CHRONOTYPE.add(INTERMEDIATE, 10 - CHRONOTYPE.lines.length)

const HEIGHT=new table.Table('Realistic, character, height')
HEIGHT.add('Tall',5)
HEIGHT.add(AVERAGE,40)
HEIGHT.add('Short',5)
HEIGHT.add('Dwarf',1)

const WEIGHT=new table.Table('Realistic, character, weight')
WEIGHT.add('Under-weight',1)
WEIGHT.add(NORMAL,40)
WEIGHT.add('Over-weight',40)
WEIGHT.add('Obese',20)

tables.push(...[AGE,SEX,RACE,SEXUALITY,RELIGION,DISABILITY,MENTALISSUE,HEALTH,CHRONOTYPE,HEIGHT,WEIGHT])

/**
 * Built using semi-extensive real-world data.
 * 
 * @author alex
 */
class WorldNpc extends table.Table{
	constructor(name='Realistic, character',s=false){
		super(name)
    this.simple=s
	}

	roll(){
		let basic=[AGE,RACE,SEX].map(b=>b.roll()).join(' ')
    basic=basic[0]+basic.slice(1).toLowerCase()
		let details=[RELIGION,SEXUALITY,DISABILITY,MENTALISSUE,HEALTH,CHRONOTYPE,HEIGHT,WEIGHT]
                  .map(d=>d.roll()).filter(d=>!TYPICAL.has(d))
		if(this.simple) details=rpg.shuffle(details).slice(0,2)
		details=details.sort().join(', ').toLowerCase()
    let p=personality.toString().toLowerCase()
		return [`${basic} (${details}).`,
              `Personality: ${p}`].join('<br/>')
	}
}

export const FULL=new WorldNpc()
const SIMPLE=new WorldNpc('Realistic, character (simple)', true)

tables.push(...[FULL,SIMPLE])
