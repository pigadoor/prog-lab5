package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;
import com.pigadoor.client.UserInputManager;
import com.pigadoor.client.util.SpaceMarineMaker;
import com.pigadoor.client.data.SpaceMarine;

/**
 * The UpdateCommand class represents a command to update an element in the collection.
 * It extends the Command class.
 */
public class UpdateCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    /**
     * Constructs an UpdateCommand object with the specified CollectionStorage and UserInputManager.
     *
     * @param collectionStorage The CollectionStorage object representing the collection.
     * @param userInputManager  The UserInputManager object for reading user input.
     */
    public UpdateCommand(CollectionStorage collectionStorage,
                         UserInputManager userInputManager) {
        super("update");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    /**
     * Executes the update command by updating the element with the specified ID in the collection.
     *
     * @param arg The input argument for the command, which should be the ID of the element to update.
     * @return A CommandResult object indicating the status of the command execution.
     *         It returns a message indicating whether the element was successfully updated or not.
     *         If there is no element with the specified ID, it returns a message indicating that.
     *         If the provided ID is not a valid integer, it returns a message indicating that.
     */
    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the id:");
        }
        try {
            Integer id = Integer.valueOf(arg);
            Integer key = collectionStorage.getMatchingKey(id);
            if (key != null) {
                SpaceMarine newSpaceMarine = new SpaceMarineMaker(userInputManager).makeSpaceMarine(id);
                collectionStorage.replace(key, newSpaceMarine);
                return new CommandResult(false, "The element has been updated");
            }
            return new CommandResult(false, "There's no element with this id. Use \"show\" to get information about elements");

        } catch (NumberFormatException e) {
            return new CommandResult(false, "ID is an integer number. Use \"show\" to get information about elements\n");
        }

    }
}
