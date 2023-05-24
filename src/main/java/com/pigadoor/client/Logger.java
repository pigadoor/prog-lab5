package com.pigadoor.client;

import java.util.ArrayList;
import java.util.List;

/**
 * The Logger class provides logging functionality for commands.
 */
public final class Logger {
    private Logger() {}

    private static int capacity = 8;

    private static int numb = -1;
    private static final List<String> history = new ArrayList<>();

    /**
     * Logs a command to the history.
     *
     * @param command The command to be logged.
     */
    public static void log(String command){
        history.add(command);
        numb += 1;
        if (history.size() > capacity) {
            history.remove(0);
        }
    }

    /**
     * Removes the last logged command from the history.
     */
    public static void removeLast(){
        history.remove(numb);
    }

    /**
     * Retrieves a copy of all logged commands in the history.
     *
     * @return A list containing all logged commands.
     */
    public static List<String> getAll(){
        return new ArrayList<>(history);
    }

    /**
     * Sets the maximum capacity of the history.
     *
     * @param capacity The maximum capacity of the history.
     */
    public static void setCapacity(int capacity) {
        Logger.capacity = capacity;
    }
}
