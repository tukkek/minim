package minim.view.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;

public class LazyInputDialog extends Dialog {
	Integer selection;
	ArrayList<Integer> result = new ArrayList<>(1);
	Group group;
	String prompt;
	private boolean multiple;
	protected List<?> choices;
	protected String title;

	/**
	 * Constructor.
	 * 
	 * @param a
	 *            Asserts this is a valid value
	 * @param prompt
	 *            Previous message.
	 */
	public LazyInputDialog(final String prompt, boolean multiple,
			List<?> choices) {
		super(Display.getCurrent().getActiveShell());
		this.prompt = prompt;
		this.multiple = multiple;
		this.choices = choices;
		setBlockOnOpen(true);
	}

	/**
	 * @see org.eclipse.jface.dialogs.InputDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		if (title != null) {
			getShell().setText(title);
		}
		group = new Group(parent, SWT.NONE);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		group.setText(prompt);
		for (int i = 0; i < choices.size(); i++) {
			Object o = choices.get(i);
			Button b = new Button(group, multiple ? SWT.CHECK : SWT.RADIO);
			b.setText(o.toString());
			if (isselected(o, i)) {
				b.setSelection(true);
				b.setFocus();
			}
		}
		parent.layout();
		return parent;
	}

	protected boolean isselected(Object o, int i) {
		return false;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		Control[] children = group.getChildren();
		for (int i = 0; i < children.length; i++) {
			Button b = (Button) children[i];
			if (b.getSelection()) {
				result.add(i);
				if (!multiple) {
					break;
				}
			}
		}
		super.buttonPressed(buttonId);
	}

	public ArrayList<Integer> getselection() {
		open();
		return result;
	}

	public int getvalue() {
		return getselection().get(0);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
	}
}
