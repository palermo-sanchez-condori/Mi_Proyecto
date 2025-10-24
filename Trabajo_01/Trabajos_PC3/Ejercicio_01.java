//concepto
/*
 * ordenamiento rapido (quick sort) es un algoritmo de ordenamiento eficiente basado en la tecnica de divide y venceras. 
 * Funciona seleccionando un 'pivote' y particionando el arreglo en dos subarreglos: los elementos menores que el pivote y los elementos mayores que el pivote. 
 * Luego, se aplica recursivamente el mismo proceso a los subarreglos hasta que el arreglo este completamente ordenado.
 * La eficiencia del quick sort radica en su capacidad para reducir el numero de comparaciones y movimientos necesarios para ordenar los elementos,
 * lo que lo hace especialmente adecuado para grandes conjuntos de datos.
 * 
 * un ejemplo de como funciona el quick sort:
 * Dado el arreglo [34, 7, 23, 32, 5, 62]
 * 1. Seleccionamos un pivote, por ejemplo, 23.
 * 2. Reorganizamos el arreglo de manera que todos los elementos menores que el pivote queden a su izquierda y los mayores a su derecha.
 * 3. Aplicamos recursivamente el mismo proceso a los subarreglos.
 * 4. Finalmente, obtenemos el arreglo ordenado: [5, 7, 23, 32, 34, 62].
 * El quick sort es conocido por su eficiencia y rapidez en la ordenacion de grandes conjuntos de datos,
 * y es ampliamente utilizado en aplicaciones informaticas donde el rendimiento es crucial.
 * en el mejor de los casos, su complejidad temporal es O(n log n), mientras que en el peor de los casos puede llegar a O(n^2),
 * dependiendo de la eleccion del pivote y la distribucion de los datos.
 */
// codigo
import java.util.Arrays;

public class QuickSort {

    public void ordenar(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSortRecursivo(arr, 0, arr.length - 1);
    }

    /**
     * El método recursivo principal de QuickSort.
     *
     * @param arr   El arreglo a ordenar.
     * @param bajo  El índice inicial (low).
     * @param alto  El índice final (high).
     */
    private void quickSortRecursivo(int[] arr, int bajo, int alto) {
        // Condición base: si el índice bajo es mayor o igual al alto,
        // la sublista tiene 0 o 1 elemento, por lo tanto, ya está ordenada.
        if (bajo < alto) {
            // Encuentra el índice del pivote, de modo que los elementos
            // menores están a su izquierda y los mayores a su derecha.
            int indicePivote = particionar(arr, bajo, alto);

            // Llama recursivamente a quickSort para las dos sub-listas
            // (antes y después del pivote).
            quickSortRecursivo(arr, bajo, indicePivote - 1);  // Sublista izquierda
            quickSortRecursivo(arr, indicePivote + 1, alto); // Sublista derecha
        }
    }

    /**
     * Este método toma el último elemento como pivote,
     * coloca el pivote en su posición correcta en el arreglo ordenado,
     * y coloca todos los elementos menores que el pivote a su izquierda,
     * y todos los mayores a su derecha.
     *
     * @param arr   El arreglo.
     * @param bajo  Índice inicial de la sublista.
     * @param alto  Índice final de la sublista (usado como pivote).
     * @return El índice donde el pivote ha sido colocado.
     */
    private int particionar(int[] arr, int bajo, int alto) {
        // Seleccionamos el último elemento como pivote.
        int pivote = arr[alto];

        // 'i' será el índice del elemento más pequeño encontrado hasta ahora.
        // Se inicializa en (bajo - 1) porque aún no hemos encontrado ninguno.
        int i = (bajo - 1);

        // Recorremos el arreglo desde 'bajo' hasta 'alto - 1' (sin incluir el pivote).
        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual (arr[j]) es menor o igual que el pivote...
            if (arr[j] <= pivote) {
                // ...incrementamos 'i' (movemos el límite de los menores).
                i++;
                // E intercambiamos arr[i] con arr[j].
                // Esto mueve el elemento menor (arr[j]) a la "zona de menores".
                intercambiar(arr, i, j);
            }
        }

        // Al final del bucle, todos los elementos menores que el pivote están
        // a la izquierda de (i + 1).
        // Ahora, colocamos el pivote (arr[alto]) en su lugar correcto (i + 1).
        intercambiar(arr, i + 1, alto);

        // Devolvemos el índice donde quedó el pivote.
        return (i + 1);
    }

    /**
     * Método auxiliar para intercambiar dos elementos en el arreglo.
     */
    private void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // --- Método main para probar el código ---
    public static void main(String[] args) {
        int[] arreglo = {10, 7, 8, 9, 1, 5, 3, 6, 2, 4};

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arreglo));

        QuickSort qs = new QuickSort();
        qs.ordenar(arreglo);

        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(arreglo));
    }
}
// enlace del video