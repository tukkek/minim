
package minim.view.command.notepad;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Font;

import minim.view.Notepad;

public class EnlargeFont {
	int change = +1;

	public EnlargeFont() {
		super();
	}

	protected EnlargeFont(int change) {
		this.change = change;
	}

	@Execute
	public void execute() {
		var t = Notepad.singleton.text;
		var fd = t.getFont().getFontData();
		for (int i = 0; i < fd.length; ++i)
			fd[i].setHeight(fd[i].getHeight() + change);
		var f = new Font(t.getDisplay(), fd);
		t.setFont(f);
		t.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				f.dispose();
			}
		});
	}
}
