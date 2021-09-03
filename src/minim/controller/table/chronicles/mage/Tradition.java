package minim.controller.table.chronicles.mage;

import java.util.List;

import minim.controller.table.Table;

public class Tradition extends Table {
	public static final Tradition INSTANCE = new Tradition();

	Tradition() {
		super("Mage (tradition)");
	}

	@Override
	public void build() {
		add(2, "Order of Hermes");
		add(List.of("Akashic broterhood", "Celestial chorus", "Dreamspeakers", "Verbena", "Cult of ecstacy",
				"Virtual adepts", "Sons of ether", "Euthanatos"));
	}
}
