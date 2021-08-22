package minim.controller.table.adventure.dungeon.lore;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Purpose extends SimpleTable {
	public static final Table SINGLETON = new Purpose();

	Purpose() {
		super("Dungeon (purpose)", List.of("Antechamber", "Archives", "Arena", "Armory",
				"Art gallery, display area, waxworks, or trophy room", "Audience-chamber", "Aviary", "Banquet hall",
				"Barracks", "Bath houses", "Bedrooms", "Casino", "Chantry", "Chapel", "Cistern or well",
				"Closets, lockers, small storage", "Conjuring or summoning", "Courtrooms", "Crypts", "Dormitories",
				"Garden (fungus, orchids or other)", "Granary, warehouse, or storage area", "Kennels", "Kitchen area",
				"Laboratories", "Library", "Lounge or common room", "Meditation chambers", "Offices",
				"Offices or administration", "Oracle or divination", "Pantries or food storage", "Prison", "Privies",
				"Proximity to elemental substance (fire or lava)",
				"Proximity to elemental substance (unusual air or gases)",
				"Proximity to elemental substance (unusual earth or gems)",
				"Proximity to elemental substance (unusual water)", "Robing rooms", "Scriptorium", "Shrine",
				"Smithies or forges", "Stables", "Study", "Torture chambers", "Training rooms", "Waiting rooms",
				"Workroom for wizard or other magic-using being", "Workrooms for craftsmen"));
	}
}
