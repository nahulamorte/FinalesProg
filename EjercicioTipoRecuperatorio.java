public class EjercicioTipoRecuperatorio {
    //Declaracion de constantes
    final static int MAX_COL = 20;
    final static int MAX_FIL = 3;
    final static int SEP = 0;
    final static int X = 3;

    public static void main(String[] args) {
        int[][] matriz = {
            {0, -8, 67, 0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 25, 25, 0, -5, 3, 0, 25, 44, 44, 0, -4, 1, 0, 0, 0, 0, 0, 0},
            {0, 44, 44, 44, 0, -7, 15, 0, -4, 9, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        mostrarMatriz(matriz);
        implementarAlgoritmo(matriz);
        mostrarMatriz(matriz);
    }

    public static void implementarAlgoritmo(int [][] matriz){
        int filaConMasDescompresiones = 0, cantTotalPixelesDescomprimidos = 0, cantPixelesDescomprimidos = 0, mayorCantPixelesDescomprimidos = -1;
        for (int fila = 0; fila < MAX_FIL; fila++){
            cantPixelesDescomprimidos = analizarFila(matriz[fila]);
            cantTotalPixelesDescomprimidos += cantPixelesDescomprimidos;
            
            if (cantPixelesDescomprimidos > mayorCantPixelesDescomprimidos) {
                mayorCantPixelesDescomprimidos = cantPixelesDescomprimidos;
                filaConMasDescompresiones = fila;
            }
        }
        System.out.println("La fila con mas compresiones es la fila: " + filaConMasDescompresiones + 
            " y el total de pixeles descomprimidos es de: " + cantTotalPixelesDescomprimidos);
    }

    public static int analizarFila(int [] arr){
        int ini = 0, fin = -1, pixelesDescomprimidos = 0, cantOcurrencias = 0;
        while (ini<MAX_COL) {
            ini = buscarInicio(arr, fin+1);
            if (ini<MAX_COL) {
                fin = buscarFin(arr, ini);
                if (arr[ini] < SEP) {
                    cantOcurrencias = arr[ini] * (-1);//Hace que el valor sea positivo.
                    descomprimirPixeles(arr, ini, cantOcurrencias);
                }
                pixelesDescomprimidos += cantOcurrencias;
            }
        }
        return pixelesDescomprimidos;
    }

    public static int buscarInicio(int [] arr, int pos) {
        while(pos < MAX_COL && arr[pos] == SEP) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int [] arr, int pos) {
        while(pos < MAX_COL && arr[pos] != SEP) {
            pos++;
        }
        return pos-1;
    }

    public static void descomprimirPixeles(int [] arr, int ini, int cantOcurrencias){
        int cantDescompresiones = 0;
        while (cantDescompresiones != cantOcurrencias) {
            for (int i = ini; i< MAX_COL - 1; i++){
                arr[i] = arr[i+1];
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < MAX_FIL; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }

    
}