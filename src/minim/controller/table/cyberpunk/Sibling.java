package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Sibling extends Table {
	public static final Table GENDER = new SimpleTable("Sibling (gender)", List.of("brother", "sister"));
	public static final Table AGE = new Table("Sibling (age)") {
		@Override
		public void build() {
			add(1, 5, "Younger");
			add(6, 9, "Older");
			add(10, "Twin");
		}
	};
	public static final Table FEELINGS = new SimpleTable("Sibling (feelings)",
			List.of("dislikes you", "likes you", "neutral", "hates you", "adores you"));

	public static final Sibling SINGLETON = new Sibling();

	Sibling() {
		super("Sibling");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return AGE.roll() + " " + GENDER.roll() + " " + FEELINGS.roll();
	}
}
