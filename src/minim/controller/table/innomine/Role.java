package minim.controller.table.innomine;

import minim.controller.table.Table;

public class Role extends Table {
	public static final Table STATUS = new Table("Role (status)") {
		@Override
		public void build() {
			add(2, "Very low");
			add(4, "Low");
			add(8, "Average");
			add(4, "High");
			add(2, "Very high");
			add(1, "Extremey high");
		}
	};
	public static final Table FAME = new Table("Role (fame)") {
		@Override
		public void build() {
			add(20, "Nobody");
			add(8, "Small group");
			add(4, "Large group");
			add(2, "Almost everyone");
			add(1, "Everyone");
		}
	};
	public static final Table INSTANCE = new Role();

	public Role() {
		super("Role");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return "%s status, famous to %s".formatted(STATUS.roll().toLowerCase(), FAME.roll().toLowerCase());
	}
}
