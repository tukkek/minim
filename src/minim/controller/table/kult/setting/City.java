package minim.controller.table.kult.setting;

import java.util.List;

import minim.controller.table.MetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;
import minim.model.Character;

public class City extends MetaTable {
	public static final Table EXPOSED = new Table("The City (exposed place)") {
		@Override
		public void build() {
			rebuild = true;
			var p = Portal.INSTANCE.roll();
			var i = Inferno.INSTANCE.roll();
			var m = Metropolis.INSTANCE.roll();
			var c = Cult.TYPE.roll();
			add("Slum to " + m);
			add("Prison to " + i);
			add("Crime scene to " + (Character.roll(2) == 1 ? i : m));
			add("Cult grounds of " + c);
			add("Corporation headquarters of " + c);
			add("Battlefield to " + i);
			add("Disaster area to " + m);
			add("Mental institution to %s".formatted(i));
			add("Industrial district to %s".formatted(Metropolis.MACHINECITY));
			add("Realm of Madmen (a homeless commune for the insane) to %s".formatted(p));
		}
	};
	public static final Table UNDERGROUND = new SimpleTable("The City (underground)",
			List.of("Sewers", "Subway", "Service tunnels", "Bomb shelter", "Military base"));
	public static final Table TRANSPORT = new SimpleTable("The city (transport)",
			List.of("Taxi", "Car ride", "Road tunnel", "Night bus", "The subway", "Train station"));
	public static final Table COMMUNICATION = new SimpleTable("The city (communication)",
			List.of("Phone booth", "Grafitti"));
	public static final Table INSTITUTION = new SimpleTable("The city (institution)",
			List.of("Police station", "University", "Hospital"));

	public City() {
		super("The City");
		rebuild = true;
	}

	@Override
	public void build() {
		for (var table : List.of(EXPOSED, Being.INSTANCE, UNDERGROUND, TRANSPORT, COMMUNICATION, INSTITUTION))
			add(table);
		add("Front to " + Metropolis.INSTANCE.roll());
		add("Lictor residence of " + Being.ARCHONS.roll());
		add("Hidden temple of " + Cult.TYPE.roll());
		add("Graveyeard, which may lead to " + Metropolis.CITYOFTHEDEAD);
		add("Permanent portal to to " + Portal.INSTANCE.roll());
		add("Real-world counterpart of " + Metropolis.LIVINGCITY.roll());
	}
}
