package minim.controller.table.weather;

import java.util.ArrayList;
import java.util.HashMap;

import minim.controller.table.Table;

public class Calendar extends Table {

	public static final Calendar SINGLETON = new Calendar();

	static final HashMap<String, Table> CLIMATES = new HashMap<>();
	static final int DAYS = 30;
	static final int COLUMNS = 4;

	static {
		CLIMATES.put(Climate.DESERT, Desert.SINGLETON);
		CLIMATES.put(Climate.COLD, Cold.SINGLETON);
		CLIMATES.put(Climate.SUMMER, TemperateSummer.SINGLETON);
		CLIMATES.put(Weather.AUTUMN, Temperate.SINGLETON);
		CLIMATES.put(Weather.SPRING, Temperate.SINGLETON);
		CLIMATES.put(Weather.SUMMER, TemperateSummer.SINGLETON);
		CLIMATES.put(Weather.WINTER, TemperateWinter.SINGLETON);
	}

	Calendar() {
		super("Calendar");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var c = Climate.SINGLETON.roll();
		if (c == Climate.SEASONS)
			c = Weather.SEASONS.roll();
		Table t = CLIMATES.get(c);
		var s = "%s\n".formatted(c);
		var dates = new ArrayList<String>(30);
		for (var i = 1; i <= DAYS; i++)
			dates.add("%s. %s".formatted(i, t.roll()));
		for (var i = 0; i < dates.size(); i += COLUMNS) {
			for (var d : dates.subList(i, Math.min(i + COLUMNS, dates.size())))
				s += d + " ";
			s += "\n";
		}
		return s;
	}
}
