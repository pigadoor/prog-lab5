package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;

/**
 * The CountLessThanHeightCommand class represents a command to count the number of elements with height less than a specified value.
 * It extends the Command class.
 */
public class CountLessThanHeightCommand extends Command {

    private final CollectionStorage collectionStorage;

    /**
     * Constructs a CountLessThanHeightCommand object with the specified CollectionStorage instance.
     *
     * @param collectionStorage The CollectionStorage instance used to perform the command operation.
     */
    public CountLessThanHeightCommand(CollectionStorage collectionStorage) {
        super("count_less_than_height");
        this.collectionStorage = collectionStorage;
    }

    /**
     * Executes the count_less_than_height command with the specified argument.
     * The argument represents the height value to compare against the elements in the collection.
     *
     * @param arg The argument for the count_less_than_height command, representing the height value.
     * @return A CommandResult object containing the result of the command execution.
     */
    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the substring:");
        }

        try {
            Float height = Float.valueOf(arg);
            Integer count = collectionStorage.countLessThanHeight(height);
            return new CommandResult(false, "Count: " + count);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "HEIGHT is a float number. Use \"show\" to get information about elements\n");
        }

    }
}
