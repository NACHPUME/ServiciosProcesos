 package Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el número de hilos");
		int numHilos = sc.nextInt();
		
		// ArrayList que utilizaremos para poder guardar y acceder a los diferentes hilos
		ArrayList<Hilo> hilos = new ArrayList<Hilo>();
		
		// Lanzamos tantos hilos como los indicados en numHilos
		for(int i = 0; i < numHilos; i++) {
			Hilo h = new Hilo();
			h.setName("Hilo " + (i+1));
			h.start();
			hilos.add(h);
		}
		
		// Una vez lanzados los hilos mostramos su estado cada 5 segundos
		int hilosTerminados = 0;
		// Si el número de hilos terminados es inferior al número total de hilos seguiremos con la ejecución del programa, mostrando el estado de los hilos
		while(hilosTerminados < numHilos) {
			hilosTerminados = 0; // Reiniciamos el contador
			// Recorremos los hilos y mostramos por pantalla su estado
			System.out.println("ESTADOS------");
			for(Thread t : hilos) {
				System.out.println(t.getName() + ": " + t.getState());
				if(!t.isAlive()) {
					// Comprobamos si el hilo esta vivo, si no lo está incrementamos el contador
					hilosTerminados++;
				}
			}
			System.out.println("------------");
			try {
				Thread.sleep(5000); // Esperamos 5 segundos antes de volver a mostrar los estados
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
