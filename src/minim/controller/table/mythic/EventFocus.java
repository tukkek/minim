package minim.controller.table.mythic;

import minim.controller.table.Table;

public class EventFocus extends Table {
	public EventFocus() {
		super("Event focus");
	}

	@Override
	public void build() {
		add(1, 7, "Remote event");
		add(8, 28, "NPC action");
		add(29, 35, "Introduce a new NPC");
		add(36, 45, "Move toward a threat");
		add(46, 52, "Move away from a thread");
		add(53, 55, "Close a thread");
		add(56, 67, "PC negative");
		add(68, 75, "PC positive");
		add(76, 83, "Ambiguous event");
		add(84, 92, "NPC negative");
		add(93, 100, "NPC positive");
	}

	@Override
	public String roll() {
		return super.roll() + " (" + EventMeaning.SINGLETON.roll().toLowerCase() + ")";
	}
}
