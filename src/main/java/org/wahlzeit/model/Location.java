package org.wahlzeit.model;

/*
 * Classname: Location
 *
 * Version information: v2.0
 *
 * Date: 09.12.2018
 *
 * Copyright notice: AGPLv3
 */

public class Location {

    private CartesianCoordinate coordinate = new CartesianCoordinate();
    private String description = ""; // Optional can describe the location

    public Location(CartesianCoordinate coordinate){
        setCoordinate(coordinate);
    }

    public Location(CartesianCoordinate coordinate, String description){
        setCoordinate(coordinate);
        setDescription(description);
    }

    /**
     * @methodtype set
     */
    public void setCoordinate(CartesianCoordinate coordinate){
        assertIsNonNullArgument(coordinate);
        assertClassInvariants();

        this.coordinate = coordinate;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     */
    public CartesianCoordinate getCoordinate(){ return this.coordinate; }

    /**
     * @methodtype set
     */
    public void setDescription(String description){
        assertIsValidDescription(description);
        assertClassInvariants();

        this.description = description;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNonNullArgument(CartesianCoordinate coordinate) throws NullPointerException{
        if(coordinate == null){
            throw new NullPointerException("Null is no acceptable argument.");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidDescription(String description) throws IllegalArgumentException{
        if(description == null){
            throw new IllegalArgumentException("Description can not be null.");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants(){
        assertIsNonNullArgument(this.coordinate);
        assertIsValidDescription(this.description);
    }
}
