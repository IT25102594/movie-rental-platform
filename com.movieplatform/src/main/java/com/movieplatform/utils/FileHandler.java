package com.movieplatform.utils;

import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String DATA_DIR = "data/";

    // reads all lines from a file, skips empty ones
    public static List<String> readAllLines(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_DIR + filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("couldnt read " + filename);
        }
        return lines;
    }

    // adds one new line to the bottom of the file
    public static void appendLine(String filename, String line) {
        try (FileWriter fw = new FileWriter(DATA_DIR + filename, true)) {
            fw.write(line + "\n");
        } catch (IOException e) {
            System.out.println("couldnt write to " + filename);
        }
    }

    // rewrites the whole file - used when updating or deleting
    public static void writeAllLines(String filename, List<String> lines) {
        try (FileWriter fw = new FileWriter(DATA_DIR + filename, false)) {
            for (String line : lines) fw.write(line + "\n");
        } catch (IOException e) {
            System.out.println("couldnt overwrite " + filename);
        }
    }

    // finds a line by matching the first field (the id)
    public static String findById(String filename, String id) {
        for (String line : readAllLines(filename)) {
            if (line.split("\\|")[0].equals(id)) return line;
        }
        return null; // not found
    }

    // generates next id e.g U001, M005
    public static String generateId(String filename, String prefix) {
        return prefix + String.format("%03d", readAllLines(filename).size() + 1);
    }

}