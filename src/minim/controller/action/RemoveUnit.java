package minim.controller.action;

import minim.Minim;
import minim.controller.Cancel;
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
	public void run() throws Cancel {
		unit.remove(this.unitsView.units);
		/*
		 * for some reason it's losing focus on removal, requires user to click
		 * instead of using keyboard accelerator shortcuts
		 */
		Minim.shell.setFocus();
	}
}