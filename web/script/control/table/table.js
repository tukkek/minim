import * as rpg from '../rpg.js'

export class Table{
  constructor(n,lines=[]){
    this.lines=lines//[string,Table...]
    this.name=n
    this.end='.'
  }
  
  roll(){
    let p=rpg.pick(this.lines)
    return p.roll?p.roll():p
  }
  
  add(l,count=1){for(let i=0;i<count;i++) this.lines.push(l)}
  
  toString(){return this.roll()}
}
