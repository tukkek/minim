package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class SettlementName extends Table {
	static final Table PREFIX = new SimpleTable("Settlement name prefix",
			List.of("Bleak", "Green", "Wolf", "Raven", "Gray", "Red", "Axe", "Great", "Wood", "Low", "White", "Storm",
					"Black", "Mourn", "New", "Stone", "Grim", "Lost", "High", "Rock", "Shield", "Sword", "Frost",
					"Thorn", "Long"));
	static final Table SUFFIX = new SimpleTable("Settlement name suffix",
			List.of("moor", "ford", "crag", "watch", "hope", "wood", "ridge", "stone", "haven", "fall(s)", "river",
					"field", "hill", "bridge", "mark", "cairn", "land", "hall", "mount", "rock", "brook", "barrow",
					"stead", "home", "wick"));

	public SettlementName() {
		super("Settlement name");
	}

	@Override
	public void build() {
		add(1, 15, "Based on landscape feature (ie. Highmount)");
		add(16, 30, "Based on a construction (ie. Whitebridge)");
		add(31, 45, "Based on creature (ie. Ravencliff)");
		add(46, 60, "Based on event (ie. Fool's Fall)");
		add(61, 75, "Based on old language (ie. Abon)");
		add(76, 90, "Based on environment (ie. Winterhome)");
		add(List.of("Based on trade good (ie. Ironvein)", "Based on old city (ie. New Arkesh)",
				"Based on figure (ie. Kei's Hall)", "Based on a god (ie. Elisore)", "Based on artifact (ie. Blackhelm)",
				"Based on race (ie. Elfbrook)", "Based on foreign word or name (ie. Elfbrook)",
				"Based on myth (ie. Ghostwalk)", "Based on positive word (ie. Hope)",
				"Based on negative word (ie. Forsaken)"));
	}

	@Override
	public String roll() {
		return super.roll() + ". Generated: " + PREFIX.roll() + SUFFIX.roll();
	}
}
