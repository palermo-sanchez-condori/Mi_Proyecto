

/* EL ALGORITMO DE MEZCLA DIRECTA
 *
 * Es un metodo de ordenamiento y se basa en la técnica de divide y vencerás.
 * la manera en la que funciona es mediante dos pasos:
 * 1. Dividir la lista en dos mitades o más.
 * 2. Mezclar las dos mitades de forma ordenada.
 * 
 * Lo bueno de este algoritmo es que es más eficiente para archivos de tamaño moderado,
 * pero no es muy eficiente para archivos de gran tamaño.
 *
 * Algunos ejemplos seran los siguientes:
 * - Si tenemos el arreglo [38, 27, 43, 3, 9, 82, 10]
 *   1. Se divide en [38, 27, 43] y [3, 9, 82, 10]
 *   2. Se mezclan para obtener [3, 9, 10, 27, 38, 43, 82]
 *
 * Ejercicio 1
 * Tienes un archivo con 1 millón de números enteros desordenados (más grande que tu memoria RAM).
 *   Ejercicio:
 *
 * Divide el archivo en bloques de 100.000 números.
 *
 * Ordena cada bloque con un algoritmo interno (ej. quicksort).
 *
Usa un algoritmo de mezcla balanceada (k-way merge) para unir los bloques en un archivo final ordenado.
 */

/* EL ALGORITMO DE FUSION NATURAL
 *
 * Este algoritmo es otro metodo de ordenamiento y lo primero que hace es identificar
 * las sublistas que ya están ordenadas. Luego, fusiona estas sublistas de manera
 * eficiente para obtener una lista completamente ordenada.
 *
 * Este algoritmo puede ser mejor que el anterior si las sublistas ya están
 * ordenadas, ya que evita la necesidad de dividir y mezclar repetidamente, pero
 * la eficiencia depende mucho de como esté la estructura del archivo.
 */
