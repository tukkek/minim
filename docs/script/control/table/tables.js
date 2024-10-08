import * as adungeon from './adventure/dungeon.js'
import * as hexcrawl from './adventure/hexcrawl.js'
import * as oneshot from './adventure/oneshot.js'
import * as cartoon from './adventure/cartoon.js'
import * as journey from './adventure/journey.js'
import * as bold from './bold.js'
import * as cyberpunk from './cyberpunk.js'
import * as falkenstein from './falkenstein.js'
import * as fantasy from './fantasy.js'
import * as nomine from './nomine.js'
import * as instant from './instant.js'
import * as weather from './weather.js'
import * as real from './real.js'
import * as misc from './misc.js'
import * as une from './une.js'
import * as conjectural from './conjectural.js'
import * as darkness from './darkness/darkness.js'
import * as kult from './kult/kult.js'
import * as arcana from './arcana.js'

export var tables=[
  adungeon,bold,cyberpunk,darkness,conjectural,
  falkenstein,fantasy,hexcrawl,nomine,instant,kult,oneshot,
  weather,cartoon,real,journey,misc,une,arcana,
]

export function setup(){
  tables=tables.flatMap(t=>t.tables)
  tables.sort((a,b)=>a.name.localeCompare(b.name))
  console.log(`${tables.length} tables loaded.`)
}
