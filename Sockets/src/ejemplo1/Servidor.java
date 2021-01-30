package ejemplo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try {
			System.out.println("SERVIDOR");
			// Creamos el servidor indicando el puerto al que pertenecer� a la escucha
			ServerSocket server = new ServerSocket(50000);
			System.out.println("Esperando conexi�n");
			Socket client = server.accept(); // El programa se detiene aqu� hasta que se conecta el cliente
			System.out.println("Cliente conectado");
			
			// Una vez llegamos aqu�, significa que el cliente se ha conectado al servidor
			
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// Leemos una l�nea del flujo de entrada
			String line = br.readLine();
			System.out.println("L�nea: " + line);
			
			client.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
