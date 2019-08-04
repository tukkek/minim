package minim.controller.table.cyberpunk;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class Family extends Table {
	public static final Table RANKING = new SimpleTable("Family (ranking)",
			List.of("Corporate executive", "Corporate manager", "Corporate technician", "Nomad pack", "Pirate fleet",
					"Gang", "Crime lord", "Warzone inhabitants", "Urban homeless", "Arcology"));
	public static final Table CHILDHOOD = new SimpleTable("Family (childhood environment)",
			List.of("Streets, unsupervised", "Corporate suburbs", "Nomad pack", "Once-upscale decaying neighborhood",
					"Defnded corporate zone", "Combat zone", "Village", "Arcology", "Pirates", "Farm",
					"Research facility"));
	public static final Table TRAGEDY = new SimpleTable("Family (tragedy)",
			List.of("Betrayed, lost everything", "Mismanaged, lost everything", "Exiled", "Imprisoned", "Vanished",
					"Dead", "Involed in conspiracy or organization", "Scattered by misfortune", "Feud", "Debt"));
	public static final Table NOPARENTS = new SimpleTable("Family (something happened to your parents)",
			List.of("Died in war", "Died in accident", "Murdered", "Amnesiacs", "Never met them", "In hiding",
					"Raised by relatives", "Never had parents", "Adopted", "They sold you"));
	public static final Family SINGLETON = new Family();

	Family() {
		super("Family");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var family = "Ranking: " + RANKING.roll();
		if (Character.roll(10) >= 7)
			family += "\nSomething happened to your parents: " + NOPARENTS.roll();
		if (Character.roll(10) <= 6)
			family += "\nTragedy: " + TRAGEDY.roll();
		family += "\nChildhood environment: " + CHILDHOOD.roll();
		var siblings = Character.roll(10) - 3;
		if (siblings > 0)
			for (var i = 1; i <= siblings; i++) {
				family += "\nSibling: " + Sibling.SINGLETON.roll();
			}

		return family;
	}
}
