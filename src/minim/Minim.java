package minim;

import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Minim implements BundleActivator {
	public static final boolean DEBUG = false;
	public static final String BASEPATH = "";
	public static final String PLUGINID = "Minim";

	public static Minim singleton;
	public static Shell shell;

	public Minim() {
		singleton = this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}
}
