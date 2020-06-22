package minim.controller.table.adventurecrafter;

import minim.controller.table.Table;

/**
 * A Plotline is an open thread in your Adventure. It is the reason your
 * Characters are adventuring. They are the conflicts to resolve, the goals to
 * achieve.
 * 
 * @author alex
 */
public class Plotline extends Table {
	public static final Plotline SINGLETON = new Plotline();

	Plotline() {
		super("Plotline");
	}

	@Override
	public void build() {
		add(1, "New plotline");
		add(2, 4, "Choose most logical plotline");
	}
}
