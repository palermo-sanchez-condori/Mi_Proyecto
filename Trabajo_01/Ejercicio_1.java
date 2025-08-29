import java.util.Scanner;

public class Ejercicio_1 {
    public static void burbuja(int[] arreg) {
        int n = arreg.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreg[j] > arreg[j + 1]) {
                    // Intercambiar arreg[j] y arreg[j+1]
                    int temp = arreg[j];
                    arreg[j] = arreg[j + 1];
                    arreg[j + 1] = temp;
                    
                }
            }
            
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = entrada.nextInt();
        int[] datos = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            datos[i] = entrada.nextInt();
        }
        burbuja(datos);
        for (int num : datos) {
            System.out.print(num + " ");
        }
    }
}