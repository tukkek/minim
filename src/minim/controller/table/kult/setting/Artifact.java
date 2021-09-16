package minim.controller.table.kult.setting;

import java.util.ArrayList;
import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.controller.table.kult.character.madness.Madness;
import minim.model.Character;

public class Artifact extends MetaTable {
	public static final Table LENSES = new SimpleTable("Artifact (lenses)",
			List.of("Eye-glass", "Enlargment lens", "Camera", "Binocular"));
	public static final String NONE = "None";
	public static final Table PASSWORD = new SimpleTable("Artifact (portal, password)",
			List.of(NONE, "Time-sensitive", "Password", "Ritual"));
	public static final Table DESTINATION = new SimpleTable("Artifact (portal, destination)",
			List.of("Another time", "Another place", "Chaotic")) {
		@Override
		public String roll() {
			return Character.roll(10) == 1 ? super.roll() : Portal.INSTANCE.roll();
		}
	};
	public static final Table PORTAL = new Table("Artifact (portal)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			var characteristics = new ArrayList<String>();
			var p = PASSWORD.roll();
			if (p != NONE)
				characteristics.add(p);
			characteristics.add(Character.roll(3) == 1 ? "two-way" : "one-way");
			var r = "portal to %s".formatted(DESTINATION.roll());
			if (!characteristics.isEmpty()) {
				r = String.join(", ", characteristics) + " " + r;
			}
			return r;
		}
	};
	public static final Table CLOCKWORK = new SimpleTable("Artifact (clockwork)",
			List.of("Large clock", "Wristwatch")) {
		@Override
		public String roll() {
			var effect = Character.roll(3) == 1 ? Portal.INSTANCE : Madness.TIME;
			return super.roll() + ", " + effect.roll();
		}
	};

	public Artifact() {
		super("Artifact");
		rebuild = true;
	}

	@Override
	public void build() {
		var p = Portal.INSTANCE.roll();
		add(1, PORTAL);
		add(2, "Mirror to %s".formatted(p));
		add(3, "Puzzle to %s".formatted(Character.roll(2) == 1 ? Inferno.INSTANCE.roll() : p));
		add(4, Character.roll(2) == 1 ? "Statuette" : "Nepharite statuette");
		add(5, LENSES);
		add(6, "Mirror");
		add(7, CLOCKWORK);
		add(8, "Software, " + Madness.NEUTRAL.roll());
	}
}
