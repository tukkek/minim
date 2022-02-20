package minim.controller.table.weather;

public class TemperateWinter extends Temperate {
	public static final TemperateWinter SINGLETON = new TemperateWinter();

	TemperateWinter() {
		super("Weather (temperate, winter)");
		normal = "Cold";
		inclement = "Snow";
		storm = "Snowstorm";
		hazard = "Blizzard";
	}
}
