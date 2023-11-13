import * as kindred from './kindred.js'
import * as mage from './mage.js'
import * as werewolf from './werewolf.js'

export var tables=[kindred,mage,werewolf].flatMap(t=>t.tables)
