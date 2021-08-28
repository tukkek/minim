package minim.controller.table.conjectural;

import minim.controller.table.Table;

public class Unexpectedly extends Table {
	public static final Unexpectedly SINGLETON = new Unexpectedly();

	Unexpectedly() {
		super("Unexpectedly");
	}

	@Override
	public void build() {
		add("foreshadowing (set a thread to be the main thread for the next scene)");
		add("tying off (the main thread resolves or substantially moves forward)");
		add("to conflict (transition to next scene, which centers on a conflict)");
		add("costume change (an NPC drastically changes their mind, motivations, alliances...)");
		add("key grip (set the location or elements for the next scene and start transition)");
		add("to knowledge (transition to next scene, which centers on lore)");
		add("framing (an NPC or object becomes critical to the main thread)");
		add("set change (scene continues in another location)");
		add("upstaged (NPC makes a big move or goes into overdrive)");
		add("pattern change (the main thread gets modified, drastically)");
		add("limelit (the rest of the scene goes great for the PCs)");
		add("entering the red (threat of danger or combat arrives)");
		add("to endings (transition to next scene, which resolves or moves forward a thread)");
		add("montage (the timeframe of the scene changes)");
		add("enter stage left (a PC or NPC arrives)");
		add("cross-stitch (choose another thread to be the main thread for the rest of the scene)");
		add("six-degrees (a connection forms between characters)");
	}
}
