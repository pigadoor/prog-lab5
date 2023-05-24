package com.pigadoor.client.data;

/**
 * Coordinates of SpaceMarine represented by x, y coordinates
 */
public class Coordinates {
    private Double x; //Поле не может быть null
    private Float y; //Максимальное значение поля: 589, Поле не может быть null


    /**
     * Constructs a new instance of Coordinates with the specified x and y coordinates.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public Coordinates(Double x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x-coordinate.
     *
     * @return The x-coordinate.
     */
    public Double getX() {
        return x;
    }

    /**
     * Sets the x-coordinate.
     *
     * @param x The x-coordinate to be set.
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Retrieves the y-coordinate.
     *
     * @return The y-coordinate.
     */
    public Float getY() {
        return y;
    }

    /**
     * Sets the y-coordinate.
     *
     * @param y The y-coordinate to be set.
     */
    public void setY(Float y) {
        this.y = y;
    }

    /**
     * Returns a string representation of the Coordinates object.
     *
     * @return A string representation of the Coordinates object.
     */
    @Override
    public String toString() {
        return "Coordinates{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }

}
