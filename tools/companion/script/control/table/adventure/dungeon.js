import * as table from '../table.js'
import * as rpg from '../../rpg.js'

const WHY=[
  new table.Table("Adventure, dungeon, backstory, why, prefix",["Inhabitants were changed", "Inhabitants defeated",
			"Inhabitants massacred", "Inhabitants abandoned place", "Inhabitants physically altered",
			"Construction (recent or ancient) was done", "Inhabitants changed beliefs", "Inhabitants mentally altered",
			"Inhabitants mentally and physically alteredOriginal inhabitants departed the place",
			"The place became hostile to civilization", "The place became filled with traps or deadly barriers",
			"The place was shut off from the world", "The original inhabitants became decadent",
			"The inhabitants broke into two groups", "A cataclysm or natural disaster took place", "Poisons were used",
			"Deadly beings were made", "Leaders were slain or imprisoned", "Raiding began"]),
  new table.Table("Adventure, dungeon, backstory, why, suffix",["In connection with an ancient curse",
			"In connection with savages", "In connection with rampaging non-human tribes",
			"In connection with a dispute between powerful monsters/individuals",
			"In connection with something unexpected being unearthed", "In connection with forbidden knowledge",
			"In connection with unexpected facts being discovered", "In connection with a disease",
			"In connection with magical research", "In connection with a strange belief",
			"In connection with promises made by a powerful being", "In connection with the use of strange substances",
			"In connection with the discovery of valuable substances", "After contact with sinister beings",
			"After a religious or philosophical dispute", "After strange omens",
			"In connection with excessive pride and hubris", "In connection with the theft of an important item",
			"In connection with black magic", "In connection with a war"])
]

class When extends table.Table{
  constructor(){
    super('Adventure, dungeon, backstory, when')
			this.add("1000 years ago")
			this.add("100 years ago",5)
			this.add("10 years ago",5)
			this.add("1 years ago",5)
			this.add("1 month ago",2)
			this.add("1 week ago",1)
			this.add("1 day ago",1)
  }
}

var when=new When()
  
class Backstory extends table.Table{
	constructor() {
		super("Adventure, dungeon, backstory")
	}

	roll(){
		return `${WHY[0]} ${WHY[1].toString().toLowerCase()} (${when})`
	}
}

	const CLUE = new table.Table("Adventure, dungeon, information, clue", [
			"Coded message for a particular recipient", "A deliberately placed message left behind for any recipient",
			"A deliberate misdirection", "A direct vision or memory imparted to someone",
			"Evidence of a mechanism or the use of one", "Journals, diaries, or other personal records",
			"Something that is an inherent part of the general decoration, architecture, environment, or atmosphere",
			"The remnants of an event"])
	const RUMOR = new table.Table("Adventure, dungeon, information, rumor",
			["Account of ancient expedition contained in book or archives", "Ancient riddle", "Ancient warning",
					"Area is taboo or forbidden", "Generally known legend or story", "Generally known prophesy",
					"Hireling with previous group of adventurers", "Minstrel who spoke with prior adventurers",
					"People who heard prior adventurers bragging in tavern", "Recent events (strange deaths, etc",
					"Recent observations by curious people", "Someone who slept with prior adventurer in the area"])
	const CONTENT = new table.Table("Adventure, dungeon, information, rumor, content", [
			"How to avoid or disarm a trap",
			"How to find another important piece of information (such as a map or a diary",
			"How to open a trick door or secret door",
			"How to operate a piece of machinery (an elevator to another level, the lava channels, the ghoul vats, the potion-brewing machine, etc).",
			"How to work a particular trick most beneficially",
			"Information about a significant monster: how to avoid iInformation about a significant monster: how to negotiate with it or keep it from attacking",
			"Information about a major monster: what it is",
			"Information about backstory: what happened to make the place dangerous",
			"Information about backstory: who built the place", "Information about backstory: who lived here",
			"Information about backstory: why the place was originally built", "Location of a key",
			"Location of a level change",
			"Location of a particular room being sought (the prison, the privy, the library, etc).",
			"Location of a secret door", "Location of a trap", "Location of a treasure", "Part of a map",
			"Why an unusual room is built the way it is"])
	const WRITING = new table.Table("Adventure, dungeon, information, writing",
			["Accounts and financial records", "Book, reference", "Book, religious tract",
					"Dossier of information about someone", "Family tree and/or genealogical records", "Graffiti",
					"Inscription on goblet, jewelry, or other item", "Journal", "Legal documents concerning a dispute",
					"Letter", "Maps", "Military plans and orders", "Notes to self", "Ownership papers", "Receipts",
					"Recipes or instructions", "Stitched into cloth", "Treaty documents", "Troop movements",
					"Wall carving"])
 class Information extends table.Table {
	 constructor() {
		super("Adventure, dungeon, information")
	}

	 roll() {
		let r = rpg.roll(1,3)
		if (r == 1)
			return CLUE.roll()
		if (r == 2)
			return RUMOR.roll() + " - " + CONTENT.roll().toLowerCase()
		return WRITING.roll()
	}
}

var occupant= new table.Table("Adventure, dungeon, occupant", ["A Casanova or sex-addict, human or otherwise",
				"A Casanova or sex-addict, human or otherwise", "A collector of objects or animals",
				"A collector of objects or animals", "A constructed entity similar to an intelligent golem",
				"A cult or sect of humans, demi-humans, or other humanoids (peaceful)",
				"A cult or sect of humans, demi-humans, or other humanoids (peaceful)",
				"A cult or sect of humans, demihumans, or other humanoids (violent, sinister, or evil)",
				"A cult or sect of humans, demihumans, or other humanoids (violent, sinister, or evil)", "A demigod",
				"A demigod",
				"A demonic creature, possibly with slaves of some type (you could roll again to see what sort of slaves)",
				"A giant, possibly a very unique one", "A giant, possibly a very unique one", "A group of traders",
				"A major political figure such as a king or prince. In a dungeon, this guy is probably either non-human or is in hiding. Other possibility is that he owns the land above, and this is a stronghold area or part of one.",
				"A major political figure such as a king or prince. In a dungeon, this guy is probably either non-human or is in hiding. Other possibility is that he owns the land above, and this is a stronghold area or part of one.",
				"A notorious poisoner", "A notorious poisoner", "A powerful undead creature",
				"A powerful undead creature", "A shapeshifter or lycanthrope", "A shapeshifter or lycanthrope",
				"A wizard, evil", "A wizard, evil", "A wizard, evil", "A wizard, evil", "A wizard, not evil",
				"A wizard, not evil", "A wizard, not evil", "A wizard, not evil", "An alchemist, human or otherwise",
				"An alchemist, human or otherwise", "An ancient race of humans or a “superior” subspecies of humanity",
				"An ancient race of humans or a “superior” subspecies of humanity", "An artificer of machines",
				"An artificer of machines", "An intelligent “Lord” of a type of vermin",
				"An intelligent “Lord” of a type of vermin",
				"Ancient, horrific creatures that are best forgotten and hopefully aren’t still there",
				"Ancient, horrific creatures that are best forgotten and hopefully aren’t still there",
				"Band of powerful adventurers ((relative to the dungeon level)",
				"Band of powerful adventurers ((relative to the dungeon level)",
				"Criminal organization: murderous or violent", "Criminal organization: murderous or violent",
				"Criminal organization: thieves, forgers, arsonists, or other non-violent crimes",
				"Criminal organization: thieves, forgers, arsonists, or other non-violent crimes", "Intelligent vermin",
				"Intelligent vermin"])
var purpose=new table.Table ("Adventure, dungeon, purpose", ["Antechamber", "Archives", "Arena", "Armory",
				"Art gallery, display area, waxworks, or trophy room", "Audience-chamber", "Aviary", "Banquet hall",
				"Barracks", "Bath houses", "Bedrooms", "Casino", "Chantry", "Chapel", "Cistern or well",
				"Closets, lockers, small storage", "Conjuring or summoning", "Courtrooms", "Crypts", "Dormitories",
				"Garden (fungus, orchids or other)", "Granary, warehouse, or storage area", "Kennels", "Kitchen area",
				"Laboratories", "Library", "Lounge or common room", "Meditation chambers", "Offices",
				"Offices or administration", "Oracle or divination", "Pantries or food storage", "Prison", "Privies",
				"Proximity to elemental substance (fire or lava)",
				"Proximity to elemental substance (unusual air or gases)",
				"Proximity to elemental substance (unusual earth or gems)",
				"Proximity to elemental substance (unusual water)", "Robing rooms", "Scriptorium", "Shrine",
				"Smithies or forges", "Stables", "Study", "Torture chambers", "Training rooms", "Waiting rooms",
				"Workroom for wizard or other magic-using being", "Workrooms for craftsmen"]) 

var grid=new table.Table("Adventure, dungeon, grid", ["None", "Square", "Hex", "Vert-hex"])


	const EXOTIC = new table.Table("Adventure, dungeon, location, exotic",
			["Inside a spell", "Sealed inside a magical dome of force",
					"On the back of a Gargantuan living creature", "In a volcano", "On an island in an underground sea",
					"In the Shadowfell", "In the Feywild", "On a cloud",
					"In an area devastated by a magical catastrophe", "On a demiplane or in a pocket dimension",
					"In a meteorite", "Floating on the sea", "Castle or structure at the bottom of a sinkhole",
					"Castle or structure sunken in a swamp", "Buried in volcanic ash", "Buried in a sandstorm",
					"Buried in an avalanche", "Behind a waterfall", "Around a geyser", "Among the branches of a tree"])
class Location extends table.Table {

	constructor() {
		super("Adventure, dungeon, location",
				["On an island", "On a promontory", "On a mountain peak", "In several conn ected mesas",
						"In sea caves", "Beneath or on top of a mesa", "In a swamp", "In a mountain pass",
						"In a jungle", "In a gorge", "In a glacier", "In a forest", "In a desert", "In a cliff face",
						"In a chasm", "Beneath a temple", "Beneath a ruined city", "Beneath a ruined castle",
						"Beneath a graveyard", "Beneath a farmhouse", "Catacombs or sewers beneath a city",
						"A building in a city"])
	}

	roll() {
		return rpg.roll(1,20) == 1 ? EXOTIC.roll() : super.roll()
	}
}

const BASIC = new table.Table("Adventure, dungeon, map, basic", ["Standard", "Classic"]);
const PNP = new table.Table("Adventure, dungeon, map, pen-and-paper", ["Crosshatch", "Graph paper", "Parchment"])
const STONEWORK = new table.Table("Adventure, dungeon, map, stonework", ["Marble", "Sandstone", "Slate"])
const EXOTICMAP = new table.Table("Adventure, dungeon, map, exotic", ["Aquatic", "Infernal", "Glacial", "Wooden"])
const OTHER = new table.Table("Adventure, dungeon, map, other", ["Asylum", "Steampunk", "Gamma"])
class DungeonMap extends table.Table {
	constructor() {
		super("Adventure, dungeon, map",[BASIC, PNP, STONEWORK, EXOTICMAP, OTHER]);
	}

}

const MONSTROUS = new table.Table("Adventure, dungeon, motif, monstrous", ["Aberrant", "Giant", "Undead", "Vermin"])
const ENVIRONMENTS = new table.Table("Adventure, dungeon, motif, environments", ["Aquatic", "Desert", "Underdark"])
const ARCANA = new table.Table("Adventure, dungeon, motif, arcana", ["Arcane", "Fire", "Cold", "Abyssal", "Infernal"])
const MOTIFS = new Map([
  ["None", false],
  ["Abandoned", false],
  ['Monstrous', MONSTROUS],
  ['Environments', ENVIRONMENTS],
  ['Arcana', ARCANA],
])
 class Motif extends table.Table {

	constructor() {
		super("Adventure, dungeon, motif",Array.from(MOTIFS.keys()));
	}

	 roll() {
		var r = super.roll();
		var m = MOTIFS.get(r);
		r = !m ? r : r + ", " + m.roll().toLowerCase();
		return r.toLowerCase();
	}
}


var location=new Location()
var information=new Information()
var dungeonmap=new DungeonMap()
var motif=new Motif()
var backstory=new Backstory()


 const CHARACTERISTICS=new Map([
    ["Location", location],
		["Motif", motif],
		["Map", dungeonmap],
		["Grid", grid],
		["Backstory", backstory],
		["Original purpose", purpose],
		["Original occupant", occupant],
	])

class Dungeon extends table.Table {
	constructor() {
		super("Adventure, dungeon");
	}

	 roll() {
		let c = Array.from(CHARACTERISTICS.keys())
				.map(t => `  ${t}: ${CHARACTERISTICS.get(t).roll().toLowerCase()}.`)
		if (rpg.roll(1,10) == 1) {
			c.push(`  Current purpose: ${purpose}.`)
			c.push(`  Current occupant}: ${occupant}.`)
		}
		let ninformation = rpg.roll(1,4)
		for (let i = 0; i < ninformation; i++)
			c.push(`  Information: ${information.roll().toLowerCase()}.`)
		return c.join('<br/>');
	}
}


export var tables=WHY.concat([when,backstory,CLUE,RUMOR,CONTENT,WRITING,information,
  occupant,purpose,grid,EXOTIC,location,
  BASIC, PNP, STONEWORK, EXOTICMAP, OTHER,dungeonmap])
  .concat([MONSTROUS,ENVIRONMENTS,ARCANA,motif,new Dungeon()])
