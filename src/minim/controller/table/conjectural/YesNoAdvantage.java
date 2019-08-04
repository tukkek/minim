package minim.controller.table.conjectural;

import minim.controller.table.Table;

public class YesNoAdvantage extends Table {
	public YesNoAdvantage() {
		super("Yes/No (simple, disadvantage)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return "Select worst:\n" + YesNo.SINGLETON.roll() + "\n" + YesNo.SINGLETON.roll();
	}
}
