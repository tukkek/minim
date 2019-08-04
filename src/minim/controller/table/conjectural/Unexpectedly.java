package minim.controller.table.conjectural;

import minim.controller.table.Table;

public class Unexpectedly extends Table {
	public static final Unexpectedly SINGLETON = new Unexpectedly();

	Unexpectedly() {
		super("Unexpectedly");
	}

	@Override
	public void build() {
		add(1, "foreshadowing (set a thread to be the main thread for the next scene)");
		add(2, "tying off (the main thread resolves or substantially moves forward)");
		add(3, "to conflict (transition to next scene, which centers on a conflict)");
		add(4, "costume change (an NPC drastically changes their mind, motivations, alliances...)");
		add(5, "key grip (set the location or elements for the next scene and start transition)");
		add(6, "to knowledge (transition to next scene, which centers on lore)");
		add(7, "framing (an NPC or object becomes critical to the main thread)");
		add(8, "set change (scene continues in another location)");
		add(9, "upstaged (NPC makes a big move or goes into overdrive)");
		add(10, "pattern change (the main thread gets modified, drastically)");
		add(11, "limelit (the rest of the scene goes great for the PCs)");
		add(12, "entering the red (threat of danger or combat arrives)");
		add(13, "to endings (transition to next scene, which resolves or moves forward a thread)");
		add(14, "montage (the timeframe of the scene changes)");
		add(15, "enter stage left (a PC or NPC arrives)");
		add(16, "cross-stitch (choose another thread to be the main thread for the rest of the scene)");
		add(17, "six-degrees (a connection forms between characters)");
//		add(18, "");
//		add(19, "");
//		add(20, "");
	}
}
