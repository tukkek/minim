package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Enemy extends Table {
	public static final Table WHO = new SimpleTable("Enemy (who)",
			List.of("Ex-friend", "Ex-lover", "Relative", "Childhood foe", "Subordinate", "Superior", "Colleague",
					"Gang member", "Corporate executive", "Government official"));
	public static final Table WHY = new SimpleTable("Enemy (why)",
			List.of("Hurt reputation", "Loss of someone important", "Embarassment", "Insult", "Physical injury",
					"Desertion or betrayal", "Turned down offer", "Didn't like each other", "Romantic competitor",
					"Foiled a plan"));
	public static final Table DIRECTION = new Table("Enemy (direction)") {
		@Override
		public void build() {
			add(1, 4, "They hate you");
			add(5, 7, "You hate them");
			add(8, 10, "Mutual hatred");
		}
	};
	public static final Table ACTION = new SimpleTable("Enemy (what you gonna do?)",
			List.of("Kill enemy", "Avoid enemy", "Backstab enemy", "Ignore enemy", "Humiliate enemy"));
	public static final Table FORCES = new Table("Enemy (forces)") {
		@Override
		public void build() {
			add(1, 3, "Just himself");
			add(4, 5, "A few friends");
			add(6, 7, "A gang");
			add(8, "Small corporation");
			add(9, "Large corporation");
			add(10, "Government agency");
		}
	};

	public Enemy() {
		super("Enemy");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var enemy = WHO.roll();
		enemy += "\nWhy? " + WHY.roll();
		enemy += "\n" + DIRECTION.roll();
		enemy += "\nWhat you gonna do about it? " + ACTION.roll();
		enemy += "\nEnemy forces: " + FORCES.roll();
		return enemy;
	}
}
