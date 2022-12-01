package ATM03.cajero.models.transacciones;

import ATM03.cajero.interfaces.GUI.hardware.ranura.RanuraDeposito;
import ATM03.models.Cuenta;

public class Deposito extends Transaccion {
  private RanuraDeposito ranura;
  public Deposito(int numeroCuenta, int monto, RanuraDeposito ranura) {
    super(numeroCuenta, monto);
    this.ranura = ranura;
  }

  @Override
  public boolean ejecutar() {
    Cuenta[] result = this.database.obtenerCUenta(numeroCuentaEjecutor);

    if (result.length > 0) {
      Cuenta cuenta = result[0];

      cuenta.abonar(this.monto);
      return this.database.actualizarCuenta(cuenta) && this.ranura.seRecibioEfectivo();
    } else {
      return false;
    }
  }
}
