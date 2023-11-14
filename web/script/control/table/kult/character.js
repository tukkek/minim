import * as table from '../table.js'
import * as rpg from '../../rpg.js'
import * as setting from './setting.js'

export var tables=[]

const NORMAL = "Normal";

const WEALTH = new table.Table("Kult, character, living standard",
			["Destitude", "Poor", "Low income", "Lower middle-class", "Middle-class", "Upper middle-class",
					"Well-off", "Very well-off", "Rich", "Extremely rich"]);
const LORES = new table.Table("Kult, character, skill, magic lore",
    ["Madness", "Space-time", "Dream", "Death", "Passion", "Reality"].map(l => l + " magic"))

tables.push(...[WEALTH,LORES])

const MELEE = "Mêlée weapons";
const POISONS = "Poisons";
const DRUGS = "Drugs";
const GRAFFITI = "Graffiti";
const HIDE = "Hide";
const HANDGUN = "Handgun";
const DRIVE = "Driving";
const IMPACT = "Impact weapons";
const CLIMB = "Climb";
const IMMIGRANT = "Immigrant language";
const UNARMED = "Unarmed combat";
const RHETORIC = "Rhetoric";
const WORDLY = "Steetwise";
const ESTIMATE = "Estimate value";
const SNEAK = "Sneak";
const AUTOMATIC = "Automatic weapon";
const DEMOLITION = "Demolition";
const DISGUISE = "Disguise";
const INFORMATION = "Gather information";
const DODGE = "Dodge";
const INTERROGATION = "Interrogation";
const SEARCH = "Search";
const SHADOW = "Shadow";
const COMPUTERS = "Computers";
const DIPLOMACY = "Diplomacy";
const FORGERY = "Forgery";
const CONTACTS = "Contacts";
const GAMBLING = "Gambling";
const ACTING = "Acting";
const ETIQUETTE = "Etiquette";
const NIGHT = "Assassination";
const FORENSICS = "Forensics";
const ELECTRONICS = "Electronics";
const PHOTOGRAPHY = "Photography";
const SURVIVAL = "Survival";
const RADIO = "Radio communications";
const SWIM = "Swimming";
const THROWING = "Throwing weapons";
const MECHANICS = "Motor mechanics";
const PILOTING = "Piloting";
const HEAVY = "Heavy weapons";
const AID = "First aid";
const PARACHUTING = "Parachuting";
const BUGGING = "Bugging";
const INTELLIGENCESKILL = "Intelligence services";
const CRYPTOGRAPHY = "Cryptography";
const PARRY = "Parry";
const RIDING = "Riding";
const SEAMANSHIP = "Seamanship";
const DIVING = "Scuba diving";
const ACCOUNTING = "Accounting";
const ECONOMICS = "Economics";
const LAW = "Law";
const WRITING = "Writing";
const SEDUCTION = "Seduction";
const DANCING = SEDUCTION;
const SPORT = "Sport";
const PSYCHOLOGY = "Psychology";
const SCIENCE = "Natural science";
const MEDICINE = "Medicine";
const CHEMISTRY = "Chemistry";
const ACROBATICS = "Acrobatics";
const FALLING = ACROBATICS;
const RIFLE = "Rifle";
const WHIPS = "Whips";
const CHAINS = "Chains";
const MUSIC = "Music";
const CRAFT = "Craft";
const ART = "Visual arts";
const POETRY = "Poetry";
const MARKETING = "Marketing";
const OCCULTISM = "Occultism";
const LANGUAGES = "Languages";
const FRENCH = LANGUAGES;
const ITALIAN = LANGUAGES;
const GERMAN = LANGUAGES;
const ARABIC = LANGUAGES;
const RUSSIAN = LANGUAGES;
const SECURITYSKILL = "Security";
const BURGLARY = SECURITYSKILL;
const SOCIALSKILL = "Social sciences";
const HUMANITIES = SOCIALSKILL;
const CODE = "Programming";
const MEDITATION = "Meditation";
const COOKING = "Cooking";
const ADMINISTRATION = "Administration";
const INSTRUCTION = "Instruction";
const BUREAUCRACY = "Bureaucracy";
const TRIVIA = "Trivia";
const CAROUSING = "Partying";
const STYLE = "Fashion";
const HAUT = "Fine tastes";

class Skill extends table.Table {
	constructor() {
		super("Kult, character, skill",
				[MELEE, POISONS, DRUGS, GRAFFITI, HIDE, HANDGUN, DRIVE, IMPACT, CLIMB, SECURITYSKILL, IMMIGRANT,
						UNARMED, RHETORIC, WORDLY, ESTIMATE, SNEAK, AUTOMATIC, DEMOLITION, DISGUISE, INFORMATION,
						ACROBATICS, DODGE, INTERROGATION, SEARCH, SHADOW, COMPUTERS, DIPLOMACY, FORGERY, CONTACTS,
						GAMBLING, ACTING, ETIQUETTE, NIGHT, FORENSICS, ELECTRONICS, PHOTOGRAPHY, SURVIVAL, RADIO, SWIM,
						THROWING, MECHANICS, PILOTING, HEAVY, AID, PARACHUTING, BUGGING, INTELLIGENCESKILL, CRYPTOGRAPHY,
						PARRY, RIDING, SEAMANSHIP, DIVING, ACCOUNTING, ECONOMICS, LAW, WRITING, SEDUCTION, SPORT,
						SOCIALSKILL, PSYCHOLOGY, SCIENCE, MEDICINE, CHEMISTRY, RIFLE, WHIPS, CHAINS, MUSIC, CRAFT, ART,
						POETRY, MARKETING, OCCULTISM, LANGUAGES, CODE, MEDITATION, COOKING, ADMINISTRATION, INSTRUCTION,
						BUREAUCRACY, TRIVIA, CAROUSING, STYLE, HAUT])
	}
}
var skill=new Skill()

tables.push(skill)

const ARTISTIC = "Artistic talent";
const HONOR = "Code of honor";
const AWARENESS = "Awareness";
const FLEXIBILITY = "Cultural flexiblity";
const SENSATE = "Sixth sense";
const ENDURANCE = "Endurance";
const INFLUENCE = "Influential friends";
const EMPATHY = "Empathy";
const INTUITION = "Intuition";
const LUCK = "Luck";
const ANIMALS = "Animal empathy";
const LANGUAGEGIFT = "Gift for languages";
const CHIVALRY = "Chivalry";
const PACIFISM = "Pacifism";
const REPUTATION = "Reputation";
const MATH = "Mathematical talent";
const HONESTY = "Honesty";
const ALTRUIST = "Altruist";
const ALERTNESS = AWARENESS;
const MECHANIC = "Mechanically-inclined";
const FORGIVING = "Forgiving";
const MOTHERLINESS = "Motherliness";
const GOAL = "Goal-driven";
const STATUS = "Status";
const FAITH = "Faith";
const LARGESSE = "Largesse";
const OPTIMIST = "Optimist";
const MENTOR = "Mentor";
const WILL = "Iron will";
const MAGICAL = "Magical intuition";

class Advantage extends table.Table {
	constructor() {
		super("Kult, character, advantage",
				[ARTISTIC, HONOR, AWARENESS, FLEXIBILITY, SENSATE, ENDURANCE, INFLUENCE, EMPATHY, INTUITION,
						LUCK, ANIMALS, LANGUAGEGIFT, CHIVALRY, PACIFISM, REPUTATION, MATH, HONESTY, ALTRUIST, MECHANIC,
						FORGIVING, MOTHERLINESS, GOAL, STATUS, FAITH, LARGESSE, OPTIMIST, MENTOR, WILL, MAGICAL])
	}
}

var advantage=new Advantage()
tables.push(advantage)

const GOODBALANCE = new Map();
GOODBALANCE.set(ALTRUIST, 5);
GOODBALANCE.set(ANIMALS, 20);
GOODBALANCE.set(ARTISTIC, 10);
GOODBALANCE.set(AWARENESS, 30);
GOODBALANCE.set(CHIVALRY, 5);
GOODBALANCE.set(HONOR, 5);
GOODBALANCE.set(FLEXIBILITY, 10);
GOODBALANCE.set(EMPATHY, 20);
GOODBALANCE.set(ENDURANCE, 20);
GOODBALANCE.set(LANGUAGEGIFT, 10);
GOODBALANCE.set(REPUTATION, 10);
GOODBALANCE.set(HONESTY, 5);
GOODBALANCE.set(INFLUENCE, 20);
GOODBALANCE.set(INTUITION, 20);
GOODBALANCE.set(LUCK, 20);
GOODBALANCE.set(MATH, 10);
GOODBALANCE.set(PACIFISM, 5);
GOODBALANCE.set(SENSATE, 20);
GOODBALANCE.set(MECHANIC, 10);
GOODBALANCE.set(FORGIVING, 5);
GOODBALANCE.set(MOTHERLINESS, 5);
GOODBALANCE.set(GOAL, 5);
GOODBALANCE.set(STATUS, 10);
GOODBALANCE.set(FAITH, 5);
GOODBALANCE.set(LARGESSE, 5);
GOODBALANCE.set(OPTIMIST, 5);
GOODBALANCE.set(MENTOR, 10);
GOODBALANCE.set(WILL, 10);
GOODBALANCE.set(MAGICAL, 20);
for (var a of advantage.lines)
  if (GOODBALANCE.get(a) == null)
    throw new RuntimeException("No GOODBALANCE for " + a);
      
const DEPRESSION = "Depression";
const BADREPUTATION = "Bad reputation";
const DEATHWISH = "Death wish";
const PHOBIA = "Phobia";
const CONSTRICTION = "Cognitive dissonance";
const PARANOIA = "Paranoia";
const PERSECUTED = "Persecuted";
const NIGHTMARES = "Nightmares";
const ADDICTION = "Drug addiction";
const LIAR = "Habitual liar";
const SCHIZOPHRENIA = "Schizophrenia";
const RATIONALIST = "Rationalist";
const NYMPHOMANIA = "Sexual neurosis";
const COMPULSION = "Mental compulsion";
const REVENGE = "Oath of revenge";
const ENEMY = "Mortal enemy";
const BADLUCK = "Bad luck";
const WANTED = "Wanted";
const HAUNTED = "Haunted";
const MANIA = "Mania";
const FANATICISM = "Fanaticism";
const INTOLERANCE = "Intolerance";
const TOUCHY = "Touchy";
const EGOTIST = "Narcissist";
const MAIMED = "Maimed";
const GREED = "Greed";
const GAMBLER = "Reckless gambler";
const CURSE = "Curse";
const MANICDEPRESSIVE = "Manic-depressive";
const ANXIETY = "Anxiety";
const SELFESTEEM = "Low self-esteem";
const MARTYR = "Martyr";
const MEDIUM = "Medium";
const NEGLIGENT = "Health- and hygiene-negligent";
const HYGIENE = "Compulsive health and hygiene";
const SPLIT = "Dissociative identity";
const INEPT = "Socially inept";
const BRASH = "Brash";
const DOMINEERING = "Domineering";
const VAIN = "Vain";
const TANTALIZING = "Sexually tantalizing";
const REACTIONARY = "Reactionary";
const RIVAL = "Rival";
const CYNIC = "Cynic";
const DEBT = "Debt";
const DEPENDENT = "Dependent";
const BLAMED = "Innocently blamed";
const MISTAKEN = "Mistaken identity";
const BLACKSHEEP = "Black sheep";
const FORGOTTEN = "Forgotten";
const ANIMAL = "Animal enmity";
const AMNESIA = "Partial amnesia";
      
class Disadvantage extends table.Table {
	constructor() {
		super("Kult, character, disadvantage",
				[DEPRESSION, BADREPUTATION, DEATHWISH, PHOBIA, CONSTRICTION, PARANOIA, PERSECUTED, NIGHTMARES,
						ADDICTION, LIAR, SCHIZOPHRENIA, RATIONALIST, NYMPHOMANIA, COMPULSION, REVENGE, ENEMY, BADLUCK,
						WANTED, HAUNTED, MANIA, FANATICISM, INTOLERANCE, TOUCHY, EGOTIST, MAIMED, GREED, GAMBLER, CURSE,
						MANICDEPRESSIVE, ANXIETY, SELFESTEEM, MARTYR, MEDIUM, NEGLIGENT, HYGIENE, SPLIT, INEPT, BRASH,
						DOMINEERING, VAIN, TANTALIZING, REACTIONARY, RIVAL, CYNIC, DEBT, DEPENDENT, BLAMED, MISTAKEN,
						FORGOTTEN, ANIMAL, AMNESIA])
	}
}

var disadvantage=new Disadvantage()
tables.push(disadvantage)

const BADBALANCE = new Map();
BADBALANCE.set(BADLUCK, 5);
BADBALANCE.set(BADREPUTATION, 10);
BADBALANCE.set(CURSE, 20);
BADBALANCE.set(DEATHWISH, 10);
BADBALANCE.set(DEPRESSION, 20);
BADBALANCE.set(ADDICTION, 20);
BADBALANCE.set(EGOTIST, 5);
BADBALANCE.set(FANATICISM, 10);
BADBALANCE.set(GAMBLER, 20);
BADBALANCE.set(GREED, 10);
BADBALANCE.set(LIAR, 10);
BADBALANCE.set(HAUNTED, 10);
BADBALANCE.set(MANIA, 20);
BADBALANCE.set(MANICDEPRESSIVE, 20);
BADBALANCE.set(COMPULSION, 10);
BADBALANCE.set(CONSTRICTION, 10);
BADBALANCE.set(ENEMY, 20);
BADBALANCE.set(NIGHTMARES, 10);
BADBALANCE.set(REVENGE, 5);
BADBALANCE.set(PARANOIA, 20);
BADBALANCE.set(PHOBIA, 10);
BADBALANCE.set(RATIONALIST, 20);
BADBALANCE.set(SCHIZOPHRENIA, 20);
BADBALANCE.set(NYMPHOMANIA, 10);
BADBALANCE.set(TOUCHY, 5);
BADBALANCE.set(WANTED, 10);
BADBALANCE.set(INTOLERANCE, 10);
BADBALANCE.set(PERSECUTED, 10);
BADBALANCE.set(MAIMED, 15);
BADBALANCE.set(GREED, 10);
BADBALANCE.set(GAMBLER, 20);
BADBALANCE.set(CURSE, 20);
BADBALANCE.set(MANICDEPRESSIVE, 20);
BADBALANCE.set(ANXIETY, 10);
BADBALANCE.set(SELFESTEEM, 10);
BADBALANCE.set(MARTYR, 10);
BADBALANCE.set(MEDIUM, 20);
BADBALANCE.set(NEGLIGENT, 10);
BADBALANCE.set(HYGIENE, 5);
BADBALANCE.set(SPLIT, 20);
BADBALANCE.set(INEPT, 5);
BADBALANCE.set(BRASH, 10);
BADBALANCE.set(DOMINEERING, 5);
BADBALANCE.set(VAIN, 5);
BADBALANCE.set(TANTALIZING, 10);
BADBALANCE.set(REACTIONARY, 10);
BADBALANCE.set(RIVAL, 10);
BADBALANCE.set(CYNIC, 5);
BADBALANCE.set(DEBT, 10);
BADBALANCE.set(DEPENDENT, 10);
BADBALANCE.set(BLAMED, 20);
BADBALANCE.set(MISTAKEN, 10);
BADBALANCE.set(BLACKSHEEP, 5);
BADBALANCE.set(FORGOTTEN, 10);
BADBALANCE.set(ANIMAL, 5);
BADBALANCE.set(AMNESIA, 10);
for (let d of disadvantage.lines)
  if (BADBALANCE.get(d) == null)
    throw new RuntimeException("No BADBALANCE for " + d);

const VICTIM = "Victim";
const SUPERNATURALEXPERIENCE = "Supernatural experience";
const PESSESSED = "Possessed";
const PACT = "Dark pact";
const OCCULTEXPERIENCE = "Occult experience";
const INSANITY = "Insanity";
const GUILTY = "Guilty";
const KNOWLEDGE = "Knowledge";
const FAMILY = "Family secret";
const SURVIVOR = "Survivor friend";
const GUARDIAN = "Guardian";
const UPROOTED = "Uprooted";
const CHOSEN = "Chosen";
const INHERITOR = "Inheritor";
const DISADVANTAGES = new Map();
DISADVANTAGES.set(CURSE,
  [DEPRESSION, BADREPUTATION, DEATHWISH, PHOBIA,
      CONSTRICTION, PARANOIA, PERSECUTED,
      NIGHTMARES, ADDICTION, LIAR, SCHIZOPHRENIA,
      RATIONALIST, NYMPHOMANIA, COMPULSION])
DISADVANTAGES.set(KNOWLEDGE,
  [DEPRESSION, DEATHWISH, ENEMY, REVENGE,
      PHOBIA, PARANOIA, PERSECUTED, NIGHTMARES,
      ADDICTION, BADLUCK, RATIONALIST, COMPULSION])
DISADVANTAGES.set(GUILTY,
  [DEPRESSION, BADREPUTATION, DEATHWISH, PHOBIA,
      CONSTRICTION, PARANOIA, PERSECUTED, WANTED,
      LIAR, NIGHTMARES, ADDICTION, BADLUCK,
      SCHIZOPHRENIA, RATIONALIST, COMPULSION])
DISADVANTAGES.set(INSANITY,
  [DEPRESSION, DEATHWISH, PHOBIA, CONSTRICTION,
      PARANOIA, HAUNTED, MANIA, NIGHTMARES,
      ADDICTION, SCHIZOPHRENIA, NYMPHOMANIA,
      COMPULSION])
DISADVANTAGES.set(OCCULTEXPERIENCE,
  [DEPRESSION, DEATHWISH, PHOBIA, PARANOIA,
      HAUNTED, WANTED, NIGHTMARES, ADDICTION,
      BADLUCK, RATIONALIST, SCHIZOPHRENIA,
      NYMPHOMANIA, COMPULSION])
DISADVANTAGES.set(PACT,
  [DEPRESSION, DEATHWISH, PHOBIA, CURSE,
      CONSTRICTION, PARANOIA, GREED, HAUNTED,
      PERSECUTED, LIAR, ADDICTION, BADLUCK,
      SCHIZOPHRENIA, NYMPHOMANIA, EGOTIST,
      COMPULSION])
DISADVANTAGES.set(HAUNTED,
  [DEPRESSION, DEATHWISH, PHOBIA, CONSTRICTION,
      PARANOIA, HAUNTED, NIGHTMARES, ADDICTION,
      RATIONALIST, COMPULSION])
DISADVANTAGES.set(SUPERNATURALEXPERIENCE,
  [DEPRESSION, DEATHWISH, PHOBIA, CONSTRICTION,
      PARANOIA, HAUNTED, WANTED, NIGHTMARES,
      ADDICTION, BADLUCK, RATIONALIST, SCHIZOPHRENIA,
      NYMPHOMANIA, COMPULSION])
DISADVANTAGES.set(VICTIM,
  [DEPRESSION, BADREPUTATION, DEATHWISH, ENEMY,
      REVENGE, PHOBIA, CONSTRICTION, PARANOIA,
      PERSECUTED, NIGHTMARES, LIAR, ADDICTION,
      BADLUCK, SCHIZOPHRENIA, NYMPHOMANIA,
      COMPULSION])
    
/**
 * Instead of having a free-form Archetype, I'm approaching this by not printing
 * the acrtual {@link #ARCHETYPE} name unless using that specific table. This
 * allows plenty of room for imagination on interpreting the results (except for
 * special cases such as sngle-{@link Profession} archetypes).
 * 
 * @author alex
 */
class KultCharacter extends table.Table {
	constructor(title, disadvantages, advantages, secrets,
			profession, wealthmin, wealthmax, skills) {
		super(title);
		this.disadvantages = Array.from(disadvantages);
		this.advantages = Array.from(advantages);
		this.secrets = Array.from(secrets);
		this.profession = Array.from(profession);
		this.wealthmin = wealthmin;
		this.wealthmax = wealthmax;
		this.skills = Array.from(skills)
    this.archetype=false
	}

  describe(balance) {
		if (balance <= -100)
			return "Loses control over disadvantages, Light Shadow awakens";
		if (balance <= -75)
			return "Psychotic, body changes, emotionally unstable";
		if (balance <= -50)
			return "Mentally ill";
		if (balance <= -25)
			return "Disturbed, abnormal, magical intution";
		if (balance <= -15)
			return "Uneasy, weak negative aura";
		if (balance >= +15)
			return "Comfortable, weak positive aura";
		if (balance >= +25)
			return "Likable, magic intuition";
		if (balance >= +50)
			return "Natural empathy";
		if (balance >= +75)
			return "Repels negative beings";
		if (balance >= +100)
			return "Repels negative beings, full body control, zero aggression, Dark Shadow awakens";
		return NORMAL;
	}

  roll() {
		let l = [];
    let n=this.name.split(', ')
    n=n[n.length-1]
    n=n.toUpperCase().slice(0,1)+n.slice(1)
    if(this.archetype) n=this.archetype+' '+n.toLowerCase()
    l.push(n)
		let balance = 0;
		rpg.shuffle(this.disadvantages);
		let disadvantages = this.disadvantages.slice(0,rpg.roll(1,5))
		l.push("Disadvantages"+': '+ disadvantages.join(", ").toLowerCase());
		for (let d of disadvantages) balance -= BADBALANCE.get(d);
		rpg.shuffle(this.advantages);
		let advantages = this.advantages.slice(0, rpg.roll(1,5));
		l.push("Advantages"+': '+ advantages.join(", ").toLowerCase());
		for (let a of advantages) balance += GOODBALANCE.get(a);
		let mental = this.describe(balance);
		if (mental != NORMAL) {
			l.push("Mental balance"+': '+ mental);
			if (balance < 0) l.push("Dark secret"+': '+ secret.roll(this.secrets, this.disadvantages));
		}
		rpg.shuffle(this.profession);
		l.push("Profession"+': '+ this.profession[0]);
		let wealth = 0;
		while (!(this.wealthmin <= wealth && wealth <= this.wealthmax))
			wealth = rpg.roll(1,10);
		l.push("Wealth"+': '+ WEALTH.lines[wealth - 1]);
		rpg.shuffle(this.skills);
		let skills = this.skills.slice(0, 1 + rpg.roll(1,3));
		l.push("Skills"+': '+ skills.join(", ").toLowerCase());
		return l.join('<br/>')
	}
}

class Secret extends table.Table {
	constructor() {
		super("Kult, character, dark secret", [CURSE, FAMILY, KNOWLEDGE, GUILTY, INSANITY, OCCULTEXPERIENCE, PACT,
				PESSESSED, HAUNTED, SUPERNATURALEXPERIENCE, VICTIM, SURVIVOR, GUARDIAN, UPROOTED, CHOSEN, INHERITOR])
	}

	 roll(secrets=false, disadvantages=false) {
     if(!secrets&&!disadvantages) return super.roll()
		let count = new Map();
		let high = 0;
		for (let s of secrets) {
			let hits = 0;
			for (let d of disadvantages) {
				let related = DISADVANTAGES.get(s);
				if (related != null && related.includes(d))
					hits += 1;
			}
			count.set(s, hits);
			if (hits > high)
				high = hits;
		}
		let finalhigh = high;
		let best = Array.from(count.keys()).filter(k => count.get(k) == finalhigh)
		return rpg.pick(best);
	}
}
var secret=new Secret()
tables.push(secret)

const UNEMPLOYED = "Unemployed";
const CRIMINAL = "Criminal";
const WORKER = "General worker";
const LANDLORD = "Landlord";
const PI = "Private investigator";
const JOURNALIST = "Journalist";
const ARTIST = "Artist";
const SECURITY = "Security consultant";
const SPECOPS = "Officer in military special forces";
const INTELLIGENCE = "Intelligence officer";
const BUSINESSMAN = "Business man";
const ECONOMIST = "Economist";
const ENGINEER = "Engineer";
const CONSULTANT = "Consultant";
const LAWYER = "Lawyer";
const STUDENT = "Student";
const SCIENTIST = "Scientist";
const BODYGUARD = "Bodyguard";
const DETECTIVE = "Police detective";
const WRITER = "Writer";
const MUSICIAN = "Musician";
const BOUNCER = "Bouncer";
const ROLLINGSTONE = "Constantly changing jobs";
const TECHNICIAN = "Technician";
const PROGRAMMER = "Programmer";
const HOUSEWIFE = "Housewife";
const RADICAL = "Member of a radical group";
const DIPLOMAT = "Diplomat";
const TRAINER = "Personal trainer";
const COACH = "Coach";
const ATHLETE = "Athlete";
const NURSE = "Nurse";
const PARENT = "Parent";
const GOVERNESS = "Governess";
const NANNY = "Nanny";
const SOCIAL = "Social worker";
const TV = "TV personality";
const MODEL = "Model";
const TEACHER = "Teacher";
const MONK = "Monk or nun";
const CLERGY = "Minister, priest, rabbi...";
const PSYCHIATRIST = "Psychiatrist";
const PHYSICIAN = "Physician";
const SECRETARY = "Secretary";
const GAMEDEV = "Game designer";
const BARTENDER = "Baretender";
const PROSTITUTE = "Prostitute";
const ODDJOBS = "Odd jobs";
const CURATOR = "Curator";
const LIBRARIAN = "Librarian";

class Profession extends table.Table {
	constructor() {
		super("Kult, character, profession",
				[UNEMPLOYED, CRIMINAL, WORKER, LANDLORD, PI, JOURNALIST, ARTIST, SECURITY, SPECOPS, INTELLIGENCE,
						BUSINESSMAN, ECONOMIST, ENGINEER, CONSULTANT, LAWYER, STUDENT, SCIENTIST, BODYGUARD, DETECTIVE,
						WRITER, MUSICIAN, BOUNCER, ROLLINGSTONE, TECHNICIAN, PROGRAMMER, HOUSEWIFE, RADICAL, DIPLOMAT,
						TRAINER, COACH, ATHLETE, NURSE, PARENT, GOVERNESS, NANNY, SOCIAL, TV, MODEL, TEACHER, MONK,
						CLERGY, PSYCHIATRIST, PHYSICIAN, SECRETARY, GAMEDEV, BARTENDER, PROSTITUTE, ODDJOBS, CURATOR,
						LIBRARIAN]);
	}
}
var profession=new Profession()
tables.push(profession)

const GANGMEMBER = new KultCharacter("Kult, character, archetype, gang member",
  [REPUTATION, DEATHWISH, ENEMY, REVENGE,
      FANATICISM, CONSTRICTION, INTOLERANCE, WANTED,
      TOUCHY, LIAR, MANIA, ADDICTION,
      EGOTIST],
  [ARTISTIC, HONOR, AWARENESS, FLEXIBILITY, SENSATE],
  [FAMILY, VICTIM, GUILTY],
  [UNEMPLOYED, CRIMINAL, WORKER], 2, 4,
  [DANCING, MELEE, POISONS, DRUGS, GRAFFITI, HIDE, IMMIGRANT,
      BURGLARY, CLIMB, IMPACT, DRIVE, HANDGUN, SNEAK, UNARMED,
      RHETORIC, WORDLY, ESTIMATE])
const AVENGER = new KultCharacter("Kult, character, archetype, avenger",
  [LUCK, REPUTATION, DEATHWISH, MAIMED,
      DEPRESSION, ADDICTION, FANATICISM, LIAR,
      MANIA, ENEMY, COMPULSION, PARANOIA,
      SCHIZOPHRENIA, NYMPHOMANIA, WANTED, REVENGE],
  [HONOR, SENSATE, ENDURANCE],
  [FAMILY, GUILTY, VICTIM], profession.lines, 3, 5,
  [AUTOMATIC, BURGLARY, CLIMB, MELEE, DEMOLITION, DISGUISE,
      DRIVE, DODGE, FALLING, INFORMATION, HANDGUN, HIDE, IMPACT,
      INTERROGATION, UNARMED, SEARCH, SHADOW, SNEAK])
const DEALER = new KultCharacter("Kult, character, archetype, dealer",
  [REPUTATION, DEATHWISH, ENEMY, REVENGE,
      GREED, TOUCHY, LIAR, ADDICTION,
      RATIONALIST, EGOTIST, GAMBLER],
  [EMPATHY, INFLUENCE, FLEXIBILITY, INTUITION,
      SENSATE, LUCK],
  [FAMILY, KNOWLEDGE, VICTIM, GUILTY],
  [CRIMINAL, CONSULTANT, BUSINESSMAN], 5, 7,
  [COMPUTERS, DIPLOMACY, MELEE, FRENCH, FORGERY, INFORMATION,
      ITALIAN, CONTACTS, DRIVE, SEARCH, HANDGUN, SNEAK,
      GAMBLING, UNARMED, GERMAN, RHETORIC, WORDLY, ESTIMATE])
const FEMMEFATALE = new KultCharacter("Kult, character, archetype, femme fatale",
  [DEPRESSION, REPUTATION, DEATHWISH, ENEMY,
      REVENGE, CONSTRICTION, GREED, TOUCHY,
      MANIA, ADDICTION, NYMPHOMANIA, LIAR,
      EGOTIST, GAMBLER],
  [ARTISTIC, ANIMALS, EMPATHY, INFLUENCE, INTUITION,
      AWARENESS, LANGUAGES],
  [FAMILY, KNOWLEDGE, VICTIM, GUILTY, INSANITY],
  [ARTIST, CRIMINAL, JOURNALIST, PI, LANDLORD],
  6, 8,
  [DANCING, DIPLOMACY, MELEE, ETIQUETTE, FRENCH, INTERROGATION,
      DISGUISE, POISONS, DRUGS, INFORMATION, CONTACTS, DRIVE,
      HANDGUN, ACTING, GAMBLING, UNARMED, RHETORIC, WORDLY,
      ESTIMATE])
const PIARCHETYPE = new KultCharacter("Kult, character, archetype, private investigator",
  [DEPRESSION, REPUTATION, DEATHWISH, ENEMY,
      REVENGE, CURSE, CONSTRICTION, PARANOIA,
      GREED, LIAR, ADDICTION, RATIONALIST,
      EGOTIST, GAMBLER],
  [CHIVALRY, EMPATHY, HONOR, INFLUENCE, FLEXIBILITY,
      SENSATE, LUCK, ENDURANCE],
  [FAMILY, KNOWLEDGE, VICTIM, GUILTY],
  [PI, SECURITY], 5, 7,
  [AUTOMATIC, FORENSICS, MELEE, ELECTRONICS, PHOTOGRAPHY,
      INTERROGATION, DISGUISE, HIDE, INFORMATION, DRIVE, HANDGUN,
      SHADOW, SNEAK, NIGHT, UNARMED, WORDLY])
const VETERAN = new KultCharacter("Kult, character, archetype, veteran",
  [DEPRESSION, DEATHWISH, PHOBIA, CONSTRICTION,
      PARANOIA, WANTED, TOUCHY, LIAR,
      ADDICTION, COMPULSION],
  [AWARENESS, PACIFISM, SENSATE, ENDURANCE],
  [FAMILY, VICTIM, GUILTY], [UNEMPLOYED, WORKER], 3,
  5,
  [AUTOMATIC, MELEE, DODGE, PARACHUTING, INTERROGATION, AID,
      HIDE, THROWING, CLIMB, DRIVE, MECHANICS, PILOTING,
      HANDGUN, RADIO, SWIM, SNEAK, DEMOLITION, UNARMED, HEAVY,
      SURVIVAL])
const AGENT = new KultCharacter("Kult, character, archetype, secret agent",
  [DEPRESSION, DEATHWISH, ENEMY, REVENGE,
      CONSTRICTION, PARANOIA, LIAR, NIGHTMARES,
      ADDICTION, RATIONALIST, GAMBLER],
  [CHIVALRY, HONOR, INFLUENCE, AWARENESS,
      FLEXIBILITY, SENSATE, LUCK, ENDURANCE],
  [KNOWLEDGE, VICTIM, GUILTY],
  [INTELLIGENCE, SPECOPS], 6, 8,
  [ARABIC, AUTOMATIC, BUGGING, FORENSICS, COMPUTERS, MELEE,
      DODGE, PARACHUTING, FALLING, FRENCH, FORGERY, INTERROGATION,
      DISGUISE, HIDE, BURGLARY, INFORMATION, THROWING, CLIMB,
      CONTACTS, INTELLIGENCESKILL, CRYPTOGRAPHY, DRIVE, SEARCH, PARRY,
      PILOTING, HANDGUN, RADIO, RIDING, RUSSIAN, SWIM,
      SEAMANSHIP, SHADOW, SNEAK, GAMBLING, DIVING, DEMOLITION,
      NIGHT, UNARMED, GERMAN, WORDLY])
const CORPORATE = new KultCharacter("Kult, character, archetype, corporate",
  [DEPRESSION, ENEMY, PHOBIA, CONSTRICTION,
      GREED, INTOLERANCE, LIAR, ADDICTION,
      RATIONALIST, EGOTIST, GAMBLER, COMPULSION],
  [REPUTATION, INFLUENCE, INTUITION, LANGUAGES,
      LUCK],
  [GUILTY, KNOWLEDGE, VICTIM],
  [BUSINESSMAN, CRIMINAL, ECONOMIST, ENGINEER,
      LAWYER, CONSULTANT],
  6, 8,
  [ACCOUNTING, COMPUTERS, DIPLOMACY, ECONOMICS, ETIQUETTE, FRENCH,
      FORGERY, INFORMATION, LAW, CONTACTS, HANDGUN, GERMAN,
      RHETORIC, ESTIMATE, WORDLY])
const STUDENTARCHETYPE = new KultCharacter("Kult, character, archetype, student",
  [DEPRESSION, CONSTRICTION, PARANOIA, LIAR,
      MANIA, ADDICTION, RATIONALIST],
  [FLEXIBILITY, MATH, LANGUAGES],
  [GUILTY, FAMILY, KNOWLEDGE, VICTIM], [STUDENT], 2, 4,
  [COMPUTERS, FRENCH, SEDUCTION, SPORT, INFORMATION, CONTACTS,
      WRITING, RHETORIC, WORDLY])
const SCIENTISTARCHETYPE = new KultCharacter("Kult, character, archetype, scientist",
  [REPUTATION, DEATHWISH, ENEMY, FANATICISM,
      CONSTRICTION, PARANOIA, INTOLERANCE, WANTED,
      TOUCHY, MANIA, ADDICTION, RATIONALIST,
      EGOTIST],
  [AWARENESS, INFLUENCE, INTUITION, MATH, LUCK],
  [GUILTY, KNOWLEDGE, VICTIM, INSANITY, SUPERNATURALEXPERIENCE],
  [SCIENTIST], 5, 7,
  [COMPUTERS, ELECTRONICS, POISONS, DRUGS, HUMANITIES, PSYCHOLOGY,
      INFORMATION, CHEMISTRY, CONTACTS, MEDICINE, SCIENCE])
const SAMURAI = new KultCharacter("Kult, character, archetype, city samurai",
  [REPUTATION, DEATHWISH, ENEMY, REVENGE,
      GREED, INTOLERANCE, WANTED, TOUCHY,
      LIAR, ADDICTION, EGOTIST],
  [HONOR, INFLUENCE, AWARENESS, SENSATE, ENDURANCE],
  [KNOWLEDGE, VICTIM, GUILTY],
  [CRIMINAL, BODYGUARD, SECURITY], 5, 7,
  [ACROBATICS, AUTOMATIC, MELEE, DODGE, FALLING, INTERROGATION,
      AID, RIFLE, HIDE, BURGLARY, THROWING, CLIMB, CONTACTS,
      IMPACT, DRIVE, SEARCH, WHIPS, CHAINS, HANDGUN, SWIM,
      SHADOW, MELEE, SNEAK, NIGHT, UNARMED, WORDLY])
const MUCKRAKER = new KultCharacter("Kult, character, archetype, muck-raker",
  [DEPRESSION, REPUTATION, ENEMY, REVENGE,
      FANATICISM, WANTED, TOUCHY, MANIA,
      ADDICTION, RATIONALIST, EGOTIST],
  [HONOR, INFLUENCE, INTUITION, FLEXIBILITY, SENSATE,
      LUCK, HONESTY],
  [KNOWLEDGE, VICTIM, GUILTY], [JOURNALIST], 5, 7,
  [FORENSICS, COMPUTERS, PHOTOGRAPHY, FORGERY, DISGUISE, BURGLARY,
      INFORMATION, HANDGUN, WRITING, SHADOW, SNEAK, RHETORIC,
      WORDLY])
const COP = new KultCharacter("Kult, character, archetype, cop",
  [DEATHWISH, ENEMY, REVENGE, FANATICISM,
      CONSTRICTION, INTOLERANCE, TOUCHY, NIGHTMARES,
      ADDICTION, RATIONALIST, COMPULSION],
  [CHIVALRY, HONOR, ALTRUIST, SENSATE, ENDURANCE],
  [FAMILY, VICTIM, GUILTY, INSANITY], [DETECTIVE], 4, 6,
  [AUTOMATIC, FORENSICS, INTERROGATION, DISGUISE, RIFLE, SPORT,
      BURGLARY, INFORMATION, DRIVE, HANDGUN, HUMANITIES, UNARMED,
      SHADOW, SNEAK])
const ARTISTARCHETYPE = new KultCharacter("Kult, character, archetype, artist",
  [DEPRESSION, FANATICISM, CURSE, CONSTRICTION,
      TOUCHY, MANIA, MANICDEPRESSIVE, NIGHTMARES,
      ADDICTION, SCHIZOPHRENIA, COMPULSION],
  [ARTISTIC, EMPATHY, AWARENESS, INTUITION,
      ENDURANCE],
  secret.lines, [ARTIST, WRITER, MUSICIAN], 3, 5,
  [ACTING, WRITING, CRAFT, DANCING, CONTACTS, ART,
      PHOTOGRAPHY, MUSIC, RHETORIC, WORDLY])
const ROCKER = new KultCharacter("Kult, character, archetype, rock musician",
  [DEPRESSION, REPUTATION, DEATHWISH, CURSE,
      TOUCHY, MANIA, NIGHTMARES, ADDICTION,
      NYMPHOMANIA, COMPULSION],
  [ARTISTIC, EMPATHY, AWARENESS, INFLUENCE, LUCK],
  [CURSE, KNOWLEDGE, VICTIM, PACT, INSANITY, GUILTY],
  [MUSICIAN], 6, 8, [ACROBATICS, DANCING, POETRY, POISONS,
      DRUGS, MUSIC, MARKETING, ACTING, GAMBLING, WORDLY])
const OUTSIDER = new KultCharacter("Kult, character, archetype, outsider",
  [DEPRESSION, REPUTATION, DEATHWISH, ENEMY,
      REVENGE, CURSE, PERSECUTED, CONSTRICTION,
      PARANOIA, WANTED, TOUCHY, ADDICTION,
      LUCK, SCHIZOPHRENIA, NYMPHOMANIA, EGOTIST,
      GAMBLER],
  [ARTISTIC, AWARENESS, FLEXIBILITY, SENSATE,
      ENDURANCE],
  [FAMILY, CURSE, KNOWLEDGE, VICTIM, GUILTY, INSANITY],
  [UNEMPLOYED, CRIMINAL, WORKER], 1, 3,
  [AUTOMATIC, MELEE, DODGE, FALLING, SEDUCTION, DISGUISE,
      RIFLE, POISONS, DRUGS, HIDE, BURGLARY, THROWING, CLIMB,
      CONTACTS, MECHANICS, WHIPS, CHAINS, HANDGUN, MUSIC,
      SHADOW, GAMBLING, SNEAK, NIGHT, MARKETING, WORDLY,
      SURVIVAL])
const ESCAPEE = new KultCharacter("Kult, character, archetype, asylum escapee",
  [ANXIETY, DEPRESSION, ADDICTION, HAUNTED,
      HAUNTED, SELFESTEEM, MANICDEPRESSIVE, MARTYR,
      COMPULSION, REVENGE, PARANOIA, SCHIZOPHRENIA,
      NYMPHOMANIA, DEPRESSION, TOUCHY, MEDIUM],
  [ALERTNESS, ARTISTIC, ENDURANCE, SENSATE],
  [GUILTY, INSANITY, SUPERNATURALEXPERIENCE, VICTIM],
  [UNEMPLOYED, ROLLINGSTONE], 2, 6,
  [HANDGUN, SNEAK, SWIM, HIDE, SEARCH, COMPUTERS,
      ELECTRONICS, POISONS, DRUGS, OCCULTISM, DISGUISE, ACTING,
      FORGERY, BURGLARY, DRIVE])
const HACKER = new KultCharacter("Kult, character, archetype, hacker",
  [DEPRESSION, PHOBIA, TOUCHY, NIGHTMARES,
      ADDICTION, LUCK, RATIONALIST, NEGLIGENT],
  [INFLUENCE, MATH, MECHANIC], [FAMILY, GUILTY],
  [PROGRAMMER, TECHNICIAN, CONSULTANT], 4, 8,
  [COMPUTERS, ELECTRONICS, ETIQUETTE, PHOTOGRAPHY, INFORMATION,
      CODE, DRIVE, SCIENCE, WRITING, LANGUAGES, SECURITYSKILL,
      HUMANITIES, CONTACTS])
const HOMEMAKER = new KultCharacter("Kult, character, archetype, homemaker",
  [HYGIENE, ADDICTION, FANATICISM, INTOLERANCE,
      MANICDEPRESSIVE, COMPULSION, CONSTRICTION,
      NIGHTMARES, PARANOIA, PHOBIA, RATIONALIST,
      NYMPHOMANIA, SPLIT, TOUCHY, MEDIUM],
  [ALTRUIST, HONOR, EMPATHY, FORGIVING, REPUTATION,
      HONESTY, MOTHERLINESS, SENSATE],
  [FAMILY, KNOWLEDGE, INSANITY, OCCULTEXPERIENCE, VICTIM],
  [HOUSEWIFE], 3, 5,
  [SEARCH, DANCING, CRAFT, SPORT, ACCOUNTING, AID, COOKING,
      MEDITATION, DIPLOMACY, ETIQUETTE, INTERROGATION, CONTACTS,
      ACTING, PHOTOGRAPHY, DRIVE, MECHANICS])
const PRODIGY = new KultCharacter("Kult, character, archetype, prodigy",
  [TOUCHY, INEPT], [MATH, MECHANIC],
  [FAMILY, VICTIM],
  [SCIENTIST, PROGRAMMER, TECHNICIAN, CONSULTANT], 4, 6,
  [COMPUTERS, ADMINISTRATION, WRITING, INSTRUCTION, ACCOUNTING,
      ELECTRONICS, INFORMATION, CRYPTOGRAPHY, LANGUAGES, ETIQUETTE,
      RHETORIC, SCIENCE, SOCIALSKILL])
const ACTIVIST = new KultCharacter("Kult, character, archetype, activist",
  [REPUTATION, BRASH, DOMINEERING, FANATICISM,
      MARTYR, COMPULSION],
  [ALTRUIST, HONOR, FLEXIBILITY, GOAL, EMPATHY],
  [KNOWLEDGE, GUILTY, SURVIVOR, VICTIM], [RADICAL], 3, 5,
  [BURGLARY, BUREAUCRACY, COMPUTERS, INFORMATION, LAW, WORDLY,
      CONTACTS, PHOTOGRAPHY, RHETORIC, WRITING, SOCIALSKILL, MEDICINE,
      TRIVIA])
const ARISTOCRAT = new KultCharacter("Kult, character, archetype, aristocrat",
  [CURSE, ADDICTION, EGOTIST, INTOLERANCE,
      REACTIONARY, DEPRESSION, TANTALIZING, VAIN],
  [CHIVALRY, HONOR, LANGUAGES, REPUTATION,
      INFLUENCE],
  [FAMILY, KNOWLEDGE, GUARDIAN, HAUNTED],
  [UNEMPLOYED, UNEMPLOYED, BUSINESSMAN, DIPLOMAT], 8, 10,
  [ADMINISTRATION, CAROUSING, DANCING, DIPLOMACY, DRIVE, ESTIMATE,
      ETIQUETTE, GAMBLING, HAUT, LANGUAGES, CONTACTS, SOCIALSKILL,
      STYLE])
const ATHLETEARCHETYPE = new KultCharacter("Kult, character, archetype, athlete",
  [REPUTATION, BRASH, ADDICTION, EGOTIST,
      GREED, COMPULSION, RIVAL, TANTALIZING,
      TOUCHY],
  [ALERTNESS, GOAL, ENDURANCE, INFLUENCE, LUCK,
      STATUS],
  [FAMILY, GUILTY, VICTIM],
  [ATHLETE, COACH, TRAINER], 8, 10,
  [ACROBATICS, CLIMB, DANCING, DODGE, DRIVE, GAMBLING,
      CONTACTS, SPORT, THROWING, UNARMED])
const CAREGIVER = new KultCharacter("Kult, character, archetype, caregiver",
  [CYNIC, DEBT, DEPENDENT, DEPRESSION,
      MARTYR, COMPULSION, PARANOIA],
  [ALTRUIST, EMPATHY, FAITH, FORGIVING, REPUTATION,
      LARGESSE, MOTHERLINESS],
  [GUILTY, SUPERNATURALEXPERIENCE, SURVIVOR, UPROOTED, VICTIM],
  [SOCIAL, NANNY, GOVERNESS, PARENT, NURSE], 3,
  7, [MEDICINE, BUREAUCRACY, WORDLY, PSYCHOLOGY, CONTACTS])
const CELEBRITY = new KultCharacter("Kult, character, archetype, celebrity",
  [REPUTATION, EGOTIST, GREED, MANICDEPRESSIVE,
      RIVAL, TANTALIZING, TOUCHY, VAIN],
  [ARTISTIC, REPUTATION, LUCK, STATUS],
  [CHOSEN, GUILTY, OCCULTEXPERIENCE, HAUNTED],
  [WRITER, MUSICIAN, MODEL, TV], 8, 10,
  [ACTING, CAROUSING, WRITING, DRIVE, HAUT, CONTACTS, MUSIC,
      RHETORIC, SEDUCTION, STYLE])
const CLERGYARCHETYPE = new KultCharacter("Kult, character, archetype, clergy",
  [DEPRESSION, ADDICTION, HAUNTED, MARTYR,
      COMPULSION, NYMPHOMANIA],
  [ALTRUIST, HONOR, EMPATHY, FORGIVING, INFLUENCE,
      INTUITION, MOTHERLINESS, PACIFISM],
  [CHOSEN, CURSE, KNOWLEDGE, GUARDIAN, OCCULTEXPERIENCE,
      PACT, SUPERNATURALEXPERIENCE],
  [CLERGY, MONK, SOCIAL, TEACHER], 2, 4,
  [PSYCHOLOGY, ETIQUETTE, INFORMATION, LANGUAGES, MEDITATION,
      SOCIALSKILL, CONTACTS, RHETORIC, WRITING])
const DOCTOR = new KultCharacter("Kult, character, archetype, doctor",
  [DEBT, EGOTIST, GREED, RATIONALIST,
      GAMBLER, NYMPHOMANIA],
  [REPUTATION, INFLUENCE], [GUILTY, SURVIVOR],
  [PHYSICIAN, SCIENTIST, PSYCHIATRIST], 7, 9,
  [MEDICINE, FORENSICS, COMPUTERS, WORDLY, CONTACTS, SCIENCE,
      POISONS, DRUGS])
const FUGITIVE = new KultCharacter("Kult, character, archetype, fugitive",
  [ANXIETY, LUCK, CURSE, CYNIC,
      DEPRESSION, PERSECUTED, BLAMED, MISTAKEN,
      ENEMY, PARANOIA, RIVAL],
  [ALERTNESS, ANIMALS, HONESTY, ENDURANCE, SENSATE],
  [CURSE, FAMILY, KNOWLEDGE, GUILTY, VICTIM],
  [WORKER], 1, 3, [SECURITYSKILL, WORDLY, CLIMB, DISGUISE,
      DODGE, HIDE, SNEAK, UNARMED, SURVIVAL])
const X = new KultCharacter("Kult, character, archetype, generation X",
  [CYNIC, ANXIETY, LUCK, BLACKSHEEP,
      DEBT, DEPRESSION, ADDICTION, SELFESTEEM,
      SCHIZOPHRENIA, TOUCHY],
  [ARTISTIC, FLEXIBILITY, EMPATHY, AWARENESS],
  [FAMILY, GUILTY, INSANITY, OCCULTEXPERIENCE, UPROOTED,
      VICTIM],
  profession.lines, 2, 4,
  [CAROUSING, WORDLY, COMPUTERS, DANCING, DRIVE, INFORMATION,
      ART, MUSIC, POISONS, DRUGS, SPORT, WRITING, SOCIALSKILL,
      SCIENCE])
const HUSTLER = new KultCharacter("Kult, character, archetype, hustler",
  [LUCK, CYNIC, DEPRESSION, ADDICTION,
      FORGOTTEN, SELFESTEEM, PERSECUTED],
  [ANIMALS, FLEXIBILITY, ENDURANCE],
  [GUILTY, INSANITY, OCCULTEXPERIENCE, SURVIVOR, VICTIM,
      UPROOTED],
  [UNEMPLOYED, PROSTITUTE, ODDJOBS, LANDLORD], 1, 3,
  [CAROUSING, WORDLY, SEDUCTION, HIDE, SEARCH, SNEAK,
      UNARMED, CONTACTS, SURVIVAL])
const MARTIAL = new KultCharacter("Kult, character, archetype, martial artist",
  [BRASH, DEATHWISH, EGOTIST, FANATICISM,
      COMPULSION, REVENGE, RIVAL, TOUCHY],
  [ALERTNESS, ANIMALS, HONOR, ENDURANCE, FAITH,
      WILL, MENTOR, INTUITION, OPTIMIST, SENSATE],
  [CHOSEN, KNOWLEDGE, GUARDIAN, GUILTY, UPROOTED],
  [COACH, MONK, WORKER], 2, 4,
  [MEDICINE, CLIMB, INSTRUCTION, THROWING, MELEE, UNARMED,
      MEDITATION, SOCIALSKILL, NIGHT, SPORT, MELEE])
const PARAPSYCHOLOGIST = new KultCharacter("Kult, character, archetype, parapsychologist",
  [LUCK, REPUTATION, BLACKSHEEP, HAUNTED,
      COMPULSION, TOUCHY, MEDIUM],
  [FLEXIBILITY, GOAL, AWARENESS, INTUITION, MATH,
      MENTOR, SENSATE],
  [OCCULTEXPERIENCE, INSANITY, GUILTY, SUPERNATURALEXPERIENCE],
  [PSYCHIATRIST, TEACHER], 4, 6,
  [MEDICINE, COMPUTERS, ELECTRONICS, PSYCHOLOGY, INFORMATION,
      LANGUAGES, MEDITATION, CONTACTS, OCCULTISM, PHOTOGRAPHY,
      RHETORIC, WRITING])
const SCHOLAR = new KultCharacter("Kult, character, archetype, scholar",
  [DEPRESSION, EGOTIST, FANATICISM, INTOLERANCE,
      RATIONALIST],
  [HONOR, FLEXIBILITY, LANGUAGES, MATH],
  [KNOWLEDGE, INHERITOR, OCCULTEXPERIENCE, GUILTY,
      SUPERNATURALEXPERIENCE, SURVIVOR],
  [SCIENTIST, TEACHER, CURATOR, LIBRARIAN], 4, 6,
  [CRYPTOGRAPHY, INFORMATION, INSTRUCTION, LANGUAGES, CONTACTS,
      RHETORIC, SOCIALSKILL, MEDICINE, SCIENCE, WRITING])

class Conjurer extends KultCharacter {
	constructor(title, disadvantages, advantages, secrets,
			profession, wealthmin, wealthmax, skills) {
		super(title, disadvantages, advantages, secrets, profession, wealthmin, wealthmax, skills);
		LORES.roll();
		this.skills.push(...LORES.lines);
	}
}

const OCCULTIST = new Conjurer("Kult, character, archetype, conjurer, burnt-out occultist",
    [REPUTATION, CURSE, PERSECUTED, CONSTRICTION,
        HAUNTED, WANTED, NIGHTMARES, ADDICTION,
        MEDIUM],
    [EMPATHY, AWARENESS, INTUITION, MAGICAL, MATH],
    [HAUNTED, CURSE, KNOWLEDGE, OCCULTEXPERIENCE, PACT,
        SUPERNATURALEXPERIENCE],
    [WORKER, WRITER, JOURNALIST, ARTIST,
        CONSULTANT, CLERGY],
    4, 4, [OCCULTISM, LANGUAGES, PSYCHOLOGY, CONTACTS, MEDITATION,
        WRITING, RHETORIC]);
const PAGAN = new Conjurer("Kult, character, archetype, conjurer, new-age pagan",
    [REPUTATION, FANATICISM, CURSE, HAUNTED,
        INTOLERANCE, NIGHTMARES, MEDIUM, PERSECUTED],
    [EMPATHY, AWARENESS, INTUITION, ANIMALS],
    [HAUNTED, CURSE, OCCULTEXPERIENCE, PACT, SUPERNATURALEXPERIENCE],
    [WORKER, NURSE, ARTIST, CONSULTANT,
        PSYCHIATRIST],
    6, 6, [OCCULTISM, COMPUTERS, POISONS, DRUGS, PSYCHOLOGY,
        CONTACTS, MEDITATION, WRITING, UNARMED, RHETORIC, WORDLY]);

const BLOODTHIRST = "Bloodthirst";
const SYMBOLBOUND = "Symbol bondage";
const TOMBBOUND = "Tomb bondage";
const HUNTER = "Hunting instinct";
const CANNIBAL = "Cannibalism";
const CONTROLLED = "Controlled by external power";
const FIRE = "Sensitive to fire";
const ELECTRICITY = "Sensitive to electricity";
const HOLYSYMBOL = "Scared of religious symbols";
const SILVER = "Sensitive to silver";
const IRON = "Sensitive to iron";
const COPPER = "Sensitive to copper";
const SUNLIGHT = "Sensitive to sunlight";
const SHAPECHANGE = "Uncontrolled shape change";
const INHUMAN = "Inhuman appearance";
const SOULTHIRST = "Soul thirst";
const STARS = "Controlled by stars";
const LIMITATIONS = new table.Table("Kult, character, child of the night, limitations",
    [BLOODTHIRST, SYMBOLBOUND, TOMBBOUND, HUNTER, CANNIBAL, CONTROLLED, FIRE, ELECTRICITY, HOLYSYMBOL,
        SILVER, IRON, COPPER, SUNLIGHT, SHAPECHANGE, INHUMAN, SOULTHIRST, STARS])
tables.push(LIMITATIONS)

const COMMANDING = "Commanding voice";
const ETERNAL = "Eternal youth";
const ABILITY = "Increased ability";
const POISON = "Resistant to poison";
const VISION = "Infrared vision";
const WEAPONS = "Natural weapons";
const FIREIMMUNE = "Invulnerable to fire";
const ELECTRICITYIMMUNE = "Invulnerable to electricity";
const RADIATION = "Invulnerable to radiation";
const WEAPONSIMMUNITY = "Invulnerable to weapons";
const FAST = "Fast reactions";
const REGENERATION = "Regeneration";
const SKIN = "Protective skin";
const SENSES = "Enhanced senses";
const TELEKINESIS = "Telekinesis";
const TELEPATHY = "Telepathy";
const ENDURANCEPOWER = "Infinite endurance";
const NOFOOD = "Never needs food or drink";
const POWERS = new table.Table("Kult, character, child of the night, powers",
    [COMMANDING, ETERNAL, ABILITY, POISON, VISION, WEAPONS, FIREIMMUNE, ELECTRICITYIMMUNE, RADIATION,
        WEAPONSIMMUNITY, FAST, REGENERATION, SKIN, SENSES, TELEKINESIS, TELEPATHY, ENDURANCEPOWER, NOFOOD])
tables.push(POWERS)

class NightChild extends KultCharacter {
	constructor(title, secrets, powers, limitations,
			disadvantages, advantages, profession, wealthmin, wealthmax,
			skills) {
		super(title, disadvantages, advantages, secrets, profession, wealthmin, wealthmax, skills);
		this.advantages.push(...powers);
		this.disadvantages.push(...limitations);
    this.archetype='Child of the night, '
	}

	describe(balance) {
		balance = Math.min(-25, balance);
		return super.describe(balance);
	}
}

export const GENERIC = new NightChild("Kult, character, child of the night, archetype, generic",
    secret.lines, POWERS.lines, LIMITATIONS.lines,
    [DEPRESSION, REPUTATION, DEATHWISH, ENEMY,
        REVENGE, CURSE, PERSECUTED, CONSTRICTION,
        PARANOIA, WANTED, TOUCHY, MANIA,
        NIGHTMARES, SCHIZOPHRENIA, MAIMED],
    [AWARENESS, INTUITION, SENSATE, ENDURANCEPOWER],
    [UNEMPLOYED, WORKER, STUDENT, BOUNCER], 1, 7,
    skill.lines);
const LORELEI = new NightChild("Kult, character, child of the night, archetype, lorelei",
    [GUILTY], [ABILITY, ETERNAL], [CONTROLLED, SOULTHIRST],
    [COMPULSION, ANIMAL, EGOTIST, NYMPHOMANIA,
        TANTALIZING, VAIN],
    [ENDURANCEPOWER, AWARENESS], profession.lines, 6, 10,
    [WORDLY, DANCING, ETIQUETTE, CONTACTS, STYLE])
const NEPHILIM = new NightChild("Kult, character, child of the night, archetype, nephilim",
    [CURSE, OCCULTEXPERIENCE, GUILTY, UPROOTED],
    [VISION, WEAPONS, WEAPONSIMMUNITY, SKIN, SENSES, ABILITY, FAST],
    [INHUMAN, IRON, SILVER, COPPER, ELECTRICITY],
    [PERSECUTED, CURSE, DEATHWISH, ADDICTION,
        SCHIZOPHRENIA, TOUCHY, WANTED],
    [AWARENESS, HONESTY, ENDURANCEPOWER, MENTOR, SENSATE],
    [UNEMPLOYED, CRIMINAL], 1, 1,
    [BURGLARY, WORDLY, DISGUISE, ETIQUETTE, CONTACTS, POISONS,
        DRUGS, SURVIVAL, SHADOW, SNEAK, UNARMED])
const REVENANT = new NightChild("Kult, character, child of the night, archetype, revenant",
    [CHOSEN, CURSE, INSANITY, VICTIM, UPROOTED],
    [ABILITY, SKIN, NOFOOD, REGENERATION],
    [CONTROLLED, FIRE, ELECTRICITY, HOLYSYMBOL, TOMBBOUND, INHUMAN],
    [CURSE, HAUNTED, COMPULSION, NIGHTMARES,
        REVENGE, TOUCHY],
    [ENDURANCEPOWER, INTUITION, SENSATE], [UNEMPLOYED], 1, 1,
    [WORDLY, SURVIVAL, SHADOW, SNEAK, UNARMED])
const SERAPHIM = new NightChild("Kult, character, child of the night, archetype, seraphim",
    [KNOWLEDGE, INSANITY, PACT], [WEAPONS, ETERNAL, FAST, ABILITY, VISION],
    [ELECTRICITY, IRON],
    [COMPULSION, TANTALIZING, AMNESIA, WANTED,
        EGOTIST, MANICDEPRESSIVE],
    [ENDURANCEPOWER, INTUITION, ANIMALS, HONOR, LUCK,
        SENSATE],
    [UNEMPLOYED], 1, 1, [MELEE, LANGUAGES, SEDUCTION,
        PSYCHOLOGY, INTERROGATION, CONTACTS])
const WOLVEN = new NightChild("Kult, character, child of the night, archetype, wolven",
    [INHERITOR, VICTIM, GUILTY, UPROOTED],
    [WEAPONSIMMUNITY, FAST, SENSES, POISON, WEAPONS, ABILITY, VISION],
    [SILVER, HUNTER, SHAPECHANGE, INHUMAN, STARS],
    [CURSE, SPLIT, TOUCHY, REPUTATION,
        CYNIC, DEPRESSION, WANTED],
    [ALERTNESS, ANIMALS, ENDURANCEPOWER, INTUITION],
    profession.lines, 1, 10, [CONTACTS, SNEAK, SURVIVAL, UNARMED])
const CHILDOFTHENIGHT = new table.Table("Kult, character, child of the night",
    [GENERIC, LORELEI, NEPHILIM, REVENANT, SERAPHIM, WOLVEN])
tables.push(...CHILDOFTHENIGHT.lines.concat([CHILDOFTHENIGHT]))

BADBALANCE.set(BLOODTHIRST, 10);
BADBALANCE.set(SYMBOLBOUND, 10);
BADBALANCE.set(TOMBBOUND, 10);
BADBALANCE.set(HUNTER, 5);
BADBALANCE.set(CANNIBAL, 20);
BADBALANCE.set(CONTROLLED, 20);
BADBALANCE.set(FIRE, 10);
BADBALANCE.set(ELECTRICITY, 10);
BADBALANCE.set(HOLYSYMBOL, 10);
BADBALANCE.set(SILVER, 5);
BADBALANCE.set(IRON, 5);
BADBALANCE.set(COPPER, 5);
BADBALANCE.set(SUNLIGHT, 20);
BADBALANCE.set(SHAPECHANGE, 10);
BADBALANCE.set(INHUMAN, 10);
BADBALANCE.set(SOULTHIRST, 20);
BADBALANCE.set(STARS, 10);
for (var p of POWERS.lines)
  GOODBALANCE.set(p, 0);

export const ARCHETYPE = new table.Table("Kult, character",
  [GANGMEMBER, AVENGER, DEALER, FEMMEFATALE, PIARCHETYPE, VETERAN, AGENT, CORPORATE, STUDENTARCHETYPE, SCIENTISTARCHETYPE,
      SAMURAI, MUCKRAKER, COP, ARTISTARCHETYPE, ROCKER, OUTSIDER, ESCAPEE, HACKER, HOMEMAKER, PRODIGY, ACTIVIST,
      ARISTOCRAT, ATHLETEARCHETYPE, CAREGIVER, CELEBRITY, CLERGYARCHETYPE, DOCTOR, FUGITIVE, X, HUSTLER, MARTIAL,
      PARAPSYCHOLOGIST, SCHOLAR, OCCULTIST, PAGAN])
ARCHETYPE.add(CHILDOFTHENIGHT,ARCHETYPE.lines.length/3)
tables.push(...ARCHETYPE.lines.concat([ARCHETYPE]))

class Effect extends table.Table {
	constructor() {
		super("Kult, effect");
		this.add("Bad");
		this.add("Acceptable",5);
		this.add("Normal",4);
		this.add("Good",10);
		this.add("very good",4);
		this.add("Exceptionally good",3);
		this.add("Impossibly good!");
	}
}
tables.push(new Effect())

const SHOCK = new table.Table("Kult, madness, reaction, shock",
  ["Screams", "Weeps", "Faints", "Runs away", "Shocked"])
const POSSESSION = new table.Table("Kult, madness, reaction, possession",
  ["Dead human spirit", "Purgatide (refugee from Hell)", "Etherace (non-physical creature)",
      "Razide (demon)", "Nepharite (demon)"])
const DREAM = new table.Table("Kult, madness, hallucination, waking dream, other")
DREAM.add("Objects change color and shape", 30 / 1);
DREAM.add("Lighting changes", 30 / 6);
DREAM.add("Transform an object up to 10 kilograms into another of double size and weight", 30 / 11);
DREAM.add("Transform an object up to 10 kilograms into another of half size and weight", 30 / 11);
DREAM.add("Time moves at half or double speed", 30 / 16);
DREAM.add("Compleetely change creature", 30 / 20);
DREAM.add("Compleetely change building", 30 / 20);
DREAM.add("Create an object of up to 10 kilograms or 1 cubic meter", 30 / 20);
DREAM.add("Move freely through time", 30 / 26);
DREAM.add("Act twice as fast", 30 / 26);
DREAM.add("Alter an entire landscape", 30 / 30);
DREAM.add("Add creature", 30 / 30);
DREAM.add("Add building", 30 / 30);
DREAM.add("Remove creature", 30 / 30);
DREAM.add("Remove building", 30 / 30);
const DREAMSELF = new table.Table("Kult, madness, hallucination, waking dream, self")
DREAMSELF.add("Minor cosmetic changes to self", 50 / 1);
DREAMSELF.add("Minimal increase to ability", 50 / 11);
DREAMSELF.add("Switch sex", 50 / 11);
DREAMSELF.add("Complete appearance change", 50 / 11);
DREAMSELF.add("Assume non-human form", 50 / 16);
DREAMSELF.add("Minor increase to ability", 50 / 16);
DREAMSELF.add("Major increase to ability", 50 / 20);
DREAMSELF.add("Minimal increase to all abilities", 50 / 30);
DREAMSELF.add("Shape-shift at will", 50 / 30);
DREAMSELF.add("Minor increase to all abilities", 50 / 40);
DREAMSELF.add("Major increase to all abilities", 50 / 50);
const DREAMPORTAL = new table.Table("Kult, madness, hallucination, waking dream, portal")
DREAMPORTAL.add("Summon one or more dreamers", 40 / 20);
DREAMPORTAL.add("Create a dream portal for yourself into " + setting.dream, 40 / 26);
DREAMPORTAL.add("Create a dream portal for anyone into " + setting.dream, 40 / 31);
DREAMPORTAL.add("Connect reality with " + setting.dream, 40 / 40);
const TOACHLYS = "Transported to " + setting.ACHLYS;
const TIME = new table.Table("Kult, madness, hallucination, time distortion")
TIME.add("Time moves at double speed", 40 / 5);
TIME.add("Time moves at half speed", 40 / 5);
TIME.add("Time jumps up to a month forward", 40 / 5);
TIME.add("Time jumps up to a month backward", 40 / 5);
TIME.add("Time jumps up to 3 months forward", 40 / 10);
TIME.add("Time jumps up to 3 months backward", 40 / 10);
TIME.add("Alter your perception of time at-will, up to twice as fast or slow", 40 / 15);
TIME.add("Jump forward or backward in time up to a month at-will", 40 / 15);
TIME.add("Time jumps up to 3 years forward", 40 / 15);
TIME.add("Time jumps up to 3 years backward", 40 / 15);
TIME.add("Time stops for up to a week", 40 / 15);
TIME.add("Time reversal", 40 / 15);
TIME.add("Time-jump up to 30 years forward or backward, at will", 40 / 30);
TIME.add("Time stops for up to a week, at will", 40 / 30);
TIME.add("Alter the passage of time at will", 40 / 40);
TIME.add("Time-jump to any point, at will", 40 / 30);
TIME.add("Stop time at will", 40 / 30);
TIME.add(TOACHLYS, 1);
const SPACE = new table.Table("Kult, madness, hallucination, space distortion")
SPACE.add("Teleport up to 2 kilometers", 40 / 5);
SPACE.add("Distances become 10x longer", 40 / 5);
SPACE.add("Distances become 10x shorter", 40 / 5);
SPACE.add("World becomes two-dimensional", 40 / 5);
SPACE.add("Teleport up to 50 kilometers", 40 / 10);
SPACE.add("Distances become 100x longer", 40 / 10);
SPACE.add("Distances become 100x shorter", 40 / 10);
SPACE.add("Teleport up to 2 kilometers, at will", 40 / 15);
SPACE.add("Increase or decrease distances by a favtor of 10, at will", 40 / 15);
SPACE.add("Teleport up to 1,000 kilometers", 40 / 15);
SPACE.add("Distances become 1,000x longer", 40 / 15);
SPACE.add("Distances become 1,000x shorter", 40 / 15);
SPACE.add("Teleport up to 50 kilometers, at will", 40 / 30);
SPACE.add("Increase or decrease distances by a favtor of 100, at will", 40 / 30);
SPACE.add("World becomes two- or four-dimensional, at will", 40 / 30);
SPACE.add("Teleport any distance, at will", 40 / 40);
SPACE.add("Increase or decrease distances by any amount, at will", 40 / 40);
SPACE.add(TOACHLYS, 1);
const HALLUCINATION = new table.Table("Kult, madness, hallucination")
HALLUCINATION.add(DREAM,500/9);
HALLUCINATION.add(DREAMSELF,500/9);
HALLUCINATION.add(DREAMPORTAL,500/9);
HALLUCINATION.add(TIME,500 / 6);
HALLUCINATION.add(SPACE,500 / 6);
HALLUCINATION.add("See through the illusion and into " + setting.portal, 500 / 3);
HALLUCINATION.add("Your Shadow haunts you", 500 / 100);
HALLUCINATION.add("Your Shadow confronts you", 500 / 300);
HALLUCINATION.add("Awakening (attain divinity)", 500 / 500);
tables.push(...[SHOCK,POSSESSION,DREAM,DREAMSELF,DREAMPORTAL,TIME,SPACE,HALLUCINATION])

// TODO 228-230 251
class Madness extends table.Table {
	constructor(balance='neutral') {
		super("Kult, madness (" + balance + " mental balance)");
	}

  roll() {
    this.lines=[]
		this.add("Project your inner terrors to reality");
		this.add(physicalchange);
		this.add(physicalchange.roll().toLowerCase() + " (temporary)");
		this.add(POSSESSION.roll().toLowerCase() + " possession");
		this.add(mentalchange);
		let p = HALLUCINATION.roll();
		this.add("Projected hallucination (affects all)" + p, 10 / 2);
		this.add("Hallucinate (affects you)<br/>" + p, 10 / 2);
		this.add("Hurt yourself");
		this.add("Hurt others");
		this.add("Lose control over flaws");
		this.add("Lose control over flaws (can be helped by others)");
		let s = SHOCK.roll().toLowerCase();
		this.add(s + " for one minute");
		this.add(s);
		this.add(s + " but can act with general penalty to actions");
		this.add("Hesitates for a turn");
		this.add("De-project (threat is destroyed or relocated)");
    return super.roll()
	}
}

const NEUTRAL = new Madness();
class Negative extends Madness{
  constructor(){
    super("negative")
  }

  roll() {
    super.roll()
    let l=this.lines
    return l[rpg.low(0,l.length-1)]
  }
};
class Positive extends Madness{
  constructor(){
    super("positive")
  }

  roll() {
    super.roll()
    let l=this.lines
    return l[rpg.high(0,l.length-1)]
  }
};

tables.push(...[NEUTRAL,new Negative(),new Positive()])

class MentalChange extends table.Table {
	constructor() {
		super("Kult, madness, reaction, mental change");
	}

  roll() {
		let change = "disadvantage";
		let t = disadvantage;
		if (rpg.roll(1,10) == 1) {
			change = "limitation";
			t = nightchild;
		}
		return `new ${change}, ${t.roll().toLowerCase()} (reroll if not relevant)`;
	}
}
class PhysicalChange extends table.Table {
	constructor() {
		super("Kult, madness, reaction, physical change",
				[new table.Table("Sex", ["Angrodynous", "Sex change"]),
						new table.Table("Size", ["Dwarf size", "Giant size"]),
						new table.Table("Extra body",
								["Extra arms", "Extra legs", "Extra eyes", "Extra mouths", "Extra genitalia",
										"Tentacles"]),
						new table.Table("Aquatic", ["Gills", "Fish scales", "Webbed hands and feet"]),
						new table.Table("Bestial", ["Claws", "Fangs"]),
						new table.Table("Mechanical",
								["Mechanical arms", "Mechanical legs", "Steel claws", "Steel teeth"]),
						new table.Table("Purgatoriees",
								["Hooks throught the body", "Needles throught the body", "No skin",
										"Constantly growing, itching skin scurf", "Worms in your flesh"]),
						new table.Table("Disease", ["Boils", "Rashes"])]);
		this.lines.push(...["Extreme hair growth", "Shape change", "Horns", "Hornlike skin", "Rotting flesh", "Tail","Wounds that won't heal", "Supernatural tattoos"])
	}
}

var physicalchange=new PhysicalChange()
var mentalchange=new MentalChange()

tables.push(...[physicalchange,mentalchange])
