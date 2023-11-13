import * as kindred from './kindred.js'
import * as mage from './mage.js'

export var tables=[kindred,mage].flatMap(t=>t.tables)
