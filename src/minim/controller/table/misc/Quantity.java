package minim.controller.table.misc;

import minim.controller.table.Table;

/** Concept by EagleFire. */
public class Quantity extends Table {
	public Quantity() {
		super("Quantity");
	}

	@Override
	public void build() {
		add(1, 1, "Extremely low");
		add(2, 4, "Low");
		add(5, 8, "Average");
		add(9, 11, "High");
		add(12, 12, "Extremely high");
	}
}
