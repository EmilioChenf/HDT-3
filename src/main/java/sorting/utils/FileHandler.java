package main.java.sorting.utils;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static void generateNumbers(String filename, int count) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                writer.write(random.nextInt(10000) + "\n");
            }
        }
    }

    public static Integer[] readNumbers(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        }
        return numbers.toArray(new Integer[0]);
    }
}