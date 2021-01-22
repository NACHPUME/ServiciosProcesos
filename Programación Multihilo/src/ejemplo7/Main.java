package ejemplo7;

public class Main {
	
	public static void main(String[] args) {
		Contador c = new Contador();
		Thread t = new Thread(c);
		t.start();
		System.out.println("Se ha lanzado el hilo");
		System.out.println("Hilo principal hace cosas");
		try {
			while(true) {
				Thread.sleep(1000);
				System.out.println(t.getState());
				System.out.println("HHH" + Thread.currentThread().getState());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
