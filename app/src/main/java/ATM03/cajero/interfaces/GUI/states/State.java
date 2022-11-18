package ATM03.cajero.interfaces.GUI.states;

import javax.swing.JPanel;
import javax.swing.JTextField;

import ATM03.cajero.interfaces.GUI.GUI;

public abstract class State extends JPanel {
  public JTextField input;
  public GUI context;
  
  public State(GUI context) {
    super();
    this.context = context;
  }

  public String obtenerInput() {
    return this.input.getText();
  }

  public abstract State nextState();
}
