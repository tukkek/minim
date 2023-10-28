package minim.controller.table.innomine;

import java.util.ArrayList;

import minim.controller.action.base.RolledAction;
import minim.controller.table.MetaTable;
import minim.controller.table.Table;
import minim.controller.table.innomine.character.Angel;
import minim.controller.table.innomine.character.Demon;

public class Artifact extends MetaTable {
	public static final Table TALISMAN = new Table("Artifact (talisman)") {
		@Override
		public void build() {
			for (var s : RolledAction.SKILLS)
				add("Talisman of %s (skill bonus)".formatted(s.toLowerCase()));
		}
	};
	public static final Table RELIC = new Table("Artifact (relic)") {
		@Override
		public void build() {
			Song.INSTANCE.roll();
			for (var s : Song.INSTANCE.lines)
				add("Relic of %s (song)".formatted(s.toLowerCase()));
		}
	};
	public static final Table COMPASS = new Table("Artifact (compass)") {
		@Override
		public void build() {
			Angel.CHOIR.roll();
			var attunements = new ArrayList<>(Angel.CHOIR.lines);
			for (var b : Demon.BAND.lines)
				attunements.add("%s (%s)".formatted(b, Demon.TITLES.get(b)));
			for (var s : attunements)
				add("Compass of the %s".formatted(s));
		}
	};
	public static final Table VESSEL = new Table("Artifact (vessel)") {
		@Override
		public void build() {
			for (var t : Song.TYPE.lines)
				add("Vessel (%s elemental)".formatted(t.toLowerCase()));
		}
	};
	public static final Table LEVEL = new Table("Artifact (level)") {
		@Override
		public void build() {
			add(5, "Level 1");
			add(4, "Level 2");
			add(3, "Level 3");
			add(2, "Level 4");
			add(1, "Level 5");
		}
	};

	public static final Table INSTANCE = new Artifact();

	Artifact() {
		super("Artifact");
	}

	@Override
	public void build() {
		add(6, "Corporeal artifact (reduces paradox)");
		add(3, TALISMAN);
		add(2, "Reliquary (generates 1 willpower/level, rate of 1/day)");
		add(2, RELIC);
		add(2, COMPASS);
		add(2, "Fiery sword (+1/level)");
		add(2, VESSEL);
		add(1, "Holy pistol (+1/level)");
		add(1, "Unholy pistol (+1/level)");
	}

	@Override
	public String roll() {
		return super.roll() + ", " + LEVEL.roll().toLowerCase();
	}
}
