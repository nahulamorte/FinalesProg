public class FinalRegular23 {

    public static final int CANT_LETRAS_ALF = 27;
    public static final int MAX_COL = 20;  // Ahora el número correcto de columnas
    public static final int MAX_FIL = 3;   // Tres filas
    public static final char SEP = ' ';

    public static void main(String[] args) {
        // Definir matriz con 19 columnas y 3 filas
        char[][] mensaje = {
            {' ', 'E', 'L', ' ', 'A', 'U', 'T', 'O', ' ', 'C', 'H', 'I', 'C', 'O', ' ', 'D', 'E', ' ',' ',' '},
            {' ', ' ', 'L', 'A', ' ', 'B', 'R', 'I', 'G', 'A', 'D', 'A', ' ', 'V', 'A', ' ', 'A', ' ',' ',' '},
            {' ', 'L', 'A', ' ', 'U', 'N', 'A', ' ', 'A', 'L', ' ', 'C', 'U', 'A', 'R', 'T', 'E', 'L',' ',' '}
        };

        mostrarMensaje(mensaje);

        char[] alfabeto = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        for (int i = 0; i < MAX_FIL; i++) {
            procesarMensaje(mensaje[i], alfabeto);
        }

        mostrarMensaje(mensaje);

        
    }

    // Método corregido para imprimir la matriz sin exceder los límites
    public static void mostrarMensaje(char[][] matriz) {
        for (int i = 0; i < MAX_FIL; i++) {  // Recorre cada fila
            for (int j = 0; j < MAX_COL; j++) {  // Asegúrate de que no exceda la cantidad de columnas (19)
                System.out.print(matriz[i][j]);
            }
            System.out.println();  // Imprime una nueva línea al final de cada fila
        }
    }

    public static void procesarMensaje(char[] mensaje, char[] alfabeto) {
        int ini = 0, fin = -1, palabrasEncriptadas = 0, tamPalabraLarga = 0, totalPalabrasEncriptadas = 0;;
        while (ini < MAX_COL) {
            ini = buscarInicio(mensaje, fin + 1);
            if (ini < MAX_COL) {
                fin = buscarFin(mensaje, ini);
                palabrasEncriptadas++;
                encriptarPalabra(mensaje, alfabeto, ini, fin);

                int tam = fin - ini + 1;
                if (tam >= tamPalabraLarga) {
                    tamPalabraLarga = tam;
                }
            }
            
            totalPalabrasEncriptadas += palabrasEncriptadas; 
        }

        

        System.out.println("La palabra más larga tiene: " + tamPalabraLarga);
        System.out.println("Se encriptaron: " + totalPalabrasEncriptadas + " palabras.");
    }

    public static int buscarInicio(char[] mensaje, int pos) {
        while (pos < MAX_COL && mensaje[pos] == SEP) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] mensaje, int pos) {
        while (pos < MAX_COL && mensaje[pos] != SEP) {
            pos++;
        }
        return pos - 1;
    }

    public static void encriptarPalabra(char[] mensaje, char[] alfabeto, int ini, int fin) {
        int pos = 0;
        while (pos < CANT_LETRAS_ALF && ini <= fin) {
            if (alfabeto[pos] == mensaje[ini]) {
                int cuenta = CANT_LETRAS_ALF - 1 - pos;
                mensaje[ini] = alfabeto[cuenta];
                ini++;
                pos = -1;
            }
            pos++;
        }
    }
}
