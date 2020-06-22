package minim.controller.table.steampunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

/**
 * Basd on Castle Falkenstein character creation.
 * 
 * @author alex
 */
public class Diary extends Table {
	public static final Table BACKGROUND = new SimpleTable("Diary questions (background)",
			List.of("What is your name?", "Where do you come from?", "What do you regret most?",
					"What are you most proud of?", "What have you been doing for the last few years?",
					"What has granted you social acclaim?", "Have you comitted a crime?",
					"What sort of education did you have?", "Where do you live now?"));
	public static final Table APPEARANCE = new SimpleTable("Diary questions (appearance)",
			List.of("What do you look like?", "What is your style?", "Describe your clothing preferences",
					"Describe your quirks.", "Are you dashing or demure?"));
	public static final Table PERSONALITY = new SimpleTable("Diary questions (personality)",
			List.of("What are your virtues and vices?", "What are your best qualities?",
					"Describe your personality in two words", "What principle do you value the most?",
					"What is your most treasured possession?", "What is your social goal?",
					"What is your professional goal?", "What gives you a sense of satisfaction?",
					"Would you give up your life for something? Why?"));
	public static final Table PREFERENCES = new SimpleTable("Diary questions (preferences)",
			List.of("What do you like?", "What do you dislike?", "Describe your favorite foods.",
					"Describe your favorite drinks.", "Describe your favorite books.", "Describe your favorite music.",
					"Describe your favorite places.", "Describe your least favorite foods.",
					"Describe your least favorite drinks.", "Describe your least favorite books.",
					"Describe your least favorite music.", "Describe your least favorite places."));
	public static final Table ALLEGIANCES = new SimpleTable("Diary questions (allegiances)",
			List.of("Who do you value most?", "Who is your nemesis?", "What do you stand against?",
					"Who are your allies?", "Do you have friends?", "Do you look up to someone?",
					"who are your heroes?", "Would you give up your life for someone? Why?"));
	public static final Table SKILLS = new SimpleTable("Diary questions (skills)",
			List.of("What ability are you great at?", "What ability are you poor at?",
					"Describe four abilities you're good at?", "How do you make a living?",
					"What activites do you enjoy outside of work?", "What would be your dream job?"));
	public static final Table ROMANCE = new SimpleTable("Diary questions (romance)",
			List.of("Describe your romantic life.", "What is your romantic goal?", "Did you ever abandon a lover?",
					"Have you ever not acted upon your heart's desires?",
					"Are you romantically involved and with whom?", "Are there obstacles in your way to love?"));
	public static final Table FAMILY = new SimpleTable("Diary questions (family)",
			List.of("Describe your childhood and upbringing.", "Do you have siblings?", "Are your parents around?",
					"Were you a legitimate or bastard child?",
					"How did you get along with your family as a young person?",
					"How do you get along with your family nowadays?", "Is your family wealthy?",
					"What are the important events in your family's history?",
					"What are the tragic events in your family's history?"));

	public Diary() {
		super("Diary questions");
	}

	@Override
	public void build() {
		for (var t : List.of(BACKGROUND, APPEARANCE, PERSONALITY, PREFERENCES, ALLEGIANCES, SKILLS, ROMANCE, FAMILY))
			add(t.lines);
	}
}
