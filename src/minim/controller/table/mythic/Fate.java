package minim.controller.table.mythic;

import minim.controller.table.Table;
import minim.model.Character;

public class Fate extends Table {
	public static final Fate IMPOSSIBLE = new Fate(5, "impossible");
	public static final Fate UNLIKELY = new Fate(35, "unlikely");
	public static final Fate EVENODSS = new Fate(50, "50/50");
	public static final Fate LIKELY = new Fate(75, "likely");
	public static final Fate SURETHING = new Fate(90, "sure thing");

	int target;

	Fate(int target, String description) {
		super("Yes/no (" + description + ")");
		this.target = target;
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var roll = Character.roll(100);
		if (roll <= target / 5) {
			return "Exceptional yes";
		}
		if (roll <= target)
			return "Yes";
		if (roll > 100 - (100 - target) / 5)
			return "Exceptional no";
		return "No";
	}
}
