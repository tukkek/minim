package minim.controller.table.conjectural.loom;

import minim.controller.table.Table;
import minim.controller.table.conjectural.Unexpectedly;
import minim.model.Character;

public abstract class YesNoLoom extends Table {
	protected static final String YES_AND_UNEXPECTEDLY = "Yes and unexpectedly...";
	protected static final String YES_BUT = "Yes but...";
	protected static final String YES_AND = "Yes and...";
	protected static final String YES = "Yes";
	protected static final String NO = "No";
	protected static final String NO_AND = "No and...";
	protected static final String NO_BUT = "No but...";
	protected static final String NO_AND_UNEXPECTEDLY = "No and unexpectedly...";

	static int surge = 0;

	public YesNoLoom(String title) {
		super(title);
	}

	@Override
	public String roll() {
		super.roll();
		var roll = Character.roll(100);
		if (roll > 50) {
			roll += surge;
			if (roll > 100)
				roll = 100;
		} else {
			roll -= surge;
			if (roll < 1)
				roll = 1;
		}
		var result = lines.get(roll - 1);
		if (result == YES_AND_UNEXPECTEDLY || result == NO_AND_UNEXPECTEDLY) {
			result += " " + Unexpectedly.SINGLETON.roll();
			surge = 0;
		} else if (result == YES || result == NO)
			surge += 2;
		else
			surge = 0;
		System.out.println("Surge: " + surge);
		return result;
	}

}