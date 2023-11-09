import * as db from '../control/db.js'
import * as input from '../control/input.js'
import * as action from '../control/action.js'
import * as actionsm from './actions.js'
import * as unitm from '../model/unit.js'
import * as groupm from '../model/group.js'

const VIEW=document.querySelector('#units')
const UNIT=VIEW.querySelector('template#unit').content.children[0]
const EFFECT=UNIT.querySelector('template#effect').content.children[0]
const GROUPER=VIEW.querySelector('#grouper')
const MEMBER=GROUPER.querySelector('template#member').content.children[0]

class Remove extends action.Action{
  constructor(){
    super('Remove unit')
  }
  
  act(unit){
    unit.remove()
    update()
  }
}

class Rename extends action.Action{
  constructor(){
    super('Rename unit')
  }
  
  async act(unit){
    let n=unit.name
    let p=prompt('Name this unit',n)
    if(!p) return
    unit.rename(p)
    update()
  }
}

class Regroup extends action.GroupAction{
  constructor(){
    super('Modify group')
  }
  
  async apply(unit){
    let names=[]
    for(let m of GROUPER.querySelectorAll('.member')){
      if(!m.querySelector('input').checked) continue
      names.push(m.unit.name)
    }
    unit.names=names
    GROUPER.classList.add('hidden')
    db.store()
  }
  
  act(unit){
    let units=Array.from(VIEW.querySelectorAll('.unit'))
    units=units.map(u=>u.unit).filter(u=>u instanceof unitm.Unit)
    if(units.length==0){
      alert('No characters found.')
      return
    }
    GROUPER.querySelector('.group').textContent=unit.name
    let members=GROUPER.querySelector('.members')
    for(let m of members.querySelectorAll('.member')) m.remove()
    let first=true
    let current=unit.names
    for(let u of units){
      let m=MEMBER.cloneNode(true)
      m.unit=u
      m.querySelector('span').textContent=u.name
      let i=m.querySelector('input')
      i.checked=current.length==0||current.find(c=>c==u.name)
      members.appendChild(m)
      if(first){
        setTimeout(()=>i.focus(),100)
        first=false
      }
    }
    GROUPER.querySelector('button').onclick=()=>this.apply(unit)
    setTimeout(()=>GROUPER.classList.remove('hidden'),100)
  }
}

class Hide extends action.GroupAction{
  constructor(name='Hide members',h=true){
    super(name)
    this.hide=h
  }
  
  act(group){
    for(let m of group.members) m.hidden=this.hide
    update()
    db.store()
  }
}

export var regroup=new Regroup()
export var active=false
export var actions=[new Remove(),new Rename(),regroup,new Hide(),new Hide('Show members',false)]

function get(unit){
  return Array.from(VIEW.querySelectorAll('.unit')).find(u=>u.unit.name==unit.name)
}

function act(unit,button=false){
  if(button) button.focus()
  active=unit
  setTimeout(()=>actionsm.open(),100)
}

function draw(unit){
  if(unit.hidden) return
  let parent=get(unit)
  if(!parent){
    parent=UNIT.cloneNode(true)
    VIEW.appendChild(parent)
  }
  let b=parent.querySelector('button')
  b.onclick=()=>act(unit,b)
  b.textContent=unit.name
  b.setAttribute('accesskey',unit.name[0].toLowerCase())
  parent.unit=unit
  parent.trash=false
  let effects=parent.querySelector('.effects')
  for(let e of effects.querySelectorAll('.effect')) e.remove()
  if(unit.effects) for(let e of unit.effects){
    let effect=EFFECT.cloneNode(true)
    effect.textContent=e
    effect.onclick=()=>unit.end(e)
    effects.appendChild(effect)
  }
}

async function update(){
  let units=Array.from(VIEW.querySelectorAll('.unit'))
  for(let u of units) u.trash=true
  for(let u of unitm.units) draw(u)
  for(let g of groupm.groups) draw(g)
  for(let u of units) if(u.trash) u.remove()
}

async function listen(transaction){transaction.on('complete',update)}

function press(key){
  if(!GROUPER.classList.contains('hidden')){
    if(key=='Enter') GROUPER.querySelector('button').click()
    else if(key=='Escape') GROUPER.classList.add('hidden')
    return
  }
  key=key.toLowerCase()
  let units=Array.from(VIEW.querySelectorAll(`button[accesskey="${key}"]`))
  if(units.length==0) return
  if(units.length==1){
    let b=units[0]
    b.focus()
    b.click()
    return
  }
  let focus=units.indexOf(document.activeElement)+1
  if(focus>=units.length) focus=0
  units[focus].focus()
}

export async function setup(){
  update()
  input.listen(press)
  VIEW.querySelector('.invite').onclick=()=>{
    new unitm.Unit(prompt('Unit name:')).add()
    update()
  }
  VIEW.querySelector('.group').onclick=()=>{
    let g=new groupm.Group(prompt('Group name:'))
    g.add()
    update()
    regroup.act(g)
  }
}
