
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
import minim.controller.table.adventure.journey.Journey;
import minim.controller.table.adventure.journey.JourneyHelpers;
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
import minim.controller.table.darkness.WodArtifact;
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
import minim.controller.table.falkenstein.Diary;
import minim.controller.table.hexcrawl.Elevation;
import minim.controller.table.hexcrawl.Hex;
import minim.controller.table.hexcrawl.Hexcrawl;
import minim.controller.table.hexcrawl.PointOfInterest;
import minim.controller.table.hexcrawl.Vegetation;
import minim.controller.table.hexcrawl.Water;
import minim.controller.table.innomine.Artifact;
import minim.controller.table.innomine.Discord;
import minim.controller.table.innomine.Song;
import minim.controller.table.innomine.character.Angel;
import minim.controller.table.innomine.character.Characters;
import minim.controller.table.innomine.character.Fiends;
import minim.controller.table.innomine.character.Reliever;
import minim.controller.table.innomine.character.Role;
import minim.controller.table.innomine.character.Soldier;
import minim.controller.table.instant.InstantChallenge;
import minim.controller.table.instant.InstantCharacter;
import minim.controller.table.instant.InstantPlot;
import minim.controller.table.instant.InstantSetting;
import minim.controller.table.instant.Thing;
import minim.controller.table.instant.Trait;
import minim.controller.table.kult.character.Advantage;
import minim.controller.table.kult.character.Conjurer;
import minim.controller.table.kult.character.Disadvantage;
import minim.controller.table.kult.character.Effect;
import minim.controller.table.kult.character.KultCharacter;
import minim.controller.table.kult.character.NightChild;
import minim.controller.table.kult.character.Profession;
import minim.controller.table.kult.character.Secret;
import minim.controller.table.kult.character.Skill;
import minim.controller.table.kult.character.madness.Madness;
import minim.controller.table.kult.character.madness.MentalChange;
import minim.controller.table.kult.character.madness.PhysicalChange;
import minim.controller.table.kult.setting.Being;
import minim.controller.table.kult.setting.City;
import minim.controller.table.kult.setting.Cult;
import minim.controller.table.kult.setting.Dream;
import minim.controller.table.kult.setting.Elysium;
import minim.controller.table.kult.setting.Inferno;
import minim.controller.table.kult.setting.KultAdventure;
import minim.controller.table.kult.setting.KultArtifact;
import minim.controller.table.kult.setting.Metropolis;
import minim.controller.table.kult.setting.Period;
import minim.controller.table.kult.setting.Portal;
import minim.controller.table.misc.OneShot;
import minim.controller.table.misc.Quantity;
import minim.controller.table.misc.RandomEncounter;
import minim.controller.table.real.Personality;
import minim.controller.table.real.WorldNpc;
import minim.controller.table.toon.BadGuy;
import minim.controller.table.toon.CartoonAdventure;
import minim.controller.table.toon.Location;
import minim.controller.table.toon.Motive;
import minim.controller.table.une.Importance;
import minim.controller.table.une.Mood;
import minim.controller.table.une.Motivation;
import minim.controller.table.une.Npc;
import minim.controller.table.une.PowerLevel;
import minim.controller.table.weather.Calendar;
import minim.controller.table.weather.Cold;
import minim.controller.table.weather.Desert;
import minim.controller.table.weather.Temperate;
import minim.controller.table.weather.TemperateSummer;
import minim.controller.table.weather.TemperateWinter;
import minim.controller.table.weather.Weather;

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

	static final Category TOON = new Category("Adventure (cartoon)", List.of(CartoonAdventure.SINGLETON,
			Location.SINGLETON, BadGuy.SINGLETON, minim.controller.table.toon.Character.SINGLETON, Motive.SINGLETON,
			minim.controller.table.toon.Object.SINGLETON, Location.ANYTOWN, Location.OUTERSPACE, Location.OUTSIDEOFTOWN,
			Location.THECITY, CartoonAdventure.BATTLE, CartoonAdventure.CHASE, CartoonAdventure.MYSTERY,
			CartoonAdventure.RESCUE, CartoonAdventure.SURVIVAL, CartoonAdventure.THEFT));
	static final Category UNE = new Category("Character (Universal NPC Emulator)",
			List.of(Importance.SINGLETON, Importance.DEMEANOR, Importance.FOCUS, Mood.FRIENDLY, Mood.HOSTILE,
					Mood.NEUTRAL, Motivation.SINGLETON, Motivation.NOUN, Motivation.VERB, new Npc(), Npc.MODIFIER,
					Npc.NOUN, PowerLevel.SINGLETON)) {
		{
			this.tables.addAll(Importance.BEARINGS.values());
		}
	};
	static final Category BOLD = new Category("Game master emulator (Stories and Deeds)",
			List.of(new ArcedWaylay(), new Connection(), Connection.ACTION, Connection.GERUND, Connection.SUBJECT,
					Waylay.SINGLETON, Waylay.EASYFOES, Waylay.EPIC, Waylay.FACTIONAL, Waylay.HARDFOES, Waylay.HAVEN,
					Waylay.KNOWLEDGE, Waylay.MODIFIER, Waylay.NATURAL, Waylay.PARTY, Waylay.PERSONAL, Waylay.PHYSICAL,
					Waylay.SOLUTION));
	static final Category CYBERPUNK2020 = new Category("Character (Cyberpunk 2020 lifepath)",
			List.of(Enemy.ACTION, Enemy.DIRECTION, Enemy.FORCES, Enemy.WHO, Enemy.WHY, new Enemy(), Family.CHILDHOOD,
					Family.NOPARENTS, Family.RANKING, Family.SINGLETON, Family.TRAGEDY, LifeEvent.BIGPROBLEMSBIGWINS,
					LifeEvent.DISASTER, LifeEvent.FRIEND, LifeEvent.FRIENDSFOES, LifeEvent.LUCKY, LifeEvent.SINGLETON,
					LifeEvent.ACTION, new Lifepath(), Lifepath.ETHNICITY, LifepathMotivation.PERSONALITY,
					LifepathMotivation.POSSESSION, LifepathMotivation.RELATIONS, LifepathMotivation.SINGLETON,
					LifepathMotivation.VALUED, LifepathMotivation.VALUES, Romance.FEELINGS, Romance.PROBLEMATIC,
					Romance.TRAGIC, new Romance(), Sibling.AGE, Sibling.FEELINGS, Sibling.GENDER, Sibling.SINGLETON,
					Style.AFFECTATION, Style.CLOTHES, Style.HAIR, Style.SINGLETON));
	static final Category FALKENSTEIN = new Category("Character (Castle Falkenstein diary questions)",
			List.of(new Diary(), Diary.ALLEGIANCES, Diary.APPEARANCE, Diary.BACKGROUND, Diary.FAMILY, Diary.PERSONALITY,
					Diary.PREFERENCES, Diary.ROMANCE, Diary.SKILLS));
	static final Category INSTANT = new Category("Game master emulator (Instant game)",
			List.of(new InstantChallenge(), InstantCharacter.FLAW, InstantCharacter.PEOPLE,
					InstantCharacter.PERSONALITY, InstantCharacter.NORMAL, InstantCharacter.WEAK,
					InstantCharacter.FLAMBOYANT, InstantPlot.ACTION, InstantPlot.OPPOSITION, InstantPlot.SINGLETON,
					InstantSetting.PLACE, InstantSetting.POPULATION, InstantSetting.SINGLETON, InstantSetting.TECH,
					InstantSetting.TONE, Thing.DESCRIPTOR, Thing.SINGLETON, Trait.OTHER, Trait.RANKS, Trait.SINGLETON,
					Trait.SKILL, Trait.ATTRIBUTE));
	static final Category WORLD = new Category("Character (realistic)",
			List.of(WorldNpc.SINGLETON, WorldNpc.RACE, WorldNpc.SEX, WorldNpc.AGE, WorldNpc.SEXUALITY,
					WorldNpc.RELIGION, WorldNpc.DISABILITY, WorldNpc.MENTALISSUE, Personality.INSTANCE, WorldNpc.HEALTH,
					WorldNpc.SIMPLE, WorldNpc.CHRONOTYPE));
	static final Category HEXCRAWL = new Category("Adventure (hexcrawl)",
			List.of(Hex.SINGLETON, Hex.NEXT, Elevation.SINGLETON, Elevation.NEXT, PointOfInterest.SINGLETON,
					PointOfInterest.TYPES, Vegetation.SINGLETON, Vegetation.NEXT, Water.SINGLETON, Water.NEXT,
					Hexcrawl.SMALL, Hexcrawl.BIG));
	static final Category COMBAT = new Category("Game master emulator (combat)",
			List.of(Action.CAREFREE, Action.CAUTIOUS, Action.CERTAIN, Action.COWERING, Action.DARING, Action.TREMBLING,
					ActionType.SINGLETON, Twist.SINGLETON, Wound.HIT, Wound.CRITICAL, Wound.DEADLY));
	static final Category ADVENTURE = new Category("Adventure (fantasy)",
			List.of(Type.SINGLETON, Motif.SINGLETON, Map.SINGLETON, Grid.SINGLETON, Dungeon.SINGLETON,
					Backstory.SINGLETON, Purpose.SINGLETON, Occupant.SINGLETON, Information.CLUE, Information.RUMOR,
					Information.RUMORCONTENT, Information.WRITING, Information.SINGLETON,
					minim.controller.table.adventure.dungeon.Location.SINGLETON,
					minim.controller.table.adventure.dungeon.Location.EXOTIC));
	static final Category WEATHER = new Category("Weather",
			List.of(Cold.SINGLETON, Desert.SINGLETON, Temperate.SINGLETON, TemperateSummer.SINGLETON,
					TemperateWinter.SINGLETON, minim.controller.table.weather.Climate.SINGLETON, Weather.SEASONS,
					Calendar.SINGLETON));
	static final Category MISC = new Category("Widget",
			List.of(new Quantity(), new RandomEncounter(), RandomEncounter.DELAY, new OneShot()));
	static final Category WODNPC = new Category("Character (World of Darkness)",
			List.of(Hunter.INSTANCE, Hunter.CREED, Hunter.MERCY, Hunter.VISION, Hunter.ZEAL, Hunter.COMPACT,
					Hunter.CONSPIRACY, Hunter.ORGANIZATION, HedgeMage.INSTANCE, HedgeMage.ORGANIZATION, Bound.INSTANCE,
					Bound.BURDEN, Bound.HAUNT, Bound.KEY));
	static final Category WODMONSTER = new Category("Character (World of Darkness, monster)",
			List.of(Monster.INSTANCE, Clan.ANARCH, Clan.CAMARILLA, Clan.INDEPENDENT, Clan.RURAL, Clan.SABBAT,
					Clan.URBAN, Generation.INSTANCE, minim.controller.table.darkness.kindred.Type.INSTANCE,
					Age.INSTANCE, Kindred.RURAL, Kindred.URBAN, minim.controller.table.darkness.mage.Faction.INSTANCE,
					Tradition.INSTANCE, Rank.TECHNOCRACY, Rank.TRADITIONS, new Chantry(), new Convention(),
					Convention.CONSTRUCT, Mage.INSTANCE, Mage.TRADITIONALIST, Mage.TECHNOCRAT, Rank.NEṔHANDI,
					Mage.NEPHANDI, new Labyrinth(), Labyrinth.FACTION, Rank.MARAUDER, Marauder.BACKRGOUND,
					Marauder.INSTANCE, Rank.ORPHAN, Mage.ORPHAN, Werewolf.AUSPICE, Tribe.FORSAKEN, Tribe.OTHER,
					Tribe.PURE, Tribe.INSTANCE, Werewolf.INSTANCE, Wraith.INSTANCE, Wraith.FACTIONS, Wraith.GUILDS,
					Wraith.HERETICS, Wraith.LEGIONS, Wraith.RENEGADES, Changeling.INSTANCE, Changeling.ADHENE,
					Changeling.COURT, Changeling.GALLAIN, Changeling.HOUSES, Changeling.HSIEN, Changeling.INANIMAE,
					Changeling.KITH, Changeling.KITHAIN, Changeling.NUNNEHI, Changeling.SEELIEHOUSES,
					Changeling.THALLAIN, Changeling.UNSEELIEHOUSES, Beast.INSTANCE, Beast.FAMILIES, Beast.HUNGER,
					Demon.INSTANCE, Demon.FACTION, Demon.HOUSE, Kuejin.INSTANCE, Kuejin.DHARMA, Kuejin.HERETICAL,
					Kuejin.ORTHODOX, Kuejin.CHI, Promethean.INSTANCE, Promethean.LINEAGE, Promethean.REFINEMENT,
					Promethean.TRANSMUTATION, Athanor.FRANKENSTEIN, Athanor.GALATEA, Athanor.OSIRIS, Athanor.TAMMUZ,
					Athanor.ULGAN, Mummy.INSTANCE, Mummy.DECREE, Mummy.GUILD));
	static final Category INNOMINE = new Category("Setting (In Nomine)",
			List.of(Discord.INSTANCE, Discord.TYPE, Song.INSTANCE, Song.TYPE, Artifact.INSTANCE, Artifact.COMPASS,
					Artifact.RELIC, Artifact.TALISMAN, Artifact.VESSEL, Artifact.LEVEL));
	static final Category INNOMINENPC = new Category("Character (In Nomine)",
			List.of(Angel.INSTANCE, Angel.CHOIR, Characters.INSTANCE,
					minim.controller.table.innomine.character.Demon.BAND,
					minim.controller.table.innomine.character.Demon.INSTANCE, new Fiends(), Reliever.INSTANCE,
					Soldier.GOD, Soldier.HELL, Role.INSTANCE, Role.FAME, Role.STATUS));
	static final Category KULTCHARACTER = new Category("Character (Kult)",
			List.of(Effect.INSTANCE, Advantage.INSTANCE, Disadvantage.INSTANCE, Profession.INSTANCE, Secret.INSTANCE,
					Skill.INSTANCE, Skill.LORES, KultCharacter.ARCHETYPE));
	static final Category KULTARCHETYPE = new Category("Character (Kult, archetype)",
			List.of(KultCharacter.AGENT, KultCharacter.ARTIST, KultCharacter.AVENGER, KultCharacter.COP,
					KultCharacter.CORPORATE, KultCharacter.DEALER, KultCharacter.FEMMEFATALE, KultCharacter.GANGMEMBER,
					KultCharacter.MUCKRAKER, KultCharacter.OUTSIDER, KultCharacter.ROCKER, KultCharacter.SAMURAI,
					KultCharacter.SCIENTIST, KultCharacter.STUDENT, KultCharacter.VETERAN, KultCharacter.PI,
					KultCharacter.ESCAPEE, KultCharacter.HACKER, KultCharacter.HOMEMAKER, KultCharacter.PRODIGY,
					KultCharacter.ACTIVIST, KultCharacter.ARISTOCRAT, KultCharacter.ATHLETE, KultCharacter.CAREGIVER,
					KultCharacter.CELEBRITY, KultCharacter.CLERGY, KultCharacter.DOCTOR, KultCharacter.FUGITIVE,
					KultCharacter.X, KultCharacter.HUSTLER, KultCharacter.MARTIAL, KultCharacter.PARAPSYCHOLOGIST,
					KultCharacter.SCHOLAR, Conjurer.OCCULTIST, Conjurer.PAGAN));
	static final Category KULTBEING = new Category("Character (Kult, being)",
			List.of(Being.INSTANCE, Being.ARCHONS, Inferno.ASTAROTH, Inferno.ANGELS, Being.DEITIES, Being.BORDERLINER,
					Being.UNDEAD, Dream.PRINCE, Dream.BEING, Inferno.BEING, Metropolis.METROPOLITAN, NightChild.GENERIC,
					NightChild.LIMITATIONS, NightChild.POWERS, NightChild.LORELEI, NightChild.NEPHILIM,
					NightChild.REVENANT, NightChild.SERAPHIM, NightChild.WOLVEN, NightChild.INSTANCE));
	static final Category KULTADVENTURE = new Category("Adventure (Kult)",
			List.of(new KultAdventure(), KultAdventure.BEGINNING, KultAdventure.CHARACTERS, KultAdventure.COMPLICATION,
					KultAdventure.EVENT, KultAdventure.MOTIVATION, KultAdventure.PLOT));
	static final Category KULTSETTING = new Category("Setting (Kult)",
			List.of(KultArtifact.INSTANCE, KultArtifact.DESTINATION, KultArtifact.LENSES, KultArtifact.PASSWORD,
					KultArtifact.PORTAL, Cult.TYPE, Cult.INSTANCE, Cult.CHARACTERISTIC, KultArtifact.CLOCKWORK,
					Period.INSTANCE, Period.ANCIENT, Period.MODERN));
	static final Category KULTLOCATION = new Category("Setting (Kult, location)",
			List.of(Metropolis.INSTANCE, Metropolis.CITADELS, Metropolis.LABYRINTH, Inferno.INSTANCE, Dream.INSTANCE,
					Elysium.INSTANCE, Portal.INSTANCE, Portal.HIGHER, Portal.LOWER, new City(), City.EXPOSED,
					City.UNDERGROUND, Dream.SPEED, Dream.TYPE, City.TRANSPORT, City.COMMUNICATION, City.INSTITUTION,
					Metropolis.LIVINGCITY, Metropolis.RUINS));
	static final Category KULTMADNESS = new Category("Setting (Kult, madness)",
			List.of(Madness.DREAM, Madness.DREAMPORTAL, Madness.DREAMSELF, Madness.TIME, Madness.HALLUCINATION,
					Madness.SPACE, Madness.POSITIVE, Madness.NEGATIVE, Madness.NEUTRAL, Madness.SHOCK,
					Madness.POSSESSION, PhysicalChange.INSTANCE, MentalChange.INSTANCE));
	static final Category WODSETTING = new Category("Setting (World of darkness)",
			List.of(WodArtifact.SINGLETON, WodArtifact.MAGE, WodArtifact.VAMPIRE, WodArtifact.WRAITH));
	static final Category JOURNEY = new Category("Adventure (Journey)",
			List.of(new Journey(), JourneyHelpers.CHARACTER, JourneyHelpers.ENEMY, JourneyHelpers.REWARD));
	static final Category CONJECTURAL = new Category("Game master emulator (Conjectural)",
			List.of(new SceneTone(), SceneTwist.SINGLETON, YesNo.SINGLETON, new YesNoAdvantage(),
					new YesNoDisadvantage(), new YesNoKnowledge(), Unexpectedly.SINGLETON, new YesNoConflict(),
					new YesNoEnding()));
	static final List<Category> CATEGORIES = new ArrayList<>(
			List.of(TOON, UNE, BOLD, CYBERPUNK2020, FALKENSTEIN, INSTANT, WORLD, HEXCRAWL, COMBAT, ADVENTURE, WEATHER,
					MISC, WODMONSTER, WODNPC, INNOMINE, INNOMINENPC, KULTCHARACTER, KULTSETTING, JOURNEY, KULTBEING,
					KULTADVENTURE, KULTMADNESS, KULTLOCATION, KULTARCHETYPE, WODSETTING, CONJECTURAL));

	static {
		CATEGORIES.sort((a, b) -> a.title.compareToIgnoreCase(b.title));
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