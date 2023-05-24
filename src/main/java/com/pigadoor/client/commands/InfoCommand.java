package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

/**
 * The InfoCommand class represents a command to display information about the collection.
 * It extends the Command class.
 */
public class InfoCommand extends Command {
    private final CollectionStorage collectionStorage;

    /**
     * Constructs an InfoCommand object with the specified CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     */
    public InfoCommand(CollectionStorage collectionStorage) {
        super("info");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the info command.
     *
     * @param inputArg The input argument for the info command (not used).
     * @return A CommandResult object containing information about the collection.
     *         It includes the type of the collection, the number of elements, and the creation date.
     */
    @Override
    public CommandResult execute(String inputArg) {
        return new CommandResult(false, "Тип коллекции "
                + collectionStorage.getTreeMap().getClass().toString() + "\n"
                + "Число элементов: " + collectionStorage.getTreeMap().size() + "\n"
                + "Дата создания: " + collectionStorage.getCreationDate());
    }
}
