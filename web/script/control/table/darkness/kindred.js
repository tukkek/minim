import * as table from '../table.js'
import * as rpg from '../../rpg.js'

class Age extends table.Table {
	constructor() {
		super("Darkness, kindred, age");
	}

	roll() {
    this.lines=[]
		let millenium = 1;
		while (rpg.roll(1,2) == 1) millenium += 1;
		this.add( millenium * 1000 + " years",3);
		this.add( (3 + rpg.roll(1,7) - 1) * 100 + " years",4);
		this.add( "200 years",4);
		this.add( "100 years",3);
		this.add( rpg.roll(1,9) * 10 + " years",40);
    return super.roll()
	}
}

const ANTITRIBU = "antitribu";

const CAMARILLA = new table.Table("Darkness, kindred, clan,  camarilla") 
CAMARILLA.add( "Ventrue",10);
CAMARILLA.add( "Toreador",10);
CAMARILLA.add( "Tremere",8);
CAMARILLA.add( "Nosferatu",9);
CAMARILLA.add( "Malkavian",7);
CAMARILLA.add( "Lasombra",6);

const INDEPENDENT = new table.Table("Darkness, kindred, clan,  independent") 
INDEPENDENT.add("Giovanni",4);
INDEPENDENT.add("Ravnos",3);

const SABBAT = new table.Table("Darkness, kindred, clan,  sabbat")
SABBAT.add( "Assamite",3);
SABBAT.add( "Tzimisce",6);
let antitribu = Array.from(CAMARILLA.unique)
antitribu.push(...INDEPENDENT.unique)
for (let a of antitribu) SABBAT.add(a + " " + ANTITRIBU);

const ANARCH = new table.Table("Darkness, kindred, clan,  anarch") 
ANARCH.add("Brujah",20);
ANARCH.add("Gangrel",8);
ANARCH.add( "Setites",3);
ANARCH.add("Caitiff",3);
var others = Array.from(CAMARILLA.unique)
others.push(...INDEPENDENT.unique);
others.push(...SABBAT.unique);
ANARCH.lines.push(...others.filter(o=>!o.includes(ANTITRIBU)).map(o => o + " anarch"))

const FACTIONS = new Map();
for (let f of [ANARCH, CAMARILLA, INDEPENDENT, SABBAT]) {
  FACTIONS.set(f.name, f);
}

class Clan extends table.Table {
	constructor(title, c, s) {
		super(title);
		this.add(ANARCH.name,3);
		this.add(CAMARILLA.name,c);
		this.add(INDEPENDENT.name,3);
		this.add(SABBAT.name,s);
	}

	 roll() {return FACTIONS.get(super.roll()).roll()}
}

const URBAN = new Clan("Darkness, kindred, clan, urban", 4, 2);
const RURAL = new Clan("Darkness, kindred, clan, rural", 2, 4);

class Generation extends table.Table {
	constructor() {
		super("Darkness, kindred, generation");
		this.add("4th", 3);
		this.add("5th", 6);
		this.add("6th", 10);
		this.add("7th", 20);
		this.add("8th", 20);
		this.add("9th", 20);
		this.add("10th", 9);
		this.add("11th", 4);
		this.add("12th", 5);
		this.add("13th", 4);
		this.add("14th", 1);
	}
}

class Type extends table.Table {
	constructor() {
		super("Darkness, kindred, type");
		this.add("Vampire", 7);
		this.add("Ghoul", 2);
		this.add("Revenant", 1);
	}
}

var type=new Type()
var generation=new Generation()
var age=new Age()

const TRAITS = new Map();
TRAITS.set(RURAL, "Clan");
TRAITS.set(URBAN, "Clan");
TRAITS.set(type, "Type");
TRAITS.set(generation, "Generation");
TRAITS.set(age, "Age");

class Kindred extends table.Table {
	constructor(title, clan) {
		super(title);
		this.clan = clan;
	}

	 roll() {
		return [type, this.clan, generation, age]
				.map(t => TRAITS.get(t) + ": " + t.roll().toLowerCase() + ".").join("<br/>");
	}
}

export var urban = new Kindred("Darkness, kindred, urban", URBAN);
export var rural = new Kindred("Darkness, kindred, rural", RURAL);
export var kindred = new table.Table("Darkness, kindred", [rural,urban]);

export var tables=[age,CAMARILLA,SABBAT,INDEPENDENT,ANARCH,URBAN,RURAL,type,generation,urban,rural,kindred]
