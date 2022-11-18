package ATM03.cajero.interfaces.text;

import ATM03.cajero.models.ATM;

public class ATMText {
  private Pantalla pantalla;
  private Teclado teclado;
  private ATM ATM;

  private boolean usuarioAutentificado;
  private int numeroCuentaActual;

  // constantes correspondientes a las opciones del men? principal
  private static final int SOLICITUD_SALDO = 1;
  private static final int RETIRO = 2;
  private static final int DEPOSITO = 3;
  private static final int SALIR = 4;
  
  public ATMText() {
    this.ATM = new ATM();
    this.pantalla = new Pantalla();
    this.teclado = new Teclado();
    this.usuarioAutentificado = false;

    this.numeroCuentaActual = 0;
  }

  public void run() {
    while (true) {
      while (!this.usuarioAutentificado) {
        this.pantalla.mostrarLineaMensaje( "\nBienvenido!" );
        this.autentificarUsuario();

        realizarTransacciones(); // ahora el usuario est? autenticado 
        this.usuarioAutentificado = false;
        this.numeroCuentaActual = 0;
        pantalla.mostrarLineaMensaje( "\nGracias! Adios!" );
      }
    }
  }

  public void autentificarUsuario() {
    while (!this.usuarioAutentificado) {
      pantalla.mostrarMensaje( "\nEscriba su numero de cuenta: " );
      int numeroCuenta = teclado.obtenerEntrada();
      pantalla.mostrarMensaje( "\nEscriba su NIP: " );
      int nip = teclado.obtenerEntrada();

      this.usuarioAutentificado = this.ATM.loggin(numeroCuenta, nip);
      
      if (this.usuarioAutentificado) {
        this.numeroCuentaActual = numeroCuenta;
      } else {
        pantalla.mostrarLineaMensaje( 
              "Numero de cuenta o NIP invalido. Intente de nuevo." );
      }
    }
  }

  public void realizarTransacciones() {
    boolean usuarioSalio = false;

    while (!usuarioSalio) {
      int seleccionMenuPrincipal = mostrarMenuPrincipal();
      boolean exito;
      String payload;

      switch (seleccionMenuPrincipal) {
        case SOLICITUD_SALDO:

          int saldoDisponible = (int) Double.parseDouble(this.ATM.consultar(SOLICITUD_SALDO));

          // muestra la informaci?n del saldo en la pantalla
          pantalla.mostrarLineaMensaje( "\nInformacion de saldo:" );
          pantalla.mostrarMensaje( " - Saldo disponible: " ); 
          pantalla.mostrarMontoDolares( saldoDisponible );
          pantalla.mostrarLineaMensaje( "" );
          break;
        case RETIRO:
          boolean efectivoDispensado  = false;

          do {
            int monto = mostrarMenuDeMontos();

            if (monto != -1) {
              exito = this.ATM.ejecutar(RETIRO, monto);
  
              if (exito) {
                pantalla.mostrarLineaMensaje( 
                        "\nTome ahora su efectivo." );
              } else {
                pantalla.mostrarLineaMensaje( 
                    "\nNo hay suficientes fondos en su cuenta." +
                    "\n\nSeleccione un monto menor." );
              }
            } else {
              usuarioSalio = true;
              pantalla.mostrarLineaMensaje( "\nCancelando transaccion..." );
              break;
            }
          } while (!efectivoDispensado);
        break;
        case DEPOSITO:

          int monto = this.pedirMontoADepositar();

          if (monto != 0) {
            pantalla.mostrarMensaje( 
            "\nInserte la cantidad a depositar " );
            pantalla.mostrarMontoDolares( monto );
            pantalla.mostrarLineaMensaje( "." );

            
            boolean result = this.ATM.ejecutar(DEPOSITO, monto);
            
            if (result) {
              pantalla.mostrarLineaMensaje( "\n Se ha recibido correctamente su deposito, gracias. :)" );
            } else {
              pantalla.mostrarLineaMensaje( "\nNo inserto un sobre de " +
               "deposito, por lo que el ATM ha cancelado su transaccion." );
            }
          } else {
            pantalla.mostrarLineaMensaje( "\nCancelando transaccion..." );
          }
        break;
        case SALIR:
          pantalla.mostrarLineaMensaje( "\nCerrando el sistema..." );
          usuarioSalio = true; // esta sesi?n con el ATM debe terminar
          this.usuarioAutentificado = false;
          
        default:
          pantalla.mostrarLineaMensaje( 
                  "\nNo introdujo una seleccion valida. Intente de nuevo." );
          break;
      }
    }
  }

  public int mostrarMenuPrincipal() {
    pantalla.mostrarLineaMensaje( "\nMenu principal:" );
      pantalla.mostrarLineaMensaje( "1 - Ver mi saldo" );
      pantalla.mostrarLineaMensaje( "2 - Retirar efectivo" );
      pantalla.mostrarLineaMensaje( "3 - Depositar fondos" );
      pantalla.mostrarLineaMensaje( "4 - Salir\n" );
      pantalla.mostrarMensaje( "Escriba una opcion: " );
      return teclado.obtenerEntrada(); // devuelve la opcion seleccionada por el usuario
  }

  private int mostrarMenuDeMontos()
   {
      int opcionUsuario = 0; // variable local para almacenar el valor de retorno
      // arreglo de montos que corresponde a los n?meros del men?
      int montos[] = { 0, 20, 40, 60, 100, 200 };

      // itera mientras no se haya elegido una opci?n v?lida
      while ( opcionUsuario == 0 )
      {
         // muestra el men?
         pantalla.mostrarLineaMensaje( "\nMenu de retiro:" );
         pantalla.mostrarLineaMensaje( "1 - $20" );
         pantalla.mostrarLineaMensaje( "2 - $40" );
         pantalla.mostrarLineaMensaje( "3 - $60" );
         pantalla.mostrarLineaMensaje( "4 - $100" );
         pantalla.mostrarLineaMensaje( "5 - $200" );
         pantalla.mostrarLineaMensaje( "6 - Cancelar transaccion" );
         pantalla.mostrarMensaje( "\nSeleccione un monto a retirar: " );

         int entrada = teclado.obtenerEntrada(); // obtiene la entrada del usuario mediante el teclado

         // determina c?mo proceder con base en el valor de la entrada
         switch ( entrada )
         {
            case 1: // si el usuario eligi? un monto de retiro
            case 2: // (es decir, si eligi? la opci?n 1, 2, 3, 4 o 5), devolver
            case 3: // el monto correspondiente del arreglo montos
            case 4:
            case 5:
               opcionUsuario = montos[ entrada ]; // guarda la elecci?n del usuario
               break;       
            case 6: // el usuario eligi? cancelar
               opcionUsuario = -1; // guarda la elecci?n del usuario
               break;
            default: // el usuario no introdujo un valor del 1 al 6
               pantalla.mostrarLineaMensaje( 
                  "\nSeleccion invalida. Intente de nuevo." );
         } // fin de switch
      } // fin de while

      return opcionUsuario; // devuelve el monto de retiro o CANCELO
   } // fin del m?todo mostrarMenuDeMontos


   // pide al usuario que introduzca un monto a depositar en centavos
   private int pedirMontoADepositar()
   {
      // muestra el indicador
      pantalla.mostrarMensaje( "\nIntroduzca un monto a depositar en " + 
         "CENTAVOS (o 0 para cancelar): " );
      int entrada = teclado.obtenerEntrada(); // recibe la entrada del monto de dep?sito
      
      // comprueba si el usuario cancel? o introdujo un monto v?lido
      if ( entrada == 0 ) 
         return 0;
      else
      {
         return entrada; // devuelve el monto en d?lares
      } // fin de else
   } // fin del m?todo pedirMontoADepositar
}
