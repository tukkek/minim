import * as setting from './setting.js'
import * as character from './character.js'

export var tables=[
  setting.tables,
  character.tables,
].flatMap(t=>t)
