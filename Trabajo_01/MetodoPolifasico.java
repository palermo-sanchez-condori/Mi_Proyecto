import java.io.*;
import java.util.*;

public class MetodoPolifasico {

    // Calcula la secuencia de Fibonacci para distribuir los runs
    public static int[] fibonacciDistribucion(int totalRuns, int numArchivos) {
        int[] fib = new int[numArchivos];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < numArchivos; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        // Ajusta la distribución para que la suma sea igual o mayor al total de runs
        while (Arrays.stream(fib).sum() < totalRuns) {
            for (int i = 0; i < numArchivos; i++) {
                fib[i]++;
            }
        }
        return fib;
    }

    // Distribuye los runs en los archivos según la secuencia de Fibonacci
    public static void distribuirRunsPolifasico(String archivoOriginal, String[] archivosAuxiliares, int[] distribucion, int runSize) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
        List<Integer> buffer = new ArrayList<>();
        int archivoActual = 0, runActual = 0;
        String linea;
        while ((linea = reader.readLine()) != null) {
            buffer.add(Integer.parseInt(linea));
            if (buffer.size() == runSize) {
                Collections.sort(buffer);
                if (runActual < distribucion[archivoActual]) {
                    escribirRun(archivosAuxiliares[archivoActual], buffer, true);
                    runActual++;
                }
                buffer.clear();
                if (runActual >= distribucion[archivoActual]) {
                    archivoActual++;
                    runActual = 0;
                }
            }
        }
        if (!buffer.isEmpty() && archivoActual < archivosAuxiliares.length) {
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

    // Mezcla polifásica: mezcla los runs de los archivos auxiliares en el archivo de salida
    public static void mezclarPolifasico(String[] archivosEntrada, String archivoSalida) throws IOException {
        PriorityQueue<ElementoRun> pq = new PriorityQueue<>();
        BufferedReader[] readers = new BufferedReader[archivosEntrada.length];

        for (int i = 0; i < archivosEntrada.length; i++) {
            readers[i] = new BufferedReader(new FileReader(archivosEntrada[i]));
            String linea = readers[i].readLine();
            if (linea != null) {
                pq.add(new ElementoRun(Integer.parseInt(linea), i));
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));

        while (!pq.isEmpty()) {
            ElementoRun min = pq.poll();
            writer.write(min.valor + "\n");
            String linea = readers[min.indiceArchivo].readLine();
            if (linea != null) {
                pq.add(new ElementoRun(Integer.parseInt(linea), min.indiceArchivo));
            }
        }

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
        String[] archivosAuxiliares = {"aux1.txt", "aux2.txt", "aux3.txt"};
        String archivoOrdenado = "ordenado.txt";
        int runSize = 5; // Tamaño de cada run
        int totalRuns = 13; // Total de runs a distribuir

        // Paso 1: Calcular distribución polifásica (Fibonacci)
        int[] distribucion = fibonacciDistribucion(totalRuns, archivosAuxiliares.length);

        // Paso 2: Distribuir runs según la secuencia de Fibonacci
        distribuirRunsPolifasico(archivoOriginal, archivosAuxiliares, distribucion, runSize);

        // Paso 3: Mezclar polifásicamente los runs
        mezclarPolifasico(archivosAuxiliares, archivoOrdenado);

        System.out.println("Archivo ordenado generado: " + archivoOrdenado);
    }
}
