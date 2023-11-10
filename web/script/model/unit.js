import * as db from '../control/db.js'
import * as rpg from '../control/rpg.js'
import * as action from '../control/action.js'
import * as dialog from '../view/dialog.js'
import * as group from './group.js'

const STATUS=new Map([
  [5,'Unharmed'],
  [4,'Scratched'],
  [3,'Hurt'],
  [2,'Wounded'],
  [1,'Dying'],
  [0,'Dead']
])

export var values=new Map([
  ['Physical',['Brawl','Coordination','Shooting','Sports','Steal']],
  ['Mental',['Art','Cure','Security','Technology','Knowledge']],
  ['Social',['Animals','Coercion','Communication','Languages','Perception']]
])
export var units=[]
export var roll=-1//last roll

export class Unit{
  constructor(n){
    if(!n) throw 'unit needs name'
    this.skills=new Map([['life',5]])
    this.hidden=false
    this.effects=[]
    this.name=n
  }
  
  affect(effect){this.effects.push(effect)}
  
  end(effect){
    let effects=this.effects
    let i=effects.indexOf(effect)
    if(i<0) return
    effects.splice(i,1)
    db.store()
  }
  
  add(){
    units.push(this)
    db.store()
  }
  
  remove(){
    units.splice(units.indexOf(this),1)
    for(let g of group.groups){
      let names=g.names
      let i=names.indexOf(this.name)
      if(i>=0) names.splice(i,1)
    }
    db.store()
  }
  
  rename(name){
    for(let g of group.groups){
      let names=g.names
      let i=names.indexOf(this.name)
      if(i>=0) names[i]=name
    }
    this.name=name
    db.store()
  }
  
  async get(skill){
    skill=skill.toLowerCase()
    let value=this.skills.get(skill)
    if(value) return Promise.resolve(value)
    let d=new dialog.Skill(this,skill)
    value=await d.input()
    this.skills.set(skill,value)
    db.store()
    return Promise.resolve(value)
  }
  
  async roll(skill){
    skill=await this.get(skill)
    skill+=action.bonus
    if(skill<1) skill=1
    else if(skill>5) skill=5
    roll=rpg.roll(1,6)
    if(roll==6) return -1
    if(roll==1) return +1
    if(roll==skill) return +0
    return roll<skill?+1:-1
  }
  
  toString(){return this.name}
  
  async order(){return await action.order.act(this)}
  
  async act(action){Promise.resolve(await action.act(this))}
  
  hit(hits){
    if(hits<1) hits=1
    let s=this.skills
    let l=s.get('life')
    l-=hits
    if(l<0) l=0
    s.set('life',l)
    if(l==0) this.remove()
  }
  
  get life(){return this.skills.get('life')}
  
  get status(){return STATUS.get(this.life)}
}
