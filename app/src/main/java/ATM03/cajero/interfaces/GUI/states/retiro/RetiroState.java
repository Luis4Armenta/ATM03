package ATM03.cajero.interfaces.GUI.states.retiro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ATM03.cajero.interfaces.GUI.GUI;
import ATM03.cajero.interfaces.GUI.states.ActionListenerWithContext;
import ATM03.cajero.interfaces.GUI.states.State;
import ATM03.cajero.interfaces.GUI.states.login.LoginNumeroUsuarioState;
import ATM03.cajero.interfaces.GUI.states.menu.MenuState;

public class RetiroState extends State {
  private JLabel Bienvenida;
  private JLabel indicacion;
  private JLabel jLabel1;

  public RetiroState(GUI context) {
    super(context);

    setSize(500, 400);

    initComponents();
    this.colocarComportamiento();
  }

  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

        Bienvenida = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        indicacion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        Bienvenida.setText("Retiro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(Bienvenida, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 10, 10);
        add(input, gridBagConstraints);

        indicacion.setText("Digita la cantidad a retirar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 5);
        add(indicacion, gridBagConstraints);

        jLabel1.setText("$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(jLabel1, gridBagConstraints);
  }

  @Override
  public State nextState() {
    // TODO Auto-generated method stub
    return null;
  }

  private void colocarComportamiento() {
    ActionListenerWithContext defaultComportament = new ActionListenerWithContext(context) {
      @Override
      public void action() {
        
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
    int monto = Integer.parseInt(this.context.getState().obtenerInput());


    if (this.context.service.ejecutar(2, monto)) {
      JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
      this.context.changeState(new MenuState(context));
      return true;
    } else {
      JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
      return false;
    }
  }

  @Override
  public void cancelar() {
    this.context.changeState(new MenuState(context));
  }
}