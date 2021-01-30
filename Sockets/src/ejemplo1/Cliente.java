package ejemplo1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		System.out.println("CLIENTE");
		try {
			// Creamos el socket cliente, indicando la ip y el puerto del servidor
			Socket client = new Socket("127.0.0.1", 50000);
			
			// PrintWriter nos permitirá enviar datos al stream de salida
			PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);

			// Solicitamos el texto a enviar
			System.out.println("Escribe lo que quieras enviar: ");
			String line = sc.nextLine();
			
			// Enviamos
			pw.println(line);
			
			// Cerramos el cliente
			client.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
