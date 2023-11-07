package minim.controller.action.attack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.Cancel;
import minim.controller.action.base.RolledAction;
import minim.model.Character;
import minim.model.Unit;
import minim.view.Output;
import minim.view.UnitList;
import minim.view.dialog.LazyInputDialog;

public class Attack extends RolledAction{
  public static final List<String> ATTACKS=List.of("&brawl","&shooting");

  static final Map<String,String> FUMBLES=new HashMap<String,String>();

  static{
    FUMBLES.put("begins grappling","grappling");
    FUMBLES.put("is disarmed","disarmed");
    FUMBLES.put("is stunned","stunned");
    FUMBLES.put("is shaken","shaken");
    FUMBLES.put("falls","fallen");
    FUMBLES.put("is disabled","disabled"); // only "minor" actions next round
    FUMBLES.put("is pinned","pinned"); // cannot move
    FUMBLES.put("interacts with ally (or enemy)",null);
    FUMBLES.put("interacts with environment",null);
    FUMBLES.put("moves back",null);
  }

  public class TargetDialog extends LazyInputDialog{
    List<Character> targets;
    Character attacker;

    public TargetDialog(Character attacker,List<Character> targets){
      super("Choose the target of this attack:",false,targets);
      this.attacker=attacker;
      this.targets=targets;
      title=attacker + "'s " + skill;
      numbered=true;
    }

    @Override
    public List<Integer> getselection() throws Cancel{
      var selection=super.getselection();
      if(selection.isEmpty()) throw new Cancel();
      return selection;
    }

    public Character gettarget() throws Cancel{
      return targets.get(getvalue());
    }

    @Override
    protected boolean isselected(Object o,int i){
      return o==lasttarget&&o!=attacker;
    }
  }

  class ApplyDamageDialog extends LazyInputDialog{
    public ApplyDamageDialog(String skill){
      super("Should this attack deal damage?",false,Arrays.asList(new String[]
      {"Apply damage","Ignore damage"}));
    }

    boolean applydamage() throws Cancel{
      return getvalue()==0;
    }

    @Override
    protected boolean isselected(Object o,int i){
      return i==0;
    }
  }

  public Character target;

  Character lasttarget;

  public Attack(String skill,Unit u){
    super("physical",skill,u);
  }

  @Override
  public int run(Character c) throws Cancel{
    var result=super.run(c);
    if(result==-2){
      fumble(c,c);
      return -2;
    }
    if(result==-1) return -1;
    if(result==0){
      fumble(c,null);
      return 0;
    }
    target=gettarget(c);
    var weapon=c.getstat("weapon",false);
    var armor=target.getstat("armor",false);
    var damage=result+weapon-armor;
    if(damage<1) damage=1;
    target.damage(damage);
    Output.print(target.describehealth().toLowerCase());
    return result;
  }

  void fumble(Character attacker,Character target) throws Cancel{
    var f=Character.roll(new ArrayList<>(FUMBLES.keySet()));
    var effect=FUMBLES.get(f);
    if(effect!=null){
      if(target==null) target=gettarget(attacker);
      target.state.add(effect);
      UnitList.singleton.update();
    }
    Output.print("%s %s.".formatted(target==null?"target":target,f));
  }

  Character gettarget(Character attacker) throws Cancel{
    if(target!=null) return target;
    var all=UnitList.singleton.getall();
    lasttarget=new TargetDialog(attacker,all).gettarget();
    return lasttarget;
  }
}
