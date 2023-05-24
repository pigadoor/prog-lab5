package com.pigadoor.client.commands;

/**
 * The CommandResult class represents the result of executing a command.
 * It contains the command's message and an indicator if the command execution should result in an exit.
 */
public class CommandResult {
    private final String message;
    private final boolean exit;

    /**
     * Constructs a CommandResult object with the specified exit status and message.
     *
     * @param exit    A boolean indicating if the command execution should result in an exit.
     * @param message The message associated with the command result.
     */
    public CommandResult(boolean exit, String message) {
        this.exit = exit;
        this.message = message;
    }

    /**
     * Returns the message associated with the command result.
     *
     * @return The message associated with the command result.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Checks if the command execution should result in an exit.
     *
     * @return true if the command execution should result in an exit, false otherwise.
     */
    public boolean isExit() {
        return exit;
    }
}
