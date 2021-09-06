
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

import minim.controller.table.Mummy;
import minim.controller.table.Table;
import minim.controller.table.adventure.Type;
import minim.controller.table.adventure.dungeon.Dungeon;
import minim.controller.table.adventure.dungeon.Grid;
import minim.controller.table.adventure.dungeon.Map;
import minim.controller.table.adventure.dungeon.Motif;
import minim.controller.table.adventure.dungeon.lore.Backstory;
import minim.controller.table.adventure.dungeon.lore.Information;
import minim.controller.table.adventure.dungeon.lore.Occupant;
import minim.controller.table.adventure.dungeon.lore.Purpose;
import minim.controller.table.adventure.weather.Cold;
import minim.controller.table.adventure.weather.Desert;
import minim.controller.table.adventure.weather.Temperate;
import minim.controller.table.adventure.weather.TemperateSummer;
import minim.controller.table.adventure.weather.TemperateWinter;
import minim.controller.table.adventure.weather.Weather;
import minim.controller.table.adventurecrafter.Adventure;
import minim.controller.table.adventurecrafter.CharacterCrafter;
import minim.controller.table.adventurecrafter.PlotPoint;
import minim.controller.table.adventurecrafter.Plotline;
import minim.controller.table.adventurecrafter.TurningPoint;
import minim.controller.table.bold.ArcedWaylay;
import minim.controller.table.bold.Connection;
import minim.controller.table.bold.Waylay;
import minim.controller.table.combat.Action;
import minim.controller.table.combat.ActionType;
import minim.controller.table.combat.Twist;
import minim.controller.table.combat.Wound;
import minim.controller.table.conjectural.SceneTone;
import minim.controller.table.conjectural.SceneTwist;
import minim.controller.table.conjectural.Unexpectedly;
import minim.controller.table.conjectural.YesNo;
import minim.controller.table.conjectural.YesNoAdvantage;
import minim.controller.table.conjectural.YesNoDisadvantage;
import minim.controller.table.conjectural.loom.YesNoConflict;
import minim.controller.table.conjectural.loom.YesNoEnding;
import minim.controller.table.conjectural.loom.YesNoKnowledge;
import minim.controller.table.cyberpunk.Enemy;
import minim.controller.table.cyberpunk.Family;
import minim.controller.table.cyberpunk.LifeEvent;
import minim.controller.table.cyberpunk.Lifepath;
import minim.controller.table.cyberpunk.LifepathMotivation;
import minim.controller.table.cyberpunk.Romance;
import minim.controller.table.cyberpunk.Sibling;
import minim.controller.table.cyberpunk.Style;
import minim.controller.table.darkness.Beast;
import minim.controller.table.darkness.Bound;
import minim.controller.table.darkness.Changeling;
import minim.controller.table.darkness.Demon;
import minim.controller.table.darkness.Hunter;
import minim.controller.table.darkness.Kuejin;
import minim.controller.table.darkness.Monster;
import minim.controller.table.darkness.Promethean;
import minim.controller.table.darkness.Promethean.Athanor;
import minim.controller.table.darkness.Wraith;
import minim.controller.table.darkness.kindred.Age;
import minim.controller.table.darkness.kindred.Clan;
import minim.controller.table.darkness.kindred.Generation;
import minim.controller.table.darkness.kindred.Kindred;
import minim.controller.table.darkness.mage.Rank;
import minim.controller.table.darkness.mage.Tradition;
import minim.controller.table.darkness.mage.npc.HedgeMage;
import minim.controller.table.darkness.mage.npc.Mage;
import minim.controller.table.darkness.mage.npc.Marauder;
import minim.controller.table.darkness.mage.social.Chantry;
import minim.controller.table.darkness.mage.social.Convention;
import minim.controller.table.darkness.mage.social.Labyrinth;
import minim.controller.table.darkness.werewolf.Tribe;
import minim.controller.table.darkness.werewolf.Werewolf;
import minim.controller.table.hexcrawl.Elevation;
import minim.controller.table.hexcrawl.Hex;
import minim.controller.table.hexcrawl.PointOfInterest;
import minim.controller.table.hexcrawl.Vegetation;
import minim.controller.table.hexcrawl.Water;
import minim.controller.table.innomine.Artifact;
import minim.controller.table.innomine.Discord;
import minim.controller.table.innomine.Role;
import minim.controller.table.innomine.Song;
import minim.controller.table.innomine.character.Angel;
import minim.controller.table.innomine.character.Characters;
import minim.controller.table.innomine.character.Fiends;
import minim.controller.table.innomine.character.Reliever;
import minim.controller.table.innomine.character.Soldier;
import minim.controller.table.instant.InstantChallenge;
import minim.controller.table.instant.InstantCharacter;
import minim.controller.table.instant.InstantPlot;
import minim.controller.table.instant.InstantSetting;
import minim.controller.table.instant.Thing;
import minim.controller.table.instant.Trait;
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
import minim.controller.table.misc.Quantity;
import minim.controller.table.misc.RandomEncounter;
import minim.controller.table.mythic.EventFocus;
import minim.controller.table.mythic.EventMeaning;
import minim.controller.table.mythic.Fate;
import minim.controller.table.mythic.SceneChaos;
import minim.controller.table.steampunk.Diary;
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
import minim.controller.table.world.Personality;
import minim.controller.table.world.WorldNpc;

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
	static final Category DIARY = new Category("Steampunk diary",
			List.of(new Diary(), Diary.ALLEGIANCES, Diary.APPEARANCE, Diary.BACKGROUND, Diary.FAMILY, Diary.PERSONALITY,
					Diary.PREFERENCES, Diary.ROMANCE, Diary.SKILLS));
	static final Category ADVENTURECRAFTER = new Category("Adventure crafter",
			List.of(new Adventure(), Plotline.SINGLETON, PlotPoint.ACTION, PlotPoint.META, PlotPoint.MYSTERY,
					PlotPoint.PERSONAL, PlotPoint.SINGLETON, PlotPoint.SOCIAL, PlotPoint.TENSION, PlotPoint.THEME,
					TurningPoint.SINGLETON, new minim.controller.table.adventurecrafter.Character(),
					new CharacterCrafter(), CharacterCrafter.DESCRIPTOR, CharacterCrafter.IDENTITY,
					CharacterCrafter.TRAIT));
	static final Category INSTANT = new Category("Instant game",
			List.of(new InstantChallenge(), InstantCharacter.FLAW, InstantCharacter.PEOPLE,
					InstantCharacter.PERSONALITY, InstantCharacter.NORMAL, InstantCharacter.WEAK,
					InstantCharacter.FLAMBOYANT, InstantPlot.ACTION, InstantPlot.OPPOSITION, InstantPlot.SINGLETON,
					InstantSetting.PLACE, InstantSetting.POPULATION, InstantSetting.SINGLETON, InstantSetting.TECH,
					InstantSetting.TONE, Thing.DESCRIPTOR, Thing.SINGLETON, Trait.OTHER, Trait.RANKS, Trait.SINGLETON,
					Trait.SKILL, Trait.ATTRIBUTE));
	static final Category WORLD = new Category("Real-world NPC",
			List.of(new WorldNpc(), WorldNpc.RACE, WorldNpc.SEX, WorldNpc.AGE, WorldNpc.SEXUALITY, WorldNpc.RELIGION,
					WorldNpc.DISABILITY, WorldNpc.MENTALISSUE, Personality.INSTANCE, WorldNpc.HEALTH, WorldNpc.SIMPLE));
	static final Category HEXCRAWL = new Category("Hexcrawl",
			List.of(new Hex(), Hex.NEXT, Elevation.SINGLETON, Elevation.NEXT, PointOfInterest.SINGLETON,
					PointOfInterest.TYPES, Vegetation.SINGLETON, Vegetation.NEXT, Water.SINGLETON, Water.NEXT));
	static final Category COMBAT = new Category("Combat",
			List.of(Action.CAREFREE, Action.CAUTIOUS, Action.CERTAIN, Action.COWERING, Action.DARING, Action.TREMBLING,
					ActionType.SINGLETON, Twist.SINGLETON, Wound.HIT, Wound.CRITICAL, Wound.DEADLY));
	static final Category ADVENTURE = new Category("Adventure overview",
			List.of(new Type(), Motif.SINGLETON, Map.SINGLETON, Grid.SINGLETON, new Dungeon(), Backstory.SINGLETON,
					Purpose.SINGLETON, Occupant.SINGLETON, Information.CLUE, Information.RUMOR,
					Information.RUMORCONTENT, Information.WRITING, Information.SINGLETON,
					minim.controller.table.adventure.dungeon.Location.SINGLETON,
					minim.controller.table.adventure.dungeon.Location.EXOTIC));
	static final Category WEATHER = new Category("Weather",
			List.of(new Cold(), new Desert(), new Temperate(), new TemperateSummer(), new TemperateWinter(),
					new minim.controller.table.adventure.weather.Type(), Weather.SEASONS));
	static final Category MISC = new Category("Miscellaneous",
			List.of(new Quantity(), new RandomEncounter(), RandomEncounter.DELAY));
	static final Category MONSTER = new Category("World of darkness (monsters)",
			List.of(Wraith.INSTANCE, Hunter.INSTANCE, Werewolf.INSTANCE, Changeling.INSTANCE, Beast.INSTANCE,
					Demon.INSTANCE, Kindred.URBAN, Kindred.RURAL, HedgeMage.INSTANCE, Mage.INSTANCE, Kuejin.INSTANCE,
					Bound.INSTANCE, Promethean.INSTANCE, Mummy.INSTANCE, Monster.INSTANCE));
	static final Category DARKNESS = new Category("World of darkness", List.of(Monster.INSTANCE, Clan.ANARCH,
			Clan.CAMARILLA, Clan.INDEPENDENT, Clan.RURAL, Clan.SABBAT, Clan.URBAN, Generation.INSTANCE,
			minim.controller.table.darkness.kindred.Type.INSTANCE, Age.INSTANCE, Kindred.RURAL, Kindred.URBAN,
			minim.controller.table.darkness.mage.Faction.INSTANCE, Tradition.INSTANCE, Rank.TECHNOCRACY,
			Rank.TRADITIONS, new Chantry(), new Convention(), Convention.CONSTRUCT, Mage.INSTANCE, Mage.TRADITIONALIST,
			Mage.TECHNOCRAT, Rank.NEṔHANDI, Mage.NEPHANDI, new Labyrinth(), Labyrinth.FACTION, Rank.MARAUDER,
			Marauder.BACKRGOUND, Marauder.INSTANCE, Rank.ORPHAN, Mage.ORPHAN, HedgeMage.INSTANCE,
			HedgeMage.ORGANIZATION, Werewolf.AUSPICE, Tribe.FORSAKEN, Tribe.OTHER, Tribe.PURE, Tribe.INSTANCE,
			Werewolf.INSTANCE, Wraith.INSTANCE, Wraith.FACTIONS, Wraith.GUILDS, Wraith.HERETICS, Wraith.LEGIONS,
			Wraith.RENEGADES, Hunter.INSTANCE, Hunter.CREED, Hunter.MERCY, Hunter.VISION, Hunter.ZEAL, Hunter.COMPACT,
			Hunter.CONSPIRACY, Hunter.ORGANIZATION, Changeling.INSTANCE, Changeling.ADHENE, Changeling.COURT,
			Changeling.GALLAIN, Changeling.HOUSES, Changeling.HSIEN, Changeling.INANIMAE, Changeling.KITH,
			Changeling.KITHAIN, Changeling.NUNNEHI, Changeling.SEELIEHOUSES, Changeling.THALLAIN,
			Changeling.UNSEELIEHOUSES, Beast.INSTANCE, Beast.FAMILIES, Beast.HUNGER, Demon.INSTANCE, Demon.FACTION,
			Demon.HOUSE, Kuejin.INSTANCE, Kuejin.DHARMA, Kuejin.HERETICAL, Kuejin.ORTHODOX, Kuejin.CHI, Bound.INSTANCE,
			Bound.BURDEN, Bound.HAUNT, Bound.KEY, Promethean.INSTANCE, Promethean.LINEAGE, Promethean.REFINEMENT,
			Promethean.TRANSMUTATION, Athanor.FRANKENSTEIN, Athanor.GALATEA, Athanor.OSIRIS, Athanor.TAMMUZ,
			Athanor.ULGAN, Mummy.INSTANCE, Mummy.DECREE, Mummy.GUILD));
	static final Category INNOMINE = new Category("In nomine",
			List.of(Angel.INSTANCE, Angel.CHOIR, new Characters(), Role.INSTANCE, Role.FAME, Role.STATUS,
					minim.controller.table.innomine.character.Demon.BAND,
					minim.controller.table.innomine.character.Demon.INSTANCE, new Fiends(), Reliever.INSTANCE,
					Soldier.GOD, Soldier.HELL, Discord.INSTANCE, Discord.TYPE, Song.INSTANCE, Song.TYPE, new Artifact(),
					Artifact.COMPASS, Artifact.RELIC, Artifact.TALISMAN, Artifact.VESSEL, Artifact.LEVEL));
	static final List<Category> CATEGORIES = new ArrayList<>(
			List.of(CONJECTURAL, TOON, TAROT, MYTHIC, IRONSWORN, UNE, BOLD, CYBERPUNK, DIARY, ADVENTURECRAFTER, INSTANT,
					WORLD, HEXCRAWL, COMBAT, ADVENTURE, WEATHER, MISC, DARKNESS, MONSTER, INNOMINE));

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
			if (i == null) {
				return;
			}
			var t = (Table) i.getData();
			if (t == null) {
				return;
			}
			var result = t.roll();
			if (!result.endsWith(".") && !result.endsWith("?")) {
				result += ".";
			}
			if (result.contains("\n")) {
				result = "\n" + result;
			}
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