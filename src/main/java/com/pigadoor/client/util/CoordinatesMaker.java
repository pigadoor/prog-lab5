package com.pigadoor.client.util;

import com.pigadoor.client.data.Coordinates;
import com.pigadoor.client.UserInputManager;

/**
 * Utility class for creating Coordinates objects based on user input.
 */
public class CoordinatesMaker {
    private final UserInputManager userInputManager;

    /**
     * Constructs a new instance of CoordinatesMaker with the specified UserInputManager.
     *
     * @param userInputManager The UserInputManager to use for reading user input.
     */
    public CoordinatesMaker(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    /**
     * Creates a new Coordinates object based on user input.
     *
     * @return A new Coordinates object.
     */
    public Coordinates makeCoordinates() {
        return new Coordinates(getInputX(), getInputY());
    }

    /**
     * Reads and validates the input for the X coordinate from the user.
     *
     * @return The validated X coordinate value.
     */
    public Double getInputX() {
        System.out.println("Enter a double value of X coordinate (Поле не может быть null):");
        Double x = null;
        while (x == null || x > 172) {
            x = CoordinatesConverter.convertX(userInputManager.readLine());
        }
        return x;
    }

    /**
     * Reads and validates the input for the Y coordinate from the user.
     *
     * @return The validated Y coordinate value.
     */
    public Float getInputY() {
        System.out.println("Enter a float value of Y coordinate (Максимальное значение поля: 589, Поле не может быть null):");
        Float y = null;
        while (y == null) {
            y = CoordinatesConverter.convertY(userInputManager.readLine());
        }
        return y;
    }

    /**
     * A nested utility class for converting and validating input related to Coordinates.
     */
    public static class CoordinatesConverter {

        /**
         * Converts and validates the input string as an X coordinate.
         *
         * @param input The input string to convert and validate.
         * @return The converted and validated X coordinate value, or null if the input is invalid.
         */
        public static Double convertX(String input) {
            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value:");
                return null;
            }
        }

        /**
         * Converts and validates the input string as a Y coordinate.
         *
         * @param input The input string to convert and validate.
         * @return The converted and validated Y coordinate value, or null if the input is invalid.
         */
        public static Float convertY(String input) {
            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                float y = Float.parseFloat(input);
                final int max = 589;
                if (y > max) {
                    System.out.println("Please enter numerical value (не больше 589):");
                    return null;
                }
                return y;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value (не больше 589):");
                return null;
            }
        }
    }
}
