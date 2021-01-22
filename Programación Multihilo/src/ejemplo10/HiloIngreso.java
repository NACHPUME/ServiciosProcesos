package ejemplo10;

public class HiloIngreso implements Runnable {

	private Cuenta cuenta;
	
	public HiloIngreso(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			// Este hilo ingresa 100 veces 100 €
			cuenta.ingresar(100);
		}
	}

}
