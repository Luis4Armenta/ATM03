// Retiro.java
// Representa una transacción de retiro en el ATM
package ATM03.cajero.models.transacciones;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.DispensadorEfectivo;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public class Retiro extends Transaccion {

    private final DispensadorEfectivo dispensadorEfectivo; // referencia al dispensadorEfectivo de efectivo

    // constructor de Retiro
    public Retiro(
            ICuentasRepository baseDatosBanco,
            int numeroCuentaATM,
            int monto,
            DispensadorEfectivo dispensadorEfectivo
    ) {
        // inicializa las variables de la superclase
        super(baseDatosBanco, numeroCuentaATM, monto);
        
        // inicializa la referencia a dispensador de efectivo
        this.dispensadorEfectivo = dispensadorEfectivo;
    }// fin del constructor de Retiro

    // realiza la transacción
    @Override
    public boolean ejecutar() {
        // pregunta sobre todas las cuentas con el numero de cuenta dado
        Cuenta[] result = this.baseDatosBanco.obtenerCUenta(numeroCuenta);

        // si hay una cuenta la trata
        if (result.length > 0) { // inicio if
            Cuenta cuenta = result[0]; // selecciona la unica cuenta que hay

            // comprueba si el dispensador de efectivo tiene suficiente dinero
            if (this.dispensadorEfectivo.dispensarEfectivo(monto)) {
                // actualiza la cuenta implicada para reflejar el saldo
                cuenta.cargar(monto);
                
                return this.baseDatosBanco.actualizarCuenta(cuenta);
            } else { // el dispensador no tiene suficiente efectivo
                return false;
            } // fin else
        } else { // el dispensador no tiene suficiente efectivo
            return false;
        } // fin else
    } // fin del método ejecutar
} // fin de la clase Retiro
