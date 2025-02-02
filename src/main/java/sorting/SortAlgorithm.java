package main.java.sorting;

public interface SortAlgorithm {
    <T extends Comparable<T>> void sort(T[] array);
}