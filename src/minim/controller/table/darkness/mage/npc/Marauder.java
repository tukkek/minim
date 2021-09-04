package minim.controller.table.darkness.mage.npc;

import java.util.ArrayList;

import minim.controller.table.Table;
import minim.controller.table.darkness.mage.Rank;
import minim.model.Character;

public class Marauder extends Table {
	public static final Table BACKRGOUND = new Table("Mage (NPC, marauder, background)") {
		@Override
		public void build() {
			add(4, "Former traditionalist");
			add(2, "Former technocrat");
			add(1, "Former nephandi");
			add(3, "Former orphan");
		}
	};
	public static final Marauder INSTANCE = new Marauder();

	Marauder() {
		super("Mage (NPC, marauder)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var lines = new ArrayList<String>();
		lines.add("Rank: " + Rank.MARAUDER.roll());
		if (Character.roll(4) == 1) {
			lines.add("Resides on Earth");
		} else
			lines.add("Resides in Umbra");
		lines.add(BACKRGOUND.roll());
		return String.join(".\n", lines);
	}
}