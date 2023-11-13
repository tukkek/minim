import * as table from '../table.js'
import * as rpg from '../../rpg.js'

export var tables=[]

class Tradition extends table.Table {
	constructor() {
		super("Darkness, mage, tradition");
		this.add("Order of Hermes", 2);
		this.lines.push(...["Akashic broterhood", "Celestial chorus", "Dreamspeakers", "Verbena", "Cult of ecstacy",
				"Virtual adepts", "Sons of ether", "Euthanatos"])
	}
}

class Faction extends table.Table {
	constructor() {
		super("Darkness, mage, faction");
		this.add("Traditions", 3);
		this.add("Technocracy", 4);
		this.add("Marauders", 1);
		this.add("Nephandi", 1);
		this.add("Orphans", 1);
	}
}

class Rank extends table.Table {
	constructor(title,a=1,d=5,ad=2,m=2) {
		super(title);
		this.add("Apprentice", a);
		this.add("Disciple", d);
		this.add("Adept", ad);
		this.add("Master", m);
	}
}

var tradition=new Tradition()
var faction=new Faction()

tables.push(...[tradition,faction])

const TRADITIONS = new Rank("Darkness, mage, rank, traditions");
const TECHNOCRACY = new Rank("Darkness, mage, rank, technoracy");
const NEPHANDI = new Rank("Darkness, mage, rank, nephandi", 1, 4, 4, 2);
const MARAUDER = new Rank("Darkness, mage, rank, marauder", 1, 4, 4, 2);
const ORPHAN = new Rank("Darkness, mage, rank, orphan", 1, 3, 2, 1)
ORPHAN.add("Lone apprentice", 1);
ORPHAN.add("Lone disciple", 2);
ORPHAN.add("Lone adept", 1);

const LARGEGROUP = "Large group";
const ORGANIZATION = new table.Table("Darkness, mage, NPC, hedge mage, organization",
  ["Loner", "Small group", LARGEGROUP]);

tables.push(...[TRADITIONS,TECHNOCRACY,NEPHANDI,MARAUDER,ORPHAN,ORGANIZATION])

class HedgeMage extends table.Table {
	constructor() {
		super("Darkness, mage, NPC, hedge mage");
	}

	 roll() {
		let lines = []
		let o = ORGANIZATION.roll();
		if (o == LARGEGROUP) {
			o += " (" + rpg.roll(1,10) * 10 + " hedge mages)";
		}
		lines.push("Organization: " + o);
		if (rpg.roll(20) == 20)
			lines.push("Associated with " + tradition.roll());
		return lines.join('<br/>')
	}
}

class Traditionalist extends table.Table {
  constructor(){
    super("Darkness, mage, NPC, traditionalist")
  }
  
  roll() {
    let lines = [
      "Tradition: " + tradition.roll(),
      "Rank: " + TRADITIONS.roll()
    ]
    return lines.join('<br/>')
  }
};

class Technocrat extends table.Table {
  constructor(){
    super("Darkness, mage, NPC, technocrat")
  }
  
  roll() {
    return "Rank: " + TECHNOCRACY.roll()
  }
}

class Nephandi extends table.Table{
  constructor(){
    super('Darkness, mage, NPC, nephandi')
  }

  roll() {
    let lines = []
    lines.push("Rank: " + NEPHANDI.roll());
    if (rpg.roll(1,2) == 1) {
      lines.push("Resides in Umbra");
    } else
      lines.push("Resides on Earth");
    if (rpg.roll(1,4) == 4) {
      lines.push("Independent");
    } else
      lines.push("Part of a labyrinth");
    return lines.join(".<br/>")
  }
};

class Orphan extends table.Table{
  constructor(){
    super("Darkness, mage, NPC, orphan")
  }
  
  roll() {
    return "Rank: " + ORPHAN.roll();
  }
}

export var hedgemage=new HedgeMage()
var traditionalist=new Traditionalist()
var technocrat=new Technocrat()
var nephandi=new Nephandi()
var orphan=new Orphan()

tables.push(...[hedgemage,traditionalist,technocrat,nephandi,orphan])

const FACTIONS = new Map()
FACTIONS.set("Traditions", traditionalist);
FACTIONS.set("Technocracy", technocrat);
FACTIONS.set("Nephandi", nephandi);
FACTIONS.set("Marauders", MARAUDER);
FACTIONS.set("Orphans", orphan);

class Mage extends table.Table {
	constructor() {
		super("Darkness, mage");
	}

	roll() {
		let t = faction.roll();
		return "Faction: " + t + ".<br/>" + FACTIONS.get(t).roll();
	}
}

const BACKRGOUND = new table.Table("Darkness, mage, NPC, marauder, background")
BACKRGOUND.add("Former traditionalist", 4);
BACKRGOUND.add("Former technocrat", 2);
BACKRGOUND.add("Former nephandi", 1);
BACKRGOUND.add("Former orphan", 3);

export var mage=new Mage()
tables.push(...[mage,BACKRGOUND])

class Marauder extends table.Table {
	constructor() {
		super("Darkness, mage, NPC, marauder");
	}

  roll() {
		let lines = []
		lines.push("Rank: " + Rank.MARAUDER.roll());
		if (rpg.roll(1,4) == 1) {
			lines.push("Resides on Earth");
		} else
			lines.push("Resides in Umbra");
		lines.push(BACKRGOUND.roll());
		return lines.join('<br/>')
	}
}

const FACTION = new table.Table("Darkness, mage, social, nephandi labyrinth, type")
FACTION.add("Infernal", 4);
FACTION.add("Wyrm", 3);
FACTION.add("Deep Umbra", 1);
FACTION.add("Freelance", 2);

class Labyrinth extends table.Table {
  constructor() {
		super("Darkness, mage, social, nephandi labyrinth");
	}

	roll() {
		let lines = [
      "Mages: " + (rpg.roll(1,10) + rpg.roll(1,10)),
      "Faction: " + FACTION.roll().toLowerCase()
    ];
		return lines.join('<br/>')
	}
}

class Chantry extends table.Table {
  constructor() {
		super("Darkness, mage, social, tradtitions chantry");
	}

	rolltype() {
		let r = rpg.roll(1,3);
		let type=''
		let ntraditions=0
		if (r == 1) {
			type = "unified";
			ntraditions = 1;
		} else if (r == 2) {
			type = "mixed";
			ntraditions = rpg.roll(2) + 1;
		} else {
			type = "open";
			ntraditions = 4;
			while (rpg.roll(2) == 1)
				ntraditions += 1;
		}
		let traditions = []
		while (traditions.length < ntraditions) {
			traditions.push(tradition.roll().toLowerCase());
		}
		return `Type: ${type} (${traditions.join(',' )})`
	}

  roll() {
		let lines = []
		lines.push("Cabals: " + rpg.roll(1,6));
		lines.push("Mages: " + (rpg.roll(1,20) + rpg.roll(1,20)));
		lines.push(this.rolltype());
		let nnodes = rpg.roll(1,6);
		let nodes = []
		let power = 0;
		for (let i = 0; i < nnodes; i++) {
			let n = rpg.roll(1,3);
			nodes.push(n);
			power += n;
		}
		nodes=nodes.map(n => n.toString()).join(", ")
		lines.push(`Power: ${power} (nodes: ${nodes})`)
		if (power >= 13) {
			lines.push("Has Doissetep-class Horizon Realms");
		} else if (power >= 10) {
			lines.push("Has Horizon Realms");
		}
		return lines.join('<br/>')
	}
}

class Construct extends table.Table{
  constructor(){
    super("Darkness, mage, social, technocracy convention, construct")
  }
  
  roll() {
    var lines = [
      "Amalgams: " + (rpg.roll(1,4)),
      "Mages: " + (rpg.roll(1,10) + rpg.roll(1,10))
    ]
    return lines.join('<br/>')
  }
};

class Convention extends table.Table {
	constructor() {
		super("Darkness, mage, social, technocracy convention");
	}

	roll() {
		let lines = [
      "Mages: " + (rpg.roll(1,6) + rpg.roll(1,6)) * 100,
      "Constructs: " + (rpg.roll(1,6) + rpg.roll(1,6)) * 10
    ]
    return lines.join('<br/>')
	}
}

tables.push(...[FACTION,new Labyrinth(),new Chantry(),new Construct(),new Convention()])
