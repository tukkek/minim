package minim.model;

import java.io.Serializable;
import java.util.ArrayList;

import minim.controller.action.base.Action;
import minim.view.UnitList;
import minim.view.dialog.LazyInputDialog;

public class Group implements Unit, Serializable {
	public class GroupSelectionDialog extends LazyInputDialog {
		public GroupSelectionDialog(ArrayList<Character> characters) {
			super("Which characters should be part of this group?", true,
					characters);
		}

		@Override
		protected boolean isselected(Object o, int i) {
			return group.contains(o);
		}
	}

	public ArrayList<Character> group = new ArrayList<>();
	public String name;

	public Group(String name) {
		this.name = name;
	}

	@Override
	public String getname() {
		return name;
	}

	@Override
	public void run(Action action) {
		for (Character c : group) {
			action.run(c);
		}
	}

	public void selectgroup(ArrayList<Character> characters) {
		ArrayList<Integer> selection = new GroupSelectionDialog(characters)
				.getselection();
		group.clear();
		for (int i : selection) {
			group.add(characters.get(i));
		}
	}

	@Override
	public void setname(String name) {
		this.name = name;
	}

	public void remove(Character c) {
		group.remove(c);
	}

	@Override
	public void remove(ArrayList<Unit> units) {
		units.remove(this);
		UnitList.singleton.updateunits();
	}
}
