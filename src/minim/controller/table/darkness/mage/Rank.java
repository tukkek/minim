package minim.controller.table.darkness.mage;

import minim.controller.table.Table;

public class Rank extends Table {
	public static final Rank TRADITIONS = new Rank("Mage (rank, traditions)");
	public static final Rank TECHNOCRACY = new Rank("Mage (rank, theocracy)");
	public static final Rank NEṔHANDI = new Rank("Mage (rank, nephandi)", 1, 4, 4, 2);
	public static final Rank MARAUDER = new Rank("Mage (rank, marauder)", 1, 4, 4, 2);
	public static final Rank ORPHAN = new Rank("Mage (rank, orphan)", 1, 3, 2, 1) {
		@Override
		public void build() {
			super.build();
			add(1, "Lone apprentice");
			add(2, "Lone disciple");
			add(1, "Lone adept");
		}
	};

	int apprentice = 1;
	int disciple = 5;
	int adept = 2;
	int master = 2;

	Rank(String title) {
		super(title);
	}

	protected Rank(String title, int apprentice, int disciple, int adept, int master) {
		super(title);
		this.apprentice = apprentice;
		this.disciple = disciple;
		this.adept = adept;
		this.master = master;
	}

	@Override
	public void build() {
		add(apprentice, "Apprentice");
		add(disciple, "Disciple");
		add(adept, "Adept");
		add(master, "Master");
	}
}
