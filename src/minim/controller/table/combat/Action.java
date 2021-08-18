package minim.controller.table.combat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.Table;
import minim.model.Character;

public class Action extends Table {
	public static final Table TREMBLING = new Action("Action (trembling)", +1);
	public static final Table COWERING = new Action("Action (cowering)", +2);
	public static final Table CAUTIOUS = new Action("Action (cautious)", +3);
	public static final Table CERTAIN = new Action("Action (certain)", +4);
	public static final Table DARING = new Action("Action (daring)", +5);
	public static final Table CAREFREE = new Action("Action (carefree)", +6);

	static final Map<Integer, String> ACTIONS = new HashMap<>(18 - 3 + 1);

	static {
		var i = 3;
		for (var a : List.of("Panic", "Surrender", "Flee", "Retreat", "Guard", "Buy time", "Wait", "Distract", "Probe",
				"Light attack", "Attack", "Heavy attack", "Feint", "Taunt", "Charge", "Enrage")) {
			ACTIONS.put(i, a);
			i += 1;
		}
	}

	int bonus;

	public Action(String name, int bonus) {
		super(name);
		this.bonus = bonus;
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var a = ActionType.SINGLETON.roll();
		if (a == ActionType.NEW)
			return ACTIONS.get(Character.roll() + Character.roll() + bonus);
		if (a == ActionType.TWIST)
			return "Twist: " + Twist.SINGLETON.roll().toLowerCase();
		return a;
	}
}
