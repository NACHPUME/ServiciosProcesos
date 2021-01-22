package ejemplo8;

public class Sumador implements Runnable {

	private int cuenta = 0; // VARIABLE COMPARTIDA

	public Sumador(int cuentaInicial) {
		cuenta = cuentaInicial;
	}

	public void run() {
		// Sumamos 1000 a cuenta
		for(int i = 0; i < 1000; i++) {
			cuenta++;
		}
		// Mostramos el resultado por pantalla
		System.out.println("La cuenta total es " + cuenta);
		
	}
}
