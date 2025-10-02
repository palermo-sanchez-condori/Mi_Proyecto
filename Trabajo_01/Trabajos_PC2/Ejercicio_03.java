/*
 * Algoritmos de búsqueda externa son:
 * 1. Búsqueda secuencial
 * 2. Búsqueda binaria
 * 3. Búsqueda por interpolación
 * 4. Búsqueda por salto (Jump Search)
 * 5. Búsqueda exponencial
 * 6. Búsqueda ternaria
 * 7. Búsqueda por Fibonacci
 * busueda secuencial es la mas sencilla y basica ya que funciona de la siguiente manera:
 * se recorre el arreglo desde el primer elemento hasta el ultimo elemento
 * y se compara cada elemento con el elemento que se esta buscando
 * si se encuentra el elemento se retorna la posicion del elemento
 * si no se encuentra el elemento se retorna -1
 * si el arreglo esta ordenado se puede utilizar la busqueda binaria que es mas eficiente
 * ya que divide el arreglo en dos partes y se compara el elemento con el elemento del medio
 * si el elemento es menor que el elemento del medio se busca en la primera mitad
 * si el elemento es mayor que el elemento del medio se busca en la segunda mitad
 * y asi sucesivamente hasta encontrar el elemento o hasta que el arreglo no se pueda dividir mas
 */

 //me falta agregar el codigo para los algoritomos de busqueda externa


 //me falta añadir el enlace del video:
 public class Ejercicio_03{
    public static int busquedaPorBloques(int[] arr, int x, int bloqueTam) {
        int n = arr.length;
        int inicio = 0;

        // Buscar el bloque donde podría estar el elemento
        while (inicio < n && arr[Math.min(inicio + bloqueTam - 1, n - 1)] < x) {
            inicio += bloqueTam;
        }

        // Búsqueda secuencial dentro del bloque
        for (int i = inicio; i < Math.min(inicio + bloqueTam, n); i++) {
            if (arr[i] == x) {
                return i; // Retorna la posición si lo encuentra
            }
        }
        return -1; // Retorna -1 si no lo encuentra
    }
    // Ejemplo de uso
    public static void main(String[] args) {
        int[] arreglo = {2, 4, 7, 10, 15, 20, 25, 30, 35, 40};
        int elementoBuscado = 25;
        int tamBloque = 3;

        int resultado = busquedaPorBloques(arreglo, elementoBuscado, tamBloque);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
 }
 //me falta el enlace del video: 