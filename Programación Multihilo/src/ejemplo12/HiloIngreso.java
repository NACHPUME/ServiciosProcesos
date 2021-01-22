package ejemplo12;

public class HiloIngreso implements Runnable {

	private Cuenta cuenta;
	
	public HiloIngreso(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			/* Otra opci�n es utilizar synchronized en un
			 * bloque de c�digo. En este caso bloqueamos el
			 * objeto cuenta. M�s de un hilo no puede entrar
			 * en un bloque que bloque al mismo objeto. As�
			 * pues, si un hilo est� dentro del bloque, bloquar�
			 * el objeto cuenta, y el otro hilo no podr� entrar
			 * a su bloque hasta que no se libere el objeto cuenta. 
			 */
			synchronized(cuenta) {  
				cuenta.ingresar(100);
			}
		}
	}

}
