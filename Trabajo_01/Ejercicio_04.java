import java.io.*;
import java.util.*;

public class Ejercicio_04 {

    // Divide el archivo grande en archivos más pequeños ordenados
    public static List<File> dividirYOrdenar(File archivoEntrada, int tamanoBloque) throws IOException {
        List<File> archivosTemporales = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada))) {
            List<Integer> bloque = new ArrayList<>(tamanoBloque);
            String linea;
            while ((linea = lector.readLine()) != null) {
                bloque.add(Integer.parseInt(linea));
                if (bloque.size() == tamanoBloque) {
                    archivosTemporales.add(guardarBloqueOrdenado(bloque));
                    bloque.clear();
                }
            }
            if (!bloque.isEmpty()) {
                archivosTemporales.add(guardarBloqueOrdenado(bloque));
            }
        }
        return archivosTemporales;
    }

    // Guarda un bloque ordenado en un archivo temporal
    private static File guardarBloqueOrdenado(List<Integer> bloque) throws IOException {
        Collections.sort(bloque);
        File temp = File.createTempFile("bloque", ".tmp");
        temp.deleteOnExit();
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(temp))) {
            for (int num : bloque) {
                escritor.write(num + "\n");
            }
        }
        return temp;
    }

    // Mezcla los archivos temporales en un archivo de salida ordenado
    public static void mezclarArchivos(List<File> archivosTemporales, File archivoSalida) throws IOException {
        PriorityQueue<ElementoArchivo> cola = new PriorityQueue<>();
        List<BufferedReader> lectores = new ArrayList<>();

        for (File archivo : archivosTemporales) {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            lectores.add(lector);
            String linea = lector.readLine();
            if (linea != null) {
                cola.add(new ElementoArchivo(Integer.parseInt(linea), lectores.size() - 1));
            }
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida))) {
            while (!cola.isEmpty()) {
                ElementoArchivo elemento = cola.poll();
                escritor.write(elemento.valor + "\n");
                String linea = lectores.get(elemento.indiceArchivo).readLine();
                if (linea != null) {
                    cola.add(new ElementoArchivo(Integer.parseInt(linea), elemento.indiceArchivo));
                }
            }
        }

        for (BufferedReader lector : lectores) {
            lector.close();
        }
    }

    // Clase auxiliar para la cola de prioridad
    static class ElementoArchivo implements Comparable<ElementoArchivo> {
        int valor;
        int indiceArchivo;

        ElementoArchivo(int valor, int indiceArchivo) {
            this.valor = valor;
            this.indiceArchivo = indiceArchivo;
        }

        public int compareTo(ElementoArchivo otro) {
            return Integer.compare(this.valor, otro.valor);
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) throws IOException {
        File archivoEntrada = new File("entrada.txt");
        File archivoSalida = new File("salida_ordenada.txt");
        int tamanoBloque = 1000; // Ajustar según la memoria disponible

        List<File> archivosTemporales = dividirYOrdenar(archivoEntrada, tamanoBloque);
        mezclarArchivos(archivosTemporales, archivoSalida);

        System.out.println("Ordenamiento externo completado.");
    }
}