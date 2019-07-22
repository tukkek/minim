package minim.view;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import minim.controller.StateManager;

public class Notepad {
	public static Notepad singleton;

	private Text text;

	private String saved;

	@PostConstruct
	public void createControls(Composite parent) {
		singleton = this;
		Composite layout = new Composite(parent, SWT.NONE);
		layout.setLayout(new FillLayout());
		text = new Text(layout, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		text.setBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		text.setText("Type your free-form text here :)");
		if (saved != null) {
			text.setText(saved);
		}
	}

	public static void print(String text) {
		singleton.text.append(text + "\n");
	}

	@PostConstruct
	public void start() {
		saved = (String) StateManager.load(Notepad.class);
	}

	@PersistState
	public void stop() {
		StateManager.save(Notepad.class, text.getText());
	}
}
