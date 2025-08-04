import * as realm from './real.js'
import * as tablem from './table.js'
import * as rpgm from '../rpg.js'

const ANALYST=new tablem.Table('Scene, verb, analysis',['Plan','Logic','Command','Debate'])
const DIPLOMAT=new tablem.Table('Scene, verb, diplomacy',['Advocate','Mediate','Lead','Campaign'])
const ACTION=new tablem.Table('Scene, verb, action',['Move','Defend','Execute','Help'])
const EXPLORER=new tablem.Table('Scene, verb, exploration',
                                ['Experiment','Adventure','Build','Entertain'])
const TYPES=[ANALYST,DIPLOMAT,ACTION,EXPLORER]
const REWARD=new tablem.Table('Scene, reward',['Glory','Wisdom','Sustenance','Wealth'])

class Task extends tablem.Table{
  constructor(){super('Scene, task')}

  roll(){
    let adjective=rpgm.pick(realm.traits).roll()
    let verb=rpgm.pick(TYPES)
    let type=verb.name.split(',').last.trim()
    let task=`${adjective} ${type} (${verb.roll()})`
    return task[0].toUpperCase()+task.slice(1).toLowerCase()
  }
}

class Trait extends tablem.Table{
  constructor(tiers){super('Scene, trait',tiers)}

  roll(){
    let rolls=Array.from(new Array(3),()=>rpgm.roll(0,this.lines.length-1)).sort()
    return this.lines[rolls[1]]
  }
}

class Scene extends tablem.Table{
  constructor(){super('Scene')}

  roll(){
    let task=new Task().roll()
    let traits=[
      new Trait(['Stupid','Dull','Reasonable','Smart','Genius']),
      new Trait(['Disabled','Slow','Able','Fast','Olympic']),
      new Trait(['Collapsing','Weak','Healthy','Hardened','Steeled']),
    ].reverse().join('; ')
    return [
      task,
      traits,
      `Reward: ${REWARD.roll().toLowerCase()}`,
    ].map((line)=>line[0].toUpperCase()+line.slice(1).toLowerCase()).join('<br>')
  }
}

export var tables=[new Task(),TYPES,new Scene(),REWARD].flat()
