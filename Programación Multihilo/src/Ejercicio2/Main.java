package Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/* El siguiente programa pide al usuario que indique nombres de archivo. Cada vez
	 * que indica un nombre se lanza un hilo. El hilo se encarga de abrir el archivo
	 * indicado, lee sus l�neas, extrae los n�meros que contiene y los suma.El
	 * programa principal espera que los hilos finalicen, una vez han finalizado todos
	 * obtiene el resultado calculado por cada hilo y los suma.
	 * 
	 * Los ficheros contienen n�meros separados por espacios y pueden tener m�ltiples l�neas.
	 * En el directorio Ficheros hay dos ficheros de ejemplo: f1 y f2.
	 * 
	 * Este ejercicio tiene las siguientes caracter�sticas diferenciadoras:
	 * - El hilo se lanza en cuanto se indica el nombre del fichero en vez de esperarse al
	 * final para lanzarlos todos.
	 * - Para simular que los hilos realizan un trabajo m�s costoso (que requiere m�s tiempo) y
	 * para poder ver mejor c�mo funcionan los hilos, cada vez que el hilo lee una l�nea
	 * se suspende 5 segundos mediante el m�todo sleep.
	 * - El proceso principal espera a que los hilos hayan finalizado llamando al m�todo join
	 * - El proceso principal obtiene el resultado calculado mediante el m�todo getTotal.
	 */
	public static void main(String[] args) {
		
		int total = 0;
		
		// Lista de hilos
		ArrayList<Thread> sumadores = new ArrayList<Thread>();
		
		Scanner sc = new Scanner(System.in);
		String opcion;
		do {
			System.out.println("Introduce el nombre del fichero: ");
			String nombreFichero = sc.nextLine();
			
			// Una vez indicado el nombre del archivo lanzamos el hilo
			Sumador s = new Sumador();
			s.setNombreArchivo(nombreFichero);
			s.start();
			
			// Guardamos el sumador en la lista
			sumadores.add(s);
			
			// Preguntamos si se quiere introducir otro fichero
			System.out.println("�Quiere introducir otro fichero? (s/n)");
			opcion = sc.nextLine();
		}while(opcion.equals("s"));

		// Este c�digo se ejecuta cuando ya no se quieren introducir m�s ficheros
		// Recorremos los hilos y esperamos uno a uno a que terminen
		int contador = 1;
		for(Thread t : sumadores) {
			try {
				System.out.println("Esperamos a que termine el hilo " + contador);
				t.join(); // El programa principal se detiene aqu� y no contin�a hasta que el hilo t haya finalizado
				System.out.println("El hilo " + contador + " ha finalizado");
				Sumador s = (Sumador) t;
				// Obtenemos el total calculado por el hilo y lo sumamos al total.
				total += s.getTotal();
				contador++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("LA SUMA TOTAL ES : " + total);
		
		sc.close();
	}

}
