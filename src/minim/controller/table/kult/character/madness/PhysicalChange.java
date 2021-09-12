package minim.controller.table.kult.character.madness;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;

public class PhysicalChange extends SimpleMetaTable {
	public static final PhysicalChange INSTANCE = new PhysicalChange();

	PhysicalChange() {
		super("Madness (reaction, physical change)",
				List.of(new SimpleTable("Sex", List.of("Angrodynous", "Sex change")),
						new SimpleTable("Size", List.of("Dwarf size", "Giant size")),
						new SimpleTable("Extra body",
								List.of("Extra arms", "Extra legs", "Extra eyes", "Extra mouths", "Extra genitalia",
										"Tentacles")),
						new SimpleTable("Aquatic", List.of("Gills", "Fish scales", "Webbed hands and feet")),
						new SimpleTable("Bestial", List.of("Claws", "Fangs")),
						new SimpleTable("Mechanical",
								List.of("Mechanical arms", "Mechanical legs", "Steel claws", "Steel teeth")),
						new SimpleTable("Purgatoriees",
								List.of("Hooks throught the body", "Needles throught the body", "No skin",
										"Constantly growing, itching skin scurf", "Worms in your flesh")),
						new SimpleTable("Disease", List.of("Boils", "Rashes"))));
	}

	@Override
	public void build() {
		super.build();
		add(List.of("Extreme hair growth", "Shape change", "Horns", "Hornlike skin", "Rotting flesh", "Tail",
				"Wounds that won't heal", "Supernatural tattoos"));
	}
}
