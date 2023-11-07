package minim.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import minim.Minim;
import minim.controller.BalanceTest;
import minim.controller.Cancel;
import minim.controller.StateManager;
import minim.controller.action.ChangeName;
import minim.controller.action.DetermineOrder;
import minim.controller.action.ModifyDamage;
import minim.controller.action.ModifyGroup;
import minim.controller.action.RemoveUnit;
import minim.controller.action.attack.Attack;
import minim.controller.action.base.Action;
import minim.controller.action.base.RolledAction;
import minim.controller.action.base.SimpleAction;
import minim.model.Character;
import minim.model.Group;
import minim.model.Unit;

public class UnitList{
  public class Show extends SimpleAction{

    public Show(Unit u){
      super(u);
      // TODO Auto-generated constructor stub
    }

    @Override
    public void run() throws Cancel{
      var g=(Group) unit;
      var hidden=g.group.stream().filter(unit -> !units.contains(unit))
          .toList();
      units.addAll(hidden);
      update();
    }
  }

  public class Hide extends SimpleAction{
    public Hide(Unit u){
      super(u);
    }

    @Override
    public void run() throws Cancel{
      var g=(Group) unit;
      units.removeAll(g.group);
      update();
    }
  }

  public class Move extends SimpleAction{
    int delta;

    public Move(Unit u,int d){
      super(u);
      delta=d;
    }

    @Override
    public void run() throws Cancel{
      var i=units.indexOf(unit);
      var to=delta==+1?i+2:i-1;
      if(!(0<=to&&to<=units.size())) return;
      units.add(to,unit);
      if(delta==-1) i+=1;
      units.remove(i);
      update();
    }
  }

  public class AddCharacter extends SelectionAdapter{
    @Override
    public void widgetSelected(SelectionEvent e){
      var name=UnitList.getname("What is the new character's name?","");
      if(name!=null&&!name.isEmpty()) units.add(new Character(name));
      update();
    }
  }

  public class AddGroup extends SelectionAdapter{
    @Override
    public void widgetSelected(SelectionEvent e){
      var characters=getcharacters();
      if(characters.size()<2) return;
      var name=getname("What is the new group's name?","");
      if(name!=null&&!name.isEmpty()){
        var g=new Group(name);
        units.add(g);
        g.selectgroup(characters);
        update();
      }
    }
  }

  public class DetermineAll extends SelectionAdapter{
    @Override
    public void widgetSelected(SelectionEvent e){
      try{
        var all=new HashMap<Unit,Character>(units.size());
        for (var u : units){
          var g=u instanceof Group?(Group) u:null;
          if(g!=null&&g.group.size()==0) continue;
          all.put(u,g==null?(Character) u:g.group.get(0));
        }
        if(all.isEmpty()) return;
        var characters=new DetermineOrder(null)
            .determine(new ArrayList<Character>(all.values()));
        var units=new ArrayList<Unit>(all.keySet());
        units.sort(Comparator.comparing(u -> characters.indexOf(all.get(u))));
        UnitList.this.units.removeAll(units);
        UnitList.this.units.addAll(units);
        update();
      }catch (Cancel e1){
        return;
      }
    }
  }

  class ShowMenu extends SelectionAdapter{
    private final Menu menu;
    private Button b;

    ShowMenu(Menu menu,Button b){
      this.menu=menu;
      this.b=b;
    }

    @Override
    public void widgetSelected(SelectionEvent e){
      var bounds=b.getBounds();
      var point=b.getParent().toDisplay(bounds.x+bounds.width,bounds.y);
      menu.setLocation(point);
      menu.setVisible(true);
    }
  }

  static final List<String> ACCELERATORS=List.of("1","2","3","4","5","6","7",
      "8","9");

  public static UnitList singleton;

  public ArrayList<Unit> units=new ArrayList<>();
  Composite unitsarea;
  Composite layout;

  @SuppressWarnings("unused")
  @PostConstruct
  public void createControls(Composite parent){
    var saved=(ArrayList<Unit>) StateManager.load(UnitList.class);
    if(saved!=null) units=(ArrayList<Unit>) StateManager.load(UnitList.class);
    singleton=this;
    Minim.shell=parent.getShell();
    layout=new Composite(parent,SWT.NONE);
    layout.setLayout(new RowLayout(SWT.VERTICAL));
    var add=new Composite(layout,SWT.NONE);
    add.setLayout(new FillLayout(SWT.HORIZONTAL));
    if(!BalanceTest.ENABLED){
      addbutton(add,"Add &character",new AddCharacter());
      addbutton(add,"Add &group",new AddGroup());
      addbutton(add,"&Determine order",new DetermineAll());
    }else addbutton(add,"Test balance",BalanceTest.HANDLER);
    new Label(layout,SWT.NONE);
    unitsarea=new Composite(layout,SWT.NONE);
    unitsarea.setLayout(new FillLayout(SWT.VERTICAL));
    update();
  }

  void addbutton(Composite add,String string,SelectionListener l){
    var b=new Button(add,SWT.NONE);
    b.setText(string);
    b.addSelectionListener(l);
  }

  public void update(){
    if(BalanceTest.ENABLED) return;
    var s=unitsarea.getShell();
    for (var w : unitsarea.getChildren()) w.dispose();
    for (var i=0; i<units.size(); i++){
      var u=units.get(i);
      var b=new Button(unitsarea,SWT.NONE);
      var label=u.getname();
      if(i<ACCELERATORS.size()) label="&" + ACCELERATORS.get(i) + " " + label;
      b.setText(label);
      var icon=u instanceof Character?"krusader.png":"kuser.png";
      b.setImage(getImage("icons" + File.separator + icon));
      var m=addmenu(b,u);
      b.addSelectionListener(new ShowMenu(m,b));
    }
    /* Shouldn't have to do this manually but it bugs otherwise. */
    layout.layout();
    unitsarea.layout();
  }

  Image getImage(String path){
    var bundle=Platform.getBundle(Minim.PLUGINID);
    var url=FileLocator.find(bundle,new Path(path),null);
    var imageDesc=ImageDescriptor.createFromURL(url);
    return imageDesc.createImage();
  }

  Menu addmenu(Button b,Unit u){
    final var menu=new Menu(b);
    b.setMenu(menu);
    if(u instanceof Group){
      final var group=addsubmenu(menu,"&Group");
      var g=(Group) u;
      addmenuitem("Determine &order",b,group,new DetermineOrder(g));
      addmenuitem("Modify &group",b,group,new ModifyGroup(this,g));
      addmenuitem("Hide members",b,group,new Hide(g));
      addmenuitem("Show members",b,group,new Show(g));
    }
    final var attack=addsubmenu(menu,"&Attack");
    for (String s : Attack.ATTACKS) addmenuitem(s,b,attack,new Attack(s,u));
    final var physical=addsubmenu(menu,"&Physical");
    for (String s : RolledAction.PHYSICAL)
      addmenuitem(s,b,physical,new RolledAction("physical",s,u));
    final var social=addsubmenu(menu,"&Social");
    for (String s : RolledAction.SOCIAL)
      addmenuitem(s,b,social,new RolledAction("social",s,u));
    final var mental=addsubmenu(menu,"&Mental");
    for (String s : RolledAction.MENTAL)
      addmenuitem(s,b,mental,new RolledAction("mental",s,u));
    addmenuitem("Modify &wounds",b,menu,new ModifyDamage(u));
    addmenuitem("Move &up",b,menu,new Move(u,-1));
    addmenuitem("Move &down",b,menu,new Move(u,+1));
    addmenuitem("Re&name",b,menu,new ChangeName(this,u));
    addmenuitem("&Remove",b,menu,new RemoveUnit(this,u));
    return menu;
  }

  Menu addsubmenu(final Menu menu,String label){
    final var submenushell=new MenuItem(menu,SWT.CASCADE);
    submenushell.setText(label);
    final var submenu=new Menu(menu);
    submenushell.setMenu(submenu);
    return submenu;
  }

  void addmenuitem(String label,Button b,Menu menu,Action a){
    var i=new MenuItem(menu,SWT.NONE);
    i.setText(label);
    i.addSelectionListener(a);
  }

  @Focus
  public void onFocus(){

  }

  public ArrayList<Character> getcharacters(){
    var characters=new ArrayList<Character>();
    for (Unit u : units)
      if(u instanceof Character) characters.add((Character) u);
    return characters;
  }

  public static String getname(String message,String previous){
    var d=new InputDialog(Display.getCurrent().getActiveShell(),message,message,
        previous,null);
    d.setBlockOnOpen(true);
    d.open();
    return d.getReturnCode()==Window.OK?d.getValue():null;
  }

  @PersistState
  public void stop(){
    StateManager.save(UnitList.class,units);
  }

  public List<Character> getall(){
    var targets=new HashSet<Character>();
    for (var u : UnitList.singleton.units)
      if(u instanceof Group g) targets.addAll(g.group);
      else targets.add((Character) u);
    var sorted=new ArrayList<>(targets);
    sorted.sort(Comparator.comparing(s -> s.toString()));
    return sorted;
  }
}
