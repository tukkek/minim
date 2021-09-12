package minim.controller.table.kult.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Dream extends MetaTable {
	public static final String NORMAL = "Normal";
	public static final Table SPEED = new Table("Dream (speed)") {
		@Override
		public void build() {
			add(1, "Very slow (frozen time)");
			add(10, NORMAL);
			add(1, "Very fast (a week passes every five minutes)");
		}
	};
	public static final Table TYPE = new Table("Dream (type)") {
		@Override
		public void build() {
			add(10, NORMAL);
			add(10, "Nightmare");
			add(1, "Precognitive (about something that will happen in the future)");
		}
	};
	public static final Table BEING = new SimpleTable("Being (dream)", List.of(
			"Dream wanderer (a freely-wandering human who transferred his whole life force into dreams, often serves of a Dream Prince)",
			"Ichtyrian (a long shell with red eyes and large jaw with 20 spider legs, can devour people in dreams and reality at the same time)",
			"Psyphagus (usually inhabiting their own dreams, they are shadow-looking dreamers who lost access to their bodies and are looking to subdue someone in their dream and take over their body)"));
	public static final Table PRINCE = new SimpleTable("Being (dream prince)", List.of(
			"Hammad al-Sufi, oldest prince with a rock-city empire ranging from the Vortex to the Middle-East waking world",
			"Deride Aristides, prince from the future with an empire of cyberpunk cities, cyberspace, space-ships and space-stations",
			"Aaron Greenberg, rules over a fascist dream of military law and bureaucracy, often bringing waking people as inhabitants",
			"Friedich Köpfel, alchemist prince with an empire full of tempels and occult treasures, curses and the undead",
			"Nikolai Makarov, christian monk with an empire of hells, cathedrals and monasteries",
			"Samara Nyeme, wandering african princess of an empire of villages, famine, disasters, wars and dark gods",
			"Nicolette Pasteur, sickly princess of a chaotic empire of paranoia and nightmares",
			"Caren Birchlime, researcher of narcotics, youngest princess who lacked caution and was driven insane by the Vortex, now killing or maddening her citizens"));
	public static final Dream INSTANCE = new Dream();

	Dream() {
		super("Dream");
		rebuild = true;
	}

	@Override
	public void build() {
		var p = Portal.INSTANCE.roll();
		add(10, "Real dream (happens in some aspect of reality) in " + p);
		add(10, BEING);
		var characteristics = new ArrayList<String>();
		characteristics.add(SPEED.roll());
		characteristics.add(TYPE.roll());
		var suffix = characteristics.stream().filter(c -> c != NORMAL).collect(Collectors.joining(", ")).toLowerCase();
		if (!suffix.isEmpty())
			suffix = ", " + suffix;
		add(100, "Realistic dream (close to reality)" + suffix);
		add(10, "Abstract dream (distant from reality)" + suffix);
		for (var prince : PRINCE)
			add(1, "Realm of a Dream Prince (powerful dreaming entitier who built vast empires near the Vortex, which they hope to control and wage war over), "
					+ prince);
		add(1, "Vortex (origin of all dreams, source of the collective subconscious)");
	}
}
