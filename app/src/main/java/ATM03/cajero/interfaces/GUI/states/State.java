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

    this.limpiarActionListeners();
  }

  public String obtenerInput() {
    return this.input.getText();
  }

  public void colocarInput(String text) {
    this.input.setText(text);
  }

  public void limpiarInput() {
    this.input.setText("");
  }

  private void limpiarActionListeners() {
    if(this.context.opcion1Btn.getActionListeners().length > 0) {
      this.context.opcion1Btn.removeActionListener(this.context.opcion1Btn.getActionListeners()[0]);
    }
    if(this.context.opcion2Btn.getActionListeners().length > 0) {
      this.context.opcion2Btn.removeActionListener(this.context.opcion2Btn.getActionListeners()[0]);
    }
    if(this.context.opcion3Btn.getActionListeners().length > 0) {
      this.context.opcion3Btn.removeActionListener(this.context.opcion3Btn.getActionListeners()[0]);
    }
    if(this.context.opcion4Btn.getActionListeners().length > 0) {
      this.context.opcion4Btn.removeActionListener(this.context.opcion4Btn.getActionListeners()[0]);
    }
    if(this.context.opcion5Btn.getActionListeners().length > 0) {
      this.context.opcion5Btn.removeActionListener(this.context.opcion5Btn.getActionListeners()[0]);
    }
    if(this.context.opcion6Btn.getActionListeners().length > 0) {
      this.context.opcion6Btn.removeActionListener(this.context.opcion6Btn.getActionListeners()[0]);
    }
  }

  public abstract State nextState();
  public abstract boolean continuar();
  public abstract void cancelar();
}
