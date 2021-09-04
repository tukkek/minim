package minim.controller.table;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Lines extends ArrayList<String> {
	@Override
	public String toString() {
		return String.join(".\n", this);
	}

	public void add(String header, String value) {
		add("%s: %s".formatted(header, value.toLowerCase()));
	}

	public void add(String header, Table t) {
		add(header, t.roll());
	}
}
