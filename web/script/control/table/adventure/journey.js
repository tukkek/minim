import * as table from '../table.js'
import * as rpg from '../../rpg.js'
import * as nomine from '../nomine.js'
import * as character from '../kult/character.js'
import * as setting from '../kult/setting.js'
import * as darkness from '../darkness/darkness.js'
import * as mage from '../darkness/mage.js'
import * as real from '../real.js'

export var tables=[]

class Character extends table.Table{
  constructor(){
    super("Adventure, journey, character",
          [new table.Table("Character (In Nomine)", [nomine.GOD, nomine.HELL]),
            character.ARCHETYPE, new table.Table("Character (World of Darkness)",
            [darkness.bound, mage.hedgemage, darkness.hunter])])
  }

  roll() {
    return real.FULL.roll() + "<br/><br/>" + super.roll();
  };
};

tables.push(new Character())

const ENEMY = new table.Table("Adventure, journey, enemy",
    [nomine.characters,
        new table.Table("Enemy (Kult)", [setting.being, setting.cult, character.GENERIC]),
        darkness.monster]);
const REWARD = new table.Table("Adventure, journey, reward",
    [nomine.artifact, setting.artifact, darkness.ARTIFACT]) 
tables.push(...[ENEMY,REWARD])

const QUALITY=['terrible','poor','average','good','fantastic']
const MINOR=[QUALITY,QUALITY].flatMap(m=>m)
const ALIGNMENTS=
    ["Idealist","Pacifist","Free-spirited","Honorable",
        "Bystander","Roamer","Proud","Pragmatic","Monster"]
const NUMERALS=["I","II","III","IV","V","VI",
    "VII","VIII","IX","X","XI","XII"];
const PAGES=
    [[7,8,9,5],[1,4,7,5],[3,6,9,5],
        [1,2,3,5]]
const MAJOR=new Map([
  ["Trickery","Innocent"],
  ["Manipulation","Alchemist"],
  ["Mysticism","Oracle"],
  ["Compassion","Mother"],
  ["Leadership","Father"],
  ["Religion","Saint"],
  ["Love","Lover"],
  ["Control","Warrior"],
  ["Virtue","Hero"],
  ["Wisdom","Mentor"],
  ["Luck","Gambler"],
  ["Reason","Advocate"],
  ["Sacrifice","Seeker"],
  ["Change","Rebel"],
  ["Balance","Mediator"],
  ["Darkness","Deviant"],
  ["Demise","Destroyer"],
  ["Faith","Divine"],
  ["Madness","Poet"],
  ["Hope","Child"],
  ["Redemption","Knight"],
  ["Union","Guide"],
]);


class Deck{
  constructor(){
    this.clubs=rpg.shuffle(Array.from(MINOR));
    this.spades=rpg.shuffle(Array.from(MINOR));
    this.cups=rpg.shuffle(Array.from(MINOR));
    this.coins=rpg.shuffle(Array.from(MINOR));
    this.court=rpg.shuffle(Array.from(
        ["Summon","Refuse","Aid","Reach","Try","Atone","Worship",
            "Win","Flee","Rescue","Return to","Transcend"]));
    this.major=rpg.shuffle(Array.from(MAJOR.keys()));
  }
}

/**
 * My version of a narrative framework game using tarot cards. First, a setup is
 * generated using major arcana as characters/archeetypes, minor arcana
 * representing their details. Then story beats are generated on-demand, while
 * court cards are used to select plot points from the hero's journey (knight of
 * clubs to king of cups). Pages are separated, drawing one per stage to select
 * a row or column of characters (middle always available).
 * 
 * @author alex
 */
 class Journey extends table.Table{
	 constructor(){
		super("Adventure, journey");
	}

	characterize(character,d){
		let b=d.clubs.pop() + " body";
		let m=d.spades.pop() + " mind";
		let s=d.cups.pop() + " soul";
		let w=d.coins.pop() + " wealth";
		let traits=[b,m,s,w].filter(t => !t.includes("mediocre"))
				.join(", ")
		if(traits.length==0) traits="mediocre";
		return `${character} (${traits})`
	}

  roll(){
		let l=[];
		let d=new Deck();
		l.push("Protagonist"+': '+this.characterize(MAJOR.get(d.major.pop()),d) + ".");
		let characters=[]
		for (let a of ALIGNMENTS){
			let character=a.toLowerCase() + " "
					+ MAJOR.get(d.major.pop()).toLowerCase();
			characters.push(this.characterize(character,d));
		}
		l.push('');
		l.push("Stages:");
		let numerals=Array.from(NUMERALS);
		while (d.court.length>0){
			let beat=`- ${numerals.pop()}. ${d.court.pop()} ${d.major.pop().toLowerCase()}`
			let character=-1;
			while (rpg.roll(1,2)==1&&character<characters.length-1)
				character+=1;
			if(character>=0){
				let c=characters[character];
				beat+=`: ${c}.`
			}else
				beat+=".";
			l.push(beat);
		}
		l.push('');
		rpg.shuffle(PAGES);
		for (let p of PAGES.slice(0,2)){
			let lines=l.join('<br/>');
			let faction=p.map(i => characters[i-1])
					.map(c => c.slice(0,c.indexOf((" ("))))
					.filter(c => lines.includes(c))
			if(faction.length>=2)
				l.push(`Faction: ${faction.join(", ")}.`);
		}
		return l.join('<br/>');
	}
}

tables.push(new Journey())
