#include<stdio.h>
#include<unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void main(){

	pid_t pid = fork();
	if(pid < 0){
		printf("Error creando el proceso\n");
	} else if (pid > 0){
		printf("P: Soy el padre\n");
		pid_t pid = getpid();
		pid_t ppid = getppid();
		printf("P: Mi id es %d y el de mi padre es %d \n", pid, ppid);
		wait(NULL);
	}else{
		pid_t pid2 = fork();
		if(pid2 < 0){
			printf("Error creando el proceso\n");
		} else if(pid2 > 0){
		 	pid_t pid = getpid();
			pid_t ppid = getppid();
			printf("H: Soy el proceso hijo \n");
			printf("H: Mi id es %d y el de mi padre es %d \n", pid, ppid);
			wait(NULL);
		} else {
			pid_t pid = getpid();
			pid_t ppid = getppid();
			printf("N: Soy el proceso nieto \n");
			printf("N: Mi id es %d y el de mi padre es %d \n", pid, ppid);
		}
	}
	
	
}
