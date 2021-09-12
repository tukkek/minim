package minim.controller.table.kult.character.madness;

import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.controller.table.kult.setting.Dream;
import minim.controller.table.kult.setting.Portal;

// TODO 228-230 251
public class Madness extends MetaTable {
	public static final Table SHOCK = new SimpleTable("Madness (reaction, shock)",
			List.of("Screams", "Weeps", "Faints", "Runs away", "Shocked"));
	public static final Table POSSESSION = new SimpleTable("Madness (reaction, possession)",
			List.of("Dead human spirit", "Purgatide (refugee from Hell)", "Etherace (non-physical creature)",
					"Razide (demon)", "Nepharite (demon)"));
	public static final Table DREAM = new Table("Madness (hallucination, waking dream, other)") {
		@Override
		public void build() {
			add(30 / 1, "Objects change color and shape");
			add(30 / 6, "Lighting changes");
			add(30 / 11, "Transform an object up to 10 kilograms into another of double size and weight");
			add(30 / 11, "Transform an object up to 10 kilograms into another of half size and weight");
			add(30 / 16, "Time moves at half or double speed");
			add(30 / 20, "Compleetely change creature");
			add(30 / 20, "Compleetely change building");
			add(30 / 20, "Create an object of up to 10 kilograms or 1 cubic meter");
			add(30 / 26, "Move freely through time");
			add(30 / 26, "Act twice as fast");
			add(30 / 30, "Alter an entire landscape");
			add(30 / 30, "Add creature");
			add(30 / 30, "Add building");
			add(30 / 30, "Remove creature");
			add(30 / 30, "Remove building");
		}
	};
	public static final Table DREAMSELF = new Table("Madness (hallucination, waking dream, self)") {
		@Override
		public void build() {
			add(50 / 1, "Minor cosmetic changes to self");
			add(50 / 11, "Minimal increase to ability");
			add(50 / 11, "Switch sex");
			add(50 / 11, "Complete appearance change");
			add(50 / 16, "Assume non-human form");
			add(50 / 16, "Minor increase to ability");
			add(50 / 20, "Major increase to ability");
			add(50 / 30, "Minimal increase to all abilities");
			add(50 / 30, "Shape-shift at will");
			add(50 / 40, "Minor increase to all abilities");
			add(50 / 50, "Major increase to all abilities");
		}
	};
	public static final Table DREAMPORTAL = new Table("Madness (hallucination, waking dream, portal)") {
		@Override
		public void build() {
			rebuild = true;
			add(40 / 20, "Summon one or more dreamers");
			add(40 / 26, "Create a dream portal for yourself into " + Dream.INSTANCE.roll());
			add(40 / 31, "Create a dream portal for anyone into " + Dream.INSTANCE.roll());
			add(40 / 40, "Connect reality with " + Dream.INSTANCE.roll());
		}
	};
	public static final String ACHLYS = "Transported to " + Portal.ACHLYS;
	public static final Table TIME = new Table("Madness (hallucination, time distortion)") {
		@Override
		public void build() {
			add(40 / 5, "Time moves at double speed");
			add(40 / 5, "Time moves at half speed");
			add(40 / 5, "Time jumps up to a month forward");
			add(40 / 5, "Time jumps up to a month backward");
			add(40 / 10, "Time jumps up to 3 months forward");
			add(40 / 10, "Time jumps up to 3 months backward");
			add(40 / 15, "Alter your perception of time at-will, up to twice as fast or slow");
			add(40 / 15, "Jump forward or backward in time up to a month at-will");
			add(40 / 15, "Time jumps up to 3 years forward");
			add(40 / 15, "Time jumps up to 3 years backward");
			add(40 / 15, "Time stops for up to a week");
			add(40 / 15, "Time reversal");
			add(40 / 30, "Time-jump up to 30 years forward or backward, at will");
			add(40 / 30, "Time stops for up to a week, at will");
			add(40 / 40, "Alter the passage of time at will");
			add(40 / 30, "Time-jump to any point, at will");
			add(40 / 30, "Stop time at will");
			add(1, ACHLYS);
		}
	};
	public static final Table SPACE = new Table("Madness (hallucination, space distortion)") {
		@Override
		public void build() {
			add(40 / 5, "Teleport up to 2 kilometers");
			add(40 / 5, "Distances become 10x longer");
			add(40 / 5, "Distances become 10x shorter");
			add(40 / 5, "World becomes two-dimensional");
			add(40 / 10, "Teleport up to 50 kilometers");
			add(40 / 10, "Distances become 100x longer");
			add(40 / 10, "Distances become 100x shorter");
			add(40 / 15, "Teleport up to 2 kilometers, at will");
			add(40 / 15, "Increase or decrease distances by a favtor of 10, at will");
			add(40 / 15, "Teleport up to 1,000 kilometers");
			add(40 / 15, "Distances become 1,000x longer");
			add(40 / 15, "Distances become 1,000x shorter");
			add(40 / 30, "Teleport up to 50 kilometers, at will");
			add(40 / 30, "Increase or decrease distances by a favtor of 100, at will");
			add(40 / 30, "World becomes two- or four-dimensional, at will");
			add(40 / 40, "Teleport any distance, at will");
			add(40 / 40, "Increase or decrease distances by any amount, at will");
			add(1, ACHLYS);
		}
	};
	public static final Table HALLUCINATION = new MetaTable("Madness (hallucination)") {
		@Override
		public void build() {
			add(500 / 9, DREAM);
			add(500 / 9, DREAMSELF);
			add(500 / 9, DREAMPORTAL);
			add(500 / 6, TIME);
			add(500 / 6, SPACE);
			add(500 / 3, "See through the illusion and into " + Portal.INSTANCE.roll());
			add(500 / 100, "Your Shadow haunts you");
			add(500 / 300, "Your Shadow confronts you");
			add(500 / 500, "Awakening (attain divinity)");
		}
	};
	public static final Madness NEUTRAL = new Madness("neutral");
	public static final Madness NEGATIVE = new Madness("negative") {
		@Override
		protected int rolldie() {
			return Math.min(super.rolldie(), super.rolldie());
		}
	};
	public static final Madness POSITIVE = new Madness("positive") {
		@Override
		protected int rolldie() {
			return Math.max(super.rolldie(), super.rolldie());
		}
	};

	Madness(String balance) {
		super("Madness (" + balance + " mental balance)");
		rebuild = true;
	}

	@Override
	public void build() {
		add("Project your inner terrors to reality");
		add(PhysicalChange.INSTANCE);
		add(PhysicalChange.INSTANCE.roll().toLowerCase() + " (temporary)");
		add(POSSESSION.roll().toLowerCase() + " possession");
		add(MentalChange.INSTANCE);
		var p = HALLUCINATION.roll();
		add(10 / 2, "Projected hallucination (affects all)" + p);
		add(10 / 2, "Hallucinate (affects you)" + p);
		add("Hurt yourself");
		add("Hurt others");
		add("Lose control over flaws");
		add("Lose control over flaws (can be helped by others)");
		var s = SHOCK.roll().toLowerCase();
		add(s + " for one minute");
		add(s);
		add(s + " but can act with general penalty to actions");
		add("Hesitates for a turn");
		add("De-project (threat is destroyed or relocated)");
	}
}
