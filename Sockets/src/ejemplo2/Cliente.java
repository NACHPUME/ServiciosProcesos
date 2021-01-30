package ejemplo2;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		System.out.println("CLIENTE");
		try {
			Socket client = new Socket("127.0.0.1", 50000);
			PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);
			String line;
			/* Hemos modificado el c�digo para que el cliente
			 * env�e m�ltiples l�neas
			 */
			do {
				System.out.println("Escribe algo: ");
				line = sc.nextLine();
				pw.println(line);
			} while(!line.equals("fin"));
			
			client.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
