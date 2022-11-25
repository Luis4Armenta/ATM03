package ATM03.cajero.interfaces.GUI.hardware.ranura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RanuraDepositoTest {
    @Test
    public void retornar_true_siempre() {
        RanuraDeposito ranura = new RanuraDeposito();

        assertTrue(ranura.seRecibioEfectivo());
    }
}