package ATM03.cajero.interfaces.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ATM03.cajero.interfaces.GUI.states.ActionListenerWithContext;
import ATM03.cajero.interfaces.GUI.states.State;
import ATM03.cajero.interfaces.GUI.states.login.LoginNumeroUsuarioState;
import ATM03.cajero.interfaces.text.Pantalla;
import ATM03.cajero.models.ATM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class GUI implements IEventListener{
  private int sesionActual;
  public ATM service;
  public JFrame frame;
  public JButton opcion1Btn;
  public JButton opcion2Btn;
  public JButton opcion3Btn;
  public JButton opcion4Btn;
  public JButton opcion5Btn;
  public JButton opcion6Btn;
  public JButton tomarBilletesBtn;
  public JButton dejarBilletesBtn;
  public JButton cobrarBtn;
  public JPanel pantalla;
  public Teclado teclado;

  public GUI(ATM service, Pantalla pantalla, Teclado teclado ) {
    this.service = service;

    this.frame = new JFrame();
    this.opcion1Btn = new JButton("Opcion 1");
    this.opcion2Btn = new JButton("Opcion 2");
    this.opcion3Btn = new JButton("Opcion 3");
    this.opcion4Btn = new JButton("Opcion 4");
    this.opcion5Btn = new JButton("Opcion 5");
    this.opcion6Btn = new JButton("Opcion 6");
    this.tomarBilletesBtn = new JButton("Tomar billetes");
    this.dejarBilletesBtn = new JButton("Poner billetes");
    this.pantalla = new JPanel();
    this.teclado = teclado;

    this.init();
  }

  private void init() {
    this.configurarFrame();
    this.configurarBotones();
    this.configurarPantalla();
    this.configurarTeclado();
    this.configurarDejarBilletesBtn();
    this.configurarTomarBilletesBtn();
    
    this.teclado.events.subscribe("numero", this);
    this.teclado.events.subscribe("cancelar", this);
    this.teclado.events.subscribe("continuar", this);
    this.teclado.events.subscribe("limpiar", this);

    this.frame.pack();
    this.frame.setLocationRelativeTo(null);
    this.frame.setVisible(true);
    this.frame.setAlwaysOnTop(true);
    this.frame.requestFocus();
  }

  public void colocarSesionActual(int sesion) {
    this.sesionActual = sesion;
  }

  public int obtenerSesionActual() {
    return this.sesionActual;
  }

  public void changeState(State state) {
    // removiendo antiguo state y añadiendo el nuevo
    this.pantalla.remove(this.getState());
    this.pantalla.add(state);
    
    // recargando pantalla
    this.pantalla.revalidate();
    this.pantalla.repaint();
  }


  public State getState() {
      // obteniendo state desde dentro de la pantalla
      Component[] components = this.pantalla.getComponents();
      
      if (components.length > 0) {
          State state = (State) components[0];
          return state;
      } else {
          return null;
      }
  }

  private void configurarFrame() {
    // Configuraciones básicas del frame
    this.frame.setDefaultCloseOperation(3);
    this.frame.setTitle("Cajero automatico");
    
    // Colocando layout
    this.frame.getContentPane().setLayout(new GridBagLayout());
  }
  
  private void configurarBotones() {
    this.configurarOpcion1Btn();
    this.configurarOpcion2Btn();
    this.configurarOpcion3Btn();
    this.configurarOpcion4Btn();
    this.configurarOpcion5Btn();
    this.configurarOpcion6Btn(); 
  }
  
  private void configurarOpcion1Btn() {
    GridBagConstraints option1BtnLayoutSettings = new GridBagConstraints();
    option1BtnLayoutSettings.gridx = 0;
    option1BtnLayoutSettings.gridy = 0;
    option1BtnLayoutSettings.gridwidth = 1;
    option1BtnLayoutSettings.ipadx = 30;
    option1BtnLayoutSettings.ipady = 10;
    option1BtnLayoutSettings.insets = new java.awt.Insets(70, 10, 10, 10);
    
    this.frame.getContentPane().add(this.opcion1Btn, option1BtnLayoutSettings);
  }
  private void configurarOpcion2Btn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 0;
    optionBtnLayoutSettings.gridy = 1;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(10, 10, 10, 10);
                            
    this.frame.getContentPane().add(this.opcion2Btn, optionBtnLayoutSettings);
  }
  private void configurarOpcion3Btn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 0;
    optionBtnLayoutSettings.gridy = 2;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(10, 10, 10, 10);
                            
    this.frame.getContentPane().add(this.opcion3Btn, optionBtnLayoutSettings);
  }
  private void configurarOpcion4Btn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 6;
    optionBtnLayoutSettings.gridy = 0;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(70, 10, 10, 10);

    this.frame.getContentPane().add(this.opcion4Btn, optionBtnLayoutSettings);
  }
  private void configurarOpcion5Btn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 6;
    optionBtnLayoutSettings.gridy = 1;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(10, 10, 10, 10);

    this.frame.getContentPane().add(this.opcion5Btn, optionBtnLayoutSettings);    
  }
  private void configurarOpcion6Btn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 6;
    optionBtnLayoutSettings.gridy = 2;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(10, 10, 10, 10);

    this.frame.getContentPane().add(this.opcion6Btn, optionBtnLayoutSettings);
  }

  private void configurarPantalla() {
    GridBagConstraints pantallaLayoutSettings = new GridBagConstraints();
    pantallaLayoutSettings.gridx = 1;
    pantallaLayoutSettings.gridy = 0;
    pantallaLayoutSettings.gridwidth = 5;
    pantallaLayoutSettings.gridheight = 3;
    pantallaLayoutSettings.ipadx = 30;
    pantallaLayoutSettings.ipady = 10;
    pantallaLayoutSettings.insets = new java.awt.Insets(10, 10, 10, 10);
    
    
    // Colocando layout a la pantalla para que su state aparezca en medio
    this.pantalla.setLayout(new java.awt.CardLayout());

    

    // Colocando las dimensiones de la pantalla
    Dimension size = new Dimension(400, 200);
    
    this.pantalla.setSize(size);
    this.pantalla.setPreferredSize(size);
    this.pantalla.setMaximumSize(size);
    this.pantalla.setMinimumSize(size);
    
    this.pantalla.setBorder(new LineBorder(Color.BLACK, 1, true));

    
    // Agregando state a la ventana
    this.pantalla.add(new LoginNumeroUsuarioState(this));


    this.frame.getContentPane().add(this.pantalla, pantallaLayoutSettings);
  }

  private void configurarTeclado() {
    GridBagConstraints tecladoLayoutSettings = new GridBagConstraints();
    tecladoLayoutSettings.gridx = 1;
    tecladoLayoutSettings.gridy = 3;
    tecladoLayoutSettings.gridwidth = 1;
    tecladoLayoutSettings.gridheight = 6;
    tecladoLayoutSettings.ipadx = 30;
    tecladoLayoutSettings.ipady = 30;
    tecladoLayoutSettings.insets = new java.awt.Insets(10, 10, 10, 10);

    this.frame.add(this.teclado, tecladoLayoutSettings);
  }

  private void configurarTomarBilletesBtn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 6;
    optionBtnLayoutSettings.gridy = 4;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(70, 10, 10, 10);
    optionBtnLayoutSettings.anchor = java.awt.GridBagConstraints.CENTER;

    this.tomarBilletesBtn.setEnabled(false);

    this.tomarBilletesBtn.addActionListener(new ActionListenerWithContext(this) {
      @Override
      public void action() {
        this.context.tomarBilletesBtn.setEnabled(
          !this.context.tomarBilletesBtn.isEnabled()
        );
      }
    });

    this.frame.getContentPane().add(this.tomarBilletesBtn, optionBtnLayoutSettings);
  }

  private void configurarDejarBilletesBtn() {
    GridBagConstraints optionBtnLayoutSettings = new GridBagConstraints();
    optionBtnLayoutSettings.gridx = 6;
    optionBtnLayoutSettings.gridy = 5;
    optionBtnLayoutSettings.gridwidth = 1;
    optionBtnLayoutSettings.ipadx = 30;
    optionBtnLayoutSettings.ipady = 10;
    optionBtnLayoutSettings.insets = new java.awt.Insets(70, 10, 10, 10);
    optionBtnLayoutSettings.anchor = java.awt.GridBagConstraints.CENTER;

    this.dejarBilletesBtn.setEnabled(false);

    this.dejarBilletesBtn.addActionListener(new ActionListenerWithContext(this) {
      @Override
      public void action() {
        this.context.dejarBilletesBtn.setEnabled(
          !this.context.dejarBilletesBtn.isEnabled()
        );
      }
    });

    this.frame.getContentPane().add(this.dejarBilletesBtn, optionBtnLayoutSettings);
  }

  @Override
  public void update(String eventType, int numero) {
    switch (eventType) {
      case "numero":
        this.getState().input.setText((this.getState().obtenerInput() + numero));
        break;
      case "cancelar":
        this.getState().cancelar();
      break;
      case "continuar":
        if (this.getState().continuar()) {
          System.out.println("exito");
        }
      break;
      case "limpiar":
        this.getState().input.setText("");
      default:
        break;
    }
    
  }
}
