const TEST=false
const LAST={
  enumerable:false,
  configurable:false,
  get(){return this[this.length-1]}
}
const PROTOTYPE=Array.prototype
const FILTER=PROTOTYPE.filter

function remove(item){
  let i=this.indexOf(item)
  if(i<0) return false
  this.splice(i,1)[0]
  return true
}

function filter(call,self){
  if(!call) call=(item)=>item
  return FILTER.call(this,call,self)
}

if(!PROTOTYPE.remove) PROTOTYPE.remove=remove
if(!PROTOTYPE.last) Object.defineProperty(PROTOTYPE,'last',LAST)
PROTOTYPE.filter=filter

if(TEST){
  let list=[1,2,3]
  if(list.remove(2)!=2) throw `Wrong removed-item!`
  if(list[0]!=1||list[1]!=3) throw `Wrong removed-list state!`
  if(list.last!=3) throw `Wrong last element!`
  console.log('Array Enhancer: tests passed!')
}
