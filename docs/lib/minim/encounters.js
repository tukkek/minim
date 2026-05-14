#!/usr/bin/env deno
import * as dicem from './dice.js'

//TODO 10% chance of elites
const TRIVIAL=.1
const MODERATE=.2
const EPIC=.5
const DEADLY=1
const CLASSIC=false

class Difficulty{
  constructor(){
    let easy=[TRIVIAL,MODERATE]
    let fair=[MODERATE,EPIC]
    let hard=[EPIC,DEADLY]
    this.easy=easy
    this.fair=fair
    this.hard=hard
    let distribution=[easy,easy,fair,
                      fair,fair,hard]
    if(CLASSIC) distribution.splice(3,0,fair,fair,fair)
    this.distribution=distribution
  }

  get random(){return dicem.pick(this.distribution)}
}

class Unit{
  constructor(tier,generator=false){
    this.tier=tier
    this.generator=generator
    this.power=5**(tier-1)
  }

  generate(){return this.generator.call()}
}

class Encounter{
  constructor(units=[]){this.units=units}

  get power(){return this.units.map((u)=>u.power).reduce((a,b)=>a+b,0)}

  shuffle(array){
    for(let i=array.length-1;i>0;i--){
      let j=Math.floor(Math.random()*(i+1))
      let temp=array[i]
      array[i]=array[j]
      array[j]=temp
    }
    return array
  }

  generate(shuffle=true){
    let units=this.units.map((unit)=>unit.generate())
    if(shuffle) this.shuffle(units)
    return units
  }

  challenge(encounter){return encounter.power/this.power}
}

export class Encounters{
  constructor(team=[]){
    this.team=new Encounter(team.map((tier)=>new Unit(tier)))
    this.units=[]
    this.encounters=[]
    this.size=[1,3]
    this.shuffle=true
  }

  populate(tier,generator){
    let unit=new Unit(tier,generator)
    this.units.push(unit)
    return unit//return internal model for further control, such as adjusting power
  }

  encounter(index=0,units=[]){
    let e=new Encounter(units)
    let nunits=units.length
    let size=this.size
    let challenge=this.team.challenge(e)
    if(challenge>DEADLY||nunits>size[1]) return
    if(challenge>=TRIVIAL&&nunits>=size[0]) this.encounters.push(e)
    for(let i=index;i<this.units.length;i+=1){
      let next=Array.from(units)
      next.push(this.units[i])
      this.encounter(i,next)
    }
  }

  ready(){
    if(this.encounters.length>0) return true
    this.encounter()
    return this.encounters.length>0
  }

  generate(difficulty,internal=false){
    if(!this.ready()) return false
    let encounters=[]
    for(let encounter of this.encounters){
      let c=this.team.challenge(encounter)
      if(difficulty[0]<=c&&c<=difficulty[1]) encounters.push(encounter)
    }
    if(encounters.length==0) return false
    let encounter=dicem.pick(encounters)
    return internal?encounter:encounter.generate(this.shuffle)
  }

  list(){
    if(!this.ready()) return false
    return this.encounters.sort((a,b)=>a.power-b.power)
            .map((encounter)=>encounter.generate(this.shuffle))
  }

  get easy(){return this.generate(difficulty.easy)}

  get fair(){return this.generate(difficulty.fair)}

  get hard(){return this.generate(difficulty.hard)}

  get random(){return this.generate(difficulty.random)}

  tabulate(entries=20){
    if(!this.ready()) return false
    let encounters=[]
    while(encounters.length<entries){
      let e=this.generate(difficulty.random,true)
      if(e) encounters.push(e)
    }
    return encounters.sort((a,b)=>a.power-b.power)
            .map((encounter)=>encounter.generate(false))
  }
}

var difficulty=new Difficulty()

function test(members=1){
  for(let tier=1;tier<=5;tier+=1){
    let team=Array.from(new Array(members),()=>tier)
    let e=new Encounters(team)
    e.populate(1,()=>'Kobold')
    e.populate(2,()=>'Goblin')
    e.populate(3,()=>'Orc')
    e.populate(4,()=>'Ogre')
    e.populate(5,()=>'Troll')
    console.log(`Tier ${tier}`,
      {'easy':e.easy,'fair':e.fair,'hard':e.hard,'random':e.random})
  }
}
