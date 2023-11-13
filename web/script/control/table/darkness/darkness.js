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

const VAMPIRE = new table.Table("Darkness, artifact, vampire", ["Ankaran Sarcophagus",
    "Eye of Hazimel", "Enochian Sarcophagus", "Enosch Sarcophagus", "Lamp of Constantine", "Sargon Fragment",
    "Sword of Nul", "Sword of Troile", "Tablet of Destiny", "The True Vessel", "Aaron's Feeding Razor",
    "Black Gloves", "Brass Heart Shield", "Concoction of Vitality", "Femur of Toomler", "Giants' Blood",
    "Hand of Conrad", "Ivory Bow", "Jorum of Kinsmanship", "Martinelli's Ring of Clear Thought",
    "Phylactery of Recorded Memory", "Pumping Heart of Nizchetus", "Talbot's Chainsaw",
    "Tongue of Jarthis the Slaver", "Vestment of Vileness", "Argent Baton", "Bloodstones",
    "Cloak of the Abalone", "Elixir of Distillation", "Monocle of Clarity", "Powder of Rigidity",
    "Ring of the Inscrutable Eye", "Rowan Ring", "Tapestry of the Blood", "Waxen Poetica", "Berserker Fang",
    "Blazing Candle", "Blood Pouch", "Gangrel Eye", "Inner Stone", "Sire's Index Finger", "Heart's Desire",
    "Katrina's Cross", "Locke's Computer", "Mirror of Dreams", "Blood Shield", "Kduva's Mask", "Pledge-Sword",
    "Skin of the King", "Vanishing Bead", "Bloodspot Dice", "Malady Pen", "Sword of Dracula", "Ainkurn",
    "The Bell of Ashes", "Blade of Enoch", "Cup of Christ", "Gabriel's Trumpet", "Martyr's Icon", "The Stone",
    "Tyrant's Lash", "Veddartha's Chalice", "Warding Iron", "Wax Seal", "Aaron's Feeding Razor",
    "Agate Talisman", "Amulet of Temporal Perception", "Ancestor's Talisman", "Argent Baton", "Baleful Doll",
    "Banshee Ironwail", "Black Gloves", "Blade of Enoch", "Blood Shield", "Bloodstone",
    "Blood Tears of Kephran", "Bowl of Convergence", "Chalice of Kinship", "Changeling Skin Mask",
    "Cloak of the Abalone", "Codex of the Damned", "Concoction of Vitality", "Crimson Sentinel",
    "Crusader Sword", "Drums of Xipe Totec", "Elixir of Distillation", "Enchanted Marionette", "Erebus Mask",
    "Eye of Hazimel", "Femur of Toomler", "Flaming Candle", "Hand of Conrad", "Heart of Nizchetus", "Ivory Bow",
    "Jar of Skin Eaters", "Joumlon's Axe", "Kali's Fang", "Kduva's Mask", "Living Wood Staff",
    "Martinelli's Ring", "Mokolé Blood", "Monocle of Clarity", "Mummy's Tongue", "Nkishi", "Orb of Ulain",
    "Powder of Rigidity", "Reliquary: Akunanse Remains", "Reliquary: Biaque", "Reliquary: Shango Remains",
    "Reliquary: Trinket", "Ritual Scalpel", "Rowan Ring", "Sargon Fragment", "Seal of Veddartha",
    "Sengir Dagger", "Shaal Fragment", "Shackles of Enkidu", "Shilmulo Tarot", "Signet Ring of King Saul",
    "Sire's Index Finger", "Soul Gem of Etrius", "Sword of Judgment", "Sword of Nuln", "Sword of Troile",
    "Talbot's Chainsaw", "Tapestry of Blood", "Tinglestripe", "Veneficorum Artum Sanguis", "Waxen Poetica",
    "Weirding Stone"])
const WRAITH = new table.Table("Darkness, artifact, wraith",
    ["Glow", "Return of Death’s Visage", "Shapesense", "Imitate", "Sculpt", "Martialry", "Rend",
        "Bodyshape", "Armory", "Masquer: Lizard Tail", "Masquer: Skinmold", "Masquer: Calcify",
        "Masquer: Desperation’s Lash", "Masquer: Chorus of Throats", "Masquer: Volley",
        "Masquer: Chrysalis", "Masquer: Girding", "Masquer: Cripple", "Masquer: Kiln", "Masquer: Soothe",
        "Deathmasque", "The Shaper's Eye", "Maelstrom Visage", "Shapesense", "Unmarked", "Panoply of Eyes",
        "Gird", "Savage", "Embed"])
const MAGE = new table.Table("Darkness, artifact, mage",
    ["Enchantment", "Nightmare", "Shadow", "Celestial", "Totem"])
const ARTIFACT = new table.Table("Darkness, artifact", [VAMPIRE, WRAITH, MAGE])

tables.push(...[VAMPIRE, WRAITH, MAGE,ARTIFACT])
