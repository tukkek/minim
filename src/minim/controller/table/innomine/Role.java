package minim.controller.table.innomine;

import minim.controller.table.Table;

public class Role extends Table {
	public static final Table INSTANCE = new Role();

	Role() {
		super("Role (status)");
	}

	@Override
	public void build() {
		add(2, "Very low");
		add(4, "Low");
		add(8, "Average");
		add(4, "High");
		add(2, "Very high");
		add(1, "Extremey high");
	}
}
