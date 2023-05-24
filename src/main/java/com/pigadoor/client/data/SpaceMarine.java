package com.pigadoor.client.data;

import com.pigadoor.client.CollectionStorage;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Main class that stored in collection
 */
public class SpaceMarine implements Comparable<SpaceMarine> {

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float health; //Значение поля должно быть больше 0
    private Long heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    private float height; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    /**
     * Default constructor for the SpaceMarine class.
     */
    public SpaceMarine() {}

    /**
     * Constructor for the SpaceMarine class.
     * Initializes the SpaceMarine object with the provided parameters.
     *
     * @param collectionStorage The collection storage object.
     * @param name              The name of the Space Marine.
     * @param coordinates       The coordinates of the Space Marine.
     * @param health            The health of the Space Marine.
     * @param heartCount        The heart count of the Space Marine.
     * @param height            The height of the Space Marine.
     * @param meleeWeapon       The melee weapon of the Space Marine.
     * @param chapter           The chapter of the Space Marine.
     */
    public SpaceMarine(CollectionStorage collectionStorage,
                       String name,
                       Coordinates coordinates,
                       float health,
                       Long heartCount,
                       int height,
                       MeleeWeapon meleeWeapon,
                       Chapter chapter){
        this.id = collectionStorage.getMaxId() + 1;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDateTime.now();
        this.health = health;
        this.heartCount = heartCount;
        this.height = height;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    /**
     * Constructor for the SpaceMarine class.
     * Initializes the SpaceMarine object with the provided parameters.
     *
     * @param id           The ID of the Space Marine.
     * @param name         The name of the Space Marine.
     * @param coordinates  The coordinates of the Space Marine.
     * @param health       The health of the Space Marine.
     * @param heartCount   The heart count of the Space Marine.
     * @param height       The height of the Space Marine.
     * @param meleeWeapon  The melee weapon of the Space Marine.
     * @param chapter      The chapter of the Space Marine.
     */
    public SpaceMarine(int id,
                       String name,
                       Coordinates coordinates,
                       float health,
                       Long heartCount,
                       int height,
                       MeleeWeapon meleeWeapon,
                       Chapter chapter){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDateTime.now();
        this.health = health;
        this.heartCount = heartCount;
        this.height = height;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    /**
     * Constructor for the SpaceMarine class.
     * Initializes the SpaceMarine object with the provided parameters.
     *
     * @param id           The ID of the Space Marine.
     * @param name         The name of the Space Marine.
     * @param coordinates  The coordinates of the Space Marine.
     * @param creationDate The creation date of the Space Marine.
     * @param health       The health of the Space Marine.
     * @param heartCount   The heart count of the Space Marine.
     * @param height       The height of the Space Marine.
     * @param meleeWeapon  The melee weapon of the Space Marine.
     * @param chapter      The chapter of the Space Marine.
     */
    public SpaceMarine(int id, String name, Coordinates coordinates, LocalDateTime creationDate, int health,
                       Long heartCount, float height, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.heartCount = heartCount;
        this.height = height;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    /**
     * Returns a string representation of the SpaceMarine object.
     *
     * @return A string representation of the SpaceMarine object.
     */
    @Override
    public String toString() {
        return "Person{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", coordinates=" + coordinates
                + ", creationDate=" + creationDate
                + ", health=" + health
                + ", heartCount=" + heartCount
                + ", height=" + height
                + ", meleeWeapon=" + meleeWeapon
                + ", chapter=" + chapter
                + '}';
    }

    /**
     * Sets the ID of the Space Marine.
     *
     * @param id The ID value to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the Space Marine.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the coordinates of the Space Marine.
     *
     * @param coordinates The coordinates to set.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets the creation date of the Space Marine.
     *
     * @param creationDate The creation date to set.
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets the health of the Space Marine.
     *
     * @param health The health value to set.
     */
    public void setHealth(float health) {
        this.health = health;
    }

    /**
     * Sets the heart count of the Space Marine.
     *
     * @param heartCount The heart count value to set.
     */
    public void setHeartCount(Long heartCount) {
        this.heartCount = heartCount;
    }

    /**
     * Sets the height of the Space Marine.
     *
     * @param height The height value to set.
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Sets the melee weapon of the Space Marine.
     *
     * @param meleeWeapon The melee weapon to set.
     */
    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    /**
     * Sets the chapter of the Space Marine.
     *
     * @param chapter The chapter to set.
     */
    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    /**
     * Returns the ID of the Space Marine.
     *
     * @return The ID of the Space Marine.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the name of the Space Marine.
     *
     * @return The name of the Space Marine.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health of the Space Marine.
     *
     * @return The health of the Space Marine.
     */
    public float getHealth() {
        return health;
    }

    /**
     * Returns the heart count of the Space Marine.
     *
     * @return The heart count of the Space Marine.
     */
    public Long getHeartCount() {
        return heartCount;
    }

    /**
     * Returns the height of the Space Marine.
     *
     * @return The height of the Space Marine.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Returns the melee weapon of the Space Marine.
     *
     * @return The melee weapon of the Space Marine.
     */
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    /**
     * Returns the chapter of the Space Marine.
     *
     * @return The chapter of the Space Marine.
     */
    public Chapter getChapter() {
        return chapter;
    }

    /**
     * Returns the coordinates of the Space Marine.
     *
     * @return The coordinates of the Space Marine.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Returns the creation date of the Space Marine.
     *
     * @return The creation date of the Space Marine.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Checks if this Space Marine is equal to the specified object.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceMarine that = (SpaceMarine) o;
        return Objects.equals(id, that.id) && Float.compare(that.health, health) == 0 && Float.compare(that.height, height) == 0 && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(heartCount, that.heartCount) && meleeWeapon == that.meleeWeapon && Objects.equals(chapter, that.chapter);
    }

    /**
     * Computes the hash code value for the Space Marine.
     *
     * @return The hash code value for the Space Marine.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, health, heartCount, height, meleeWeapon, chapter);
    }

    /**
     * Compares this Space Marine with another Space Marine object for order based on their height.
     *
     * @param o The Space Marine to be compared.
     * @return A negative integer, zero, or a positive integer if this Space Marine is less than, equal to, or greater
     *         than the specified Space Marine.
     */
    public int compareTo(SpaceMarine o) {
        return (int) (this.height - o.getHeight());
    }

    /**
     * Compares this Space Marine's height with the specified height for order.
     *
     * @param height The height to be compared.
     * @return A negative integer, zero, or a positive integer if this Space Marine's height is less than, equal to, or
     *         greater than the specified height.
     */
    public int compareTo(Float height) {
        return (int) (this.height - height);
    }
}
