package minim.controller.table.mythic;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class EventMeaning extends Table {
	public static final Table ACTION = new SimpleTable("Event meaning (action)",
			List.of("Attainment", "Starting", "Neglect", "Fight", "Recruit", "Triumph", "Violate", "Oppose", "Malice",
					"Communicate", "Persecute", "Increase", "Decrease", "Abandon", "Gratify", "Inquire", "Antagonise",
					"Move", "Waste", "Truce", "Release", "Befriend", "Judge", "Desert", "Dominate", "Procrastinate",
					"Praise", "Separate", "Take", "Break", "Heal", "Delay", "Stop", "Lie", "Return", "Immitate",
					"Struggle", "Inform", "Bestow", "Postpone", "Expose", "Haggle", "Imprison", "Release", "Celebrate",
					"Develop", "Travel", "Block", "Harm", "Debase", "Overindulge", "Adjourn", "Adversity", "Kill",
					"Disrupt", "Usurp", "Create", "Betray", "Agree", "Abuse", "Oppress", "Inspect", "Ambush", "Spy",
					"Attach", "Carry", "Open", "Carelessness", "Ruin", "Extravagance", "Trick", "Arrive", "Propose",
					"Divide", "Refuse", "Mistrust", "Deceive", "Cruelty", "Intolerance", "Trust", "Excitement",
					"Activity", "Assist", "Care", "Negligence", "Passion", "Work hard", "Control", "Attract", "Failure",
					"Pursue", "Vengeance", "Proceedings", "Dispute", "Punish", "Guide", "Transform", "Overthrow",
					"Oppress", "Change"));
	public static final Table SUBJECT = new SimpleTable("Event meaning (subject)",
			List.of("Goals", "Dreams", "Environment", "Outside", "Inside", "Reality", "Allies", "Enemies", "Evil",
					"Good", "Emotions", "Opposition", "War", "Peace", "The innocent", "Love", "The spiritual",
					"The intellectual", "New ideas", "Joy", "Messages", "Energy", "Balance", "Tension", "Friendship",
					"The physical", "A project", "Pleasures", "Pain", "Possessions", "Benefits", "Plans", "Lies",
					"Expectations", "Legalmatters", "Bureaucracy", "Business", "A path", "News", "External factors",
					"Advice", "A plot", "Competition", "Prison", "Illness", "Food", "Attention", "Success", "Failure",
					"Travel", "Jealousy", "Dispute", "Home", "Investment", "Suffering", "Wishes", "Tactics",
					"Stalemate", "Randomness", "Misfortune", "Death", "Disruption", "Power", "Aburden", "Intrigues",
					"Fears", "Ambush", "Rumor", "Wounds", "Extravagance", "A representative", "Adversities", "Opulence",
					"Liberty", "Military", "The mundane", "Trials", "Masses", "Vehicle", "Art", "Victory", "Dispute",
					"Riches", "Statusquo", "Technology", "Hope", "Magic", "Illusions", "Portals", "Danger", "Weapons",
					"Animals", "Weather", "Elements", "Nature", "The public", "Leadership", "Fame", "Anger",
					"Information"));
	public static final EventMeaning SINGLETON = new EventMeaning();

	EventMeaning() {
		super("Event meaning");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return ACTION.roll() + " " + SUBJECT.roll().toLowerCase();
	}
}
