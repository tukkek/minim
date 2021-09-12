package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Metropolis extends MetaTable {
	public static final List<String> MISSINGARCHONS = List.of("Chokmah", "Chesed", "Hod", "Yesod");
	public static final Table CITADELS = new Table("Metropolis (citadels)") {
		@Override
		public void build() {
			for (var a : Being.ARCHONS) {
				add(10, "Citadel lower floors, %s (mostly empty)".formatted(a));
				add(30, "Citadel higher floors, %s (modern or holy, sparsely guarded by lictors and acrotides)"
						.formatted(a));
				add(1, "Citadel top floors, %s (the Archon's own shape-shifting body, densely populated)".formatted(a));
			}
			for (var a : MISSINGARCHONS)
				add(10, "Abandoned citadel, %s".formatted(a));
		}
	};
	public static final Table LABYRINTH = new Table("Metropolis (underground)") {
		@Override
		public void build() {
			add(10, "The Labyrinth");
			add(1, "Hatching chamber (for Razide larvae)");
			add(1, "Ktonor (eternally-dark-city underneath where the formless Blind Bull guards the entrance to the Inner Labyrinth)");
		}
	};
	public static final String AZGHOUL = "Azghoul (humanity's name-bound, armed and fully-armored ancient slaves";
	public static final String UNDEADSERVANT = "Undead servant of the Dead Gods (looking for a victim to bring to the City of the Dead)";
	public static final Table METROPOLITAN = new SimpleTable("Being (metropolitan)", List.of(
			"Metropolitan human (feral hunter-scavenger, often lost from our world)", AZGHOUL,
			"Wolven (semi-reptilian dire-wolves)", "Ferroco (largy, clumsy camouflaging felines)",
			"Techrones (meek spider-like humans made of steel and plastic, carrying industrial tools for Mechine City maintenance)",
			UNDEADSERVANT, "Achlytides (half-human, half-caterpillar)",
			"Zeloth (skinless humanoids who live in the tunnels beneath the strets and communicate through rattles and clanks on its metal, waiting to ambush surface-dwellers)",
			"Erinyae (swarming pteradons of flesh and black glass, more common near huge structures like the Citadels or the Abyss)",
			"Crustacz (very quick, meter-long, eleven-legged flies that come out of the Abyss during the night and hunt prey with a paralyzing poison)"));
	public static final String CITYOFTHEDEAD = "City of the dead (necropolis inhabited by the shadows of humans who have truly died, inside or among enormous tombstones, mausoleums...)";
	public static final String MACHINECITY = "The Machine City (one huge factory that goes for thousands of miles, mostly shut down, inhabited by Techrones)";
	public static final Metropolis INSTANCE = new Metropolis();

	Metropolis() {
		super("Metropolis");
	}

	@Override
	public void build() {
		add(List.of(
				"Abyss (surrounded by the 10 citadels, a 30-mile-long square hole in the center of Metropolis where the Demiurge's citadel used to be, from where only Astaroth has returned)",
				"Mirror HAlls (arabic section made of glass and mirrors, high above the rest of the city, where time and matter are malleable)",
				"Empty Chapel (white building in the City of the Dead where a shadow Guardian appearead after the Demiurge's disapparance)",
				"Mausoleum of the Dead Gods (located in the City of the Dead, the trapped gods will lure victims in and befriend them - but sooner or later be overtaken by desire, rape, kill and eat them",
				"The Cube (100-meter long cube, with liquids and energy fed to ir via tubes, maintained and venerated by a hundred Achlytides)"));
		for (var t : List.of(CITADELS, Being.BORDERLINER, METROPOLITAN))
			add(t);
		for (var section : List.of("Anachronistic city", "Real-world city", "The Maze (Escher-like)",
				"Hunting Grounds (most worn part of Metropolis, full of Wolvens and some Ferocci)", MACHINECITY,
				CITYOFTHEDEAD))
			add(10, section);
		add(10, LABYRINTH);
	}
}
