package minim.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import minim.controller.action.DetermineOrder;
import minim.controller.action.attack.Attack;
import minim.model.Character;
import minim.model.Group;
import minim.view.Output;
import minim.view.UnitList;;

public class BalanceTest{
  public static final SelectionListener HANDLER=new SelectionAdapter(){
    @Override
    public void widgetSelected(SelectionEvent e){
      run();
    };
  };
  static final String REPORT="%sx%s versus %sx%s: %s%% resources spent.";
  public static final boolean ENABLED=false;

  static final List<String> STATS=List.of("physical","brawl","weapon","armor",
      "social","perception");
  static final List<String> REPORTS=new ArrayList<>();
  static final int ITERATIONS=100;
  static final List<Integer> FOES=List.of(1,5);

  static class Fight{
    List<Character> friends=new ArrayList<>(1);
    List<Character> foes=new ArrayList<>(1);

    Character add(List<Character> group,int level){
      var name=group==friends?"Friend":"Foe";
      name+=" " + (group.size()+1);
      var c=new Character(name);
      group.add(c);
      for (var stat : STATS) c.stats.put(stat,level);
      return c;
    }

    void fight() throws Cancel{
      while (!friends.isEmpty()&&!foes.isEmpty()){
        var all=Stream.of(friends,foes).flatMap(f -> f.stream()).toList();
        for (var unit : new DetermineOrder(null).determine(all)){
          if(unit.damage>=5) continue;
          var a=new Attack(STATS.get(1),unit);
          var enemies=friends.contains(unit)?foes:friends;
          a.target=enemies.get(Character.roll(enemies.size())-1);
          a.run();
          Output.singleton.clear();// avoid slow string operations
        }
        friends.removeIf(f -> f.damage>=5);
        foes.removeIf(f -> f.damage>=5);
      }
    }

    void test(int nfriends,int friendl,int nfoes,int foel) throws Cancel{
      try{
        Group.modifier=0;
        for (var i=0; i<nfriends; i++) add(friends,friendl);
        for (var i=0; i<nfoes; i++) add(foes,foel);
        fight();
      }finally{
        Group.modifier=null;
        UnitList.singleton.units.clear();
      }
    }
  }

  static void test(int nfriends,int friendl,int nfoes,int foel) throws Cancel{
    var damage=0;
    for (var i=0; i<ITERATIONS; i++){
      var f=new Fight();
      f.test(nfriends,friendl,nfoes,foel);
      var round=0;
      for (var j=0; j<nfriends; j++)
        round+=j<f.friends.size()?f.friends.get(j).damage:5;
      damage+=round;
    }
    var resources=100 * damage / (5 * nfriends * ITERATIONS);
    var r=REPORT.formatted(nfriends,friendl,nfoes,foel,resources);
    REPORTS.add(r);
    System.out.println(r);
    UnitList.singleton.update();
  }

  static void run(){
    try{
      REPORTS.clear();
      for (var nfoes : FOES) for (var friendl=5; friendl>=2; friendl--){
        for (var foel=friendl-1; foel>=2; foel--) test(1,friendl,nfoes,foel);
        REPORTS.add("");
      }
      for (var r : REPORTS) Output.print(r);
    }catch (Cancel e){
      Output.singleton.clear();
      Output.print(e.getLocalizedMessage());
    }
  }
}
