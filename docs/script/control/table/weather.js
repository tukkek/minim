import * as table from './table.js' 

export var tables=[]

const SPRING = "Spring";
const WINTER = "Winter";
const AUTUMN = "Autumn";
const SUMMER = "Summer";
const SEASONS = new table.Table("Weather, calendar,  season", [SUMMER, AUTUMN, WINTER, SPRING]);

tables.push(SEASONS)

class Weather extends table.Table {
	constructor(title) {
		super(title);
    this.normal = "Normal";
    this.normalodds = 70;
    this.abnormal1 = "Abnormal";
    this.abnormal1odds = 5;
    this.abnormal2 = "Abnormal";
    this.abnormal2odds = 5;
    this.inclement = "Inclement";
    this.inclementodds = 10;
    this.storm = "Storm";
    this.stormodds = 9;
    this.hazard = "Powerful storm";
    this.hazardodds = 1;
	}
	
	roll(){
    if(this.rows.length==0){
      this.add(this.normal, this.normalodds);
      this.add(this.abnormal1, this.abnormal1odds);
      this.add(this.abnormal2, this.abnormal2odds);
      this.add(this.inclement, this.inclementodds);
      this.add(this.storm, this.stormodds);
      this.add(this.hazard, this.hazardodds);
    }
    return super.roll()
  }
}

class Temperate extends Weather {
	constructor(name="Weather, calendar,  temperate") {
		super(name);
		this.normal = "Temperate";
		this.abnormal1 = "Heat wave";
		this.abnormal2 = "Cold snap";
		this.inclement = "Rain";
		this.storm = "Thunderstorm";
		this.hazard = "Windstorm, hurricane or tornado";
	}
}
var temperate=new Temperate()

class TemperateWinter extends Temperate {
	constructor() {
		super("Weather, calendar,  temperate, winter");
		this.normal = "Cold";
		this.inclement = "Snow";
		this.storm = "Snowstorm";
		this.hazard = "Blizzard";
	}
}
var temperatewinter=new TemperateWinter()

class TemperateSummer extends Temperate {
	constructor() {
		super("Weather, calendar,  temperate, summer");
		this.normal = "Warm";
	}
}
var temperatesummer=new TemperateSummer()

class Desert extends Weather {
	constructor() {
		super("Weather, calendar,  desert");
		this.normal = "Hot, calm";
		this.abnormal1odds = 10;
		this.abnormal1 = "Hot, windy";
		this.abnormal2odds = 0;
		this.inclement = "Hot windy";
		this.storm = "Sandstorm";
		this.hazard = "Downpour";
	}
}
var desert=new Desert()

class Cold extends Weather {
	constructor() {
		super("Weather, calendar,  cold");
		this.normal = "Cold, calm";
		this.abnormal1odds = 3;
		this.abnormal1 = "Heat wave";
		this.abnormal2odds = 7;
		this.abnormal2 = "Cold snap";
		this.inclement = "Snow";
		this.storm = "Snowstorm";
		this.hazard = "Blizzard";
	}
}
var cold=new Cold()

tables.push(...[temperate,temperatesummer,temperatewinter,cold,desert])

const DESERT = "Desert";
const PERMANENTSUMMER = "Permanent summer";
const FOURSEASONS = "Four seasons";
const COLD = "Cold";

class Climate extends table.Table {
	constructor() {
		super("Weather, calendar,  climate");
		this.add(COLD, 1 * 2);
		this.add(FOURSEASONS, 2 * 2);
		this.add(PERMANENTSUMMER, 1);
		this.add(DESERT, 1);
	}
}
var climate=new Climate()
tables.push(climate)

const CLIMATES = new Map([
		[DESERT, desert],
		[COLD, cold],
		[SUMMER, temperatesummer],
		[AUTUMN, temperate],
		[SPRING, temperate],
		[PERMANENTSUMMER, temperatesummer],
		[WINTER, temperatewinter],
]);
const COLUMNS = 4;
const DAYS = 30;

class Calendar extends table.Table {
	constructor() {
		super("Weather, calendar");
	}

	roll() {
		let c = climate.roll();
		if (c == FOURSEASONS)
			c = SEASONS.roll();
		let t = CLIMATES.get(c);
		let s = c+'<br/>'
		let dates = []
		for (let i = 1; i <= DAYS; i++)
			dates.push(i+'. '+t.roll());
		for (let i = 0; i < dates.length; i += COLUMNS) {
			for (let d of dates.slice(i, i + COLUMNS))
				s += d + " ";
			s += "<br/>";
		}
		return s;
	}
}
export var calendar=new Calendar()
tables.push(calendar)
