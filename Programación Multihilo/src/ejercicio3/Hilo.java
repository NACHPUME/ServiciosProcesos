package ejercicio3;

import java.util.Random;

public class Hilo extends Thread {

	public void run() {
		Thread t = Thread.currentThread();
		for(int i = 0; i < 10; i++) {
			System.out.println(t.getName() + ": " + i);
			try {
				Random r = new Random();
				int tiempoEspera = (r.nextInt(5) + 1)*1000;
				Thread.sleep(tiempoEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
