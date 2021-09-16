package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Period extends MetaTable {
	public static final Table ANCIENT = new SimpleTable("Time period (ancient)",
			List.of("Bronze age", "Iron age", "Classical antiquity", "Late antiquity"));
	public static final Table MODERN = new SimpleTable("Time period (modern)",
			List.of("Renaissance", "Age of Discovery", "Industrial revolution"));
	public static final Period INSTANCE = new Period();

	Period() {
		super("Time period");
	}

	@Override
	public void build() {
		add(1, "Pre-historic");
		add(2, ANCIENT);
		add(3, "Middle-ages");
		add(4, MODERN);
		add(5, "Present-day");
	}
}
