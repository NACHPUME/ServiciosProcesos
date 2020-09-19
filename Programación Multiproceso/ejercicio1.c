#include<stdio.h>
#include<stdlib.h>

void main(){
	// Mensaje de bienvenida
	printf("Bienvenidos\n");
	// Ejecutamos ps y guardamos el resultado en ejercicio1.out
	system("ps > ejercicio1.out ");
	// Abrimos ejercicio1.out con gedit
	system("gedit ejercicio1.out ");
	// Nos despedimos
	printf("Hasta siempre!\n");
}
