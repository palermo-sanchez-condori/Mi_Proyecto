package Trabajos_PC1;
import java.io.*;
import java.util.*;

public class MezclaEquilibradaMultiple {

    // Divide el archivo original en runs ordenados y los distribuye en archivos auxiliares
    public static void distribuirRuns(String archivoOriginal, String[] archivosAuxiliares, int runSize) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
        List<Integer> buffer = new ArrayList<>();
        int archivoActual = 0;
        String linea;
        while ((linea = reader.readLine()) != null) {
            buffer.add(Integer.parseInt(linea));
            if (buffer.size() == runSize) {
                Collections.sort(buffer); // Ordena el run
                escribirRun(archivosAuxiliares[archivoActual], buffer, true);
                buffer.clear();
                archivoActual = (archivoActual + 1) % archivosAuxiliares.length; // Rota entre archivos
            }
        }
        // Escribe el último run si queda algo
        if (!buffer.isEmpty()) {
            Collections.sort(buffer);
            escribirRun(archivosAuxiliares[archivoActual], buffer, true);
        }
        reader.close();
    }

    // Escribe un run en el archivo especificado
    private static void escribirRun(String archivo, List<Integer> run, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, append));
        for (int num : run) {
            writer.write(num + "\n");
        }
        writer.close();
    }

    // Mezcla los runs de los archivos auxiliares en un archivo de salida
    public static void mezclarRuns(String[] archivosEntrada, String archivoSalida) throws IOException {
        PriorityQueue<ElementoRun> pq = new PriorityQueue<>();
        BufferedReader[] readers = new BufferedReader[archivosEntrada.length];

        // Inicializa los lectores y la cola de prioridad
        for (int i = 0; i < archivosEntrada.length; i++) {
            readers[i] = new BufferedReader(new FileReader(archivosEntrada[i]));
            String linea = readers[i].readLine();
            if (linea != null) {
                pq.add(new ElementoRun(Integer.parseInt(linea), i));
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));

        // Mezcla los runs
        while (!pq.isEmpty()) {
            ElementoRun min = pq.poll();
            writer.write(min.valor + "\n");
            String linea = readers[min.indiceArchivo].readLine();
            if (linea != null) {
                pq.add(new ElementoRun(Integer.parseInt(linea), min.indiceArchivo));
            }
        }

        // Cierra los archivos
        for (BufferedReader r : readers) r.close();
        writer.close();
    }

    // Clase auxiliar para la cola de prioridad
    static class ElementoRun implements Comparable<ElementoRun> {
        int valor;
        int indiceArchivo;
        ElementoRun(int valor, int indiceArchivo) {
            this.valor = valor;
            this.indiceArchivo = indiceArchivo;
        }
        public int compareTo(ElementoRun otro) {
            return Integer.compare(this.valor, otro.valor);
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) throws IOException {
        String archivoOriginal = "datos.txt";
        String[] archivosAuxiliares = {"aux1.txt", "aux2.txt"};
        String archivoOrdenado = "ordenado.txt";
        int runSize = 5; // Tamaño de cada run

        // Paso 1: Distribuir runs
        distribuirRuns(archivoOriginal, archivosAuxiliares, runSize);

        // Paso 2: Mezclar runs
        mezclarRuns(archivosAuxiliares, archivoOrdenado);

        System.out.println("Archivo ordenado generado: " + archivoOrdenado);
    }
}
