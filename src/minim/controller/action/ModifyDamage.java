package minim.controller.action;

import minim.controller.Cancel;
import minim.controller.action.base.Action;
import minim.model.Character;
import minim.model.Unit;
import minim.view.Output;
import minim.view.dialog.LazyInputDialog;

public class ModifyDamage extends Action{
	class DamageDialog extends LazyInputDialog{
		Character c;

		public DamageDialog(Character c){
			super("Change damage level to:",false,
					Character.HEALTH.subList(0,5));
			this.c=c;
			title=c.name;
			numbered=true;
		}

		@Override
		protected boolean isselected(Object o,int i){
			return i==c.damage;
		}
	}

	public ModifyDamage(Unit u){
		super(u);
	}

	@Override
	public int run(Character c) throws Cancel{
		c.damage=new DamageDialog(c).getvalue();
		Output.print(c.describehealth());
		return 0;
	}
}
