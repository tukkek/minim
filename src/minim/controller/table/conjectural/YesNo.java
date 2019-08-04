package minim.controller.table.conjectural;

import minim.controller.table.Table;

public class YesNo extends Table {
	public static YesNo SINGLETON = new YesNo();

	YesNo() {
		super("Yes/No (simple)");
	}

	@Override
	public void build() {
		add(1, "No and...");
		add(2, "No");
		add(3, "No but...");
		add(4, "Yes and...");
		add(5, "Yes");
		add(6, "Yes but...");
	}
}
