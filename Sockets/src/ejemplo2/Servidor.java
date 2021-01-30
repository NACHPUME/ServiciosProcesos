package ejemplo2;

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
			ServerSocket server = new ServerSocket(50000);
			System.out.println("Esperando conexi�n");
			Socket client = server.accept();
			System.out.println("Cliente conectado");
			
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			/* Hemos modificado el c�digo para que el cliente
			 * reciba m�ltiples l�neas
			 */
			String line;
			do {
				line = br.readLine();
				if(line != null)
					System.out.println("L�nea: " + line);
			} while(line != null);
			
			client.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
