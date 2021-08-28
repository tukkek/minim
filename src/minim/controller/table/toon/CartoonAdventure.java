package minim.controller.table.toon;

import java.util.Collections;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class CartoonAdventure extends Table {
	static abstract class Situation extends Table {
		public Situation(String title) {
			super(title);
			rebuild = true;
		}
	}

	public static final Situation MYSTERY = new Situation("Cartoon adventure (mystery)") {
		@Override
		public void build() {
			String character = minim.controller.table.toon.Character.SINGLETON.roll();
			String location = Location.SINGLETON.roll();
			String object = Object.SINGLETON.roll();
			String badguy = BadGuy.SINGLETON.roll();
			String secret = new Table("secret") {
				@Override
				public void build() {
					add(1, 2, location + " is plagued by Species");
					add(3, object + " is cursed");
					add(4, object + " has monstrous guardian");
					add(5, 6, badguy + " has cartoony thing of your choice");
				}
			}.roll();
			add("Players sent by " + character + " to investigate " + location + " and find " + object + " before "
					+ badguy + " does.\n" + secret);
		}
	};

	public static final Situation THEFT = new Situation("Cartoon adventure (theft)") {
		@Override
		public void build() {
			String location = Location.SINGLETON.roll();
			String object = Object.SINGLETON.roll();
			String motive = Motive.SINGLETON.roll();
			String secret = new Table("secret") {
				@Override
				public void build() {
					var objectsecret = new SimpleTable("objectsecret",
							List.of("changed into another object", "changed into a trap", "changed into a living thing",
									"hidden", "occupied by species", "eating by species"));
					add(1, 2, "\n" + object + " has been " + objectsecret.roll());
					add(3, 4, "\n" + object + " is held by " + BadGuy.SINGLETON.roll());
					add("\n" + String.join(". ", lines));
					add("");
				}
			}.roll();
			add("Players go to " + location + " to steal " + object + " thereby gaining " + motive + "." + secret);
		}
	};

	public static final Situation CHASE = new Situation("Cartoon adventure (chase)") {
		@Override
		public void build() {
			String badguy = BadGuy.SINGLETON.roll();
			String location = Location.SINGLETON.roll();
			String object = Object.SINGLETON.roll();
			String character = minim.controller.table.toon.Character.SINGLETON.roll();
			var secret = new Table("secret") {
				@Override
				public void build() {
					add(badguy + " has multiple personalities");
					add(badguy + " has strange companion or familiar");
					add(location + " changes from scene to scene");
					add(object + " is really strange");
					Collections.shuffle(lines);
					add(5, 6, String.join(" ", lines.subList(0, Character.roll(lines.size()))));
				}
			}.roll();
			add("Players chase " + badguy + " to " + location + " to get " + object + " for " + character + ".\n"
					+ secret);
		}
	};

	public static final Situation BATTLE = new Situation("Cartoon adventure (battle)") {
		@Override
		public void build() {
			String badguy = BadGuy.SINGLETON.roll();
			String location = Location.SINGLETON.roll();
			String over = new Table("over") {
				@Override
				public void build() {
					add(List.of("ownership of " + location, "possession of " + Object.SINGLETON.roll(),
							"competing business", "personal feud",
							"relationship with " + minim.controller.table.toon.Character.SINGLETON.roll(),
							"desire for " + Motive.SINGLETON.roll()));
				}
			}.roll();
			add("Players fight " + badguy + " in " + location + " over " + over);
		}
	};

	public static final Situation RESCUE = new Situation("Cartoon adventure (rescue)") {
		@Override
		public void build() {
			var character = minim.controller.table.toon.Character.SINGLETON.roll();
			var badguy = BadGuy.SINGLETON.roll();
			var location = Location.SINGLETON.roll();
			var secret = new Table("secret") {
				@Override
				public void build() {
					add("\n" + character + " doesn't want to be rescued");
					add("\n" + character + " owns " + location);
					add("\n" + character + " is another " + badguy);
					add("\n" + character + " is actually holding " + badguy);
					add(5, 6, "");
				}
			}.roll();
			add("Players must rescue " + character + " held by " + badguy + " in " + location + "." + secret);
		}
	};

	public static final Situation SURVIVAL = new Situation("Cartoon adventure (survival)") {
		@Override
		public void build() {
			var location = Location.SINGLETON.roll();
			var badguy = BadGuy.SINGLETON.roll();
			var goal = new SimpleTable("goal", List.of("survive", "get home")).roll();
			var secret = new Table("secret") {
				@Override
				public void build() {
					add(1, 3, "\n" + badguy + " wants " + Object.SINGLETON.roll() + " in player's posession");
					add(4, 6, "");
				}
			}.roll();
			add("Players trapped in a " + location + " are bothered by " + badguy + " as they attempt to " + goal + "."
					+ secret);
		}
	};

	public CartoonAdventure() {
		super("Cartoon adventure");
	}

	@Override
	public void build() {
		// dynamic
	}

	@Override
	public String roll() {
		var die = Character.roll(6);
		if (die == 1)
			return SURVIVAL.roll();
		if (die == 2)
			return RESCUE.roll();
		if (die == 3)
			return BATTLE.roll();
		if (die == 4)
			return CHASE.roll();
		if (die == 5)
			return THEFT.roll();
		return MYSTERY.roll();
	}
}
