package minim.controller.table.combat;

import java.util.List;

import minim.controller.table.Table;

public class Twist extends Table {
	public static final Table SINGLETON = new Twist();

	Twist() {
		super("Twist");
	}

	@Override
	public void build() {
		add(List.of("Reinforce", "Change", "Disadvantage opponent", "Advantage self", "Bargain", "Trick"));
	}
}
