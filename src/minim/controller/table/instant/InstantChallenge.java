package minim.controller.table.instant;

import minim.controller.table.Table;

public class InstantChallenge extends Table {
	public InstantChallenge() {
		super("Instant challenge");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var challenge = "Settting:\n" + InstantSetting.SINGLETON.roll();
		challenge += "\n\nPlot:\n" + InstantPlot.SINGLETON.roll();
		challenge += "\n\nExtras: " + Thing.DESCRIPTOR.roll() + ", " + Thing.SINGLETON.roll(false);
		return challenge;
	}
}
