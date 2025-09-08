/*
 * El Algoritmo de Mezcla Equilibrada Múltiple es una técnica utilizada en ordenación externa, especialmente cuando los datos a ordenar no caben en memoria principal y deben procesarse en archivos o cintas.

¿Cómo funciona?
Distribución inicial:
El archivo original se divide en varias secuencias ordenadas llamadas "runs", que se distribuyen de manera equilibrada en varios archivos o cintas auxiliares.

Mezcla múltiple:
En cada paso, se mezclan simultáneamente los runs de los archivos auxiliares en otros archivos/cintas, combinando varios runs en uno más grande y ordenado.

Iteración:
El proceso se repite, alternando los archivos/cintas de entrada y salida, hasta que todo el archivo está ordenado en uno solo.

Ventajas
Permite ordenar archivos muy grandes usando poca memoria.
Aprovecha varios dispositivos de almacenamiento para acelerar el proceso.
Ejemplo
Si tienes 4 cintas y un archivo grande, el algoritmo distribuye los runs en las cintas y luego los mezcla en pasos sucesivos hasta obtener el archivo ordenado.
 */