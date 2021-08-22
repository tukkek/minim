package minim.controller.table.adventure.dungeon.lore;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Information extends Table {
	public static final Table CLUE = new SimpleTable("Dungeon (information, clue)", List.of(
			"Coded message for a particular recipient", "A deliberately placed message left behind for any recipient",
			"A deliberate misdirection", "A direct vision or memory imparted to someone",
			"Evidence of a mechanism or the use of one", "Journals, diaries, or other personal records",
			"Something that is an inherent part of the general decoration, architecture, environment, or atmosphere",
			"The remnants of an event"));
	public static final Table RUMOR = new SimpleTable("Dungeon (information, rumor)",
			List.of("Account of ancient expedition contained in book or archives", "Ancient riddle", "Ancient warning",
					"Area is taboo or forbidden", "Generally known legend or story", "Generally known prophesy",
					"Hireling with previous group of adventurers", "Minstrel who spoke with prior adventurers",
					"People who heard prior adventurers bragging in tavern", "Recent events (strange deaths, etc)",
					"Recent observations by curious people", "Someone who slept with prior adventurer in the area"));
	public static final Table RUMORCONTENT = new SimpleTable("Dungeon (information, rumor, content)", List.of(
			"How to avoid or disarm a trap",
			"How to find another important piece of information (such as a map or a diary)",
			"How to open a trick door or secret door",
			"How to operate a piece of machinery (an elevator to another level, the lava channels, the ghoul vats, the potion-brewing machine, etc).",
			"How to work a particular trick most beneficially",
			"Information about a significant monster: how to avoid iInformation about a significant monster: how to negotiate with it or keep it from attacking",
			"Information about a major monster: what it is",
			"Information about backstory: what happened to make the place dangerous",
			"Information about backstory: who built the place", "Information about backstory: who lived here",
			"Information about backstory: why the place was originally built", "Location of a key",
			"Location of a level change",
			"Location of a particular room being sought (the prison, the privy, the library, etc).",
			"Location of a secret door", "Location of a trap", "Location of a treasure", "Part of a map",
			"Why an unusual room is built the way it is"));
	public static final Table WRITING = new SimpleTable("Dungeon (information, writing)",
			List.of("Accounts and financial records", "Book, reference", "Book, religious tract",
					"Dossier of information about someone", "Family tree and/or genealogical records", "Graffiti",
					"Inscription on goblet, jewelry, or other item", "Journal", "Legal documents concerning a dispute",
					"Letter", "Maps", "Military plans and orders", "Notes to self", "Ownership papers", "Receipts",
					"Recipes or instructions", "Stitched into cloth", "Treaty documents", "Troop movements",
					"Wall carving"));
	public static final Table SINGLETON = new Information();

	public Information() {
		super("Dungeon (information)");
	}

	@Override
	public void build() {
//don't
	}

	@Override
	public String roll() {
		var r = Character.roll(3);
		if (r == 1)
			return CLUE.roll();
		if (r == 2)
			return RUMOR.roll() + " - " + RUMORCONTENT.roll().toLowerCase();
		return WRITING.roll();
	}
}
