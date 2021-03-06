package minim.controller.table.ironsworn;

import java.util.List;

import minim.controller.table.Table;
import minim.model.Character;

public class MysticBackslash extends Table {
	public MysticBackslash() {
		super("Mystic backslash");
	}

	@Override
	public void build() {
		add(List.of("Your ritual has the opposite affect", "You are sapped of strength",
				"Your friend, ally, or companion is adversely affected", "You destroy an important object",
				"You inadvertently summon a horror", "You collapse, and drift into a troubled sleep",
				"You undergo a physical torment which leaves its mark upon you",
				"You hear ghostly voices whispering of dark portents",
				"You are lost in shadow, and find yourself in another place without memory of how you got there",
				"You alert someone or something to your presence",
				"You are not yourself, and act against a friend, ally, or companion",
				"You affect or damage your surroundings, causing a disturbance or potential harm",
				"You waste resources", "You suffer the loss of a sense for several hours",
				"You lose your connection to magic for a day or so, and cannot perform rituals",
				"Your ritual affects the target in an unexpected and problematic way",
				"Your ritual reveals a surprising and troubling truth", "You are tempted by dark powers",
				"You see a troubling vision of your future",
				"You can't perform this ritual again until you acquire an important component",
				"You develop a strange fear or compulsion",
				"Your ritual causes creatures to exhibit strange or aggressive behavior",
				"You are tormented by an apparition from your past", "You are wracked with sudden sickness"));
	}

	@Override
	public String roll() {
		var result = super.roll();
		if (Character.roll(20) == 1)
			result += " and " + super.roll().toLowerCase();
		return result;
	}
}
