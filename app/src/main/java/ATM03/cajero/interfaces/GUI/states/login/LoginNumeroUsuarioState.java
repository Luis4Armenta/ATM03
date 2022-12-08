package ATM03.cajero.interfaces.GUI.states.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ATM03.cajero.interfaces.GUI.GUI;
import ATM03.cajero.interfaces.GUI.states.ActionListenerWithContext;
import ATM03.cajero.interfaces.GUI.states.State;

public class LoginNumeroUsuarioState extends State {
  private JLabel Bienvenida;
  private JLabel indicacion;

  public LoginNumeroUsuarioState(GUI context) {
    super(context);

    setSize(500, 400);

    initComponents();
    this.colocarComportamiento();
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

    indicacion.setText("Digita tu numero de cuenta");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
    gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 5);
    add(indicacion, gridBagConstraints);

    this.context.opcion1Btn.setEnabled(false);
    this.context.opcion2Btn.setEnabled(false);
    this.context.opcion3Btn.setEnabled(false);
    this.context.opcion4Btn.setEnabled(false);
    this.context.opcion5Btn.setEnabled(false);
    this.context.opcion6Btn.setEnabled(false);
  }

  @Override
  public State nextState() {
    return new LoginNIPState(context);
  }

  private void colocarComportamiento() {
    ActionListenerWithContext defaultComportament = new ActionListenerWithContext(context) {
      @Override
      public void action() {
        continuar();
      }
    };

    this.context.opcion1Btn.addActionListener(defaultComportament);
    this.context.opcion2Btn.addActionListener(defaultComportament);
    this.context.opcion3Btn.addActionListener(defaultComportament);
    this.context.opcion4Btn.addActionListener(defaultComportament);
    this.context.opcion5Btn.addActionListener(defaultComportament);
    this.context.opcion6Btn.addActionListener(defaultComportament);
  }

  @Override
  public boolean continuar() {
    String in = this.input.getText();
    if (in.length() == 5) {
      this.context.colocarSesionActual(Integer.parseInt(obtenerInput()));
      context.changeState(nextState());
      return true;
    } else {
      JOptionPane.showMessageDialog(context.pantalla, "Tu numero de cuenta debe ser de 5 caracteres...");
      return false;
    }
  }

  @Override
  public void cancelar() {
    this.input.setText("");    
  }
}
