package minim.controller.table.innomine.character;

import minim.controller.table.Lines;
import minim.controller.table.innomine.character.Characters.Character;

public class Reliever extends Character {
	public static final Reliever INSTANCE = new Reliever();

	Reliever() {
		super("Character (reliever)", 7);
	}

	@Override
	protected void define(Lines l) {
		l.add("Reliever");
	}
}
