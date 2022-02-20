package minim.controller.table.hexcrawl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import minim.controller.table.Table;
import minim.controller.table.hexcrawl.Hex.Hexagon;

/** TODO hexagonal map */
public class Hexcrawl extends Table {
	public static final Hexcrawl SMALL = new Hexcrawl(3);
	public static final Hexcrawl BIG = new Hexcrawl(5);

	String letters = "abcdefghijklmnopqrstuvwxyz";
	int size;

	Hexcrawl(int size) {
		super("Hexcrawl (%sx%s)".formatted(size, size));
		this.size = size;
	}

	@Override
	public void build() {
		// don't
	}

	public String roll() {
		Hexagon[][] map = new Hexagon[size][size];
		List<Hexagon> hexes = new ArrayList<>(size * size);
		HashMap<Hexagon, Character> legend = new HashMap<>(size * size);
		var ascii = "";
		var description = "";
		for (var y = 0; y < size; y++) {
			var shorter = y % 2 == 1;
			if (shorter)
				ascii += "  ";
			for (var x = 0; x < size - (shorter ? 1 : 0); x++) {
				Hexagon h;
				if (x == 0 && y == 0)
					h = new Hexagon();
				else if (x == 0 && y > 0)
					h = map[0][y - 1].next();
				else
					h = map[x - 1][y].next();
				map[x][y] = h;
				hexes.add(h);
				var l = letters.charAt(legend.size());
				if (h.interest())
					l = Character.toUpperCase(l);
				legend.put(h, l);
				ascii += l + "  ";
				description += "%s = %s\n".formatted(l, h.toString());
			}
			ascii += "\n";
		}
		return ascii + "\n" + description;
	}
}
