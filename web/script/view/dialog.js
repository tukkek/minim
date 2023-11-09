import * as input from '../control/input.js'

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

var active=false

export class Dialog{
  constructor(t='',choices=false){
    this.choices=choices||new Map()
    this.search=true
    this.title=t
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
    let query=SEARCH.value.trim().toLowerCase()
    for(let c of choices){
      let label=c.textContent.toLowerCase()
      let hide=query.length>0&&!label.includes(query)
      c.classList.toggle('hidden',hide)
    }
    let s=choices.find(r=>r.classList.contains('selected'))
    if(s&&!s.classList.contains('hidden')) return
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

  close(choice){
    input.deafen(press)
    VIEW.classList.add('hidden')
    active=false
    if(choice) this.accept(choice)
    else this.reject('Dialog closed')
  }
  
  input(){
    return new Promise((a,r)=>{
      this.open()
      this.accept=a
      this.reject=r
    })
  }
  
  open(){
    active=this
    SEARCH.value=''
    SEARCH.onkeyup=e=>{if(e.key.indexOf('Arrow')<0) this.filter()}
    SEARCH.parentNode.classList.toggle('hidden',!this.search)
    VIEW.querySelector('.close').onclick=()=>this.close()
    TITLE.textContent=this.title
    this.populate()
    this.filter()
    VIEW.classList.remove('hidden')
    if(this.search) SEARCH.focus()
    setTimeout(()=>input.listen(press),100)
  }
}

export class Skill extends Dialog{
  constructor(u,s){
    super(`${u.name}'s ${s}?`,PROFICIENCY)
    this.search=false
    this.skill=s
    this.unit=u
  }
  
  open(){
    super.open()
    this.select(VIEW.querySelectorAll('.choice')[2])
  }
}

function press(key){if(active) active.press(key)}
