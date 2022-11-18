package ATM03.cajero.models.transacciones;

import ATM03.models.Cuenta;

public class Retiro extends Transaccion {
  public Retiro(int numeroCuentaEjecutor, int monto) {
    super(numeroCuentaEjecutor, monto);
  }

  @Override
  public boolean ejecutar() {
    Cuenta[] result = this.database.obtenerCUenta(numeroCuentaEjecutor);

    if (result.length > 0) {
      Cuenta cuenta = result[0];

      return this.database.actualizarCuenta(cuenta);
    } else {
      return false;
    }
  }
}
