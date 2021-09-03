package minim.controller.table.chronicles.kindred;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import minim.controller.table.Table;

public class Kindred extends Table {
	public static final Table URBAN = new Kindred("Kindred (urban)", Clan.URBAN);
	public static final Table RURAL = new Kindred("Kindred (rural)", Clan.RURAL);

	static final Map<Table, String> TRAITS = new HashMap<>();

	static {
		TRAITS.put(Clan.RURAL, "Clan");
		TRAITS.put(Clan.URBAN, "Clan");
		TRAITS.put(Type.INSTANCE, "Type");
		TRAITS.put(Generation.INSTANCE, "Generation");
		TRAITS.put(Age.INSTANCE, "Age");
	}

	Table clan;

	Kindred(String title, Table clan) {
		super(title);
		this.clan = clan;
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return List.of(Type.INSTANCE, clan, Generation.INSTANCE, Age.INSTANCE).stream()
				.map(t -> TRAITS.get(t) + ": " + t.roll().toLowerCase() + ".").collect(Collectors.joining("\n"));
	}
}
