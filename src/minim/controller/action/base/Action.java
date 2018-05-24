package minim.controller.action.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;

import minim.Minim;
import minim.controller.Cancel;
import minim.model.Unit;
import minim.view.Output;

public abstract class Action extends SelectionAdapter {

	public boolean applymodifier = true;
	protected Unit unit;

	public Action(Unit u) {
		unit = u;
	}

	@Override
	public void widgetSelected(SelectionEvent event) {
		try {
			run();
		} catch (Cancel c) {
			return;
		} catch (RuntimeException e) {
			e.printStackTrace();
			show(e);
		}
	}

	int show(RuntimeException e) {
		MessageBox dialog = new MessageBox(Minim.shell,
				SWT.ICON_ERROR | SWT.OK);
		dialog.setText("Error");
		dialog.setMessage(e.getLocalizedMessage());
		return dialog.open();
	}

	public void run() throws Cancel {
		prepare();
		unit.run(this);
		Output.print("\n");
	}

	protected void prepare() {
		// nothing by default
	}

	abstract public int run(minim.model.Character character) throws Cancel;
}
