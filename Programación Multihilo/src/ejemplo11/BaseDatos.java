package ejemplo11;

public class BaseDatos {
	
	private static double saldo;
	
	public static void guarda(double saldo) {
		BaseDatos.saldo = saldo;
	}
	
	public static double obten() {
		return saldo;
	}
	
}
