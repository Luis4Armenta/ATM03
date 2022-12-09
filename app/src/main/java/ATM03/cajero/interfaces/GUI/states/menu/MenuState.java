package ATM03.cajero.interfaces.GUI.states.menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ATM03.cajero.interfaces.GUI.GUI;
import ATM03.cajero.interfaces.GUI.states.ActionListenerWithContext;
import ATM03.cajero.interfaces.GUI.states.State;
import ATM03.cajero.interfaces.GUI.states.deposito.DepositoState;
import ATM03.cajero.interfaces.GUI.states.login.LoginNumeroUsuarioState;
import ATM03.cajero.interfaces.GUI.states.retiro.RetiroMenuState;
import ATM03.cajero.interfaces.GUI.states.retiro.RetiroState;

public class MenuState extends State {
  private JLabel Bienvenida;
  private JLabel indicacion;
  private JLabel indicacion1;
  private JLabel indicacion2;
  private JLabel indicacion3;

  public MenuState(GUI context) {
    super(context);

    setSize(500, 400);

    initComponents();
    this.colocarComportamiento();
  }

  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    Bienvenida = new javax.swing.JLabel();
    indicacion = new javax.swing.JLabel();
    indicacion1 = new javax.swing.JLabel();
    indicacion2 = new javax.swing.JLabel();
    indicacion3 = new javax.swing.JLabel();

    setLayout(new java.awt.GridBagLayout());

    Bienvenida.setText("Men\u00fa de trasnacciones");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
    add(Bienvenida, gridBagConstraints);

    indicacion.setText("2) Deposito");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
    add(indicacion, gridBagConstraints);

    indicacion1.setText("3) Consulta");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
    add(indicacion1, gridBagConstraints);

    indicacion2.setText("1) Retiro");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
    add(indicacion2, gridBagConstraints);

    indicacion3.setText(" Salir (4");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
    add(indicacion3, gridBagConstraints);

    
    this.context.opcion1Btn.setEnabled(true);
    this.context.opcion2Btn.setEnabled(true);
    this.context.opcion3Btn.setEnabled(true);
    this.context.opcion4Btn.setEnabled(true);
    this.context.opcion5Btn.setEnabled(false);
    this.context.opcion6Btn.setEnabled(false);
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

    this.context.opcion1Btn.addActionListener(new ActionListenerWithContext(context) {
      @Override
      public void action() {
//        this.context.changeState(new RetiroState(context));
          this.context.changeState(new RetiroMenuState(context));
      }
    });
    this.context.opcion2Btn.addActionListener(new ActionListenerWithContext(context) {
      @Override
      public void action() {
        this.context.changeState(new DepositoState(context));
      }
    });
    this.context.opcion3Btn.addActionListener(new ActionListenerWithContext(context) {
      @Override
      public void action() {
        JOptionPane.showMessageDialog(this.context.pantalla, this.context.service.consultar(1));
      }
    });
    this.context.opcion4Btn.addActionListener(
      new ActionListenerWithContext(context) {
        @Override
        public void action() {
          this.context.colocarSesionActual(0);
          this.context.service.cerrarSesion();
          this.context.changeState(new LoginNumeroUsuarioState(context));
        }
      }
    );
    this.context.opcion5Btn.addActionListener(defaultComportament);
    this.context.opcion6Btn.addActionListener(defaultComportament);
  }

  @Override
  public boolean continuar() {
    return true;
  }

  @Override
  public void cancelar() {
    this.context.colocarSesionActual(0);
    this.context.service.cerrarSesion();
    this.context.changeState(new LoginNumeroUsuarioState(context));
  }
}
