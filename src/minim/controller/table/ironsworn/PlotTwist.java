package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.Table;
import minim.model.Character;

public class PlotTwist extends Table {
	public PlotTwist() {
		super("Plot twist");
	}

	@Override
	public void build() {
		add(List.of("It was all a diversion", "A dark secret is revealed", "A trap is sprung",
				"An assumption is revealed to be false", "A secret alliance is revealed",
				"Your actions benefit an enemy", "Someone returns unexpectedly", "A more dangerous foe is revealed",
				"You and an enemy share a common goal", "A true identity is revealed",
				"You are betrayed by someone who was trusted", "You are too late", "The true enemy is revealed",
				"The enemy gains new allies", "A new danger appears", "Someone or something goes missing",
				"The truth of a relationship is revealed",
				"Two seemingly unrelated situations are shown to be connected",
				"Unexpected powers or abilities are revealed"));
	}

	@Override
	public String roll() {
		var result = super.roll();
		if (Character.roll(20) == 1)
			result += " and " + super.roll().toLowerCase();
		return result;
	}
}
