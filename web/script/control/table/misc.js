import * as table from './table.js'
import * as rpg from '../rpg.js'

export var tables=[]

/** Concept by EagleFire. */
class Quantity extends table.Table {
	 constructor() {
		super("Quantity");
		this.add("Extremely low");
		this.add( "Low",2);
		this.add( "Average",3);
		this.add( "High",2);
		this.add( "Extremely high");
	}
}

tables.push(new Quantity())

class Delay extends table.Table{
  constructor(){
    super('Random encounter, delay')
  }
  
  roll() {
    return rpg.roll(1,10) + " minutes";
  }
};
var delay=new Delay()

const YES = "Yes";

class RandomEncounter extends table.Table {
	 constructor() {
		super("Random encounter");
		this.add(YES);
		this.add("No",4);
	}

  roll() {
		let r = super.roll();
		if (r == YES) r += ". Delay: " + delay.roll();
		return r;
	}
}
tables.push(...[delay,new RandomEncounter()])
