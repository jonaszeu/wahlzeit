package org.wahlzeit.model;

/*
 * Classname: AbstractCoordinate
 *
 * Version information: v2.1
 *
 * Date: 09.12.2018
 *
 * Copyright notice: AGPLv3
 */


public abstract class AbstractCoordinate implements Coordinate {

    final double EPSILON = 0.0000001;

    /**
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate){

        assertIsNonNullArgument(coordinate);
        assertClassInvariants();

        CartesianCoordinate cartCoordinateA = this.asCartesianCoordinate();
        CartesianCoordinate cartCoordinateB = coordinate.asCartesianCoordinate();

        if(cartCoordinateA.isEqual(cartCoordinateB)){
            return 0;
        }

        // Direct Cartesian distance
        double distance = Math.sqrt(Math.pow(cartCoordinateA.getX()-cartCoordinateB.getX(),2)
                    + Math.pow(cartCoordinateA.getY()-cartCoordinateB.getY(),2)
                    + Math.pow(cartCoordinateA.getZ()-cartCoordinateB.getZ(),2));

        assertIsValidDistance(distance);
        assertClassInvariants();

        return distance;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate){

        assertIsNonNullArgument(coordinate);
        assertClassInvariants();

        SphericCoordinate spherCoordinateA = this.asSphericCoordinate();
        SphericCoordinate spherCoordinateB = coordinate.asSphericCoordinate();

        double centralAngle = Math.sin(spherCoordinateA.getPhi())
                * Math.sin(spherCoordinateB.getPhi())
                + Math.cos(spherCoordinateA.getPhi())
                * Math.cos(spherCoordinateB.getPhi())
                * Math.cos(spherCoordinateB.getTheta()
                - spherCoordinateA.getTheta());
        centralAngle = Math.acos(centralAngle);

        assertIsValidAngle(centralAngle);
        assertClassInvariants();

        return centralAngle;
    }

    /**
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate coordinate){

        assertIsNonNullArgument(coordinate);
        assertClassInvariants();

        CartesianCoordinate cartCoordinateA = this.asCartesianCoordinate();
        CartesianCoordinate cartCoordinateB = coordinate.asCartesianCoordinate();

        boolean isEqualReturn = true;

        if(Math.abs(cartCoordinateB.getX() - cartCoordinateA.getX()) >= EPSILON){
            isEqualReturn = false;
        }
        if(Math.abs(cartCoordinateB.getY() - cartCoordinateA.getY()) >= EPSILON){
            isEqualReturn = false;
        }
        if(Math.abs(cartCoordinateB.getZ() - cartCoordinateA.getZ()) >= EPSILON){
            isEqualReturn = false;
        }

        assertClassInvariants();

        return isEqualReturn;
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNonNullArgument(Coordinate coordinate) throws NullPointerException{
        if(coordinate == null){
            throw new NullPointerException("Null is no acceptable argument.");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants(){};

    /**
     * @methodtype assertion
     */
    protected void assertIsValidDistance(double distance) throws IllegalArgumentException{
        if(distance < 0){
            throw new IllegalArgumentException("Distance can not be negative");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidAngle(double angle) throws IllegalArgumentException{
        if(angle < 0 || angle > 360){
            throw new IllegalArgumentException("Angle can not be negative or greater 360");
        }
    }

}