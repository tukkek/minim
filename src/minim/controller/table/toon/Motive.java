package minim.controller.table.toon;

import minim.controller.table.Table;

public class Motive extends Table {
	public static final Motive SINGLETON = new Motive();

	Motive() {
		super("Motive");
	}

	@Override
	public void build() {
		add(1, "money");
		add(2, "fame");
		add(3, "fun");
		add(4, "love");
		add(5, "food");
		add(6, "all of the above");
	}
}
