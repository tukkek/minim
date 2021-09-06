package minim.controller.table.innomine.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.controller.table.innomine.character.Fiends.Fiend;

public class Demon extends minim.controller.table.innomine.character.Characters.Character {
	public static final String BALSERAPH = "Balseraph";
	public static final String DJINN = "Djinn";
	public static final String CALABIM = "Calabim";
	public static final String HABBALAH = "Habbalah";
	public static final String LILIM = "Lilim";
	public static final String SHEDIM = "Shedim";
	public static final String IMPUDITES = "Impudites";
	public static final Table BAND = new SimpleTable("Character (demon, band)",
			List.of(BALSERAPH, DJINN, CALABIM, HABBALAH, LILIM, SHEDIM, IMPUDITES));
	public static final Demon INSTANCE = new Demon();

	static final Map<String, String> TITLES = new HashMap<>();
	static final Fiends PLEDGE = new Fiends();

	static {
		TITLES.put(BALSERAPH, "liars");
		TITLES.put(DJINN, "stalkers");
		TITLES.put(CALABIM, "destroyers");
		TITLES.put(HABBALAH, "punishers");
		TITLES.put(LILIM, "tempters");
		TITLES.put(SHEDIM, "corrupters");
		TITLES.put(IMPUDITES, "takers");
		for (var t : PLEDGE.tables.values()) {
			var f = (Fiend) t;
			f.forces = 7;
		}
	}

	static String band;

	Demon() {
		super("Character (demon)", 9);
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	protected void define(Lines l) {
		l.add("Demon");
		band = BAND.roll();
		l.add("Band", "%s (%s)".formatted(band, TITLES.get(band)));
	}

	@Override
	public String roll() {
		var r = super.roll();
		for (var i = 0; i < Angel.pledge(2); i++) {
			r += "\n\nPledge: " + PLEDGE.roll(band);
		}
		return r;
	}
}
