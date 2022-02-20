
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
import minim.controller.table.bold.ArcedWaylay;
import minim.controller.table.bold.Connection;
import minim.controller.table.bold.Waylay;
import minim.controller.table.combat.Action;
import minim.controller.table.combat.ActionType;
import minim.controller.table.combat.Twist;
import minim.controller.table.combat.Wound;
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
import minim.controller.table.kult.character.Disadvantage;
import minim.controller.table.kult.character.Effect;
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
import minim.controller.table.kult.setting.Metropolis;
import minim.controller.table.kult.setting.Period;
import minim.controller.table.kult.setting.Portal;
import minim.controller.table.misc.OneShot;
import minim.controller.table.misc.Quantity;
import minim.controller.table.misc.RandomEncounter;
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

	static final Category TOON = new Category("Adventure (cartoon)", List.of(CartoonAdventure.SINGLETON,
			Location.SINGLETON, BadGuy.SINGLETON, minim.controller.table.toon.Character.SINGLETON, Motive.SINGLETON,
			minim.controller.table.toon.Object.SINGLETON, Location.ANYTOWN, Location.OUTERSPACE, Location.OUTSIDEOFTOWN,
			Location.THECITY, CartoonAdventure.BATTLE, CartoonAdventure.CHASE, CartoonAdventure.MYSTERY,
			CartoonAdventure.RESCUE, CartoonAdventure.SURVIVAL, CartoonAdventure.THEFT));
	static final Category UNE = new Category("NPC (Universal NPC Emulator)",
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
	static final Category CYBERPUNK2020 = new Category("NPC (Cyberpunk 2020 lifepath)",
			List.of(Enemy.ACTION, Enemy.DIRECTION, Enemy.FORCES, Enemy.WHO, Enemy.WHY, new Enemy(), Family.CHILDHOOD,
					Family.NOPARENTS, Family.RANKING, Family.SINGLETON, Family.TRAGEDY, LifeEvent.BIGPROBLEMSBIGWINS,
					LifeEvent.DISASTER, LifeEvent.FRIEND, LifeEvent.FRIENDSFOES, LifeEvent.LUCKY, LifeEvent.SINGLETON,
					LifeEvent.ACTION, new Lifepath(), Lifepath.ETHNICITY, LifepathMotivation.PERSONALITY,
					LifepathMotivation.POSSESSION, LifepathMotivation.RELATIONS, LifepathMotivation.SINGLETON,
					LifepathMotivation.VALUED, LifepathMotivation.VALUES, Romance.FEELINGS, Romance.PROBLEMATIC,
					Romance.TRAGIC, new Romance(), Sibling.AGE, Sibling.FEELINGS, Sibling.GENDER, Sibling.SINGLETON,
					Style.AFFECTATION, Style.CLOTHES, Style.HAIR, Style.SINGLETON));
	static final Category FALKENSTEIN = new Category("NPC (Castle Falkenstein diary questions)",
			List.of(new Diary(), Diary.ALLEGIANCES, Diary.APPEARANCE, Diary.BACKGROUND, Diary.FAMILY, Diary.PERSONALITY,
					Diary.PREFERENCES, Diary.ROMANCE, Diary.SKILLS));
	static final Category INSTANT = new Category("Game master emulator (Instant game)",
			List.of(new InstantChallenge(), InstantCharacter.FLAW, InstantCharacter.PEOPLE,
					InstantCharacter.PERSONALITY, InstantCharacter.NORMAL, InstantCharacter.WEAK,
					InstantCharacter.FLAMBOYANT, InstantPlot.ACTION, InstantPlot.OPPOSITION, InstantPlot.SINGLETON,
					InstantSetting.PLACE, InstantSetting.POPULATION, InstantSetting.SINGLETON, InstantSetting.TECH,
					InstantSetting.TONE, Thing.DESCRIPTOR, Thing.SINGLETON, Trait.OTHER, Trait.RANKS, Trait.SINGLETON,
					Trait.SKILL, Trait.ATTRIBUTE));
	static final Category WORLD = new Category("NPC (realistic)",
			List.of(new WorldNpc(), WorldNpc.RACE, WorldNpc.SEX, WorldNpc.AGE, WorldNpc.SEXUALITY, WorldNpc.RELIGION,
					WorldNpc.DISABILITY, WorldNpc.MENTALISSUE, Personality.INSTANCE, WorldNpc.HEALTH, WorldNpc.SIMPLE));
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
	static final Category MONSTER = new Category("NPC (World of Darkness)",
			List.of(Wraith.INSTANCE, Hunter.INSTANCE, Werewolf.INSTANCE, Changeling.INSTANCE, Beast.INSTANCE,
					Demon.INSTANCE, Kindred.URBAN, Kindred.RURAL, HedgeMage.INSTANCE, Mage.INSTANCE, Kuejin.INSTANCE,
					Bound.INSTANCE, Promethean.INSTANCE, Mummy.INSTANCE, Monster.INSTANCE));
	static final Category DARKNESS = new Category("Setting (World of Darkness)", List.of(Monster.INSTANCE, Clan.ANARCH,
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
	static final Category INNOMINE = new Category("Setting (In Nomine)",
			List.of(Discord.INSTANCE, Discord.TYPE, Song.INSTANCE, Song.TYPE, new Artifact(), Artifact.COMPASS,
					Artifact.RELIC, Artifact.TALISMAN, Artifact.VESSEL, Artifact.LEVEL));
	static final Category INNOMINENPC = new Category("NPC (In Nomine)",
			List.of(Angel.INSTANCE, Angel.CHOIR, new Characters(), minim.controller.table.innomine.character.Demon.BAND,
					minim.controller.table.innomine.character.Demon.INSTANCE, new Fiends(), Reliever.INSTANCE,
					Soldier.GOD, Soldier.HELL, Role.INSTANCE, Role.FAME, Role.STATUS));
	static final Category KULTCHARACTER = new Category("NPC (Kult)", List.of(Effect.INSTANCE, Advantage.INSTANCE,
			Disadvantage.INSTANCE, Profession.INSTANCE, Secret.INSTANCE, Skill.INSTANCE,
			minim.controller.table.kult.character.Character.ARCHETYPE,
			minim.controller.table.kult.character.Character.AGENT,
			minim.controller.table.kult.character.Character.ARTIST,
			minim.controller.table.kult.character.Character.AVENGER,
			minim.controller.table.kult.character.Character.COP,
			minim.controller.table.kult.character.Character.CORPORATE,
			minim.controller.table.kult.character.Character.DEALER,
			minim.controller.table.kult.character.Character.FEMMEFATALE,
			minim.controller.table.kult.character.Character.GANGMEMBER,
			minim.controller.table.kult.character.Character.MUCKRAKER,
			minim.controller.table.kult.character.Character.OUTSIDER,
			minim.controller.table.kult.character.Character.ROCKER,
			minim.controller.table.kult.character.Character.SAMURAI,
			minim.controller.table.kult.character.Character.SCIENTIST,
			minim.controller.table.kult.character.Character.STUDENT,
			minim.controller.table.kult.character.Character.VETERAN, minim.controller.table.kult.character.Character.PI,
			minim.controller.table.kult.character.Character.ESCAPEE,
			minim.controller.table.kult.character.Character.HACKER,
			minim.controller.table.kult.character.Character.HOMEMAKER,
			minim.controller.table.kult.character.Character.PRODIGY,
			minim.controller.table.kult.character.Character.ACTIVIST,
			minim.controller.table.kult.character.Character.ARISTOCRAT,
			minim.controller.table.kult.character.Character.ATHLETE,
			minim.controller.table.kult.character.Character.CAREGIVER,
			minim.controller.table.kult.character.Character.CELEBRITY,
			minim.controller.table.kult.character.Character.CLERGY,
			minim.controller.table.kult.character.Character.DOCTOR,
			minim.controller.table.kult.character.Character.FUGITIVE, minim.controller.table.kult.character.Character.X,
			minim.controller.table.kult.character.Character.HUSTLER,
			minim.controller.table.kult.character.Character.MARTIAL,
			minim.controller.table.kult.character.Character.PARAPSYCHOLOGIST,
			minim.controller.table.kult.character.Character.SCHOLAR,
			minim.controller.table.kult.character.Conjurer.OCCULTIST,
			minim.controller.table.kult.character.Conjurer.PAGAN, NightChild.GENERIC, NightChild.LIMITATIONS,
			NightChild.POWERS, NightChild.LORELEI, NightChild.NEPHILIM, NightChild.REVENANT, NightChild.SERAPHIM,
			NightChild.WOLVEN, NightChild.INSTANCE, PhysicalChange.INSTANCE, MentalChange.INSTANCE, Madness.POSITIVE,
			Madness.NEGATIVE, Madness.NEUTRAL, Madness.SHOCK, Madness.POSSESSION, Skill.LORES));
	static final Category KULTSETTING = new Category("Setting (Kult)",
			List.of(Metropolis.INSTANCE, Being.INSTANCE, Being.ARCHONS, Inferno.ASTAROTH, Inferno.ANGELS,
					Metropolis.CITADELS, Metropolis.LABYRINTH, Inferno.INSTANCE, Dream.INSTANCE, Elysium.INSTANCE,
					Portal.INSTANCE, Portal.HIGHER, Portal.LOWER, new minim.controller.table.kult.setting.Artifact(),
					minim.controller.table.kult.setting.Artifact.DESTINATION,
					minim.controller.table.kult.setting.Artifact.LENSES,
					minim.controller.table.kult.setting.Artifact.PASSWORD,
					minim.controller.table.kult.setting.Artifact.PORTAL, Being.DEITIES, new City(), City.EXPOSED,
					Being.BORDERLINER, City.UNDERGROUND, Metropolis.METROPOLITAN, Being.UNDEAD, Inferno.BEINGS,
					Dream.BEING, Dream.SPEED, Dream.TYPE, Dream.PRINCE, Madness.DREAM, Madness.DREAMPORTAL,
					Madness.DREAMSELF, Madness.TIME, Madness.HALLUCINATION, Madness.SPACE, Cult.TYPE, new Cult(),
					Cult.CHARACTERISTIC, new minim.controller.table.kult.setting.Adventure(),
					minim.controller.table.kult.setting.Adventure.BEGINNING,
					minim.controller.table.kult.setting.Adventure.CHARACTERS,
					minim.controller.table.kult.setting.Adventure.COMPLICATION,
					minim.controller.table.kult.setting.Adventure.EVENT,
					minim.controller.table.kult.setting.Adventure.MOTIVATION,
					minim.controller.table.kult.setting.Adventure.PLOT, City.TRANSPORT, City.COMMUNICATION,
					City.INSTITUTION, minim.controller.table.kult.setting.Artifact.CLOCKWORK, Metropolis.LIVINGCITY,
					Metropolis.RUINS, Period.INSTANCE, Period.ANCIENT, Period.MODERN));
	static final List<Category> CATEGORIES = new ArrayList<>(
			List.of(TOON, UNE, BOLD, CYBERPUNK2020, FALKENSTEIN, INSTANT, WORLD, HEXCRAWL, COMBAT, ADVENTURE, WEATHER,
					MISC, DARKNESS, MONSTER, INNOMINE, INNOMINENPC, KULTCHARACTER, KULTSETTING));

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