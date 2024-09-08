public class Recuperatorio2024 {
    final static int N = 3;
    final static int M = 20;
    final static int R = 2;
    final static int MAXB = 3;

    public static void main(String[] args) {
        char[][] matrizV = {
                {'x', 't', 'a', 'C', 'M', 'O', 't', 'a', 'a', 't', 'O', 'C', 't', 't', 'a', 'O', 'M', 'C', 't', 'x'},
                {'x', 'r', 'r', 'r', 'C', 'C', 'O', 'O', 'r', 'r', 'C', 'r', 'G', 'G', 'G', 'r', 'r', 'x', 'x', 'x'},
                {'x', 'm', 'G', 'm', 'h', 'h', 'L', 'G', 'G', 'O', 'h', 'h', 'm', 'm', 'O', 'B', 'M', 'C', 'x', 'x'}
        };
        char[] arregloB = {'C', 'O', 'L'};

        int totalMalezasEliminadas = 0;

        for (int fila = 0; fila < N; fila++) {
            totalMalezasEliminadas += procesarArreglo(matrizV[fila], arregloB);
        }

        // Mostrar la matriz resultante
        mostrarMatriz(matrizV);

        // Mostrar la cantidad de malezas eliminadas
        System.out.println("Total de malezas eliminadas: " + totalMalezasEliminadas);
    }

    public static boolean esCultivada(char c) {
        boolean esCultivada = false;
         if(c >= 'a' && c <= 'z'){
             esCultivada = true;
         }
         return esCultivada;
    }

    public static int buscarInicio(char[] matV, int pos) {
        while (pos < M && esCultivada(matV[pos])) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] matV, int pos) {
        while (pos < M && !esCultivada(matV[pos]) && matV[pos] != 'x') {
            pos++;
        }
        return pos - 1;
    }

    public static int procesarArreglo(char[] matV, char[] arrB) {
        int ini = 0, fin = -1;
        int malezasEliminadas = 0;

        while (ini < M) {
            ini = buscarInicio(matV, fin + 1);
            if (ini < M) {
                fin = buscarFin(matV, ini);
                int tam = fin - ini + 1;
                if (tam > R) {
                    malezasEliminadas += accionarLaser(matV, arrB, ini, fin);
                }
            }
        }
        return malezasEliminadas;
    }

    public static int accionarLaser(char[] matV, char[] arrB, int ini, int fin) {
        int malezasEliminadas = 0;

        for (int i = ini; i <= fin; i++) {
            if (!esBeneficiosa(matV[i], arrB) && !esCultivada(matV[i])) {
                eliminarMaleza(matV, i); // Eliminar maleza
                malezasEliminadas++;
                fin--;
            }
        }
        return malezasEliminadas;
    }

    public static boolean esBeneficiosa(char c, char[] arrB) {
        boolean esBeneficiosa = false;
        int pos = 0;
        while (pos<MAXB && !esBeneficiosa) {
            if (c == arrB[pos]) {
                esBeneficiosa = true;
            }
            pos++;
        }
        return esBeneficiosa;
    }

    public static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void eliminarMaleza(char[] matV, int pos) {
        for (int i = pos; i < M - 1; i++) {
            matV[i] = matV[i + 1];
        }
        matV[M - 1] = 'x'; // Colocar una 'x' al final del arreglo
    }
}
