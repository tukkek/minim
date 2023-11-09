import * as db from '../control/db.js'
import * as rpg from '../control/rpg.js'
import * as dialog from '../view/dialog.js'
import * as group from './group.js'

export var values=new Map([
  ['Physical',['Brawl','Coordination','Shooting','Sports','Steal']],
  ['Mental',['Art','Cure','Security','Technology','Knowledge']],
  ['Social',['Animals','Coercion','Communication','Languages','Perception']]
])
export var units=[]

export class Unit{
  constructor(n){
    if(!n) throw 'unit needs name'
    this.name=n
    this.effects=[]
    this.hidden=false
    this.skills=new Map()
  }
  
  affect(effect){this.effects.push(effect)}
  
  end(effect){
    let effects=this.effects
    let i=effects.indexOf(effect)
    if(i<0) return
    effects.splice(i,1)
    this.save()
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
    return await new dialog.Skill(this,skill).input()
  }
  
  async roll(skill){
    skill=await this.get(skill)
    let r=rpg.roll(1,6)
    if(r==6) return -1
    if(r==1) return +1
    if(r==skill) return +0
    return r<skill?+1:-1
  }
}
