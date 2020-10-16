package com.u1.ejercicio8;

public class Main {

	public static void main (String[] args) {
		
		if(args.length % 2 == 0 ) {
			for(int i = 0; i < args.length-1; i=i+2) {
				int num = Integer.parseInt(args[i]);
				String cadena = args[i+1];
				for(int j = 0; j < num; j++) {
					System.out.println(cadena);
				}
			}
		} else {
			System.out.println("Error, número de parámetros incorrecto");
		}
		
	}
}
