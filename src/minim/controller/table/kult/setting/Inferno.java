package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Inferno extends Table {
	public static final Table ASTAROTH = new SimpleTable("Being (Astaroth form)",
			List.of("Antichrist, the Warlord", "The Seducer", "The Beast"));
	public static final String NAHEMOTH = "Nahemoth, the Defiled";
	public static final Table ANGELS = new SimpleTable("Being (Angels of Death)",
			List.of("Thaumiel, the unjust ruler", "Chagidiel, the Bloodstained Patriarch",
					"Sathariel, the Devastating Mother", "Gamichicoth, the False Rescuer", "Golab, the Torturer",
					"Togarini, Protector of the Death Conjurers", "Hareb-Sepap, the Raven of the Battlefields",
					"Samael, the Avenger", "Gamaliel, the Perverted", NAHEMOTH));
	public static final String HELL = "Hell (a sinner's personal purgatory, ruled by a nepharite, always metaphysically super-imposed to the sinner's place of death)";
	public static final String RAZIDE = "Razide of %s (tall, half-living humanoids with a black iron and glass exoskeleton, yellow-red eyes and a metal jaw)";
	public static final Table BEINGS = new Table("Being (inferno)") {
		@Override
		public void build() {
			for (var a : ANGELS)
				add(RAZIDE.formatted(a));
			add("Nepharite (run personal hells for sinners, shape-changing but usually mutilated humans)");
			add(10, "Purgatide (tormented human sinner)");
		}
	};
	public static final Inferno INSTANCE = new Inferno();

	Inferno() {
		super("Inferno");
	}

	@Override
	public void build() {
		for (var circle : List.of("First circle", "Second circle", "Third circle", "Fourth circle", "Fifth circle",
				"Sixth circle", "Seventh circle", "Eigth circle", "Ninth circle"))
			add(10, circle);
		add(10, HELL);
		add(BEINGS.lines);
		for (var a : ANGELS)
			add(1, "Black palace of %s (dark labyrinths down into the deep undeerground)".formatted(a));
		add(1, "Dead sun (terrifying black sun that is rarely glimpsed in Inferno's starless sky)");
	}
}
