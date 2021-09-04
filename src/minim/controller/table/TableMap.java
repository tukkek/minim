package minim.controller.table;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
public class TableMap extends HashMap<String, Table> {
	public TableMap(List<Table> tables) {
		for (var t : tables)
			put(t);
	}

	public TableMap() {
		super();
	}

	public void put(Table t) {
		put(t.title, t);
	}

	public void put(List<Table> tables) {
		for (var t : tables)
			put(t);
	}
}
