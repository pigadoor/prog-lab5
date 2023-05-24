package com.pigadoor.client;

import com.pigadoor.client.commands.CommandResult;
import com.pigadoor.client.data.SpaceMarine;
import com.pigadoor.client.util.FileManager;
import com.pigadoor.client.util.JsonParser;

import java.io.FileNotFoundException;
import java.util.TreeMap;


/**
 * Main class that start interactive mode
 *
 * @author Zakharov Egor P3116
 */
public final class Client {

    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws FileNotFoundException {

        final CollectionStorage collectionStorage = new CollectionStorage();
        final UserInputManager userInputManager = new UserInputManager();
        final CommandStore commandStore = new CommandStore(collectionStorage, userInputManager);
        final CommandInvoker commandInvoker = new CommandInvoker(commandStore);


        String fileData = FileManager.read(FileManager.FILE_PATH);
        TreeMap<Integer, SpaceMarine> tm = JsonParser.deserialize(fileData);
        System.out.println("Collection downloaded. Loaded: " + tm.size() + " items.");
        System.out.println("Application has been started. Enter a command.");
        collectionStorage.initializeTreeMap(tm);

        CommandResult result;
        do {
            String name = "";
            String arg = "";
            String[] command = userInputManager.readLine().split(" ");

            if (command.length >= 1) {
                name = command[0];
            }
            if (command.length >= 2) {
                arg = command[1];
            }

            result = commandInvoker.runCommand(name,arg);
            System.out.println(result.getMessage());

        } while (!result.isExit());

    }
}
