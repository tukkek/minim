package minim.controller.table.tarot;

import java.util.List;
import java.util.stream.Collectors;

import minim.controller.table.Table;

public class TarotTable extends Table {
	List<String> characteristics;

	public TarotTable(String title, List<String> characteristics) {
		super(title);
		this.characteristics = characteristics;
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		return characteristics.stream().map(c -> c + ": " + TarotCard.SINGLETON.roll())
				.collect(Collectors.joining("\n"));
	}

}