package minim.controller.table.conjectural;

import java.util.function.BinaryOperator;

import minim.controller.table.Table;

public class YesNoAdvantage extends Table {
	public YesNoAdvantage() {
		super("Yes/no (simple, advantage)");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return roll((a, b) -> Math.max(a, b));
	}

	public static String roll(BinaryOperator<Integer> select) {
		var results = YesNo.RESULTS;
		var a = results.indexOf(YesNo.SINGLETON.roll(false));
		var b = results.indexOf(YesNo.SINGLETON.roll(false));
		var r = YesNo.expand(results.get(select.apply(a, b)));
		return r;
	}
}
