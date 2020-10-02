#include <stdio.h>
#include <unistd.h>

void main (){
	int num;
    	printf("Introduce un número: ");
	scanf("%d", &num);
	
	pid_t pid = fork();
	
	if(pid < 0){
		printf("Error");
	} else {
		if(pid== 0){
			printf("Soy el proceso padre\n");
			int res = num + 5;
			printf("Resultado padre: %d", res);
		} else {
			printf("Soy el proceso hijo\n");
			int res = num - 5;
			printf("Resultado hijo: %d", res);
		}
	}
}
