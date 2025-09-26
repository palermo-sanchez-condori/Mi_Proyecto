import java.util.LinkedList;

public class HashTableChaining<K, V> {
    private static final int SIZE = 10;
    private LinkedList<Entry<K, V>>[] table;

    public HashTableChaining() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);
        return table[index].removeIf(entry -> entry.key.equals(key));
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

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
    // Ejemplo de uso
    public static void main(String[] args) {
        HashTableChaining<String, Integer> hashTable = new HashTableChaining<>();
        hashTable.put("uno", 1);
        hashTable.put("dos", 2);
        hashTable.put("tres", 3);

        System.out.println(hashTable.get("dos")); // Imprime 2
        hashTable.remove("dos");
        System.out.println(hashTable.get("dos")); // Imprime null
    }
}


