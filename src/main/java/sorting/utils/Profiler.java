package main.java.sorting.utils;

import java.util.Arrays;

import main.java.sorting.SortAlgorithm;

public class Profiler {
    public static long measureTime(SortAlgorithm algorithm, Integer[] data) {
        Integer[] copy = Arrays.copyOf(data, data.length);
        long startTime = System.nanoTime();
        algorithm.sort(copy);
        return System.nanoTime() - startTime;
    }
}