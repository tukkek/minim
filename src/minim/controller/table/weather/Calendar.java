package minim.controller.table.weather;

import java.util.HashMap;

import minim.controller.table.Table;

public class Calendar extends Table {
	public static final Calendar SINGLETON = new Calendar();

	static final HashMap<String, Table> CLIMATES = new HashMap<>();

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
		for (var i = 1; i <= 30; i++) {
			s += "Day %s - %s\n".formatted(i, t.roll());
		}
		return s;
	}
}
