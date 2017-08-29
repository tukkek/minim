package minim.controller.action.base;

import minim.model.Unit;
import minim.view.Output;

public class BasicAction extends Action {
	public static final String[] PHYSICAL = new String[] { "brawl",
			"coordination", "shooting", "sports", "steal", "physical" };
	public static final String[] SOCIAL = new String[] { "animals", "coercion",
			"communication", "languages", "perception", "social" };
	public static final String[] MENTAL = new String[] { "art", "cure",
			"security", "technology", "knowledge", "mental" };

	private static final String[] DESCRIBERESULT = new String[] { "Terrible!",
			"Failure.", "Neutral.", "Success.", "Amazing!" };

	protected String attribute;
	protected String skill;

	public BasicAction(String attribute, String skill, Unit u) {
		super(u);
		this.attribute = attribute;
		this.skill = skill;
	}

	@Override
	public int run(minim.model.Character c) {
		final int result = c.roll(attribute, skill, this);
		Output.print(c + " rolls " + skill + ". " + DESCRIBERESULT[result + 2]);
		return result;
	}
}
