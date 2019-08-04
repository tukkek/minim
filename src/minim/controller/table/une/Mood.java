package minim.controller.table.une;

import minim.controller.table.Table;

public class Mood {
	public static final Table FRIENDLY = new Table("NPC mood (friendly)") {
		@Override
		public void build() {
			add(1, 8, "hostile");
			add(9, 20, "cautious");
			add(21, 40, "neutral");
			add(41, 76, "sociable");
			add(77, 100, "friendly");
		}
	};
	public static final Table NEUTRAL = new Table("NPC mood (neutral)") {
		@Override
		public void build() {
			add(1, 15, "hostile");
			add(16, 30, "cautious");
			add(31, 60, "neutral");
			add(61, 85, "sociable");
			add(86, 100, "friendly");
		}
	};
	public static final Table HOSTILE = new Table("NPC mood (hostile)") {
		@Override
		public void build() {
			add(1, 24, "hostile");
			add(25, 61, "cautious");
			add(62, 81, "neutral");
			add(82, 93, "sociable");
			add(94, 100, "friendly");
		}
	};
}
