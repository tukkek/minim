package minim.controller.table.kult.madness;

import minim.controller.table.Table;
import minim.controller.table.kult.character.Disadvantage;
import minim.controller.table.kult.character.NightChild;
import minim.model.Character;

public class MentalChange extends Table {
	public static final MentalChange INSTANCE = new MentalChange();

	MentalChange() {
		super("Madness (reaction, mental change)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var change = "disadvantage";
		Table t = Disadvantage.INSTANCE;
		if (Character.roll(10) == 1) {
			change = "limitation";
			t = NightChild.LIMITATIONS;
		}
		return "new %s, %s (reroll if not relevant)".formatted(change, t.roll().toLowerCase());
	}
}
