package minim.controller.table.adventure.dungeon.lore;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Backstory extends Table {
	public static final Table SINGLETON = new Backstory();

	static final Table WHY1 = new SimpleTable("Why (#1)", List.of("Inhabitants were changed", "Inhabitants defeated",
			"Inhabitants massacred", "Inhabitants abandoned place", "Inhabitants physically altered",
			"Construction (recent or ancient) was done", "Inhabitants changed beliefs", "Inhabitants mentally altered",
			"Inhabitants mentally and physically alteredOriginal inhabitants departed the place",
			"The place became hostile to civilization", "The place became filled with traps or deadly barriers",
			"The place was shut off from the world", "The original inhabitants became decadent",
			"The inhabitants broke into two groups", "A cataclysm or natural disaster took place", "Poisons were used",
			"Deadly beings were made", "Leaders were slain or imprisoned", "Raiding began"));
	static final Table WHY2 = new SimpleTable("Why (#2)", List.of("In connection with an ancient curse",
			"In connection with savages", "In connection with rampaging non-human tribes",
			"In connection with a dispute between powerful monsters/individuals",
			"In connection with something unexpected being unearthed", "In connection with forbidden knowledge",
			"In connection with unexpected facts being discovered", "In connection with a disease",
			"In connection with magical research", "In connection with a strange belief",
			"In connection with promises made by a powerful being", "In connection with the use of strange substances",
			"In connection with the discovery of valuable substances", "After contact with sinister beings",
			"After a religious or philosophical dispute", "After strange omens",
			"In connection with excessive pride and hubris", "In connection with the theft of an important item",
			"In connection with black magic", "In connection with a war"));
	static final Table WHEN = new Table("When") {
		@Override
		public void build() {
			add(1, "1000 years ago");
			add(5, "100 years ago");
			add(5, "10 years ago");
			add(5, "1 years ago");
			add(2, "1 month ago");
			add(1, "1 week ago");
			add(1, "1 day ago");
		}
	};

	Backstory() {
		super("Dungeon (backstory)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return "%s %s (%s)".formatted(WHY1.roll(), WHY2.roll().toLowerCase(), WHEN.roll());
	}
}
