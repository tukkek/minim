//TODO modify attack group
import * as output from '../view/output.js'
import * as dialog from '../view/dialog.js'
import * as unitm from '../model/unit.js'
import * as group from '../model/group.js'
import * as db from './db.js'

const OUTCOME=new Map([
  [-2,'Terrible'],
  [-1,'Failure'],
  [ 0,'Neutral'],
  [+1,'Success'],
  [+2,'Amazing'],
])

export class Action{
  constructor(n,skills=false){
    this.name=n
    this.skills=skills
  }
  
  toString(){return this.name}
  
  async act(unit){
    let result=0
    let rolls=[]
    for(let s of this.skills){
      s=s.toLowerCase()
      let r=await unit.roll(s)
      rolls.push(`${s} ${unitm.roll}/${unit.skills.get(s)}`)
      result+=r
    }
    let o=OUTCOME.get(result).toLowerCase()
    if(result==-2||result==+2) o+='!'
    o=`<strong>${o}</strong>`
    let dice=rolls.join(', ').toLowerCase()
    dice=`<small>${dice}</small>`
    let n=`<strong>${unit.name}</strong>`
    output.say(`${n}'s ${this.name.toLowerCase()}: ${o} (${dice}).`) //TODO template
    return result
  }
  
  validate(unit){return true}
}

export class GroupAction extends Action{
  constructor(n,skills=false){
    super(n,skills)
  }
  
  validate(unit){return unit instanceof group.Group}
}

class Order extends Action{
  constructor(){
    super('Determine order',['Social','Physical'])
  }
  
  async act(unit){
    let roll=await super.act(unit)
    let s=await unit.get('social')
    let p=await unit.get('physical')
    return roll*100+s*10+p
  }
}

class Change extends Action{
  constructor(s){
    super('Change '+s.toLowerCase())
    this.skill=s.toLowerCase()
  }
  
  async act(unit){
    let d=new dialog.Skill(unit,this.skill)
    let s=unit.skills.get(this.skill)
    if(s) d.default=s-1
    s=await d.input()
    unit.skills.set(this.skill,s)
    db.store()
  }
}

export var order=new Order()
export var actions=[order]

export function setup(){
  let values=unitm.values
  for(let v of values.keys()){
    actions.push(new Action(v+ ' test',[v,v]))
    actions.push(new Change(v))
    for(let skill of values.get(v)){
      actions.push(new Action(skill+' test',[v,skill]))
      actions.push(new Change(skill))
    }
  }
}
