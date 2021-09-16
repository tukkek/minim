package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Being extends MetaTable {
	public static final String KETHER = "Kether, the Ruler";
	public static final String MALKUTH = "Malkuth, the Rebel";
	public static final Table ARCHONS = new SimpleTable("Being (archons)", List.of(KETHER, "Binah, the Black Madonna",
			"Geburah, the Judge", "Tiphareth, the Spider", "Netzach, the Victor", MALKUTH));
	public static final Table DEITIES = new SimpleMetaTable("Being (deity)",
			List.of(ARCHONS, Inferno.ASTAROTH, Inferno.ANGELS));
	public static final Table BORDERLINER = new SimpleTable("Being (borderliner)", List.of("Borderliner human",
			"Nachtkäfer (giant, insect-like portal-dwellers)", "Child of the underworld (mole people)",
			"Razid larvae (eats organic matter, phase through inorganic matter)",
			"Psilocites (eyeless giants with metal exo-skeletons and atrophied appendages)", Metropolis.AZGHOUL,
			Metropolis.UNDEADSERVANT,
			"Amentoraz (slowly consumes mentallly-ill people, looks like a darker shadow during the day and assumes forms relevant to their victim at night to torment them)",
			"Madman (physically-altered mentally-negative insane person)",
			"Fury (large, extremely insane human with several body alterations, can sometimes be controlled as minions)",
			"Cairath (large bipedal, four-armed sewer predators with a metallic head and bodies made of junk, refuse, vermin and their victims)",
			"Libith (shape-changing succcubus looking to madden and degrade their victims, or drive them to suicide)",
			"Darthea (possesses humans and influence them into sexual acts, often into exhaustion and starvation)",
			"Gynachide (dark-grey creatures with metallic teeths and nails that impregnate women with their offspring, as romantic, loyal and protective as they are alien)",
			"Aetats (murderous \"time-police\" with distorded, long, curved bodies and eight legs - if perceived, can be thrown off by \"laying low\" long enough)",
			"Aspecti (thin, flickering, color-changing, distorted Medusa-looking creatures with flowing space-perception, may appear to humans when ni the same wavelengthm, often causing madness and system shock)",
			"The homeless (the Bag Lady)", "The police (well-armed and paranoid, prowling in vehicles)",
			"Garbage symbiosis (semi-organic creature followed by smaller, suicidal compostats)", "Police stand-off",
			"Gang brutality",
			"Scavenger (usually found in an area with potential to find equipment, will usually avoid others but can also attack from stealth)",
			"Soldier", "Human hunter (generally hostile, paranoid)", "Artillery barrage", "Hunting squad"));
	public static final Table UNDEAD = new SimpleTable("Being (undead)", List.of(
			"Undead (ghost on the borderline of death, by their own will or bound to something)",
			"Corpophagus (usually a broken dead spirit, with deadly, inch-long corpophagi parasites in the vicinity)",
			"Living dead (usually insane and aggressive, unless very recent)",
			"Nosferatu (vampire, often extroverted and artsy or seclusive and magic)",
			"Specters (semi-physical living dead who are bound to a thing or a goal, usually driven insane after a decade)"));
	public static final Table INSTANCE = new Being();

	Being() {
		super("Being (city)");
	}

	@Override
	public void build() {
		add(1, "Astaroth incarnate (form: %s, immune to magic and controls beings with negative mental balance)"
				.formatted(Inferno.ASTAROTH.roll()));
		for (var a : ARCHONS.lines) {
			if (a == KETHER)
				continue;
			add(10, "Archon incarnate (%s)".formatted(a));
			add(20, "Archon manifestation (%s)".formatted(a));
			add(30, "%s of %s".formatted(a == MALKUTH ? "Human servant" : "Lictor (jailer)", a));
		}
		for (var a : Inferno.ANGELS.lines) {
			if (a != Inferno.NAHEMOTH)
				add(4, "Angel of Death incarnate (%s)".formatted(a));
			add(20, "Angel of Death manifestation (%s)".formatted(a));
			add(30, Inferno.RAZIDE.formatted(a));
		}
		add(40, BORDERLINER);
		add(40, UNDEAD);
	}
}
