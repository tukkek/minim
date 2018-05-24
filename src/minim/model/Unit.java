package minim.model;

import java.util.ArrayList;

import minim.controller.Cancel;
import minim.controller.action.base.Action;

public interface Unit {
	String getname();

	void run(Action action) throws Cancel;

	void setname(String name);

	void remove(ArrayList<Unit> units);
}
