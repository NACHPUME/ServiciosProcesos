package ejemplo8;

public class Main {

	public static void main(String[] args) {
		
		/* En este ejemplo el hilo se crea implementando
		 * la interfaz Runnable en vez de heredar de Thread.
		 * 
		 * En el código se indica las diferencias que hay
		 * al utilizar Runnable.
		 * 
		 * En este ejemplo se trata la problemática de los
		 * recursos compartidos cuando son accedidos desde
		 * diferentes hilos, en este caso el recurso compartido
		 * es una variable. La variable cuenta de la clase sumador.
		 * 
		 * Los hilos reciben un número en su constructor y en su método
		 * run hay un bucle for que itera 1000 veces sumando 1 a la variable
		 * cuenta.
		 */
		
		// Creamos una instancia de sumador s1
		Sumador s1 = new Sumador(500);
		/* Al implementar la interfaz Runnable, s1 no tiene
		* un método start, en vez de eso hay que crear
		* una instancia Thread y pasar en el constructor
		 El runnable, es decir s1.*/
		Thread t1 = new Thread(s1);
		
		// Lanzamos un segundo hilo con el sumador s1
		Thread t2 = new Thread(s1);
		
		/* Lanzamos los hilos
		* Podríamos esperar que el resultado mostrado fuese
		* La cuenta total es 1500
		* La cuenta total es 1500
		* Pero cada vez que lo ejecutamos se muestran valores diferentes
		* Esto es así porque se utiliza la misma instancia s1 en ambos hilos
		* y, por tanto, el atributo cuenta es compartido por los dos hilos.
		* (Los dos hilos están accediendo a la misma variable en memoria).
		* 
		*/
		t1.start();
		t2.start();
		
		

	}

}
