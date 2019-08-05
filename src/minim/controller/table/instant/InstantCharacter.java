package minim.controller.table.instant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

/**
 * @author alex
 *
 */
public class InstantCharacter extends Table {
	public static final Table PEOPLE = new SimpleTable("Instant character (people)",
			List.of("Actor", "Advisor", "Agent", "Anthropomorphic Object", "Aristocrat", "Artificial Intelligence",
					"Artisan", "Athlete", "Author", "Banker", "Bar Fly", "Bounty Hunter", "Bully", "Cannonfodder",
					"Caretaker", "Carpenter", "Casanova", "Child", "Clergy", "Collector", "Common Criminal",
					"Concerned Parent", "Conspiracy Theorist", "Crazed Loner", "Demon", "Desperate Citizen",
					"Devil's Advocate", "Driver", "Eccentric Millionaire", "Elder", "Elected Official", "Expert",
					"Farmer", "Fixer", "Gambler", "Genius", "Government Agent", "Guard", "Guide", "Healer", "Heir",
					"Hired Muscle", "Historian", "Horseman", "Hostage", "Hunter", "Idiot Savant", "Immortals",
					"Informant", "Janitor", "Judge", "Kingpin", "Law Enforcement Officer", "Lawyer", "Leader",
					"Local Legend", "Magician", "Mason", "Mechanic", "Mercenaries", "Musician", "Ninjas", "Noble",
					"Philosopher", "Pirate", "Prisoner", "Private Investigator", "Prophet", "Prostitute", "Pundit",
					"Rebel", "Recluse", "Red Shirt", "Relative", "Religious Fanatics", "Repairman", "Robot/Automaton",
					"Sailor", "Salesman", "Scribe", "Security Forces", "Serial Killer", "Servant", "Shopkeep", "Slave",
					"Smith", "Soldier", "Speaker", "Sportsman", "Spy", "Student", "Swindler", "Teacher", "Technician",
					"Thief", "Thug", "Troubled Youth", "Undertaker", "Vagrant", "Village Idiot"));
	public static final Table PERSONALITY = new SimpleTable("Instant character (personality)", List.of("Affectionate",
			"Aloof", "Ambitious", "Angry", "Apathetic", "Argumentative", "Arrogant", "Artsy", "Athletic", "Attentive",
			"Battle-Scarred", "Beautiful", "Belligerent", "Boastful", "Calm", "Cautious", "Charming", "Chaste",
			"Chauvinistic", "Chivalrous", "Clever", "Confident", "Cruel", "Curious", "Cynical", "Deceitful",
			"Defensive", "Defiant", "Detached", "Deviant", "Devil's Advocate", "Distracted", "Ditzy", "Dumb", "Eager",
			"Egomaniacal", "Evasive", "Extravagant", "Famous", "Flexible", "Generous", "Gloomy", "Greedy", "Hasty",
			"Healthy", "Hedonistic", "Honest", "Humble", "Humorous", "Hyper", "Hypochondriac", "Ignorant", "Ill",
			"Imaginative", "Impatient", "Impulsive", "Independent", "Innocent", "Insane", "Insecure", "Intelligent",
			"Introverted", "Judgmental", "Juvenile", "Lazy", "Logical", "Mischievous", "Nervous", "Obnoxious",
			"Obsessive-Compulsive", "Organized", "Paranoid", "Passive-Aggressive", "Popular", "Quixotic", "Reasonable",
			"Relentless", "Resourceful", "Restless", "Rich", "Rude", "Sadistic", "Sensitive", "Serious", "Shrewd",
			"Shy", "Sloppy", "Snobby", "Spiritual", "Spontaneous", "Stubborn", "Sympathetic", "Tongue-Tied", "Tough",
			"Ungrateful", "Virtuous", "Vulgar", "Whiny", "Wise", "Xenophobic"));
	public static final Table FLAW = new SimpleTable("Instant character (flaw)",
			List.of("Addiction of any sort", "Ambitious", "Cannot lose an argument", "Can't turnaway a person in need",
					"Code of Honor", "Compulsivebehavior", "Cowardly", "Easily distracted", "Enemy",
					"Fanatically loyal", "Foolishly brave", "Greedy", "Gullible", "Angry",
					"Incompetence in a specific skillarea", "Intolerant", "Lazy", "Massive debt", "Mental illness",
					"Obese", "Obsessive", "Overconfident", "Overly generous", "Pacifism", "Painfully shy", "Phobia",
					"Physically weak", "Poor", "Progammed with Asimov's Laws of Robotics", "Prone tobattle rage",
					"Racist", "Slow learner", "Stubborn", "Thin skinned", "Unlucky", "Vain", "Wanted by the law",
					"Zealous behavior"));
	public static final InstantCharacter NORMAL = new InstantCharacter("normal", 5, 3, 1, 1);
	public static final InstantCharacter WEAK = new InstantCharacter("weak", 4, 2, 1, 1);
	public static final InstantCharacter FLAMBOYANT = new InstantCharacter("flamboyant", 6, 4, 2, 1);

	int basic;
	int advanced;
	int exceptional;
	int flaws;

	InstantCharacter(String title, int basic, int advanced, int exceptional, int flaws) {
		super("Instant character, " + title);
		this.basic = basic;
		this.advanced = advanced;
		this.exceptional = exceptional;
		this.flaws = flaws;
	}

	@Override
	public void build() {
		// don't
	}

	List<String> gettraits(int basic, int advanced, int exceptional) {
		var traits = new ArrayList<String>(); // cannot use set unless possession an power table is added
		while (traits.size() < basic + advanced + exceptional)
			traits.add(Trait.SINGLETON.roll());
		for (var i = 0; i < traits.size(); i++) {
			var t = traits.get(i).toLowerCase();
			if (exceptional > 0) {
				t = "exceptional " + t;
				exceptional -= 1;
			} else if (advanced > 0) {
				t = "advanced " + t;
				advanced -= 1;
			} else if (basic > 0) {
				t = "basic " + t;
				basic -= 1;
			}
			traits.set(i, t);
		}
		return traits;
	}

	@Override
	public String roll() {
		var personality = new HashSet<String>(1);
		while (personality.isEmpty() || Character.roll(2) == 1)
			personality.add(PERSONALITY.roll().toLowerCase());
		var character = PEOPLE.roll() + " (" + String.join(", ", personality) + ")";
		int basic = this.basic;
		int advanced = this.advanced;
		int exceptional = this.exceptional;
		int nflaws = this.flaws;
		var roll = Character.roll(8);
		if (roll == 1 || roll == 2) {
			nflaws += 1;
			basic += 1;
		} else if (roll == 3) {
			nflaws += 2;
			basic += 2;
		} else if (roll == 4) {
			nflaws += 2;
			advanced += 1;
		}
		character += "\nTraits: " + String.join(", ", gettraits(basic, advanced, exceptional));
		var flaws = new HashSet<String>(nflaws);
		while (flaws.size() < nflaws)
			flaws.add(FLAW.roll().toLowerCase());
		character += "\nFlaws: " + String.join(", ", flaws);
		return character;
	}
}
