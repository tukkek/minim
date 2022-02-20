package minim.controller.table.weather;

public class TemperateSummer extends Temperate {
	public static final TemperateSummer SINGLETON = new TemperateSummer();

	TemperateSummer() {
		super("Weather (temperate, summer)");
		normal = "Warm";
	}
}
