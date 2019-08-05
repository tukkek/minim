package minim.controller.table.adventurecrafter;

import minim.controller.table.Table;
import minim.model.Character;

/**
 * Turning Points are the pivotal Scenes in your Adventure that propel the story
 * along. They are the plot twists within your Adventure. A Turning Point is
 * composed of a group of Plot Points put together.
 * 
 * Each Turning Point is focused on a Plotline and will either create, develop
 * or end it.
 * 
 * @author alex
 */
public class TurningPoint extends Table {
	public static final TurningPoint SINGLETON = new TurningPoint();

	public TurningPoint() {
		super("Turning point");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return roll(new Adventure());
	}

	public String roll(Adventure a) {
		var turningpoint = "Plotline: " + Plotline.SINGLETON.roll();
		var amount = Character.roll(5);
		while (Character.roll(2) == 1)
			amount += 1;
		for (var i = 0; i < amount; i++) {
			turningpoint += "\nPlot point: " + PlotPoint.SINGLETON.roll(a) + ".";
		}
		return turningpoint;
	}
}
