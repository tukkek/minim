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
  
  act(unit){
    let result=0
    for(let r of this.rolls) result+=unit.roll(r)
    return result
  }
  
  validate(unit){return true}
}

export class GroupAction extends Action{
  constructor(n,rolls=false){
    super(n,rolls)
  }
  
  validate(unit){return unit instanceof group.Group}
}

class Order extends Action{
  constructor(){
    super('Determine order',['physical','social'])
  }
}

export var order=new Order()
export var actions=[order]

export function setup(){
  let values=unit.values
  for(let v of values.keys()){
    actions.push(new Action(v+ ' test',[v,v]))
    for(let skill of values.get(v))
      actions.push(new Action(skill+' test',[skill,v]))
  }
}
