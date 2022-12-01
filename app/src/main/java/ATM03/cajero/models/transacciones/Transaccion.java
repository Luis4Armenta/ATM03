package ATM03.cajero.models.transacciones;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;

public abstract class Transaccion {
  public ICuentasRepository database;
  public int numeroCuentaEjecutor;
  public int monto;

  public Transaccion(ICuentasRepository database, int numeroCuentaEjecutor, int monto) {
    this.database = database;
    this.numeroCuentaEjecutor = numeroCuentaEjecutor;
    this.monto = monto;
  }

  public abstract boolean ejecutar();
}
