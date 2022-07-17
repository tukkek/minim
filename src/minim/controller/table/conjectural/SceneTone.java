package minim.controller.table.conjectural;

import minim.controller.table.Table;
import minim.model.Character;

public class SceneTone extends Table {
	public SceneTone() {
		super("Scene tone");
	}

	@Override
	public void build() {
		add(1, 3, "Dramatic scene");
		add(4, 5, "Quiet scene");
		add("Meanwhile...");
	}

	@Override
	public String roll() {
		var result = super.roll();
		if (Character.roll(6) == 1)
			result += " (twist: " + SceneTwist.SINGLETON.roll() + ")";
		return result;
	}
}
