package main.java.sorting;

public class RadixSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        // Verificar que el tipo de dato sea Integer
        if (array.length == 0 || !(array[0] instanceof Integer)) {
            throw new UnsupportedOperationException("RadixSort solo soporta arreglos de enteros (Integer[]).");
        }

        Integer[] intArray = (Integer[]) array; // Cast seguro, ya verificamos el tipo
        int max = getMax(intArray);

        // Realizar el conteo para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(intArray, exp);
        }
    }

    private int getMax(Integer[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    private void countingSort(Integer[] array, int exp) {
        int n = array.length;
        Integer[] output = new Integer[n]; // Salida del arreglo
        int[] count = new int[10]; // Arreglo de conteo para los dígitos (0-9)

        // Contar las ocurrencias de los dígitos
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        // Sumar los conteos para calcular las posiciones finales
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copiar el arreglo de salida al original
        System.arraycopy(output, 0, array, 0, n);
    }
}