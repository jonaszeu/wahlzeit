package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

/*
 * Classname: SphericCoordinateTest
 *
 * Version information: v2
 *
 * Date: 15.12.2018
 *
 * Copyright notice: AGPLv3
 */

public class SphericCoordinateTest {

    double defaultPhi;
    double defaultTheta;
    double defaultRadius;

    @Before
    public void setUpDefaultValues(){
        defaultPhi = 0;
        defaultTheta = 0;
        defaultRadius = 0;
    }

    @Test
    public void testTrivialCreation(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(defaultPhi, defaultTheta, defaultRadius);
        assertEquals(coordinate1.getPhi(), defaultPhi, 0);
        assertEquals(coordinate1.getTheta(), defaultTheta, 0);
        assertEquals(coordinate1.getRadius(), defaultRadius, 0);
    }

    @Test
    public void testExplictCreation(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(1,2,3);
        assertEquals(coordinate1.getPhi(), 1, 0);
        assertEquals(coordinate1.getTheta(), 2, 0);
        assertEquals(coordinate1.getRadius(), 3, 0);
    }

    @Test
    public void testGetterSetter(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(1, 2, 3);

        assertEquals(coordinate1.getPhi(), 1, 0);
        assertEquals(coordinate1.getTheta(), 2, 0);
        assertEquals(coordinate1.getRadius(), 3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleaglePhi() {
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(-1000, defaultTheta, defaultRadius);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(1000, defaultTheta, defaultRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleTheta(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(defaultPhi, -1000, defaultRadius);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(defaultPhi, 1000, defaultRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleRadius(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(defaultPhi, defaultTheta, -1);
    }


    @Test
    public void testIsEqual(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(defaultPhi, defaultTheta, defaultRadius);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(defaultPhi, defaultTheta, defaultRadius);
        SphericCoordinate coordinate3 = SphericCoordinate.getSphericCoordinate(0, 0, 0);
        SphericCoordinate coordinate4 = SphericCoordinate.getSphericCoordinate(1,2,3);
        SphericCoordinate coordinate5 = SphericCoordinate.getSphericCoordinate(1, 2, 3);

        assertEquals(coordinate1.isEqual(coordinate2), true);
        assertEquals(coordinate1.isEqual(coordinate3), true);
        assertEquals(coordinate1.isEqual(coordinate4), false);

        assertEquals(coordinate4.isEqual(coordinate1), false);
        assertEquals(coordinate4.isEqual(coordinate3), false);
        assertEquals(coordinate4.isEqual(coordinate4), true);
        assertEquals(coordinate4.isEqual(coordinate5), true);

    }

    @Test
    public void testAsCartesianCoordinate(){
        SphericCoordinate coordinate = SphericCoordinate.getSphericCoordinate(defaultPhi, defaultTheta, defaultRadius);
        assertThat(coordinate.asCartesianCoordinate(), instanceOf(CartesianCoordinate.class));
    }

    @Test
    public void testGetCartesianDistance(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(1,1,1);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(1,1,1);
        assertEquals(coordinate1.getCartesianDistance(coordinate2), 0, 0.00001);
    }

    @Test
    public void testAsSphericCoordinate(){
        SphericCoordinate coordinate = SphericCoordinate.getSphericCoordinate(defaultPhi, defaultTheta, defaultRadius);
        assertThat(coordinate.asSphericCoordinate(), instanceOf(SphericCoordinate.class));
    }

    @Test
    public void testGetCentralAngle(){
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(1,1,1);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(1,1,1);
        assertEquals(coordinate1.getCentralAngle(coordinate2), 0, 0.00001);
    }

}