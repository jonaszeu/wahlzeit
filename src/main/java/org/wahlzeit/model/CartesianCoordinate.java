package org.wahlzeit.model;

/*
 * Classname: CartesianCoordinate
 *
 * Version information: v2.1 [for adap-hw06]
 *
 * Date: 25.11.2018
 *
 * Copyright notice: AGPLv3
 */

public class CartesianCoordinate extends AbstractCoordinate {

    // CartesianCoordinate variables with default values
    private double x = 0.00;
    private double y = 0.00;
    private double z = 0.00;

    // Constructors

    /**
     *
     */
    public CartesianCoordinate(){
        // Keep Default values x:0, y:0, z:0
    }

    /**
     *
     */
    public CartesianCoordinate(double x, double y, double z){
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
     *
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate(){
        return this;
    }

    /**
     *
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate){
        CartesianCoordinate tmpCC = coordinate.asCartesianCoordinate();
        return getDistance(tmpCC);
    }

    /**
     *
     */
    @Override
    public SphericCoordinate asSphericCoordinate(){
        double radius = Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2));
        double theta = Math.acos(z/radius);
        double phi = Math.atan2(getY(), getX());

        return new SphericCoordinate(phi, theta, radius);
    }

    /**
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate coordinate){
        double epsilon = 0.0000001;

        if(coordinate == null){
            return false;
        }

        CartesianCoordinate tmpCC = coordinate.asCartesianCoordinate();

        if(Math.abs(tmpCC.getX() - getX()) >= epsilon){
            return false;
        }
        if(Math.abs(tmpCC.getY() - getY()) >= epsilon){
            return false;
        }
        if(Math.abs(tmpCC.getZ() - getZ()) >= epsilon){
            return false;
        }
        return true;
    }

    /**
     * Calculates and returns the direct cartesian distance
     */
    public double getDistance(CartesianCoordinate coordinate){
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