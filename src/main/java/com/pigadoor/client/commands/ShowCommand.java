package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

import java.util.StringJoiner;

/**
 * The ShowCommand class represents a command to display all elements in the collection.
 * It extends the Command class.
 */
public class ShowCommand extends Command {

    private final CollectionStorage collectionStorage;

    /**
     * Constructs a ShowCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     */
    public ShowCommand(CollectionStorage collectionStorage) {
        super("show");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the show command by displaying all elements in the collection.
     *
     * @param inputArg The input argument for the command (not used in this command).
     * @return A CommandResult object indicating the status of the command execution.
     *         It returns the string representation of all elements in the collection.
     *         If the collection is empty, it returns a message indicating that the collection is empty.
     */
    @Override
    public CommandResult execute(String inputArg) {

        if (collectionStorage.getTreeMap().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        }
        StringJoiner output = new StringJoiner("\n\n");
        for (Integer key : collectionStorage.getKeysSet()) {
            output.add(key + " = " + collectionStorage.getSpaceMarine(key).toString());
        }
        return new CommandResult(false, output.toString());
    }

}
