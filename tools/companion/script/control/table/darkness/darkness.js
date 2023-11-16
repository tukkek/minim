import * as kindred from './kindred.js'
import * as mage from './mage.js'
import * as werewolf from './werewolf.js'
import * as table from '../table.js'
import * as rpg from '../../rpg.js'

export var tables=[kindred,mage,werewolf].flatMap(t=>t.tables)
                    
const FAMILIES = new table.Table("Darkness, character, beast, family", ["Anakim, giants", "Eshmaki, lurkers",
    "Inguma, outsiders", "Makara, leviathans", "Namtaru, gorgoms", "Talassii, captors", "Ugallu, raptors"])
const HUNGER = new table.Table("Darkness, character, beast, hunger",
    ["Predator (prey)", "Tyrant (power)", "Nemesies (punishment)", "Ravager (ruin)",
        "Collectors (hoard)", "Whispers (secrets)", "Enablers (transgression)"])

class Beast extends table.Table {
	constructor() {
		super("Darkness, character, beast");
	}

	roll() {
		let l = [
      "Family: "+ FAMILIES,
      "Hunger: "+ HUNGER
    ]
		return l.join('<br/>');
	}
}

export var beast=new Beast()
tables.push(...[FAMILIES,HUNGER,beast])

const LEGIONS = new table.Table("Darkness, character, wraith, faction, hierarchy legions",
  ["Emerald legion", "Legion of fate", "Grim legion", "Iron legion", "Legion of paupers",
      "Penitent legion", "Silent legion", "Skeletal legion"])
const HERETICS = new table.Table("Darkness, character, wraith, faction, heretics",
  ["The host", "Children of the green", "Riders of the wheel"])
const RENEGADES = new table.Table("Darkness, character, wraith, faction, renegades",
  ["Protesters", "Idealists", "Outlaws", "Drop-outs"])
const FACTIONS = new table.Table("Darkness, character, wraith, faction")
FACTIONS.add(LEGIONS,2);
FACTIONS.add(HERETICS);
FACTIONS.add(RENEGADES);
FACTIONS.add("Ferrymen", 1);

const GUILDS = new table.Table("Darkness, character, wraith, guilds",
  ["Alchemists", "Artificers", "Chanteur", "Harbingers", "Haunters", "Masquers", "Mnemoi", "Monitors",
      "Oracles", "Pardoners", "Proctors", "Sandmen", "Solicitors", "Sppoks", "Usurers"])

class Wraith extends table.Table {
	constructor() {
		super("Darkness, character, wraith");
	}

  roll() {
		let l = [
      "Faction: "+ FACTIONS,
      "Guild: "+ GUILDS
    ]
		return l.join('<br/>')
	}
}

var wraith=new Wraith()

tables.push(...[LEGIONS,HERETICS,RENEGADES,FACTIONS,GUILDS,wraith])

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
export const ARTIFACT = new table.Table("Darkness, artifact", [VAMPIRE, WRAITH, MAGE])

tables.push(...[VAMPIRE, WRAITH, MAGE,ARTIFACT])

const HOUSE = new table.Table("Darkness, character, demon, houses",
    ["Devils", "Scourges", "Malefactors", "Fiends", "Defilers", "Devourers", "Slayers"])
const FACTION = new table.Table("Darkness, character, demon, factions",
    ["Faustian", "Cryptics", "Luciferans", "Raveners", "Reconcilers"])
class Demon extends table.Table {
	constructor() {
		super("Darkness, character, demon");
	}

	roll() {
		return [
      "House: "+ HOUSE,
      "Faction: "+ FACTION
    ].join('<br/>')
	}
}

var demon=new Demon()
tables.push(...[HOUSE,FACTION,demon])

const BURDEN = new table.Table("Darkness, character, bound, burden",
  ["Abiding", "Bereaved", "Hungry", "Kindly", "Vengeful"])
const HAUNT = new table.Table("Darkness, character, bound, haunt", ["Boneyard", "Caul", "Curse", "Dirge",
  "Marionette", "Memoria", "Oracle", "Pit", "Rage", "Shroud", "Tomb", "Void", "Well"])
const KEY = new table.Table("Darkness, character, bound, key", ["Beasts", "Blood", "Chance", "Cold wind",
  "Deep waters", "Disease", "Grave dirt", "Pyre flame", "Stillness"])

class Bound extends table.Table {
	constructor() {
		super("Darkness, character, bound");
	}

  roll() {
		return [
      "Burden: "+ BURDEN,
      "Haunt: "+ HAUNT,
      "Key: "+ KEY
    ].join('<br/>')
	}
}

var bound=new Bound()
tables.push(...[BURDEN,HAUNT,KEY,bound])

const SIDHE = "Sidhe";
const KITHAIN = new table.Table("Darkness, character, changeling, kith, kithain",
  ["Boggasn", "Eshu", "Nockers", "Pooka", "Redcaps", "Satyrs", SIDHE, "Sluagh", "Trolls"])
const GALLAIN = new table.Table("Darkness, character, changeling, kith, gallain",
  ["Clurichaun", "Ghille dhu", "Korred", "Merfolk", "Morganed", "Piskies", "River Hags", "Selkies",
      "Swan maidens", "Wichtel", "Wolpertinger"])
const ADHENE = new table.Table("Darkness, character, changeling, kith, adhene",
  ["Acheri", "Aonides", "Fir-bholg", "Fuath", "Keremet", "Moirae", "Naraka"])
const HSIEN = new table.Table("Darkness, character, changeling, kith, hsien", ["Chu-ih-yu", "Chu Jung",
  "Fu Hsi", "Hanumen", "Heng Po", "Hou-chi", "Komuko", "Nyan", "Suijen", "Tanuki"])
const INANIMAE = new table.Table("Darkness, character, changeling, kith, inanimae",
  ["Glomes", "Kuberas", "Mannikins", "Ondines", "Parosemes", "Solimonds"])
const NUNNEHI = new table.Table("Darkness, character, changeling, kith, nunnehi",
  ["Canotili", "Inua", "Kachina", "May-may-gway-shi", "Nanehi", "Nümüzo'ho", "Pu'gwis", "Rock Giant",
      "Surem", "Thought-crafter", "Tunghat", "Water Baby", "Yunwi Amai'yine'hi", "Yunwi Tsundsi"])
const THALLAIN = new table.Table("Darkness, character, changeling, kith, thallain",
  ["Aithu", "Beastie", "Bodach", "Boggart", "Bogie", "Ghast", "Goblin", "Huaka'i Po", "Kelpies",
      "Lurks", "Mandragora", "Murdhuacha", "Nasties", "Night Hag", "Ogre", "Sevartal", "Skinwalker",
      "Spriggan", "Weeping Wights"])
const KITH = new table.Table("Darkness, character, changeling, kith",
  [KITHAIN, GALLAIN, ADHENE, HSIEN, INANIMAE, NUNNEHI, THALLAIN])
const SEELIE = "Seelie";
const UNSEELIE = "Unseelie";
const COURT = new table.Table("Darkness, character, changeling, court")
COURT.add(SEELIE, 5);
COURT.add(UNSEELIE, 5);
COURT.add("Shadow", 1);

tables.push(...[KITHAIN,GALLAIN,ADHENE,HSIEN,INANIMAE,NUNNEHI,THALLAIN,KITH,COURT])

const SEELIEHOUSES = new table.Table("Darkness, character, changeling, house, seelie",
  ["Beaumayn", "Dougal", "Eiluned", "Fiona", "Gwydion", "Liam", "Scathach"])
const UNSEELIEHOUSES = new table.Table("Darkness, character, changeling, house, unseelie",
  ["Aesin", "Ailil", "Balor", "Daireann", "Leanhaun", "Varich", "Scathach"])
const HOUSES = new table.Table("Darkness, character, changeling, house", [SEELIEHOUSES, UNSEELIEHOUSES])

class Changeling extends table.Table {
	constructor() {
		super("Darkness, character, changeling");
	}

	 roll() {
		let l = []
		let k = l.push("Kith: "+ KITH)
		let c = l.push("Court: "+ COURT);
		if (k == SIDHE || rpg.roll(1,10) == 10) {
			if (c == SEELIE)
				l.push("House: "+ SEELIEHOUSES);
			else
				l.push("House: "+ UNSEELIEHOUSES);
		}
		return l.join('<br/>')
	}
}

var changeling=new Changeling()

tables.push(...[SEELIEHOUSES,UNSEELIEHOUSES,HOUSES,changeling])

const MERCY = new table.Table("Darkness, character, hunter, creed, mercy",
    ["Innocents", "Martyrs", "Redeemers"])
const VISION = new table.Table("Darkness, character, hunter, creed, vision",
    ["Hermits", "Visionaries", "Waywards"])
const ZEAL = new table.Table("Darkness, character, hunter, creed, zeal",
    ["Avengers", "Defenders", "Judges"])
const CREED = new table.Table("Darkness, character, hunter, creed", [MERCY, VISION, ZEAL])
const COMPACT = new table.Table("Darkness, character, hunter, organization, compact",
    ["Ahl al-Jabal", "Ashwood Abbey", "The Bear Lodge", "Barrett Commission", "Division Six",
        "Habibti Ma", "The Hunt Club", "The Illuminated Brotherhood", "Keepers of the Source", "Long Night",
        "Loyalists of Thule", "Maiden's Blood Sisterhood", "Network Zero", "Night Watch", "Null Mysteriis",
        "The Promethean Brotherhood", "Talbot Group", "The Union", "Utopia Now"])
const CONSPIRACY = new table.Table("Darkness, character, hunter, organization, conspiracy",
    ["Aegis Kai Doru", "Ascending Ones", "The Cainite Heresy", "The Cheiron Group",
        "The Faithful of Shulpae", "Knights of Saint Adrian", "The Knights of Saint George", "Les Mystères",
        "Lucifuge", "Malleus Maleficarum", "Task Force: VALKYRIE", "Vanguard Serial Crimes Unit"])
const ORGANIZATION = new table.Table("Darkness, character, hunter, organization")
ORGANIZATION.add(CONSPIRACY);
ORGANIZATION.add(COMPACT,2);
ORGANIZATION.add("Independent cell", 4);

class Hunter extends table.Table {
	constructor() {
		super("Darkness, character, hunter");
	}

	roll() {
		return [
      "Creed: "+ CREED,
      "Organization: "+ORGANIZATION
    ].join('<br/>')
	}
}

export var hunter=new Hunter()

tables.push(...[MERCY,VISION,ZEAL,CREED,COMPACT,CONSPIRACY,ORGANIZATION,hunter])

const ORTHODOX = new table.Table("Darkness, character, kue-jin, dharma, orthodox",
    ["Devil-tiger", "Song of shadow", "Resplendent crane", "Thrashing dragon", "Thousand whispers"])
const HERETICAL = new table.Table("Darkness, character, kue-jin, dharma, heretical",
    ["Spirit of the living earth", "Face of the gods", "Flame of the rising phoenix",
        "Tempest of inward focus"])
const DHARMA = new table.Table("Darkness, character, kue-jin, dharma")
DHARMA.add("Scorpion eater", 1);
DHARMA.add(HERETICAL,2);
DHARMA.add(ORTHODOX,4);
const CHI = new table.Table("Darkness, character, kue-jin, chi")
CHI.add("Yin (black)", 2);
CHI.add("Yang (scarlet)", 2);
CHI.add("P'o (demon)", 1);

class Kuejin extends table.Table {
	constructor() {
		super("Darkness, character, kue-jin");
	}

	roll() {
		return [
      "Dharma: "+ DHARMA,
      "Chi: "+ CHI
    ].join('<br/>')
	}
}

var kuejin=new Kuejin()
tables.push(...[ORTHODOX,HERETICAL,DHARMA,CHI,kuejin])

var Athanor={
  FRANKENSTEIN:new table.Table("Darkness, character, promethean, athanor, frankenstein",
      ["Basilisk", "Caladrius", "Griffon", "Lion", "Manticore"]),
  GALATEA : new table.Table("Darkness, character, promethean, athanor, galatea",
      ["Dove", "Gorgon", "Seraph", "Swan", "Unicorn"]),
   OSIRIS : new table.Table("Darkness, character, promethean, athanor, osiris",
      ["Ant", "Dragon", "Eagle", "Eel", "Honeybee", "Owl", "Sphinx"]),
   TAMMUZ : new table.Table("Darkness, character, promethean, athanor, tammuz",
      ["Cerberus", "Crab", "Humbaba", "Pelican", "Phoenix"]),
   ULGAN : new table.Table("Darkness, character, promethean, athanor, ulgan",
      ["Chimera", "Crane", "Dragon", "Fox", "La llorona", "Raven", "Salamander", "Toad"])
}
tables.push(...[Athanor.FRANKENSTEIN,Athanor.GALATEA,Athanor.OSIRIS,Athanor.TAMMUZ,Athanor.ULGAN])

const FRANKENSTEIN = "Frankenstein";
const GALATEA = "Galatea";
const OSIRIS = "Osiris";
const TAMMUZ = "Tammuz";
const ULGAN = "Ulgan";
const LINEAGE = new table.Table("Darkness, character, promethean, lineage",
  [FRANKENSTEIN, GALATEA, OSIRIS, TAMMUZ, ULGAN])
const AES = "Aes (aid)";
const ARGENTUM = "Argentum (mystery)";
const COBALUS = "Cobalus (impurity)";
const MERCURIUS = "Mercurius (pyros)";
const PHOSPORUM = "Phosporum (ephemerality)";
const CENTIMANTI = "Centimanti (flux)";
const REFINEMENT = new table.Table("Darkness, character, promethean, simple refinement")
for (let r of ["Aurum (mortality)", "Coprum (self)", "Ferrum (corpus)", "Plumbum (Source)",
    "Stannum (torment)"])
  REFINEMENT.add(r, 100);
for (let r of [AES, ARGENTUM, COBALUS, MERCURIUS, PHOSPORUM])
  REFINEMENT.add(r, 10);
REFINEMENT.add(CENTIMANTI, 1);
const TRANSMUTATION = new table.Table("Darkness, character, promethean, transmutations",
  ["Consortium", "Corporeum", "Deception", "Disquietism", "Electrification", "Mesmerism",
      "Metamorphosis", "Saturminus", "Sensorium", "Vitality", "Vulcanus"])
tables.push(...[LINEAGE,REFINEMENT,TRANSMUTATION])

const COMPLEX = new Map();
COMPLEX.set(AES, "Benefice");
COMPLEX.set(ARGENTUM, "Spiritus");
COMPLEX.set(COBALUS, "Contamination");
COMPLEX.set(MERCURIUS, "Alchemicus");
COMPLEX.set(PHOSPORUM, "Luciferius");
COMPLEX.set(CENTIMANTI, "Flux");
const ATHANOR = new Map();
ATHANOR.set(FRANKENSTEIN, Athanor.FRANKENSTEIN);
ATHANOR.set(GALATEA, Athanor.GALATEA);
ATHANOR.set(OSIRIS, Athanor.OSIRIS);
ATHANOR.set(TAMMUZ, Athanor.TAMMUZ);
ATHANOR.set(ULGAN, Athanor.ULGAN);
const DISQUIET = new Map();
DISQUIET.set(FRANKENSTEIN, "makes them the scapegoat of the Disquieted");
DISQUIET.set(GALATEA, "mix of of revulsion and lustful obsession");
DISQUIET.set(OSIRIS, "sparks an obsessive curiousity about the Promethean.");
DISQUIET.set(TAMMUZ, "disrupts communication between the Promethean and the Disquieted");
DISQUIET.set(ULGAN, "causes intense paranoia");
class Promethean extends table.Table {
	constructor() {
		super("Darkness, character, promethean");
	}

  roll() {
		let l = []
		let lineage = l.push("Lineage: "+ LINEAGE);
		let r = l.push("Refinement: "+ REFINEMENT);
		let t = COMPLEX.get(r);
		if (!t)
			t = TRANSMUTATION.roll();
		else
			t += " (complex)";
		l.push("Transmutation: "+ t.toLowerCase())
		l.push("Athanor: "+ ATHANOR.get(lineage))
		l.push("Disquiet: "+ DISQUIET.get(lineage))
		return l.join('<br/>')
	}
}

var promethean=new Promethean()
tables.push(promethean)

const DECREE = new table.Table("Darkness, character, mummy, decree",
    ["Heart", "Spirit", "Essence", "Name", "Shadow"])
const GUILD = new table.Table("Darkness, character, mummy, guild", ["Engravers of amulets",
    "First alchemists", "Inscribers of texts", "Sheperds of the shell", "Builders of effigies"])
class Mummy extends table.Table{
	constructor() {
		super("Darkness, character, mummy");
	}

  roll() {
		return [
      "Decree: "+ DECREE,
      "Guild: "+ GUILD
    ].join('<br/>')
	}
}
var mummy=new Mummy()
tables.push(...[DECREE,GUILD,mummy])


class Monster extends table.Table {
	constructor() {
		super("Darkness, character");
    this.add( wraith,500);
		this.add( hunter,500);
		this.add( werewolf.werewolf,300);
		this.add( changeling,300);
		this.add( beast,200);
		this.add( demon,200);
		this.add(kindred.kindred,100);
		this.add( mage.hedgemage,50);
		this.add( mage.mage,30);
		this.add( kuejin,30);
		this.add( bound,10);
		this.add( promethean,5);
		this.add( mummy,1);
	}

	roll(){
    let t=rpg.pick(this.lines)
		return t.name + ":<br/>" + t
	}
}

export var monster=new Monster()
tables.push(monster)
