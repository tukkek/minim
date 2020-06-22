package minim.controller.table.bold;

import minim.controller.table.Table;

public class ArcedWaylay extends Table {
	public ArcedWaylay() {
		super("Arced waylay");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var arc = "Theme: " + Waylay.SINGLETON.roll(false);
		arc += "\n\nExposition: " + Waylay.SINGLETON.roll();
		arc += "\n\nRising action and conflict: " + Waylay.SINGLETON.roll();
		arc += "\n\nClimax :" + Waylay.SINGLETON.roll();
		return arc;
	}
}
