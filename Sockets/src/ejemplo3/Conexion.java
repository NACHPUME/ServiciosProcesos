package ejemplo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Conexion implements Runnable {

	Socket client;
	
	public Conexion (Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
		try {
			
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			do {
				line = br.readLine();
				if(line != null) {
					String ip = client.getInetAddress().toString();
					System.out.println(ip + " " + line);
				}
			} while(line != null);
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
