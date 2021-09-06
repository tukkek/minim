package minim.controller.table.misc;

import minim.controller.table.Table;
import minim.model.Character;

public class RandomEncounter extends Table {
	public static final Table DELAY = new Table("Random encounter (delay)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			return Character.roll(10) + " minutes";
		}
	};

	static final String YES = "Yes";

	public RandomEncounter() {
		super("Random encounter");
	}

	@Override
	public void build() {
		add(1, YES);
		add(2, 6, "No");
	}

	@Override
	public String roll() {
		var r = super.roll();
		if (r == YES) {
			r += ". Delay: " + DELAY.roll();
		}
		return r;
	}
}
