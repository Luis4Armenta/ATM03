package ATM03.cajero.interfaces.GUI.hardware.dispensador;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billetera;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billete;
import org.mockito.Mockito;


public class BilleteraDebe {
  @Test
  public void consultar_el_billete_asignado() {
    Billete billete = Mockito.mock(Billete.class);

    Billetera billetera = new Billetera(billete, 2);

    billetera.obtenerTotal();

    Mockito.verify(billete, Mockito.times(1)).obtenerDenominacion();
  }

  @Test
  public void debe_retornar_la_cantidad_total_segun_la_denominacion_del_billete_y_la_cantidad_disponible() {
      Billete billete = Mockito.mock(Billete.class);

      Billetera billetera = new Billetera(billete, 2);

      Mockito.when(billete.obtenerDenominacion()).thenReturn(100);

      assertEquals(200, billetera.obtenerTotal()    );
  }
}
