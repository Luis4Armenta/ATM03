// Transaccion.java
// La superclase abstracta Transaccion representa una transacción con el ATM
package ATM03.cajero.models.transacciones;

import ATM03.database.ICuentasRepository;

public abstract class Transaccion {

    public ICuentasRepository baseDatosBanco; // base de datos de información de cuentas
    public int numeroCuenta; // base de datos de información de cuentas
    public int monto; // En todas las transacciones hay montos 

    // el constructor de Transaccion es invocado por las subclases mediante super()
    public Transaccion(ICuentasRepository baseDatosBancoATM, int numeroCuenta, int monto) {
        this.baseDatosBanco = baseDatosBancoATM;
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
    } // fin del constructor de Transaccion

    // devuelve el número de cuenta 
    public int obtenerNumeroCuenta() {
        return numeroCuenta;
    } // fin del método obtenerNumeroCuenta

    // devuelve una referencia a la base de datos del banco
    public ICuentasRepository obtenerBaseDatosBanco() {
        return this.baseDatosBanco;
    } // fin del método obtenerBaseDatosBanco

    // realiza la transacción (cada subclase sobrescribe este método)
    public abstract boolean ejecutar();
}
