package minim.controller.action.base;

import java.util.ArrayList;
import java.util.List;

import minim.controller.Cancel;
import minim.model.Unit;
import minim.view.Output;

public class BasicAction extends Action {
	public static final String[] PHYSICAL = new String[] { "&brawl", "&coordination", "&shooting", "sp&orts", "s&teal",
			"&physical" };
	public static final String[] SOCIAL = new String[] { "&animals", "&coercion", "c&ommunication", "&languages",
			"&perception", "&social" };
	public static final String[] MENTAL = new String[] { "&art", "&cure", "&security", "&technology", "&knowledge",
			"&mental" };
	public static final List<String> SKILLS = new ArrayList<>(5 * 3);

	static {
		for (var skills : List.of(PHYSICAL, SOCIAL, MENTAL))
			for (var i = 0; i < 5; i++)
				SKILLS.add(skills[i].replace("&", ""));
	}

	static final String[] DESCRIBERESULT = new String[] { "Terrible!", "Failure.", "Neutral.", "Success.", "Amazing!" };

	protected String attribute;
	protected String skill;

	public BasicAction(String attribute, String skill, Unit u) {
		super(u);
		this.attribute = attribute;
		this.skill = skill.replaceAll("&", "");
		applymodifier = true;
	}

	@Override
	public int run(minim.model.Character c) throws Cancel {
		final int result = c.roll(attribute, skill, this);
		Output.print(c + " rolls " + skill + ". " + DESCRIBERESULT[result + 2]);
		return result;
	}
}
