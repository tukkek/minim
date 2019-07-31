package minim.controller.table.adventure;

import java.util.List;

import minim.controller.table.Table;

public class Object extends Table {
	public static final Object SINGLETON = new Object();

	Object() {
		super("Object");
	}

	@Override
	public void build() {
		add(List.of("One of the other characters", "Steamroler", "Bucket of water", "oil can", "lit light bulb",
				"bagpipes", "toupee", "elephant", "charging bull", "spaceship", "boy choir", "safety pin", "tuba",
				"broom", "rope", "ostrich", "jack-in-the-box", "cannon", "magnifying glass", "cigar", "pie", "banana",
				"bow tie", "spring", "revolving door", "needle and thread", "propellor beanie", "seltzer bottle",
				"fake moustache", "sail boat", "penguin", "butterfly", "boxing gloves", "confetti",
				"character's clone"));
	}
}
