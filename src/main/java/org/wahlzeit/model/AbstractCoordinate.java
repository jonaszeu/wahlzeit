package org.wahlzeit.model;

/*
 * Classname: AbstractCoordinate
 *
 * Version information: v1.0 [for adap-hw06]
 *
 * Date: 25.11.2018
 *
 * Copyright notice: AGPLv3
 */


public abstract class AbstractCoordinate implements Coordinate {

    /**
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate){
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    /**
     * @methodtype get
     */
    public double getCentralAngle(Coordinate coordinate){
        return asSphericCoordinate().getCentralAngle(coordinate);
    }

}