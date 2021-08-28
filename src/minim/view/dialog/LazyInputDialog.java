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

import minim.controller.Cancel;

public class LazyInputDialog extends Dialog {
	protected boolean numbered = false;
	protected List<?> choices;
	protected String title;

	Integer selection;
	ArrayList<Integer> result = new ArrayList<>(1);
	Group group;
	String prompt;
	boolean multiple;

	/**
	 * Constructor.
	 * 
	 * @param a      Asserts this is a valid value
	 * @param prompt Previous message.
	 */
	public LazyInputDialog(final String prompt, boolean multiple, List<?> choices) {
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
		var dialog = (Composite) super.createDialogArea(parent);
		if (title != null) {
			getShell().setText(title);
		}
		group = new Group(dialog, SWT.NONE);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		group.setText(prompt);
		for (int i = 0; i < choices.size(); i++) {
			Object o = choices.get(i);
			Button b = new Button(group, multiple ? SWT.CHECK : SWT.RADIO);
			String number = numbered ? (i + 1) + ". " : "";
			b.setText("&" + number + o);
			if (isselected(o, i)) {
				b.setSelection(true);
				b.setFocus();
			}
		}
//		dialog.layout();	
		return dialog;
	}

	static final List<Integer> KEYS = List.of(SWT.KEYPAD_1, SWT.KEYPAD_1, SWT.KEYPAD_2, SWT.KEYPAD_3, SWT.KEYPAD_4,
			SWT.KEYPAD_5, SWT.KEYPAD_6, SWT.KEYPAD_7, SWT.KEYPAD_8, SWT.KEYPAD_9);

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

	public ArrayList<Integer> getselection() throws Cancel {
		int code = open();
		if (code == Dialog.CANCEL) {
			throw new Cancel();
		}
		return result;
	}

	public int getvalue() throws Cancel {
		return getselection().get(0);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}
}
