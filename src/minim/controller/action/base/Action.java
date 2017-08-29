package minim.controller.action.base;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import minim.model.Unit;

public abstract class Action extends SelectionAdapter {

	protected Unit unit;
	public boolean applymodifier = true;

	public Action(Unit u) {
		unit = u;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		run();
	}

	public void run() {
		prepare();
		unit.run(this);
	}

	protected void prepare() {
		// nothing by default
	}

	abstract public int run(minim.model.Character character);
}
