public class Ejercicio_02 {

    // Método para ordenar un arreglo usando ordenamiento por inserción
    public static void ordenamientoPorInsercion(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i];
            int j = i - 1;
            // Mueve los elementos del arreglo[0..i-1] que son mayores que clave
            // a una posición adelante de su posición actual
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = clave;
        }
    }

    // Método para imprimir el arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método principal para probar el ordenamiento
    public static void main(String[] args) {
        int[] datos = {5, 2, 9, 1, 5, 6};
        System.out.println("Arreglo original:");
        imprimirArreglo(datos);

        ordenamientoPorInsercion(datos);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(datos);
    }
}
