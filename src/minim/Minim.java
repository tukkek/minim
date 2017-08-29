package minim;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import minim.view.UnitList;

public class Minim implements BundleActivator {
	public static final boolean DEBUG = false;
	public static final String BASEPATH = true ? ""
			: UnitList.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath();
	public static final String PLUGINID = "Minim";

	public static Minim singleton;

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
