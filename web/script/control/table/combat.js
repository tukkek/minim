import * as table from './table.js'
import * as rpg from '../rpg.js'

const LEG = "Leg";
const HAND = "Hand";
const ARM = "Arm";
const ABDOMEN = "Abdomen";
const HEART = "Heart";
const CHEST = "Chest";
const NECK = "Neck";
const EYE = "Eye";
const EAR = "Ear";
const HEAD = "Head";
const EFFECTS = new Map([
  [LEG, ["Slowed for a couple of turns", "Slowed until end of combat", "Permanently slowed"]],
  [HAND, ["Cannot hold for a couple of turns", "Cannot hold until end of combat",
      "Cannot hold permanently"]],
  [ARM, ["Penalty to attacks for a couple of turns", "Penalty to attacks until end of combat",
      "Permanent penalty to attacks"]],
  [ABDOMEN,
      ["Staggered for a couple of turns", "Staggered until end of combat", "Permanently staggered"]],
  [HEART, ["No particular effect.", "No particular effect.", "Instant death."]],
  [CHEST,
      ["No particular effect.", "Stunned for a couple of turns.", "Target is unconscious."]],
  [NECK, ["Muted for a couple of turns.", "Muted until end of combat.", "Permanently muted."]],
  [EYE,
      ["Blinded for a couple of turns.", "Blinded until end of combat.", "Permanently blind."]],
  [EAR, ["Deaf for a couple of turns.", "Deaf until end of combat.", "Permanently deaf."]],
  [HEAD, ["Disoriented for a couple of turns.", "Disoriented until end of combat.",
      "Permanently disoriented."]],
])



class Wound extends table.Table {
	constructor(name, effect) {
		super(name);
		this.effect = effect;
		this.add(HEAD,2);
		this.add(EAR);
		this.add(EYE);
		this.add( NECK);
		this.add( CHEST,5);
		this.add( HEART);
		this.add( ABDOMEN,2);
		this.add( ARM,5);
		this.add( HAND,2);
		this.add( LEG,5);
	}


	 roll() {
		let r = super.roll();
    let e=EFFECTS.get(r)[this.effect].toLowerCase()
		return r.toLowerCase() + " - "+e+".";
	}
}

const HIT = new Wound("Combat, wound", 0);
const CRITICAL = new Wound("Combat, wound, critical", 1);
const DEADLY = new Wound("Combat, wound, deadly", 2);


const twist = new table.Table("Combat, twist",["Reinforce", "Change", "Disadvantage opponent", "Advantage self", "Bargain", "Trick"]);
const NEW = "New action";
const TWIST = "Twist";

class ActionType extends table.Table {
	constructor(title) {
		super(title);
		this.add("Repeat previous action",5);
		this.add(NEW,9-6+1);
		this.add(TWIST);
	}
}
const actiontype = new ActionType("Combat, action type");

const ACTIONS = new Map()

let i = 3;
for (let a of ["Panic", "Surrender", "Flee", "Retreat", "Guard", "Buy time", "Wait", "Distract", "Probe",
    "Light attack", "Attack", "Heavy attack", "Feint", "Taunt", "Charge", "Enrage"]) {
  ACTIONS.set(i, a);
  i += 1;
}

class Action extends table.Table {
	 constructor(name,bonus) {
		super(name);
		this.bonus = bonus;
	}

  roll() {
		var a = actiontype.roll();
		if (a == NEW)
			return ACTIONS.get(rpg.roll(1,6) + rpg.roll(1,6) + this.bonus);
		if (a == TWIST)
			return "Twist: " + twist.roll().toLowerCase();
		return a;
	}
}

const TREMBLING = new Action("Combat, action, trembling", +1);
const COWERING = new Action("Combat, action, cowering", +2);
const CAUTIOUS = new Action("Combat, action, cautious", +3);
const CERTAIN = new Action("Combat, action, certain", +4);
const DARING = new Action("Combat, action, daring", +5);
const CAREFREE = new Action("Combat, action, carefree", +6);


export var tables=[HIT,CRITICAL,DEADLY]
  .concat([twist,actiontype])
  .concat([TREMBLING,COWERING,CAUTIOUS,CERTAIN,DARING,CAREFREE])

