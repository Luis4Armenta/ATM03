// Deposito.java
// Representa una transacciÃ³n de depÃ³sito en el ATM
package ATM03.cajero.models.transacciones;

import ATM03.cajero.interfaces.GUI.hardware.ranura.RanuraDeposito;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public class Deposito extends Transaccion {

    private RanuraDeposito ranuraDeposito; // referencia a la ranura de depósito

    // constructor de Deposito
    public Deposito(ICuentasRepository database, int numeroCuenta, int monto, RanuraDeposito ranura) {
        // inicializa las variables de la superclase
        super(database, numeroCuenta, monto);

        // inicializa la referencia la ranura de depósito
        this.ranuraDeposito = ranura;
    } // fin del metodo constructor de Deposito

    // realiza la transacción
    @Override
    public boolean ejecutar() {
        // pregunta sobre todas las cuentas con el numero de cuenta dado
        Cuenta[] result = this.baseDatosBanco.obtenerCUenta(numeroCuenta);

        // si hay una cuenta la trata
        if (result.length > 0) {    //inicio de if
            Cuenta cuenta = result[0]; // selecciona la unica cuenta que hay

            // hace un abono a la cuenta para reflejar el depósito
            cuenta.abonar(this.monto);
            return this.baseDatosBanco.actualizarCuenta(cuenta) && this.ranuraDeposito.seRecibioEfectivo();
        } else { // fin de si e inicio de else
            return false;
        } // fin de else
    } // Fin del método ejecutar
} // fin de la clase transacción
