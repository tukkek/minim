import * as adungeon from './adventure/dungeon.js'
import * as type from './adventure/type.js'
import * as bold from './bold.js'
import * as combat from './combat.js'

export var tables=[adungeon,type,bold,combat]

export function setup(){tables=tables.flatMap(t=>t.tables)}
