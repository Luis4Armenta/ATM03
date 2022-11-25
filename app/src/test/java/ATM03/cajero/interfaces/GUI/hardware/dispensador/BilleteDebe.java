package ATM03.cajero.interfaces.GUI.hardware.dispensador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billete;

public class BilleteDebe {
  @Test
  public void retornar_la_denominacion_indicada() {
    Billete billete100 = new Billete(100);

    assertEquals(100, billete100.obtenerDenominacion());
  }
}
