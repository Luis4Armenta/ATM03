package ATM03.cajero.interfaces.GUI.states.retiro;

import java.util.TimerTask;

import ATM03.cajero.interfaces.GUI.GUI;

public abstract class Contador extends TimerTask {
  GUI context;
  
  public Contador(GUI context) {
    this.context = context;
  }
}
