package org.wahlzeit.model;

/*
 * Classname: Location
 *
 * Version information: v1.0
 *
 * Date: 23.10.2018
 *
 * Copyright notice: -
 */

public class Location {

    private Coordinate coordinate = null;
    private String description = ""; // Optional can describe the location

    public Location(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Location(Coordinate coordinate, String description){
        this.coordinate = coordinate;
        this.description = description;
    }

    // Getter and Setter

    /**
     * @methodtype set
     */
    public void setCoordinate(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    /**
     * @methodtype get
     */
    public Coordinate getCoordinate(){
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
