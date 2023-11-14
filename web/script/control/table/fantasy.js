import * as table from './table.js'

class Kit extends table.Table{
  constructor(title,tables){
    super(title,tables);
  }

  roll(s=true){
    let r=super.roll();
    return s?swap(r):r;
  }
}
const MAGICAL=new table.Table("Fantasy, character, class, by type, magical",
  ["Cleric","Wizard","Druid"])
const HYBRID=new table.Table("Fantasy, character, class, by type, hybrid",
  ["Paladin","Ranger","Bard"])
const MARTIAL=new table.Table("Fantasy, character, class, by type, martial",
  ["Monk","Fighter","Rogue"])
const TYPES=[MAGICAL,HYBRID,MARTIAL]
const LAWFUL=new table.Table("Fantasy, character, class, by ethics, lawful",
  TYPES.map(t => t.lines[0]))
const NEUTRAL=new table.Table(
  "Fantasy, character, class, by ethics, neutral",
  TYPES.map(t => t.lines[1]))
const CHAOTIC=new table.Table(
  "Fantasy, character, class, by ethics, chaotic",
  TYPES.map(t => t.lines[2]))
const ETHICS=new table.Table("Fantasy, character, alignment, ethics",
  ["Lawful","Neutral","Chaotic"])
const MORALS=new table.Table("Fantasy, character, alignment, morals",
  ["Good","Neutral","Evil"])


class Alignment extends table.Table{
  constructor(){
    super("Fantasy, character, alignment")
  }
  
  roll(){
    let e=ETHICS.roll();
    let m=MORALS.roll();
    return describe(e,m);
  }
};

export var tables=[MAGICAL,HYBRID,MARTIAL,LAWFUL,NEUTRAL,CHAOTIC,ETHICS,MORALS,new Alignment()]

const MONK=new table.Table("Fantasy, character, class, kit, monk",
  [MARTIAL.lines[0],"Ninja","Acrobat","Drunken master","Dervish",
      "Brawler","Samurai","Tattooist","Kinetic psionic","Metabolic psionic",
      "Teleporting psionic"])
const FIGHTER=new table.Table("Fantasy, character, class, kit, fighter",
  [MARTIAL.lines[1],"Barbarian","Duelist","Gladiator",
      "Field commander","Dragoon","Viking","Knight","Breaker","Defender",
      "Dual-wielder"])
const ROGUE=new table.Table("Fantasy, character, class, kit, rogue",
  [MARTIAL.lines[2],"Assassin","Infiltrator","Swashbuckler",
      "Dungeoneer","Poison-master","Cutpurse","Saboteur","Thug"])
const PALADIN=new table.Table("Fantasy, character, class, kit, paladin",
  [HYBRID.lines[0],"Demon-hunter","Witch-hunter","Exorcist",
      "Evangelist","Guardian","Justicar","Unholy knight"])
const RANGER=new table.Table("Fantasy, character, class, kit, ranger",
  [HYBRID.lines[1],"Warden","Archer","Hunter","Trapper",
      "Pathfinder","Rider","Mageblade"])
const BARD=new table.Table("Fantasy, character, class, kit, bard",
  [HYBRID.lines[2],"Loremaster","Diplomat","Navigator","Spy",
      "Orator","Gambler","Trickster","Jester","Juggler","Mime","Dancer",
      "Ministrel","Troubadour","Artificer","Gadgeteer","Apothecary",
      "Runesmith"])
const CLERIC=new table.Table("Fantasy, character, class, kit, cleric",
  [MAGICAL.lines[0],"Chaos cleric","Curses cleric",
      "Dream cleric","Glory cleric","Control cleric","Healing cleric",
      "Law cleric","Luck cleric","Madness cleric","Manipulation cleric",
      "Sacrifice cleric","Sun cleric","Wealth cleric"])
const WIZARD=new table.Table("Fantasy, character, class, kit, wizard",
  [MAGICAL.lines[1],"Air mage","Cold mage","Dimensional mage",
      "Earth mage","Electricity mage","Fire mage","Magma mage","Metal mage",
      "Mud mage","Shadow mage","Smoke mage","Steam mage","Time mage",
      "Water mage","Celestial warlock","Draconic warlock","Fey warlock",
      "Infernal warlock","Vampiric warlock","Shapeshifter warlock",
      "Animist wizard","Banishment wizard","Counter-spell wizard",
      "Demonologist wizard","Divination wizard","Illusionist wizard",
      "Necromancer wizard","Transmutation wizard"])
const DRUID=new table.Table("Fantasy, character, class, kit, druid",
  [MAGICAL.lines[2],"Weathermancer","Floramancer","Cultist",
      "Werewolf","Werebear","Wereboar","Werebat","Apiarist","Beastmaster",
      "Vermin-lord","Shaman"])
const KITS=[FIGHTER,WIZARD,CLERIC,ROGUE,
  DRUID,PALADIN,RANGER,BARD,MONK];
const KIT=new Kit("Fantasy, character, class, kit",TYPES);
const RACE=new table.Table("Fantasy, character, race",
  ["Human","Dwarf","Elf","Gnome","Half-elf","Half-orc","Halfling"])
const TIERS=["Low-level","Mid-level","High-level",
  "Epic-level"];
const LEVEL=new table.Table("Fantasy, character, level")
LEVEL.add(TIERS[0],100);
LEVEL.add(TIERS[1],30);
LEVEL.add(TIERS[2],6);
LEVEL.add(TIERS[3],1);

tables.push(...[MONK,FIGHTER,ROGUE,PALADIN,RANGER,BARD,CLERIC,WIZARD,DRUID,KIT,RACE,LEVEL])

function describe(ethic,moral){
  if(ETHICS.lines[1]==ethic&&MORALS.lines[1]==moral)
    return "Neutral";
  return ethic+'-'+moral.toLowerCase()
}

function swap(kit){
  var k=KITS.find(kits => kits.lines.includes(kit))
  return !k?kit:k.roll();
}

class FantasyCharacter extends table.Table{
   constructor(){
    super("Fantasy, character");
  }

  validate(kit,ethic,ethics,forrbidden){
    return !(ethics.lines.includes(kit)&&ethic==forrbidden);
  }

  roll(){
    let r=KIT.roll(false);
    let e=ETHICS.roll();
    while (!this.validate(r,e,LAWFUL,ETHICS.lines[2])
        ||!this.validate(r,e,CHAOTIC,ETHICS.lines[0]))
      e=ETHICS.roll();
    let l=LEVEL.roll();
    let alignment=describe(e,MORALS.roll()).toLowerCase();
    let race=RACE.roll().toLowerCase();
    r=swap(r).toLowerCase();
    return [l,alignment,race,r].join(' ')
  }
}
 
tables.push(new FantasyCharacter())

const LOW=new table.Table("Fantasy, character, simple, low-level",
  ["Adept","Aristocrat","Commoner","Expert","Warrior"])
const MID=new table.Table("Fantasy, character, simple, mid-level",
  ["Sorcerer (Adept/Aristocrat)","Shaman (Adept/Commoner)",
      "Bard (Adept/Expert)","Cleric (Adept/Warrior)",
      "Explorer (Aristocrat/Commoner)","Spy (Aristocrat/Expert)",
      "Duelist (Aristocrat/Warrior)","Rogue (Commoner/Expert)",
      "Barbarian (Commoner/Warrior)","Thug (Expert/Warrior)"])
const HIGH=new table.Table("Fantasy, character, simple, high-level",
  ["Druid (Adept/Aristocrat/Commoner)",
      "Wizard (Adept/Aristocrat/Expert)",
      "Paladin (Adept/Aristocrat/Warrior)","Dancer (Adept/Commoner/Expert)",
      "Ranger (Adept/Commoner/Warrior)","Ninja (Adept/Expert/Warrior)",
      "Emissary (Aristocrat/Commoner/Expert)",
      "Warden (Aristocrat/Commoner/Warrior)",
      "Assassin (Aristocrat/Expert/Warrior)",
      "Monk (Commoner/Expert/Warrior)"])
const EPIC=new table.Table("Fantasy, character, simple, epic-level",
  ["Magi (Adept/Aristocrat/Commoner/Expert)",
      "Bishop (Adept/Aristocrat/Commoner/Warrior)",
      "Samurai (Adept/Aristocrat/Expert/Warrior)",
      "Dervish (Adept/Commoner/Expert/Warrior)",
      "Commander (Aristocrat/Commoner/Expert/Warrior)"])
const CLASSES=[LOW,MID,HIGH,EPIC]

class SimpleCharacter extends FantasyCharacter{
   constructor(){
    super();
    this.name+=" (simple)";
  }

  roll(){
    let alignment=describe(ETHICS.roll(),MORALS.roll()).toLowerCase();
    let race=RACE.roll().toLowerCase();
    let l=LEVEL.roll();
    let tier=CLASSES[TIERS.indexOf(l)+1];
    let kit=tier.roll().toLowerCase();
    return [l,alignment,race,kit].join(' ')
  }
}

tables.push(...CLASSES.concat([new SimpleCharacter()]))
