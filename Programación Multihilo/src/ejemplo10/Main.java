package ejemplo10;

public class Main {

	public static void main(String[] args) {
		
		// Creamos una única cuenta
		Cuenta c = new Cuenta();
		
		/* Creamos dos hilos, uno que se encargará de 
		 * realizar los ingresos y otro que se encargará
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
		 *  caso no hemos implementado la sincronización entre hilos.
		 *  El resultado debería ser 0, sin embargo, debido a las condiciones de carrera
		 *  con cada ejecución se obtendrá un resultado diferente.	
		*/
		System.out.println("Saldo final: " + BaseDatos.obten());
		
	}

}
