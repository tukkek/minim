package minim.controller.table.chronicles.mage.social;

import java.util.ArrayList;

import minim.controller.table.Table;
import minim.model.Character;

public class Convention extends Table {
	public static final Table CONSTRUCT = new Table("Mage (social, technocracy convention, construct)") {
		@Override
		public void build() {
			// don't
		}

		@Override
		public String roll() {
			var lines = new ArrayList<String>();
			lines.add("Amalgams: " + (Character.roll(4)));
			lines.add("Mages: " + (Character.roll(10) + Character.roll(10)));
			return String.join(".\n", lines);
		}
	};

	public Convention() {
		super("Mage (social, technocracy convention)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var lines = new ArrayList<String>();
		lines.add("Mages: " + (Character.roll(6) + Character.roll(6)) * 100);
		lines.add("Constructs: " + (Character.roll(6) + Character.roll(6)) * 10);
		return String.join(".\n", lines);
	}
}
