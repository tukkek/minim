package minim.controller.table.adventure.journey;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.Table;
import minim.controller.table.darkness.Bound;
import minim.controller.table.darkness.Hunter;
import minim.controller.table.darkness.Monster;
import minim.controller.table.darkness.WodArtifact;
import minim.controller.table.darkness.mage.npc.HedgeMage;
import minim.controller.table.innomine.Artifact;
import minim.controller.table.innomine.character.Characters;
import minim.controller.table.innomine.character.Soldier;
import minim.controller.table.kult.character.KultCharacter;
import minim.controller.table.kult.character.NightChild;
import minim.controller.table.kult.setting.Being;
import minim.controller.table.kult.setting.Cult;
import minim.controller.table.kult.setting.KultArtifact;
import minim.controller.table.real.WorldNpc;
import minim.model.Character;

public class JourneyHelpers {
	public static final Table CHARACTER = new SimpleMetaTable("Character (trinity)",
			List.of(new SimpleMetaTable("Character (In Nomine)", List.of(Soldier.GOD, Soldier.HELL)),
					KultCharacter.ARCHETYPE, new SimpleMetaTable("Character (World of Darkness)",
							List.of(Bound.INSTANCE, HedgeMage.INSTANCE, Hunter.INSTANCE)))) {
		public String roll() {
			return WorldNpc.SINGLETON.roll() + "\n\n" + super.roll();
		};
	};
	public static final Table ENEMY = new SimpleMetaTable("Enemy (trinity)",
			List.of(Characters.INSTANCE,
					new SimpleMetaTable("Enemy (Kult)", List.of(Being.INSTANCE, Cult.INSTANCE, NightChild.INSTANCE)),
					Monster.INSTANCE));
	public static final Table REWARD = new SimpleMetaTable("Reward (trinity)",
			List.of(Artifact.INSTANCE, KultArtifact.INSTANCE, WodArtifact.SINGLETON)) {
		public String roll() {
			// TODO since all tables are named the same, they become one entry in TableMap
			var n = Character.roll(3);
			if (n == 1)
				return Artifact.INSTANCE.roll();
			if (n == 2)
				return KultArtifact.INSTANCE.roll();
			return WodArtifact.SINGLETON.roll();

		};
	};

	JourneyHelpers() {
		// private
	}
}
