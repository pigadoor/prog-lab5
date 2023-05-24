package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

import java.util.StringJoiner;

/**
 * The PrintDescendingCommand class represents a command to print the elements of the collection in descending order.
 * It extends the Command class.
 */
public class PrintDescendingCommand extends Command {

    private final CollectionStorage collectionStorage;

    /**
     * Constructs a PrintDescendingCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     */
    public PrintDescendingCommand(CollectionStorage collectionStorage) {
        super("print_descending");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the print descending command by printing the elements of the collection in descending order.
     *
     * @param inputArg The input argument for the command (not used in this command).
     * @return A CommandResult object containing the elements of the collection in descending order.
     *         If the collection is empty, an error message is returned.
     *         Otherwise, the elements are returned in the format "key = element".
     */
    @Override
    public CommandResult execute(String inputArg) {
        if (collectionStorage.getTreeMap().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        }

        StringJoiner output = new StringJoiner("\n\n");
        for (Integer key : collectionStorage.getDescendingKeysSet()) {
            output.add(key + " = " + collectionStorage.getSpaceMarine(key).toString());
        }
        return new CommandResult(false, output.toString());
    }
}
