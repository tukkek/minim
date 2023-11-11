import * as input from '../control/input.js'
import * as rpg from '../control/rpg.js'

const PARENT=document.querySelector('#output')
const VIEW=PARENT.querySelector('.text')
const ROLL=PARENT.querySelector('#roll')
const POOL=Array.from(PARENT.querySelectorAll('input'))
const MESSAGE=VIEW.querySelector('template#message').content.children[0]
const TEST=VIEW.querySelector('template#test').content.children[0]
const HELP=`
  Welcome to the Minim Companion! You can read the full Minim rules <a href='https://github.com/tukkek/minim/' target='_blank'>here</a>.

  <strong>Units</strong> are individual characters in your game - click on them to perform actions! <strong>Templates</strong> are units that have the same skills (for example: "Rat 1", "Rat 2")... <strong>Groups</strong> are sets of units that can perform actions together (for example: helps to have the whole group "Player party" test Perception at the same time). Templates and groups have some actions not available to plain units (like Hide Members, Regroup and Remove Template).

  Many functions can be accessed via keyboard keys, including units and dialog choices! For example:
  %commands`.trim()

var pool=[1,6,+0]

function append(c){
  VIEW.appendChild(c)
  VIEW.scrollTo(0,VIEW.scrollHeight)
}

export function say(html){
  let m=MESSAGE.cloneNode(true)
  m.innerHTML=html
  append(m)
}

function close(){
  input.deafen(confirm)
  ROLL.classList.add('hidden')
}

function roll(){
  close()
  let rolling=POOL.map(p=>parseInt(p.value))
  if(rolling.includes(NaN)||rolling.slice(0,2).includes(0)) return
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

function help(){
  clear()
  let commands=Array.from(document.querySelectorAll('*[accesskey]'))
  commands=commands.map(c=>`<strong>${c.getAttribute('accesskey')}</strong> for ${c.textContent}`)
  let h=HELP.replace('%commands',commands.join(', ')).replaceAll('\n','<br/>')
  say(`<small>${h}</small>`)
}

function text(node,q,t){node.querySelector(q).textContent=t}

export function test(unit,action,outcome,dice){
  let t=TEST.cloneNode(true)
  let fields=[['.unit',unit.name],['.action',action.name.toLowerCase()],
              ['.outcome',outcome],['.dice span',dice]]
  for(let f of fields) text(t,f[0],f[1])
  append(t)
}

export function clear(){VIEW.innerHTML=''}

export function setup(){
  PARENT.querySelector('.clear').onclick=clear
  ROLL.querySelector('button').onclick=roll
  PARENT.querySelector('.roll').onclick=()=>setTimeout(open,100)
  PARENT.querySelector('.help').onclick=()=>help()
  help()
}
