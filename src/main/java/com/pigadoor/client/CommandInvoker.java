package com.pigadoor.client;

import com.pigadoor.client.commands.Command;
import com.pigadoor.client.commands.CommandResult;

/**
 * This class invoker instances of command
 */
public class CommandInvoker {

    private final CommandStore commandStore;

    /**
     * Constructs a CommandInvoker object with the specified CommandStore.
     *
     * @param commandStore The CommandStore containing the available commands.
     */
    public CommandInvoker(CommandStore commandStore) {
        this.commandStore = commandStore;
    }

    /**
     * Runs the command with the given name and argument.
     *
     * @param name The name of the command to run.
     * @param arg  The argument for the command.
     * @return The CommandResult indicating the result of executing the command.
     */
    public CommandResult runCommand(String name, String arg) {

        for (Command command: commandStore.getCommands()) {
            if (command.getName().equals(name)) {
                Logger.log(command.getName());
                return command.execute(arg);
            }
        }
        return new CommandResult(false, "Command not found. Use \"help\" to get information about commands");

    }
}