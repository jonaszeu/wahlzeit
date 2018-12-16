package org.wahlzeit.model;

/*
 * Classname: SphericCoordinate
 *
 * Version information: v3
 *
 * Date: 15.12.2018
 *
 * Copyright notice: AGPLv3
 */

import java.util.HashMap;

public class SphericCoordinate extends AbstractCoordinate{

    /**
     *
     */
    private static final HashMap<String, SphericCoordinate> SPHERIC_COORDINATE_HASH_MAP = new HashMap<>();

    /**
     *
     */
    private final double phi;
    private final double theta;
    private final double radius;


    /**
     *
     */
    private SphericCoordinate(double phi, double theta, double radius){
        assertIsValidPhi(phi);
        assertIsValidTheta(theta);
        assertIsValidRadius(radius);

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     */
    public static synchronized SphericCoordinate getSphericCoordinate(double phi, double theta, double radius){
        String id = getCoordinateId(phi, theta, radius, "sphericCoordinate");
        SphericCoordinate coordinate = SPHERIC_COORDINATE_HASH_MAP.get(id);
        if(coordinate != null){
            return coordinate;
        }else{
            coordinate = new SphericCoordinate(phi, theta, radius);
            SPHERIC_COORDINATE_HASH_MAP.put(id, coordinate);
            return coordinate;
        }
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

        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getCartesianCoordinate(x, y, z);

        assertIsNonNullArgument(cartesianCoordinate);
        assertClassInvariants();

        return cartesianCoordinate;
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