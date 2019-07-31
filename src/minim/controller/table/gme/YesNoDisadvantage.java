package minim.controller.table.gme;

import minim.controller.table.Table;

public class YesNoDisadvantage extends Table {
	public YesNoDisadvantage() {
		super("Yes/No (simple, advantage)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return "Select best:\n" + YesNo.SINGLETON.roll() + "\n" + YesNo.SINGLETON.roll();
	}
}
