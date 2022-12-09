// RanuraDeposito.java
// Represents the deposit slot of the ATM

package ATM03.cajero.interfaces.GUI.hardware.ranura;

public class RanuraDeposito {
    // indica si se recibió el sobre (siempre devuelve true, ya que ésta
   // es sólo una simulación de software de una ranura de depósito real)
    public boolean seRecibioEfectivo() {
        return true; // se recibió el sobre
    } // fin del método seRecibioSobre
} // fin de la clase RanuraDeposito
