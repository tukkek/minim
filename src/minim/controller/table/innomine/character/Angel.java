package minim.controller.table.innomine.character;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Angel extends minim.controller.table.innomine.character.Characters.Character {
	public static final Table CHOIR = new SimpleTable("Character (angel, choir)",
			List.of("Seraphim (most-holy)", "Cherubim (guardians)", "Ofanim (wheels)", "Elohim (powers)",
					"Malakim (virtues)", "Kyriotates (dominations)", "Mercurians (friends-of-man)"));
	public static final Angel INSTANCE = new Angel();

	static final Reliever PLEDGE = new Reliever();

	static {
		PLEDGE.forces = 9;
	}

	Angel() {
		super("Character (angel)", 9);
	}

	@Override
	protected void define(Lines l) {
		l.add("Angel");
		l.add("Choir", CHOIR);
	}

	@Override
	public String roll() {
		var r = super.roll();
		for (var i = 0; i < pledge(1); i++) {
			r += "\n\nPledge: " + PLEDGE.roll();
		}
		return r;
	}

	static public int pledge(int die) {
		var pledges = 0;
		while (Character.roll(2) == 1) {
			pledges += Character.roll(die);
		}
		return pledges;
	}
}
