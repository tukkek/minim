import * as table from '../table.js'

const AUSPICE = new table.Table("Darkness, werewolf, auspice",
    ["Warrior", "Visinary", "Walker-between", "Spirit master", "Stalker"])

const FORSAKEN = new table.Table("Darkness, werewolf, tribe, forsaken",
    ["Blood talons", "Bone shadows", "Hunters in darkness", "Iron masters", "Storm lords"])
const PURE = new table.Table("Darkness, werewolf, tribe, pure",
    ["Fire-touched", "Ivory claws", "Predator kings"])
const OTHER = new table.Table("Darkness, werewolf, tribe, other",
    ["Ghost wolves", "Bale hounds"])

const TRIBES = new Map();
for (let t of [FORSAKEN, PURE, OTHER]) TRIBES.set(t.name, t);

class Tribe extends table.Table {
	constructor() {
		super("Darkness, werewolf, tribe");
		this.add(FORSAKEN, 2);
		this.add(PURE, 3);
		this.add(OTHER, 1);
	}
}

var tribe=new Tribe()

class Werewolf extends table.Table {
	constructor() {
		super("Darkness, werewolf");
	}

	roll() {
		let lines = [
      "Tribe: " + tribe.roll().toLowerCase(),
      "Auspice: " + AUSPICE.roll().toLowerCase()
		]
		return lines.join('<br/>')
	}
}

export var tables=[AUSPICE,FORSAKEN,PURE,OTHER,tribe,new Werewolf()]
