package minim.view;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class Output {
	public static Output singleton;

	Composite layout;

	private Text text;

	@PostConstruct
	public void createControls(Composite parent) {
		singleton = this;
		layout = new Composite(parent, SWT.NONE);
		layout.setLayout(new FillLayout());
		text = new Text(layout, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		text.setEditable(false);
	}

	public static void print(String text) {
		singleton.text.append(text + "\n");
	}

	public void clear() {
		text.setText("");
	}
}
