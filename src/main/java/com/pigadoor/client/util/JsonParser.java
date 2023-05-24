package com.pigadoor.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import com.pigadoor.client.data.Coordinates;
import com.pigadoor.client.data.SpaceMarine;
import com.pigadoor.client.data.SpaceMarineWrapper;
import com.pigadoor.client.data.Chapter;

import com.pigadoor.client.parsers.ChapterParser;
import com.pigadoor.client.parsers.CoordinatesParser;
import com.pigadoor.client.parsers.LocalDateTimeSerializer;
import com.pigadoor.client.parsers.SpaceMarineParser;
import com.pigadoor.client.parsers.SpaceMarinesParser;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Utility class for parsing JSON data.
 */
public final class JsonParser {

    /**
     * The Gson instance used for JSON parsing.
     */
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(SpaceMarine.class, new SpaceMarineParser())
            .registerTypeAdapter(Chapter.class, new ChapterParser())
            .registerTypeAdapter(Coordinates.class, new CoordinatesParser())
            .registerTypeAdapter(TreeMap.class, new SpaceMarinesParser())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .create();

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private JsonParser() {}


    /**
     * Converts a JSON string to a list of objects of the specified class.
     *
     * @param s     The JSON string to convert.
     * @param clazz The class of the objects in the list.
     * @param <T>   The type of the objects in the list.
     * @return The list of objects created from the JSON string.
     */
    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        try {
            T[] arr = gson.fromJson(s, clazz);
            if (arr == null) {
                return new ArrayList<>();
            }
            return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
        } catch (JsonSyntaxException jsonSyntaxException) {
            return new ArrayList<T>();
        }
    }

    /**
     * Deserializes a JSON string into a TreeMap of SpaceMarine objects.
     *
     * @param data The JSON string to deserialize.
     * @return The TreeMap of SpaceMarine objects.
     */
    public static TreeMap<Integer, SpaceMarine> deserialize(String data) {
        List<SpaceMarine> linkedList = stringToArray(data, SpaceMarine[].class);
        //SpaceMarine[] array = gson.fromJson(data, LinkedList.class);
        TreeMap<Integer, SpaceMarine> collection = new TreeMap<>();
        if (linkedList == null) {
            return new TreeMap<>();
        } else {
            for (SpaceMarine current : linkedList) {
                if (current == null) continue;
                if (validateSpaceMarine(current)) {
                    collection.put(current.getId(), current);
                }
            }
            return collection;
        }
    }

    /**
     * Validates a SpaceMarine object for required fields.
     *
     * @param spaceMarine The SpaceMarine object to validate.
     * @return {@code true} if the SpaceMarine object is valid, {@code false} otherwise.
     */
    private static  boolean validateSpaceMarine(SpaceMarine spaceMarine) {
        if (spaceMarine.getId() == null) return false;
        if (spaceMarine.getId() <= 0) return false;
        if (spaceMarine.getName() == null) return false;
        if (spaceMarine.getName().isEmpty()) return false;
        if (spaceMarine.getCoordinates() == null) return false;
        if (spaceMarine.getCoordinates().getX() == null) return false;
        if (spaceMarine.getCoordinates().getY() == null) return false;
        if (spaceMarine.getCoordinates().getY() > 589) return false;
        if (spaceMarine.getCreationDate() == null) return false;
        if (spaceMarine.getHealth() <= 0) return false;
        if (spaceMarine.getHeartCount() == null) return false;
        if (spaceMarine.getHeartCount() <= 0) return false;
        if (spaceMarine.getHeartCount() > 3) return false;
        if (spaceMarine.getMeleeWeapon() == null) return false;
        if (spaceMarine.getChapter() != null) {
            if (spaceMarine.getChapter().getName() == null) {
                return false;
            }
            if (spaceMarine.getChapter().getName().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Serializes a TreeMap of SpaceMarine objects into a JSON string.
     *
     * @param collection The TreeMap of SpaceMarine objects to serialize.
     * @return The JSON string representing the serialized objects.
     */
    public static String serialize(TreeMap<Integer, SpaceMarine> collection) {
        List<SpaceMarineWrapper> list = new ArrayList<>();
        for (Map.Entry<Integer, SpaceMarine> entry : collection.entrySet()) {
            SpaceMarine spaceMarine = entry.getValue();
            SpaceMarineWrapper spaceMarineWrapper = new SpaceMarineWrapper();
            spaceMarineWrapper.setId(spaceMarine.getId());
            spaceMarineWrapper.setName(spaceMarine.getName());
            spaceMarineWrapper.setCoordinates(spaceMarine.getCoordinates());
            spaceMarineWrapper.setCreationDate(spaceMarine.getCreationDate().toString());
            spaceMarineWrapper.setHealth(spaceMarine.getHealth());
            spaceMarineWrapper.setHeartCount(spaceMarine.getHeartCount());
            spaceMarineWrapper.setHeight(spaceMarine.getHeight());
            spaceMarineWrapper.setMeleeWeapon(spaceMarine.getMeleeWeapon());
            spaceMarineWrapper.setChapter(spaceMarine.getChapter());
            list.add(spaceMarineWrapper);
        }

        return gson.toJson(list);
    }

}
