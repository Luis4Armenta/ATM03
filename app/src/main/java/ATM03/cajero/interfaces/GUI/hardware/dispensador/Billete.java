package ATM03.cajero.interfaces.GUI.hardware.dispensador;

public class Billete {
  private int denominacion;
  
  public Billete(int denominacion) {
    this.denominacion = denominacion;
  }

  public int obtenerDenominacion() {
    return this.denominacion;
  }
}
