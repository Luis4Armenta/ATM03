package ATM03.cajero.interfaces.GUI.states.retiro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ATM03.cajero.interfaces.GUI.GUI;
import ATM03.cajero.interfaces.GUI.states.ActionListenerWithContext;
import ATM03.cajero.interfaces.GUI.states.State;
import ATM03.cajero.interfaces.GUI.states.login.LoginNumeroUsuarioState;
import ATM03.cajero.interfaces.GUI.states.menu.MenuState;

public class RetiroMenuState extends State {
  private JLabel Bienvenida;
  private JLabel indicacion;
  private JLabel jLabel1;

  public RetiroMenuState(GUI context) {
    super(context);

    setSize(500, 400);

    initComponents();
    this.colocarComportamiento();
  }

  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

      JLabel Bienvenida = new javax.swing.JLabel();
      JLabel indicacion = new javax.swing.JLabel();
      JLabel indicacion1 = new javax.swing.JLabel();
      JLabel indicacion2 = new javax.swing.JLabel();
      JLabel indicacion3 = new javax.swing.JLabel();
      JLabel indicacion4 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        Bienvenida.setText("Elige el monto de retiro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        add(Bienvenida, gridBagConstraints);

        indicacion.setText("2) $200");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        add(indicacion, gridBagConstraints);

        indicacion1.setText("3) $300");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        add(indicacion1, gridBagConstraints);

        indicacion2.setText("1) $100");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        add(indicacion2, gridBagConstraints);

        indicacion3.setText(" otro (5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
        add(indicacion3, gridBagConstraints);

        indicacion4.setText(" $500 (4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
        add(indicacion4, gridBagConstraints);
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
          int monto = 100;
          
        if (monto <= 0) {
            this.context.changeState(new MenuState(this.context));
            JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado la transacción");
        }

        if (this.context.service.ejecutar(2, monto)) {
          JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
          this.context.changeState(new MenuState(context));
        } else {
          JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
        }
      }
    });
    this.context.opcion2Btn.addActionListener(new ActionListenerWithContext(context) {
      @Override
      public void action() {
          int monto = 200;
          
        if (monto <= 0) {
            this.context.changeState(new MenuState(this.context));
            JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado la transacción");
        }

        if (this.context.service.ejecutar(2, monto)) {
          JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
          this.context.changeState(new MenuState(context));
        } else {
          JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
        }
      }
    });
    this.context.opcion3Btn.addActionListener(new ActionListenerWithContext(context) {
      @Override
      public void action() {
        int monto = 300;
          
        if (monto <= 0) {
            this.context.changeState(new MenuState(this.context));
            JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado la transacción");
        }

        if (this.context.service.ejecutar(2, monto)) {
          JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
          this.context.changeState(new MenuState(context));
        } else {
          JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
        }
      }
    });
    this.context.opcion4Btn.addActionListener(
      new ActionListenerWithContext(context) {
        @Override
        public void action() {
          int monto = 500;
          
        if (monto <= 0) {
            this.context.changeState(new MenuState(this.context));
            JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado la transacción");
        }

        if (this.context.service.ejecutar(2, monto)) {
          JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
          this.context.changeState(new MenuState(context));
        } else {
          JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
        }
        }
      }
    );
    this.context.opcion5Btn.addActionListener(new ActionListenerWithContext(context) {
        @Override
        public void action() {
            this.context.changeState(new RetiroState(context));
        }
    });
    this.context.opcion6Btn.addActionListener(defaultComportament);
  }

  @Override
  public boolean continuar() {
    return false;
  }

  @Override
  public void cancelar() {
    this.context.changeState(new MenuState(context));
  }

  public void retirar(int monto) {
    if (monto <= 0) {
        this.context.changeState(new MenuState(this.context));
        JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado la transacción");
    }

    if (this.context.service.ejecutar(2, monto)) {
      JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
      this.context.changeState(new MenuState(context));
    } else {
      JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
    }
  }
}

