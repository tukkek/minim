import * as kindred from './kindred.js'
import * as mage from './mage.js'
import * as werewolf from './werewolf.js'
import * as table from '../table.js'

const FAMILIES = new table.Table("Darkness, beast, family", ["Anakim, giants", "Eshmaki, lurkers",
    "Inguma, outsiders", "Makara, leviathans", "Namtaru, gorgoms", "Talassii, captors", "Ugallu, raptors"])
const HUNGER = new table.Table("Darkness, beast, hunger",
    ["Predator (prey)", "Tyrant (power)", "Nemesies (punishment)", "Ravager (ruin)",
        "Collectors (hoard)", "Whispers (secrets)", "Enablers (transgression)"])

class Beast extends table.Table {
	constructor() {
		super("Darkness, beast");
	}

	roll() {
		let l = [
      "Family: "+ FAMILIES,
      "Hunger: "+ HUNGER
    ]
		return l.join('<br/>');
	}
}

export var tables=[kindred,mage,werewolf].flatMap(t=>t.tables)
                    .concat([FAMILIES,HUNGER,new Beast()])
