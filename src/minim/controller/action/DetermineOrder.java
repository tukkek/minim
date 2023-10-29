package minim.controller.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import minim.Minim;
import minim.controller.Cancel;
import minim.controller.action.base.SimpleAction;
import minim.model.Character;
import minim.model.Group;
import minim.view.Output;
import minim.view.UnitList;

public class DetermineOrder extends SimpleAction{
  Group g;

  public DetermineOrder(Group g){
    super(g);
    this.g=g;
  }

  @Override
  public void run() throws Cancel{
    determine(g.group);
  }

  public List<Character> determine(List<Character> group) throws Cancel{
    var initiatives=new HashMap<Object,Integer>();
    var perceptions=new HashMap<Object,Integer>();
    for (Character c : group){
      initiatives.put(c,c.roll("social","perception",this));
      perceptions.put(c,c.getstat("perception"));
    }
    group=new ArrayList<>(group);
    Collections.shuffle(group);
    group.sort((a,b) -> {
      var delta=initiatives.get(b)-initiatives.get(a);
      if(delta!=0) return delta;
      return perceptions.get(a)-perceptions.get(b);
    });
    var result="Initiative order:\n";
    var u=UnitList.singleton;
    u.units.removeAll(group);
    u.units.addAll(0,group);
    u.update();
    for (Character c : group){
      var roll=Minim.DEBUG?" (" + initiatives.get(c) + ")":"";
      result+="  " + c + roll + "\n";
    }
    Output.print(result);
    return group;
  }
}
