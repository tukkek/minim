package minim.controller.action;

import minim.controller.Cancel;
import minim.controller.action.base.SimpleAction;
import minim.model.Group;
import minim.view.UnitList;

public class ModifyGroup extends SimpleAction {
	/**
	 * 
	 */
	private final UnitList unitsView;
	Group g;

	public ModifyGroup(UnitList unitsView, Group g) {
		super(g);
		this.unitsView = unitsView;
		this.g = g;
	}

	@Override
	public void run() throws Cancel {
		g.selectgroup(this.unitsView.getcharacters());
	}
}