import * as db from '../control/db.js'
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
}
