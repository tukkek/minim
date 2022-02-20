package minim.controller.table.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.Lines;
import minim.controller.table.Table;
import minim.controller.table.adventure.Type;
import minim.controller.table.adventure.dungeon.Dungeon;
import minim.controller.table.bold.Waylay;
import minim.controller.table.hexcrawl.Hexcrawl;
import minim.controller.table.instant.InstantSetting;
import minim.controller.table.toon.CartoonAdventure;
import minim.controller.table.weather.Calendar;

public class OneShot extends Table {
	static final List<String> ARC = List.of("Setup", "Confrontation", "Resolution");
	static final Map<String, Table> ADVENTURES = new HashMap<>();

	static {
		ADVENTURES.put(Type.DUNGEON, Dungeon.SINGLETON);
		ADVENTURES.put(Type.URBAN, CartoonAdventure.SINGLETON);
		ADVENTURES.put(Type.HEXCRAWL, Hexcrawl.SMALL);
	}

	public OneShot() {
		super("One-shot adventure");
	}

	@Override
	public void build() {
		// don't
	}

	@Override
	public String roll() {
		var l = new Lines();
		l.add("Setting", InstantSetting.SINGLETON);
		for (var a : ARC) {
			l.add();
			l.add(a + " chapter", Waylay.SINGLETON);
			l.add();
			var t = Type.SINGLETON.roll();
			l.add("%s module (%s):".formatted(a, t.toLowerCase()));
			l.add(ADVENTURES.get(t));
		}
		l.add();
		l.add(Calendar.SINGLETON);
		return l.toString();
	}

}
