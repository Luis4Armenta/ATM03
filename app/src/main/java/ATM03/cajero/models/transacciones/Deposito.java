package ATM03.cajero.models.transacciones;

import ATM03.models.Cuenta;

public class Deposito extends Transaccion {
  public Deposito(int numeroCuenta, int monto) {
    super(numeroCuenta, monto);
  }

  @Override
  public boolean ejecutar() {
    Cuenta[] result = this.database.obtenerCUenta(numeroCuentaEjecutor);

    if (result.length > 0) {
      Cuenta cuenta = result[0];

      cuenta.abonar(this.monto);
      return this.database.actualizarCuenta(cuenta);
    } else {
      return false;
    }
  }
}
