package minim.controller.table.mythic;

import minim.controller.table.Table;

public class SceneChaos extends Table {
	public static SceneChaos LOW = new SceneChaos("low chaos", 3);
	public static SceneChaos NORMAL = new SceneChaos("even chaos", 5);
	public static SceneChaos HIGH = new SceneChaos("high chaos", 8);

	int chaos;

	SceneChaos(String description, int chaos) {
		super("Scene chaos (" + description + ")");
		this.chaos = chaos;
	}

	@Override
	public void build() {
		add(1, chaos, "Altered scene (alter scene to some degree)");
		add(1, chaos, "Interrupted scene (entirely new scene instead)");
		add(1, 2 * (10 - chaos), "Normal scene");
	}
}
