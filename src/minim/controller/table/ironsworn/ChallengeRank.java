package minim.controller.table.ironsworn;

import minim.controller.table.Table;

public class ChallengeRank extends Table {
	public ChallengeRank() {
		super("Challenge rank");
	}

	@Override
	public void build() {
		add(1, 2, "Simple");
		add(3, 8, "Typical");
		add(9, 10, "Extreme");
	}
}
