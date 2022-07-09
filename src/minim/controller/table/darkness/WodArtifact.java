package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class WodArtifact {
	public static final Table VAMPIRE = new SimpleTable("Artifact (Vampire)", List.of("Ankaran Sarcophagus",
			"Eye of Hazimel", "Enochian Sarcophagus", "Enosch Sarcophagus", "Lamp of Constantine", "Sargon Fragment",
			"Sword of Nul", "Sword of Troile", "Tablet of Destiny", "The True Vessel", "Aaron's Feeding Razor",
			"Black Gloves", "Brass Heart Shield", "Concoction of Vitality", "Femur of Toomler", "Giants' Blood",
			"Hand of Conrad", "Ivory Bow", "Jorum of Kinsmanship", "Martinelli's Ring of Clear Thought",
			"Phylactery of Recorded Memory", "Pumping Heart of Nizchetus", "Talbot's Chainsaw",
			"Tongue of Jarthis the Slaver", "Vestment of Vileness", "Argent Baton", "Bloodstones",
			"Cloak of the Abalone", "Elixir of Distillation", "Monocle of Clarity", "Powder of Rigidity",
			"Ring of the Inscrutable Eye", "Rowan Ring", "Tapestry of the Blood", "Waxen Poetica", "Berserker Fang",
			"Blazing Candle", "Blood Pouch", "Gangrel Eye", "Inner Stone", "Sire's Index Finger", "Heart's Desire",
			"Katrina's Cross", "Locke's Computer", "Mirror of Dreams", "Blood Shield", "Kduva's Mask", "Pledge-Sword",
			"Skin of the King", "Vanishing Bead", "Bloodspot Dice", "Malady Pen", "Sword of Dracula", "Ainkurn",
			"The Bell of Ashes", "Blade of Enoch", "Cup of Christ", "Gabriel's Trumpet", "Martyr's Icon", "The Stone",
			"Tyrant's Lash", "Veddartha's Chalice", "Warding Iron", "Wax Seal", "Aaron's Feeding Razor",
			"Agate Talisman", "Amulet of Temporal Perception", "Ancestor's Talisman", "Argent Baton", "Baleful Doll",
			"Banshee Ironwail", "Black Gloves", "Blade of Enoch", "Blood Shield", "Bloodstone",
			"Blood Tears of Kephran", "Bowl of Convergence", "Chalice of Kinship", "Changeling Skin Mask",
			"Cloak of the Abalone", "Codex of the Damned", "Concoction of Vitality", "Crimson Sentinel",
			"Crusader Sword", "Drums of Xipe Totec", "Elixir of Distillation", "Enchanted Marionette", "Erebus Mask",
			"Eye of Hazimel", "Femur of Toomler", "Flaming Candle", "Hand of Conrad", "Heart of Nizchetus", "Ivory Bow",
			"Jar of Skin Eaters", "Joumlon's Axe", "Kali's Fang", "Kduva's Mask", "Living Wood Staff",
			"Martinelli's Ring", "Mokolé Blood", "Monocle of Clarity", "Mummy's Tongue", "Nkishi", "Orb of Ulain",
			"Powder of Rigidity", "Reliquary: Akunanse Remains", "Reliquary: Biaque", "Reliquary: Shango Remains",
			"Reliquary: Trinket", "Ritual Scalpel", "Rowan Ring", "Sargon Fragment", "Seal of Veddartha",
			"Sengir Dagger", "Shaal Fragment", "Shackles of Enkidu", "Shilmulo Tarot", "Signet Ring of King Saul",
			"Sire's Index Finger", "Soul Gem of Etrius", "Sword of Judgment", "Sword of Nuln", "Sword of Troile",
			"Talbot's Chainsaw", "Tapestry of Blood", "Tinglestripe", "Veneficorum Artum Sanguis", "Waxen Poetica",
			"Weirding Stone"));
	public static final Table WRAITH = new SimpleTable("Artifact (Wraith)",
			List.of("Glow", "Return of Death’s Visage", "Shapesense", "Imitate", "Sculpt", "Martialry", "Rend",
					"Bodyshape", "Armory", "Masquer: Lizard Tail", "Masquer: Skinmold", "Masquer: Calcify",
					"Masquer: Desperation’s Lash", "Masquer: Chorus of Throats", "Masquer: Volley",
					"Masquer: Chrysalis", "Masquer: Girding", "Masquer: Cripple", "Masquer: Kiln", "Masquer: Soothe",
					"Deathmasque", "The Shaper's Eye", "Maelstrom Visage", "Shapesense", "Unmarked", "Panoply of Eyes",
					"Gird", "Savage", "Embed"));
	public static final Table MAGE = new SimpleTable("Artifact (Mage)",
			List.of("Enchantment", "Nightmare", "Shadow", "Celestial", "Totem"));
	public static final Table SINGLETON = new SimpleMetaTable("Artifact", List.of(VAMPIRE, WRAITH, MAGE));
}
