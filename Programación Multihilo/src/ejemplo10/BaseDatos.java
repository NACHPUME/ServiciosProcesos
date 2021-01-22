package ejemplo10;

public class BaseDatos {
	
	/* Clase que simula una base de datos 
	con métodos para obtener y modificar el saldo */
	
	private static double saldo;
	
	public static void guarda(double saldo) {
		BaseDatos.saldo = saldo;
	}
	
	public static double obten() {
		return saldo;
	}
	
}
