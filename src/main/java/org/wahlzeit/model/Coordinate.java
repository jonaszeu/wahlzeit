package org.wahlzeit.model;

/*
 * Classname: Coordinate
 *
 * Version information: v2.1 [correction for adap-hw05]
 *
 * Date: 25.11.2018
 *
 * Copyright notice: AGPLv3
 */

public interface Coordinate {

    /**
     * @methodtype conversion
     */
    CartesianCoordinate asCartesianCoordinate();

    /**
     * @methodtype get
     */
    double getCartesianDistance(Coordinate coordinate);

    /**
     * @methodtype conversion
     */
    SphericCoordinate asSphericCoordinate();

    /**
     * @methodtype get
     */
    double getCentralAngle(Coordinate coordinate);

    /**
     * @methodtype boolean-query
     */
    boolean isEqual(Coordinate coordinate);

}
