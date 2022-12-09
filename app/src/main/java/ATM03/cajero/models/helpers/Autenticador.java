// ATM.java
// Representa el proceso de autentificación para permitir
// al usuario utilizar el cajero segun sus credenciales

package ATM03.cajero.models.helpers;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public class Autenticador {
    // obtiene una conexión directa con la base de datos
    private static final ICuentasRepository database = HashMapBinFileCuentasRepository.obtenerInstancia("archivo.bin");

    // trata de autenticar al usuario
    public static boolean autenticarUsuario(int numeroCuenta, int nip) {
        // pregunta sobre todas las cuentas con el numero de cuenta dado
        Cuenta[] result = database.obtenerCUenta(numeroCuenta);

        // si hay una cuenta la trata
        if (result.length > 0) {
            Cuenta cuenta = result[0]; // selecciona la unica cuenta que hay
            
            // determina si un NIP especificado por el usuario coincide con el NIP en la Cuenta
            return cuenta.validarNIP(nip);
        } else { // retorna false si no se logro autenticar
            return false;
        } // fin else
    } // fin de autenticación
} // fin de la clase Autenticador
