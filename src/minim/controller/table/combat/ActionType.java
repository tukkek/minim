package minim.controller.table.combat;

import minim.controller.table.Table;

public class ActionType extends Table {
	public static final String NEW = "New action";
	public static final String TWIST = "Twist";
	public static final Table SINGLETON = new ActionType("Action type");

	ActionType(String title) {
		super(title);
	}

	@Override
	public void build() {
		add(1, 5, "Repeat previous action");
		add(6, 9, NEW);
		add(10, 10, TWIST);
	}
}