package com.pigadoor.client.commands;

/**
 * The Command class is an abstract class representing a command.
 * Concrete command classes should extend this class and implement the execute method.
 */
public abstract class Command {
    private final String name;

    /**
     * Constructs a Command object with the specified name.
     *
     * @param name The name of the command.
     */
    public Command(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the command.
     *
     * @return The name of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the command with the specified argument.
     *
     * @param arg The argument for the command.
     * @return The CommandResult object indicating the result of the command execution.
     */
    public abstract CommandResult execute(String arg);
}

