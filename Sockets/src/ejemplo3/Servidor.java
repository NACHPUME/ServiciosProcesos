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
				System.out.println("Esperando conexión");
				Socket client = server.accept();
				
				/* Por cada cliente que se conecta lanzamos un hilo,
				 * así conseguimos que el servidor siempre permanezca
				 * a la espera de nuevos clientes.
				 */
			
				System.out.println("Cliente conectado");
				// Al recibir una conexión, creamos el hilo
				Conexion c = new Conexion(client);
				Thread t = new Thread(c);
				t.start();
				// El hilo gestionará el envío de datos
				// Mientras que el hilo principal continuará, volviendo a esperar una nueva conexión
				
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
