package minim.controller.table.kult.madness;

import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Madness extends MetaTable {
	public static final Table SHOCK = new SimpleTable("Madness (reaction, shock)",
			List.of("Screams", "Weeps", "Faints", "Runs away", "Shocked"));
	public static final Table POSSESSION = new SimpleTable("Madness (reaction, possession)",
			List.of("Dead human spirit", "Purgatide (refugee from Hell)", "Etherace (non-physical creature)",
					"Razide (demon)", "Nepharite (demon)"));
	public static final Madness NEUTRAL = new Madness("neutral");
	public static final Madness POSITIVE = new Madness("positive") {
		@Override
		protected int rolldie() {
			return Math.min(super.rolldie(), super.rolldie());
		}
	};
	public static final Madness NEGATIVE = new Madness("negative") {
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
		add("De-project (terror is destroyed or relocated)");
		add("Hesitates for a turn");
		var s = SHOCK.roll().toLowerCase();
		add(s + " but can act with general penalty to actions");
		add(s);
		add(s + " for one minute");
		add("Lose control over flaws (can be helped by others)");
		add("Lose control over flaws");
		add("Hurt others");
		add("Hurt yourself");
		add("See through the Illusion");
		add(MentalChange.INSTANCE);
		add(POSSESSION.roll().toLowerCase() + " possession");
		add(PhysicalChange.INSTANCE.roll().toLowerCase() + " (temporary)");
		add(PhysicalChange.INSTANCE);
		add("Project your inner terrors to reality");
	}
}
