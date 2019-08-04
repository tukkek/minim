package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Romance extends Table {
	static final public Table TRAGIC = new SimpleTable("Romance (tragic)",
			List.of("Died accidently", "Vanished", "Didn't work out", "Goal or vendetta came in-between", "Kidnapped",
					"Insanity", "Suicide", "Left for another", "Imrposned or exiled"));
	static final public Table PROBLEMATIC = new SimpleTable("Romance (problematic)",
			List.of("Their friends/family hate you", "Their friends/family want to get rid of you",
					"Your family/friends hate your lover", "One of you has a romantic rival",
					"You are somehow separated", "Constant fights", "You two compete professionaly", "Jealousy",
					"One of you has an affair(s)", "Conflicting backgrounds")) {
		@Override
		public String roll() {
			return super.roll() + ". " + FEELINGS.roll();
		}
	};
	static final public Table FEELINGS = new SimpleTable("Romance (residual feelings)",
			List.of("They love you", "You love them", "You still love each other", "You hate them", "They hate you",
					"You hate each other", "You're friends now", "It's over for both of you",
					"You like them, they hate you", "You hate them, they like you"));

	public Romance() {
		super("Romance");
		rebuild = true;
	}

	@Override
	public void build() {
		add(1, 4, "Happy love affair");
		add(5, TRAGIC.roll());
		add(6, 7, PROBLEMATIC.roll());
		add(8, 10, "Affairs and hot dates");
	}
}
