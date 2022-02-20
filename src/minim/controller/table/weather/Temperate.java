package minim.controller.table.weather;

public class Temperate extends Weather {
	public static final Temperate SINGLETON = new Temperate();

	Temperate() {
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
