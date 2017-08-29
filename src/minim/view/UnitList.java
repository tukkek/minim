package minim.view;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import minim.Minim;
import minim.controller.StateManager;
import minim.controller.action.ChangeName;
import minim.controller.action.DetermineOrder;
import minim.controller.action.ModifyDamage;
import minim.controller.action.ModifyGroup;
import minim.controller.action.RemoveUnit;
import minim.controller.action.attack.Attack;
import minim.controller.action.base.Action;
import minim.controller.action.base.BasicAction;
import minim.model.Character;
import minim.model.Group;
import minim.model.Unit;

public class UnitList {
	public class AddCharacter extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			String name = UnitList.getname("What is the new character's name?",
					"");
			if (name != null && !name.isEmpty()) {
				units.add(new Character(name));
			}
			updateunits();
		}
	}

	public class AddGroup extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			ArrayList<Character> characters = getcharacters();
			if (characters.size() < 2) {
				return;
			}
			String name = getname("What is the new group's name?", "");
			if (name != null && !name.isEmpty()) {
				Group g = new Group(name);
				units.add(g);
				g.selectgroup(characters);
				updateunits();
			}
		}
	}

	public class DetermineAll extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			ArrayList<Character> all = getcharacters();
			if (!all.isEmpty()) {
				new DetermineOrder(null).determineorder(all);
			}
		}
	}

	class ShowMenu extends SelectionAdapter {
		private final Menu menu;
		private Button b;

		ShowMenu(Menu menu, Button b) {
			this.menu = menu;
			this.b = b;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			Rectangle bounds = b.getBounds();
			Point point = b.getParent().toDisplay(bounds.x + bounds.width,
					bounds.y);
			menu.setLocation(point);
			menu.setVisible(true);
		}
	}

	public static UnitList singleton;

	public ArrayList<Unit> units = new ArrayList<>();
	Composite unitsarea;
	Composite layout;

	@PostConstruct
	public void createControls(Composite parent) {
		singleton = this;
		layout = new Composite(parent, SWT.NONE);
		layout.setLayout(new RowLayout(SWT.VERTICAL));
		Composite add = new Composite(layout, SWT.NONE);
		add.setLayout(new FillLayout(SWT.HORIZONTAL));
		addbutton(add, "Add character", new AddCharacter());
		addbutton(add, "Add group", new AddGroup());
		addbutton(add, "Determine order", new DetermineAll());
		new Label(layout, SWT.NONE);
		unitsarea = new Composite(layout, SWT.NONE);
		unitsarea.setLayout(new FillLayout(SWT.VERTICAL));
		updateunits();
	}

	void addbutton(Composite add, String string, SelectionListener l) {
		Button b = new Button(add, SWT.NONE);
		b.setText(string);
		b.addSelectionListener(l);
	}

	public void updateunits() {
		for (Control w : unitsarea.getChildren()) {
			w.dispose();
		}
		for (int i = 0; i < units.size(); i++) {
			Unit u = units.get(i);
			Button b = new Button(unitsarea, SWT.NONE);
			int accelerator = i + 1;
			String suffix = "";
			if (accelerator < 10) {
				suffix = " (&" + accelerator + ")";
			}
			b.setText(u.getname() + suffix);
			String icon = u instanceof Character ? "krusader.png" : "kuser.png";
			b.setImage(new Image(Display.getCurrent(),
					Minim.BASEPATH + "icons" + File.separator + icon));
			Menu m = addmenu(b, u);
			b.addSelectionListener(new ShowMenu(m, b));
		}
		/* Shouldn't have to do this manually but it bugs otherwise. */
		layout.layout();
		unitsarea.layout();
	}

	Menu addmenu(Button b, Unit u) {
		final Menu menu = new Menu(b);
		b.setMenu(menu);
		final Menu attack = addsubmenu(menu, "Attack");
		for (String s : Attack.ATTACKS) {
			addmenuitem(s, b, attack, new Attack(s, u));
		}
		final Menu physical = addsubmenu(menu, "Physical");
		for (String s : BasicAction.PHYSICAL) {
			addmenuitem(s, b, physical, new BasicAction("physical", s, u));
		}
		final Menu social = addsubmenu(menu, "Social");
		for (String s : BasicAction.SOCIAL) {
			addmenuitem(s, b, social, new BasicAction("social", s, u));
		}
		final Menu mental = addsubmenu(menu, "Mental");
		for (String s : BasicAction.MENTAL) {
			addmenuitem(s, b, mental, new BasicAction("mental", s, u));
		}
		if (u instanceof Group) {
			final Menu group = addsubmenu(menu, "Group");
			Group g = (Group) u;
			addmenuitem("Determine order", b, group, new DetermineOrder(g));
			addmenuitem("Modify group", b, group, new ModifyGroup(this, g));
		}
		addmenuitem("Modify damage", b, menu, new ModifyDamage(u));
		addmenuitem("Change name", b, menu, new ChangeName(this, u));
		addmenuitem("Remove", b, menu, new RemoveUnit(this, u));
		return menu;
	}

	Menu addsubmenu(final Menu menu, String label) {
		final MenuItem submenushell = new MenuItem(menu, SWT.CASCADE);
		submenushell.setText(label);
		final Menu submenu = new Menu(menu);
		submenushell.setMenu(submenu);
		return submenu;
	}

	void addmenuitem(String label, Button b, Menu menu, Action a) {
		MenuItem i = new MenuItem(menu, SWT.NONE);
		i.setText("&" + label);
		i.addSelectionListener(a);
	}

	@Focus
	public void onFocus() {

	}

	public ArrayList<Character> getcharacters() {
		ArrayList<Character> characters = new ArrayList<>();
		for (Unit u : units) {
			if (u instanceof Character) {
				characters.add((Character) u);
			}
		}
		return characters;
	}

	public static String getname(String message, String previous) {
		InputDialog d = new InputDialog(Display.getCurrent().getActiveShell(),
				message, message, previous, null);
		d.setBlockOnOpen(true);
		d.open();
		return d.getValue();
	}

	@PostConstruct
	public void start() {
		ArrayList<Unit> units = (ArrayList<Unit>) StateManager
				.load(UnitList.class);
		if (units != null) {
			this.units = units;
			updateunits();
		}
	}

	@PersistState
	public void stop() {
		StateManager.save(UnitList.class, units);
	}
}
