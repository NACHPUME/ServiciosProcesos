package ejemplo10;

public class Main {

	public static void main(String[] args) {
		
		// Creamos una �nica cuenta
		Cuenta c = new Cuenta();
		
		/* Creamos dos hilos, uno que se encargar� de 
		 * realizar los ingresos y otro que se encargar�
		 * de retirar el dinero
		 */
		HiloIngreso hi = new HiloIngreso(c);
		HiloRetirada hr = new HiloRetirada(c);
		
		Thread ti = new Thread(hi);
		Thread tr = new Thread(hr);
		
		// Lanzamos los hilos
		ti.start();
		tr.start();
		
		try {
			// Esperamos a que los dos hilos finalicen
			ti.join();
			tr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*  Una vez finalizan mostramos el saldo final. En este
		 *  caso no hemos implementado la sincronizaci�n entre hilos.
		 *  El resultado deber�a ser 0, sin embargo, debido a las condiciones de carrera
		 *  con cada ejecuci�n se obtendr� un resultado diferente.	
		*/
		System.out.println("Saldo final: " + BaseDatos.obten());
		
	}

}
