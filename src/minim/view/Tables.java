
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
import minim.controller.table.bold.ArcedWaylay;
import minim.controller.table.bold.Connection;
import minim.controller.table.bold.Waylay;
import minim.controller.table.conjectural.SceneTone;
import minim.controller.table.conjectural.SceneTwist;
import minim.controller.table.conjectural.Unexpectedly;
import minim.controller.table.conjectural.YesNo;
import minim.controller.table.conjectural.YesNoAdvantage;
import minim.controller.table.conjectural.YesNoConflict;
import minim.controller.table.conjectural.YesNoDisadvantage;
import minim.controller.table.conjectural.YesNoEnding;
import minim.controller.table.conjectural.YesNoKnowledge;
import minim.controller.table.cyberpunk.Enemy;
import minim.controller.table.cyberpunk.Family;
import minim.controller.table.cyberpunk.LifeEvent;
import minim.controller.table.cyberpunk.Lifepath;
import minim.controller.table.cyberpunk.LifepathMotivation;
import minim.controller.table.cyberpunk.Romance;
import minim.controller.table.cyberpunk.Sibling;
import minim.controller.table.cyberpunk.Style;
import minim.controller.table.ironsworn.ChallengeRank;
import minim.controller.table.ironsworn.CharacterGenerator;
import minim.controller.table.ironsworn.CombatAction;
import minim.controller.table.ironsworn.MysticBackslash;
import minim.controller.table.ironsworn.Oracles;
import minim.controller.table.ironsworn.PlotTwist;
import minim.controller.table.ironsworn.Region;
import minim.controller.table.ironsworn.SettlementName;
import minim.controller.table.ironsworn.SettlementTrouble;
import minim.controller.table.ironsworn.WaterLocation;
import minim.controller.table.mythic.EventFocus;
import minim.controller.table.mythic.EventMeaning;
import minim.controller.table.mythic.Fate;
import minim.controller.table.mythic.SceneChaos;
import minim.controller.table.tarot.Character;
import minim.controller.table.tarot.PlotGenerator;
import minim.controller.table.tarot.TarotCard;
import minim.controller.table.toon.BadGuy;
import minim.controller.table.toon.CartoonAdventure;
import minim.controller.table.toon.Location;
import minim.controller.table.toon.Motive;
import minim.controller.table.une.Importance;
import minim.controller.table.une.Mood;
import minim.controller.table.une.Motivation;
import minim.controller.table.une.Npc;
import minim.controller.table.une.PowerLevel;

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

	static final Category CONJECTURAL = new Category("Conjectural GME",
			List.of(new SceneTone(), SceneTwist.SINGLETON, YesNo.SINGLETON, new YesNoAdvantage(),
					new YesNoDisadvantage(), new YesNoKnowledge(), Unexpectedly.SINGLETON, new YesNoConflict(),
					new YesNoEnding()));
	static final Category TOON = new Category("Cartoon adventure", List.of(new CartoonAdventure(), Location.SINGLETON,
			BadGuy.SINGLETON, minim.controller.table.toon.Character.SINGLETON, Motive.SINGLETON,
			minim.controller.table.toon.Object.SINGLETON, Location.ANYTOWN, Location.OUTERSPACE, Location.OUTSIDEOFTOWN,
			Location.THECITY, CartoonAdventure.BATTLE, CartoonAdventure.CHASE, CartoonAdventure.MYSTERY,
			CartoonAdventure.RESCUE, CartoonAdventure.SURVIVAL, CartoonAdventure.THEFT));
	static final Category TAROT = new Category("Tarot",
			List.of(TarotCard.SINGLETON, TarotCard.MAJOR, TarotCard.CUPS, TarotCard.PENTACLES, TarotCard.SWORDS,
					TarotCard.WANDS, new Character(), new PlotGenerator(), PlotGenerator.ACT1, PlotGenerator.ACT2,
					PlotGenerator.ACT3));
	static final Category MYTHIC = new Category("Mythic GME",
			List.of(Fate.EVENODSS, Fate.IMPOSSIBLE, Fate.LIKELY, Fate.SURETHING, Fate.UNLIKELY, new EventFocus(),
					EventMeaning.SINGLETON, EventMeaning.ACTION, EventMeaning.SUBJECT, SceneChaos.LOW,
					SceneChaos.NORMAL, SceneChaos.HIGH));
	static final Category IRONSWORN = new Category("Ironsworn GME",
			List.of(new CharacterGenerator(), new minim.controller.table.ironsworn.Location(),
					minim.controller.table.ironsworn.Location.DESCRIPTOR, Oracles.ACTION, Oracles.THEME, new Region(),
					new WaterLocation(), new SettlementName(), new SettlementTrouble(), CharacterGenerator.DESCRIPTOR,
					CharacterGenerator.GOAL, CharacterGenerator.ROLE, new CombatAction(), new MysticBackslash(),
					new PlotTwist(), new ChallengeRank()));
	static final Category UNE = new Category("Universal NPC emulator",
			List.of(Importance.SINGLETON, Importance.DEMEANOR, Importance.FOCUS, Mood.FRIENDLY, Mood.HOSTILE,
					Mood.NEUTRAL, Motivation.SINGLETON, Motivation.NOUN, Motivation.VERB, new Npc(), Npc.MODIFIER,
					Npc.NOUN, PowerLevel.SINGLETON)) {
		{
			this.tables.addAll(Importance.BEARINGS.values());
		}
	};
	static final Category BOLD = new Category("Stories and deeds",
			List.of(new ArcedWaylay(), new Connection(), Connection.ACTION, Connection.GERUND, Connection.SUBJECT,
					Waylay.SINGLETON, Waylay.EASYFOES, Waylay.EPIC, Waylay.FACTIONAL, Waylay.HARDFOES, Waylay.HAVEN,
					Waylay.KNOWLEDGE, Waylay.MODIFIER, Waylay.NATURAL, Waylay.PARTY, Waylay.PERSONAL, Waylay.PHYSICAL,
					Waylay.SOLUTION));
	static final Category CYBERPUNK = new Category("Cyberpunk lifepath",
			List.of(Enemy.ACTION, Enemy.DIRECTION, Enemy.FORCES, Enemy.WHO, Enemy.WHY, new Enemy(), Family.CHILDHOOD,
					Family.NOPARENTS, Family.RANKING, Family.SINGLETON, Family.TRAGEDY, LifeEvent.BIGPROBLEMSBIGWINS,
					LifeEvent.DISASTER, LifeEvent.FRIEND, LifeEvent.FRIENDSFOES, LifeEvent.LUCKY, LifeEvent.SINGLETON,
					LifeEvent.ACTION, new Lifepath(), Lifepath.ETHNICITY, LifepathMotivation.PERSONALITY,
					LifepathMotivation.POSSESSION, LifepathMotivation.RELATIONS, LifepathMotivation.SINGLETON,
					LifepathMotivation.VALUED, LifepathMotivation.VALUES, Romance.FEELINGS, Romance.PROBLEMATIC,
					Romance.TRAGIC, new Romance(), Sibling.AGE, Sibling.FEELINGS, Sibling.GENDER, Sibling.SINGLETON,
					Style.AFFECTATION, Style.CLOTHES, Style.HAIR, Style.SINGLETON));
	static final List<Category> CATEGORIES = new ArrayList<>(
			List.of(CONJECTURAL, TOON, TAROT, MYTHIC, IRONSWORN, UNE, BOLD, CYBERPUNK));

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
			if (result.contains("\n"))
				result = "\n" + result;
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