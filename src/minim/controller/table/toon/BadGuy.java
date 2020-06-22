package minim.controller.table.toon;

import minim.controller.table.Table;

public class BadGuy extends Table {
	public static final BadGuy SINGLETON = new BadGuy();

	BadGuy() {
		super("Bad guy");
	}

	@Override
	public void build() {
		add(1, "mobster with tough guy");
		add(2, "Foogle");
		add(3, "spy");
		add(4, "mastermind");
		add(5, "witch");
		add(6, "monster");
	}
}
