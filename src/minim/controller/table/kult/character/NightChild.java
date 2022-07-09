package minim.controller.table.kult.character;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class NightChild extends KultCharacter {
	public static final String BLOODTHIRST = "Bloodthirst";
	public static final String SYMBOLBOUND = "Symbol bondage";
	public static final String TOMBBOUND = "Tomb bondage";
	public static final String HUNTER = "Hunting instinct";
	public static final String CANNIBAL = "Cannibalism";
	public static final String CONTROLLED = "Controlled by external power";
	public static final String FIRE = "Sensitive to fire";
	public static final String ELECTRICITY = "Sensitive to electricity";
	public static final String HOLYSYMBOL = "Scared of religious symbols";
	public static final String SILVER = "Sensitive to silver";
	public static final String IRON = "Sensitive to iron";
	public static final String COPPER = "Sensitive to copper";
	public static final String SUNLIGHT = "Sensitive to sunlight";
	public static final String SHAPECHANGE = "Uncontrolled shape change";
	public static final String INHUMAN = "Inhuman appearance";
	public static final String SOULTHIRST = "Soul thirst";
	public static final String STARS = "Controlled by stars";
	public static final Table LIMITATIONS = new SimpleTable("Character (child of the night, limitations)",
			List.of(BLOODTHIRST, SYMBOLBOUND, TOMBBOUND, HUNTER, CANNIBAL, CONTROLLED, FIRE, ELECTRICITY, HOLYSYMBOL,
					SILVER, IRON, COPPER, SUNLIGHT, SHAPECHANGE, INHUMAN, SOULTHIRST, STARS));
	public static final String COMMANDING = "Commanding voice";
	public static final String ETERNAL = "Eternal youth";
	public static final String ABILITY = "Increased ability";
	public static final String POISON = "Resistant to poison";
	public static final String VISION = "Infrared vision";
	public static final String WEAPONS = "Natural weapons";
	public static final String FIREIMMUNE = "Invulnerable to fire";
	public static final String ELECTRICITYIMMUNE = "Invulnerable to electricity";
	public static final String RADIATION = "Invulnerable to radiation";
	public static final String WEAPONSIMMUNITY = "Invulnerable to weapons";
	public static final String FAST = "Fast reactions";
	public static final String REGENERATION = "Regeneration";
	public static final String SKIN = "Protective skin";
	public static final String SENSES = "Enhanced senses";
	public static final String TELEKINESIS = "Telekinesis";
	public static final String TELEPATHY = "Telepathy";
	public static final String ENDURANCE = "Infinite endurance";
	public static final String NOFOOD = "Never needs food or drink";
	public static final Table POWERS = new SimpleTable("Character (child of the night, powers)",
			List.of(COMMANDING, ETERNAL, ABILITY, POISON, VISION, WEAPONS, FIREIMMUNE, ELECTRICITYIMMUNE, RADIATION,
					WEAPONSIMMUNITY, FAST, REGENERATION, SKIN, SENSES, TELEKINESIS, TELEPATHY, ENDURANCE, NOFOOD));
	public static final NightChild GENERIC = new NightChild("Character (child of the night, archetype, generic)",
			Secret.INSTANCE.lines, POWERS.lines, LIMITATIONS.lines,
			List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
					Disadvantage.REVENGE, Disadvantage.CURSE, Disadvantage.PERSECUTED, Disadvantage.CONSTRICTION,
					Disadvantage.PARANOIA, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.MANIA,
					Disadvantage.NIGHTMARES, Disadvantage.SCHIZOPHRENIA, Disadvantage.MAIMED),
			List.of(Advantage.AWARENESS, Advantage.INTUITION, Advantage.SENSATE, Advantage.ENDURANCE),
			List.of(Profession.UNEMPLOYED, Profession.WORKER, Profession.STUDENT, Profession.BOUNCER), 1, 7,
			Skill.INSTANCE.lines);
	public static final NightChild LORELEI = new NightChild("Character (child of the night, archetype, lorelei)",
			List.of(Secret.GUILTY), List.of(ABILITY, ETERNAL), List.of(CONTROLLED, SOULTHIRST),
			List.of(Disadvantage.COMPULSION, Disadvantage.ANIMAL, Disadvantage.EGOTIST, Disadvantage.NYMPHOMANIA,
					Disadvantage.TANTALIZING, Disadvantage.VAIN),
			List.of(Advantage.ENDURANCE, Advantage.AWARENESS), Profession.INSTANCE.lines, 6, 10,
			List.of(Skill.WORDLY, Skill.DANCING, Skill.ETIQUETTE, Skill.CONTACTS, Skill.STYLE));
	public static final NightChild NEPHILIM = new NightChild("Character (child of the night, archetype, nephilim)",
			List.of(Secret.CURSE, Secret.OCCULTEXPERIENCE, Secret.GUILTY, Secret.UPROOTED),
			List.of(VISION, WEAPONS, WEAPONSIMMUNITY, SKIN, SENSES, ABILITY, FAST),
			List.of(INHUMAN, IRON, SILVER, COPPER, ELECTRICITY),
			List.of(Disadvantage.PERSECUTED, Disadvantage.CURSE, Disadvantage.DEATHWISH, Disadvantage.ADDICTION,
					Disadvantage.SCHIZOPHRENIA, Disadvantage.TOUCHY, Disadvantage.WANTED),
			List.of(Advantage.AWARENESS, Advantage.HONESTY, Advantage.ENDURANCE, Advantage.MENTOR, Advantage.SENSATE),
			List.of(Profession.UNEMPLOYED, Profession.CRIMINAL), 1, 1,
			List.of(Skill.BURGLARY, Skill.WORDLY, Skill.DISGUISE, Skill.ETIQUETTE, Skill.CONTACTS, Skill.POISONS,
					Skill.DRUGS, Skill.SURVIVAL, Skill.SHADOW, Skill.SNEAK, Skill.UNARMED));
	public static final NightChild REVENANT = new NightChild("Character (child of the night, archetype, revenant)",
			List.of(Secret.CHOSEN, Secret.CURSE, Secret.INSANITY, Secret.VICTIM, Secret.UPROOTED),
			List.of(ABILITY, SKIN, NOFOOD, REGENERATION),
			List.of(CONTROLLED, FIRE, ELECTRICITY, HOLYSYMBOL, TOMBBOUND, INHUMAN),
			List.of(Disadvantage.CURSE, Disadvantage.HAUNTED, Disadvantage.COMPULSION, Disadvantage.NIGHTMARES,
					Disadvantage.REVENGE, Disadvantage.TOUCHY),
			List.of(Advantage.ENDURANCE, Advantage.INTUITION, Advantage.SENSATE), List.of(Profession.UNEMPLOYED), 1, 1,
			List.of(Skill.WORDLY, Skill.SURVIVAL, Skill.SHADOW, Skill.SNEAK, Skill.UNARMED));
	public static final NightChild SERAPHIM = new NightChild("Character (child of the night, archetype, seraphim)",
			List.of(Secret.KNOWLEDGE, Secret.INSANITY, Secret.PACT), List.of(WEAPONS, ETERNAL, FAST, ABILITY, VISION),
			List.of(ELECTRICITY, IRON),
			List.of(Disadvantage.COMPULSION, Disadvantage.TANTALIZING, Disadvantage.AMNESIA, Disadvantage.WANTED,
					Disadvantage.EGOTIST, Disadvantage.MANICDEPRESSIVE),
			List.of(Advantage.ENDURANCE, Advantage.INTUITION, Advantage.ANIMALS, Advantage.HONOR, Advantage.LUCK,
					Advantage.SENSATE),
			List.of(Profession.UNEMPLOYED), 1, 1, List.of(Skill.MELEE, Skill.LANGUAGES, Skill.SEDUCTION,
					Skill.PSYCHOLOGY, Skill.INTERROGATION, Skill.CONTACTS));
	public static final NightChild WOLVEN = new NightChild("Character (child of the night, archetype, wolven)",
			List.of(Secret.INHERITOR, Secret.VICTIM, Secret.GUILTY, Secret.UPROOTED),
			List.of(WEAPONSIMMUNITY, FAST, SENSES, POISON, WEAPONS, ABILITY, VISION),
			List.of(SILVER, HUNTER, SHAPECHANGE, INHUMAN, STARS),
			List.of(Disadvantage.CURSE, Disadvantage.SPLIT, Disadvantage.TOUCHY, Disadvantage.REPUTATION,
					Disadvantage.CYNIC, Disadvantage.DEPRESSION, Disadvantage.WANTED),
			List.of(Advantage.ALERTNESS, Advantage.ANIMALS, Advantage.ENDURANCE, Advantage.INTUITION),
			Profession.INSTANCE.lines, 1, 10, List.of(Skill.CONTACTS, Skill.SNEAK, Skill.SURVIVAL, Skill.UNARMED));
	public static final Table INSTANCE = new SimpleMetaTable("Character (child of the night)",
			List.of(GENERIC, LORELEI, NEPHILIM, REVENANT, SERAPHIM, WOLVEN));

	static {
		Disadvantage.BALANCE.put(BLOODTHIRST, 10);
		Disadvantage.BALANCE.put(SYMBOLBOUND, 10);
		Disadvantage.BALANCE.put(TOMBBOUND, 10);
		Disadvantage.BALANCE.put(HUNTER, 5);
		Disadvantage.BALANCE.put(CANNIBAL, 20);
		Disadvantage.BALANCE.put(CONTROLLED, 20);
		Disadvantage.BALANCE.put(FIRE, 10);
		Disadvantage.BALANCE.put(ELECTRICITY, 10);
		Disadvantage.BALANCE.put(HOLYSYMBOL, 10);
		Disadvantage.BALANCE.put(SILVER, 5);
		Disadvantage.BALANCE.put(IRON, 5);
		Disadvantage.BALANCE.put(COPPER, 5);
		Disadvantage.BALANCE.put(SUNLIGHT, 20);
		Disadvantage.BALANCE.put(SHAPECHANGE, 10);
		Disadvantage.BALANCE.put(INHUMAN, 10);
		Disadvantage.BALANCE.put(SOULTHIRST, 20);
		Disadvantage.BALANCE.put(STARS, 10);
		for (var p : POWERS.lines)
			Advantage.BALANCE.put(p, 0);
	}

	NightChild(String title, List<String> secrets, List<String> powers, List<String> limitations,
			List<String> disadvantages, List<String> advantages, List<String> profession, int wealthmin, int wealthmax,
			List<String> skills) {
		super(title, disadvantages, advantages, secrets, profession, wealthmin, wealthmax, skills);
		this.advantages.addAll(powers);
		this.disadvantages.addAll(limitations);
	}

	@Override
	String describe(int balance) {
		balance = Math.min(-25, balance);
		return super.describe(balance);
	}
}
