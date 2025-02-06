#include <stdio.h>
#include <stdint.h>

int main() {
  int N, M;
  // Adquirimos el dato del arreglo
  if(scanf("%d", &N) == -1) return -1;
  int arr[N + 1];

  // Inicializamos el arreglo con ceros
  for(int i = 0; i <= N; i++) arr[i] = 0;

  // Adquirimos el dato de los intervalos
  if(scanf("%d", &M) == -1) return -1;
  while (M--) {
    int I, F;
    if(scanf("%d %d", &I, &F) == -1) return -1;
    arr[I]++;
    arr[F]--;  
  }

  // Imprimimos el primer elemento del arreglo
  printf("%d ", arr[0]);
  // Recorremos el arreglo sumando y restando 
  // el valor anterior de cada elemento
  for(int i = 1; i < N; i++){
    arr[i] += arr[i-1];
    printf("%d ", arr[i]);
  }

  return 0;
}
