package minim.controller.table.gme;

import minim.controller.table.Table;

public class SceneTwist extends Table {
	public static final SceneTwist SINGLETON=new SceneTwist();
	
	static final Table FIRST=new Table("") {
		@Override
		public void build() {
			add(1,"NPC");
			add(2,"PC");
			add(3,"Organization");
			add(4,"Physical event");
			add(5,"Emotional event");
			add(6,"Item");
		}
	};
	static final Table SECOND=new Table("") {
		@Override
		public void build() {
			add(1,"Appears");
			add(2,"Alters the location");
			add(3,"Helps the hero");
			add(4,"Hinders the hero");
			add(5,"Changes the goal");
			add(6,"Ends the scene");
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
		return FIRST.roll()+" "+SECOND.roll().toLowerCase();
	}
}
