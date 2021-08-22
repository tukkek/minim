package minim.controller.table.adventure.dungeon.lore;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Occupant extends SimpleTable {
	public static final Table SINGLETON = new Occupant();

	Occupant() {
		super("Dungeon (pccupant)", List.of("A Casanova or sex-addict, human or otherwise",
				"A Casanova or sex-addict, human or otherwise", "A collector of objects or animals",
				"A collector of objects or animals", "A constructed entity similar to an intelligent golem",
				"A cult or sect of humans, demi-humans, or other humanoids (peaceful)",
				"A cult or sect of humans, demi-humans, or other humanoids (peaceful)",
				"A cult or sect of humans, demihumans, or other humanoids (violent, sinister, or evil)",
				"A cult or sect of humans, demihumans, or other humanoids (violent, sinister, or evil)", "A demigod",
				"A demigod",
				"A demonic creature, possibly with slaves of some type (you could roll again to see what sort of slaves)",
				"A giant, possibly a very unique one", "A giant, possibly a very unique one", "A group of traders",
				"A major political figure such as a king or prince. In a dungeon, this guy is probably either non-human or is in hiding. Other possibility is that he owns the land above, and this is a stronghold area or part of one.",
				"A major political figure such as a king or prince. In a dungeon, this guy is probably either non-human or is in hiding. Other possibility is that he owns the land above, and this is a stronghold area or part of one.",
				"A notorious poisoner", "A notorious poisoner", "A powerful undead creature",
				"A powerful undead creature", "A shapeshifter or lycanthrope", "A shapeshifter or lycanthrope",
				"A wizard, evil", "A wizard, evil", "A wizard, evil", "A wizard, evil", "A wizard, not evil",
				"A wizard, not evil", "A wizard, not evil", "A wizard, not evil", "An alchemist, human or otherwise",
				"An alchemist, human or otherwise", "An ancient race of humans or a “superior” subspecies of humanity",
				"An ancient race of humans or a “superior” subspecies of humanity", "An artificer of machines",
				"An artificer of machines", "An intelligent “Lord” of a type of vermin",
				"An intelligent “Lord” of a type of vermin",
				"Ancient, horrific creatures that are best forgotten and hopefully aren’t still there",
				"Ancient, horrific creatures that are best forgotten and hopefully aren’t still there",
				"Band of powerful adventurers ((relative to the dungeon level)",
				"Band of powerful adventurers ((relative to the dungeon level)",
				"Criminal organization: murderous or violent", "Criminal organization: murderous or violent",
				"Criminal organization: thieves, forgers, arsonists, or other non-violent crimes",
				"Criminal organization: thieves, forgers, arsonists, or other non-violent crimes", "Intelligent vermin",
				"Intelligent vermin"));
	}
}
