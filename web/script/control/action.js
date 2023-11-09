//TODO modify attack group
import * as output from '../view/output.js'
import * as unitm from '../model/unit.js'
import * as group from '../model/group.js'

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
    let text=[]
    for(let s of this.skills){
      let r=await unit.roll(s)
      text.push(`${s} ${unitm.roll}/${unit.skills.get(s.toLowerCase())}`)
      result+=r
    }
    text=[text.map((t,i)=>i==0?t:t.toLowerCase()).join(', ')+'.']
    let o=OUTCOME.get(result).toLowerCase()
    o+=result==-2||result==+2?'!':'.'
    text.push(`${unit.name}'s ${this.name.toLowerCase()}: ${o}`)
    output.say(text.join('<br/>'))
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
    super('Determine order',['physical','social'])
  }
}

class Modify extends Action{
  constructor(s){
    super('Modify '+s.toLowerCase())
    this.skill=s.toLowerCase()
  }
  
  async act(unit){
    let s=this.skill
    unit.skills.delete(s)
    await unit.roll(s)
  }
}

export var order=new Order()
export var actions=[order]

export function setup(){
  let values=unitm.values
  for(let v of values.keys()){
    actions.push(new Action(v+ ' test',[v,v]))
    actions.push(new Modify(v))
    for(let skill of values.get(v)){
      actions.push(new Action(skill+' test',[v,skill]))
      actions.push(new Modify(skill))
    }
  }
}
