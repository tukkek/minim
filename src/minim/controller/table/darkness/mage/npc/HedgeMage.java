package minim.controller.table.darkness.mage.npc;

import java.util.ArrayList;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.controller.table.darkness.mage.Tradition;
import minim.model.Character;

public class HedgeMage extends Table {
	public static final Table INSTANCE = new HedgeMage();
	public static final String LARGEGROUP = "Large group";
	public static final Table ORGANIZATION = new SimpleTable("Hedge mage (organization)",
			List.of("Loner", "Small group", LARGEGROUP));

	HedgeMage() {
		super("Hedge mage");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var lines = new ArrayList<String>();
		var o = ORGANIZATION.roll();
		if (o == LARGEGROUP) {
			o += " (" + Character.roll(10) * 10 + " hedge mages)";
		}
		lines.add("Organization: " + o);
		if (Character.roll(20) == 20)
			lines.add("Associated with " + Tradition.INSTANCE.roll());
		return String.join(".\n", lines);
	}
}
