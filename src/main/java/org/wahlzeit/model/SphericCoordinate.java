package org.wahlzeit.model;

/*
 * Classname: SphericCoordinate
 *
 * Version information: v2 [for adap-hw07]
 *
 * Date: 02.12.2018
 *
 * Copyright notice: AGPLv3
 */

public class SphericCoordinate extends AbstractCoordinate{

    /**
     *
     */
    private double phi;
    private double theta;
    private double radius;

    /**
     *
     */
    public SphericCoordinate(){
        setPhi(0);
        setTheta(0);
        setRadius(0);
    }

    /**
     *
     */
    public SphericCoordinate(double phi, double theta, double radius){
        setPhi(phi);
        setTheta(theta);
        setRadius(radius);
    }

    /**
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate(){

        assertClassInvariants();

        double x = getRadius() * Math.sin(getTheta()) * Math.cos(getPhi());
        double y = getRadius() * Math.sin(getTheta()) * Math.sin(getPhi());
        double z = getRadius() * Math.cos(getTheta());

        assertClassInvariants();

        return new CartesianCoordinate(x, y, z);
    }

    /**
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate){
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    /**
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate(){
        return this;
    }

    /**
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate coordinate){
        return asCartesianCoordinate().isEqual(coordinate);
    }

    /**
     * @methodtype get
     */
    public double getPhi() {
        return phi;
    }

    /**
     * @methodtype get
     */
    public double getTheta() {
        return theta;
    }

    /**
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype set
     */
    public void setPhi(double phi) {

        assertIsValidPhi(phi);
        assertClassInvariants();

        this.phi = phi;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setTheta(double theta) {

        assertIsValidTheta(theta);
        assertClassInvariants();

        this.theta = theta;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setRadius(double radius){

        assertIsValidRadius(radius);
        assertClassInvariants();

        this.radius = radius;

        assertClassInvariants();
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidPhi(double phi){
        if(phi < -90 || phi > 90){
            throw new IllegalArgumentException("Phi must be in range of [-90, 90]");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidTheta(double theta){
        if(theta < -180 || theta > 180){
            throw new IllegalArgumentException("Theta must be in range of [-180, 180]");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidRadius(double radius){
        if(radius < 0){
            throw new IllegalArgumentException("Radius must be greater or equals zero");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants(){
        super.assertClassInvariants();
        assertIsValidPhi(this.getPhi());
        assertIsValidTheta(this.getTheta());
        assertIsValidRadius(this.getRadius());
    }
}