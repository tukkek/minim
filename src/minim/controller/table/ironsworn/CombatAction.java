package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.Table;

public class CombatAction extends Table {
	public CombatAction() {
		super("Combat action");
	}

	@Override
	public void build() {
		for (var i : List.of("Compel a surrender.", "Coordinate with allies.", "Gather reinforcements."))
			add(1, 3, i);
		for (var i : List.of("Seize something or someone.", "Provoke a reckless response.", "Intimidate or frighten.",
				"Reveal a surprising truth.", "Shift focus to someone or something else.",
				"Destroy something, or render it useless."))
			add(1, 4, i);
		for (var i : List.of("Take a decisive action.", "Reinforce defenses."))
			add(1, 5, i);
		add(1, 6, "Ready an action.");
		for (var i : List.of("Use the terrain to gain advantage.", "Leverage the advantage of a weapon or ability."))
			add(1, 7, i);
		add(1, 8, "Create an opportunity.");
		for (var i : List.of("Attack with precision.", "Attack with power."))
			add(1, 9, i);
		add("Unexpected action");
	}
}
