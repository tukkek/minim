package minim.controller.table.darkness;

import minim.controller.table.MetaTable;
import minim.controller.table.Mummy;
import minim.controller.table.Table;
import minim.controller.table.darkness.kindred.Kindred;
import minim.controller.table.darkness.mage.npc.HedgeMage;
import minim.controller.table.darkness.mage.npc.Mage;
import minim.controller.table.darkness.werewolf.Werewolf;

public class Monster extends MetaTable {
	public static final Table INSTANCE = new Monster();

	Monster() {
		super("Monster");
	}

	@Override
	public void build() {
		add(500, Wraith.INSTANCE);
		add(500, Hunter.INSTANCE);
		add(300, Werewolf.INSTANCE);
		add(300, Changeling.INSTANCE);
		add(200, Beast.INSTANCE);
		add(200, Demon.INSTANCE);
		add(100, Kindred.URBAN);
		add(50, HedgeMage.INSTANCE);
		add(30, Mage.INSTANCE);
		add(30, Kuejin.INSTANCE);
		add(10, Bound.INSTANCE);
		add(5, Promethean.INSTANCE);
		add(1, Mummy.INSTANCE);
	}

	@Override
	protected String onroll(Table t, String result) {
		return t.title + ":\n" + result;
	}
}
