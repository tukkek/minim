package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Location extends Table {
	public static final Table DESCRIPTOR = new SimpleTable("Location descriptor",
			List.of("High", "Remote", "Exposed", "Small", "Broken", "Diverse", "Rough", "Dark", "Shadowy", "Contested",
					"Grim", "Wild", "Fertile", "Blocked", "Ancient", "Perilous", "Hidden", "Occupied", "Rich", "Big",
					"Savage", "Defended", "Withered", "Mystical", "Inaccessible", "Protected", "Abandoned", "Wide",
					"Foul", "Dead", "Ruined", "Barren", "Cold", "Blighted", "Low", "Beautiful", "Abundant", "Lush",
					"Flooded", "Empty", "Strange", "Corrupted", "Peaceful", "Forgotten", "Expansive", "Settled",
					"Dense", "Civilized", "Desolate", "Isolated"));

	public Location() {
		super("Location");
	}

	@Override
	public void build() {
		add(List.of("Hideout", "Ruin", "Mine", "Waste", "MysticalSite", "Path", "Outpost", "Wall", "Battlefield",
				"Hovel", "Spring", "Lair", "Fort", "Bridge", "Camp", "Cairn/Grave", "Anomaly"));
		for (var i : List.of("Caravan", "Waterfall", "Cave", "Swamp", "Fen", "Ravine", "Road", "Tree", "Pond", "Fields",
				"Marsh", "Steading", "Rapids", "Pass", "Trail", "Glade", "Plain", "Ridge", "Cliff", "Grove", "Village",
				"Moor", "Thicket", "RiverFord", "Valley", "Bay/Fjord", "Foothills", "Lake"))
			add(1, 2, i);
		add(73, 75, "River");
		add(76, 79, "Forest");
		add(80, 83, "Coast");
		add(84, 88, "Hill");
		add(84, 88, "Plains");
		add(89, 93, "Mountain");
		add(94, 99, "Woods");
	}

	@Override
	public String roll() {
		return "(" + DESCRIPTOR.roll() + ") " + super.roll();
	}
}
