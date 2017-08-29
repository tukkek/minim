package minim.view.command;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

import minim.view.Output;

public class ClearOutput {
	@Execute
	public void execute(IWorkbench workbench) {
		Output.singleton.clear();
	}
}
