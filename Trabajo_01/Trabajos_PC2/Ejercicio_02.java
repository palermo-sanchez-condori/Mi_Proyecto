/*
 * 
 * Direccionamiento Enlazado (Encadenamiento)
 * Una técnica común para manejar colisiones en tablas hash es el direccionamiento enlazado (encadenamiento).
 * En este enfoque, cada posición de la tabla hash contiene una lista de elementos que colisionaron en esa posición.
 * Cuando se produce una colisión, el nuevo elemento se agrega a la lista en la posición correspondiente.
 * Esto permite almacenar múltiples elementos en la misma posición de la tabla sin perder información.
 * 
 * Ventajas del direccionamiento enlazado:
 * - Manejo eficiente de colisiones: Almacena múltiples elementos en la misma posición sin necesidad de rehashing.
 * - Flexibilidad: Permite insertar elementos de manera dinámica sin preocuparse por el tamaño de la tabla.
 * - Simplicidad: La implementación es más sencilla en comparación con otras técnicas de manejo de colisiones.
 * - No hay necesidad de un tamaño fijo para la tabla: La tabla puede crecer dinámicamente según sea necesario.
 * - Eficiencia en la inserción: La inserción de nuevos elementos es rápida, ya que solo se agrega a la lista.
 * 
 * Desventajas del direccionamiento enlazado:
 * - Mayor uso de memoria: Cada elemento requiere espacio adicional para los punteros de la lista
 * - Rendimiento variable: Si muchas colisiones ocurren, las listas pueden volverse largas, afectando el tiempo de búsqueda.
 * - Complejidad en la implementación: Requiere manejo de listas enlazadas, lo que puede complicar el código.
 */


