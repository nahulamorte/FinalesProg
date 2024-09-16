public class ExtraRecuperatorio {
    //Declaracion de constantes:
    final static int N = 3; //cantidad de filas
    final static int M = 22; //cantidad de columnas
    
    public static void main(String[] args) {
        char[][] matriz = {
            {'-', 'S', 'u', 'p', 'e', 'r', ' ', 's', 'e', 'c', 'r', 'e', 't', 'o', ':', '-', '-', '-', '-', '-', '-', '-'},
            {'¡', '¡', 'n', 'o', ' ', 'c', 'o', 'r', 't', 'a', 'r', ' ', 'f', 'o', 'r', '-', '-', '-', '-', '-', '-', '-'},
            {' ', 'c', 'o', 'n', ' ', 'r', 'e', 't', 'u', 'r', 'n', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!'}
        };
        mostrarMatriz(matriz);
        recorrerMatriz(matriz);
        mostrarMatriz(matriz);
    }

    public static boolean esLetra(char caracter){
        boolean esLetra = false;
        if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {
            esLetra = true;
        }
        return esLetra;
    }

    public static boolean esVocal(char caracter){
        boolean esVocal = false;
        if ((caracter == 'a' || caracter == 'e' || caracter == 'i'|| caracter == 'o' || caracter == 'u') || 
        (caracter == 'A' || caracter == 'E' || caracter == 'I'|| caracter == 'O' || caracter == 'U')) {
            esVocal = true;
        }
        return esVocal;
    }

    public static int buscarInicio(char [] arr, int pos){
        while (pos<M && !esLetra(arr[pos])) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char [] arr, int pos){
        while (pos<M && esLetra(arr[pos])) {
            pos++;
        }
        return pos-1;
    }
    
    public static void recorrerMatriz(char [][] matriz){
        int palabrasEncriptadas = 0;
        for (int fila = 0; fila < N;fila++){
            palabrasEncriptadas += recorrerFila(matriz[fila]);
        }
        System.out.println("Se encriptaron " + palabrasEncriptadas + " palabras");
    }

    public static int recorrerFila(char [] arr){
        int ini = 0, fin = -1, palabrasEncriptadas = 0;
        while (ini<M) {
            ini = buscarInicio(arr, fin+1);
            if (ini<M) {
                fin = buscarFin(arr, ini);
                encriptarPalabra(arr, ini, fin);
                palabrasEncriptadas++;
            }
        }
        return palabrasEncriptadas;
    }

    public static void encriptarPalabra(char [] arr, int ini, int fin){
        int tam = fin - ini + 1;
        while (ini<=fin) {
            if (!esVocal(arr[ini])) {
                duplicarLetra(arr, ini);
                fin++;
                ini++;
            } else {
                arr[ini] = (char)(arr[ini] + tam);
            }
            ini++;
        }
    }

    public static void duplicarLetra(char [] arr, int ini){
        for (int i = M - 1; i > ini; i--) {
            arr[i] = arr[i-1];
        } 
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
