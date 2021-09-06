package minim.controller.table.innomine;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Discord extends Table {
	public static final Discord INSTANCE = new Discord();
	public static final Table TYPE = new SimpleTable("Discord (type)",
			List.of("Celestial discord", "Etherial discord", "Corporeal discord"));

	static final String YES = "Yes";

	Discord() {
		super("Discord");
	}

	@Override
	public void build() {
		add(1, YES);
		add(300, "None");
	}

	@Override
	public String roll() {
		var r = super.roll();
		return r == YES ? TYPE.roll() : r;
	}
}
