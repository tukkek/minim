package minim.controller.table.kult.character;

import java.util.List;

import minim.controller.table.SimpleTable;

public class Skill extends SimpleTable {
	public static final Skill INSTANCE = new Skill();
	public static final String DAGGER = "Knives";
	public static final String POISONS = "Poisons";
	public static final String DRUGS = "Drugs";
	public static final String GRAFFITI = "Graffiti";
	public static final String HIDE = "Hide";
	public static final String HANDGUN = "Handgun";
	public static final String DRIVE = "Driving";
	public static final String IMPACT = "Impact weapons";
	public static final String CLIMB = "Climb";
	public static final String BURGLARY = "Burglary";
	public static final String IMMIGRANT = "Immigrant language";
	public static final String MARTIAL = "Martial arts";
	public static final String RHETORIC = "Rhetoric";
	public static final String WORDLY = "Steet-wise";
	public static final String ESTIMATE = "Estimate value";
	public static final String SNEAK = "Sneak";
	public static final String AUTOMATIC = "Automatic weapon";
	public static final String DEMOLITION = "Demolition";
	public static final String DISGUISE = "Disguise";
	public static final String INFORMATION = "Gather information";
	public static final String DODGE = "Dodge";
	public static final String INTERROGATION = "Interrogation";
	public static final String SEARCH = "Search";
	public static final String SHADOW = "Shadow";
	public static final String COMPUTERS = "Computers";
	public static final String DIPLOMACY = "Diplomacy";
	public static final String FRENCH = "French";
	public static final String FORGERY = "Forgery";
	public static final String CONTACTS = "contacts";
	public static final String ITALIAN = "Italian";
	public static final String GAMBLING = "Gambling";
	public static final String GERMAN = "German";
	public static final String ACTING = "Acting";
	public static final String ETIQUETTE = "Etiquette";
	public static final String NIGHT = "Assassination";
	public static final String FORENSICS = "Forensics";
	public static final String ELECTRONICS = "Electronics";
	public static final String PHOTOGRAPHY = "Photography";
	public static final String SURVIVAL = "Survival";
	public static final String RADIO = "Radio communications";
	public static final String SWIM = "Swimming";
	public static final String THROWING = "Throwing weapons";
	public static final String MECHANICS = "Motor mechanics";
	public static final String PILOTING = "Piloting";
	public static final String HEAVY = "Heavy weapons";
	public static final String AID = "First aid";
	public static final String PARACHUTING = "Parachuting";
	public static final String ARABIC = "Arabic";
	public static final String BUGGING = "Bugging";
	public static final String INTELLIGENCE = "Intelligence services";
	public static final String CRYPTOGRAPHY = "Cryptography";
	public static final String PARRY = "Parry";
	public static final String RUSSIAN = "Russian";
	public static final String RIDING = "Riding";
	public static final String SEAMANSHIP = "Seamanship";
	public static final String DIVING = "Scuba divin";
	public static final String ACCOUNTING = "Accounting";
	public static final String ECONOMICS = "Economics";
	public static final String LAW = "Law";
	public static final String WRITING = "Writing";
	public static final String SEDUCTION = "Seduction";
	public static final String DANCING = SEDUCTION;
	public static final String SPORT = "Sport";
	public static final String HUMANITIES = "Humanities";
	public static final String PSYCHOLOGY = "Psychology";
	public static final String SCIENCE = "Natural science";
	public static final String MEDICINE = "Medicine";
	public static final String CHEMISTRY = "Chemistry";
	public static final String ACROBATICS = "Acrobatics";
	public static final String FALLING = ACROBATICS;
	public static final String RIFLE = "Rifle";
	public static final String WHIPS = "Whips";
	public static final String CHAINS = "Chains";
	public static final String TWOHANDED = "Two-handed weapons";
	public static final String MUSIC = "Music";
	public static final String CRAFT = "Craft";
	public static final String ART = "Painting/drawing";
	public static final String POETRY = "Poetry";
	public static final String MARKETING = "Marketing";

	Skill() {
		super("Character (skills)",
				List.of(DAGGER, POISONS, DRUGS, GRAFFITI, HIDE, HANDGUN, DRIVE, IMPACT, CLIMB, BURGLARY, IMMIGRANT,
						MARTIAL, RHETORIC, WORDLY, ESTIMATE, SNEAK, AUTOMATIC, DEMOLITION, DISGUISE, INFORMATION,
						ACROBATICS, DODGE, INTERROGATION, SEARCH, SHADOW, COMPUTERS, DIPLOMACY, FRENCH, FORGERY,
						CONTACTS, ITALIAN, GAMBLING, GERMAN, ACTING, ETIQUETTE, NIGHT, FORENSICS, ELECTRONICS,
						PHOTOGRAPHY, SURVIVAL, RADIO, SWIM, THROWING, MECHANICS, PILOTING, HEAVY, AID, PARACHUTING,
						ARABIC, BUGGING, INTELLIGENCE, CRYPTOGRAPHY, PARRY, RUSSIAN, RIDING, SEAMANSHIP, DIVING,
						ACCOUNTING, ECONOMICS, LAW, WRITING, SEDUCTION, SPORT, HUMANITIES, PSYCHOLOGY, SCIENCE,
						MEDICINE, CHEMISTRY, RIFLE, WHIPS, CHAINS, TWOHANDED, MUSIC, CRAFT, ART, POETRY, MARKETING));
	}
}
