package main.java;

import main.java.sorting.InsertionSort;
import main.java.sorting.MergeSort;
import main.java.sorting.QuickSort;
import main.java.sorting.RadixSort;
import main.java.sorting.SortAlgorithm;
import java.io.IOException;
import main.java.sorting.utils.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "data/numbers.txt";

        FileHandler.generateNumbers(filename, 3000);
        Integer[] numbers = FileHandler.readNumbers(filename);

        SortAlgorithm[] algorithms = {
            new InsertionSort(),
            new MergeSort(),
            new QuickSort(),
            new RadixSort()
        };

        for (SortAlgorithm algorithm : algorithms) {
            long time = Profiler.measureTime(algorithm, numbers);
            System.out.println(algorithm.getClass().getSimpleName() + ": " + time + " ns");
        }
    }
}