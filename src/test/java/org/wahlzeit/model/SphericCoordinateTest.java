package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

/*
 * Classname: SphericCoordinateTest
 *
 * Version information: v1.0 [for adap-hw05]
 *
 * Date: 17.11.2018
 *
 * Copyright notice: AGPLv3
 */

public class SphericCoordinateTest {

    @Test
    public void testTrivialCreation(){
        SphericCoordinate coordinate1 = new SphericCoordinate();
        assertEquals(coordinate1.getPhi(), 0, 0);
        assertEquals(coordinate1.getTheta(), 0, 0);
        assertEquals(coordinate1.getRadius(), 0, 0);
    }

    @Test
    public void testExplictCreation(){
        SphericCoordinate coordinate1 = new SphericCoordinate(1,2,3);
        assertEquals(coordinate1.getPhi(), 1, 0);
        assertEquals(coordinate1.getTheta(), 2, 0);
        assertEquals(coordinate1.getRadius(), 3, 0);
    }

    @Test
    public void testGetterSetter(){
        SphericCoordinate coordinate1 = new SphericCoordinate();
        coordinate1.setPhi(1);
        coordinate1.setTheta(2);
        coordinate1.setRadius(3);
        assertEquals(coordinate1.getPhi(), 1, 0);
        assertEquals(coordinate1.getTheta(), 2, 0);
        assertEquals(coordinate1.getRadius(), 3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleaglePhi() {
        SphericCoordinate coordinate1 = new SphericCoordinate();
        coordinate1.setPhi(-1000);
        coordinate1.setPhi(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleTheta(){
        SphericCoordinate coordinate1 = new SphericCoordinate();
        coordinate1.setTheta(-1000);
        coordinate1.setTheta(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleRadius(){
        SphericCoordinate coordinate1 = new SphericCoordinate();
        coordinate1.setRadius(-1);
    }


    @Test
    public void testIsEqual(){
        SphericCoordinate coordinate1 = new SphericCoordinate();
        SphericCoordinate coordinate2 = new SphericCoordinate();
        SphericCoordinate coordinate3 = new SphericCoordinate(0, 0, 0);
        SphericCoordinate coordinate4 = new SphericCoordinate(1,2,3);
        SphericCoordinate coordinate5 = new SphericCoordinate(1, 2, 3);

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
        SphericCoordinate coordinate = new SphericCoordinate();
        assertThat(coordinate.asCartesianCoordinate(), instanceOf(CartesianCoordinate.class));
    }

    @Test
    public void testGetCartesianDistance(){
        SphericCoordinate coordinate1 = new SphericCoordinate(1,1,1);
        SphericCoordinate coordinate2 = new SphericCoordinate(1,1,1);
        assertEquals(coordinate1.getCartesianDistance(coordinate2), 0, 0.00001);
    }

    @Test
    public void testAsSphericCoordinate(){
        SphericCoordinate coordinate = new SphericCoordinate();
        assertThat(coordinate.asSphericCoordinate(), instanceOf(SphericCoordinate.class));
    }

    @Test
    public void testGetCentralAngle(){
        SphericCoordinate coordinate1 = new SphericCoordinate(1,1,1);
        SphericCoordinate coordinate2 = new SphericCoordinate(1,1,1);
        assertEquals(coordinate1.getCentralAngle(coordinate2), 0, 0.00001);
    }

}