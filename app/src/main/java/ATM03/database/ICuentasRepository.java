package ATM03.database;

import ATM03.models.Cuenta;

public interface ICuentasRepository {
  Cuenta[] obtenerCUenta(int numeroCuenta);
  boolean guardarNuevaCuenta(Cuenta cuenta);
  boolean actualizarCuenta(Cuenta cuenta);
  boolean eleminarCuenta(int numeroCuenta);
  Cuenta[] obtenerCuentas();
}
