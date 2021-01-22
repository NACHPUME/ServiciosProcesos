package ejemplo7;

public class Contador implements Runnable {
	
	private int contador = 0;
	private long totalEsperado = 0;
	public long getTotalEsperado() {
		return totalEsperado;
	}
	 @Override
	public void run() {
		 while(contador < 10) {
			 long espera = (long) (Math.random()*5000);
			 totalEsperado += espera;
			 try {
				System.out.println("Esperamos " + espera);
				Thread.sleep(espera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			 System.out.println("Incrementamos contador " + contador);
			 contador++;
		 }
	}
}
