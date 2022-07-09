package minim.controller.table.innomine.character;

import minim.controller.table.Lines;
import minim.controller.table.MetaTable;
import minim.controller.table.Table;
import minim.controller.table.innomine.Discord;
import minim.controller.table.innomine.Song;

public class Characters extends MetaTable {
	public static abstract class Character extends Table {
		protected Song songs = Song.INSTANCE;
		int forces;

		protected Character(String title, int forces) {
			super(title);
			this.forces = forces;
		}

		protected Character(String title, int i, Song s) {
			this(title, i);
			this.songs = s;
		}

		@Override
		public void build() {
			// don't
		}

		protected abstract void define(Lines l);

		@Override
		public String roll() {
			var l = new Lines();
			define(l);
			l.add("Role", Role.INSTANCE);
			if (minim.model.Character.roll(10) == 10)
				l.add(Discord.TYPE.roll());
			l.addAll(songs.roll(forces - 5));
			return l.toString();
		}
	}

	public static final Table INSTANCE = new Characters();

	Characters() {
		super("Character");
	}

	@Override
	public void build() {
		add(100, Reliever.INSTANCE);
		add(60, Soldier.GOD);
		add(20, Soldier.HELL);
		add(2, Angel.INSTANCE);
		add(1, Demon.INSTANCE);
	}
}
