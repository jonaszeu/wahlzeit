package org.wahlzeit.model;

/*
 * Classname: Coordinate
 *
 * Version information: v1.0
 *
 * Date: 23.10.2018
 *
 * Copyright notice: -
 */

public class Coordinate {

    // Coordinate variables with default values
    private double x = 0.00;
    private double y = 0.00;
    private double z = 0.00;

    // Constructors

    /**
     *
     */
    public Coordinate(){
        // Keep Default values x:0, y:0, z:0
    }

    /**
     *
     */
    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Functions

    /**
     * @methodtype boolean-query
     */
    public boolean isEqual(Coordinate coordinate){
        if(this.x == coordinate.getX() && this.y == coordinate.getY() && this.z == coordinate.getZ()){
            return true;
        }
        return false;
    }

    /**
     * Calculates and returns the direct cartesian distance
     */
    public double getDistance(Coordinate coordinate){
        if(this.isEqual(coordinate)){
            return 0;
        }

        // Direct Cartesian distance
        double distance = Math.sqrt(Math.pow(this.x-coordinate.x,2)+Math.pow(this.y-coordinate.y,2)+Math.pow(this.z-coordinate.z,2));

        return distance;
    }

    // Getter and Setter

    /**
     * @methodtype get
     */
    public double getX(){
        return this.x;
    }

    /**
     * @methodtype get
     */
    public double getY(){
        return this.y;
    }

    /**
     * @methodtype get
     */
    public double getZ(){
        return this.z;
    }

    /**
     * @methodtype set
     */
    public void setX(double newX){
        this.x = newX;
    }

    /**
     * @methodtype set
     */
    public void setY(double newY){
        this.y = newY;
    }

    /**
     * @methodtype set
     */
    public void setZ(double newZ){
        this.z = newZ;
    }
}
