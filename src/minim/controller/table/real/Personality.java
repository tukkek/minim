package minim.controller.table.real;

import java.util.List;
import java.util.stream.Collectors;

import minim.controller.table.Table;

/** Based on big-five demographics. Differences between sexes are minor. */
public class Personality extends Table {
	public static class Trait extends Table {
		public String common;
		public String rare;

		public Trait(String title, String common, String rare) {
			super(title);
			this.common = common;
			this.rare = rare;
		}

		@Override
		public void build() {
			add(4, common);
			add(1, rare);
		}

		public boolean israre() {
			return roll() == rare;
		}
	}

	public static final Personality INSTANCE = new Personality();
	public static final Trait OPENNESS = new Trait("Openess", "Curious", "Cautious");
	public static final Trait CONSCIOUSNESS = new Trait("Consciousness", "Competent", "Careless");
	public static final Trait EXTRAVERSION = new Trait("Extraversion", "Outgoing", "Reserved");
	public static final Trait AGREEABLENESS = new Trait("Agreeableness", "Friendly", "Harsh");
	public static final Trait NEUROTICISM = new Trait("Neuroticism", "Nervous", "Confident") {
		@Override
		public void build() {
			add(3, common);
			add(2, rare);
		}
	};
	public static final List<Trait> TRAITS = List.of(OPENNESS, CONSCIOUSNESS, EXTRAVERSION, AGREEABLENESS, NEUROTICISM);

	Personality() {
		super("Personality");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return TRAITS.stream().map(t -> t.roll().toLowerCase()).collect(Collectors.joining(", "));
	}
}
