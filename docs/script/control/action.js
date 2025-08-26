import * as output from '../view/output.js'
import * as dialog from '../view/dialog.js'
import * as unitm from '../model/unit.js'
import * as group from '../model/group.js'
import * as db from './db.js'
import * as rpg from './rpg.js'

const OUTCOME=new Map([
  [-2,'Terrible'],
  [-1,'Failure'],
  [ 0,'Neutral'],
  [+1,'Success'],
  [+2,'Amazing'],
])
const GRAPPLING='grappling'
const FUMBLE=[
  ['is stunned','stunned'],
  ['falls','fallen'],
  ['is disarmed','disarmed'],
  ['is shaken','shaken'],
  ['interacts with enemy',false],
  ['interacts with environment',false],
  ['interacts with ally',false],
  ['moves back','back'],
  ['is disabled','disabled'], // can only move
  ['is pinned','pinned'], // cannot move
  ['begins grappling',GRAPPLING],
  false,
  false,
].reverse()

export class Action{
  constructor(n){
    this.name=n
    this.group=false//see group.Group#act()
  }
  
  act(unit){throw 'unimplemented'}
  
  toString(){return this.name}
  
  validate(unit){return true}
  
  async prepare(){return Promise.resolve()}
  
  async finish(){return Promise.resolve()}
}

class Test extends Action{
  constructor(name,skills){
    super(name+' test')
    this.skills=skills
    this.group=true
  }

  sign(number){return number<0?new String(number):`+${number}`}

  compare(number1,number2){
    let symbol='='
    if(number1>number2) symbol='>'
    else if(number1<number2) symbol='<'
    return [number1,symbol,number2].join('')
  }

  async act(unit){
    let hits=0
    let details=[]
    for(let skill of this.skills.map((skill)=>skill.toLowerCase())){
      hits+=await unit.roll(skill)
      let value=await unit.get(skill)
      let comparison=this.compare(unitm.roll,rpg.bind(1,value+bonus,5))
      let calculation=`(${[value,this.sign(bonus)].join('')})`
      details.push([skill,comparison,calculation].join(' '))
    }
    details=details.join('; ')
    details=details[0].toUpperCase()+details.slice(1).toLowerCase()
    let punctuation=hits==-2||hits==+2?'!':'.'
    let outcome=OUTCOME.get(hits).toLowerCase()+punctuation
    output.test(unit,this,outcome,details)
    return Promise.resolve(hits)
  }
  
  async prepare(){
    let d=new dialog.Bonus()
    bonus=await d.input()
    return Promise.resolve(bonus)
  }
  
  async finish(){
    bonus=0
    return Promise.resolve(bonus)
  }
}

class Attack extends Test{
  constructor(skill){
    super('',['Brawl',skill])
    this.name=skill+' attack'
  }
  
  fumble(unit,unit2){
    let fumble=FUMBLE[rpg.rolldice(2,6)]
    output.say(`${unit.name} ${fumble[0]}.`)
    let effect=fumble[1]
    if(effect){
      let targets=[unit]
      if(effect==GRAPPLING&&unit2) targets.push(unit2)
      for(let target of targets) target.affect(effect)
    }
    db.store()
  }
  
  async target(){
    let d=new dialog.Target()
    let target=await d.input()
    return Promise.resolve(target)
  }
  
  async act(unit,target=false){
    let hits=await super.act(unit)
    if(!target)
      target=await this.target()
    if(hits>0){
      let weapon=await unit.get('weapon')
      let armor=await target.get('armor')
      await target.hit(weapon-armor)
      if(target.life>0&&hits==+2){
        let next=await this.act(unit,target)
        if(next>0) return Promise.resolve(+2)
      }
      output.say(`${target} is ${target.status.toLowerCase()}!`)
      db.store()
    }else if(hits==0) this.fumble(target,unit)
    else if(hits==-2) this.fumble(unit,target)
    return Promise.resolve(hits)
  }
}

class Change extends Action{
  constructor(s){
    super('Change '+s.toLowerCase())
    this.skill=s.toLowerCase()
    this.group=true
  }
  
  async act(unit){
    let t=unit.template
    if(t) unit=t
    let d=new dialog.Skill(unit,this.skill)
    let s=unit.skills.get(this.skill)
    if(s) d.default=s-1
    s=await d.input()
    unit.skills.set(this.skill,s)
    db.store()
  }
}

export var actions=['Fight','Shooting','Sports'].map(a=>new Attack(a))
export var bonus=0

var change=['weapon','armor']

export function setup(){
  let values=unitm.values
  for(let v of values.keys()){
    actions.push(new Test(v,[v,v]))
    change.push(v)
    for(let skill of values.get(v)){
      actions.push(new Test(skill,[v,skill]))
      change.push(skill)
    }
  }
  actions.push(...change.map(c=>new Change(c)))
}
