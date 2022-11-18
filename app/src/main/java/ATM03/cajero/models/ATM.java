package ATM03.cajero.models;

import ATM03.cajero.models.consultas.Consulta;
import ATM03.cajero.models.consultas.SolicitudSaldo;
import ATM03.cajero.models.helpers.Autentificador;
import ATM03.cajero.models.transacciones.Deposito;
import ATM03.cajero.models.transacciones.Retiro;
import ATM03.cajero.models.transacciones.Transaccion;

public class ATM {
  private int sesion;
  private boolean login;

  private static final int CONSULTAR_SALDO = 1;
  private static final int RETIRO = 2;
  private static final int DEPOSITO = 3;

  public ATM() {
    this.sesion = 0;
    this.login = false;  
  }

  public String consultar(int option) {
    if (login) {
      return this.generarConsulta(option).consultar();
    } else {
      return "Error";
    }
  }

  public boolean ejecutar(int opcion, int monto) {
    if (login) {
      return this.generarTransaccion(opcion, monto).ejecutar();
    } else {
      return false;
    }
  }

  public void cerrarSesion() {
    this.sesion = 0;
    this.login = false;
  }

  public boolean loggin(int numeroCuenta, int nip) {
    if (Autentificador.login(numeroCuenta, nip)) {
      this.sesion = numeroCuenta;
      this.login = true;

      return true;
    } else {
      return false;
    }
  }

  private Transaccion generarTransaccion(int opcion, int monto) {
    switch (opcion) {
      case RETIRO:
          return new Retiro(this.sesion, monto);
      case DEPOSITO:
          return new Deposito(this.sesion, monto);
      default:
          return null;
    }
  }

  private Consulta generarConsulta(int opcion) {
    switch (opcion) {
      case CONSULTAR_SALDO:
        return new SolicitudSaldo(this.sesion);
      default:
        return null;
    }
  }

}
