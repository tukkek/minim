package minim.controller.table.kult.character;

import java.util.List;

import minim.controller.table.SimpleTable;

public class Skill extends SimpleTable {
	public static final Skill INSTANCE = new Skill();
	public static final String MELEE = "Mêlée weapons";
	public static final String POISONS = "Poisons";
	public static final String DRUGS = "Drugs";
	public static final String GRAFFITI = "Graffiti";
	public static final String HIDE = "Hide";
	public static final String HANDGUN = "Handgun";
	public static final String DRIVE = "Driving";
	public static final String IMPACT = "Impact weapons";
	public static final String CLIMB = "Climb";
	public static final String IMMIGRANT = "Immigrant language";
	public static final String UNARMED = "Unarmed combat";
	public static final String RHETORIC = "Rhetoric";
	public static final String WORDLY = "Steetwise";
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
	public static final String FORGERY = "Forgery";
	public static final String CONTACTS = "Contacts";
	public static final String GAMBLING = "Gambling";
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
	public static final String BUGGING = "Bugging";
	public static final String INTELLIGENCE = "Intelligence services";
	public static final String CRYPTOGRAPHY = "Cryptography";
	public static final String PARRY = "Parry";
	public static final String RIDING = "Riding";
	public static final String SEAMANSHIP = "Seamanship";
	public static final String DIVING = "Scuba diving";
	public static final String ACCOUNTING = "Accounting";
	public static final String ECONOMICS = "Economics";
	public static final String LAW = "Law";
	public static final String WRITING = "Writing";
	public static final String SEDUCTION = "Seduction";
	public static final String DANCING = SEDUCTION;
	public static final String SPORT = "Sport";
	public static final String PSYCHOLOGY = "Psychology";
	public static final String SCIENCE = "Natural science";
	public static final String MEDICINE = "Medicine";
	public static final String CHEMISTRY = "Chemistry";
	public static final String ACROBATICS = "Acrobatics";
	public static final String FALLING = ACROBATICS;
	public static final String RIFLE = "Rifle";
	public static final String WHIPS = "Whips";
	public static final String CHAINS = "Chains";
	public static final String MUSIC = "Music";
	public static final String CRAFT = "Craft";
	public static final String ART = "Visual arts";
	public static final String POETRY = "Poetry";
	public static final String MARKETING = "Marketing";
	public static final String OCCULTISM = "Occultism";
	public static final String LANGUAGES = "Languages";
	public static final String FRENCH = LANGUAGES;
	public static final String ITALIAN = LANGUAGES;
	public static final String GERMAN = LANGUAGES;
	public static final String ARABIC = LANGUAGES;
	public static final String RUSSIAN = LANGUAGES;
	public static final String SECURITY = "Security";
	public static final String BURGLARY = SECURITY;
	public static final String SOCIAL = "Social sciences";
	public static final String HUMANITIES = SOCIAL;
	public static final String CODE = "Programming";
	public static final String MEDITATION = "Meditation";
	public static final String COOKING = "Cooking";
	public static final String ADMINISTRATION = "Administration";
	public static final String INSTRUCTION = "Instruction";
	public static final String BUREAUCRACY = "Bureaucracy";
	public static final String TRIVIA = "Trivia";
	public static final String CAROUSING = "Partying";
	public static final String STYLE = "Fashion";
	public static final String HAUT = "Fine tastes";

	Skill() {
		super("Character (skills)",
				List.of(MELEE, POISONS, DRUGS, GRAFFITI, HIDE, HANDGUN, DRIVE, IMPACT, CLIMB, SECURITY, IMMIGRANT,
						UNARMED, RHETORIC, WORDLY, ESTIMATE, SNEAK, AUTOMATIC, DEMOLITION, DISGUISE, INFORMATION,
						ACROBATICS, DODGE, INTERROGATION, SEARCH, SHADOW, COMPUTERS, DIPLOMACY, FORGERY, CONTACTS,
						GAMBLING, ACTING, ETIQUETTE, NIGHT, FORENSICS, ELECTRONICS, PHOTOGRAPHY, SURVIVAL, RADIO, SWIM,
						THROWING, MECHANICS, PILOTING, HEAVY, AID, PARACHUTING, BUGGING, INTELLIGENCE, CRYPTOGRAPHY,
						PARRY, RIDING, SEAMANSHIP, DIVING, ACCOUNTING, ECONOMICS, LAW, WRITING, SEDUCTION, SPORT,
						SOCIAL, PSYCHOLOGY, SCIENCE, MEDICINE, CHEMISTRY, RIFLE, WHIPS, CHAINS, MUSIC, CRAFT, ART,
						POETRY, MARKETING, OCCULTISM, LANGUAGES, CODE, MEDITATION, COOKING, ADMINISTRATION, INSTRUCTION,
						BUREAUCRACY, TRIVIA, CAROUSING, STYLE, HAUT));
	}
}
