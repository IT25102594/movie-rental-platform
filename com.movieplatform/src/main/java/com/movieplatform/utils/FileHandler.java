package com.movieplatform.utils;

import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String DATA_DIR = "data/";

    public static List<String> readAllLines(String filename) {
        List<String> lines = new ArrayList<>();
        File file = new File(DATA_DIR + filename);
        if (!file.exists()) return lines;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void appendLine(String filename, String line) {
        try (FileWriter fw = new FileWriter(DATA_DIR + filename, true)) {
            fw.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllLines(String filename, List<String> lines) {
        try (FileWriter fw = new FileWriter(DATA_DIR + filename, false)) {
            for (String line : lines) fw.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String findById(String filename, String id) {
        for (String line : readAllLines(filename)) {
            String[] parts = line.split("\\|");
            if (parts[0].equals(id)) return line;
        }
        return null;
    }

    public static String generateId(String filename, String prefix) {
        int count = readAllLines(filename).size();
        return prefix + String.format("%03d", count + 1);
    }
}