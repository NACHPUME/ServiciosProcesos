#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>


void main (){
	int fd[2];
	pipe(fd); // Creamos la tubería
	
	pid_t pid = fork(); // Creamos el proceso
	
	if(pid < 0){
		// Error
		printf("Se ha producido un error");
	} else if (pid > 0) {
		// Proceso padre
		close(fd[1]);
		char cadena [80];
		read(fd[0], cadena, sizeof(cadena));
		printf("Soy el padre, mensaje recibido del hijo: %s\n", cadena);
	} else {
		// Proceso hijo
		char cadena [] = "Hola Padre \0";
		close(fd[0]);
		printf("Soy el hijo y envío el mensaje al padre\n");
		// Escribimos la cadena en la tubería
		write(fd[1], cadena, sizeof(cadena));
		// Esperamos al hijo
		wait(NULL);
	}

}
