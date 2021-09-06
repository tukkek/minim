package minim.controller.table.innomine.character;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.innomine.Song;
import minim.controller.table.innomine.character.Characters.Character;

public class Soldier extends Character {
	public static final Soldier GOD = new Soldier("Soldier of god");
	public static final Soldier HELL = new Soldier("Soldier of hell");

	String type;

	Soldier(String type) {
		super("Character (%s)".formatted(type.toLowerCase()), 6, new Song(Song.SONGS, List.of(Song.CORPOREA)));
		this.type = type;
	}

	@Override
	protected void define(Lines l) {
		l.add(type);
	}
}
