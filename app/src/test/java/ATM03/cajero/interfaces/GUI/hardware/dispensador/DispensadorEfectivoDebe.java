package ATM03.cajero.interfaces.GUI.hardware.dispensador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ATM03.cajero.interfaces.GUI.hardware.dispensador.DispensadorEfectivo;
import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billete;
import ATM03.cajero.interfaces.GUI.hardware.dispensador.Billetera;
import org.junit.jupiter.api.Test;

public class DispensadorEfectivoDebe {
  @Test
  public void retornar_false_cuando_cantidad_no_es_multiplo_de_100() {
      Billetera billetera100 = new Billetera(new Billete(100), 2000);
      Billetera billetera200 = new Billetera(new Billete(200), 1500);
      Billetera billetera500 = new Billetera(new Billete(500), 1000);

      DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera100, billetera200, billetera500);

      boolean respuesta = dispensador.dispensar(150);

      assertFalse(respuesta);
  }

  @Test
  public void retornar_false_si_no_tenemos_suficiente_dinero() {
      Billetera billetera100 = new Billetera(new Billete(100), 1);
      Billetera billetera200 = new Billetera(new Billete(200), 0);
      Billetera billetera500 = new Billetera(new Billete(500), 0);

      DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera500, billetera200, billetera100);

      boolean respuesta = dispensador.dispensar(5000);

      assertFalse(respuesta);
  }

  @Test
  public void retornar_true_si_tenemos_los_billetes_adecuados_para_la_cantidad_solicitada() {
      Billetera billetera100 = new Billetera(new Billete(100), 1);
      Billetera billetera200 = new Billetera(new Billete(200), 0);
      Billetera billetera500 = new Billetera(new Billete(500), 0);

      DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera500, billetera200, billetera100);

      boolean respuesta = dispensador.dispensar(100);

      assertTrue(respuesta);
  }

  @Test
  public void retornar_fase_si_solo_tenemos_billetes_de_denominacion_mayor_a_la_cantidad_solicitada() {
      Billetera billetera100 = new Billetera(new Billete(100), 0);
      Billetera billetera200 = new Billetera(new Billete(200), 500);
      Billetera billetera500 = new Billetera(new Billete(500), 25);

      DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera500, billetera200, billetera100);

      boolean respuesta = dispensador.dispensar(100);

    assertFalse(respuesta);
  }
  @Test
    public void retornar_true_si_tenemos_puros_billetes_de_100_disponibles() {
      Billetera billetera100 = new Billetera(new Billete(100), 500);
      Billetera billetera200 = new Billetera(new Billete(200), 0);
      Billetera billetera500 = new Billetera(new Billete(500), 0);

      DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera500, billetera200, billetera100);

      boolean respuesta = dispensador.dispensar(200);

      assertTrue(respuesta);
  }
    @Test
    public void retorna_false_si_el_dispensador_esta_vacio() {
        Billetera billetera100 = new Billetera(new Billete(100), 0);
        Billetera billetera200 = new Billetera(new Billete(200), 0);
        Billetera billetera500 = new Billetera(new Billete(500), 0);

        DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera500, billetera200, billetera100);

        boolean respuesta = dispensador.dispensar(200);

        assertFalse(respuesta);
    }

    @Test
    public void retornar_false_si_no_se_llega_a_la_cantidad() {
        Billetera billetera100 = new Billetera(new Billete(100), 1);
        Billetera billetera200 = new Billetera(new Billete(200), 0);
        Billetera billetera500 = new Billetera(new Billete(500), 1);

        DispensadorEfectivo dispensador = new DispensadorEfectivo(billetera500, billetera200, billetera100);

        boolean respuesta = dispensador.dispensar(700);

        assertFalse(respuesta);
    }


  
}


