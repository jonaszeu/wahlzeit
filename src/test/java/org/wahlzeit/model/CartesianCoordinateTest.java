package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

/*
 * Classname: CartesianCoordinateTest
 *
 * Version information: v2.0 [for adap-hw05]
 *
 * Date: 17.11.2018
 *
 * Copyright notice: AGPLv3
 */

public class CartesianCoordinateTest {

    double defaultX;
    double defaultY;
    double defaultZ;

    @Before
    public void setUpDefaultValues(){
        defaultX = 0;
        defaultY = 0;
        defaultZ = 0;
    }

    @Test
    public void testTrivialCreation(){
        CartesianCoordinate coordinate = new CartesianCoordinate();

        assertEquals(coordinate.getX(), defaultX, 0);
        assertEquals(coordinate.getY(), defaultY, 0);
        assertEquals(coordinate.getZ(), defaultZ, 0);

    }

    @Test
    public void testExplictCreation(){
        double x = 1;
        double y = 2;
        double z = 3;
        double x2 = -1;
        double y2 = -2;
        double z2 = -3;

        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);

        assertEquals(coordinate.getX(), x, 0);
        assertEquals(coordinate.getY(), y, 0);
        assertEquals(coordinate.getZ(), z, 0);

        CartesianCoordinate coordinate2 = new CartesianCoordinate(x2, y2, z2);

        assertEquals(coordinate2.getX(), x2, 0);
        assertEquals(coordinate2.getY(), y2, 0);
        assertEquals(coordinate2.getZ(), z2, 0);
    }

    @Test
    public void testGetterSetter(){
        double x1 = 1;
        double y1 = 2;
        double z1 = 3;
        double x2 = -1;
        double y2 = -2;
        double z2 = -3;

        CartesianCoordinate coordinate1 = new CartesianCoordinate(x1, y1, z1);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(x2, y2, z2);

        assertEquals(coordinate1.getX(), x1, 0);
        assertEquals(coordinate1.getY(), y1, 0);
        assertEquals(coordinate1.getZ(), z1, 0);

        assertEquals(coordinate2.getX(), x2, 0);
        assertEquals(coordinate2.getY(), y2, 0);
        assertEquals(coordinate2.getZ(), z2, 0);

        coordinate1.setX(x2);
        coordinate1.setY(y2);
        coordinate1.setZ(z2);

        coordinate2.setX(x1);
        coordinate2.setY(y1);
        coordinate2.setZ(z1);

        assertEquals(coordinate1.getX(), x2, 0);
        assertEquals(coordinate1.getY(), y2, 0);
        assertEquals(coordinate1.getZ(), z2, 0);

        assertEquals(coordinate2.getX(), x1, 0);
        assertEquals(coordinate2.getY(), y1, 0);
        assertEquals(coordinate2.getZ(), z1, 0);
    }

    @Test
    public void testGetDistance(){
        CartesianCoordinate coordinate1 = new CartesianCoordinate();
        CartesianCoordinate coordinate2 = new CartesianCoordinate();
        CartesianCoordinate coordinate3 = new CartesianCoordinate(0, 0, 0);
        CartesianCoordinate coordinate4 = new CartesianCoordinate(1,2,3);

        assertEquals(coordinate1.getDistance(coordinate2), 0, 0);
        assertEquals(coordinate1.getDistance(coordinate3), 0, 0);
        assertEquals(coordinate1.getDistance(coordinate4), 3.74165738, 0.00001);

        assertEquals(coordinate3.getDistance(coordinate4), 3.74165738, 0.00001);
        assertEquals(coordinate4.getDistance(coordinate4), 0, 0);
    }

    @Test
    public void testIsEqual(){
        CartesianCoordinate coordinate1 = new CartesianCoordinate();
        CartesianCoordinate coordinate2 = new CartesianCoordinate();
        CartesianCoordinate coordinate3 = new CartesianCoordinate(0, 0, 0);
        CartesianCoordinate coordinate4 = new CartesianCoordinate(1,2,3);
        CartesianCoordinate coordinate5 = new CartesianCoordinate(1, 2, 3);

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
        CartesianCoordinate coordinate = new CartesianCoordinate();
        assertThat(coordinate.asCartesianCoordinate(), instanceOf(CartesianCoordinate.class));
    }

    @Test
    public void testGetCartesianDistance(){
        CartesianCoordinate coordinate1 = new CartesianCoordinate();
        CartesianCoordinate coordinate2 = new CartesianCoordinate();
        CartesianCoordinate coordinate3 = new CartesianCoordinate(0, 0, 0);
        CartesianCoordinate coordinate4 = new CartesianCoordinate(1,2,3);

        assertEquals(coordinate1.getCartesianDistance(coordinate2), 0, 0);
        assertEquals(coordinate1.getCartesianDistance(coordinate3), 0, 0);
        assertEquals(coordinate1.getCartesianDistance(coordinate4), 3.74165738, 0.00001);

        assertEquals(coordinate3.getCartesianDistance(coordinate4), 3.74165738, 0.00001);
        assertEquals(coordinate4.getCartesianDistance(coordinate4), 0, 0);
    }

    @Test
    public void testAsSphericCoordinate(){
        CartesianCoordinate coordinate = new CartesianCoordinate();
        assertThat(coordinate.asSphericCoordinate(), instanceOf(SphericCoordinate.class));
    }

    @Test
    public void testGetCentralAngle(){}

}