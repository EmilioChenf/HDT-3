package main.java;

import main.java.sorting.InsertionSort;
import main.java.sorting.MergeSort;
import main.java.sorting.QuickSort;
import main.java.sorting.RadixSort;
import main.java.sorting.SortAlgorithm;
import java.io.IOException;
import main.java.sorting.utils.*;
import java.util.Arrays;

public class Main {
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