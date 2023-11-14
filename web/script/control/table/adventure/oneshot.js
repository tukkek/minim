import * as table from '../table.js'
import * as instant from '../instant.js'
import * as weather from '../weather.js'
import * as bold from '../bold.js'
import * as type from './type.js'
import * as dungeon from './dungeon.js'
import * as hexcrawl from './hexcrawl.js'
import * as cartoon from './cartoon.js'

export var tables=[]

const ARC = ["Setup", "Confrontation", "Resolution"]
const ADVENTURES = new Map([
    [type.dungeon,dungeon.tables[dungeon.tables.length-1]],
    [type.wilderness,hexcrawl.BIG],
    [type.urban, cartoon.adventure]
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
			var t = type.tables[0].roll();
			l.push(`${a} module (${t.toLowerCase()}):`)
			l.push(ADVENTURES.get(t));
		}
		l.push();
    l.push(weather.calendar);
		return l.join('<br/>')
	}
}

tables.push(new OneShot())
