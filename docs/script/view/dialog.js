import * as input from '../control/input.js'
import * as tables from '../control/table/tables.js'
import * as unit from '../model/unit.js'
import * as output from './output.js'

const VIEW=document.querySelector('#dialog')
const SEARCH=VIEW.querySelector('input')
const CHOICES=VIEW.querySelector('.choices')
const CHOICE=CHOICES.querySelector('template#choice').content.childNodes[0]
const TITLE=VIEW.querySelector('.title')
const PROFICIENCY=new Map([
  ['Terrible',1],
  ['Bad',2],
  ['Mediocre',3],
  ['Good',4],
  ['Exceptional',5],
])
const BONUSES=new Map([
  ['Trivial (+2)',+2],
  ['Easy (+1)',+1],
  ['Normal (+0)',+0],
  ['Hard (-1)',-1],
  ['Impossible (-2)',-2],
])
const NONE=new Object()

var active=false

export class Dialog{
  constructor(t='',choices=false){
    this.choices=choices||new Map()
    this.search=true
    this.title=t
    this.default=-1
    VIEW.removeAttribute('name')
  }
  
  select(choice){
    let selected=CHOICES.querySelector('.selected')
    if(selected) selected.classList.remove('selected')
    choice.classList.add('selected')
  }
  
  populate(){
    for(let c of CHOICES.querySelectorAll('.choice')) c.remove()
    for(let label of this.choices.keys()){
      let c=this.choices.get(label)
      let n=CHOICE.cloneNode(true)
      n.textContent=label
      n.onmouseenter=()=>this.select(n)
      n.onclick=()=>this.close(c)
      CHOICES.appendChild(n)
    }
  }
  
  filter(){
    let choices=Array.from(CHOICES.querySelectorAll('.choice'))
    let query=SEARCH.value.trim().toLowerCase().split(' ')
    for(let c of choices){
      let label=c.textContent.toLowerCase()
      let hide=false
      for(let q of query) if(!label.includes(q)) hide=true
      c.classList.toggle('hidden',hide)
    }
    let first=choices.find(r=>!r.classList.contains('hidden'))
    if(first) this.select(first)
  }

  press(key){
    let s=CHOICES.querySelector('.selected')
    if(key=='Enter'){
      if(s) s.click()
      return
    }
    if(key=='Escape'){
      this.close()
      return
    }
    let choices=Array.from(CHOICES.querySelectorAll('.choice'))
    choices=choices.filter(c=>!c.classList.contains('hidden'))
    let i=choices.indexOf(s)
    if(key=='ArrowDown'&&s&&i<choices.length-1){
      this.select(choices[i+1])
      return
    }
    if(key=='ArrowUp'&&s&&i>0){
      this.select(choices[i-1])
      return
    }
    if(this.search) return
    i=parseInt(key)
    if(!isNaN(i)&&0<i&&i<=choices.length) this.select(choices[i-1])
  }

  close(choice=NONE){
    input.deafen(press)
    VIEW.classList.add('hidden')
    active=false
    if(choice==NONE) this.reject('Dialog closed')
    else this.accept(choice)
  }
  
  input(){
    return new Promise((a,r)=>{
      this.open()
      this.accept=a
      this.reject=r
    })
  }
  
  open(){
    if(active) throw 'Cannot open another dialog!'
    let a=document.activeElement
    if(a) a.blur()
    active=this
    SEARCH.value=''
    SEARCH.onkeyup=e=>{
      let k=e.key
      if(k!='Backspace'&&k.length!=1) return
      this.filter()
      e.stopPropagation()
    }
    SEARCH.parentNode.classList.toggle('hidden',!this.search)
    VIEW.querySelector('.close').onclick=()=>this.close()
    TITLE.textContent=this.title
    this.populate()
    this.filter()
    VIEW.classList.remove('hidden')
    if(this.search) SEARCH.focus()
    let d=this.default
    if(d>=0) this.select(VIEW.querySelectorAll('.choice')[d])
    setTimeout(()=>input.listen(press),200)
  }
  
  name(n){VIEW.setAttribute('name',n)}
}

export class Skill extends Dialog{
  constructor(u,s){
    super(`${u.name}'s ${s}?`,PROFICIENCY)
    this.search=false
    this.default=2
  }
}

export class Target extends Dialog{
  constructor(){
    super('Select target:')
    for(let u of unit.units)
      this.choices.set(u.name,u)
  }
}

export class Bonus extends Dialog{
  constructor(){
    super('Apply bonus:',BONUSES)
    this.search=false
    this.default=2
  }
}

export class Template extends Dialog{
  constructor(){
    super('Select template to derive:')
    let choices=this.choices
    for(let t of unit.templates) choices.set(t.name,t)
    this.add='Create new template'
    choices.set(this.add,this.add)
  }
}

export class Tables extends Dialog{
  constructor(filter=true){
    super('Select a table:')
    for(let t of tables.tables)
      if(!filter||t.name.split(',').length<3)
        this.choices.set(t.name,t)
    this.name('tables')
  }
  
  async input(){
    let table=await super.input()
    let all=tables.tables
    all.splice(all.indexOf(table),1)
    all.splice(0,0,table)
    output.clear()
    output.say(table.roll()+table.end)
  }
}

function press(key){if(active) active.press(key)}
