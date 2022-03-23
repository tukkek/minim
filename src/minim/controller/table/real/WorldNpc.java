package minim.controller.table.real;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

/**
 * Built using semi-extensive real-world data.
 * 
 * TODO simple height (something like average/tall/short)
 * 
 * @author alex
 */
public class WorldNpc extends Table {
	public static final Table SIMPLE = new WorldNpc("NPC (simple)", true);

	static final String ATHEIST = "Atheist";
	static final String STRAIGHT = "Straight";
	static final String ABLE = "Able";
	static final String NEUROTYPICAL = "Neurotypical";
	static final String HEALTHY = "Healthy";
	static final String INTERMEDIATE = "Intermediate";
	static final Set<String> TYPICAL = Set.of(ATHEIST, STRAIGHT, ABLE, NEUROTYPICAL, HEALTHY, INTERMEDIATE);

	static public final Table AGE = new Table("Age") {
		@Override
		public void build() {
			add(1, "Baby");
			add(1, "Child");
			add(1, "Teenager");
			add(4, "Adult");
			add(2, "Middle-aged adult");
			add(1, "Elder");
		}
	};
	static public final Table SEX = new SimpleTable("Sex", List.of("Male", "Female"));

	static public final Table RACE = new Table("Race") {
		@Override
		public void build() {
			add(3, "White");
			add(2, "Latino");
			add(2, "Asian");
			add(1, "Black");
			add(1, "Indian");
			add(1, "Arab");
		}
	};

	static public final Table SEXUALITY = new Table("Sexuality") {
		@Override
		public void build() {
			add(9 * 2, STRAIGHT);
			add(1, "Homosexual");
			add(1, "Bisexual");
		}
	};

	static public final Table RELIGION = new Table("Religion") {
		@Override
		public void build() {
			add(3, "Christian");
			add(2, "Muslim");
			add(2, ATHEIST);
			add(1, "Hindu");
			add(1, "Shamanic");
			add(1, "Buddhist");
		}
	};

	static public final Table DISABILITY = new Table("Disability") {
		@Override
		public void build() {
			add(5, "Difficulty walking");
			add(1, "Blind");
			add(1, "Deaf");
			add(1, "Wheelchair");
			add(lines.size() * 4, ABLE);
		}
	};

	static public final Table MENTALISSUE = new Table("Mental issues") {
		@Override
		public void build() {
			add(5, "Depression");
			add(4, "Substance abuse");
			add(2, "Anxiety");
			add(1, "Schizophrenia");
			add(1, "Bipolar");
			add(lines.size() * 9, NEUROTYPICAL);
		}
	};

	/*
	 * As of August 2021 (cases per year, relative to population):
	 * 
	 * - Cold: 300%.
	 * 
	 * - Flu: 0.01%.
	 * 
	 * - CoVid: 0.02%.
	 */
	static public final Table HEALTH = new Table("Health issues") {
		@Override
		public void build() {
			add(3, "Hypertension");
			add(1, "Diabetes");
			add(1, "Cardiovascular disease");
			add(1, "Common cold (if cold weather)");
			add(10 - lines.size(), HEALTHY);
		}
	};

	public static final Table CHRONOTYPE = new Table("Chronotype") {
		@Override
		public void build() {
			add(2, "Early bird");
			add(3, "Night owl");
			add(10 - this.lines.size(), INTERMEDIATE);
		}
	};

	protected boolean simple = false;

	public WorldNpc() {
		super("NPC");
	}

	WorldNpc(String title, boolean simple) {
		super(title);
		this.simple = simple;
	}

	@Override
	public void build() {
		// see sub-tables
	}

	@Override
	public String roll() {
		var basic = new ArrayList<String>(3);
		basic.add(SEX.roll());
		basic.add(RACE.roll());
		basic.add(AGE.roll());
		var details = new ArrayList<String>(4);
		for (var table : List.of(RELIGION, SEXUALITY, DISABILITY, MENTALISSUE, HEALTH, CHRONOTYPE)) {
			var line = table.roll();
			if (!TYPICAL.contains(line))
				details.add(line.toLowerCase());
		}
		Personality.TRAITS.stream().filter(t -> t.israre()).map(t -> t.rare.toLowerCase()).forEach(t -> details.add(t));
		if (simple)
			while (details.size() > 2)
				details.remove(Character.roll(details.size() - 1));
		details.sort(null);
		var npc = String.join(" ", basic) + " - " + String.join(", ", details);
		return npc.toLowerCase();
	}
}
