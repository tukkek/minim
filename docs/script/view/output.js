import * as input from '../control/input.js'
import * as rpg from '../control/rpg.js'
import * as dialog from './dialog.js'

const PARENT=document.querySelector('#output')
const VIEW=PARENT.querySelector('.text')
const MESSAGE=VIEW.querySelector('template#message').content.children[0]
const TEST=VIEW.querySelector('template#test').content.children[0]
const HELP=`
  Welcome to the Minim Companion! You can read the full Minim rules <a href='https://github.com/tukkek/minim/' target='_blank'>here</a>.

  <strong>Units</strong> are individual characters in your game - click on them to perform actions! <strong>Templates</strong> are units that have the same skills (for example: "Rat 1", "Rat 2")... <strong>Groups</strong> are sets of units that can perform actions together (for example: helps to have the whole group "Player party" test Perception at the same time). Templates and groups have some actions not available to plain units (like Hide Members, Regroup and Remove Template).

  Many functions can be accessed via keyboard keys, including units and dialog choices! For example:
  %commands`.trim()
const COPY=PARENT.querySelector('.copy')

class Roller{
  constructor(){
    this.dice=1
    this.sides=6
    this.bonus=+0
    this.result=[]
  }

  template(){
    let dice=this.dice
    let sides=this.sides
    let bonus=this.bonus
    if(bonus>=0) bonus=`+${bonus}`
    return `${dice}d${sides}${bonus}`
  }

  roll(){
    let prompt=window.prompt('Type your roll:',this.template())
    if(!prompt) return false
    let roll=prompt.split(/[d+-]/).map((text)=>Number(text))
    let dice=roll[0]
    this.dice=dice
    let sides=roll[1]
    this.sides=sides
    let bonus=roll.length>2?roll[2]:+0
    if(prompt.includes('-')) bonus*=-1
    this.bonus=bonus
    this.result=Array.from(new Array(dice),()=>rpg.roll(1,sides))
                      .sort((number1,number2)=>number1-number2)
    return true
  }

  sum(){
    let sum=this.bonus
    for(let r of this.result) sum+=r
    return sum
  }

  get middle(){return this.result[Math.floor(this.result.length/2)]}
}

class Pooler extends Roller{
  constructor(){
    super()
    this.target=-1
    this.hits=0
    this.misses=0
  }

  template(){return `${this.dice}d${this.sides}`}

  roll(){
    if(!super.roll()) return false
    let target=this.target
    if(target<0) target=Math.round(Math.floor(this.sides/2))
    target=Number(window.prompt('Target to roll-against?',target))
    if(!target) return false
    this.target=target
    let result=pooler.result
    let hits=result.filter((number)=>number<=target).length
    this.hits=hits
    this.misses=result.length-hits
    return true
  }
}

var roller=new Roller()
var pooler=new Pooler()

function append(c){
  VIEW.appendChild(c)
  VIEW.scrollTo(0,VIEW.scrollHeight)
}

export function say(html){
  let m=MESSAGE.cloneNode(true)
  m.innerHTML=html
  append(m)
}

function roll(){
  if(!roller.roll()) return
  clear()
  say([
    `Rolled: ${roller.result.join('; ')}.`,
    `Result: ${roller.sum()}.`,
    `Middle: ${roller.middle}.`
  ].join('<br/>'))
}

function pool(){
  if(!pooler.roll()) return
  clear()
  say([
    `Rolled: ${pooler.result.join('; ')}.`,
    `Hits: ${pooler.hits}.`,
    `Misses: ${pooler.misses}.`
  ].join('<br/>'))
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

export async function copy(){
  let text=VIEW.innerText
  await navigator.clipboard.write([new ClipboardItem({['text/plain']:text})])
  COPY.innerText='Copied'
  setTimeout(()=>COPY.innerText='Copy',1_000)
}

export function setup(){
  PARENT.querySelector('.clear').onclick=clear
  PARENT.querySelector('.roll').onclick=()=>roll()
  PARENT.querySelector('.pool').onclick=()=>pool()
  PARENT.querySelector('.help').onclick=()=>help()
  PARENT.querySelector('.tables').onclick=()=>new dialog.Tables(true).input()
  PARENT.querySelector('.alltables').onclick=()=>new dialog.Tables(false).input()
  COPY.onclick=()=>copy()
  help()
}
