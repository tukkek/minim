package minim.controller.table.conjectural;

import minim.controller.table.Table;

public class SceneTwist extends Table {
	public static final SceneTwist SINGLETON = new SceneTwist();

	static final Table FIRST = new Table("") {
		@Override
		public void build() {
			add("NPC");
			add("PC");
			add("Organization");
			add("Physical event");
			add("Emotional event");
			add("Item");
		}
	};
	static final Table SECOND = new Table("") {
		@Override
		public void build() {
			add("Appears");
			add("Alters the location");
			add("Helps the hero");
			add("Hinders the hero");
			add("Changes the goal");
			add("Ends the scene");
		}
	};

	SceneTwist() {
		super("Scene twist");
	}

	@Override
	public void build() {
		FIRST.build();
		SECOND.build();
	}

	@Override
	public String roll() {
		return FIRST.roll() + " " + SECOND.roll().toLowerCase();
	}
}
