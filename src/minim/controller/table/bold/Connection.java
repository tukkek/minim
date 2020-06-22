package minim.controller.table.bold;

import java.util.ArrayList;
import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Connection extends Table {
	public static final Table ACTION = new SimpleTable("Connection (action)",
			List.of("proclaim", "protest", "resolve", "interject", "demand", "impart", "commend", "muse", "examine",
					"digress", "assure", "reminisce", "ponder", "scrutinize", "address", "deceive", "negotiate",
					"guide", "endorse", "speculate"));
	public static final Table GERUND = new SimpleTable("Connection (gerund)",
			List.of("exposing", "weakening", "divulging", "lying", "confronting", "detailing", "avoiding", "working",
					"negating", "preparing", "training", "enjoying", "discussing", "obsessing", "repairing",
					"improving", "understanding", "connecting", "concluding", "excluding"));
	public static final Table SUBJECT = new SimpleTable("Connection (subject)",
			List.of("a dislike", "an attribute", "a desire", "friends or family", "an annoyance", "a skill", "a fear",
					"wealth", "home or hearth", "an ability", "a decision", "a love", "personal qualities",
					"your nature", "a like", "enemies", "party member", "a core belief", "a possession", "allies"));

	static final int ROWS = 3;

	public Connection() {
		super("Connections table");
	}

	@Override
	public void build() {
		// don't
	}

	List<String> pick(Table from) {
		var list = new ArrayList<String>(ROWS);
		while (list.size() < ROWS) {
			var line = from.roll();
			if (!list.contains(line))
				list.add(line);
		}
		var pad = list.stream().map(l -> l.length()).max((a, b) -> Integer.compare(a, b)).orElse(null);
		for (int i = 0; i < list.size(); i++) {
			var l = list.get(i);
			while (l.length() < pad)
				l += " ";
			list.set(i, l);
		}
		return list;
	}

	@Override
	public String roll() {
		var table = "";
		var actions = pick(ACTION);
		var gerund = pick(GERUND);
		var subject = pick(SUBJECT);
		for (var i = 0; i < ROWS; i++)
			table += actions.get(i) + " | " + gerund.get(i) + " | " + subject.get(i) + "\n";
		return table;
	}
}
