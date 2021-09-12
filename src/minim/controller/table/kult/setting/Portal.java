package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.MetaTable;

public class Portal extends MetaTable {
	public static final String ACHLYS = "Achlys (void beyond timespace, chaos)";
	public static final Portal INSTANCE = new Portal("");
	public static final Portal LOWER = new Portal(" (lower)") {
		@Override
		public int rolldie() {
			return Math.min(super.rolldie(), super.rolldie());
		}
	};
	public static final Portal HIGHER = new Portal(" (higher)") {
		@Override
		public int rolldie() {
			return Math.max(super.rolldie(), super.rolldie());
		}
	};

	Portal(String suffix) {
		super("Portal" + suffix);
	}

	@Override
	public void build() {
		add(ACHLYS);
		for (var to : List.of(Inferno.INSTANCE, Metropolis.LABYRINTH, Metropolis.INSTANCE, Metropolis.CITADELS,
				Dream.INSTANCE, Elysium.INSTANCE))
			add(to);
	}
}
