package minim.controller.table;

import java.util.List;

public abstract class MetaTable extends Table {
	public static class SimpleMetaTable extends MetaTable {
		public SimpleMetaTable(String title, List<Table> tables) {
			super(title);
			this.tables.put(tables);
		}

		@Override
		public void build() {
			for (var t : tables.keySet())
				add(t);
		}
	}

	TableMap tables = new TableMap();

	public MetaTable(String title) {
		super(title);
	}

	@Override
	public String roll() {
		var r = super.roll();
		var t = tables.get(r);
		return t == null ? r : t.roll();
	}

	protected void add(int n, Table t) {
		tables.put(t);
		super.add(n, t.title);
	}

	protected void add(int from, int to, Table t) {
		tables.put(t);
		super.add(from, to, t.title);
	}

	protected void add(Table t) {
		tables.put(t);
		super.add(t.title);
	}
}
