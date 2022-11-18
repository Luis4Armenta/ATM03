package ATM03.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;

import ATM03.models.Cuenta;


public class HashMapBinFileCuentasRepository implements ICuentasRepository {
  private File archivo;
  private static HashMapBinFileCuentasRepository instancia = null;
  private HashMap<Integer, Cuenta> database;

  private HashMapBinFileCuentasRepository(String filePath) {
    this.archivo = new File(filePath);
    this.cargarBaseDatos();
  }

  public static HashMapBinFileCuentasRepository obtenerInstancia(String filePath) {
    if (HashMapBinFileCuentasRepository.instancia == null) {
      HashMapBinFileCuentasRepository.instancia = new HashMapBinFileCuentasRepository(filePath);
    }
    return HashMapBinFileCuentasRepository.instancia;
  }

  @Override
  public Cuenta[] obtenerCUenta(int numeroCuenta) {
    Cuenta cuenta = this.database.get(numeroCuenta);

    if (cuenta != null) {
      return (Cuenta[]) Arrays.asList(cuenta).toArray();
    } else {
      Cuenta[] cuentaNoEncontrada = {};
      return cuentaNoEncontrada;
    }
  }

  @Override
  public boolean guardarNuevaCuenta(Cuenta cuenta) {
    this.database.put(cuenta.obtenerNumeroCuenta(), cuenta);
    
    if (this.database.containsKey(cuenta.obtenerNumeroCuenta())) {
      actualizarBaseDatos();

      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean actualizarCuenta(Cuenta cuenta) {
    if (this.database.containsKey(cuenta.obtenerNumeroCuenta())) {
      this.database.put(cuenta.obtenerNumeroCuenta(), cuenta);

      if(this.database.get(cuenta.obtenerNumeroCuenta()).equals(cuenta)) {
        actualizarBaseDatos();

        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  @Override
  public boolean eleminarCuenta(int numeroCuenta) {
    if (this.database.containsKey(numeroCuenta)) {
      this.database.remove(numeroCuenta);
      
      if (!this.database.containsKey(numeroCuenta)) {
        actualizarBaseDatos();
      
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private void cargarBaseDatos() {
    try {
      FileInputStream archivo = new FileInputStream(this.archivo);
      ObjectInputStream lectura = new ObjectInputStream(archivo);

      // try {
        Object obj = lectura.readObject();

        this.database = (HashMap<Integer, Cuenta>) obj;


      lectura.close();
    } catch (Exception e) {
        this.database = new HashMap<>();
    }
  }

  private void actualizarBaseDatos() {
    try {
      FileOutputStream file = new FileOutputStream(this.archivo);
      ObjectOutputStream escribir = new ObjectOutputStream(file);

      escribir.writeObject(this.database);

      escribir.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}