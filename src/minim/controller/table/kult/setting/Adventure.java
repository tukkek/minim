package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.Lines;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Adventure extends Table {
	public static final Table PLOT = new SimpleTable("Adventure (plot)",
			List.of("Stop a bad thing from happening", "Find someone", "Find something", "Revenge", "Solve a riddle",
					"Travel", "Gather information and wisdom", "Expose and stop a cult", "Make something happen",
					"Run for your life"));
	public static final Table MOTIVATION = new SimpleTable("Adventure (motivation)",
			List.of("False accusations", "Prevent something", "Revenge", "Loyalty to a person",
					"Loyalty to an organization", "Curiosity", "Money", "Religion", "A favor", "Character advantage",
					"Character disadvantage", "An objective", "Blackmail"));
	public static final Table CHARACTERS = new SimpleTable("Adventure (characters)",
			List.of("Friends", "Colleagues", "Neighbors", "Hobbyists", "Relatives", "Students", "Common friend",
					"Present at the same past event", "Common enemies", "Coincidence"));
	public static final Table BEGINNING = new SimpleTable("Adventure (beginning)",
			List.of("Murder", "Disappearance", "Comission", "Attack", "Curse", "Dreams", "Disease", "Tricked", "Object",
					"Stranger", "Place", "Help", "Pursuit"));
	public static final Table EVENT = new SimpleTable("Adventure (event)",
			List.of("Ambush", "Possession", "Surveillance", "Car chase", "Forensic investigation at a crime scene",
					"Dreams", "Death", "Escape", "Curse", "Captivity", "Interrogation", "Love", "Seduction",
					"Illusion shatters", "Burglary", "Infiltration", "Research", "Chased by monsters",
					"Chased by killers", "Hijacking", "Raid", "Confrontation", "Ritual", "New NPC", "Disaster",
					"Accident", "Travel", "Sex", "Illness", "Combat", "Lost"));
	public static final Table COMPLICATION = new SimpleTable("Adventure (complication)",
			List.of("Possession", "Wrong person", "Torn between goals", "Torn between impulses", "False information",
					"Adversary", "Loyalty changes", "Separated", "Illusion shatters", "More complexity", "New enemies",
					"New friends", "New information", "Lies", "Outsiders"));

	public Adventure() {
		super("Adventure");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Plot", PLOT);
		l.add("Motivation", MOTIVATION);
		l.add("Characters", CHARACTERS);
		l.add("Beginning", BEGINNING);
		var r = List.of(Character.roll(5), Character.roll(5));
		var events = Math.max(r.get(0), r.get(1));
		for (int i = 0; i < events; i++)
			l.add("Event", EVENT);
		var complications = Math.min(r.get(0), r.get(1));
		for (int i = 0; i < complications; i++)
			l.add("Complication", COMPLICATION);
		return l.toString();
	}
}
