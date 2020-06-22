package minim.controller.table.adventurecrafter;

import java.util.List;
import java.util.TreeMap;

import minim.controller.table.Table;

/**
 * A Plot Point is the bas basic building block of everything that happens in
 * The Adventure Crafter.
 * 
 * @author alex
 */
public class PlotPoint extends Table {
	public static final Table THEME = new Table("Plot point (theme)") {
		@Override
		public void build() {
			add(1, 4, "First priority");
			add(5, 7, "Second priority");
			add(8, 9, "Thired priority");
			add(10, "Fourth or fifth priority");
		}
	};
	public static final Table META = new Table("Plot point (meta)") {

		@Override
		public void build() {
			add(1, 18, "Character leaves");
			add(19, 27, "Character returns");
			add(28, 36, "Gain prominence");
			add(37, 55, "Lose prominence");
			add(56, 73, "Upgrade");
			add(74, 82, "Downgrade");
			add(83, 100, "Plot combo (add another plotline to this turning point)");
		}
	};
	public static final Table ACTION = new Table("Plot point (action)") {
		@Override
		public void build() {
			add(1, 8, "Conclusion (end plotline or ignore)");
			add(9, 24, "None (skip or reroll if only 2 turning points left)");
			add(96, 100, "Meta plot point (roll table)"); // TODO
			add(List.of("Collateral damage", "Catastrophe", "Clever idea", "Getting away", "Distraction", "Exotic",
					"System failure", "Change teams", "Travelling"));
			for (var l : List.of("Non-lethal attack", "Lethal attack", "Ambush", "Hunted", "Abduction attempt",
					"Immediacy", "Chase", "Escape", "Guards", "Rescue", "Physical contest", "Mass combat", "Victory",
					"Gambit", "Survivor", "Stopped", "Defend?", "Crash", "Physical obstacle", "Double down", "Theft",
					"Calamity", "Cessation", "Frantic", "Sneaking", "Peace", "Arrived first", "Confront", "Protect",
					"Crescendo", "Break")) {
				add(1, 2, l);
			}

		}
	};
	public static final Table TENSION = new Table("Plot point (tension)") {
		@Override
		public void build() {
			add(1, 8, "Conclusion (end plotline or ignore)");
			add(9, 24, "None (skip or reroll if only 2 turning points left)");
			add(96, 100, "Meta plot point (roll table)"); // TODO
			add(List.of("Vulnerability", "Rural", "New enemy", "Travel", "Change team", "Fortify", "Hidden threat",
					"Standoff", "Quiet catastrophe", "Gambit", "Victory", "Crash", "Menace", "Enemy", "Exposed",
					"Lose-lose", "Suspect", "Dead", "Guards", "Secret weapon", "Deadend", "Incapacitated", "Betrayed",
					"Immediate", "Exotic", "Lawbreaker", "Bad choice", "Hunted", "Disappears", "Escaping", "Horrific",
					"Catastrophe", "Remote area", "Threat", "Collateral damage", "Crime", "Doom", "Low resources"));
			for (var l : List.of("Creepy", "Abandon", "Bad news", "Low on resources", "Low on time", "Trap", "Followed",
					"Hide", "Disarmed", "Stuck", "Problem returns", "Survior", "Penalized", "Night", "Revenge",
					"Shady area", "Unknown")) {
				add(1, 2, l);
			}
		}
	};
	public static final Table MYSTERY = new Table("Plot point (mystery)") {
		@Override
		public void build() {
			add(1, 8, "Conclusion (end plotline or ignore)");
			add(9, 24, "None (skip or reroll if only 2 turning points left)");
			add(96, 100, "Meta plot point (roll table)"); // TODO
			add(List.of("Not working", "Lucky break", "Revelation", "Clue", "Exotic", "Found", "Watch", "Weapon",
					"Uncharacteristic", "Dead", "Information leak", "Doubtful", "Crash", "Independent",
					"Mysterious object", "Wipe clean", "Framed", "Improbable", "Travelling", "Old deal",
					"Mysterious character", "Rural", "Vulnerable", "Conspiracy", "Revelation"));
			for (var l : List.of("Unknown", "Information", "Crime", "Disappeared", "Resource gone", "Knowledge",
					"Lie exposed", "Crime", "Secret", "Lie", "Solved", "Suspect", "Evidence", "Plot thickens", "Clue",
					"Tying together", "Key", "Agenda", "Strings", "Threat", "Wrong place", "Fraud", "Here first")) {
				add(1, 2, l);
			}
		}
	};
	public static final Table SOCIAL = new Table("Plot point (social)") {
		@Override
		public void build() {
			add(1, 8, "Conclusion (end plotline or ignore)");
			add(9, 24, "None (skip or reroll if only 2 turning points left)");
			add(96, 100, "Meta plot point (roll table)"); // TODO
			add(List.of("Servant", "Social tension", "Confrontation", "Chaos", "Rural", "old dead", "Escort mission",
					"Travel", "Power", "Conflict", "Discussion", "Innocence", "Religion", "Standoff", "Independent",
					"Bare minimum", "Enemies", "Suspect", "Lie", "Watch", "Scapegoat", "Fame", "Bad behavior",
					"High spirits", "Rare"));
			for (var l : List.of("Argument", "Business", "Corruption", "Manipulation", "Alliance", "Preparation",
					"Celebration", "Injustice", "Government", "Reinforcements", "Savior", "Leader", "Public area",
					"Trouble", "Urban area", "Work", "Suburb", "Headquarters", "Organization", "Revenge", "Sold",
					"Outcast")) {
				add(1, 2, l);
			}
		}
	};
	public static final Table PERSONAL = new Table("Plot point (personal)") {
		@Override
		public void build() {
			add(1, 8, "Conclusion (end plotline or ignore)");
			add(9, 24, "None (skip or reroll if only 2 turning points left)");
			add(96, 100, "Meta plot point (roll table)"); // TODO
			add(List.of("Threat", "Revenge", "Bad choice", "Humiliation", "Watch", "Headquarters", "Past", "Good",
					"Disarm", "Innocence", "Framed", "Friends", "Untouchable", "Bribe", "Assistance", "It's personal",
					"Like", "Reward", "Promise", "Knowledge"));
			for (var l : List.of("Persusasion", "Ill will", "Outlaw", "Duty", "Connection broken", "Betrayed",
					"Incapacitated", "Home", "Family", "Reduced", "Enemies", "Mercy", "Crownless", "Help", "Prize",
					"You", "Connection", "Talk", "Harm", "Prepare", "Pleading", "Mundane", "Run!", "Protect",
					"Servant")) {
				add(1, 2, l);
			}
		}
	};
	public static final TreeMap<String, Table> THEMES = new TreeMap<>();

	static {
		THEMES.put("action", ACTION);
		THEMES.put("mystery", MYSTERY);
		THEMES.put("social", SOCIAL);
		THEMES.put("personal", PERSONAL);
		THEMES.put("tension", TENSION);
	}

	public static final PlotPoint SINGLETON = new PlotPoint();

	public PlotPoint() {
		super("Plot point");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return roll(new Adventure());
	}

	public String roll(Adventure a) {
		return THEMES.get(a.gettheme().toLowerCase()).roll();
	}
}
