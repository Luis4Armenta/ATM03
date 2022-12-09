// ATM.java
// Representa la interfaz logica para interactuar con
// cualquier implementaci�n del ATM

package ATM03.cajero.models;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billete;
import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billetera;
import ATM03.cajero.interfaces.GUI.hardware.dispensador.DispensadorEfectivo;
import ATM03.cajero.interfaces.GUI.hardware.ranura.RanuraDeposito;
import ATM03.cajero.models.consultas.Consulta;
import ATM03.cajero.models.consultas.baseDatosBanco;
import ATM03.cajero.models.helpers.Autenticador;
import ATM03.cajero.models.transacciones.Deposito;
import ATM03.cajero.models.transacciones.Retiro;
import ATM03.cajero.models.transacciones.Transaccion;
import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;

public class ATM {
    private int numeroCuentaActual; // current user's account number
    private boolean usuarioAutenticado; // indica si el usuario es autenticado

    // constantes correspondientes a las opciones del men� principal
    private static final int CONSULTAR_SALDO = 1;
    private static final int RETIRO = 2;
    private static final int DEPOSITO = 3;

    
    private DispensadorEfectivo dispensadorEfectivo; // dispensador de efectivo del ATM
    private RanuraDeposito ranuraDeposito; // ranura de dep�sito del ATM
    private ICuentasRepository baseDatosBanco; //  base de datos de informaci�n de las cuentas

    // el constructor sin argumentos de ATM inicializa las variables de instancia
    public ATM() {
        this.numeroCuentaActual = 0; // al principio, no hay n�mero de cuenta
        this.usuarioAutenticado = false; // al principio, el usuario no est� autenticado
        this.dispensadorEfectivo = new DispensadorEfectivo(
                new Billetera(new Billete(100), 2000),
                new Billetera(new Billete(200), 1500),
                new Billetera(new Billete(500), 1000)
        ); // crea el dispensador de efectivo
        this.ranuraDeposito = new RanuraDeposito(); // crea la ranura de dep�sito
        // crea la base de datos de informaci�n de cuentas
        this.baseDatosBanco = HashMapBinFileCuentasRepository.obtenerInstancia("archivo.bin");
    } // fin del constructor sin argumentos de ATM

    // realiza consultas
    public String RealizarConsultas(int option) {
        // verifica que el usuario est� autenticado
        if (usuarioAutenticado) {
            // inicializa como nuevo objeto del tipo elegido
            return this.generarConsulta(option).consultar();
        } else {
            return "Autenticaci�n invalida...";
        }
    }

    // realiza transacciones
    public boolean realizarTransacciones(int opcion, int monto) {
        // verifica que el usuario est� autenticado
        if (usuarioAutenticado) {
            // inicializa como nuevo objeto del tipo elegido
            return this.generarTransaccion(opcion, monto).ejecutar();
        } else { // no esta autenticado
            return false; // retorna false porque no se pudo realizar
        } // fin de else
    } // fin del m�todo realizarTransacciones

    // cierra la sesi�n del usuario
    public void cerrarSesion() {
        this.numeroCuentaActual = 0; // quita el # del ATM
        this.usuarioAutenticado = false; // indica que la sesi�n est� cerrada
    }
    
    // trata de autenticar al usuario en la base de datos
    public boolean autenticarUsuario(int numeroCuenta, int nip) {
        // establece usuarioAutenticado con el valor booleano devuelto por la base de datos
        this.usuarioAutenticado = Autenticador.autenticarUsuario(numeroCuenta, nip);
        
        // verifica si la autenticaci�n tuvo �xito
        if (Autenticador.autenticarUsuario(numeroCuenta, nip)) {
            this.numeroCuentaActual = numeroCuenta; // guarda el # de cuenta del usuario
            
            return true;
        } else { // no se logro autenticar
            return false;
        } // fin else
    } // fin del m�todo autenticarUsuario
    
    // devuelve un objeto de la subclase especificada de Transaccion
    private Transaccion generarTransaccion(int opcion, int monto) {
        
        // determina qu� tipo de Transaccion crear   
        switch (opcion) {
            case RETIRO: // crea una nueva transacci�n Retiro
                return new Retiro(this.baseDatosBanco, this.numeroCuentaActual, monto, this.dispensadorEfectivo);
            case DEPOSITO: // crea una nueva transacci�n Deposito
                return new Deposito(this.baseDatosBanco, this.numeroCuentaActual, monto, this.ranuraDeposito);
            default:
                return null;
        } // fin de switch
    } // fin del m�todo crearTransaccion

    // devuelve un objeto de la subclase especificada de Consulta
    private Consulta generarConsulta(int opcion) {
        // determina qu� tipo de Transaccion crear   
        switch (opcion) {
            case CONSULTAR_SALDO: // crea una nueva transacci�n SolicitudSaldo
                return new baseDatosBanco(this.baseDatosBanco, this.numeroCuentaActual);
            default:
                return null;
        }
    } // fin del m�todo crearConsulta
} // fin de la clase ATM
