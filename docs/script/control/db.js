import Dexie from '../../lib/dexie.min.mjs'
import * as unit from '../model/unit.js'
import * as group from '../model/group.js'
import * as notesm from './notes.js'

var data=new Dexie("minim")
var dirty=false

async function replace(table,objects){
  await table.toCollection().delete()
  table.bulkPut(objects)
  return Promise.resolve()
}

function save(){
  if(!dirty) return
  dirty=false
  replace(data.units,unit.units)
  replace(data.templates,unit.templates)
  replace(data.groups,group.groups)
  data.notes.put({title:'notes',body:notesm.notes.value})
}

export async function setup(){
  let tables={units:'name',templates:'name',groups:'name',
              notes:'title'}
  await data.version(1).stores(tables)
  data.units.mapToClass(unit.Unit)
  data.templates.mapToClass(unit.Template)
  data.groups.mapToClass(group.Group)
  setInterval(save,1000/3)
  return Promise.resolve()
}

export function store(){dirty=true}

function load(table,array){
  return new Promise(async function(done){
    let objects=await table.toArray()
    array.push(...objects)
    done()
  })
}

export async function restore(){
  return Promise.all([
    load(data.units,unit.units),
    load(data.templates,unit.templates),
    load(data.groups,group.groups),
    new Promise(async function(done){
      let b=await data.notes.get({title:'notes'})
      if(b) notesm.notes.textContent=b.body
      done()
    })
  ])
}
