package org.wahlzeit.model;

/*
 * Classname: SphericCoordinate
 *
 * Version information: v1.1 [for adap-hw06]
 *
 * Date: 25.11.2018
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
     *
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate(){
        double x = getRadius() * Math.sin(getTheta()) * Math.cos(getPhi());
        double y = getRadius() * Math.sin(getTheta()) * Math.sin(getPhi());
        double z = getRadius() * Math.cos(getTheta());

        return new CartesianCoordinate(x, y, z);
    }


    /**
     *
     */
    @Override
    public SphericCoordinate asSphericCoordinate(){
        return this;
    }

    /**
     *
     */
    @Override
    public double getCentralAngle(Coordinate coordinate){
        SphericCoordinate tmpSC = coordinate.asSphericCoordinate();

        double centralAngle = Math.sin(getPhi()) * Math.sin(tmpSC.getPhi())
                + Math.cos(getPhi()) * Math.cos(tmpSC.getPhi()) * Math.cos(tmpSC.getTheta() - getTheta());
        return Math.acos(centralAngle);
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

        SphericCoordinate tmpSC = coordinate.asSphericCoordinate();

        if(Math.abs(tmpSC.getPhi() - getPhi()) >= epsilon){
            return false;
        }
        if(Math.abs(tmpSC.getTheta() - getTheta()) >= epsilon){
            return false;
        }
        if(Math.abs(tmpSC.getRadius() - getRadius()) >= epsilon){
            return false;
        }
        return true;
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
        if(phi < -90 || phi > 90){
            throw new IllegalArgumentException("Phi must be in range of []");
        }
        this.phi = phi;
    }

    /**
     * @methodtype set
     */
    public void setTheta(double theta) {
        if(theta < -180 || theta > 180){
            throw new IllegalArgumentException("theta must be in range of []");
        }
        this.theta = theta;
    }

    /**
     * @methodtype set
     */
    public void setRadius(double radius){
        if(radius < 0){
            throw new IllegalArgumentException("radius must be greater or equals zero");
        }
        this.radius = radius;
    }
}