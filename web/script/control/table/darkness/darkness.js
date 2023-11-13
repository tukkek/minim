import * as kindred from './kindred.js'
import * as mage from './mage.js'
import * as werewolf from './werewolf.js'
import * as table from '../table.js'

export var tables=[kindred,mage,werewolf].flatMap(t=>t.tables)
                    
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

tables.push(...[FAMILIES,HUNGER,new Beast()])

const LEGIONS = new table.Table("Darkness, wraith, faction, hierarchy legions",
  ["Emerald legion", "Legion of fate", "Grim legion", "Iron legion", "Legion of paupers",
      "Penitent legion", "Silent legion", "Skeletal legion"])
const HERETICS = new table.Table("Darkness, wraith, faction, heretics",
  ["The host", "Children of the green", "Riders of the wheel"])
const RENEGADES = new table.Table("Darkness, wraith, faction, renegades",
  ["Protesters", "Idealists", "Outlaws", "Drop-outs"])
const FACTIONS = new table.Table("Darkness, wraith, faction")
FACTIONS.add(LEGIONS,2);
FACTIONS.add(HERETICS);
FACTIONS.add(RENEGADES);
FACTIONS.add("Ferrymen", 1);

const GUILDS = new table.Table("Darkness, wraith, guilds",
  ["Alchemists", "Artificers", "Chanteur", "Harbingers", "Haunters", "Masquers", "Mnemoi", "Monitors",
      "Oracles", "Pardoners", "Proctors", "Sandmen", "Solicitors", "Sppoks", "Usurers"])

class Wraith extends table.Table {
	constructor() {
		super("Darkness, wraith");
	}

  roll() {
		let l = [
      "Faction: "+ FACTIONS,
      "Guild: "+ GUILDS
    ]
		return l.join('<br/>')
	}
}

tables.push(...[LEGIONS,HERETICS,RENEGADES,FACTIONS,GUILDS,new Wraith()])
