package minim.controller.table.innomine;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class Song extends Table {
	public static final String ETHEREAL = "Ethereal";
	public static final String CORPOREA = "Corporeal";
	public static final String CELESTIAL = "Celestial";
	public static final Table TYPE = new SimpleTable("Song (type)", List.of(CELESTIAL, CORPOREA, ETHEREAL));
	public static final String TONGUES = "Tongues";
	public static final String THUNDER = "Thunder";
	public static final String SHIELDS = "Shields";
	public static final String PROJECTION = "Projection";
	public static final String POSSESSION = "Possession";
	public static final String CORPUS = "Numinous Corpus";
	public static final String MOTION = "Motion";
	public static final String LIGHT = "Light";
	public static final String HEALING = "Healing";
	public static final String HARMONY = "Harmony";
	public static final String FORM = "Form";
	public static final String ENTROPY = "Entropy";
	public static final String DREAMS = "Dreams";
	public static final String CHARM = "Charm";
	public static final String ATTRACTION = "Attraction";
	public static final String AFFINITY = "Affinity";
	public static final List<String> SONGS = List.of(AFFINITY, ATTRACTION, CHARM, DREAMS, ENTROPY, FORM, HARMONY,
			HEALING, LIGHT, MOTION, CORPUS, POSSESSION, PROJECTION, SHIELDS, THUNDER, TONGUES);
	public static final Song INSTANCE = new Song(SONGS);

	List<String> songs;
	List<String> types;

	public Song(List<String> songs, List<String> types) {
		super("Song");
		this.songs = songs;
		this.types = types;
	}

	public Song(List<String> songs) {
		this(songs, TYPE.lines);
	}

	@Override
	public void build() {
		for (var s : songs)
			for (var t : types)
				add(t + " " + s.toLowerCase());
	}

	public Set<String> roll(int amount) {
		if (lines.isEmpty())
			roll();
		if (amount > lines.size())
			throw new RuntimeException("Too few songs!");
		var songs = new TreeSet<String>();
		while (songs.size() < amount) {
			songs.add(roll());
		}
		return songs;
	}
}
