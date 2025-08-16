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

const ATHEIST='Atheist'
const STRAIGHT='Straight'
const ABLE='Able'
const NEUROTYPICAL='Neurotypical'
const HEALTHY='Healthy'
const INTERMEDIATE='Intermediate'
const AVERAGE='Average'
const NORMAL='Normal'
const MISERABLE='Miserable'
const NEUTRAL='Neutral'
const TYPICAL=new Set([ATHEIST,STRAIGHT,ABLE,NEUROTYPICAL,HEALTHY,INTERMEDIATE,AVERAGE,
                      NORMAL,NORMAL.toLowerCase(),MISERABLE,NEUTRAL])

export var traits=[OPENNESS, CONSCIOUSNESS, EXTRAVERSION, AGREEABLENESS, NEUROTICISM]

tables.push(...traits)

class Personality extends table.Table{
	constructor(){super('Realistic, character, personality')}

  roll(){
    let rare=traits.filter(t=>t.israre()).map(t=>t.rare.toLowerCase())
    if(rare.length==0) rare.push('normal')
		return rare.join(', ')
	}
}
export var personality=new Personality()
tables.push(personality)


const AGE=new table.Table('Realistic, character, age')
AGE.add('Elder', 1)
AGE.add('Middle-aged', 2)
AGE.add('Adult', 4)
AGE.add('Teen', 1)
AGE.add('Child', 1)
AGE.add('Baby', 1)

const SIMPLEAGE=new table.Table('Realistic, character, age (simple)')
SIMPLEAGE.add('Old',3)
SIMPLEAGE.add('Adult',4)
SIMPLEAGE.add('Young',3)

const SEX=new table.Table('Realistic, character, sex',['Male', 'Female'])

const RACE=new table.Table('Realistic, character, race')
RACE.add('White', 3)
RACE.add('Latino', 2)
RACE.add('Asian', 2)
RACE.add('Black', 1)
RACE.add('Indian', 1)
RACE.add('Arab', 1)

const SIMPLERACE=new table.Table('Realistic, character, race (simple)')
SIMPLERACE.add('White-arab',4)
SIMPLERACE.add('Black-latino',3)
SIMPLERACE.add('Asian-indian',3)

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
  * - COVID: 0.02%.
  */
const HEALTH=new table.Table('Realistic, character, health issues')
HEALTH.add('Hypertension', 3)
HEALTH.add('Diabetes', 1)
HEALTH.add('Cardiovascular disease', 1)
HEALTH.add('Common-cold if cold-weather', 1)
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

const WEALTH=new table.Table('Realistic, character, wealth')
WEALTH.add('Millionaire',1)
WEALTH.add('Middle-class',10)
WEALTH.add('Poor',30)
WEALTH.add(MISERABLE,50)

const ALERTED=new table.Table('Realistic, character, emotion, alerted') //arousal
ALERTED.add('Alert',1)
ALERTED.add(NEUTRAL,4)
ALERTED.add('Calm',1)
const ENGAGED=new table.Table('Realistic, character, emotion, engaged') //valence
ENGAGED.add('Happy',1)
ENGAGED.add(NEUTRAL,4)
ENGAGED.add('Sad',1)

tables.push(...[AGE,SIMPLEAGE,SEX,RACE,SIMPLERACE,SEXUALITY,RELIGION,DISABILITY,MENTALISSUE,HEALTH,
                CHRONOTYPE,HEIGHT,WEIGHT,WEALTH,ALERTED,ENGAGED,])

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

	format(array){
    if(this.simple) array=[rpg.pick(array)]
    return array.sort().join(', ').toLowerCase()
  }

	roll(){
    let basic=this.simple?[SIMPLEAGE,SIMPLERACE,SEX]:[AGE,RACE,SEX]
		basic=basic.map(b=>b.roll()).join(' ')
    basic=basic[0]+basic.slice(1).toLowerCase()
		let details=[RELIGION,SEXUALITY,DISABILITY,MENTALISSUE,HEALTH,CHRONOTYPE,HEIGHT,WEIGHT,WEALTH,]
                  .map(d=>d.roll()).filter(d=>!TYPICAL.has(d))
    let traits=[personality.roll().split(',').map((text)=>text.trim()),
                [ALERTED,ENGAGED].map((table)=>table.roll())]
                .flat().filter((text)=>!TYPICAL.has(text))
    if(!traits.length) traits=['bland']
		return [`${basic} (${this.format(details)}).`,
              `Personality: ${this.format(traits)}`].join('<br/>')
	}
}

export const FULL=new WorldNpc()
const SIMPLE=new WorldNpc('Realistic, character (simple)', true)

tables.push(...[FULL,SIMPLE])
