package ejercicio1;

import java.io.FileWriter;
import java.io.IOException;

public class GeneraNumeros extends Thread {
	
	private int min;
	private int max;
	private String fichero;
	
	public GeneraNumeros(int min, int max, String fichero) {
		this.min = min;
		this.max = max;
		this.fichero = fichero;
	}

	public void run() {
		try {
			FileWriter fw = new FileWriter(".\\" + fichero);
			
			for(int i = min; i <= max; i++) {
				fw.write(""+i+"\n");
			}
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
