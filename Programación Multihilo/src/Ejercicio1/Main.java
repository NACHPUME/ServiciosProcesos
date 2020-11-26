package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String continuar = "s";
		ArrayList<Thread> generadores = new ArrayList<Thread>();
		
		while(continuar.equals("s")) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Introduce el número 1: ");
			int n1 = sc.nextInt();
			System.out.print("Introduce el número 2: ");
			int n2 = sc.nextInt();
			sc.nextLine();
			System.out.print("Introduce el nombre del fichero: ");
			String fichero = sc.nextLine();
			
			GeneraNumeros gn = new GeneraNumeros(n1,n2,fichero);
			generadores.add(gn);
			
			System.out.println("¿Quieres introducir más datos? s/n");
			continuar = sc.nextLine();
		}
		
		// Lanzar hilos
		for(Thread t : generadores) {
			t.start();
		}
		

	}

}
