package minim.controller.table.weather;

public class Cold extends Weather {
	public static final Cold SINGLETON = new Cold();

	Cold() {
		super("Weather (cold)");
		normal = "Cold, calm";
		abnormal1odds = 3;
		abnormal1 = "Heat wave";
		abnormal2odds = 7;
		abnormal2 = "Cold snap";
		inclement = "Snow";
		storm = "Snowstorm";
		hazard = "Blizzard";
	}
}
