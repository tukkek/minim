import * as adungeon from './adventure/dungeon.js'

export var tables=[adungeon]

export function setup(){tables=tables.flatMap(t=>t.tables)}
