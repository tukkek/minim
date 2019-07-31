
package minim.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import minim.controller.table.Table;
import minim.controller.table.adventure.Adventure;
import minim.controller.table.adventure.BadGuy;
import minim.controller.table.adventure.Location;
import minim.controller.table.adventure.Motive;
import minim.controller.table.gme.SceneTone;
import minim.controller.table.gme.SceneTwist;
import minim.controller.table.gme.Unexpectedly;
import minim.controller.table.gme.YesNo;
import minim.controller.table.gme.YesNoAdvantage;
import minim.controller.table.gme.YesNoConflict;
import minim.controller.table.gme.YesNoDisadvantage;
import minim.controller.table.gme.YesNoEnding;
import minim.controller.table.gme.YesNoKnowledge;

public class Tables {
	static class Category {
		String title;
		List<Table> tables;

		public Category(String title, List<Table> tables) {
			super();
			this.title = title;
			this.tables = new ArrayList<>(tables);
			this.tables.sort((a, b) -> a.title.compareTo(b.title));
		}
	}

	static final Category GME = new Category("GM engine",
			List.of(new SceneTone(), SceneTwist.SINGLETON, YesNo.SINGLETON, new YesNoAdvantage(),
					new YesNoDisadvantage(), new YesNoKnowledge(), Unexpectedly.SINGLETON, new YesNoConflict(),
					new YesNoEnding()));
	static final Category ADVENTUREGENERATOR = new Category("Adventure generator",
			List.of(new Adventure(), Location.SINGLETON, BadGuy.SINGLETON,
					minim.controller.table.adventure.Character.SINGLETON, Motive.SINGLETON,
					minim.controller.table.adventure.Object.SINGLETON, Location.ANYTOWN, Location.OUTERSPACE,
					Location.OUTSIDEOFTOWN, Location.THECITY));
	static final List<Category> CATEGORIES = new ArrayList<>(List.of(GME, ADVENTUREGENERATOR));

	static {
		CATEGORIES.sort((a, b) -> a.title.compareTo(b.title));
	}

	@Inject
	public Tables() {

	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		var tree = new Tree(parent, SWT.SINGLE);
		tree.addListener(SWT.MouseDown, e -> {
			var i = tree.getItem(new Point(e.x, e.y));
			if (i == null)
				return;
			var t = (Table) i.getData();
			if (t == null)
				return;
			var result = t.roll();
			if (!result.endsWith("."))
				result += ".";
			Output.print(t.title + ": " + result + "\n");
		});
		for (var c : CATEGORIES) {
			var category = new TreeItem(tree, SWT.NONE);
			category.setText(c.title);
			category.setExpanded(false);
			for (var t : c.tables) {
				var i = new TreeItem(category, SWT.NONE);
				i.setText(t.title);
				i.setData(t);
			}
		}
	}
}