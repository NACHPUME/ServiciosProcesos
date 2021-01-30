package ejemplo4;

import java.io.BufferedReader;
import java.io.IOException;

public class Lector implements Runnable {

	BufferedReader reader;
	public Lector (BufferedReader reader) {
		this.reader = reader;
	}
	@Override
	public void run() {
		try {
			String line;
			do {
				line = reader.readLine();
				if(line != null)
					System.out.println("Línea: " + line);
			} while(line != null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
