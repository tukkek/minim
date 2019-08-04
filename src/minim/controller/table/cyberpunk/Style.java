package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Style extends Table {
	public static final Table CLOTHES = new SimpleTable("Style (clothes)", List.of("Leather", "Jeans", "Suit",
			"Jumpsuit", "Miniskirt", "Fashionable", "Camouflage", "Casual", "Nude", "X-large"));
	public static final Table HAIR = new SimpleTable("Style (hair)", List.of("Mohawk", "Long (ratty)", "Spiked", "Wild",
			"Bald", "Striped", "Tinted", "Neat", "Curly", "Long (straight)"));
	public static final Table AFFECTATION = new SimpleTable("Style (affectation)", List.of("Tatoos", "Mirrorshades",
			"Scarification", "Gloves", "Piercing", "Earring", "Fingernails", "Boots", "Contact lens"));
	public static final Style SINGLETON = new Style();

	Style() {
		super("Style");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var style = "Clothes: " + CLOTHES.roll();
		style += "\nHair: " + HAIR.roll();
		style += "\nAffectation: " + AFFECTATION.roll();
		return style;
	}
}
