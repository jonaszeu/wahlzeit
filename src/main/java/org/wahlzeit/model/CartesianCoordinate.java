package org.wahlzeit.model;

/*
 * Classname: CartesianCoordinate
 *
 * Version information: v3 [for adap-hw07]
 *
 * Date: 02.12.2018
 *
 * Copyright notice: AGPLv3
 */

public class CartesianCoordinate extends AbstractCoordinate {

    // CartesianCoordinate variables with default values
    private double x = 0.00;
    private double y = 0.00;
    private double z = 0.00;

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
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate(){
        return this;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate(){

        assertClassInvariants();

        double radius = Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2));
        double theta = Math.acos(z/radius);
        double phi = Math.atan2(getY(), getX());

        assertClassInvariants();

        return new SphericCoordinate(phi, theta, radius);
    }

    /**
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate){
        return asSphericCoordinate().getCentralAngle(coordinate);
    }

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

        assertIsValidValue(newX);
        assertClassInvariants();

        this.x = newX;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setY(double newY){

        assertIsValidValue(newY);
        assertClassInvariants();

        this.y = newY;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setZ(double newZ){

        assertIsValidValue(newZ);
        assertClassInvariants();

        this.z = newZ;

        assertClassInvariants();
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidValue(double cartesianCoordinateValue){
        if(!check_double(cartesianCoordinateValue)){
            throw new IllegalArgumentException("value of double must not be infinity or NaN");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants(){
        super.assertClassInvariants();
        assertIsValidValue(this.getX());
        assertIsValidValue(this.getY());
        assertIsValidValue(this.getZ());
    }
}