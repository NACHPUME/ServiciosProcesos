package com.u1.ejercicio9y10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el primer número: ");
		int num1 = sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("Introduce el nombre del archivo a crear: ");
		String fichero = sc.nextLine();
		
		// Procedemos a lanzar el proceso Generador
		ProcessBuilder pb = new ProcessBuilder();
		ArrayList<String> comandos = new ArrayList<String>();
		// Indicamos que queremos ejecutar el proceso java (encargado de ejecutar programas de Java)
		comandos.add("java");

		// En los parámetros (mediante -classpath) indicamos dónde se encuentra el programa que queremos ejecutar
		comandos.add("-classpath");
		// Se encuentra en la carpeta bin
		comandos.add(".\\bin");
		// Indicamos el nombre calificado del programa (incluye el nombre del paquete)
		comandos.add("com.u1.ejercicio9y10.Generador");
		
		// Indicamos los parámetros que pasaremos al programa Generador
		comandos.add(fichero);
		comandos.add(Integer.toString(num1));
		comandos.add(Integer.toString(num2));
		pb.command(comandos);
		
		System.out.println("Ejecutando el proceso Generador");
		try {
			// Redireccionamos la salida de error del proceso Generador para que escriba los posibles errores en un fichero
			pb.redirectError(new File(".\\Files\\error.log"));
			
			// Lanzamos el proceso
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
