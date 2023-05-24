package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;
import com.pigadoor.client.data.SpaceMarine;
import com.pigadoor.client.UserInputManager;
import com.pigadoor.client.util.SpaceMarineMaker;

/**
 * The InsertCommand class represents a command to insert a new element into the collection.
 * It extends the Command class.
 */
public class InsertCommand extends Command {
    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    /**
     * Constructs an InsertCommand object with the specified CollectionStorage and UserInputManager.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     * @param userInputManager  The UserInputManager object for reading user input.
     */
    public InsertCommand(CollectionStorage collectionStorage, UserInputManager userInputManager) {
        super("insert");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    /**
     * Executes the insert command by adding a new element to the collection.
     *
     * @param arg The input argument for the insert command, which is the key of the new element.
     * @return A CommandResult object indicating the result of the insert operation.
     *         If the key is already present in the collection, an error message is returned.
     *         If the key is valid and the element is successfully added, a success message is returned.
     *         If the key is not a valid integer, an error message is returned.
     */
    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        }
        try {
            Integer key = Integer.valueOf(arg);
            if (collectionStorage.containsKey(key)) {
                return new CommandResult(false, "Collection already contains an element with this key.");
            }
            SpaceMarine newSpaceMarine = new SpaceMarineMaker(userInputManager).makeSpaceMarine(collectionStorage);
            collectionStorage.add(key, newSpaceMarine);
            return new CommandResult(false, "The element has been added");
        } catch (NumberFormatException e) {
            return new CommandResult(false, "KEY must be an integer number. Use \"show\" to get information about elements\n");
        }
    }
}
