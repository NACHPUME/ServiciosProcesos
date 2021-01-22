package ejemplo11;

public class Main {

	public static void main(String[] args) {
		
		Cuenta c = new Cuenta();
		
		HiloIngreso hi = new HiloIngreso(c);
		HiloRetirada hr = new HiloRetirada(c);
		
		Thread ti = new Thread(hi);
		Thread tr = new Thread(hr);
		
		ti.start();
		tr.start();
		
		try {
			ti.join();
			tr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Saldo final: " + BaseDatos.obten());
		
	}

}
