package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

/**
 * The RemoveLowerKeyCommand class represents a command to remove all elements with keys lower than the specified key from the collection.
 * It extends the Command class.
 */
public class RemoveLowerKeyCommand extends Command {
    private final CollectionStorage collectionStorage;

    /**
     * Constructs a RemoveLowerKeyCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     */
    public RemoveLowerKeyCommand(CollectionStorage collectionStorage) {
        super("remove_lower_key");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the remove lower key command by removing all elements with keys lower than the specified key from the collection.
     *
     * @param arg The input argument for the command, which represents the key.
     * @return A CommandResult object indicating the status of the command execution.
     *         If the key is valid and elements are removed, it returns a message indicating successful removal.
     *         If the key is not valid, it returns a message indicating that the key should be an integer number.
     *         If the key is empty, it returns a message indicating that an argument is required.
     */
    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        }
        try {
            Integer key = Integer.valueOf(arg);
            collectionStorage.removeLowerKey(key);
            return new CommandResult(false, "The elements have been removed");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
        }
    }
}
