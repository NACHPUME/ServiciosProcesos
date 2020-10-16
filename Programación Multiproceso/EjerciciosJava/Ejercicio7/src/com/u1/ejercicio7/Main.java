package com.u1.ejercicio7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		String rootPath = "C:\\Program Files (x86)"; 
		int opcion;
		do {
			System.out.println("LAUNCHER");
			System.out.println("1. Internet Explorer");
			System.out.println("2. Visual Studio");
			System.out.println("3. Chrome");
			System.out.print("Elige la aplicación que quieres lanzar: ");
			opcion = Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
			case 1:
			{
				ProcessBuilder pb = new ProcessBuilder();
				ArrayList<String> comandos = new ArrayList<String>();
				comandos.add(rootPath + "\\\\Internet Explorer\\\\iexplore.exe");
				System.out.print("Indica la URL:");
				String url = sc.nextLine();
				comandos.add(url);
				pb.command(comandos);
				try {
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			}
			case 2:
			{
				ProcessBuilder pb = new ProcessBuilder();
				ArrayList<String> comandos = new ArrayList<String>();
				comandos.add(rootPath + "\\Microsoft Visual Studio\\2019\\Community\\Common7\\IDE\\devenv.exe");
				System.out.print("¿Quieres que se muestre la pantalla de bienvenida? [y/n]:");
				char letra = sc.nextLine().charAt(0);
				if(letra == 'n' || letra == 'N') {
					comandos.add("/NoSplash");
				}
				pb.command(comandos);
				try {
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			case 3:
			{
				ProcessBuilder pb = new ProcessBuilder(rootPath + "\\Google\\Chrome\\Application\\chrome.exe");
				try {
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			default:
				break;
			}
		} while (opcion != 4);

	}

}
