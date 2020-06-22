package minim.controller.table.adventurecrafter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import minim.controller.table.Table;
import minim.model.Character;

/**
 * An Adventure may have one Plotline or many, it may have a main Plotline and
 * some lesser Plotlines, or they may all be of equal merit. A Plotline develops
 * through an Adventure’s Turning Points.
 * 
 * @author alex
 */
public class Adventure extends Table {
	List<Plotline> plotlines;
	List<TurningPoint> points;
	List<String> themes = new ArrayList<>(List.of("Action", "Tension", "Mystery", "Social", "Personal"));

	public Adventure() {
		super("Adventure");
		rebuild = true;
		build();
	}

	public String gettheme() {
		var roll = Character.roll(10);
		if (roll <= 4)
			return themes.get(0);
		if (roll <= 7)
			return themes.get(1);
		if (roll <= 9)
			return themes.get(2);
		return themes.get(Character.roll(2) == 1 ? 3 : 4);
	}

	@Override
	public void build() {
		Collections.shuffle(themes);
	}

	@Override
	public String roll() {
		var turningpoints = Character.roll(5);
		var adventure = "Themes: " + String.join(" > ", themes);
		for (var i = 0; i < turningpoints; i++) {
			adventure += "\n\nTurning point;\n" + TurningPoint.SINGLETON.roll(this);
		}
		return adventure;
	}
}
