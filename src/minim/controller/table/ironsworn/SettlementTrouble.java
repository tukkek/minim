package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.Table;
import minim.model.Character;

public class SettlementTrouble extends Table {
	public SettlementTrouble() {
		super("Settlement trouble");
	}

	@Override
	public void build() {
		add(List.of("Outsiders rejected", "Dangerous discovery", "Dreadful omens", "Natural disaster",
				"Old wounds reopened", "Important object is lost", "Someone is captured", "Mysterious phenomenon",
				"Revolt against a leader", "Vengeful outcast", "Rival settlement", "Nature strikes back",
				"Someone is missing", "Production halts", "Mysterious murders", "Debt comes due", "Unjust leadership",
				"Disastrous accident", "In league with the enemy", "Raiders prey on the weak", "Cursed past",
				"An innocent is accused", "Corrupted by dark magic", "Isolated by brutal weather",
				"Provisions are scarce", "Sickness run amok", "Allies become enemies", "Attack is imminent",
				"Lost caravan", "Dark secret revealed", "Urgent expedition", "A leader falls", "Families in conflict",
				"Incompetent leadership", "Reckless warmongering", "Beast on the hunt", "Betrayed from within",
				"Broken truce", "Wrathful haunt", "Conflict with firstborn", "Trade route blocked", "In the crossfire",
				"Stranger causes discord", "Important event threatened", "Dangerous tradition"));
	}

	@Override
	public String roll() {
		var result = super.roll();
		if (Character.roll(10) == 1)
			result += " and " + super.roll().toLowerCase();
		return result;
	}
}
