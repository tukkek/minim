import * as table from '../table.js'

export var dungeon="Dungeon"
export var wilderness="Wilderness"
export var urban="Urban"

var type=new table.Table('Adventure, type',[dungeon,wilderness,urban])

export var tables=[type]
