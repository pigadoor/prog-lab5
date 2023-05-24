package com.pigadoor.client.data;

/**
 * Chapter of SpaceMarine
 */
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;

    /**
     * Constructs a new instance of Chapter with the specified name and parent legion.
     *
     * @param name          The name of the chapter.
     * @param parentLegion  The parent legion of the chapter.
     */
    public Chapter(String name, String parentLegion) {
        this.name = name;
        this.parentLegion = parentLegion;
    }

    /**
     * Retrieves the name of the chapter.
     *
     * @return The name of the chapter.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the chapter.
     *
     * @param name The name of the chapter to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the parent legion of the chapter.
     *
     * @return The parent legion of the chapter.
     */
    public String getParentLegion() {
        return parentLegion;
    }

    /**
     * Sets the parent legion of the chapter.
     *
     * @param parentLegion The parent legion of the chapter to be set.
     */
    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }

    /**
     * Returns a string representation of the Chapter object.
     *
     * @return A string representation of the Chapter object.
     */
    @Override
    public String toString() {
        return "Chapter{"
                + "name=" + name
                + ", parentLegion=" + parentLegion
                + '}';
    }


}
