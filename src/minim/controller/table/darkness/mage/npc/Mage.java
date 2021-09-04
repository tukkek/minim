package minim.controller.table.darkness.mage.npc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import minim.controller.table.Table;
import minim.controller.table.darkness.mage.Faction;
import minim.controller.table.darkness.mage.Rank;
import minim.controller.table.darkness.mage.Tradition;
import minim.model.Character;

public class Mage extends Table {
	public static final Table INSTANCE = new Mage();
	public static final Table TRADITIONALIST = new Table("Mage (NPC, traditionalist)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			var lines = new ArrayList<String>();
			lines.add("Tradition: " + Tradition.INSTANCE.roll());
			lines.add("Rank: " + Rank.TRADITIONS.roll());
			return String.join(".\n", lines);
		}
	};
	public static final Table TECHNOCRAT = new Table("Mage (NPC, technocrat)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			var lines = new ArrayList<String>();
			lines.add("Rank: " + Rank.TECHNOCRACY.roll());
			return String.join(".\n", lines);
		}
	};
	public static final Table NEPHANDI = new Table("Mage (NPC, nephandi)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			var lines = new ArrayList<String>();
			lines.add("Rank: " + Rank.NEṔHANDI.roll());
			if (Character.roll(2) == 1) {
				lines.add("Resides in Umbra");
			} else
				lines.add("Resides on Earth");
			if (Character.roll(4) == 4) {
				lines.add("Independent");
			} else
				lines.add("Part of a labyrinth");
			return String.join(".\n", lines);
		}
	};
	public static final Table ORPHAN = new Table("Mage (NPC, orphan)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			return "Rank: " + Rank.ORPHAN.roll();
		}
	};

	static final Map<String, Table> FACTIONS = new HashMap<>(5);

	static {
		FACTIONS.put(Faction.TRADITIONS, TRADITIONALIST);
		FACTIONS.put(Faction.TECHNOCRACY, TECHNOCRAT);
		FACTIONS.put(Faction.NEPHANDI, NEPHANDI);
		FACTIONS.put(Faction.MARAUDERS, Marauder.INSTANCE);
		FACTIONS.put(Faction.ORPHANS, ORPHAN);
	}

	Mage() {
		super("Mage");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var t = Faction.INSTANCE.roll();
		return "Faction: " + t + ".\n" + FACTIONS.get(t).roll();
	}
}
