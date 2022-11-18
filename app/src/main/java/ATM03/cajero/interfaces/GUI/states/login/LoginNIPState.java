package ATM03.cajero.interfaces.GUI.states.login;

import javax.swing.JLabel;

import ATM03.cajero.interfaces.GUI.GUI;
import ATM03.cajero.interfaces.GUI.states.State;

public class LoginNIPState extends State {
  private JLabel Bienvenida;
  private JLabel indicacion;

  public LoginNIPState(GUI context) {
    super(context);
    
    setSize(500, 400);

    initComponents();
  }

  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    Bienvenida = new javax.swing.JLabel();
    this.input = new javax.swing.JTextField();
    indicacion = new javax.swing.JLabel();

    setLayout(new java.awt.GridBagLayout());

    Bienvenida.setText("Bienvenido");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
    add(Bienvenida, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.ipadx = 60;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
    add(input, gridBagConstraints);

    indicacion.setText("Digita tu NIP:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
    gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 5);
    add(indicacion, gridBagConstraints);
  }

  @Override
  public State nextState() {
    // TODO Auto-generated method stub
    return null;
  }

  
}
