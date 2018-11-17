package org.wahlzeit.model;

/*
 * Classname: Coordinate
 *
 * Version information: v2.0 [for adap-hw05]
 *
 * Date: 17.11.2018
 *
 * Copyright notice: AGPLv3
 */

public interface Coordinate {

    /**
     *
     */
    public CartesianCoordinate asCartesianCoordinate();

    /**
     *
     */
    public double getCartesianDistance(Coordinate coordinate);

    /**
     *
     */
    public SphericCoordinate asSphericCoordinate();

    /**
     *
     */
    public double getCentralAngle(Coordinate coordinate);

    /**
     *
     */
    public boolean isEqual(Coordinate coordinate);

}
