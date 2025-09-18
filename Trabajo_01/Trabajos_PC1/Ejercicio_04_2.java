package Trabajos_PC1;
public class Ejercicio_04_2 {
    public static void naturalMergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        boolean sorted = false;

        while (!sorted) {
            int start = 0;
            int mid, end;
            sorted = true;

            while (start < n) {
                mid = start + 1;
                // Encuentra el final de la primera secuencia ordenada
                while (mid < n && arr[mid - 1] <= arr[mid]) {
                    mid++;
                }
                if (mid == n) break;

                end = mid + 1;
                // Encuentra el final de la segunda secuencia ordenada
                while (end < n && arr[end - 1] <= arr[end]) {
                    end++;
                }

                merge(arr, temp, start, mid, end);
                sorted = false;
                start = end;
            }
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        int i = start, j = mid, k = start;
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j < end) temp[k++] = arr[j++];
        for (i = start; i < end; i++) arr[i] = temp[i];
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 7, 1, 3, 6, 8};
        System.out.println("Antes de ordenar:");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();

        naturalMergeSort(arr);

        System.out.println("Después de ordenar:");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }
}
