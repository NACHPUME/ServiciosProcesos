package ejemplo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try {
			System.out.println("SERVIDOR");
			ServerSocket server = new ServerSocket(50000);
			System.out.println("Esperando conexión");
			Socket client = server.accept();
			System.out.println("Cliente conectado");
			
			// Código necesario para leer o recibir lo que nos envía el cliente
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// Código necesario para escribir o enviar al cliente
			PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
			
			// Lanzamos el hilo de escritura
			Thread tEscritura = new Thread(new Escritor(pw));
			tEscritura.start();
			
			// Lanzamos el hilo de lectura
			Thread tLectura = new Thread(new Lector(br));
			tLectura.start();

			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
