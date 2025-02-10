package main.java;

import main.java.sorting.InsertionSort;
import main.java.sorting.MergeSort;
import main.java.sorting.QuickSort;
import main.java.sorting.RadixSort;
import main.java.sorting.SortAlgorithm;
import java.io.IOException;
import main.java.sorting.utils.*;
import java.util.Arrays;

/**
 * Clase principal que ejecuta y mide el tiempo de ejecución de diferentes
 * algoritmos de ordenamiento con conjuntos de números aleatorios y previamente ordenados.
 */
public class Main {
    
    /**
     * Método principal que coordina la generación, lectura, ordenamiento y medición de tiempos
     * de ejecución de distintos algoritmos de ordenamiento.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     * @throws IOException Si ocurre un error al leer o escribir el archivo de números.
     */
    public static void main(String[] args) throws IOException {
        // Ruta del archivo con los números generados
        String filename = "data/numbers.txt";

        // Generar números aleatorios y guardarlos en el archivo (solo necesario la primera vez)
        FileHandler.generateNumbers(filename, 3000);

        // Leer los números desde el archivo
        Integer[] numbers = FileHandler.readNumbers(filename);

        // Algoritmos de ordenamiento
        SortAlgorithm[] algorithms = {
            new InsertionSort(),
            new MergeSort(),
            new QuickSort(),
            new RadixSort()
        };

        // Tamaños de entrada para las pruebas
        int[] sizes = {10, 100, 500, 1000, 2000, 3000};

        System.out.println("===== Tiempos de ejecución con números aleatorios =====");
        for (int size : sizes) {
            System.out.println("Tamaño: " + size);
            Integer[] subset = Arrays.copyOf(numbers, size); // Subarreglo para este tamaño

            for (SortAlgorithm algorithm : algorithms) {
                long time = Profiler.measureTime(algorithm, subset);
                System.out.printf("%s (size %d): %d ns%n", algorithm.getClass().getSimpleName(), size, time);
            }
            System.out.println();
        }

        System.out.println("===== Tiempos de ejecución con números previamente ordenados =====");
        // Ordenar previamente los números
        Arrays.sort(numbers);
        for (int size : sizes) {
            System.out.println("Tamaño: " + size);
            Integer[] subset = Arrays.copyOf(numbers, size); // Subarreglo para este tamaño

            for (SortAlgorithm algorithm : algorithms) {
                long time = Profiler.measureTime(algorithm, subset);
                System.out.printf("%s (sorted, size %d): %d ns%n", algorithm.getClass().getSimpleName(), size, time);
            }
            System.out.println();
        }
    }
}