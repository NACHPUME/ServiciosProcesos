package ejemplo3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try {
			System.out.println("SERVIDOR");
			ServerSocket server = new ServerSocket(50000);
			
			while(true) {
				System.out.println("Esperando conexi�n");
				Socket client = server.accept();
				
				/* Por cada cliente que se conecta lanzamos un hilo,
				 * as� conseguimos que el servidor siempre permanezca
				 * a la espera de nuevos clientes.
				 */
			
				System.out.println("Cliente conectado");
				// Al recibir una conexi�n, creamos el hilo
				Conexion c = new Conexion(client);
				Thread t = new Thread(c);
				t.start();
				// El hilo gestionar� el env�o de datos
				// Mientras que el hilo principal continuar�, volviendo a esperar una nueva conexi�n
				
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
