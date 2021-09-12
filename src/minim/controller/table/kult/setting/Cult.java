package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

/**
 * {@link #TYPE} is used over a static instance so as to avoid generating a
 * brand-new Cult every time one is needed/referened in another table. Instead,
 * the idea is to have one or two of {@link #TYPE} that a GM can refer to when a
 * type is rolled in another table - those instances can then be fully generated
 * with a manual roll on {@link Cult} proper.
 */
public class Cult extends Table {
	public static final Table TYPE = new SimpleTable("Cult (type)", List.of(
			"Religious cult (worship an occult being, an awakened or ordinary human or a principle)",
			"Guardian cult (protect an Artifact, of real or imagined value)",
			"Knowledge-seeking cult (rarely-violent cult trying to obtain a piece of information)",
			"Power group (business, religious or political gruup that act as a cult, sometimes extremists, not necessarily tied to the occult)",
			"Illuminati (loose world-wide net of awakened humans trying to achieve and guide toward vivinity)",
			"Perversion cult (deranged group that seeks out to fulfill their dark carnal desires)"));
	public static final Table CHARACTERISTIC = new SimpleTable("Cult (characteristic)",
			List.of("Minimal", "Low", "Average", "High", "Extreme"));

	public Cult() {
		super("Cult");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add(TYPE);
		for (var characteristic : List.of("Size", "Structure", "Membership requirements", "Resources",
				"Geographical presence", "Luxury", "Ease to identify", "Prone to violence", "Secrecy"))
			l.add(characteristic, CHARACTERISTIC);
		var d = Being.DEITIES;
		d.setup();
		if (Character.roll(d.lines.size()) != 1)
			l.add("Affiliation", d);
		while (Character.roll(4) == 1)
			l.add("Ally", TYPE);
		while (Character.roll(4) == 1)
			l.add("Enemy", TYPE);
		return l.toString();
	}
}
