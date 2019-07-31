package minim.controller.table.adventure;

import java.util.Collections;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Adventure extends Table {
	public Adventure() {
		super("Adventure");
	}

	@Override
	public void build() {
		// dynamic
	}

	@Override
	public String roll() {
		var die = Character.roll(6);
		if (die == 1)
			return survival();
		if (die == 2)
			return rescue();
		if (die == 3)
			return battle();
		if (die == 4)
			return chase();
		if (die == 5)
			return theft();
		return mystery();
	}

	private String mystery() {
		String character = minim.controller.table.adventure.Character.SINGLETON.roll();
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
		return "Players sent by " + character + " to investigate " + location + " and find " + object + " before "
				+ badguy + " does.\n" + secret;
	}

	private String theft() {
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
				add(5, "\n" + String.join(". ", lines));
				add(6, "");
			}
		}.roll();
		return "Players go to " + location + " to steal " + object + " thereby gaining " + motive + "." + secret;
	}

	private String chase() {
		String badguy = BadGuy.SINGLETON.roll();
		String location = Location.SINGLETON.roll();
		String object = Object.SINGLETON.roll();
		String character = minim.controller.table.adventure.Character.SINGLETON.roll();
		var secret = new Table("secret") {
			@Override
			public void build() {
				add(1, badguy + " has multiple personalities");
				add(2, badguy + " has strange companion or familiar");
				add(3, location + " changes from scene to scene");
				add(4, object + " is really strange");
				Collections.shuffle(lines);
				add(5, 6, String.join(" ", lines.subList(0, Character.roll(lines.size()))));
			}
		}.roll();
		return "Players chase " + badguy + " to " + location + " to get " + object + " for " + character + ".\n"
				+ secret;
	}

	private String battle() {
		String badguy = BadGuy.SINGLETON.roll();
		String location = Location.SINGLETON.roll();
		String over = new Table("over") {
			@Override
			public void build() {
				add(List.of("ownership of " + location, "possession of " + Object.SINGLETON.roll(),
						"competing business", "personal feud",
						"relationship with " + minim.controller.table.adventure.Character.SINGLETON.roll(),
						"desire for " + Motive.SINGLETON.roll()));
			}
		}.roll();
		return "Players fight " + badguy + " in " + location + " over " + over;
	}

	private String rescue() {
		var character = minim.controller.table.adventure.Character.SINGLETON.roll();
		var badguy = BadGuy.SINGLETON.roll();
		var location = Location.SINGLETON.roll();
		var secret = new Table("secret") {
			@Override
			public void build() {
				add(1, "\n" + character + " doesn't want to be rescued");
				add(2, "\n" + character + " owns " + location);
				add(3, "\n" + character + " is another " + badguy);
				add(4, "\n" + character + " is actually holding " + badguy);
				add(5, 6, "");
			}
		}.roll();
		return "Players must rescue " + character + " held by " + badguy + " in " + location + "." + secret;
	}

	private String survival() {
		var location = Location.SINGLETON.roll();
		var badguy = BadGuy.SINGLETON.roll();
		var secret = new Table("secret") {
			@Override
			public void build() {
				add(1, 3, "\n" + badguy + " wants " + Object.SINGLETON.roll() + " in player's posession");
				add(4, 6, "");
			}
		}.roll();
		return "Players trapped in a " + location + " are bothered by " + badguy
				+ " as they attempt to survive and/or get home." + secret;
	}
}
