package com.pigadoor.client;

import com.pigadoor.client.data.SpaceMarine;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class storage instances of collections
 */
public class CollectionStorage {
    private TreeMap<Integer, SpaceMarine> treemap = new TreeMap<>();

    private java.time.LocalDate creationDate;


    /**
     * Returns the maximum ID value of SpaceMarine objects in the TreeMap.
     * @return The maximum ID value of SpaceMarine objects in the TreeMap.
     */
    public int getMaxId() {
        int maxID = 0;
        for (Map.Entry<Integer, SpaceMarine> treemapEntry : treemap.entrySet()) {
            SpaceMarine spacemarine = treemapEntry.getValue();
            if (spacemarine.getId() > maxID) {
                maxID = spacemarine.getId();
            }
        }
        return maxID;
    }

    /**
     * Returns the creation date of the TreeMap.
     * @return The creation date of the TreeMap.
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Returns the TreeMap containing Integer keys and SpaceMarine values.
     * @return The TreeMap containing Integer keys and SpaceMarine values.
     */
    public TreeMap<Integer, SpaceMarine> getTreeMap() {
        return treemap;
    }
    /**
     * Initializes the TreeMap with the provided fileTreeMap and sets the creation date to the current date.
     * @param fileTreeMap The TreeMap to initialize the current TreeMap with.
     */
    public void initializeTreeMap(TreeMap<Integer, SpaceMarine> fileTreeMap) {
        creationDate = LocalDate.now();
        treemap = fileTreeMap;
    }

    /**
     * Clears all elements from the TreeMap.
     */
    public void clear() {
        treemap.clear();
    }

    /**
     * Removes the entry with the specified key from the TreeMap.
     * @param key The key of the entry to be removed.
     */
    public void remove(Integer key) {
        treemap.remove(key);
    }

    /**
     * Adds a new entry to the TreeMap with the specified key and SpaceMarine object.
     * @param key The key of the entry to be added.
     * @param spacemarine The SpaceMarine object to be associated with the key.
     */
    public void add(Integer key, SpaceMarine spacemarine) {
        treemap.put(key, spacemarine);
    }

    /**
     * Replaces the value associated with the specified key in the TreeMap with the provided new SpaceMarine object.
     * @param key The key whose associated value is to be replaced.
     * @param newSpaceMarine The new SpaceMarine object to replace the existing value.
     */
    public void replace(Integer key, SpaceMarine newSpaceMarine) {
        treemap.replace(key, newSpaceMarine);
    }

    /**
     * Returns the SpaceMarine object associated with the specified key in the TreeMap.
     * @param key The key whose associated SpaceMarine object is to be retrieved.
     * @return The SpaceMarine object associated with the specified key, or null if the key is not found in the TreeMap.
     */
    public SpaceMarine getSpaceMarine(Integer key) {
        return treemap.get(key);
    }

    /**
     * Returns a set of keys from the TreeMap.
     *
     * @return A Set of Integer keys from the TreeMap.
     */
    public Set<Integer> getKeysSet() {
        return treemap.keySet();
    }

    /**
     * Returns a set of keys from the TreeMap in descending order.
     *
     * @return A Set of Integer keys from the TreeMap in descending order.
     */
    public Set<Integer> getDescendingKeysSet() {
        return treemap.descendingKeySet();
    }

    /**
     * Checks if the specified key is present in the TreeMap.
     *
     * @param key The key to be checked for existence.
     * @return true if the key is present in the TreeMap, false otherwise.
     */
    public boolean containsKey(Integer key) {
        return getKeysSet().contains(key);
    }

    /**
     * Retrieves the key associated with the specified ID value in the TreeMap.
     *
     * @param id The ID value to search for.
     * @return The key associated with the specified ID value, or null if not found.
     */
    public Integer getMatchingKey(Integer id) {
        for (Map.Entry<Integer, SpaceMarine> treemapEntry : treemap.entrySet()) {
            Integer currentKey = treemapEntry.getKey();
            SpaceMarine oldSpaceMarine = treemap.get(currentKey);

            if (oldSpaceMarine.getId().equals(id)) {
                return currentKey;
            }
        }
        return null;
    }

    /**
     * Removes all SpaceMarine objects from the TreeMap that have a greater compareTo value than the specified SpaceMarine.
     *
     * @param spaceMarine The SpaceMarine object to compare against.
     */
    public void removeGreaterSpaceMarine(SpaceMarine spaceMarine) {
        ArrayList<Integer> keys = new ArrayList<>();

        for (Map.Entry<Integer, SpaceMarine> treemapEntry : treemap.entrySet()) {
            Integer currentKey = treemapEntry.getKey();
            SpaceMarine oldSpaceMarine = treemap.get(currentKey);

            if (oldSpaceMarine.compareTo(spaceMarine) > 0) {
                keys.add(currentKey);
            }
        }
        for (Integer key : keys) {
            treemap.remove(key);
        }
    }

    /**
     * Removes all entries from the TreeMap that have keys lower than the specified key.
     *
     * @param key The key to compare against.
     */
    public void removeLowerKey(Integer key) {
        ArrayList<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, SpaceMarine> treemapEntry : treemap.entrySet()) {
            Integer currentKey = treemapEntry.getKey();

            if (currentKey < key) {
                keys.add(currentKey);
            }
        }
        for (Integer lowerKey : keys) {
            treemap.remove(lowerKey);
        }
    }

    /**
     * Counts the number of SpaceMarine objects in the TreeMap whose height is less than the specified height value.
     *
     * @param height The height value to compare against.
     * @return The count of SpaceMarine objects with height less than the specified value.
     */
    public Integer countLessThanHeight(Float height) {

        int count = 0;
        for (Map.Entry<Integer, SpaceMarine> treemapEntry : treemap.entrySet()) {
            Integer currentKey = treemapEntry.getKey();
            SpaceMarine oldSpaceMarine = treemap.get(currentKey);

            if (oldSpaceMarine.compareTo(height) < 0) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Retrieves a list of SpaceMarine objects from the TreeMap whose health is greater than the specified health value.
     *
     * @param health The health value to compare against.
     * @return A List of SpaceMarine objects with health greater than the specified value.
     */
    public List<SpaceMarine> getMatchingHealth(int health) {
        ArrayList<SpaceMarine> list = new ArrayList<>();

        for (Map.Entry<Integer, SpaceMarine> treemapEntry : treemap.entrySet()) {
            SpaceMarine spaceMarine = treemapEntry.getValue();
            if (spaceMarine.getHealth() > health) {
                list.add(spaceMarine);
            }
        }
        return list;
    }

    /**
     * Returns a NavigableMap view of the TreeMap in descending order.
     *
     * @return A NavigableMap view of the TreeMap in descending order.
     */
    public NavigableMap<Integer, SpaceMarine> getDescending() {
        return treemap.descendingMap();
    }

}
