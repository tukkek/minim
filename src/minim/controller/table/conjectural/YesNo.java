package minim.controller.table.conjectural;

import java.util.List;

import minim.controller.table.Table;

public class YesNo extends Table {
	public static final YesNo SINGLETON = new YesNo();
	public static final String YES = "Yes";
	public static final String NO = "No";
	public static final List<String> RESULTS = List.of("No, plus...", NO, "No, however...", "Yes, however...", YES,
			"Yes, plus...");

	YesNo() {
		super("Yes/no (simple)");
	}

	@Override
	public void build() {
		add(RESULTS);
	}

	public String roll(boolean expand) {
		if (!expand)
			return super.roll();
		return expand(super.roll());
	}

	public static String expand(String roll) {
		if (!roll.contains("..."))
			return roll;
		return roll + " " + SceneTwist.SINGLETON.roll();
	}

	@Override
	public String roll() {
		return roll(true);
	}
}
