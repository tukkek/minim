package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class LifeEvent extends Table {
	static public final Table ACTION = new SimpleTable("Life events (what are you gonna do about it?)",
			List.of("Clear your name;", "Forget it.", "Take tevenge.", "Get what's yours.", "Save everyone involved."));
	static public final Table DISASTER = new Table("Life events (disaster)") {
		@Override
		public void build() {
			add(List.of("Debt", "Imprisonment", "Illness", "Addiction", "Betrayal", "Accident",
					"Lover, friend or relative killed", "False accusation", "Hunted by the law",
					"Hunted by corporation", "Mental or physical incapacitation"));
		}

		@Override
		public String roll() {
			return super.roll() + ". You're gonna " + ACTION.roll().toLowerCase();
		}
	};
	static public final Table LUCKY = new SimpleTable("Life events (luck)",
			List.of("Powerful connection", "Windfall", "Big score", "Found a mentor", "Found a sensei",
					"Friend in corporation", "Friend in nomad pack", "Friend in the police", "Friend in gang"));
	static public final Table BIGPROBLEMSBIGWINS = new Table("Life events (big problems, big wins)") {
		@Override
		public void build() {
			rebuild = true;
			add(DISASTER.roll());
			add(LUCKY.roll());
		}
	};
	static public final Table FRIEND = new SimpleTable("Friend",
			List.of("Like an older sibling", "Like a younger sibling", "Mentor", "Colleague", "Past lover",
					"Past enemy", "Guardian", "Relative", "Past friend", "Through common interest"));
	static public final Table FRIENDSFOES = new Table("Life events (friend or foe)") {
		@Override
		public void build() {
			rebuild = true;
			var gender = Character.roll(10) % 2 == 0 ? "Male" : "Female";
			add(gender + " friend (" + FRIEND.roll().toLowerCase() + ")");
			add(gender + " foe: (roll table)");
		}
	};
	static public final LifeEvent SINGLETON = new LifeEvent();

	LifeEvent() {
		super("Life event");
		rebuild = true;
	}

	@Override
	public void build() {
		add(1, 3, BIGPROBLEMSBIGWINS.roll());
		add(4, 6, FRIENDSFOES.roll());
		add(7, 8, "Romance (roll table)");
		add(9, 10, "");
	}
}
