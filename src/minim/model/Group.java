package minim.model;

import java.io.Serializable;
import java.util.ArrayList;

import minim.controller.Cancel;
import minim.controller.action.base.Action;
import minim.model.Character.ModifierDialog;
import minim.view.UnitList;
import minim.view.dialog.LazyInputDialog;

public class Group implements Unit,Serializable{
  public static Integer modifier=null;

  public class GroupSelectionDialog extends LazyInputDialog{
    public GroupSelectionDialog(ArrayList<Character> characters){
      super("Which characters should be part of this group?",true,characters);
      numbered=true;
    }

    @Override
    protected boolean isselected(Object o,int i){
      return group.contains(o);
    }
  }

  public ArrayList<Character> group=new ArrayList<>();
  public String name;

  public Group(String name){
    this.name=name;
  }

  @Override
  public String getname(){
    return name;
  }

  @Override
  public void run(Action a) throws Cancel{
    try{
      if(a.applymodifier) Group.modifier=new ModifierDialog(name).getvalue();
      for (var c : group) a.run(c);
    }finally{
      Group.modifier=null;
    }
  }

  public void selectgroup(ArrayList<Character> characters){
    try{
      var selection=new GroupSelectionDialog(characters)
          .getselection();
      group.clear();
      for (int i : selection) group.add(characters.get(i));
    }catch (Cancel c){
      return;
    }
  }

  @Override
  public void setname(String name){
    this.name=name;
  }

  public void remove(Character c){
    group.remove(c);
  }

  @Override
  public void remove(ArrayList<Unit> units){
    units.remove(this);
    UnitList.singleton.update();
  }
}
