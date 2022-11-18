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
} // fin de la clase Cuenta