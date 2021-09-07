package minim.controller.table.kult.character;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class NightChild extends Character {
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
	public static final String SUNLIGHT = "Sensitive to sunlight";
	public static final String SHAPECHANGE = "Uncontrolled shape change";
	public static final String INHUMAN = "Inhuman appearance";
	public static final String SOULTHIRST = "Soul thirst";
	public static final String STARS = "Controlled by stars";
	public static final Table LIMITATIONS = new SimpleTable("Character (child of the night, limitations)",
			List.of(BLOODTHIRST, SYMBOLBOUND, TOMBBOUND, HUNTER, CANNIBAL, CONTROLLED, FIRE, ELECTRICITY, HOLYSYMBOL,
					SILVER, SUNLIGHT, SHAPECHANGE, INHUMAN, SOULTHIRST, STARS));
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
	public static final Table POWERS = new SimpleTable("Character (child of the night, powers)",
			List.of(COMMANDING, ETERNAL, ABILITY, POISON, VISION, WEAPONS, FIREIMMUNE, ELECTRICITYIMMUNE, RADIATION,
					WEAPONSIMMUNITY, FAST, REGENERATION, SKIN, SENSES, TELEKINESIS, TELEPATHY, ENDURANCE));
	public static final NightChild INSTANCE = new NightChild();

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
		Disadvantage.BALANCE.put(SUNLIGHT, 20);
		Disadvantage.BALANCE.put(SHAPECHANGE, 10);
		Disadvantage.BALANCE.put(INHUMAN, 10);
		Disadvantage.BALANCE.put(SOULTHIRST, 20);
		Disadvantage.BALANCE.put(STARS, 10);
		for (var p : POWERS.lines)
			Advantage.BALANCE.put(p, 0);
	}

	NightChild() {
		super("Character (child of the night)",
				List.of(Disadvantage.DEPRESSION, Disadvantage.REPUTATION, Disadvantage.DEATHWISH, Disadvantage.ENEMY,
						Disadvantage.REVENGE, Disadvantage.CURSE, Disadvantage.PERSECUTED, Disadvantage.CONSTRICTION,
						Disadvantage.PARANOIA, Disadvantage.WANTED, Disadvantage.TOUCHY, Disadvantage.MANIA,
						Disadvantage.NIGHTMARES, Disadvantage.SCHIZOPHRENIA, Disadvantage.MAIMED),
				List.of(Advantage.AWARENESS, Advantage.INTUITION, Advantage.SENSATE, Advantage.ENDURANCE),
				Secret.INSTANCE.lines,
				List.of(Profession.UNEMPLOYED, Profession.WORKER, Profession.STUDENT, Profession.BOUNCER), 1, 7,
				Skill.INSTANCE.lines);
		disadvantages.addAll(LIMITATIONS.lines);
		advantages.addAll(POWERS.lines);
	}

	@Override
	String describe(int balance) {
		balance = Math.min(-25, balance);
		return super.describe(balance);
	}
}
