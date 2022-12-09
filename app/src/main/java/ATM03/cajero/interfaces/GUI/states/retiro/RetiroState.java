package ATM03.cajero.interfaces.GUI.states.retiro;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ATM03.cajero.interfaces.GUI.GUI;
import ATM03.cajero.interfaces.GUI.states.ActionListenerWithContext;
import ATM03.cajero.interfaces.GUI.states.State;
import ATM03.cajero.interfaces.GUI.states.menu.MenuState;

public class RetiroState extends State {
  private Timer timer;
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

        indicacion.setText("Digita la cantidad a retirar (o 0 para cancelar):");
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

        
        this.context.opcion1Btn.setEnabled(false);
        this.context.opcion2Btn.setEnabled(false);
        this.context.opcion3Btn.setEnabled(false);
        this.context.opcion4Btn.setEnabled(false);
        this.context.opcion5Btn.setEnabled(false);
        this.context.opcion6Btn.setEnabled(false);
        
        this.context.dejarBilletesBtn.setEnabled(false);
        this.context.tomarBilletesBtn.setEnabled(false);

        this.iniciarCounter(120000);
  }

  private void iniciarCounter(int ms) {
    this.timer = new Timer();
        TimerTask task = new Contador(this.context) {
          @Override
          public void run() {
            this.context.changeState(new MenuState(context));
            JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado el retiro por inactividad...");
          }
        };
    timer.schedule(task, ms);
  }

  private void cancelarTimer() {
    this.timer.cancel();
    this.timer.purge();
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
    if (this.context.getState().obtenerInput().isEmpty()) {
      JOptionPane.showMessageDialog(this.context.pantalla, "Por favor digita la cantidad a depositar");
      return false;
    }

    int monto = Integer.parseInt(this.context.getState().obtenerInput());

    if (monto <= 0) {
        this.cancelarTimer();
        this.context.changeState(new RetiroMenuState(this.context));
        JOptionPane.showMessageDialog(this.context.pantalla, "Se ha cancelado el retiro");
        return false;
    }

    if (this.context.service.realizarTransacciones(2, monto)) {
      this.context.tomarBilletesBtn.setEnabled(true);
      this.cancelarTimer();
      JOptionPane.showMessageDialog(this.context.pantalla, "Se ha compleado el retiro, no olvides tomar tu dinero.");
      this.context.changeState(new MenuState(context));
      return true;
    } else {
      this.cancelarTimer();
      this.iniciarCounter(120000);
      JOptionPane.showMessageDialog(this.context.pantalla, "No se ha podido completar el retiro... D:");
      return false;
    }
  }

  @Override
  public void cancelar() {
    this.cancelarTimer();
    this.context.changeState(new RetiroMenuState(context));
  }
}
