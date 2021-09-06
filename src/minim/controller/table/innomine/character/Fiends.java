package minim.controller.table.innomine.character;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.controller.table.innomine.Song;
import minim.controller.table.innomine.character.Characters.Character;

public class Fiends extends SimpleMetaTable {
	static class Fiend extends Character {
		String type;
		SimpleTable pledge;

		Fiend(String type, List<String> songs, List<String> pledge) {
			super("Character (lesser fiend, %s)".formatted(type), 5, new Song(songs));
			this.type = type;
			this.pledge = new SimpleTable("Character (lesser fiend, pledge)", pledge);
		}

		@Override
		protected void define(Lines l) {
			l.add(pledge.roll() + " " + type.toLowerCase());
		}
	}

	static class Imp extends Fiend {
		Imp() {
			super("Imp", List.of(Song.DREAMS, Song.FORM, Song.LIGHT, Song.MOTION, Song.POSSESSION),
					List.of(Demon.DJINN, Demon.SHEDIM, Demon.IMPUDITES));
		}
	}

	static class Gremlin extends Fiend {
		Gremlin() {
			super("Gremlin", List.of(Song.ENTROPY, Song.MOTION, Song.THUNDER, Song.CORPUS),
					List.of(Demon.BALSERAPH, Demon.CALABIM, Demon.HABBALAH));
		}
	}

	static class Familiar extends Fiend {
		Familiar() {
			super("Familiar", Song.SONGS, Demon.BAND.lines);
		}
	}

	public Fiends() {
		super("Character (lesser fiend)", List.of(new Familiar(), new Gremlin(), new Imp()));
	}

	public String roll(String band) {
		Table r = null;
		while (r == null || !((Fiend) r).pledge.lines.contains(band)) {
			r = super.rolltable();
		}
		return r.roll();
	}
}
