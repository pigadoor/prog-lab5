package com.pigadoor.client.commands;

/**
 * The ExitCommand class represents a command to exit the program.
 * It extends the Command class.
 */
public class ExitCommand extends Command {

    /**
     * Constructs an ExitCommand object.
     * The command name is set to "exit".
     */
    public ExitCommand() {
        super("exit");
    }

    /**
     * Executes the exit command with the specified argument.
     *
     * @param arg The argument for the exit command (not used in this case).
     * @return A CommandResult object indicating that the program should exit.
     */
    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(true, "Exiting...");
    }
}
