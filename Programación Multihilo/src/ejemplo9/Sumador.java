package ejemplo9;

public class Sumador extends Thread {

	private Cuenta cuenta; // VARIABLE COMPARTIDA
	
	public Sumador (Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public void run () {
		
		for(int i = 0; i < 1000; i++) {
			int saldo = cuenta.getNumero();
			saldo++;
			cuenta.setNumero(saldo);
		}
		System.out.println("El saldo es: " + cuenta.getNumero());
		
	}
}
