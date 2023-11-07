package minim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import minim.controller.BalanceTest;
import minim.controller.Cancel;
import minim.controller.action.base.Action;
import minim.view.UnitList;
import minim.view.dialog.LazyInputDialog;

public class Character implements Unit,Serializable{
  public static final Random RANDOM=new Random();
  public static final List<String> HEALTH=List.of("Unhurt","Scratched","Hurt",
      "Wounded (-1)","Injured (-2)","Dead");
  public static final List<String> QUALITY=List.of("Terrrible","Poor",
      "Mediocre","Good","Amazing");

  public class ConfirmDeathDialog extends LazyInputDialog{
    public ConfirmDeathDialog(Character c){
      super("Confirm " + c + "'s death?",false,Arrays.asList(new String[]
      {"Yes, remove from game.","No, keep alive."}));
      title="Dead";
    }

    public boolean confirm() throws Cancel{
      return getvalue()==0;
    }

    @Override
    protected boolean isselected(Object o,int i){
      return i==0;
    }
  }

  public class StatDialog extends LazyInputDialog{
    Integer previous;

    public StatDialog(String prompt,String stat,boolean multiple,
        Integer previous){
      super(prompt,multiple,QUALITY);
      this.previous=previous;
      title=name;
      numbered=true;
    }

    @Override
    public int getvalue() throws Cancel{
      return super.getvalue()+1;
    }

    @Override
    protected boolean isselected(Object s,int i){
      return previous==null?i==2:i==previous-1;
    }
  }

  public static class ModifierDialog extends LazyInputDialog{
    public ModifierDialog(String title){
      super("Select the appropriate modifier:",true,
          List.of("Very difficult (-2)","Difficult (-1)","Normal","Easy (+1)",
              "Very easy (+2)"));
      this.title=title;
      numbered=true;
    }

    @Override
    public int getvalue() throws Cancel{
      getselection();
      var bonus=0;
      for (var i=0; i<choices.size(); i++) if(result.contains(i)) bonus+=i-2;
      return bonus;
    }
  }

  public Map<String,Integer> stats=new HashMap<>();
  public List<String> state=new ArrayList<>(0);
  public int damage=0;
  public String name;

  public Character(String name){
    this.name=name;
  }

  @Override
  public String getname(){
    return name;
  }

  @Override
  public void run(Action action) throws Cancel{
    action.run(this);
  }

  public int getstat(String stat,boolean forceprompt) throws Cancel{
    var value=stats.get(stat.toLowerCase());
    if(!forceprompt&&value!=null) return value;
    final var prompt="What should be the value for " + stat + "?";
    value=new StatDialog(prompt,stat,false,value).getvalue();
    stats.put(stat,value);
    return value;
  }

  @Override
  public String toString(){
    return name;
  }

  @Override
  public void setname(String name){
    this.name=name;
  }

  int test(String statistic,int modifier) throws Cancel{
    modifier=bind(-2,modifier,+2);
    var t=bind(1,getstat(statistic)+modifier,6);
    var r=roll();
    if(r==1||r<t) return +1;
    if(r==t) return 0;
    return -1;
  }

  public int roll(String attribute,String skill,Action a) throws Cancel{
    var modifier=0;
    if(damage==3) modifier-=1;
    else if(damage==4) modifier-=2;
    if(a.applymodifier){
      var g=Group.modifier;
      modifier+=g!=null?g:new ModifierDialog(name).getvalue();
    }
    return test(attribute,modifier)+test(skill,modifier);
  }

  public int getstat(String name) throws Cancel{
    return getstat(name,false);
  }

  public static int roll(){
    return roll(6);
  }

  public static int roll(int sides){
    return RANDOM.nextInt(sides)+1;
  }

  private int bind(int min,int value,int max){
    if(value<min) return min;
    if(value>max) return max;
    return value;
  }

  String printroll(minim.model.Character c,String name,int value,int roll){
    return ">" + c + " rolls " + name + " (" + value + "). " + roll + "\n";
  }

  @Override
  public void remove(ArrayList<Unit> units){
    units.remove(this);
    for (Unit u : new ArrayList<>(units)) if(u instanceof Group){
      var g=(Group) u;
      g.remove(this);
      if(g.group.isEmpty()) g.remove(units);
    }
    UnitList.singleton.update();
  }

  public void damage(int d) throws Cancel{
    damage+=d;
    if(damage<=4) return;
    if(!BalanceTest.ENABLED&&!new ConfirmDeathDialog(this).confirm()){
      damage=4;
      return;
    }
    damage=5;
    remove(UnitList.singleton.units);
  }

  public String describehealth(){
    return this + ": " + HEALTH.get(damage).toLowerCase();
  }

  public static String roll(List<String> choices){
    return choices.get(roll(choices.size()-1));
  }
}
