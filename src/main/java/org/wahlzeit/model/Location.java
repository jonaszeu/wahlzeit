package org.wahlzeit.model;

/*
 * Classname: Location
 *
 * Version information: v1.0
 *
 * Date: 23.10.2018
 *
 * Copyright notice: AGPLv3
 */

public class Location {

    private CartesianCoordinate coordinate = null;
    private String description = ""; // Optional can describe the location

    public Location(CartesianCoordinate coordinate){
        this.coordinate = coordinate;
    }

    public Location(CartesianCoordinate coordinate, String description){
        this.coordinate = coordinate;
        this.description = description;
    }

    // Getter and Setter

    /**
     * @methodtype set
     */
    public void setCoordinate(CartesianCoordinate coordinate){
        this.coordinate = coordinate;
    }

    /**
     * @methodtype get
     */
    public CartesianCoordinate getCoordinate(){
        return this.coordinate;
    }

    /**
     * @methodtype set
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * @methodtype get
     */
    public String getDescription(){
        return this.description;
    }
}
