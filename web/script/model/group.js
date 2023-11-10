import * as db from '../control/db.js'
import * as rpg from '../control/rpg.js'
import * as actionm from '../control/action.js'
import * as unit from './unit.js'

export var groups=[]

export class Group{
  constructor(n){
    if(!n) throw 'group needs name'
    this.name=n
    this.names=[]
  }
  
  toString(){return this.name}
  
  add(){
    groups.push(this)
    db.store()
  }
  
  remove(){
    groups.splice(groups.indexOf(this),1)
    for(let m of this.members) m.hidden=false
    db.store()
  }
  
  rename(n){
    this.name=n
    db.store()
  }
  
  get members(){
    let members=Array.from(this.names)
    for(let i=0;i<members.length;i++)
      members[i]=unit.units.find(u=>u.name==members[i])
    return members
  }
  
  async order(){return await rpg.choose(this.members).order()}
  
  async act(action){
    if(action.group) for(let m of this.members) await m.act(action)
    else await action.act(this)
    return Promise.resolve()
  }
}
