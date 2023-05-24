package com.pigadoor.client.util;

import com.pigadoor.client.data.Chapter;
import com.pigadoor.client.UserInputManager;

/**
 * Utility class for creating Chapter objects based on user input.
 */
public class ChapterMaker {

    private final UserInputManager userInputManager;

    /**
     * Constructs a new instance of ChapterMaker with the specified UserInputManager.
     *
     * @param userInputManager The UserInputManager to use for reading user input.
     */
    public ChapterMaker(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    /**
     * Creates a new Chapter object based on user input.
     *
     * @return A new Chapter object.
     */
    public Chapter makeChapter() {
        return new Chapter(getInputName(), getInputParentLegion());
    }

    /**
     * Reads and validates the input for the parent legion from the user.
     *
     * @return The validated parent legion string.
     */
    private String getInputParentLegion() {
        System.out.println("Enter Parent Legion:");
        String parentLegion = null;
        while (parentLegion == null) {
            parentLegion = PersonConverter.convertToParentLegion(userInputManager.readLine());
        }
        return parentLegion;
    }

    /**
     * Reads and validates the input for the name from the user.
     *
     * @return The validated name string.
     */
    private String getInputName() {
        System.out.println("Enter NAME: (Поле не может быть null, Строка не может быть пустой)");

        String name = null;
        while (name == null) {
            name = PersonConverter.convertToName(userInputManager.readLine());
        }
        return name;
    }

    /**
     * A nested utility class for converting and validating input related to Chapter.
     */
    public static class PersonConverter {

        /**
         * Converts and validates the input string as a name.
         *
         * @param input The input string to convert and validate.
         * @return The converted and validated name string, or null if the input is invalid.
         */
        public static String convertToName(String input) {
            if (input.isEmpty()) {
                System.out.println("Cannot be an empty string. Please try again:");
                return null;
            }
            return input;
        }

        /**
         * Converts and validates the input string as a parent legion.
         *
         * @param input The input string to convert and validate.
         * @return The converted and validated parent legion string, or null if the input is invalid.
         */
        public static String convertToParentLegion(String input) {
            if (input.isEmpty()) {
                System.out.println("Please enter string:");
                return null;
            }
            return input;
        }
    }
}
