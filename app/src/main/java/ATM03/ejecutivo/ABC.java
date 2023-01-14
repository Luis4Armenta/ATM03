package ATM03.ejecutivo;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;

public class ABC {
  ICuentasRepository cuentasRepository;

  public ABC() {
    this.cuentasRepository = HashMapBinFileCuentasRepository.obtenerInstancia("archivo.bin");
  }

  public void crearCuenta(Cuenta cuenta) {
    this.cuentasRepository.guardarNuevaCuenta(cuenta);
  }

  public void editarCuenta(Cuenta cuenta) {
    this.cuentasRepository.actualizarCuenta(cuenta);
  }

  public void eliminarCuenta(int numeroCuenta) {
    this.cuentasRepository.eleminarCuenta(numeroCuenta);
  }
}