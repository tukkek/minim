package minim.view;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import minim.controller.StateManager;

public class Notepad{
  public static Notepad singleton;

  public Text text;
  String saved=null;

  @PostConstruct
  public void createControls(Composite parent){
    saved=(String) StateManager.load(Notepad.class);
    singleton=this;
    var layout=new Composite(parent,SWT.NONE);
    layout.setLayout(new FillLayout());
    text=new Text(layout,SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
    var f=text.getFont().getFontData();
    f[0].setHeight(13);
    text.setFont(new Font(text.getDisplay(),f));
    text.setText("Type your free-form text here :)");
    if(saved!=null) text.setText(saved);
  }

  public static void print(String text){
    singleton.text.append(text + "\n");
  }

  @PersistState
  public void stop(){
    StateManager.save(Notepad.class,text.getText());
  }
}
