public class finalMarzo {
    final static int MAXF = 24, MAXC = 10, SEP = 0, H = 3, E = 50;

    public static void main(String[] args) {
        int[][] matriz = {
            {0,0,0,0,0,8,0,0,9,0},
            {0,52,63,12,4,23,2,0,0,0},
            {0,0,0,0,89,87,78,0,10,0},
            {0,56,25,12,0,0,29,37,56,0},
            {0,64,12,14,0,0,0,25,62,0},
            {0,0,0,0,36,95,0,41,0,0},
            {0,84,78,80,47,90,0,0,0,0},
            {0,0,0,0,25,2,52,63,85,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,42,33,25,0,0,65,65,0,0},
            {0,0,0,0,26,34,42,85,94,0},
            {0,91,11,2,0,53,48,27,0,0},
            {0,68,25,11,0,0,85,20,21,0},
            {0,31,42,27,52,0,0,0,0,0},
            {0,0,0,0,6,12,24,31,0,0},
            {0,0,0,0,0,85,4,2,0,0},
            {0,0,88,85,0,26,25,12,0,0},
            {0,0,15,52,52,0,6,5,3,0},
            {0,0,0,0,0,84,32,12,28,0},
            {0,0,0,0,8,56,32,12,4,0},
            {0,0,0,0,0,8,56,32,12,4},
            {0,0,0,0,0,0,0,0,0,0},
            {0,12,22,44,0,0,0,12,0,0},
            {0,88,22,3,0,4,3,23,1,0},
            {0,0,0,0,12,11,9,4,5,0}
        };
        int [] horas = {4,5,9,11,15,17,21,22,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int hora = 0, S = 8, P=20;
        for (int filas = 0; filas<MAXF; filas++){
            if(horas[hora]>=S && horas[hora]<= P){
                if (filas == horas[hora]){
                    procesar(matriz[filas]);
                }
            } else {
                hora++;
            }
        }

        mostrarMatriz(matriz);
    }

    public static void procesar (int [] arr){
        int ini = 0, fin = -1, nubosidadEliminada = 0;
        while (ini < MAXC) {
            ini = buscarInicio(arr, fin+1);
            if (ini < MAXC){
                fin = buscarFin(arr, ini);
                int tam = fin - ini + 1;
                if (tam >= H){
                    if (descensoNubosidad(arr, ini, fin)){
                        while (nubosidadEliminada < E) {
                            nubosidadEliminada += arr[ini];
                            eliminarNubosidad(arr, ini);
                        }
                    }
                }
            }
        }
    }

    public static int buscarInicio(int [] arr, int pos){
        while (pos<MAXC && arr[pos] == SEP) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int [] arr, int pos){
        while (pos<MAXC && arr[pos] != SEP) {
            pos++;
        }
        return pos-1;
    }

    public static boolean descensoNubosidad (int [] arr, int pos, int fin){
        boolean ordenDescendente = true;
        while (pos < fin && ordenDescendente) {
            if (arr[pos] < arr[pos+1]){
                ordenDescendente = false;
            }
        }
        return ordenDescendente;
    }

    public static void eliminarNubosidad (int [] arr, int pos){
        for (int i = pos; i<MAXC-1; i++){
            arr[i] = arr[i+1];
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
