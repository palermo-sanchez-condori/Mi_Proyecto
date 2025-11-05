//concepto
/*
 * Recursividad indirecta:
 * funciona cuando una función llama a otra función,
 * y esta a su vez llama a la primera.
 * Esto crea una cadena de llamadas entre las funciones.
 * Es útil para resolver problemas que pueden dividirse en subproblemas más pequeños.
 * Un ejemplo clásico es el cálculo de números pares e impares:
 * - Una función "esPar" verifica si un número es par.
 * - Si el número no es par, llama a la función "esImpar".
 * - La función "esImpar" verifica si un número es impar.
 * - Si el número no es impar, llama a la función "esPar".
 * Este proceso continúa hasta que se alcanza una condición base.
 * Así, ambas funciones trabajan juntas para determinar si un número es par o impar.
 * La recursividad indirecta permite una mayor flexibilidad en la resolución de problemas.
 */
//codigo
import java.util.Scanner;

public class EjemploRecursividad {
    
    // Método recursivo para calcular el factorial de un número
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Caso base
        } else {
            return n * factorial(n - 1); // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un número: ");
        int numero = sc.nextInt();
        
        int resultado = factorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
        
        sc.close();
    }
}

//enlace

public class Ejercicio3 {
    
}
