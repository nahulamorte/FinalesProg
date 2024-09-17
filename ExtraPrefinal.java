public class ExtraPrefinal {
    final static int N = 5, M = 18 + 2, K = 2, P = 2;
    final static char SEP = ' ', L = 'F';
    public static void main(String[] args) {
        char[][] matriz = {
            {' ', '1', '2', 'G', 'H',' ', '2', 'A', '3',' ', '3', 'R', 'B', 'J',' ', '6', '5', 'K', ' ',' '},
            {' ', '2', '1', '4', '5', ' ',  'R', 'P', ' ',  'D', '3', ' ', '7', 'M', 'N', 'W', ' ',' ', ' ', ' '},
            {' ', '4', 'G', '8',' ', '3', '5', '7', '1',' ', '2', 'X', ' ', 'D', '4', '1', ' ',' ',' ',' '},
            {' ',' ', '5', 'T', 'T', 'M',' ', 'A', 'P', '1', '1',' ', '2', '1', '3',' ', '1', '3', ' ',' '},
            {' ', '6', '6', '4',' ', '5', '4',' ', 'A', '2', '1', '2',' ', 'G', '4', '2', '1', '8', ' ', ' '}
        };

        mostrarMatriz(matriz);
        analizarSeniales(matriz);
    }

    public static int buscarInicio(char[]arr, int pos){
        while (pos<M && arr[pos] == SEP) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[]arr, int pos){
        while (pos<M && arr[pos] != SEP) {
            pos++;
        }
        return pos-1;
    }

    public static void analizarSeniales(char[][] matriz){
        int cantLecturas = 0;
        for (int fila = 0; fila < N; fila++){
            if (recorrerFilas(matriz[fila])) {
                System.out.println("La fila cumple" + fila);
                cantLecturas++;
                // System.out.println("Entre en el if de recorrerfilas");
                if (cantLecturas == P) {
                    // System.out.println("Entre en el if de cantLecturas == P");
                    System.out.println("En las filas: " + (fila-1) + (" ") +  fila + " hay una señal de posible origen extraterrestre");
                    cantLecturas = 0;
                }
            }
        }
    }


    public static boolean recorrerFilas(char [] arr){
        int ini = 0, fin = -1, cantSenialesExtr = 0;
        boolean filaCumple = false;
        while (ini < M && cantSenialesExtr < K) {
            ini = buscarInicio(arr, fin+1);
            if (ini<M) {
                fin = buscarFin(arr, ini);
                cantSenialesExtr += determinarCantSenialesExtr(arr,ini,fin);
                if (cantSenialesExtr >= K) {
                    filaCumple = true;
                }
            }
        }
        return filaCumple;
    }

    public static int determinarCantSenialesExtr(char [] arr, int ini, int fin){
        int senialesExt = 0;
        for (int i = ini; i<= fin; i++){
            if (arr[i] > L) {
                senialesExt++;
            }
        }
        return senialesExt;
    }

    public static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }

}
