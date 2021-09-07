package minim.controller.table.kult.character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Character extends Table {
	public static final Character GANGMEMBER = new Character("Character (archetype, gang member)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.FANATICISM, Disadvantage.CONSTRICTION, Disadvantage.INTOLERANCE, Disadvantage.WANTED,
					Disadvantage.TOUCHY, Disadvantage.LIAR, Disadvantage.MANIA, Disadvantage.ADDICTION,
					Disadvantage.EGOTIST),
			List.of(Advantage.ARTISTIC, Advantage.HONOR, Advantage.AWARENESS, Advantage.FLEXIBILITY, Advantage.SENSATE),
			List.of(Secret.FAMILY, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.UNEMPLOYED, Profession.CRIMINAL, Profession.WORKER), 2, 4,
			List.of(Skill.DANCING, Skill.DAGGER, Skill.POISONS, Skill.DRUGS, Skill.GRAFFITI, Skill.HIDE,
					Skill.IMMIGRANT, Skill.BURGLARY, Skill.CLIMB, Skill.IMPACT, Skill.DRIVE, Skill.HANDGUN, Skill.SNEAK,
					Skill.MARTIAL, Skill.RHETORIC, Skill.WORDLY, Skill.ESTIMATE));
	public static final Character AVENGER = new Character("Character (archetype, avenger)",
			List.of(Disadvantage.LUCK, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.MAIMED,
					Disadvantage.DEPRESSION, Disadvantage.ADDICTION, Disadvantage.FANATICISM, Disadvantage.LIAR,
					Disadvantage.MANIA, Disadvantage.ENEMY, Disadvantage.COMPULSION, Disadvantage.PARANOIA,
					Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA, Disadvantage.WANTED, Disadvantage.REVENGE),
			List.of(Advantage.HONOR, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.GUILTY, Secret.VICTIM), Profession.INSTANCE.lines, 3, 5,
			List.of(Skill.AUTOMATIC, Skill.BURGLARY, Skill.CLIMB, Skill.DAGGER, Skill.DEMOLITION, Skill.DISGUISE,
					Skill.DRIVE, Skill.DODGE, Skill.FALLING, Skill.INFORMATION, Skill.HANDGUN, Skill.HIDE, Skill.IMPACT,
					Skill.INTERROGATION, Skill.MARTIAL, Skill.SEARCH, Skill.SHADOW, Skill.SNEAK));
	public static final Character DEALER = new Character("Character (archetype, dealer)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.GREED, Disadvantage.TOUCHY, Disadvantage.LIAR, Disadvantage.ADDICTION,
					Disadvantage.RATIONALIST, Disadvantage.EGOTIST, Disadvantage.GAMBLER),
			List.of(Advantage.EMPATHY, Advantage.INFLUENCE, Advantage.FLEXIBILITY, Advantage.INTUITION,
					Advantage.SENSATE, Advantage.LUCK),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.CRIMINAL, Profession.CONSULTANT, Profession.BUSINESSMAN), 5, 7,
			List.of(Skill.COMPUTERS, Skill.DIPLOMACY, Skill.DAGGER, Skill.FRENCH, Skill.FORGERY, Skill.INFORMATION,
					Skill.ITALIAN, Skill.CONTACTS, Skill.DRIVE, Skill.SEARCH, Skill.HANDGUN, Skill.SNEAK,
					Skill.GAMBLING, Skill.MARTIAL, Skill.GERMAN, Skill.RHETORIC, Skill.WORDLY, Skill.ESTIMATE));
	public static final Character FEMMEFATALE = new Character("Character (archetype, femme fatale)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CONSTRICTION, Disadvantage.GREED, Disadvantage.TOUCHY,
					Disadvantage.MANIA, Disadvantage.ADDICTION, Disadvantage.NYMPHOMANIA, Disadvantage.LIAR,
					Disadvantage.EGOTIST, Disadvantage.GAMBLER),
			List.of(Advantage.ARTISTIC, Advantage.ANIMALS, Advantage.EMPATHY, Advantage.INFLUENCE, Advantage.INTUITION,
					Advantage.AWARENESS, Advantage.LANGUAGES),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY, Secret.INSANITY),
			List.of(Profession.ARTIST, Profession.CRIMINAL, Profession.JOURNALIST, Profession.PI, Profession.RENTIER),
			6, 8,
			List.of(Skill.DANCING, Skill.DIPLOMACY, Skill.DAGGER, Skill.ETIQUETTE, Skill.FRENCH, Skill.INTERROGATION,
					Skill.DISGUISE, Skill.POISONS, Skill.DRUGS, Skill.INFORMATION, Skill.CONTACTS, Skill.DRIVE,
					Skill.HANDGUN, Skill.ACTING, Skill.GAMBLING, Skill.MARTIAL, Skill.RHETORIC, Skill.WORDLY,
					Skill.ESTIMATE));
	public static final Character PI = new Character("Character (archetype, private investigator)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CURSE, Disadvantage.CONSTRICTION, Disadvantage.PARANOIA,
					Disadvantage.GREED, Disadvantage.LIAR, Disadvantage.ADDICTION, Disadvantage.RATIONALIST,
					Disadvantage.EGOTIST, Disadvantage.GAMBLER),
			List.of(Advantage.CHIVALRY, Advantage.EMPATHY, Advantage.HONOR, Advantage.INFLUENCE, Advantage.FLEXIBILITY,
					Advantage.SENSATE, Advantage.LUCK, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.PI, Profession.SECURITY), 5, 7,
			List.of(Skill.AUTOMATIC, Skill.FORENSICS, Skill.DAGGER, Skill.ELECTRONICS, Skill.PHOTOGRAPHY,
					Skill.INTERROGATION, Skill.DISGUISE, Skill.HIDE, Skill.INFORMATION, Skill.DRIVE, Skill.HANDGUN,
					Skill.SHADOW, Skill.SNEAK, Skill.NIGHT, Skill.MARTIAL, Skill.WORDLY));
	public static final Character VETERAN = new Character("Character (archetype, veteran)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.PHOBIA, Disadvantage.CONSTRICTION,
					Disadvantage.PARANOIA, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.LIAR,
					Disadvantage.ADDICTION, Disadvantage.COMPULSION),
			List.of(Advantage.AWARENESS, Advantage.PACIFISM, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.VICTIM, Secret.GUILTY), List.of(Profession.UNEMPLOYED, Profession.WORKER), 3,
			5,
			List.of(Skill.AUTOMATIC, Skill.DAGGER, Skill.DODGE, Skill.PARACHUTING, Skill.INTERROGATION, Skill.AID,
					Skill.HIDE, Skill.THROWING, Skill.CLIMB, Skill.DRIVE, Skill.MECHANICS, Skill.PILOTING,
					Skill.HANDGUN, Skill.RADIO, Skill.SWIM, Skill.SNEAK, Skill.DEMOLITION, Skill.MARTIAL, Skill.HEAVY,
					Skill.SURVIVAL));
	public static final Character AGENT = new Character("Character (archetype, secret agent)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.LIAR, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.RATIONALIST, Disadvantage.GAMBLER),
			List.of(Advantage.CHIVALRY, Advantage.HONOR, Advantage.INFLUENCE, Advantage.AWARENESS,
					Advantage.FLEXIBILITY, Advantage.SENSATE, Advantage.LUCK, Advantage.ENDURANCE),
			List.of(Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.INTELLIGENCE, Profession.SPECOPS), 6, 8,
			List.of(Skill.ARABIC, Skill.AUTOMATIC, Skill.BUGGING, Skill.FORENSICS, Skill.COMPUTERS, Skill.DAGGER,
					Skill.DODGE, Skill.PARACHUTING, Skill.FALLING, Skill.FRENCH, Skill.FORGERY, Skill.INTERROGATION,
					Skill.DISGUISE, Skill.HIDE, Skill.BURGLARY, Skill.INFORMATION, Skill.THROWING, Skill.CLIMB,
					Skill.CONTACTS, Skill.INTELLIGENCE, Skill.CRYPTOGRAPHY, Skill.DRIVE, Skill.SEARCH, Skill.PARRY,
					Skill.PILOTING, Skill.HANDGUN, Skill.RADIO, Skill.RIDING, Skill.RUSSIAN, Skill.SWIM,
					Skill.SEAMANSHIP, Skill.SHADOW, Skill.SNEAK, Skill.GAMBLING, Skill.DIVING, Skill.DEMOLITION,
					Skill.NIGHT, Skill.MARTIAL, Skill.GERMAN, Skill.WORDLY));
	public static final Character CORPORATE = new Character("Character (archetype, corporate)",
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
	public static final Character STUDENT = new Character("Character (archetype, student)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.LIAR,
					Disadvantage.MANIA, Disadvantage.ADDICTION, Disadvantage.RATIONALIST),
			List.of(Advantage.FLEXIBILITY, Advantage.MATH, Advantage.LANGUAGES),
			List.of(Secret.GUILTY, Secret.FAMILY, Secret.KNOWLEDGE, Secret.VICTIM), List.of(Profession.STUDENT), 2, 4,
			List.of(Skill.COMPUTERS, Skill.FRENCH, Skill.SEDUCTION, Skill.SPORT, Skill.INFORMATION, Skill.CONTACTS,
					Skill.WRITING, Skill.RHETORIC, Skill.WORDLY));
	public static final Character SCIENTIST = new Character("Character (archetype, scientist)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.FANATICISM,
					Disadvantage.CONSTRICTION, Disadvantage.PARANOIA, Disadvantage.INTOLERANCE, Disadvantage.WANTED,
					Disadvantage.TOUCHY, Disadvantage.MANIA, Disadvantage.ADDICTION, Disadvantage.RATIONALIST,
					Disadvantage.EGOTIST),
			List.of(Advantage.AWARENESS, Advantage.INFLUENCE, Advantage.INTUITION, Advantage.MATH, Advantage.LUCK),
			List.of(Secret.GUILTY, Secret.KNOWLEDGE, Secret.VICTIM, Secret.INSANITY, Secret.SUPERNATURAL_EXPERIENCE),
			List.of(Profession.SCIENTIST), 5, 7,
			List.of(Skill.COMPUTERS, Skill.ELECTRONICS, Skill.POISONS, Skill.DRUGS, Skill.HUMANITIES, Skill.PSYCHOLOGY,
					Skill.INFORMATION, Skill.CHEMISTRY, Skill.CONTACTS, Skill.MEDICINE, Skill.SCIENCE));
	public static final Character SAMURAI = new Character("Character (archetype, city samurai)",
			List.of(Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.GREED, Disadvantage.INTOLERANCE, Disadvantage.WANTED, Disadvantage.TOUCHY,
					Disadvantage.LIAR, Disadvantage.ADDICTION, Disadvantage.EGOTIST),
			List.of(Advantage.HONOR, Advantage.INFLUENCE, Advantage.AWARENESS, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY),
			List.of(Profession.CRIMINAL, Profession.BODYGUARD, Profession.SECURITY), 5, 7,
			List.of(Skill.ACROBATICS, Skill.AUTOMATIC, Skill.DAGGER, Skill.DODGE, Skill.FALLING, Skill.INTERROGATION,
					Skill.AID, Skill.RIFLE, Skill.HIDE, Skill.BURGLARY, Skill.THROWING, Skill.CLIMB, Skill.CONTACTS,
					Skill.IMPACT, Skill.DRIVE, Skill.SEARCH, Skill.WHIPS, Skill.CHAINS, Skill.HANDGUN, Skill.SWIM,
					Skill.SHADOW, Skill.TWOHANDED, Skill.SNEAK, Skill.NIGHT, Skill.MARTIAL, Skill.WORDLY));
	public static final Character MUCKRAKER = new Character("Character (archetype, muck-raker)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.ENEMY, Disadvantage.REVENGE,
					Disadvantage.FANATICISM, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.MANIA,
					Disadvantage.ADDICTION, Disadvantage.RATIONALIST, Disadvantage.EGOTIST),
			List.of(Advantage.HONOR, Advantage.INFLUENCE, Advantage.INTUITION, Advantage.FLEXIBILITY, Advantage.SENSATE,
					Advantage.LUCK, Advantage.HONESTY),
			List.of(Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY), List.of(Profession.JOURNALIST), 5, 7,
			List.of(Skill.FORENSICS, Skill.COMPUTERS, Skill.PHOTOGRAPHY, Skill.FORGERY, Skill.DISGUISE, Skill.BURGLARY,
					Skill.INFORMATION, Skill.HANDGUN, Skill.WRITING, Skill.SHADOW, Skill.SNEAK, Skill.RHETORIC,
					Skill.WORDLY));
	public static final Character COP = new Character("Character (archetype, cop)",
			List.of(Disadvantage.DEATHWISH, Disadvantage.ENEMY, Disadvantage.REVENGE, Disadvantage.FANATICISM,
					Disadvantage.CONSTRICTION, Disadvantage.INTOLERANCE, Disadvantage.TOUCHY, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.RATIONALIST, Disadvantage.COMPULSION),
			List.of(Advantage.CHIVALRY, Advantage.HONOR, Advantage.ALTRUIST, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.VICTIM, Secret.GUILTY, Secret.INSANITY), List.of(Profession.DETECTIVE), 4, 6,
			List.of(Skill.AUTOMATIC, Skill.FORENSICS, Skill.INTERROGATION, Skill.DISGUISE, Skill.RIFLE, Skill.SPORT,
					Skill.BURGLARY, Skill.INFORMATION, Skill.DRIVE, Skill.HANDGUN, Skill.HUMANITIES, Skill.MARTIAL,
					Skill.SHADOW, Skill.SNEAK));
	public static final Character ARTIST = new Character("Character (archetype, artist)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.FANATICISM, Disadvantage.CURSE, Disadvantage.CONSTRICTION,
					Disadvantage.TOUCHY, Disadvantage.MANIA, Disadvantage.MANICDEPRESSIVE, Disadvantage.NIGHTMARES,
					Disadvantage.ADDICTION, Disadvantage.SCHIZOPHRENIA, Disadvantage.COMPULSION),
			List.of(Advantage.ARTISTIC, Advantage.EMPATHY, Advantage.AWARENESS, Advantage.INTUITION,
					Advantage.ENDURANCE),
			Secret.INSTANCE.lines, List.of(Profession.ARTIST, Profession.WRITER, Profession.MUSICIAN), 3, 5,
			List.of(Skill.ACTING, Skill.WRITING, Skill.CRAFT, Skill.DANCING, Skill.CONTACTS, Skill.ART,
					Skill.PHOTOGRAPHY, Skill.MUSIC, Skill.RHETORIC, Skill.WORDLY));
	public static final Character ROCKER = new Character("Character (archetype, rock musician)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.CURSE,
					Disadvantage.TOUCHY, Disadvantage.MANIA, Disadvantage.NIGHTMARES, Disadvantage.ADDICTION,
					Disadvantage.NYMPHOMANIA, Disadvantage.COMPULSION),
			List.of(Advantage.ARTISTIC, Advantage.EMPATHY, Advantage.AWARENESS, Advantage.INFLUENCE, Advantage.LUCK),
			List.of(Secret.CURSE, Secret.KNOWLEDGE, Secret.VICTIM, Secret.PACT, Secret.INSANITY, Secret.GUILTY),
			List.of(Profession.MUSICIAN), 6, 8, List.of(Skill.ACROBATICS, Skill.DANCING, Skill.POETRY, Skill.POISONS,
					Skill.DRUGS, Skill.MUSIC, Skill.MARKETING, Skill.ACTING, Skill.GAMBLING, Skill.WORDLY));
	public static final Character OUTSIDER = new Character("Character (archetype, outsider)",
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CURSE, Disadvantage.PERSECUTED, Disadvantage.CONSTRICTION,
					Disadvantage.PARANOIA, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.ADDICTION,
					Disadvantage.LUCK, Disadvantage.SCHIZOPHRENIA, Disadvantage.NYMPHOMANIA, Disadvantage.EGOTIST,
					Disadvantage.GAMBLER),
			List.of(Advantage.ARTISTIC, Advantage.AWARENESS, Advantage.FLEXIBILITY, Advantage.SENSATE,
					Advantage.ENDURANCE),
			List.of(Secret.FAMILY, Secret.CURSE, Secret.KNOWLEDGE, Secret.VICTIM, Secret.GUILTY, Secret.INSANITY),
			List.of(Profession.UNEMPLOYED, Profession.CRIMINAL, Profession.WORKER), 1, 3,
			List.of(Skill.AUTOMATIC, Skill.DAGGER, Skill.DODGE, Skill.FALLING, Skill.SEDUCTION, Skill.DISGUISE,
					Skill.RIFLE, Skill.POISONS, Skill.DRUGS, Skill.HIDE, Skill.BURGLARY, Skill.THROWING, Skill.CLIMB,
					Skill.CONTACTS, Skill.MECHANICS, Skill.WHIPS, Skill.CHAINS, Skill.HANDGUN, Skill.MUSIC,
					Skill.SHADOW, Skill.GAMBLING, Skill.SNEAK, Skill.NIGHT, Skill.MARKETING, Skill.WORDLY,
					Skill.SURVIVAL));
	public static final Table ARCHETYPE = new SimpleMetaTable("Character",
			List.of(GANGMEMBER, AVENGER, DEALER, FEMMEFATALE, PI, VETERAN, AGENT, CORPORATE, STUDENT, SCIENTIST,
					SAMURAI, MUCKRAKER, COP, ARTIST, ROCKER, OUTSIDER)) {
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

	Character(String title, List<String> disadvantages, List<String> advantages, List<String> secrets,
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
