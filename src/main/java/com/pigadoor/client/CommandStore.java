package com.pigadoor.client;

import com.pigadoor.client.commands.ClearCommand;
import com.pigadoor.client.commands.Command;
import com.pigadoor.client.commands.CountLessThanHeightCommand;
import com.pigadoor.client.commands.ExecuteScriptCommand;
import com.pigadoor.client.commands.ExitCommand;
import com.pigadoor.client.commands.FilterGreaterThanHealthCommand;
import com.pigadoor.client.commands.HelpCommand;
import com.pigadoor.client.commands.HistoryCommand;
import com.pigadoor.client.commands.InfoCommand;
import com.pigadoor.client.commands.InsertCommand;
import com.pigadoor.client.commands.PrintDescendingCommand;
import com.pigadoor.client.commands.RemoveGreaterCommand;
import com.pigadoor.client.commands.RemoveKeyCommand;
import com.pigadoor.client.commands.RemoveLowerKeyCommand;
import com.pigadoor.client.commands.SaveCommand;
import com.pigadoor.client.commands.ShowCommand;
import com.pigadoor.client.commands.UpdateCommand;

import java.util.HashSet;

/**
 * This class stores instances of all commands
 */
public class CommandStore {

    private final HashSet<Command> commands = new HashSet<>();

    /**
     * Constructs a CommandStore object with the specified CollectionStorage and UserInputManager.
     *
     * @param collectionStorage The CollectionStorage object to be used by the commands.
     * @param userInputManager  The UserInputManager object to be used by the commands.
     */
    public CommandStore(CollectionStorage collectionStorage, UserInputManager userInputManager) {
        commands.add(new HelpCommand());
        commands.add(new InfoCommand(collectionStorage));
        commands.add(new ShowCommand(collectionStorage));
        commands.add(new InsertCommand(collectionStorage, userInputManager));
        commands.add(new UpdateCommand(collectionStorage, userInputManager));
        commands.add(new RemoveKeyCommand(collectionStorage));
        commands.add(new ClearCommand(collectionStorage));
        commands.add(new SaveCommand(collectionStorage));
        commands.add(new ExecuteScriptCommand(userInputManager));
        commands.add(new ExitCommand());
        commands.add(new RemoveGreaterCommand(collectionStorage, userInputManager));
        commands.add(new HistoryCommand());
        commands.add(new RemoveLowerKeyCommand(collectionStorage));
        commands.add(new CountLessThanHeightCommand(collectionStorage));
        commands.add(new FilterGreaterThanHealthCommand(collectionStorage));
        commands.add(new PrintDescendingCommand(collectionStorage));
    }

    /**
     * Returns the set of all commands stored in the CommandStore.
     *
     * @return The set of all commands stored in the CommandStore.
     */
    public HashSet<Command> getCommands() {
        return commands;
    }
}
