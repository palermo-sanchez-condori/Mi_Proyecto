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

 /*
  * El Método Polifásico de Ordenación Externa es otra técnica para ordenar archivos grandes que no caben en memoria, usando varios archivos o cintas. Es más eficiente que la mezcla equilibrada múltiple porque reduce el número de archivos auxiliares y el número de pasadas necesarias.

¿Cómo funciona?
Distribución inicial polifásica:
Los runs (secuencias ordenadas) se distribuyen en los archivos auxiliares siguiendo una secuencia especial (generalmente la secuencia de Fibonacci). Esto permite que en cada paso siempre haya runs disponibles para mezclar, evitando archivos vacíos.

Mezcla polifásica:
Se mezclan los runs de los archivos auxiliares en un archivo de salida. Cuando un archivo se queda sin runs, se reutiliza como archivo de salida en la siguiente fase.

Iteración:
El proceso se repite, alternando los archivos de entrada y salida, hasta que todos los datos están ordenados en un solo archivo.

Ventajas
Menos archivos auxiliares necesarios.
Menos pasadas sobre los datos.
Mejor aprovechamiento del espacio y tiempo.
Ejemplo
Supón que tienes 3 archivos auxiliares y 13 runs. Los distribuyes según la secuencia de Fibonacci (8, 5, 0). Mezclas los runs de los dos archivos con datos en el tercero, y repites el proceso hasta que todo está ordenado.
  */