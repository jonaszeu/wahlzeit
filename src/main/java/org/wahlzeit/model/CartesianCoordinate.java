package org.wahlzeit.model;

/*
 * Classname: CartesianCoordinate
 *
 * Version information: v4.2
 *
 * Date: 13.01.2019
 *
 * Copyright notice: AGPLv3
 */

import java.util.HashMap;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Value Object",
        participants = {"CartesianCoordinate"}
)

public class CartesianCoordinate extends AbstractCoordinate {

    /**
     *
     */
    private static final HashMap<String, CartesianCoordinate> CARTESIAN_COORDINATE_HASH_MAP = new HashMap<>();

    /**
     *
     */
    private final double x;
    private final double y;
    private final double z;

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z){
        assertIsValidValue(x);
        assertIsValidValue(y);
        assertIsValidValue(z);

        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     */
    public static synchronized CartesianCoordinate getCartesianCoordinate(double x, double y, double z){
        String id = getCoordinateId(x, y, z, "cartesianCoordinate");
        CartesianCoordinate coordinate = CARTESIAN_COORDINATE_HASH_MAP.get(id);
        if(coordinate != null){
            return coordinate;
        }else{
            coordinate = new CartesianCoordinate(x, y, z);
            CARTESIAN_COORDINATE_HASH_MAP.put(id, coordinate);
            return coordinate;
        }
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
        double theta = Math.acos(getZ()/radius);
        double phi = Math.atan2(getY(), getX());
        SphericCoordinate sphericCoordinate = SphericCoordinate.getSphericCoordinate(phi, theta, radius);

        assertIsNonNullArgument(sphericCoordinate);
        assertClassInvariants();

        return sphericCoordinate;
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
     * @methodtype assertion
     */
    protected void assertIsValidValue(double cartesianCoordinateValue) throws IllegalArgumentException{
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