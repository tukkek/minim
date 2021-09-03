package minim.controller.table.chronicles.mage;

import minim.controller.table.Table;

public class Faction extends Table {
	public static final Table INSTANCE = new Faction();
	public static final String TRADITIONS = "Traditions";
	public static final String TECHNOCRACY = "Technocracy";
	public static final String MARAUDERS = "Marauders";
	public static final String NEPHANDI = "Nephandi";
	public static final String ORPHANS = "Orphans";

	Faction() {
		super("Mage (faction)");
	}

	@Override
	public void build() {
		add(3, TRADITIONS);
		add(4, TECHNOCRACY);
		add(1, MARAUDERS);
		add(1, NEPHANDI);
		add(1, ORPHANS);
	}
}
