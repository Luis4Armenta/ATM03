package ATM03.cajero.models.transacciones;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public abstract class Transaccion {
  public ICuentasRepository database;
  public int numeroCuentaEjecutor;
  public int monto;

  public Transaccion(int numeroCuentaEjecutor, int monto) {
    this.database = HashMapBinFileCuentasRepository.obtenerInstancia("archivo.bin");
    this.numeroCuentaEjecutor = numeroCuentaEjecutor;
    this.monto = monto;
  }

  public abstract boolean ejecutar();
}
