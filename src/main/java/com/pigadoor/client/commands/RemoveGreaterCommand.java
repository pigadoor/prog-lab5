package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;
import com.pigadoor.client.UserInputManager;
import com.pigadoor.client.util.SpaceMarineMaker;
import com.pigadoor.client.data.SpaceMarine;

/**
 * The RemoveGreaterCommand class represents a command to remove all elements from the collection
 * that are greater than a specified SpaceMarine.
 * It extends the Command class.
 */
public class RemoveGreaterCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    /**
     * Constructs a RemoveGreaterCommand object with the specified CollectionStorage and UserInputManager.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     * @param userInputManager  The UserInputManager object for user input.
     */
    public RemoveGreaterCommand(CollectionStorage collectionStorage, UserInputManager userInputManager) {
        super("remove_greater");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    /**
     * Executes the remove greater command by creating a SpaceMarine object from user input
     * and removing all elements from the collection that are greater than the specified SpaceMarine.
     *
     * @param arg The input argument for the command (not used in this command).
     * @return A CommandResult object indicating the status of the command execution.
     *         In this case, it returns a message indicating that lower elements were removed.
     */
    @Override
    public CommandResult execute(String arg) {
        SpaceMarine spaceMarine = new SpaceMarineMaker(userInputManager).makeSpaceMarine(collectionStorage);
        collectionStorage.removeGreaterSpaceMarine(spaceMarine);
        return new CommandResult(false, "Lower elements were removed");
    }
}
