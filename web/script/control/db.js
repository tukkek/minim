import Dexie from '../../lib/dexie.min.mjs'
import * as unit from '../model/unit.js'
import * as group from '../model/group.js'
import * as notesm from './notes.js'

export var groups=false
export var units=false

var data=new Dexie("minim");
var notes=false
var dirty=false

async function save(){
  if(!dirty) return
  dirty=false
  await notes.put({title:'notes',body:notesm.notes.value})
  await units.toCollection().delete()
  await units.bulkPut(unit.units)
  await groups.toCollection().delete()
  await groups.bulkPut(group.groups)
}

export async function setup(){
//   data.delete()
  await data.version(1).stores({units:'name',notes:'title',groups:'name'});
  units=data.units
  notes=data.notes
  groups=data.groups
  units.mapToClass(unit.Unit)
  groups.mapToClass(group.Group)
  setInterval(save,1000)
}

export async function store(){dirty=true}

export async function restore(){
  let b=await notes.get({title:'notes'})
  if(b) notesm.notes.textContent=b.body
  unit.units.push(...await units.toArray())
  group.groups.push(...await groups.toArray())
}
