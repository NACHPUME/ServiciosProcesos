package ejemplo4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		System.out.println("CLIENTE");
		try {
			Socket client = new Socket("192.168.0.73", 50000);

			// Código necesario para leer o recibir lo que nos envía el servidor
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// Código necesario para escribir o enviar al servidor
			PrintWriter pw = new PrintWriter(client.getOutputStream(), true);

			// Lanzamos el hilo de escritura
			Thread tEscritura = new Thread(new Escritor(pw));
			tEscritura.start();

			// Lanzamos el hilo de lectura
			Thread tLectura = new Thread(new Lector(br));
			tLectura.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
