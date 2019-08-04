package minim.controller.table.bold;

import java.util.HashMap;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Waylay extends Table {
	public static final Table EASYFOES = new SimpleTable("Waylay (easy foes)",
			List.of("Animals", "Mooks", "Mob", "Bandits", "Deputies"));
	public static final Table HARDFOES = new SimpleTable("Waylay (hard foes)",
			List.of("Bounty hunter", "Soldiers", "Monster", "Villain", "Horror"));
	public static final Table KNOWLEDGE = new SimpleTable("Waylay (knowedge)",
			List.of("Ascetic", "Research", "Occult", "Enigma", "Science"));
	public static final Table PHYSICAL = new SimpleTable("Waylay (physical)",
			List.of("Pursuit", "Trap", "Struggle", "Illness", "Labor"));
	public static final Table FACTIONAL = new SimpleTable("Waylay (factional)",
			List.of("Army", "Invader", "Holdings", "Authority", "Rebels"));
	public static final Table HAVEN = new SimpleTable("Waylay (haven)",
			List.of("Festival", "Hermit", "Tavern", "Hamlet", "Conclave"));
	public static final Table PARTY = new SimpleTable("Waylay (party)",
			List.of("Misunderstanding", "Accusations", "Power play", "Friend-in-need", "Disappearance"));
	public static final Table PERSONAL = new SimpleTable("Waylay (personal)",
			List.of("Traitor", "Lover", "Death", "Relative", "Rival"));
	public static final Table EPIC = new SimpleTable("Waylay (epic)",
			List.of("Heaven / hell", "Afterlife", "Myth", "Otherworldly", "The strange"));
	public static final Table NATURAL = new SimpleTable("Waylay (natural)",
			List.of("Weather", "Straying / lost", "Social environ", "Deprivation", "The wild"));
	public static final Table MODIFIER = new SimpleTable("Waylay modifier",
			List.of("futile", "impassioned", "hesitant", "benign", "revered", "pedantic", "grim", "common", "bitter",
					"impassioned", "perceiving", "selfish", "prohibited", "brusque", "prosperous", "depraved",
					"comforting", "hopeless", "waning", "regimental", "harsh", "leeching", "tranquil", "inclusive",
					"righteous", "attentive", "inexplicable", "corrupt", "roaring", "unmistakable", "sudden",
					"impending", "fragile", "painless", "haphazard", "foreign", "ravenous", "adept", "barbaric",
					"disputable", "binding", "noble", "copious", "retired", "provoking", "ordinary", "prolonged",
					"deceiving", "savage", "drowsy", "mundane", "abrupt", "unforeseen", "peaceful", "steady",
					"abetting", "stale", "regular", "dubious", "exclusive", "unreliable", "altruistic", "storied",
					"tapped", "tedious", "quiet", "exotic", "impervious", "fledgling", "fixated", "illuminating",
					"exhausting", "honorable", "exclusive", "apparent", "valuable", "haunting", "migrant", "pleasant",
					"incompetent", "abnormal", "abstract", "irritating", "hidden", "hallowed", "illusory", "legendary",
					"prolonged", "meek", "proficient", "forbidden", "fantastic", "accidental", "malevolent", "unlikely",
					"problematic", "eccentric", "lethargic", "amusing", "afflicting"));
	public static final Table SOLUTION = new Table("Waylay solution") {
		public HashMap<Integer, String> solutions = new HashMap(20);
		{
			var i = 2;
			for (var solution : List.of("legendary help", "act of nature", "the people", "enemy help", "avoidance",
					"scarce-used ability", "personal resources", "close friend", "strong attribute", "favored ability",
					"favored skill", "on accident", "weak attribute", "counteraction", "faction intervention",
					"the authority", "fate", "change of heart", "deus ex")) {
				solutions.put(i, solution);
				i += 1;
			}
		}

		@Override
		public void build() {
			// don't;
		}

		@Override
		public String roll() {
			return solutions.get(Character.roll(10) + Character.roll(10));
		}
	};

	public static final Waylay SINGLETON = new Waylay();

	Waylay() {
		super("Waylay");
		rebuild = true;
	}

	@Override
	public void build() {
		for (var w : List.of(EASYFOES, HARDFOES, KNOWLEDGE, PHYSICAL, FACTIONAL, HAVEN, PARTY, PERSONAL, EPIC, NATURAL))
			add(w.roll());
	}

	public String roll(boolean solution) {
		var waylay = super.roll() + ".";
		waylay += "\nModifier: " + MODIFIER.roll() + ".";
		if (solution)
			waylay += "\nSolution: " + SOLUTION.roll() + ".";
		return waylay;
	}

	@Override
	public String roll() {
		return roll(true);
	}

}
