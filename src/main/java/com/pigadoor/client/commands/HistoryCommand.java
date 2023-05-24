package com.pigadoor.client.commands;

import com.pigadoor.client.Logger;

import java.util.StringJoiner;

/**
 * The HistoryCommand class represents a command to display the command history.
 * It extends the Command class.
 */
public class HistoryCommand extends Command {

    /**
     * Constructs a HistoryCommand object.
     * The command name is set to "history".
     */
    public HistoryCommand() {
        super("history");
    }

    /**
     * Executes the history command.
     *
     * @param inputArg The input argument for the history command (not used).
     * @return A CommandResult object containing the command history.
     *         If the history is empty, it returns a message indicating that the history is empty.
     */
    @Override
    public CommandResult execute(String inputArg) {
        if (Logger.getAll().isEmpty()) {
            return new CommandResult(false, "The history is empty");
        }
        StringJoiner output = new StringJoiner("\n");
        for (String command : Logger.getAll()) {
            output.add(command);
        }
        return new CommandResult(false, output.toString());
    }
}
