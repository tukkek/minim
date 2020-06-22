package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Lifepath extends Table {
	public static final Table ETHNICITY = new SimpleTable("Ethnicity", List.of("Anglo-american", "African", "Asian",
			"East european / russian", "Polynesian", "Indian", "South american", "Hispanic", "European"));

	public Lifepath() {
		super("Lifepath");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var lifepath = Style.SINGLETON.roll();
		lifepath += "\nEthnicity: " + ETHNICITY.roll();
		var age = 16 + Character.roll(6) + Character.roll(6);
		lifepath += "\nAge: " + age;
		lifepath += "\n\nFamily\n" + Family.SINGLETON.roll();
		lifepath += "\n\nMotivation\n" + LifepathMotivation.SINGLETON.roll() + "\n";
		for (var year = 17; year <= age; year++) {
			var e = LifeEvent.SINGLETON.roll();
			if (!e.isEmpty())
				lifepath += "\nLife event at " + year + ": " + e;
		}
		return lifepath;
	}
}
