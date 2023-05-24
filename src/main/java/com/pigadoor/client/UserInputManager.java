package com.pigadoor.client;

import com.pigadoor.client.util.FileManager;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * This class reads user input from keyboard or from file with the script
 */
public class UserInputManager {

    private final ArrayDeque<ArrayDeque<String>> allScripts = new ArrayDeque<>();
    private final ArrayDeque<String> filePaths = new ArrayDeque<>();
    private final Scanner scanner =  new Scanner(System.in);

    /**
     * Reads a line of user input either from a script or the keyboard.
     *
     * @return The user input as a string.
     */
    public String readLine() {
        if (!allScripts.isEmpty()) {
            ArrayDeque<String> currentScript = allScripts.peek();
            if (!currentScript.isEmpty()) {
                return currentScript.pop();
            }
            allScripts.pop();
            filePaths.pop();
            return readLine();
        }
        try {
            return scanner.nextLine();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Program terminated! Exit...");
            System.exit(0);
            return "exit";
        }
    }

    /**
     * Connects to a script file and prepares to read commands from it.
     *
     * @param filePath The path of the script file to connect to.
     */
    public void connectToFile(String filePath) {
        if (filePaths.contains(filePath)) {
            System.err.println("The file contains recursion");
        } else {
            String script = FileManager.read(filePath);
            if (!script.isEmpty()) {
                try (Scanner sc = new Scanner(script)) {
                    ArrayDeque<String> commands = new ArrayDeque<>();
                    while (sc.hasNextLine()) {
                        commands.add(sc.nextLine());
                    }
                    filePaths.push(filePath);
                    allScripts.push(commands);
                }
            }
        }
    }

}

