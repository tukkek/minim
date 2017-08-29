package minim.controller.action;

import minim.controller.action.base.SimpleAction;
import minim.model.Unit;
import minim.view.UnitList;

public class RemoveUnit extends SimpleAction {
	/**
	 * 
	 */
	private final UnitList unitsView;

	public RemoveUnit(UnitList unitsView, Unit u) {
		super(u);
		this.unitsView = unitsView;
	}

	@Override
	public void run() {
		unit.remove(this.unitsView.units);
	}
}