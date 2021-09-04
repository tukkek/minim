package minim.controller.table.darkness.kindred;

import minim.controller.table.Table;
import minim.model.Character;

public class Age extends Table {
	public static final Table INSTANCE = new Age();

	Age() {
		super("Kindred (age)");
		rebuild = true;
	}

	@Override
	public void build() {
		var millenium = 1;
		while (Character.roll(2) == 1)
			millenium += 1;
		add(6, millenium * 1000 + " years");
		add(8, (3 + Character.roll(7) - 1) * 100 + " years");
		add(8, "200 years");
		add(6, "100 years");
		add(80, Character.roll(9) * 10 + " years");
	}
}
