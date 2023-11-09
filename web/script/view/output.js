import * as input from '../control/input.js'
import * as rpg from '../control/rpg.js'

const PARENT=document.querySelector('#output')
const VIEW=PARENT.querySelector('.text')
const ROLL=PARENT.querySelector('#roll')
const POOL=Array.from(PARENT.querySelectorAll('input'))

var pool=[1,6,+0]

export function say(text){
  VIEW.innerHTML+=text+'<br/><br/>'
  VIEW.scrollTo(0,VIEW.scrollHeight)
}

function close(){
  input.deafen(confirm)
  ROLL.classList.add('hidden')
}

function roll(){
  close()
  let rolling=POOL.map(p=>parseInt(p.value))
  if(rolling.includes(NaN)) return
  pool=rolling
  let roll=Array.from(new Array(pool[0]),()=>rpg.roll(1,pool[1]))
  let high=-Number.MAX_VALUE
  let low=Number.MAX_VALUE
  let sum=pool[2]
  for(let r of roll){
    if(r<low) low=r
    if(r>high) high=r
    sum+=r
  }
  say([
    `Rolled: ${roll.join(", ")}.`,
    `Sum: ${sum}.`,
    `Highest: ${high}.`,
    `Lowest: ${low}.`,
  ].join('<br/>'))
}

function confirm(key){
  if(key=='Enter') roll()
  else if(key=='Escape') close()
}

function open(){
  input.listen(confirm)
  for(let i=0;i<3;i++) POOL[i].value=pool[i]
  ROLL.classList.remove('hidden')
  POOL[0].select()
}

export function setup(){
  PARENT.querySelector('.clear').onclick=()=>VIEW.innerHTML=''
  ROLL.querySelector('button').onclick=roll
  PARENT.querySelector('.roll').onclick=()=>open()
}
