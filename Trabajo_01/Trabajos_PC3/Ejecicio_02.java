//concepto
/*
 * busqueda lineal (linear search) es un algoritmo sencillo utilizado para encontrar un elemento en una lista o arreglo.
 * Funciona recorriendo secuencialmente cada elemento del arreglo y comparandolo con el
 * elemento objetivo (target) que se desea encontrar.
 * Si el elemento se encuentra, el algoritmo devuelve su índice; si no se encuentra después de revisar todos los elementos,
 * devuelve -1 para indicar que el elemento no está presente en la lista.
 * Este método es simple pero puede ser ineficiente para listas grandes, ya que su tiempo de ejecución es lineal (O(n)).
 */

 
// Codigo
/**
 * Implementación de la Búsqueda Lineal (Linear Search) en Java.
 *
 * Este algoritmo funciona tanto en arreglos ordenados como desordenados.
 * Devuelve el índice del elemento si se encuentra, o -1 si no se encuentra.
 */
public class BusquedaLineal {

    /**
     * Realiza una búsqueda lineal en un arreglo.
     *
     * @param arr    El arreglo donde buscar.
     * @param target El número (objetivo) que queremos encontrar.
     * @return El índice del 'target' si se encuentra, de lo contrario -1.
     */
    public int busquedaLineal(int[] arr, int target) {
        // Recorremos cada elemento del arreglo usando su índice
        for (int i = 0; i < arr.length; i++) {
            
            // Comparamos el elemento actual con el objetivo
            if (arr[i] == target) {
                return i; // ¡Encontrado! Devolvemos el índice actual.
            }
        }

        // Si terminamos el bucle, significa que recorrimos todo
        // el arreglo y no encontramos el elemento.
        return -1;
    }

    // --- Método main para probar el código ---
    public static void main(String[] args) {
        BusquedaLineal bl = new BusquedaLineal();

        // El arreglo NO necesita estar ordenado
        int[] miArray = {16, 5, 38, 91, 2, 72, 23, 12};

        // --- Prueba 1: Elemento que SÍ está ---
        int objetivo1 = 72;
        System.out.println("--- Buscando el número " + objetivo1 + " ---");

        int indice1 = bl.busquedaLineal(miArray, objetivo1);
        System.out.println("Elemento encontrado en el índice: " + indice1);

        System.out.println("------------------------------------");

        // --- Prueba 2: Elemento que NO está ---
        int objetivo2 = 40;
        System.out.println("--- Buscando el número " + objetivo2 + " ---");

        int indice2 = bl.busquedaLineal(miArray, objetivo2);
        System.out.println("Elemento encontrado en el índice: " + indice2);
    }
}
//enlace del video
