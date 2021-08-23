
package minim.view.command.notepad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import minim.view.Notepad;

public class Export {
	@Execute
	public void execute() {
		var t = Notepad.singleton.text;
		var s = t.getShell();
		var d = new FileDialog(s, SWT.SAVE);
		d.setFileName("notepad.txt");
		var path = d.open();
		if (path == null)
			return;
		try {
			Files.writeString(Path.of(path), t.getText(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			alert("Exported successfully!", SWT.ICON_INFORMATION, s);
		} catch (IOException e) {
			alert(e.toString(), SWT.ICON_ERROR, s);
		}
	}

	static void alert(String text, int icon, Shell s) {
		var b = new MessageBox(s, icon);
		b.setMessage(text);
		b.open();
	}
}
