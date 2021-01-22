package ejemplo11;

public class Cuenta {

	/* Al añadir synchronized conseguimos que más de un hilo
	 * no pueda entrar a la vez en aquellos métodos marcados 
	 * como synchronized. Así evitamos las condiciones de carrera.
	 */
	
	public synchronized void ingresar(double cantidad) {
		System.out.println("Ingreso");
		double saldoActual = BaseDatos.obten();
		System.out.println("I Saldo Actual " + saldoActual);
		double nuevoSaldo = saldoActual + cantidad;
		System.out.println("I Nuevo Saldo " + nuevoSaldo);
		BaseDatos.guarda(nuevoSaldo);
		System.out.println("Ingreso Fin");
	}
	
	public synchronized void retirar (double cantidad) {
		System.out.println("Retirar");
		double saldoActual = BaseDatos.obten();
		System.out.println("R Saldo Actual " + saldoActual);
		double nuevoSaldo = saldoActual - cantidad;
		System.out.println("R Nuevo Saldo " + nuevoSaldo);
		BaseDatos.guarda(nuevoSaldo);
		System.out.println("Retirar Fin");
		
	}
}
