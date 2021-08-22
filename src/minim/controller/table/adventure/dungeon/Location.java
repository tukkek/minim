package minim.controller.table.adventure.dungeon;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Location extends SimpleTable {
	public static final Table EXOTIC = new SimpleTable("Dungeon (location, exotic)",
			List.of("Inside a spell", "Sealed inside a magical dome of force",
					"On the back of a Gargantuan living creature", "In a volcano", "On an island in an underground sea",
					"In the Shadowfell", "In the Feywild", "On a cloud",
					"In an area devastated by a magical catastrophe", "On a demiplane or in a pocket dimension",
					"In a meteorite", "Floating on the sea", "Castle or structure at the bottom of a sinkhole",
					"Castle or structure sunken in a swamp", "Buried in volcanic ash", "Buried in a sandstorm",
					"Buried in an avalanche", "Behind a waterfall", "Around a geyser", "Among the branches of a tree"));
	public static final Table SINGLETON = new Location();

	Location() {
		super("Dungeon (location)",
				List.of("On an island", "On a promontory", "On a mountain peak", "In several conn ected mesas",
						"In sea caves", "Beneath or on top of a mesa", "In a swamp", "In a mountain pass",
						"In a jungle", "In a gorge", "In a glacier", "In a forest", "In a desert", "In a cliff face",
						"In a chasm", "Beneath a temple", "Beneath a ruined city", "Beneath a ruined castle",
						"Beneath a graveyard", "Beneath a farmhouse", "Catacombs or sewers beneath a city",
						"A building in a city"));
	}

	@Override
	public String roll() {
		return Character.roll(25) == 1 ? EXOTIC.roll() : super.roll();
	}
}
