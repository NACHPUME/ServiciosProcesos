package com.u1.ejercicio9y10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Generador {

	public static void main(String[] args) {
		
		// Comprobamos que el n�mero de par�metros es correcto
		if(args.length==3) {
			
			// Realizamos la conversi�n de par�metros
			String fileName = ".\\Files\\" + args[0];
			int num1 = Integer.parseInt(args[1]);
			int num2 = Integer.parseInt(args[2]);
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
				for(int i = num1; i <= num2; i++) {
					bw.write(""+i);
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("N�mero de par�metros incorrecto");
		}
		

	}

}
