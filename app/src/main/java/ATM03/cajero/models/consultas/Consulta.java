// Consulta.java
// La superclase abstracta Consulta representa una consulta con el ATM

package ATM03.cajero.models.consultas;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;

public abstract class Consulta {
    public ICuentasRepository baseDatosBanco; // pantalla del ATM
    public int numeroCuenta; // indica la cuenta implicada

    // el constructor de Consulta es invocado por las subclases mediante super()
    public Consulta(ICuentasRepository baseDatosBancoATM, int numeroCuentaUsuario) {
        this.baseDatosBanco = baseDatosBancoATM;
        this.numeroCuenta = numeroCuentaUsuario;
    } // fin del constructor de Consulta

    // realiza la consulta (cada subclase sobrescribe este método)
    public abstract String consultar();
} // fin de la clase Consulta

