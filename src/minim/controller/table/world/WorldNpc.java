package minim.controller.table.world;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

/**
 * Built using semi-extensive real-world data.
 * 
 * @author alex
 */
public class WorldNpc extends Table {
	static final String ATHEIST = "Atheist";
	static final String STRAIGHT = "Straight";

	static public final Table AGE = new Table("Age") {
		@Override
		public void build() {
			add(1, "Baby");
			add(1, "Child");
			add(1, "Teenager");
			add(4, "Adult");
			add(2, "Middle-aged");
			add(1, "Old");
		}
	};
	static public final Table SEX = new SimpleTable("Sex", List.of("Male", "Female"));

	static public final Table RACE = new Table("Race") {
		@Override
		public void build() {
			add(3, "White");
			add(2, "Latino");
			add(2, "Asian");
			add(1, "Black");
			add(1, "Indian");
			add(1, "Arab");
		}
	};

	static public final Table SEXUALITY = new Table("Sexuality") {
		@Override
		public void build() {
			add(9 * 2, STRAIGHT);
			add(1, "Homosexual");
			add(1, "Bisexual");
		}
	};

	static public final Table RELIGION = new Table("Religion") {
		@Override
		public void build() {
			add(3, "Christian");
			add(2, "Muslim");
			add(2, ATHEIST);
			add(1, "Hindu");
			add(1, "Shamanic");
			add(1, "Buddhist");
		}
	};

	public WorldNpc() {
		super("NPC");
	}

	@Override
	public void build() {
		// see sub-tables
	}

	@Override
	public String roll() {
		var npc = AGE.roll() + " ";
		var religion = RELIGION.roll();
		if (religion != ATHEIST) {
			npc += religion + " ";
		}
		var orientation = SEXUALITY.roll();
		if (orientation != STRAIGHT) {
			npc += orientation + " ";
		}
		npc += RACE.roll() + " ";
		npc += SEX.roll();
		return npc.toLowerCase();
	}
}
