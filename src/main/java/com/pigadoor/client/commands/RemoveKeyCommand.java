package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

/**
 * The RemoveKeyCommand class represents a command to remove an element from the collection by its key.
 * It extends the Command class.
 */
public class RemoveKeyCommand extends Command {
    private final CollectionStorage collectionStorage;

    /**
     * Constructs a RemoveKeyCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     */
    public RemoveKeyCommand(CollectionStorage collectionStorage) {
        super("remove_key");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the remove key command by removing the element with the specified key from the collection.
     *
     * @param arg The input argument for the command, which represents the key of the element to be removed.
     * @return A CommandResult object indicating the status of the command execution.
     *         If the key is valid and an element is removed, it returns a message indicating successful removal.
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
            if (collectionStorage.containsKey(key)){
                collectionStorage.remove(key);
            } else {
                return new CommandResult(false, "There is no element with this KEY");
            }
            return new CommandResult(false, "The element has been removed");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
        }
    }
}
