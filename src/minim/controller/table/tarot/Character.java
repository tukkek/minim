package minim.controller.table.tarot;

import java.util.List;

/**
 * @author alex
 * @see PlotGenerator
 */
public class Character extends TarotTable {
	public Character() {
		super("Character", List.of("Description", "Past", "Wants", "Obstacle", "Strength", "Weakness"));
	}
}
