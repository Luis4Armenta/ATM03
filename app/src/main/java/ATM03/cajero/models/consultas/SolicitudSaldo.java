package ATM03.cajero.models.consultas;

import ATM03.models.Cuenta;

public class SolicitudSaldo extends Consulta {

  public SolicitudSaldo(int numeroCuentaEjecutor) {
    super(numeroCuentaEjecutor);
  }

  @Override
  public String consultar() {
    Cuenta[] result = this.database.obtenerCUenta(numeroCuentaEjecutor);
    
    if (result.length > 0) {
      Cuenta cuenta = result[0];

      return String.valueOf(cuenta.obtenerSaldoDisponible());
    } else {
      return "Error";
    }
  }
  
}
