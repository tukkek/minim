//TODO determine order, templates
import * as unit from '../model/unit.js'
import * as action from '../control/action.js'
import * as input from '../control/input.js'
import * as units from './units.js'

const VIEW=document.querySelector('#actions')
const SEARCH=VIEW.querySelector('input')
const RESULTS=VIEW.querySelector('.results')
const RESULT=RESULTS.querySelector('template#result').content.childNodes[0]
const ACTIONS=[]
const ACTIVE=VIEW.querySelector('.active span')

export function setup(){
  SEARCH.onkeyup=e=>{if(e.key.indexOf('Arrow')<0) search()}
  VIEW.querySelector('.close').onclick=close
  ACTIONS.push(...action.actions)
  ACTIONS.push(...units.actions)
  ACTIONS.sort((a,b)=>a.name.localeCompare(b.name))
}

function press(key){
  let s=RESULTS.querySelector('.selected')
  if(key=='Enter'){
    if(s) s.click()
    return
  }
  if(key=='Escape'){
    close()
    return
  }
  let results=Array.from(RESULTS.querySelectorAll('.result'))
  let i=results.indexOf(s)
//   console.log(i)
  if(key=='ArrowDown'&&s&&i<results.length-1){
    select(results[i+1])
    return
  }
  if(key=='ArrowUp'&&s&&i>0){
    select(results[i-1])
    return
  }
}

function select(result){
  let selected=RESULTS.querySelector('.selected')
  if(selected) selected.classList.remove('selected')
  result.classList.add('selected')
}

function close(){
  input.deafen(press)
  VIEW.classList.add('hidden')
}

function act(action){
  ACTIONS.splice(ACTIONS.indexOf(action),1)
  ACTIONS.splice(0,0,action)
  action.act(units.active)
  close()
}

export function search(){
  for(let r of RESULTS.querySelectorAll('.result')) r.remove()
  let query=SEARCH.value.trim()
  let selected=false
  let u=units.active
  for(let a of ACTIONS){
    if(!a.validate(u)) continue
    let name=a.name.toLowerCase()
    if(query.length>0&&!name.includes(query)) continue
    let r=RESULT.cloneNode(true)
    r.textContent=a.name
    r.onmouseenter=()=>select(r)
    r.onclick=()=>act(a)
    if(!selected){
      select(r)
      selected=r
    }
    RESULTS.appendChild(r)
  }
}

export function open(){
  SEARCH.value=''
  search()
  ACTIVE.textContent=units.active.name
  VIEW.classList.remove('hidden')
  SEARCH.focus()
  setTimeout(()=>input.listen(press),100)
}
