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
	public static final String PLATOON = "Platoon (more tired and hopeless than hostile, has an insane leader)";
	public static final Table LABYRINTH = new SimpleTable("Metropolis (underground)", List.of(
			"Hatching chamber (for Razide larvae, black worms coming out of blackeggs in low-ceiling, bare-rock rooms deep in Metropolis and near Inferno)",
			"Ktonor (eternally-dark-city underneath where the formless Blind Bull guards the entrance to the Inner Labyrinth)",
			"Metromorte (all encompassing subway necro-train)",
			"Cave (partially submerged in poisonous and radioactive pools))", "Military checkpoint",
			"Catacombs (inhabited by undead skeletons and zombies, often entombed and reaching out)",
			"Genetide (radioactive tentacled-humanoids)",
			"agentii (radioactive soldiers, either killed by or victims of radiation, or those who spread it to the enemy)",
			"Fekkuzer mating grounds (parasites that can possess and manipulate individual body parts, driving prey to their pools)",
			PLATOON)) {
		@Override
		public void build() {
			super.build();
			City.UNDERGROUND.setup();
			add(City.UNDERGROUND.lines);
		}
	};
	public static final Table LIVINGCITY = new SimpleTable("Metropolis (The Living City)", List.of(
			"The Slums (closest are of Metropolis to the real-world with deformed animals, crime and police, everything much more distant than it seems)",
			"The Bazaar (crowded eastern market district, with aritfacts, information and weapons; artists and pick-pockets; drugs, sex and slaves)",
			"Trench Town (close to reality as The Slums but darker, with crime lords, diseases and no infrastructure)",
			"The Garbage Dump (inhabited by semi-humans and monstrous vermin)",
			"Industrial Site (desolate concrete, steel and hammering machinery, workers come in the morning and leave at night going deep into the dark undergroud, mafia and stolen goods)",
			"The pub"));
	public static final Table RUINS = new SimpleTable("Metropolis (The Ruins)", List.of("Wrecking yard ruin",
			"Construction site ruin",
			"Harbor (where a mysterious lighthouse guarded by the Watchmen attracts lost ships from the real-world)",
			"Wartorn citiscape ruin", "Ruin of ancient buildings", "Car graveyeard", "Radioactive zone",
			"Tribal salt desert", "Bombed highway", "Collapsing bridge", "Collapsing building", "Minefield",
			"Trench battlefield",
			"Melting street (the concrete slowly turns into lava, potentially devouring the buildings nearby)",
			"Earthquake ritual (shamanic dance that generates real-world quakes that bring victims to be eaten)", "War",
			"Sudden hunger kicks in", "Fire, arson, inferno", "Hard-to-access cable car leading to an uppper plane",
			"Hard-to-access cable car leading to a lower plane",
			"Urban swamp (pavement decays into a mud-like substance)", PLATOON));
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
		for (var t : List.of(CITADELS, Being.BORDERLINER, METROPOLITAN, LIVINGCITY, RUINS))
			add(t);
		for (var section : List.of("Anachronistic city", "Real-world city", "The Maze (Escher-like)",
				"Hunting Grounds (most worn part of Metropolis, full of Wolvens and some Ferocci)", MACHINECITY,
				CITYOFTHEDEAD))
			add(10, section);
		add(10, LABYRINTH);
	}
}
