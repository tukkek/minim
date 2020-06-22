package minim.controller.table;

import java.util.List;

public class SimpleTable extends Table {
	public SimpleTable(String title, List<String> lines) {
		super(title);
		this.lines.addAll(lines);
	}

	@Override
	public void build() {
		// don't
	}
}