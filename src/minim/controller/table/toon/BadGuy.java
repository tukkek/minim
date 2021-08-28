package minim.controller.table.toon;

import minim.controller.table.Table;

public class BadGuy extends Table {
	public static final BadGuy SINGLETON = new BadGuy();

	BadGuy() {
		super("Bad guy");
	}

	@Override
	public void build() {
		add("mobster with tough guy");
		add("Foogle");
		add("spy");
		add("mastermind");
		add("witch");
		add("monster");
	}
}
