package ejemplo11;

public class HiloRetirada implements Runnable {

	private Cuenta cuenta;
	
	public HiloRetirada(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			cuenta.retirar(100);
		}
	}

}
