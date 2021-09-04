package minim.controller.table;

import java.util.List;

public abstract class MetaTable extends Table {
	TableMap tables;

	public MetaTable(String title, List<Table> tables) {
		super(title);
		this.tables = new TableMap(tables);
	}

	@Override
	public String roll() {
		var r = super.roll();
		var t = tables.get(r);
		return t == null ? r : t.roll();
	}

	protected void add(int n, Table t) {
		super.add(n, t.title);
	}

	protected void add(int from, int to, Table t) {
		super.add(from, to, t.title);
	}

	protected void add(Table t) {
		super.add(t.title);
	}
}
