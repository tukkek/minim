package minim.controller.table;

import java.util.List;

public class Mummy extends Table {
	public static final Table INSTANCE = new Mummy();
	public static final Table DECREE = new SimpleTable("Mummy (decree)",
			List.of("Heart", "Spirit", "Essence", "Name", "Shadow"));
	public static final Table GUILD = new SimpleTable("Mummy (guild)", List.of("Engravers of amulets",
			"First alchemists", "Inscribers of texts", "Sheperds of the shell", "Builders of effigies"));

	Mummy() {
		super("Mummy");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Decree", DECREE);
		l.add("Guild", GUILD);
		return l.toString();
	}
}
