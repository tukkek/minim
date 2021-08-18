package minim.controller.table.combat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.Table;

public class Wound extends Table {
	public static final Table HIT = new Wound("Wound", 0);
	public static final Table CRITICAL = new Wound("Wound (critical)", 1);
	public static final Table DEADLY = new Wound("Wound (deadly)", 2);

	static final Map<String, List<String>> EFFECTS = new HashMap<>(10);
	static final String LEG = "Leg";
	static final String HAND = "Hand";
	static final String ARM = "Arm";
	static final String ABDOMEN = "Abdomen";
	static final String HEART = "Heart";
	static final String CHEST = "Chest";
	static final String NECK = "Neck";
	static final String EYE = "Eye";
	static final String EAR = "Ear";
	static final String HEAD = "Head";

	static {
		EFFECTS.put(LEG, List.of("Slowed for a couple of turns", "Slowed until end of combat", "Permanently slowed"));
		EFFECTS.put(HAND, List.of("Cannot hold for a couple of turns", "Cannot hold until end of combat",
				"Cannot hold permanently"));
		EFFECTS.put(ARM, List.of("Penalty to attacks for a couple of turns", "Penalty to attacks until end of combat",
				"Permanent penalty to attacks"));
		EFFECTS.put(ABDOMEN,
				List.of("Staggered for a couple of turns", "Staggered until end of combat", "Permanently staggered"));
		EFFECTS.put(HEART, List.of("No particular effect.", "No particular effect.", "Instant death."));
		EFFECTS.put(CHEST,
				List.of("No particular effect.", "Stunned for a couple of turns.", "Target is unconscious."));
		EFFECTS.put(NECK, List.of("Muted for a couple of turns.", "Muted until end of combat.", "Permanently muted."));
		EFFECTS.put(EYE,
				List.of("Blinded for a couple of turns.", "Blinded until end of combat.", "Permanently blind."));
		EFFECTS.put(EAR, List.of("Deaf for a couple of turns.", "Deaf until end of combat.", "Permanently dead."));
		EFFECTS.put(HEAD, List.of("Disoriented for a couple of turns.", "Disoriented until end of combat.",
				"Permanently disoriented."));
	}

	int effect;

	Wound(String name, int effect) {
		super(name);
		this.effect = effect;
	}

	@Override
	public void build() {
		add(1, 2, HEAD);
		add(1, 1, EAR);
		add(1, 1, EYE);
		add(1, 1, NECK);
		add(1, 5, CHEST);
		add(1, 1, HEART);
		add(1, 2, ABDOMEN);
		add(1, 5, ARM);
		add(1, 2, HAND);
		add(1, 5, LEG);
	}

	@Override
	public String roll() {
		var r = super.roll();
		return r.toLowerCase() + " - %s.".formatted(EFFECTS.get(r).get(effect).toLowerCase());
	}
}
