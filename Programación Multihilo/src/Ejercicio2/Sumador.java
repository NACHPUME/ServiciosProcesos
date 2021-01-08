package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sumador extends Thread {

	private String nombreArchivo;
	private int total;
	
	public int getTotal() {
		return total;
	}


	public String getNombreArchivo() {
		return nombreArchivo;
	}


	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


	public void run() {
		try {
			
			// Abrir el fichero
			FileReader fr = new FileReader(".\\Ficheros\\" + nombreArchivo);
			BufferedReader br = new BufferedReader(fr);
			
			// Leemos las líneas
			String linea = br.readLine();
			while(linea != null) {
				
				// Separamos por espacios
				System.out.println("Lectura de línea del archivo " + nombreArchivo + ": " + linea);
				// En el array numeros tendremos los números guardados como string
				String[] numeros = linea.split(" ");
				
				// Recorremos el array y convertimos los string en números enteros
				for(int i = 0; i < numeros.length; i++) {
					int num = Integer.valueOf(numeros[i]);
					total += num;
				}
				
				// Suspendemos el hilo 5 segundos
				Thread.sleep(5000);
				linea = br.readLine();
			}
			System.out.println("La suma total es " + total);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
