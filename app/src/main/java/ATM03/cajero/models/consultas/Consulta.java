package ATM03.cajero.models.consultas;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;

public abstract class Consulta {
  public ICuentasRepository database;
  public int numeroCuentaEjecutor;
  public int monto;

  public Consulta(ICuentasRepository database, int numeroCuentaEjecutor) {
    this.database = database;
    this.numeroCuentaEjecutor = numeroCuentaEjecutor;
  }

  public abstract String consultar();
}
