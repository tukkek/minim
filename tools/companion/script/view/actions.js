import * as action from '../control/action.js'
import * as units from './units.js'
import * as dialog from './dialog.js'

const ACTIONS=[]

export function setup(){
  ACTIONS.push(...action.actions)
  ACTIONS.push(...units.actions)
  ACTIONS.sort((a,b)=>a.name.localeCompare(b.name))
}

export async function open(){
  let actions=new Map()
  let u=units.active
  for(let a of ACTIONS) if(a.validate(u))
    actions.set(a.name,a)
  let d=new dialog.Dialog(`${u.name}'s action?`,actions)
  let action=await d.input()
  ACTIONS.splice(ACTIONS.indexOf(action),1)
  ACTIONS.splice(0,0,action)
  try{
    await action.prepare()
    await u.act(action)
    return Promise.resolve()
  }finally{
    await action.finish()
  }
}
