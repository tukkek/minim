package minim.controller.action;

import minim.controller.Cancel;
import minim.controller.action.base.SimpleAction;
import minim.model.Unit;
import minim.view.UnitList;

public class ChangeName extends SimpleAction {
	/**
	 * 
	 */
	private final UnitList unitsView;
	Unit u;

	public ChangeName(UnitList unitsView, Unit u) {
		super(u);
		this.unitsView = unitsView;
		this.u = u;
	}

	@Override
	public void run() throws Cancel {
		String prompt = "What shall be the new name?";
		String name = UnitList.getname(prompt, u.getname());
		if (name != null) {
			u.setname(name);
			this.unitsView.update();
		}
	}
}