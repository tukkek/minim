//TODO modify attack group
import * as output from '../view/output.js'
import * as unit from '../model/unit.js'
import * as group from '../model/group.js'

export class Action{
  constructor(n,rolls=false){
    this.name=n
    this.rolls=rolls
  }
  
  toString(){return this.name}
  
  act(unit){output.say([unit.name,this.name])}
  
  validate(unit){return true}
}

export class GroupAction extends Action{
  constructor(n,rolls=false){
    super(n,rolls)
  }
  
  validate(unit){return unit instanceof group.Group}
}

export var actions=[]

export function setup(){
  let values=unit.values
  for(let v of values.keys()){
    actions.push(new Action(v+ ' test',[v,v]))
    for(let skill of values.get(v))
      actions.push(new Action(skill+' test',[skill,v]))
  }
}
