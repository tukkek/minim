package minim.controller.table.adventure.weather;

public class Temperate extends Weather {
	public Temperate() {
		this("Weather (temperate)");
	}

	protected Temperate(String title) {
		super(title);
		normal = "Temperate";
		abnormal1 = "Heat wave";
		abnormal2 = "Cold snap";
		inclement = "Rain";
		storm = "Thunderstorm";
		hazard = "Windstorm, hurricane or tornado";
	}
}
