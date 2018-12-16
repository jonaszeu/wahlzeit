package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

/*
 * Classname: CartesianCoordinateTest
 *
 * Version information: v3
 *
 * Date: 15.12.2018
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
        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);

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

        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(x, y, z);

        assertEquals(coordinate.getX(), x, 0);
        assertEquals(coordinate.getY(), y, 0);
        assertEquals(coordinate.getZ(), z, 0);

        CartesianCoordinate coordinate2 = CartesianCoordinate.getCartesianCoordinate(x2, y2, z2);

        assertEquals(coordinate2.getX(), x2, 0);
        assertEquals(coordinate2.getY(), y2, 0);
        assertEquals(coordinate2.getZ(), z2, 0);
    }

    @Test
    public void testGetter(){
        double x1 = 1;
        double y1 = 2;
        double z1 = 3;
        double x2 = -1;
        double y2 = -2;
        double z2 = -3;

        CartesianCoordinate coordinate1 = CartesianCoordinate.getCartesianCoordinate(x1, y1, z1);
        CartesianCoordinate coordinate2 = CartesianCoordinate.getCartesianCoordinate(x2, y2, z2);

        assertEquals(coordinate1.getX(), x1, 0);
        assertEquals(coordinate1.getY(), y1, 0);
        assertEquals(coordinate1.getZ(), z1, 0);

        assertEquals(coordinate2.getX(), x2, 0);
        assertEquals(coordinate2.getY(), y2, 0);
        assertEquals(coordinate2.getZ(), z2, 0);
    }

    @Test
    public void testIsEqual(){
        CartesianCoordinate coordinate1 = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        CartesianCoordinate coordinate2 = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        CartesianCoordinate coordinate3 = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
        CartesianCoordinate coordinate4 = CartesianCoordinate.getCartesianCoordinate(1,2,3);
        CartesianCoordinate coordinate5 = CartesianCoordinate.getCartesianCoordinate(1, 2, 3);

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
        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        assertThat(coordinate.asCartesianCoordinate(), instanceOf(CartesianCoordinate.class));
    }

    @Test
    public void testGetCartesianDistance(){
        CartesianCoordinate coordinate1 = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        CartesianCoordinate coordinate2 = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        CartesianCoordinate coordinate3 = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
        CartesianCoordinate coordinate4 = CartesianCoordinate.getCartesianCoordinate(1,2,3);

        assertEquals(coordinate1.getCartesianDistance(coordinate2), 0, 0);
        assertEquals(coordinate1.getCartesianDistance(coordinate3), 0, 0);
        assertEquals(coordinate1.getCartesianDistance(coordinate4), 3.74165738, 0.00001);

        assertEquals(coordinate3.getCartesianDistance(coordinate4), 3.74165738, 0.00001);
        assertEquals(coordinate4.getCartesianDistance(coordinate4), 0, 0);
    }

    @Test
    public void testAsSphericCoordinate(){
        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        assertThat(coordinate.asSphericCoordinate(), instanceOf(SphericCoordinate.class));
    }

    @Test
    public void testGetCentralAngle(){
        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);
        CartesianCoordinate coordinate2 = CartesianCoordinate.getCartesianCoordinate(defaultX, defaultY, defaultZ);

        coordinate.getCentralAngle(coordinate2);
    }

}