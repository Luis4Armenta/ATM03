// baseDatosBanco.java
// Representa una consulta de solicitud de saldo en el ATM

package ATM03.cajero.models.consultas;

import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public class baseDatosBanco extends Consulta {
    
    // constructor de SolicitudSaldo
    public baseDatosBanco(ICuentasRepository baseDatosBanco, int numeroCuenta) {
        super(baseDatosBanco, numeroCuenta);
    } // fin del constructor de SolicitudSaldo

    
    // realiza la transacción
    @Override
    public String consultar() {
        // pregunta sobre todas las cuentas con el numero de cuenta dado
        Cuenta[] result = this.baseDatosBanco.obtenerCUenta(numeroCuenta);

        // si hay una cuenta la trata
        if (result.length > 0) {
            Cuenta cuenta = result[0]; // selecciona la unica cuenta que hay
            
            // obtiene el saldo total para la cuenta implicada
            return String.valueOf(cuenta.obtenerSaldoDisponible());
        } else { // no se encuentra una cuenta
            return "No se ha encontrado ninguna cuenta con el número de cuenta dado...";
        } // fin else
    } // fin del método ejecutar
} // fin de la clase SolicitudSaldo
