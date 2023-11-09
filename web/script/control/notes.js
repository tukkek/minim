import * as db from './db.js'

const VIEW=document.querySelector('#notes')

export var notes=VIEW

var dirty=false

function save(){
  if(!dirty) return
  db.store()
  dirty=false
}

export async function setup(){
  VIEW.onkeyup=()=>dirty=true
  setInterval(save,1*1000)
}
