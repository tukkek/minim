package minim.controller.table.kult.character;

import java.util.List;

public class Conjurer extends Character {
	public static final Character OCCULTIST = new Conjurer("Character (archetype, conjurer, burnt-out occultist)",
			List.of(Disadvantage.REPUTATION, Disadvantage.CURSE, Disadvantage.PERSECUTED, Disadvantage.CONSTRICTION,
					Disadvantage.HAUNTED, Disadvantage.WANTED, Disadvantage.NIGHTMARES, Disadvantage.ADDICTION,
					Disadvantage.MEDIUM),
			List.of(Advantage.EMPATHY, Advantage.AWARENESS, Advantage.INTUITION, Advantage.MAGICAL, Advantage.MATH),
			List.of(Secret.HAUNTED, Secret.CURSE, Secret.KNOWLEDGE, Secret.OCCULTEXPERIENCE, Secret.PACT,
					Secret.SUPERNATURALEXPERIENCE),
			List.of(Profession.WORKER, Profession.WRITER, Profession.JOURNALIST, Profession.ARTIST,
					Profession.CONSULTANT, Profession.CLERGY),
			4, 4, List.of(Skill.OCCULTISM, Skill.LANGUAGES, Skill.PSYCHOLOGY, Skill.CONTACTS, Skill.MEDITATION,
					Skill.WRITING, Skill.RHETORIC));
	public static final Character PAGAN = new Conjurer("Character (archetype, conjurer, new-age pagan)",
			List.of(Disadvantage.REPUTATION, Disadvantage.FANATICISM, Disadvantage.CURSE, Disadvantage.HAUNTED,
					Disadvantage.INTOLERANCE, Disadvantage.NIGHTMARES, Disadvantage.MEDIUM, Disadvantage.PERSECUTED),
			List.of(Advantage.EMPATHY, Advantage.AWARENESS, Advantage.INTUITION, Advantage.ANIMALS),
			List.of(Secret.HAUNTED, Secret.CURSE, Secret.OCCULTEXPERIENCE, Secret.PACT, Secret.SUPERNATURALEXPERIENCE),
			List.of(Profession.WORKER, Profession.NURSE, Profession.ARTIST, Profession.CONSULTANT,
					Profession.PSYCHIATRIST),
			6, 6, List.of(Skill.OCCULTISM, Skill.COMPUTERS, Skill.POISONS, Skill.DRUGS, Skill.PSYCHOLOGY,
					Skill.CONTACTS, Skill.MEDITATION, Skill.WRITING, Skill.UNARMED, Skill.RHETORIC, Skill.WORDLY));

	Conjurer(String title, List<String> disadvantages, List<String> advantages, List<String> secrets,
			List<String> profession, int wealthmin, int wealthmax, List<String> skills) {
		super(title, disadvantages, advantages, secrets, profession, wealthmin, wealthmax, skills);
		Skill.LORES.roll();
		this.skills.addAll(Skill.LORES.lines);
	}
}
