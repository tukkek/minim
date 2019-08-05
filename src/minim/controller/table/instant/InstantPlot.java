package minim.controller.table.instant;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class InstantPlot extends Table {
	public static final Table OPPOSITION = new SimpleTable("Instant plot (opposition)",
			List.of("Artifact", "Big Business", "Charismatic Leader", "Common Criminal", "Conspiracy", "Crazed Loner",
					"Demon", "Desperate Citizen", "Deity", "Disease", "Divine Creation", "Doppelganger",
					"Evil Mastermind", "Family", "Force of Nature", "Government Agents", "Hired Muscle", "Immortals",
					"Infestation", "Invaders/Outsiders", "Kingpin", "Law Enforcement", "Machines Gone Mad",
					"Mercenaries", "Military", "Mindless Horde", "Misguided Hero", "Mob", "Movie Monsters", "Mutants",
					"Mythical Legend", "Organized Crime", "Political Group", "Rebels", "Religious Fanatics",
					"Security Forces", "Serial Killer", "Societal Pressure/Custom", "Spy", "Street Gang/Gang Member",
					"The System", "Ticking Time Bomb", "Tragic Villain", "Traitor", "Troubled Youth", "Undead",
					"Underground Pariahs", "Warlord", "Wild Animals", "Yourself"));
	public static final Table ACTION = new SimpleTable("Instant plot (action)",
			List.of("Alert", "Assassinate", "Blackmail", "Brainwash", "Build", "Celebrate", "Clean", "Clear", "Collect",
					"Convince", "Cover Up", "Defend", "Deliver", "Destroy", "Discover", "Disguise", "Duel", "Escape",
					"Explore", "Fight", "Fire", "Guard", "Guide", "Hide", "Humiliate", "Hunt", "Infiltrate",
					"Intimidate", "Kidnap", "Launch", "Liberate", "Lose", "Mimic", "Murder", "Negotiate", "Poison",
					"Purchase", "Recover", "Reject", "Rescue", "Research", "Scare", "Seduce", "Spy", "Steal", "Survive",
					"Teach", "Trade", "Travel", "Win"));
	public static final InstantPlot SINGLETON = new InstantPlot();

	InstantPlot() {
		super("Instant plot");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var plot = "Opposition: " + OPPOSITION.roll();
		plot += "\n" + ACTION.roll() + " " + Thing.SINGLETON.roll(false).toLowerCase();
		plot += "\n" + ACTION.roll() + " " + Thing.SINGLETON.roll(false).toLowerCase();
		return plot;
	}
}
