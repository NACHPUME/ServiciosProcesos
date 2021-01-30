package ejemplo4;

import java.io.PrintWriter;
import java.util.Scanner;

public class Escritor implements Runnable {

	PrintWriter writer;
	public Escritor (PrintWriter writer) {
		this.writer = writer;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String line;
		
		do {
			System.out.println("Escribe algo: ");
			line = sc.nextLine();
			writer.println(line);
		} while(!line.equals("fin"));
	}

}
