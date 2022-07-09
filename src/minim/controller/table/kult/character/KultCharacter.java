package minim.controller.table.kult.character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

/**
 * Instead of having a free-form Archetype, I'm approaching this by not printing
 * the acrtual {@link #ARCHETYPE} name unless using that specific table. This
 * allows plenty of room for imagination on interpreting the results (except for
 * special cases such as sngle-{@link Profession} archetypes).
 * 
 * @author alex
 */
public class KultCharacter extends Table {
	public static final KultCharacter GANGMEMBER = new KultCharacter("Character (archetype, gang member)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.FANATICISM, Disadvantage.CONSTRICTION, Disadvantage.INTOLERANCE, Disadvantage.WANTED,
					Disadvantage.TOUCHY, Disadvantage.LIAR, Disadvantage.MANIA, Disadvantage.ADDICTION,
					Disadvantage.EGOTIST),
			List.of(Advantage.ARTISTIC, Advantage.HONOR, Advantage.AWARENESS, Advantage.FLEXIBILITY, Advantage.SENSATE),
			List.of(Secret.FAMILY, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.UNEMPLOYED, Profession.CRIMINAL, Profession.WORKER), 2, 4,
			List.of(Skill.DANCING, Skill.MELEE, Skill.POISONS, Skill.DRUGS, Skill.GRAFFITI, Skill.HIDE, Skill.IMMIGRANT,
					Skill.BURGLARY, Skill.CLIMB, Skill.IMPACT, Skill.DRIVE, Skill.HANDGUN, Skill.SNEAK, Skill.UNARMED,
					Skill.RHETORIC, Skill.WORDLY, Skill.ESTIMATE));
	public static final KultCharacter AVENGER = new KultCharacter("Character (archetype, avenger)",
			List.of(Disadvantage.LUCK, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.MAIMED,
					Disadvantage.DEPRESSION, Disadvantage.ADDICTION, Disadvantage.FANATICISM, Disadvantage.LIAR,
					Disadvantage.MANIA, Disadvantage.ENEMY, Disadvantage.COMPULSION, Disadvantage.PARANOIA,
					Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA, Disadvantage.WANTED, Disadvantage.REVENGE),
			List.of(Advantage.HONOR, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.GUILTY, Secret.VICTIM), Profession.INSTANCE.lines, 3, 5,
			List.of(Skill.AUTOMATIC, Skill.BURGLARY, Skill.CLIMB, Skill.MELEE, Skill.DEMOLITION, Skill.DISGUISE,
					Skill.DRIVE, Skill.DODGE, Skill.FALLING, Skill.INFORMATION, Skill.HANDGUN, Skill.HIDE, Skill.IMPACT,
					Skill.INTERROGATION, Skill.UNARMED, Skill.SEARCH, Skill.SHADOW, Skill.SNEAK));
	public static final KultCharacter DEALER = new KultCharacter("Character (archetype, dealer)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.GREED, Disadvantage.TOUCHY, Disadvantage.LIAR, Disadvantage.ADDICTION,
					Disadvantage.RATIONALIST, Disadvantage.EGOTIST, Disadvantage.GAMBLER),
			List.of(Advantage.EMPATHY, Advantage.INFLUENCE, Advantage.FLEXIBILITY, Advantage.INTUITION,
					Advantage.SENSATE, Advantage.LUCK),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.CRIMINAL, Profession.CONSULTANT, Profession.BUSINESSMAN), 5, 7,
			List.of(Skill.COMPUTERS, Skill.DIPLOMACY, Skill.MELEE, Skill.FRENCH, Skill.FORGERY, Skill.INFORMATION,
					Skill.ITALIAN, Skill.CONTACTS, Skill.DRIVE, Skill.SEARCH, Skill.HANDGUN, Skill.SNEAK,
					Skill.GAMBLING, Skill.UNARMED, Skill.GERMAN, Skill.RHETORIC, Skill.WORDLY, Skill.ESTIMATE));
	public static final KultCharacter FEMMEFATALE = new KultCharacter("Character (archetype, femme fatale)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CONSTRICTION, Disadvantage.GREED, Disadvantage.TOUCHY,
					Disadvantage.MANIA, Disadvantage.ADDICTION, Disadvantage.NYMPHOMANIA, Disadvantage.LIAR,
					Disadvantage.EGOTIST, Disadvantage.GAMBLER),
			List.of(Advantage.ARTISTIC, Advantage.ANIMALS, Advantage.EMPATHY, Advantage.INFLUENCE, Advantage.INTUITION,
					Advantage.AWARENESS, Advantage.LANGUAGES),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY, Secret.INSANITY),
			List.of(Profession.ARTIST, Profession.CRIMINAL, Profession.JOURNALIST, Profession.PI, Profession.LANDLORD),
			6, 8,
			List.of(Skill.DANCING, Skill.DIPLOMACY, Skill.MELEE, Skill.ETIQUETTE, Skill.FRENCH, Skill.INTERROGATION,
					Skill.DISGUISE, Skill.POISONS, Skill.DRUGS, Skill.INFORMATION, Skill.CONTACTS, Skill.DRIVE,
					Skill.HANDGUN, Skill.ACTING, Skill.GAMBLING, Skill.UNARMED, Skill.RHETORIC, Skill.WORDLY,
					Skill.ESTIMATE));
	public static final KultCharacter PI = new KultCharacter("Character (archetype, private investigator)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CURSE, Disadvantage.CONSTRICTION, Disadvantage.PARANOIA,
					Disadvantage.GREED, Disadvantage.LIAR, Disadvantage.ADDICTION, Disadvantage.RATIONALIST,
					Disadvantage.EGOTIST, Disadvantage.GAMBLER),
			List.of(Advantage.CHIVALRY, Advantage.EMPATHY, Advantage.HONOR, Advantage.INFLUENCE, Advantage.FLEXIBILITY,
					Advantage.SENSATE, Advantage.LUCK, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.PI, Profession.SECURITY), 5, 7,
			List.of(Skill.AUTOMATIC, Skill.FORENSICS, Skill.MELEE, Skill.ELECTRONICS, Skill.PHOTOGRAPHY,
					Skill.INTERROGATION, Skill.DISGUISE, Skill.HIDE, Skill.INFORMATION, Skill.DRIVE, Skill.HANDGUN,
					Skill.SHADOW, Skill.SNEAK, Skill.NIGHT, Skill.UNARMED, Skill.WORDLY));
	public static final KultCharacter VETERAN = new KultCharacter("Character (archetype, veteran)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION,
					Disadvantage.PARANOIA, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.LIAR,
					Disadvantage.ADDICTION, Disadvantage.COMPULSION),
			List.of(Advantage.AWARENESS, Advantage.PACIFISM, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.VICTIM, Secret.GUILTY), List.of(Profession.UNEMPLOYED, Profession.WORKER), 3,
			5,
			List.of(Skill.AUTOMATIC, Skill.MELEE, Skill.DODGE, Skill.PARACHUTING, Skill.INTERROGATION, Skill.AID,
					Skill.HIDE, Skill.THROWING, Skill.CLIMB, Skill.DRIVE, Skill.MECHANICS, Skill.PILOTING,
					Skill.HANDGUN, Skill.RADIO, Skill.SWIM, Skill.SNEAK, Skill.DEMOLITION, Skill.UNARMED, Skill.HEAVY,
					Skill.SURVIVAL));
	public static final KultCharacter AGENT = new KultCharacter("Character (archetype, secret agent)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.LIAR, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.RATIONALIST, Disadvantage.GAMBLER),
			List.of(Advantage.CHIVALRY, Advantage.HONOR, Advantage.INFLUENCE, Advantage.AWARENESS,
					Advantage.FLEXIBILITY, Advantage.SENSATE, Advantage.LUCK, Advantage.ENDURANCE),
			List.of(Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.INTELLIGENCE, Profession.SPECOPS), 6, 8,
			List.of(Skill.ARABIC, Skill.AUTOMATIC, Skill.BUGGING, Skill.FORENSICS, Skill.COMPUTERS, Skill.MELEE,
					Skill.DODGE, Skill.PARACHUTING, Skill.FALLING, Skill.FRENCH, Skill.FORGERY, Skill.INTERROGATION,
					Skill.DISGUISE, Skill.HIDE, Skill.BURGLARY, Skill.INFORMATION, Skill.THROWING, Skill.CLIMB,
					Skill.CONTACTS, Skill.INTELLIGENCE, Skill.CRYPTOGRAPHY, Skill.DRIVE, Skill.SEARCH, Skill.PARRY,
					Skill.PILOTING, Skill.HANDGUN, Skill.RADIO, Skill.RIDING, Skill.RUSSIAN, Skill.SWIM,
					Skill.SEAMANSHIP, Skill.SHADOW, Skill.SNEAK, Skill.GAMBLING, Skill.DIVING, Skill.DEMOLITION,
					Skill.NIGHT, Skill.UNARMED, Skill.GERMAN, Skill.WORDLY));
	public static final KultCharacter CORPORATE = new KultCharacter("Character (archetype, corporate)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.ENEMY, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION,
					Disadvantage.GREED, Disadvantage.INTOLERANCE, Disadvantage.LIAR, Disadvantage.ADDICTION,
					Disadvantage.RATIONALIST, Disadvantage.EGOTIST, Disadvantage.GAMBLER, Disadvantage.COMPULSION),
			List.of(Advantage.REPUTATION, Advantage.INFLUENCE, Advantage.INTUITION, Advantage.LANGUAGES,
					Advantage.LUCK),
			List.of(Secret.GUILTY, Secret.KNOWLEDGE, Secret.VICTIM),
			List.of(Profession.BUSINESSMAN, Profession.CRIMINAL, Profession.ECONOMIST, Profession.ENGINEER,
					Profession.LAWYER, Profession.CONSULTANT),
			6, 8,
			List.of(Skill.ACCOUNTING, Skill.COMPUTERS, Skill.DIPLOMACY, Skill.ECONOMICS, Skill.ETIQUETTE, Skill.FRENCH,
					Skill.FORGERY, Skill.INFORMATION, Skill.LAW, Skill.CONTACTS, Skill.HANDGUN, Skill.GERMAN,
					Skill.RHETORIC, Skill.ESTIMATE, Skill.WORDLY));
	public static final KultCharacter STUDENT = new KultCharacter("Character (archetype, student)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.LIAR,
					Disadvantage.MANIA, Disadvantage.ADDICTION, Disadvantage.RATIONALIST),
			List.of(Advantage.FLEXIBILITY, Advantage.MATH, Advantage.LANGUAGES),
			List.of(Secret.GUILTY, Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM), List.of(Profession.STUDENT), 2, 4,
			List.of(Skill.COMPUTERS, Skill.FRENCH, Skill.SEDUCTION, Skill.SPORT, Skill.INFORMATION, Skill.CONTACTS,
					Skill.WRITING, Skill.RHETORIC, Skill.WORDLY));
	public static final KultCharacter SCIENTIST = new KultCharacter("Character (archetype, scientist)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.FANATICISM,
					Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.INTOLERANCE, Disadvantage.WANTED,
					Disadvantage.TOUCHY, Disadvantage.MANIA, Disadvantage.ADDICTION, Disadvantage.RATIONALIST,
					Disadvantage.EGOTIST),
			List.of(Advantage.AWARENESS, Advantage.INFLUENCE, Advantage.INTUITION, Advantage.MATH, Advantage.LUCK),
			List.of(Secret.GUILTY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.INSANITY, Secret.SUPERNATURALEXPERIENCE),
			List.of(Profession.SCIENTIST), 5, 7,
			List.of(Skill.COMPUTERS, Skill.ELECTRONICS, Skill.POISONS, Skill.DRUGS, Skill.HUMANITIES, Skill.PSYCHOLOGY,
					Skill.INFORMATION, Skill.CHEMISTRY, Skill.CONTACTS, Skill.MEDICINE, Skill.SCIENCE));
	public static final KultCharacter SAMURAI = new KultCharacter("Character (archetype, city samurai)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.GREED, Disadvantage.INTOLERANCE, Disadvantage.WANTED, Disadvantage.TOUCHY,
					Disadvantage.LIAR, Disadvantage.ADDICTION, Disadvantage.EGOTIST),
			List.of(Advantage.HONOR, Advantage.INFLUENCE, Advantage.AWARENESS, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.CRIMINAL, Profession.BODYGUARD, Profession.SECURITY), 5, 7,
			List.of(Skill.ACROBATICS, Skill.AUTOMATIC, Skill.MELEE, Skill.DODGE, Skill.FALLING, Skill.INTERROGATION,
					Skill.AID, Skill.RIFLE, Skill.HIDE, Skill.BURGLARY, Skill.THROWING, Skill.CLIMB, Skill.CONTACTS,
					Skill.IMPACT, Skill.DRIVE, Skill.SEARCH, Skill.WHIPS, Skill.CHAINS, Skill.HANDGUN, Skill.SWIM,
					Skill.SHADOW, Skill.MELEE, Skill.SNEAK, Skill.NIGHT, Skill.UNARMED, Skill.WORDLY));
	public static final KultCharacter MUCKRAKER = new KultCharacter("Character (archetype, muck-raker)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.FANATICISM, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.MANIA,
					Disadvantage.ADDICTION, Disadvantage.RATIONALIST, Disadvantage.EGOTIST),
			List.of(Advantage.HONOR, Advantage.INFLUENCE, Advantage.INTUITION, Advantage.FLEXIBILITY, Advantage.SENSATE,
					Advantage.LUCK, Advantage.HONESTY),
			List.of(Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY), List.of(Profession.JOURNALIST), 5, 7,
			List.of(Skill.FORENSICS, Skill.COMPUTERS, Skill.PHOTOGRAPHY, Skill.FORGERY, Skill.DISGUISE, Skill.BURGLARY,
					Skill.INFORMATION, Skill.HANDGUN, Skill.WRITING, Skill.SHADOW, Skill.SNEAK, Skill.RHETORIC,
					Skill.WORDLY));
	public static final KultCharacter COP = new KultCharacter("Character (archetype, cop)",
			List.of(Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE, Disadvantage.FANATICISM,
					Disadvantage.CONSTRICTION, Disadvantage.INTOLERANCE, Disadvantage.TOUCHY, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.RATIONALIST, Disadvantage.COMPULSION),
			List.of(Advantage.CHIVALRY, Advantage.HONOR, Advantage.ALTRUIST, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.VICTIM, Secret.GUILTY, Secret.INSANITY), List.of(Profession.DETECTIVE), 4, 6,
			List.of(Skill.AUTOMATIC, Skill.FORENSICS, Skill.INTERROGATION, Skill.DISGUISE, Skill.RIFLE, Skill.SPORT,
					Skill.BURGLARY, Skill.INFORMATION, Skill.DRIVE, Skill.HANDGUN, Skill.HUMANITIES, Skill.UNARMED,
					Skill.SHADOW, Skill.SNEAK));
	public static final KultCharacter ARTIST = new KultCharacter("Character (archetype, artist)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.FANATICISM, Disadvantage.CURSE, Disadvantage.CONSTRICTION,
					Disadvantage.TOUCHY, Disadvantage.MANIA, Disadvantage.MANICDEPRESSIVE, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.SCHIZOPHRENIA, Disadvantage.COMPULSION),
			List.of(Advantage.ARTISTIC, Advantage.EMPATHY, Advantage.AWARENESS, Advantage.INTUITION,
					Advantage.ENDURANCE),
			Secret.INSTANCE.lines, List.of(Profession.ARTIST, Profession.WRITER, Profession.MUSICIAN), 3, 5,
			List.of(Skill.ACTING, Skill.WRITING, Skill.CRAFT, Skill.DANCING, Skill.CONTACTS, Skill.ART,
					Skill.PHOTOGRAPHY, Skill.MUSIC, Skill.RHETORIC, Skill.WORDLY));
	public static final KultCharacter ROCKER = new KultCharacter("Character (archetype, rock musician)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.CURSE,
					Disadvantage.TOUCHY, Disadvantage.MANIA, Disadvantage.NIGHTMARES, Disadvantage.ADDICTION,
					Disadvantage.NYMPHOMANIA, Disadvantage.COMPULSION),
			List.of(Advantage.ARTISTIC, Advantage.EMPATHY, Advantage.AWARENESS, Advantage.INFLUENCE, Advantage.LUCK),
			List.of(Secret.CURSE, Secret.KNOWLEDGE, Secret.VICTIM, Secret.PACT, Secret.INSANITY, Secret.GUILTY),
			List.of(Profession.MUSICIAN), 6, 8, List.of(Skill.ACROBATICS, Skill.DANCING, Skill.POETRY, Skill.POISONS,
					Skill.DRUGS, Skill.MUSIC, Skill.MARKETING, Skill.ACTING, Skill.GAMBLING, Skill.WORDLY));
	public static final KultCharacter OUTSIDER = new KultCharacter("Character (archetype, outsider)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CURSE, Disadvantage.PERSECUTED, Disadvantage.CONSTRICTION,
					Disadvantage.PARANOIA, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.ADDICTION,
					Disadvantage.LUCK, Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA, Disadvantage.EGOTIST,
					Disadvantage.GAMBLER),
			List.of(Advantage.ARTISTIC, Advantage.AWARENESS, Advantage.FLEXIBILITY, Advantage.SENSATE,
					Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.CURSE, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY, Secret.INSANITY),
			List.of(Profession.UNEMPLOYED, Profession.CRIMINAL, Profession.WORKER), 1, 3,
			List.of(Skill.AUTOMATIC, Skill.MELEE, Skill.DODGE, Skill.FALLING, Skill.SEDUCTION, Skill.DISGUISE,
					Skill.RIFLE, Skill.POISONS, Skill.DRUGS, Skill.HIDE, Skill.BURGLARY, Skill.THROWING, Skill.CLIMB,
					Skill.CONTACTS, Skill.MECHANICS, Skill.WHIPS, Skill.CHAINS, Skill.HANDGUN, Skill.MUSIC,
					Skill.SHADOW, Skill.GAMBLING, Skill.SNEAK, Skill.NIGHT, Skill.MARKETING, Skill.WORDLY,
					Skill.SURVIVAL));
	public static final KultCharacter ESCAPEE = new KultCharacter("Character (archetype, asylum escapee)",
			List.of(Disadvantage.ANXIETY, Disadvantage.DEPRESSION, Disadvantage.ADDICTION, Disadvantage.HAUNTED,
					Disadvantage.HAUNTED, Disadvantage.SELFESTEEM, Disadvantage.MANICDEPRESSIVE, Disadvantage.MARTYR,
					Disadvantage.COMPULSION, Disadvantage.REVENGE, Disadvantage.PARANOIA, Disadvantage.SCHIZOPHRENIA,
					Disadvantage.NYMPHOMANIA, Disadvantage.DEPRESSION, Disadvantage.TOUCHY, Disadvantage.MEDIUM),
			List.of(Advantage.ALERTNESS, Advantage.ARTISTIC, Advantage.ENDURANCE, Advantage.SENSATE),
			List.of(Secret.GUILTY, Secret.INSANITY, Secret.SUPERNATURALEXPERIENCE, Secret.VICTIM),
			List.of(Profession.UNEMPLOYED, Profession.ROLLINGSTONE), 2, 6,
			List.of(Skill.HANDGUN, Skill.SNEAK, Skill.SWIM, Skill.HIDE, Skill.SEARCH, Skill.COMPUTERS,
					Skill.ELECTRONICS, Skill.POISONS, Skill.DRUGS, Skill.OCCULTISM, Skill.DISGUISE, Skill.ACTING,
					Skill.FORGERY, Skill.BURGLARY, Skill.DRIVE));
	public static final KultCharacter HACKER = new KultCharacter("Character (archetype, hacker)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.PHOBIA, Disadvantage.TOUCHY, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.LUCK, Disadvantage.RATIONALIST, Disadvantage.NEGLIGENT),
			List.of(Advantage.INFLUENCE, Advantage.MATH, Advantage.MECHANIC), List.of(Secret.FAMILY, Secret.GUILTY),
			List.of(Profession.PROGRAMMER, Profession.TECHNICIAN, Profession.CONSULTANT), 4, 8,
			List.of(Skill.COMPUTERS, Skill.ELECTRONICS, Skill.ETIQUETTE, Skill.PHOTOGRAPHY, Skill.INFORMATION,
					Skill.CODE, Skill.DRIVE, Skill.SCIENCE, Skill.WRITING, Skill.LANGUAGES, Skill.SECURITY,
					Skill.HUMANITIES, Skill.CONTACTS));
	public static final KultCharacter HOMEMAKER = new KultCharacter("Character (archetype, homemaker)",
			List.of(Disadvantage.HYGIENE, Disadvantage.ADDICTION, Disadvantage.FANATICISM, Disadvantage.INTOLERANCE,
					Disadvantage.MANICDEPRESSIVE, Disadvantage.COMPULSION, Disadvantage.CONSTRICTION,
					Disadvantage.NIGHTMARES, Disadvantage.PARANOIA, Disadvantage.PHOBIA, Disadvantage.RATIONALIST,
					Disadvantage.NYMPHOMANIA, Disadvantage.SPLIT, Disadvantage.TOUCHY, Disadvantage.MEDIUM),
			List.of(Advantage.ALTRUIST, Advantage.HONOR, Advantage.EMPATHY, Advantage.FORGIVING, Advantage.REPUTATION,
					Advantage.HONESTY, Advantage.MOTHERLINESS, Advantage.SENSATE),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.INSANITY, Secret.OCCULTEXPERIENCE, Secret.VICTIM),
			List.of(Profession.HOUSEWIFE), 3, 5,
			List.of(Skill.SEARCH, Skill.DANCING, Skill.CRAFT, Skill.SPORT, Skill.ACCOUNTING, Skill.AID, Skill.COOKING,
					Skill.MEDITATION, Skill.DIPLOMACY, Skill.ETIQUETTE, Skill.INTERROGATION, Skill.CONTACTS,
					Skill.ACTING, Skill.PHOTOGRAPHY, Skill.DRIVE, Skill.MECHANICS));
	public static final KultCharacter PRODIGY = new KultCharacter("Character (archetype, prodigy)",
			List.of(Disadvantage.TOUCHY, Disadvantage.INEPT), List.of(Advantage.MATH, Advantage.MECHANIC),
			List.of(Secret.FAMILY, Secret.VICTIM),
			List.of(Profession.SCIENTIST, Profession.PROGRAMMER, Profession.TECHNICIAN, Profession.CONSULTANT), 4, 6,
			List.of(Skill.COMPUTERS, Skill.ADMINISTRATION, Skill.WRITING, Skill.INSTRUCTION, Skill.ACCOUNTING,
					Skill.ELECTRONICS, Skill.INFORMATION, Skill.CRYPTOGRAPHY, Skill.LANGUAGES, Skill.ETIQUETTE,
					Skill.RHETORIC, Skill.SCIENCE, Skill.SOCIAL));
	public static final KultCharacter ACTIVIST = new KultCharacter("Character (archetype, activist)",
			List.of(Disadvantage.REPUTATION, Disadvantage.BRASH, Disadvantage.DOMINEERING, Disadvantage.FANATICISM,
					Disadvantage.MARTYR, Disadvantage.COMPULSION),
			List.of(Advantage.ALTRUIST, Advantage.HONOR, Advantage.FLEXIBILITY, Advantage.GOAL, Advantage.EMPATHY),
			List.of(Secret.KNOWLEDGE, Secret.GUILTY, Secret.SURVIVOR, Secret.VICTIM), List.of(Profession.RADICAL), 3, 5,
			List.of(Skill.BURGLARY, Skill.BUREAUCRACY, Skill.COMPUTERS, Skill.INFORMATION, Skill.LAW, Skill.WORDLY,
					Skill.CONTACTS, Skill.PHOTOGRAPHY, Skill.RHETORIC, Skill.WRITING, Skill.SOCIAL, Skill.MEDICINE,
					Skill.TRIVIA));
	public static final KultCharacter ARISTOCRAT = new KultCharacter("Character (archetype, aristocrat)",
			List.of(Disadvantage.CURSE, Disadvantage.ADDICTION, Disadvantage.EGOTIST, Disadvantage.INTOLERANCE,
					Disadvantage.REACTIONARY, Disadvantage.DEPRESSION, Disadvantage.TANTALIZING, Disadvantage.VAIN),
			List.of(Advantage.CHIVALRY, Advantage.HONOR, Advantage.LANGUAGES, Advantage.REPUTATION,
					Advantage.INFLUENCE),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.GUARDIAN, Secret.HAUNTED),
			List.of(Profession.UNEMPLOYED, Profession.UNEMPLOYED, Profession.BUSINESSMAN, Profession.DIPLOMAT), 8, 10,
			List.of(Skill.ADMINISTRATION, Skill.CAROUSING, Skill.DANCING, Skill.DIPLOMACY, Skill.DRIVE, Skill.ESTIMATE,
					Skill.ETIQUETTE, Skill.GAMBLING, Skill.HAUT, Skill.LANGUAGES, Skill.CONTACTS, Skill.SOCIAL,
					Skill.STYLE));
	public static final KultCharacter ATHLETE = new KultCharacter("Character (archetype, athlete)",
			List.of(Disadvantage.REPUTATION, Disadvantage.BRASH, Disadvantage.ADDICTION, Disadvantage.EGOTIST,
					Disadvantage.GREED, Disadvantage.COMPULSION, Disadvantage.RIVAL, Disadvantage.TANTALIZING,
					Disadvantage.TOUCHY),
			List.of(Advantage.ALERTNESS, Advantage.GOAL, Advantage.ENDURANCE, Advantage.INFLUENCE, Advantage.LUCK,
					Advantage.STATUS),
			List.of(Secret.FAMILY, Secret.GUILTY, Secret.VICTIM),
			List.of(Profession.ATHLETE, Profession.COACH, Profession.TRAINER), 8, 10,
			List.of(Skill.ACROBATICS, Skill.CLIMB, Skill.DANCING, Skill.DODGE, Skill.DRIVE, Skill.GAMBLING,
					Skill.CONTACTS, Skill.SPORT, Skill.THROWING, Skill.UNARMED));
	public static final KultCharacter CAREGIVER = new KultCharacter("Character (archetype, caregiver)",
			List.of(Disadvantage.CYNIC, Disadvantage.DEBT, Disadvantage.DEPENDENT, Disadvantage.DEPRESSION,
					Disadvantage.MARTYR, Disadvantage.COMPULSION, Disadvantage.PARANOIA),
			List.of(Advantage.ALTRUIST, Advantage.EMPATHY, Advantage.FAITH, Advantage.FORGIVING, Advantage.REPUTATION,
					Advantage.LARGESSE, Advantage.MOTHERLINESS),
			List.of(Secret.GUILTY, Secret.SUPERNATURALEXPERIENCE, Secret.SURVIVOR, Secret.UPROOTED, Secret.VICTIM),
			List.of(Profession.SOCIAL, Profession.NANNY, Profession.GOVERNESS, Profession.PARENT, Profession.NURSE), 3,
			7, List.of(Skill.MEDICINE, Skill.BUREAUCRACY, Skill.WORDLY, Skill.PSYCHOLOGY, Skill.CONTACTS));
	public static final KultCharacter CELEBRITY = new KultCharacter("Character (archetype, celebrity)",
			List.of(Disadvantage.REPUTATION, Disadvantage.EGOTIST, Disadvantage.GREED, Disadvantage.MANICDEPRESSIVE,
					Disadvantage.RIVAL, Disadvantage.TANTALIZING, Disadvantage.TOUCHY, Disadvantage.VAIN),
			List.of(Advantage.ARTISTIC, Advantage.REPUTATION, Advantage.LUCK, Advantage.STATUS),
			List.of(Secret.CHOSEN, Secret.GUILTY, Secret.OCCULTEXPERIENCE, Secret.HAUNTED),
			List.of(Profession.WRITER, Profession.MUSICIAN, Profession.MODEL, Profession.TV), 8, 10,
			List.of(Skill.ACTING, Skill.CAROUSING, Skill.WRITING, Skill.DRIVE, Skill.HAUT, Skill.CONTACTS, Skill.MUSIC,
					Skill.RHETORIC, Skill.SEDUCTION, Skill.STYLE));
	public static final KultCharacter CLERGY = new KultCharacter("Character (archetype, clergy)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.ADDICTION, Disadvantage.HAUNTED, Disadvantage.MARTYR,
					Disadvantage.COMPULSION, Disadvantage.NYMPHOMANIA),
			List.of(Advantage.ALTRUIST, Advantage.HONOR, Advantage.EMPATHY, Advantage.FORGIVING, Advantage.INFLUENCE,
					Advantage.INTUITION, Advantage.MOTHERLINESS, Advantage.PACIFISM),
			List.of(Secret.CHOSEN, Secret.CURSE, Secret.KNOWLEDGE, Secret.GUARDIAN, Secret.OCCULTEXPERIENCE,
					Secret.PACT, Secret.SUPERNATURALEXPERIENCE),
			List.of(Profession.CLERGY, Profession.MONK, Profession.SOCIAL, Profession.TEACHER), 2, 4,
			List.of(Skill.PSYCHOLOGY, Skill.ETIQUETTE, Skill.INFORMATION, Skill.LANGUAGES, Skill.MEDITATION,
					Skill.SOCIAL, Skill.CONTACTS, Skill.RHETORIC, Skill.WRITING));
	public static final KultCharacter DOCTOR = new KultCharacter("Character (archetype, doctor)",
			List.of(Disadvantage.DEBT, Disadvantage.EGOTIST, Disadvantage.GREED, Disadvantage.RATIONALIST,
					Disadvantage.GAMBLER, Disadvantage.NYMPHOMANIA),
			List.of(Advantage.REPUTATION, Advantage.INFLUENCE), List.of(Secret.GUILTY, Secret.SURVIVOR),
			List.of(Profession.PHYSICIAN, Profession.SCIENTIST, Profession.PSYCHIATRIST), 7, 9,
			List.of(Skill.MEDICINE, Skill.FORENSICS, Skill.COMPUTERS, Skill.WORDLY, Skill.CONTACTS, Skill.SCIENCE,
					Skill.POISONS, Skill.DRUGS));
	public static final KultCharacter FUGITIVE = new KultCharacter("Character (archetype, fugitive)",
			List.of(Disadvantage.ANXIETY, Disadvantage.LUCK, Disadvantage.CURSE, Disadvantage.CYNIC,
					Disadvantage.DEPRESSION, Disadvantage.PERSECUTED, Disadvantage.BLAMED, Disadvantage.MISTAKEN,
					Disadvantage.ENEMY, Disadvantage.PARANOIA, Disadvantage.RIVAL),
			List.of(Advantage.ALERTNESS, Advantage.ANIMALS, Advantage.HONESTY, Advantage.ENDURANCE, Advantage.SENSATE),
			List.of(Secret.CURSE, Secret.FAMILY, Secret.KNOWLEDGE, Secret.GUILTY, Secret.VICTIM),
			List.of(Profession.WORKER), 1, 3, List.of(Skill.SECURITY, Skill.WORDLY, Skill.CLIMB, Skill.DISGUISE,
					Skill.DODGE, Skill.HIDE, Skill.SNEAK, Skill.UNARMED, Skill.SURVIVAL));
	public static final KultCharacter X = new KultCharacter("Character (archetype, generation X)",
			List.of(Disadvantage.CYNIC, Disadvantage.ANXIETY, Disadvantage.LUCK, Disadvantage.BLACKSHEEP,
					Disadvantage.DEBT, Disadvantage.DEPRESSION, Disadvantage.ADDICTION, Disadvantage.SELFESTEEM,
					Disadvantage.SCHIZOPHRENIA, Disadvantage.TOUCHY),
			List.of(Advantage.ARTISTIC, Advantage.FLEXIBILITY, Advantage.EMPATHY, Advantage.AWARENESS),
			List.of(Secret.FAMILY, Secret.GUILTY, Secret.INSANITY, Secret.OCCULTEXPERIENCE, Secret.UPROOTED,
					Secret.VICTIM),
			Profession.INSTANCE.lines, 2, 4,
			List.of(Skill.CAROUSING, Skill.WORDLY, Skill.COMPUTERS, Skill.DANCING, Skill.DRIVE, Skill.INFORMATION,
					Skill.ART, Skill.MUSIC, Skill.POISONS, Skill.DRUGS, Skill.SPORT, Skill.WRITING, Skill.SOCIAL,
					Skill.SCIENCE));
	public static final KultCharacter HUSTLER = new KultCharacter("Character (archetype, hustler)",
			List.of(Disadvantage.LUCK, Disadvantage.CYNIC, Disadvantage.DEPRESSION, Disadvantage.ADDICTION,
					Disadvantage.FORGOTTEN, Disadvantage.SELFESTEEM, Disadvantage.PERSECUTED),
			List.of(Advantage.ANIMALS, Advantage.FLEXIBILITY, Advantage.ENDURANCE),
			List.of(Secret.GUILTY, Secret.INSANITY, Secret.OCCULTEXPERIENCE, Secret.SURVIVOR, Secret.VICTIM,
					Secret.UPROOTED),
			List.of(Profession.UNEMPLOYED, Profession.PROSTITUTE, Profession.ODDJOBS, Profession.LANDLORD), 1, 3,
			List.of(Skill.CAROUSING, Skill.WORDLY, Skill.SEDUCTION, Skill.HIDE, Skill.SEARCH, Skill.SNEAK,
					Skill.UNARMED, Skill.CONTACTS, Skill.SURVIVAL));
	public static final KultCharacter MARTIAL = new KultCharacter("Character (archetype, martial artist)",
			List.of(Disadvantage.BRASH, Disadvantage.DEATHWISH, Disadvantage.EGOTIST, Disadvantage.FANATICISM,
					Disadvantage.COMPULSION, Disadvantage.REVENGE, Disadvantage.RIVAL, Disadvantage.TOUCHY),
			List.of(Advantage.ALERTNESS, Advantage.ANIMALS, Advantage.HONOR, Advantage.ENDURANCE, Advantage.FAITH,
					Advantage.WILL, Advantage.MENTOR, Advantage.INTUITION, Advantage.OPTIMIST, Advantage.SENSATE),
			List.of(Secret.CHOSEN, Secret.KNOWLEDGE, Secret.GUARDIAN, Secret.GUILTY, Secret.UPROOTED),
			List.of(Profession.COACH, Profession.MONK, Profession.WORKER), 2, 4,
			List.of(Skill.MEDICINE, Skill.CLIMB, Skill.INSTRUCTION, Skill.THROWING, Skill.MELEE, Skill.UNARMED,
					Skill.MEDITATION, Skill.SOCIAL, Skill.NIGHT, Skill.SPORT, Skill.MELEE));
	public static final KultCharacter PARAPSYCHOLOGIST = new KultCharacter("Character (archetype, parapsychologist)",
			List.of(Disadvantage.LUCK, Disadvantage.REPUTATION, Disadvantage.BLACKSHEEP, Disadvantage.HAUNTED,
					Disadvantage.COMPULSION, Disadvantage.TOUCHY, Disadvantage.MEDIUM),
			List.of(Advantage.FLEXIBILITY, Advantage.GOAL, Advantage.AWARENESS, Advantage.INTUITION, Advantage.MATH,
					Advantage.MENTOR, Advantage.SENSATE),
			List.of(Secret.OCCULTEXPERIENCE, Secret.INSANITY, Secret.GUILTY, Secret.SUPERNATURALEXPERIENCE),
			List.of(Profession.PSYCHIATRIST, Profession.TEACHER), 4, 6,
			List.of(Skill.MEDICINE, Skill.COMPUTERS, Skill.ELECTRONICS, Skill.PSYCHOLOGY, Skill.INFORMATION,
					Skill.LANGUAGES, Skill.MEDITATION, Skill.CONTACTS, Skill.OCCULTISM, Skill.PHOTOGRAPHY,
					Skill.RHETORIC, Skill.WRITING));
	public static final KultCharacter SCHOLAR = new KultCharacter("Character (archetype, scholar)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.EGOTIST, Disadvantage.FANATICISM, Disadvantage.INTOLERANCE,
					Disadvantage.RATIONALIST),
			List.of(Advantage.HONOR, Advantage.FLEXIBILITY, Advantage.LANGUAGES, Advantage.MATH),
			List.of(Secret.KNOWLEDGE, Secret.INHERITOR, Secret.OCCULTEXPERIENCE, Secret.GUILTY,
					Secret.SUPERNATURALEXPERIENCE, Secret.SURVIVOR),
			List.of(Profession.SCIENTIST, Profession.TEACHER, Profession.CURATOR, Profession.LIBRARIAN), 4, 6,
			List.of(Skill.CRYPTOGRAPHY, Skill.INFORMATION, Skill.INSTRUCTION, Skill.LANGUAGES, Skill.CONTACTS,
					Skill.RHETORIC, Skill.SOCIAL, Skill.MEDICINE, Skill.SCIENCE, Skill.WRITING));
	public static final Table ARCHETYPE = new SimpleMetaTable("Character",
			List.of(GANGMEMBER, AVENGER, DEALER, FEMMEFATALE, PI, VETERAN, AGENT, CORPORATE, STUDENT, SCIENTIST,
					SAMURAI, MUCKRAKER, COP, ARTIST, ROCKER, OUTSIDER, ESCAPEE, HACKER, HOMEMAKER, PRODIGY, ACTIVIST,
					ARISTOCRAT, ATHLETE, CAREGIVER, CELEBRITY, CLERGY, DOCTOR, FUGITIVE, X, HUSTLER, MARTIAL,
					PARAPSYCHOLOGIST, SCHOLAR, Conjurer.OCCULTIST, Conjurer.PAGAN)) {
		@Override
		public String roll() {
			return minim.model.Character.roll(3) == 3 ? NightChild.INSTANCE.roll() : super.roll();
		}
	};
	public static final String NORMAL = "Normal";

	List<String> disadvantages;
	List<String> advantages;
	List<String> secrets;
	List<String> profession;
	int wealthmin;
	int wealthmax;
	List<String> skills;

	KultCharacter(String title, List<String> disadvantages, List<String> advantages, List<String> secrets,
			List<String> profession, int wealthmin, int wealthmax, List<String> skills) {
		super(title);
		this.disadvantages = new ArrayList<>(disadvantages);
		this.advantages = new ArrayList<>(advantages);
		this.secrets = new ArrayList<>(secrets);
		this.profession = new ArrayList<>(profession);
		this.wealthmin = wealthmin;
		this.wealthmax = wealthmax;
		this.skills = new ArrayList<>(skills);
	}

	@Override
	public void build() {
		// don't
	}

	String describe(int balance) {
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

	public static final Table WEALTH = new SimpleTable("Character (living standard)",
			List.of("Destitude", "Poor", "Low income", "Lower middle-class", "Middle-class", "Upper middle-class",
					"Well-off", "Very well-off", "Rich", "Extremely rich"));

	@Override
	public String roll() {
		var l = new Lines();
		var balance = 0;
		Collections.shuffle(this.disadvantages);
		var disadvantages = this.disadvantages.subList(0,
				Math.min(this.disadvantages.size(), minim.model.Character.roll(5)));
		l.add("Disadvantages", String.join(", ", disadvantages).toLowerCase());
		for (var d : disadvantages) {
			balance -= Disadvantage.BALANCE.get(d);
		}
		Collections.shuffle(this.advantages);
		var advantages = this.advantages.subList(0, Math.min(this.advantages.size(), minim.model.Character.roll(5)));
		l.add("Advantages", String.join(", ", advantages).toLowerCase());
		for (var a : advantages) {
			balance += Advantage.BALANCE.get(a);
		}
		var mental = describe(balance);
		if (mental != NORMAL) {
			l.add("Mental balance", mental);
			if (balance < 0)
				l.add("Dark secret", Secret.INSTANCE.roll(secrets, disadvantages));
		}
		Collections.shuffle(profession);
		l.add("Profession", profession.get(0));
		var wealth = 0;
		while (!(wealthmin <= wealth && wealth <= wealthmax))
			wealth = minim.model.Character.roll(10);
		l.add("Wealth", WEALTH.lines.get(wealth - 1));
		Collections.shuffle(this.skills);
		var skills = this.skills.subList(0, Math.min(this.skills.size(), 1 + minim.model.Character.roll(3)));
		l.add("Skills", String.join(", ", skills).toLowerCase());
		return l.toString();
	}

}
