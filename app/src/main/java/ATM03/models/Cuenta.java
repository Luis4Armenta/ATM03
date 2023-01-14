package ATM03.models;

import java.io.Serializable;

public class Cuenta implements Serializable
{
   private int numeroCuenta; // n?mero de cuenta
   private int nip; // NIP para autenticaci?n
   private double saldoDisponible; // fondos disponibles para retirar

   // el constructor de Cuenta inicializa los atributos
   public Cuenta( int elNumeroDeCuenta, int elNIP, 
      double elSaldoDisponible)
   {
      numeroCuenta = elNumeroDeCuenta;
      nip = elNIP;
      saldoDisponible = elSaldoDisponible;
   } // fin del constructor de Cuenta

   // determina si un NIP especificado por el usuario coincide con el NIP en la Cuenta
   public boolean validarNIP( int nipUsuario )
   {
      if ( nipUsuario == nip )
         return true;
      else
         return false;
   } // fin del m?todo validarNIP
   
   // devuelve el saldo disponible
   public double obtenerSaldoDisponible()
   {
      return saldoDisponible;
   } // fin de obtenerSaldoDisponible

   // abona un monto a la cuenta
   public void abonar( double monto )
   {
      this.saldoDisponible += monto; // lo suma al saldo total
   } // fin del m?todo abonar

   // carga un monto a la cuenta
   public void cargar( double monto )
   {
      saldoDisponible -= monto; // lo resta del saldo disponible
   } // fin del m?todo cargar

   // devuelve el n?mero de cuenta
   public int obtenerNumeroCuenta()
   {
      return numeroCuenta;  
   } // fin del m?todo obtenerNumeroCuenta
   
   public int ObtenerNIP()
   {
       return this.nip;
   }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.numeroCuenta;
        hash = 83 * hash + this.nip;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.saldoDisponible) ^ (Double.doubleToLongBits(this.saldoDisponible) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (this.numeroCuenta != other.numeroCuenta) {
            return false;
        }
        if (this.nip != other.nip) {
            return false;
        }
        return Double.doubleToLongBits(this.saldoDisponible) == Double.doubleToLongBits(other.saldoDisponible);
    }

    @Override
    public String toString() {
        return String.valueOf(numeroCuenta);
    }
   
   
} // fin de la clase Cuenta