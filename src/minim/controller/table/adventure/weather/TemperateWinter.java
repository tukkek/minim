package minim.controller.table.adventure.weather;

public class TemperateWinter extends Temperate {
	public TemperateWinter() {
		super("Weather (temperate, winter)");
		normal = "Cold";
		inclement = "Snow";
		storm = "Snowstorm";
		hazard = "Blizzard";
	}
}
