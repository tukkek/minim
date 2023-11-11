import * as adungeon from './adventure/dungeon.js'
import * as type from './adventure/type.js'
import * as bold from './bold.js'

export var tables=[adungeon,type,bold]

export function setup(){tables=tables.flatMap(t=>t.tables)}
