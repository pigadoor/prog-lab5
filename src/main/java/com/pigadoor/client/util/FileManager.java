package com.pigadoor.client.util;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Utility class for file operations.
 */
public final class FileManager {

    /**
     * The default file path to use.
     */
    public static final String FILE_PATH = System.getenv("LAB");

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private FileManager() {
    }

    /**
     * Reads the contents of a file at the specified file path.
     *
     * @param filePath The path of the file to read.
     * @return The contents of the file as a string.
     */
    public static String read(final String filePath) {
        StringJoiner fileData = new StringJoiner("\n");

        try (FileReader reader = new FileReader(filePath);
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Environment variable not set");
            System.exit(0);
        }
        return fileData.toString();
    }

    /**
     * Writes data to a file at the specified file path.
     *
     * @param data     The data to write to the file.
     * @param filePath The path of the file to write to.
     */
    public static void write(String data, final String filePath) {
        try (OutputStream os = new FileOutputStream(filePath);
             OutputStreamWriter osw = new OutputStreamWriter(os)) {
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Environment variable not set");
            System.exit(0);
        }
    }
}
