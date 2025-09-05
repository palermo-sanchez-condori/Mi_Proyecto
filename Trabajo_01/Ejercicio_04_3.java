/*
 * Problema 1:
   Dado un archivo de texto con una lista de números enteros desordenados (uno por línea), 
   implementa un programa que utilice el algoritmo de Mezcla Directa para ordenarlos y
   guarde el resultado en un nuevo archivo.
 * 
 * en este problema se puede usar el algoritmo de mezcla directa para ordenar los números enteros,
 * dividiendo el archivo en bloques manejables, ordenando cada bloque y luego fusionándolos.
 * ejemplo:
  * - Si tenemos una lista de numeros [38, 27, 43, 3, 9, 82, 10]
 *   1. Se divide en [38, 27, 43] y [3, 9, 82, 10]
 *   2. Se mezclan para obtener [3, 9, 10, 27, 38, 43, 82]
 *
 */

 /*
  * Problema 2:
   Un banco recibe 10 archivos de transacciones diarios (cada uno con 100 MB).
   Implementa un programa que utilice el algoritmo de Fusión Natural para ordenar las transacciones y
   guardar el resultado en un nuevo archivo.
    * en este problema se puede usar el algoritmo de fusión natural para ordenar las transacciones,
   identificando las sublistas ya ordenadas en cada archivo y fusionándolas eficientemente.
    ejemplo:
    * - Si tenemos una lista de transacciones [2023-10-01, 2023-10-03, 2023-10-02]
 *   1. Se identifica que [2023-10-01, 2023-10-03] está ordenado y [2023-10-02] es una sublista.
 *   2. Se fusionan para obtener [2023-10-01, 2023-10-02, 2023-10-03]
 *   3. Se repite el proceso para los demás archivos.
  */