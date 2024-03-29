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
const FUMBLE=[
  ['is stunned','stunned'],
  ['is disarmed','disarmed'],
  ['falls','fallen'],
  ['is shaken','shaken'],
  ['interacts with ally (or enemy)',false],
  ['interacts with environment',false],
  ['begins grappling','grappling'],
  ['is disabled','disabled'], // only 'minor' actions next round
  ['is pinned','pinned'], // cannot move
  ['moves back',false],
]

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
  
  async act(unit){
    let m=await unit.modify()
    let result=0
    let rolls=[]
    for(let s of this.skills){
      s=s.toLowerCase()
      result+=await unit.roll(s)
      let value=await unit.get(s)
      let b=bonus
      let target=value+bonus+m
      if(b>=0) b='+'+b
      rolls.push(`${s} ${unitm.roll}≤${target}=${value}${b}-${Math.abs(m)}`)
    }
    let o=OUTCOME.get(result).toLowerCase()
    if(result==-2||result==+2) o+='!'
    let dice=rolls.join(', ').toLowerCase()
    output.test(unit,this,o,dice)
    return Promise.resolve(result)
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

class Order extends Test{
  constructor(){
    super('',['Social','Physical'])
    this.name='Determine order'
    this.group=true
  }
  
  async act(unit){
    let roll=await super.act(unit)
    let s=await unit.get('social')
    let p=await unit.get('physical')
    return Promise.resolve(roll*100+s*10+p)
  }
}

class Attack extends Test{
  constructor(skill){
    super('',['Physical',skill])
    this.name=skill+' attack'
  }
  
  fumble(unit){
    let f=rpg.pick(FUMBLE)
    output.say(`${unit.name} ${f[0]}.`)
    if(f[1]) unit.affect(f[1])
    db.store()
  }
  
  async target(){
    let d=new dialog.Target()
    let target=await d.input()
    return Promise.resolve(target)
  }
  
  async act(unit,target=false){
    let outcome=await super.act(unit)
    if(outcome==-2){
      this.fumble(unit)
    }else if(outcome==-1){
      //fail
    }else if(outcome==0){
      if(!target) target=await this.target()
      this.fumble(target)
    }else if(outcome>=+1){
      if(!target) target=await this.target()
      let w=await unit.get('weapon')
      let a=await target.get('armor')
      target.hit(w-a)
      if(target.life>0&&outcome==+2){
        let next=await this.act(unit,target)
        if(next>=+1) return Promise.resolve(+2)
      }
      let s=target.status.toLowerCase()
      output.say(`${target} is ${s}!`)
      db.store()
    }
    return Promise.resolve(outcome)
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

export var order=new Order()
export var actions=['Brawl','Shooting','Sports'].map(a=>new Attack(a)).concat([order])
export var bonus=0

var change=['weapon','armor','life']

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
