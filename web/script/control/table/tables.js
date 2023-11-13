import * as adungeon from './adventure/dungeon.js'
import * as type from './adventure/type.js'
import * as bold from './bold.js'
import * as combat from './combat.js'
import * as conjectural from './conjectural.js'
import * as cyberpunk from './cyberpunk.js'
import * as falkenstein from './falkenstein.js'
import * as darkness from './darkness/darkness.js'

export var tables=[adungeon,type,bold,combat,conjectural,cyberpunk,darkness,falkenstein]

export function setup(){
  tables=tables.flatMap(t=>t.tables)
  tables.sort((a,b)=>a.name.localeCompare(b.name))
}
