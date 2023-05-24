package com.pigadoor.client.commands;

import com.pigadoor.client.CollectionStorage;
import com.pigadoor.client.data.SpaceMarine;

import java.util.List;
import java.util.StringJoiner;

public class FilterGreaterThanHealthCommand extends Command {

    private final CollectionStorage collectionStorage;

    public FilterGreaterThanHealthCommand(CollectionStorage collectionStorage) {
        super("filter_greater_than_health");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the substring:");
        }
        if (collectionStorage.getTreeMap().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        }
        int health = Integer.parseInt(arg);
        List<SpaceMarine> list = collectionStorage.getMatchingHealth(health);
        StringJoiner output = new StringJoiner("\n\n");
        for (SpaceMarine spaceMarine : list) {
            output.add(spaceMarine.toString());
        }
        if (output.toString().isEmpty()) {
            return new CommandResult(false, "There aren't any elements whose name starts like this");
        }
        return new CommandResult(false, output.toString());

    }
}
