package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

/**
 * The ClearCommand class represents a command to clear the collection.
 * It extends the Command class.
 */
public class ClearCommand extends Command {
    private final CollectionStorage collectionStorage;

    /**
     * Constructs a ClearCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection to be cleared.
     */
    public ClearCommand(CollectionStorage collectionStorage) {
        super("clear");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the clear command, clearing the collection.
     *
     * @param inputArg The input argument (not used in this command).
     * @return The CommandResult object indicating the result of the command execution.
     */
    @Override
    public CommandResult execute(String inputArg) {
        collectionStorage.clear();
        return new CommandResult(false, "Collection has been cleared");
    }
}
