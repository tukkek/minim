package minim.controller.table.tarot;

import java.util.List;

import minim.controller.table.Table;

/**
 * Based on
 * http://www.random-generator.com/index.php?title=Tarot_Plot_Generator&action=edit
 * 
 * @author alex
 */
public class PlotGenerator extends Table {
	public static final Table ACT1 = new TarotTable("Plot generator (act 1)",
			List.of("Premise", "Circumstance", "Action/wants", "Plot point"));
	public static final Table ACT2 = new TarotTable("Plot generator (act 2)", List.of("Low point", "Plot point"));
	public static final Table ACT3 = new TarotTable("Plot generator (act 2)", List.of("Climax", "Denouement"));

	public PlotGenerator() {
		super("Plot generator");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return "Act 1\n" + ACT1.roll() + "\n\nAct 2\n" + ACT2.roll() + "\n\nAct 3\n" + ACT3.roll();
	}
}
