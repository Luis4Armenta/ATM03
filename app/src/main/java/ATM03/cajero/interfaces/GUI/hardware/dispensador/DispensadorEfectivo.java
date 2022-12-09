// DispensadorEfectivo.java
// Representa al dispensador de efectivo del ATM
package ATM03.cajero.interfaces.GUI.hardware.dispensador;

public class DispensadorEfectivo {

    Billetera[] billeteras; // Son los depositos de billetes

    public DispensadorEfectivo(Billetera... depositos) {  // Recibimos billeteras de cada denominaciÛn
        this.billeteras = depositos;
    }

    // simula la acciÛn de dispensar el monto especificado de efectivo
    public boolean dispensarEfectivo(int cantidad) {
        int necesito = cantidad;  // Se define la cantidad que se necesita recolectar en billetes de todo tipo para cumplir

        // verificamos si la cantidad solicitada es multiplo de 100
        if (cantidad % 100 == 0 && cantidad > 0) {  
            // recorremos todas nuestros contenedores de billetes
            for (Billetera billetera : this.billeteras) { 

                // Si un contenedor de billetes est√° vac√≠o simplemente lo saltamos
                if (billetera.obtenerTotal() <= 0) {
                    continue; // salta al siguiente ciclo del for.
                }

                // tomamos todos los billetes necesarios
                if (necesito % billetera.obtenerDenominacion() >= 0 && cantidad >= billetera.obtenerDenominacion()) {
                    // obtener lo que podamos
                    int denominacion = billetera.obtenerDenominacion();
                    int billetesDisponibles = billetera.obtenerCantidadBilletes();
                    int billetesQuePodemosRecolectar = (int) (necesito / denominacion);

                    // obtenemos todos los billetes que podemos sacar del contenedor sin pasarlos
                    int billetesRecolctados = billetesDisponibles >= billetesQuePodemosRecolectar ? billetesQuePodemosRecolectar : billetesDisponibles;

                    // le decimos a la billetera que es posible que usemos estos billetes
                    billetera.agregarDeuda(billetesRecolctados);

                    // indicamos la cantidad de dinero que todav√≠a necesitamos
                    necesito = necesito - (billetesRecolctados * denominacion);
                }
            }

            // comprobamos si hemos logrado juntar billetes para dispensarEfectivo la cantidad indicada
            int totalRecolectado = 0;
            for (Billetera billetera : this.billeteras) {
                totalRecolectado += (billetera.obtenerDeuda() * billetera.obtenerDenominacion());
            }

            if (totalRecolectado == cantidad) {
                // dispensamos los billetes
                this.dispensarDinero();
                return true;
            } else {
                // le decimos a la billetera que como no se cumplio el objetivo ya no vamos a necesitar el dinero por ahora
                for (Billetera billetera : this.billeteras) {
                    billetera.cancelarDeuda();
                }
                return false;
            } // fin else
        } else { // la cantidad solicitada no es multiplo de 100
            return false;
        } // fin del else 
    } // fin del mÈtodo dispensarEfectivo

    // hace el descuento de billetes del cajero
    private void dispensarDinero() {
        for (Billetera billetera : this.billeteras) {
            billetera.extraerBilletes();
        }
    } // fin del mÈtodo dispensarDinero
} // fin de la clase DispensadorEfectivo
