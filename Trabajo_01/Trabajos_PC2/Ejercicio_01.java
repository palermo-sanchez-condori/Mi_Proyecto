import java.util.Arrays;
import java.util.Scanner;

/*tablas hash
  Las tablas hash son estructuras de datos que permiten almacenar y recuperar información de manera eficiente.
  Utilizan una función hash para calcular un índice en una tabla, donde se almacena el valor asociado a una clave.
  Esto permite un acceso rápido a los datos, ya que la búsqueda se realiza en tiempo constante en promedio.
  Sin embargo, el rendimiento puede verse afectado por colisiones, que ocurren cuando dos claves diferentes generan el mismo índice.
  Para manejar colisiones, se pueden utilizar técnicas como la encadenamiento o la direccionamiento abierto.
*/
/* Ejemplos de funciones hash comunes son:
  - Función hash de división: calcula el índice como el resto de la división de la clave por el tamaño de la tabla.
  - Función hash multiplicativa: utiliza una constante fraccional para multiplicar la clave y luego extrae la parte fraccional para determinar el índice.
  - Función hash universal: selecciona una función hash al azar de una familia de funciones para minimizar las colisiones.
*/
/*
 * Funciones de Dispersión (Hash Functions) están diseñadas para distribuir uniformemente los datos en una tabla hash.
 * Una buena función de dispersión debe minimizar las colisiones y ser rápida de calcular.
 * Algunas características de una buena función de dispersión incluyen:
 * - Uniformidad: distribuye las claves de manera uniforme en la tabla.
 * - Determinismo: la misma clave siempre produce el mismo índice.
 * - Eficiencia: debe ser rápida de calcular para no afectar el rendimiento de la tabla hash.
 * - Simplicidad: la función debe ser fácil de implementar y entender.
 */
// Ejemplo básico de tabla hash con direccionamiento abierto
class TablaHash {
    private int[] tabla;
    private int tamaño;

    public TablaHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new int[tamaño];
        Arrays.fill(tabla, -1); // -1 indica celda vacía
    }

    // Función hash simple (división)
    private int funcionHash(int clave) {
        return clave % tamaño;
    }

    // Insertar un valor en la tabla hash
    public void insertar(int clave) {
        int indice = funcionHash(clave);
        int original = indice;
        while (tabla[indice] != -1) { // Si hay colisión, busca la siguiente celda
            indice = (indice + 1) % tamaño;
            if (indice == original) {
                System.out.println("Tabla llena, no se puede insertar " + clave);
                return;
            }
        }
        tabla[indice] = clave;
    }

    // Buscar un valor en la tabla hash
    public boolean buscar(int clave) {
        int indice = funcionHash(clave);
        int original = indice;
        while (tabla[indice] != -1) {
            if (tabla[indice] == clave) return true;
            indice = (indice + 1) % tamaño;
            if (indice == original) break;
        }
        return false;
    }

    // Mostrar la tabla hash
    public void mostrar() {
        System.out.println("Tabla hash:");
        for (int i = 0; i < tamaño; i++) {
            System.out.println(i + ": " + tabla[i]);
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TablaHash th = new TablaHash(7);
        System.out.println("cuantos valores quieres ingresar?");
        int valor = sc.nextInt();
        for (int i = 0 ; i < valor;i++){
            System.out.println("ingrese el valor "+(i+1)+":");
            int num = sc.nextInt();
            th.insertar(num);
        }
        th.mostrar();
        String res;
        do{
            System.out.println("Que valor quieres buscar?");
            int bus = sc.nextInt();
            System.out.println("el valor que usted busco es "+th.buscar(bus));
            System.out.println("quieres buscar otro numero?(si/no)");
            res = sc.nextLine();
            res = sc.nextLine();
        }while(res.equals("si"));
    }
}
// Fin del ejemplo
// me falta agregar el enlace del video demostrativo