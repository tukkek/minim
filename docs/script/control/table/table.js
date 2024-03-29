import * as rpg from '../rpg.js'

export class Table{
  constructor(n,lines=[]){
    if(!n) throw new Error('Table needs name')
    this.lines=lines//[string,Table...]
    this.name=n
    this.end='.'
  }
  
  roll(){
    try{
      let p=rpg.pick(this.lines)
      return p.roll?p.roll():p
    }catch(e){
      console.log(this.name,e)
    }
  }
  
  add(l,count=1){
    count=Math.round(count)
    for(let i=0;i<count;i++) this.lines.push(l)
  }
  
  toString(){return this.roll()}
  
  get unique(){return new Set(this.lines)}
}
