import * as table from '../table.js'
import * as instant from '../instant.js'
import * as weather from '../weather.js'
import * as bold from '../bold.js'
import * as dungeonm from './dungeon.js'
import * as hexcrawl from './hexcrawl.js'
import * as cartoon from './cartoon.js'

export var tables=[]

export var dungeon="Dungeon"
export var wilderness="Wilderness"
export var urban="Urban"

var type=new table.Table('Adventure, one-shot, type',[dungeon,wilderness,urban])
tables.push(type)

const ARC = ["Setup", "Confrontation", "Resolution"]
const ADVENTURES = new Map([
    [dungeon,dungeonm.tables[dungeonm.tables.length-1]],
    [wilderness,hexcrawl.BIG],
    [urban, cartoon.adventure]
])
class OneShot extends table.Table {
  constructor() {
		super("Adventure, one-shot");
	}

  roll() {
		var l = [];
		l.push("Setting: "+instant.setting);
		for (let a of ARC) {
			l.push('');
			l.push(a + " chapter: "+ bold.waylay);
			l.push('');
			var t = type.roll();
			l.push(`${a} module (${t.toLowerCase()}):`)
			l.push(ADVENTURES.get(t));
		}
		l.push();
    l.push(weather.calendar);
		return l.join('<br/>')
	}
}

tables.push(new OneShot())
