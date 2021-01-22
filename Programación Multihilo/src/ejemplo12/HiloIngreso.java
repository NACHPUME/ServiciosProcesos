package ejemplo12;

public class HiloIngreso implements Runnable {

	private Cuenta cuenta;
	
	public HiloIngreso(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			/* Otra opción es utilizar synchronized en un
			 * bloque de código. En este caso bloqueamos el
			 * objeto cuenta. Más de un hilo no puede entrar
			 * en un bloque que bloque al mismo objeto. Así
			 * pues, si un hilo está dentro del bloque, bloquará
			 * el objeto cuenta, y el otro hilo no podrá entrar
			 * a su bloque hasta que no se libere el objeto cuenta. 
			 */
			synchronized(cuenta) {  
				cuenta.ingresar(100);
			}
		}
	}

}
