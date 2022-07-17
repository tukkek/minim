package minim.controller.table.conjectural;

import minim.controller.table.Table;

public class YesNoDisadvantage extends Table {
	public YesNoDisadvantage() {
		super("Yes/no (simple, disadvantage)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return YesNoAdvantage.roll((a, b) -> Math.min(a, b));
	}
}
