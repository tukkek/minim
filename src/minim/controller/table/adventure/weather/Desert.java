package minim.controller.table.adventure.weather;

public class Desert extends Weather {
	public Desert() {
		super("Weather (desert)");
		normal = "Hot, calm";
		abnormal1odds = 10;
		abnormal1 = "Hot, windy";
		abnormal2odds = 0;
		inclement = "Hot windy";
		storm = "Sandstorm";
		hazard = "Downpour";
	}
}
