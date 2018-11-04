package org.wahlzeit.model;

/*
 * Classname: Coordinate
 *
 * Version information: v1.0
 *
 * Date: 23.10.2018
 *
 * Copyright notice: AGPLv3
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
        setX(x);
        setY(y);
        setZ(z);
    }

    // Functions

    /**
     * @methodtype boolean-query
     */
    public boolean check_double(double d){
        if(Double.isFinite(d) && !Double.isNaN(d)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @methodtype boolean-query
     */
    public boolean isEqual(Coordinate coordinate){
        double epsilon = 0.0000001;

        if(Math.abs(coordinate.getX() - this.x) >= epsilon){
            return false;
        }
        if(Math.abs(coordinate.getY() - this.y) >= epsilon){
            return false;
        }
        if(Math.abs(coordinate.getZ() - this.z) >= epsilon){
            return false;
        }
        return true;
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
        if(!check_double(newX)){
            throw new IllegalArgumentException("value of double must not be infinity or NaN");
        }
        this.x = newX;
    }

    /**
     * @methodtype set
     */
    public void setY(double newY){
        if(!check_double(newY)){
            throw new IllegalArgumentException("value of double must not be infinity or NaN");
        }
        this.y = newY;
    }

    /**
     * @methodtype set
     */
    public void setZ(double newZ){
        if(!check_double(newZ)){
            throw new IllegalArgumentException("value of double must not be infinity or NaN");
        }
        this.z = newZ;
    }
}
