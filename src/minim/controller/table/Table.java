package minim.controller.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import minim.model.Character;

public abstract class Table {
	public String title;
	public List<String> lines = new ArrayList<>(0);

	protected boolean rebuild = false;

	public Table(String title) {
		this.title = title;
	}

	protected void add(int n, String s) {
		for (var i = 0; i < n; i++) {
			lines.add(s);
		}
	}

	protected void add(int from, int to, String s) {
		for (var i = from; i <= to; i++) {
			lines.add(s);
		}
	}

	public abstract void build();

	public String roll() {
		if (rebuild) {
			lines.clear();
			build();
		} else if (lines.isEmpty()) {
			build();
		}
		return lines.get(Character.roll(lines.size()) - 1);
	}

	protected void add(Collection<String> list) {
		lines.addAll(list);
	}

	protected void add(String line) {
		lines.add(line);
	}

	@Override
	public String toString() {
		return title;
	}

	public Set<String> getunique() {
		roll();
		return new HashSet<String>(lines);
	}
}
