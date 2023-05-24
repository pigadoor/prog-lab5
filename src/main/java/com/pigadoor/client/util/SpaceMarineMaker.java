package com.pigadoor.client.util;

import com.pigadoor.client.CollectionStorage;
import com.pigadoor.client.data.MeleeWeapon;
import com.pigadoor.client.data.SpaceMarine;
import com.pigadoor.client.UserInputManager;

import java.util.Arrays;

/**
 * Utility class for creating SpaceMarine objects based on user input.
 */
public class SpaceMarineMaker {

    private final UserInputManager userInputManager;
    private final ChapterMaker chapterMaker;
    private final CoordinatesMaker coordinatesMaker;

    /**
     * Constructs a SpaceMarineMaker object.
     *
     * @param userInputManager The UserInputManager instance to use for user input.
     */
    public SpaceMarineMaker(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
        this.chapterMaker = new ChapterMaker(userInputManager);
        this.coordinatesMaker = new CoordinatesMaker(userInputManager);;
    }

    /**
     * Creates a SpaceMarine object based on user input and the CollectionStorage.
     *
     * @param collectionStorage The CollectionStorage instance.
     * @return The created SpaceMarine object.
     */
    public SpaceMarine makeSpaceMarine(CollectionStorage collectionStorage) {
        return new SpaceMarine(collectionStorage,
                getInputName(),
                coordinatesMaker.makeCoordinates(),
                getInputHealth(),
                getInputHeartCount(),
                getInputHeight(),
                getInputMeleeWeapon(),
                chapterMaker.makeChapter());
    }

    /**
     * Creates a SpaceMarine object with the specified ID based on user input.
     *
     * @param id The ID of the SpaceMarine object.
     * @return The created SpaceMarine object.
     */
    public SpaceMarine makeSpaceMarine(Integer id) {
        return new SpaceMarine(id,
                getInputName(),
                coordinatesMaker.makeCoordinates(),
                getInputHealth(),
                getInputHeartCount(),
                getInputHeight(),
                getInputMeleeWeapon(),
                chapterMaker.makeChapter());
    }

    /**
     * Prompts the user for input and retrieves the name.
     *
     * @return The input name.
     */
    public String getInputName() {
        System.out.println("Enter NAME: (Поле не может быть null, Строка не может быть пустой)");

        String name = null;
        while (name == null) {
            name = SpaceMarineConverter.convertToName(userInputManager.readLine());
        }
        return name;
    }

    /**
     * Prompts the user for input and retrieves the health value.
     *
     * @return The input health value.
     */
    public float getInputHealth() {
        System.out.println("Enter HEALTH (Значение поля должно быть больше 0):");
        Float health = null;
        while (health == null) {
            health = SpaceMarineConverter.convertToHealth(userInputManager.readLine());
        }
        return health;
    }

    /**
     * Prompts the user for input and retrieves the heart count.
     *
     * @return The input heart count.
     */
    public Long getInputHeartCount() {
        System.out.println("Enter HEART COUNT (Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3):");
        Long heartCount = null;
        while (heartCount == null) {
            heartCount = SpaceMarineConverter.convertToHeartCount(userInputManager.readLine());
        }
        return heartCount;
    }

    /**
     * Prompts the user for input and retrieves the height.
     *
     * @return The input height.
     */
    public Integer getInputHeight() {
        System.out.println("Enter HEIGHT:");
        Integer height = null;
        while (height == null) {
            height = SpaceMarineConverter.convertToHeight(userInputManager.readLine());
        }
        return height;
    }

    /**
     * Prompts the user for input and retrieves the melee weapon.
     *
     * @return The input melee weapon.
     */
    public MeleeWeapon getInputMeleeWeapon() {
        System.out.println(Arrays.toString(MeleeWeapon.values()));
        System.out.println("Enter the MELEE WEAPON exactly as it is printed above: ");

        MeleeWeapon meleeWeapon = null;
        while (meleeWeapon == null) {
            meleeWeapon = SpaceMarineConverter.convertToMeleeWeapon(userInputManager.readLine().toUpperCase());
        }
        return meleeWeapon;
    }

    /**
     * Utility class for converting user input values to the corresponding data types.
     */
    public static class SpaceMarineConverter {

        /**
         * Converts the input to a name value.
         *
         * @param input The input string.
         * @return The converted name value.
         */
        public static String convertToName(String input) {
            if (input.isEmpty()) {
                System.out.println("Cannot be an empty string. Please try again:");
                return null;
            }
            return input;
        }

        /**
         * Converts the input to a health value.
         *
         * @param input The input string.
         * @return The converted health value.
         */
        public static Float convertToHealth(String input) {

            if (input.isEmpty()) {
                return 0f;
            }
            try {
                float height = Float.parseFloat(input);
                if (height <= 0) {
                    System.out.println("Please enter numerical value (больше 0)");
                    return null;
                }
                return height;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value (больше 0)");
                return null;
            }

        }

        /**
         * Converts the input to a height value.
         *
         * @param input The input string.
         * @return The converted height value.
         */
        public static Integer convertToHeight(String input) {
            if (input == null) {
                return null;
            }
            if (input.isEmpty()) {
                return null;
            }
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                return null;
            }

        }

        /**
         * Converts the input to a heart count value.
         *
         * @param input The input string.
         * @return The converted heart count value.
         */
        public static Long convertToHeartCount(String input) {

            if (input.isEmpty()) {
                System.out.println("Cannot be null. Please try again:");
                return null;
            }
            try {
                long heartCount = Long.parseLong(input);
                final int max = 3;
                if (heartCount > max || heartCount <= 0) {
                    System.out.println("Please enter numerical value (от 0 до 3):");
                    return null;
                }
                return heartCount;
            } catch (NumberFormatException e) {
                System.out.println("Please enter numerical value (от 0 до 3):");
                return null;
            }
        }

        /**
         * Converts the input to a MeleeWeapon value.
         *
         * @param input The input string.
         * @return The converted MeleeWeapon value.
         */
        public static MeleeWeapon convertToMeleeWeapon(String input) {

            MeleeWeapon meleeWeapon = null;

            switch (input) {
                case "CHAIN_SWORD" -> meleeWeapon = MeleeWeapon.CHAIN_SWORD;
                case "POWER_SWORD" -> meleeWeapon = MeleeWeapon.POWER_SWORD;
                case "MANREAPER" -> meleeWeapon = MeleeWeapon.MANREAPER;
                case "LIGHTING_CLAW" -> meleeWeapon = MeleeWeapon.LIGHTING_CLAW;
                case "POWER_FIST" -> meleeWeapon = MeleeWeapon.POWER_FIST;
                default -> System.out.println("Wrong input. Please try again:");
            }
            return meleeWeapon;
        }

    }
}
