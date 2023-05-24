package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;
import com.pigadoor.client.util.FileManager;
import com.pigadoor.client.util.JsonParser;

/**
 * The SaveCommand class represents a command to save the collection to a file.
 * It extends the Command class.
 */
public class SaveCommand extends Command {
    private final CollectionStorage collectionStorage;

    /**
     * Constructs a SaveCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     */
    public SaveCommand(CollectionStorage collectionStorage) {
        super("save");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the save command by writing the collection to a file.
     *
     * @param inputArg The input argument for the command (not used in this command).
     * @return A CommandResult object indicating the status of the command execution.
     *         It returns a message indicating that the collection has been saved.
     */
    @Override
    public CommandResult execute(String inputArg) {
        FileManager.write(JsonParser.serialize(collectionStorage.getTreeMap()), FileManager.FILE_PATH);
        return new CommandResult(false, "Collection has been saved");
    }
}
