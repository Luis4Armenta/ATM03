package ATM03.cajero.interfaces.GUI.states;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ATM03.cajero.interfaces.GUI.GUI;


public abstract class ActionListenerWithContext implements ActionListener{
  public GUI context;
  
  public ActionListenerWithContext(GUI context) {
    this.context = context;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    this.action();
  }
  
  public abstract void action();
}
