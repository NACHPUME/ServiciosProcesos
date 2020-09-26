#include<stdio.h>
#include<unistd.h>

void main(){

	int max = 100000;
	pid_t pid = fork();
	if(pid < 0){
		printf("Error creando el proceso\n");
	} else if (pid == 0){
		printf("H: Soy el proceso hijo\n");
		for(int i = max; i >= 0; i--){
			printf("H: %d\n", i);
		}
	} else {
		printf("P: Soy el proceso padre\n");
		for(int i = 0; i <= max; i++){
			printf("P: %d\n", i);
		}
	}
}
