package ejemplo9;

public class Main {

	public static void main(String[] args) {
		
		/* Este ejemplo es similar al ejemplo 8, pero en
		 * este caso se crean dos sumadores (s1 y s2).
		 * Ambos sumadores reciben la misma instancia de la
		 * clase Cuenta (c), por lo que la variable es
		 * compartida entre ambas.
		 * 
		 * Los hilos se encargan de incrementar el valor
		 * numero de la instancia Cuenta.
		 * 
		 * De nuevo, en este caso el resultado no
		 * es el esperado.
		 * 
		 */
		Cuenta c = new Cuenta();
		c.setNumero(500);
		
		Sumador s1 = new Sumador(c);
		Sumador s2 = new Sumador(c);
		s1.start();
		s2.start();
	}

}
