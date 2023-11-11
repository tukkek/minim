import * as debug from './debug.js'
import * as db from './db.js'
import * as input from './input.js'
import * as notes from './notes.js'
import * as action from './action.js'
import * as tables from './table/tables.js'
import * as units from '../view/units.js'
import * as actions from '../view/actions.js'
import * as output from '../view/output.js'

export async function setup(){
  notes.setup()
  await db.setup()
  await db.restore()
  units.setup()
  input.setup()
  action.setup()
  actions.setup()
  output.setup()
  tables.setup()
  debug.start()
}
