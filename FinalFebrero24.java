public class FinalFebrero24 {
    final static int MAXF = 3, MAXC = 15, MAXA = 3, X = 200;
    public static void main (String[]args) {
        int[][] matriz = {
                {0, 0, 150, 200, 165, 0, 154, 352, 240, 256, 0, 900, 750, 0, 0},
                {0, 940, 105, 265, 845, 215, 0, 245, 65, 48, 0, 741, 125, 541, 0},
                {0, 851, 543, 625, 845, 914, 0, 754, 184, 0, 637, 917, 0, 0, 0}};

        int[] A = {1, 3, 0};

        analizarMes(matriz, A);
        mostrarMatriz(matriz);
    }

    public static void analizarMes(int[][] m, int[] A){
        int fila = 0, diasQueCumplen = 0;
        while(fila < MAXF){
            for (int i = 0; i < MAXA; i++) {
                if(fila + 1 == A[i]) {
                    diasQueCumplen = analizarDias(m[fila]);
                    System.out.println("la cantidad de dias que cumplen en el mes " + (fila + 1) + " es: " + diasQueCumplen);
                }
            }
            fila++;
        }
    }

    public static int analizarDias(int[] arr) {
        int inicio = 0, fin = -1, diasQueCumplen = 0;
        while(inicio < MAXC) {
            inicio = obtenerInicio(arr, fin + 1);
            if(inicio < MAXC) {
                fin = obtenerFin(arr, inicio);
                if(calcularPromedio(arr, inicio, fin, fin - inicio + 1) < X) {
                    eliminarDias(arr, inicio, fin);
                    fin = inicio;
                } else {
                    diasQueCumplen++;
                }
            }
        }
        return diasQueCumplen;
    }

    public static double calcularPromedio(int[] arr, int inicio, int fin, double cantDias) {
        double suma = 0;
        for(int i = inicio; i <= fin; i++) {
            suma += arr[i];
        }
        return suma / cantDias;
    }

    public static void eliminarDias(int[] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzquierda(arr, inicio);
        }
    }

    public static void corrimientoIzquierda(int[] arr, int inicio) {
        for(int i = inicio; i < MAXC - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int obtenerInicio(int [] arr, int pos) {
        while(pos < MAXC && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int obtenerFin(int [] arr, int pos) {
        while(pos < MAXC && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            System.out.println("Fila: " + (i + 1));
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }
}