package minim.controller.table.toon;

import minim.controller.table.Table;

public class Motive extends Table {
	public static final Motive SINGLETON = new Motive();

	Motive() {
		super("Motive");
	}

	@Override
	public void build() {
		add("money");
		add("fame");
		add("fun");
		add("love");
		add("food");
		add("all of the above");
	}
}
