package ATM03.cajero.models.helpers;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public class Autentificador {
  private static ICuentasRepository database = HashMapBinFileCuentasRepository.obtenerInstancia("archivo.bin");
  
  public static boolean login(int numeroCuenta, int nip) {
    Cuenta[] result = database.obtenerCUenta(numeroCuenta);
    
    if (result.length > 0) {
      Cuenta cuenta = result[0];

      return cuenta.validarNIP(nip);
    } else {
      return false;
    }
  }
}
