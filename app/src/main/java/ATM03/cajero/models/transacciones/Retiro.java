package ATM03.cajero.models.transacciones;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.DispensadorEfectivo;
import ATM03.models.Cuenta;

public class Retiro extends Transaccion {
  private DispensadorEfectivo dispensador;
  public Retiro(int numeroCuentaEjecutor, int monto, DispensadorEfectivo dispensador) {
    super(numeroCuentaEjecutor, monto);
    this.dispensador = dispensador;
  }

  @Override
  public boolean ejecutar() {
    Cuenta[] result = this.database.obtenerCUenta(numeroCuentaEjecutor);

    if (result.length > 0) {
      Cuenta cuenta = result[0];

      if (this.dispensador.dispensar(monto)) {
        cuenta.cargar(monto);
        return this.database.actualizarCuenta(cuenta);
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
