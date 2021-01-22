package ejemplo10;

public class Cuenta {

	/* Clase encargada de ingresar y
	 *  retirar cantidades y almacenar el resultado
	 *  en la "base de datos" */
	public void ingresar(double cantidad) {
		System.out.println("Ingreso");
		double saldoActual = BaseDatos.obten();
		System.out.println("I Saldo Actual " + saldoActual);
		double nuevoSaldo = saldoActual + cantidad;
		System.out.println("I Nuevo Saldo " + nuevoSaldo);
		BaseDatos.guarda(nuevoSaldo);
		System.out.println("Ingreso Fin");
	}
	
	public void retirar (double cantidad) {
		System.out.println("Retirar");
		double saldoActual = BaseDatos.obten();
		System.out.println("R Saldo Actual " + saldoActual);
		double nuevoSaldo = saldoActual - cantidad;
		System.out.println("R Nuevo Saldo " + nuevoSaldo);
		BaseDatos.guarda(nuevoSaldo);
		System.out.println("Retirar Fin");
		
	}
}
