package ATM03.cajero.interfaces.GUI.hardware.dispensador;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billete;

public class Billetera {
  private Billete billetes;
  private int cantidadBilletes;
  private int billetesDeuda;
  
  public Billetera(Billete billete, int cantidadDeBilletes) {
    this.billetes = billete;
    this.cantidadBilletes = cantidadDeBilletes;
  }

  public int obtenerTotal() {
    return billetes.obtenerDenominacion() * this.cantidadBilletes;
  }

  public int obtenerDenominacion() { return this.billetes.obtenerDenominacion(); }

  public int cargarBilletes(int cantidadACargar) {
    return this.cantidadBilletes += cantidadACargar;
  }

  public int obtenerCantidadBilletes() { return this.cantidadBilletes; }

  public void agregarDeuda(int billetes) {
    this.billetesDeuda = billetes;
  }

  public void extraerBilletes() {
    this.billetesDeuda = 0;
    this.cantidadBilletes = this.cantidadBilletes - billetesDeuda;
  }

  public int obtenerDeuda() {
    return this.billetesDeuda;
  }

  public void cancelarDeuda() {
    this.billetesDeuda = 0;
  }
}
