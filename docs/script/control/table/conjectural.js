import * as table from './table.js'
import * as rpg from '../rpg.js'

const FIRST = new table.Table("internal",["NPC",
    "PC",
    "Organization",
    "Physical event",
    "Emotional event",
    "Item"]) 
const SECOND = new table.Table("internal",["Appears",
    "Alters the location",
    "Helps the hero",
    "Hinders the hero",
    "Changes the goal",
    "Ends the scene",]) 

class SceneTwist extends table.Table {

	constructor() {
		super("Conjectural, scene twist");
	}

	 roll() {
		return FIRST.roll() + " " + SECOND.roll().toLowerCase();
	}
}

var twist=new SceneTwist()

class SceneTone extends table.Table {
  constructor() {
		super("Conjectural, scene tone");
		this.add("Dramatic scene",3);
		this.add( "Quiet scene",2);
		this.add("Meanwhile...");
	}

	 roll() {
		let result = super.roll();
		if (rpg.roll(1,6) == 1)
			result += " (twist: " + twist.roll() + ")";
		return result;
	}
}

var unexpectedly=new table.Table ("Conjectural, unexpectedly",[
      "foreshadowing (set a thread to be the main thread for the next scene)",
		"tying off (the main thread resolves or substantially moves forward)",
		"to conflict (transition to next scene, which centers on a conflict)",
		"costume change (an NPC drastically changes their mind, motivations, alliances...)",
		"key grip (set the location or elements for the next scene and start transition)",
		"to knowledge (transition to next scene, which centers on lore)",
		"framing (an NPC or object becomes critical to the main thread)",
		"set change (scene continues in another location)",
		"upstaged (NPC makes a big move or goes into overdrive)",
		"pattern change (the main thread gets modified, drastically)",
		"limelit (the rest of the scene goes great for the PCs)",
		"entering the red (threat of danger or combat arrives)",
		"to endings (transition to next scene, which resolves or moves forward a thread)",
		"montage (the timeframe of the scene changes)",
		"enter stage left (a PC or NPC arrives)",
		"cross-stitch (choose another thread to be the main thread for the rest of the scene)",
		"six-degrees (a connection forms between characters)",])

const YES = "Yes";
const NO = "No";
const RESULTS = ["No, plus...", NO, "No, however...", "Yes, however...", YES,
  "Yes, plus..."]
;
class YesNo extends table.Table {
	constructor() {
		super("Conjectural, yes-no",RESULTS);
	}

  expand(roll) {
		if (!roll.includes("..."))
			return roll;
		return roll + " " + twist.roll();
	}
	
  roll(expand=true) {
		if (!expand)
			return super.roll();
		return this.expand(super.roll());
	}
}

var yesno=new YesNo()

class YesNoAdvantage extends table.Table {
	 constructor() {
		super("Conjectural, yes-no (advantage)");
	}

  roll() {
    let r=YesNoAdvantage.roll()
		return yesno.lines[Math.max(r[0],r[1])]
	}

  static roll() {
		var results = yesno.lines;
		var a = results.indexOf(yesno.roll(false));
		var b = results.indexOf(yesno.roll(false));
		return [a,b];
	}
}

 class YesNoDisadvantage extends table.Table {
	 constructor() {
		super("Conjectural, yes-no (disadvantage)");
	}

	 roll() {
    let r=YesNoAdvantage.roll()
		return yesno.lines[Math.min(r[0],r[1])]
	}
}

const YES_AND_UNEXPECTEDLY = "Yes and unexpectedly...";
const YES_BUT = "Yes but...";
const YES_AND = "Yes and...";
const NO_AND = "No and...";
const NO_BUT = "No but...";
const NO_AND_UNEXPECTEDLY = "No and unexpectedly...";

var surge = 0;

class YesNoLoom extends table.Table {
  constructor(title) {
		super(title);
	}

	 roll() {
		super.roll();
		let roll = rpg.roll(1,100);
		if (roll > 50) {
			roll += surge;
			if (roll > 100)
				roll = 100;
		} else {
			roll -= surge;
			if (roll < 1)
				roll = 1;
		}
		let result = this.lines[roll - 1]
		if (result == YES_AND_UNEXPECTEDLY || result == NO_AND_UNEXPECTEDLY) {
			result += " " + unexpectedly.roll();
			surge = 0;
		} else if (result == YES || result == NO)
			surge += 2;
		else
			surge = 0;
		return result;
	}

}

 class YesNoConflict extends YesNoLoom {
  constructor() {
		super("Conjectural, yes-no, loom, conflict");
		this.add(NO_AND_UNEXPECTEDLY);
		this.add(NO_BUT);
		this.add(NO_AND,20);
		this.add(NO,50-20);
		this.add(YES,80-50);
		this.add(YES_AND,90-80);
		this.add(YES_BUT);
		this.add(YES_AND_UNEXPECTEDLY);
	}
}


class YesNoEnding extends YesNoLoom {
	 constructor() {
		super("Conjectural, yes-no, loom, ending");
    this.add(NO_AND_UNEXPECTEDLY,2-1);
		this.add(NO_BUT,6-3);
		this.add(NO_AND,10-7);
		this.add(NO,50-10);
		this.add(YES,80-50);
		this.add(YES_AND,90-80);
		this.add(YES_BUT,8-5);
		this.add(YES_AND_UNEXPECTEDLY,100-90);
	}
}

class YesNoKnowledge extends YesNoLoom {
	 constructor() {
		super("Conjectural, yes-no, loom, knowledge");
		this.add(NO_AND_UNEXPECTEDLY,5);
		this.add(NO_BUT,10-6);
		this.add(NO_AND,20-10);
		this.add(NO,50-20);
		this.add(YES,80-50);
		this.add(YES_AND,5);
		this.add(YES_BUT,90-80);
		this.add(YES_AND_UNEXPECTEDLY,100-90);
	}
}

export var tables=[twist,new SceneTone(),unexpectedly,yesno,new YesNoAdvantage(),new YesNoDisadvantage(), new YesNoConflict(),new YesNoEnding(),new YesNoKnowledge()]
