package com.pigadoor.client.commands;

import com.pigadoor.client.UserInputManager;

/**
 * The ExecuteScriptCommand class represents a command to execute a script file.
 * It extends the Command class.
 */
public class ExecuteScriptCommand extends Command {
    private final UserInputManager userInputManager;

    /**
     * Constructs an ExecuteScriptCommand object with the specified UserInputManager instance.
     *
     * @param userInputManager The UserInputManager instance used to manage user input and script execution.
     */
    public ExecuteScriptCommand(UserInputManager userInputManager) {
        super("execute_script");
        this.userInputManager = userInputManager;
    }

    /**
     * Executes the execute_script command with the specified argument.
     * The argument represents the file path of the script to be executed.
     *
     * @param arg The argument for the execute_script command, representing the file path of the script.
     * @return A CommandResult object containing the result of the command execution.
     */
    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the file path:");
        }
        userInputManager.connectToFile(arg);

        return new CommandResult(false, "");
    }
}
