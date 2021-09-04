package minim.controller.table.darkness;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Changeling extends Table {
	public static final String SIDHE = "Sidhe";
	public static final Table KITHAIN = new SimpleTable("Changeling (kith, kithain)",
			List.of("Boggasn", "Eshu", "Nockers", "Pooka", "Redcaps", "Satyrs", SIDHE, "Sluagh", "Trolls"));
	public static final Table GALLAIN = new SimpleTable("Changeling (kith, gallain)",
			List.of("Clurichaun", "Ghille dhu", "Korred", "Merfolk", "Morganed", "Piskies", "River Hags", "Selkies",
					"Swan maidens", "Wichtel", "Wolpertinger"));
	public static final Table ADHENE = new SimpleTable("Changeling (kith, adhene)",
			List.of("Acheri", "Aonides", "Fir-bholg", "Fuath", "Keremet", "Moirae", "Naraka"));
	public static final Table HSIEN = new SimpleTable("Changeling (kith, hsien)", List.of("Chu-ih-yu", "Chu Jung",
			"Fu Hsi", "Hanumen", "Heng Po", "Hou-chi", "Komuko", "Nyan", "Suijen", "Tanuki"));
	public static final Table INANIMAE = new SimpleTable("Changeling (kith, inanimae)",
			List.of("Glomes", "Kuberas", "Mannikins", "Ondines", "Parosemes", "Solimonds"));
	public static final Table NUNNEHI = new SimpleTable("Changeling (kith, nunnehi)",
			List.of("Canotili", "Inua", "Kachina", "May-may-gway-shi", "Nanehi", "Nümüzo'ho", "Pu'gwis", "Rock Giant",
					"Surem", "Thought-crafter", "Tunghat", "Water Baby", "Yunwi Amai'yine'hi", "Yunwi Tsundsi"));
	public static final Table THALLAIN = new SimpleTable("Changeling (kith, thallain)",
			List.of("Aithu", "Beastie", "Bodach", "Boggart", "Bogie", "Ghast", "Goblin", "Huaka'i Po", "Kelpies",
					"Lurks", "Mandragora", "Murdhuacha", "Nasties", "Night Hag", "Ogre", "Sevartal", "Skinwalker",
					"Spriggan", "Weeping Wights"));
	public static final Table KITH = new SimpleMetaTable("Changeling (kith)",
			List.of(KITHAIN, GALLAIN, ADHENE, HSIEN, INANIMAE, NUNNEHI, THALLAIN));
	public static final String SEELIE = "Seelie";
	static final String UNSEELIE = "Unseelie";
	public static final Table COURT = new Table("Changeling (court)") {
		@Override
		public void build() {
			add(5, SEELIE);
			add(5, UNSEELIE);
			add(1, "Shadow");
		}
	};
	public static final Table SEELIEHOUSES = new SimpleTable("Changeling (house, seelie)",
			List.of("Beaumayn", "Dougal", "Eiluned", "Fiona", "Gwydion", "Liam", "Scathach"));
	public static final Table UNSEELIEHOUSES = new SimpleTable("Changeling (house, unseelie)",
			List.of("Aesin", "Ailil", "Balor", "Daireann", "Leanhaun", "Varich", "Scathach"));
	public static final Table HOUSES = new SimpleMetaTable("Changeling (house)", List.of(SEELIEHOUSES, UNSEELIEHOUSES));

	public Changeling() {
		super("Changeling");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		var k = l.add("Kith", KITH);
		var c = l.add("Court", COURT);
		if (k == SIDHE || Character.roll(10) == 10) {
			if (c == SEELIE)
				l.add("House", SEELIEHOUSES);
			else
				l.add("House", UNSEELIEHOUSES);
		}
		return l.toString();
	}
}
