package ejemplo11;

public class Cuenta {

	/* Al a�adir synchronized conseguimos que m�s de un hilo
	 * no pueda entrar a la vez en aquellos m�todos marcados 
	 * como synchronized. As� evitamos las condiciones de carrera.
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
