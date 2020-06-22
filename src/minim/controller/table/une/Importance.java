package minim.controller.table.une;

import java.util.HashMap;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Importance extends Table {
	public static final Table DEMEANOR = new SimpleTable("NPC importance (demeanor)",
			List.of("scheming", "insane", "friendly", "hostile", "inquisitive", "knowing", "mysterious", "prejudiced"));
	public static final HashMap<String, Table> BEARINGS = new HashMap<String, Table>();

	static {
		BEARINGS.put("scheming", new SimpleTable("NPC bearing (scheming)", List.of("intent", "bargain", "means",
				"proposition", "plan", "compromise", "agenda", "arrangement", "negotiation", "plot")));
		BEARINGS.put("insane", new SimpleTable("NPC bearing (insane)", List.of("madness", "fear", "accident", "chaos",
				"idiocy", "illusion", "turmoil", "confusion", "façade", "bewilderment")));
		BEARINGS.put("friendly", new SimpleTable("NPC bearing (friendly)", List.of("alliance", "comfort", "gratitude",
				"shelter", "happiness", "support", "promise", "delight", "aid", "celebration")));
		BEARINGS.put("hostile", new SimpleTable("NPC bearing (hostile)", List.of("death", "capture", "judgment",
				"combat", "surrender", "rage", "resentment", "submission", "injury", "destruction")));
		BEARINGS.put("inquisitive", new SimpleTable("NPC bearing (inquisitive)", List.of("questions", "investigation",
				"interest", "demand", "suspicion", "request", "curiosity", "skepticism", "command", "petition")));
		BEARINGS.put("knowing", new SimpleTable("NPC bearing (knowing)", List.of("report", "effects", "examination",
				"records", "account", "news", "history", "telling", "discourse", "speech")));
		BEARINGS.put("mysterious", new SimpleTable("NPC bearing (mysterious)", List.of("rumor", "uncertainty",
				"secrets", "misdirection", "whispers", "lies", "shadows", "enigma", "obscurity", "conundrum")));
		BEARINGS.put("prejudiced", new SimpleTable("NPC bearing (prejudiced)", List.of("reputation", "doubt", "bias",
				"dislike", "partiality", "belief", "view", "discrimination", "assessment", "difference")));
	}

	static final public Table FOCUS = new SimpleTable("NPC importance (focus)",
			List.of("current scene", "parents", "wealth", "skills", "campaign", "allies", "flaws", "experience",
					"community", "current story", "weapons", "last story", "history", "relics", "superiors",
					"future action", "last scene", "antagonist", "knowledge", "treasure", "family", "previous scene",
					"equipment", "retainers", "last action", "fame", "friends", "contacts", "rewards", "recent scene",
					"the character", "power", "enemy"));

	static final public Importance SINGLETON = new Importance();

	Importance() {
		super("NPC importance");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var demeanor = DEMEANOR.roll();
		var bearing = BEARINGS.get(demeanor).roll();
		var focus = FOCUS.roll();
		return "The " + demeanor + " NPC speaks of " + bearing + " regarding " + focus;
	}
}
