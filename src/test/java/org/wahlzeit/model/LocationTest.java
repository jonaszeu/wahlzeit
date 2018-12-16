package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

/*
 * Classname: LocationTest
 *
 * Version information: v2
 *
 * Date: 15.12.2018
 *
 * Copyright notice: AGPLv3
 */

public class LocationTest {

    @Test
    public void testTrivialCreation(){
        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
        Location location = new Location(coordinate);
        assertEquals(location.getCoordinate(), coordinate);
    }

    @Test
    public void testComplexCreation(){
        CartesianCoordinate coordinate = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
        String description = "Wundervoller Ort";
        Location location = new Location(coordinate, description);
        assertEquals(location.getCoordinate(), coordinate);
        assertEquals(location.getDescription(), description);
    }

    @Test
    public void testGetterSetter(){
        CartesianCoordinate coordinate1 = CartesianCoordinate.getCartesianCoordinate(1,2,3);
        CartesianCoordinate coordinate2 = CartesianCoordinate.getCartesianCoordinate(-1,-2,-3);

        String description1 = "Desc1";
        String description2 = "Desc2";

        Location location1 = new Location(coordinate1);
        Location location2 = new Location(coordinate2, description2);

        assertEquals(location1.getCoordinate(), coordinate1);
        assertEquals(location1.getDescription(), "");

        assertEquals(location2.getCoordinate(), coordinate2);
        assertEquals(location2.getDescription(), description2);

        // Change / Flip Values
        location1.setCoordinate(coordinate2);
        location1.setDescription(description2);

        location2.setCoordinate(coordinate1);
        location2.setDescription(description1);

        assertEquals(location1.getCoordinate(), coordinate2);
        assertEquals(location1.getDescription(), description2);

        assertEquals(location2.getCoordinate(), coordinate1);
        assertEquals(location2.getDescription(), description1);
    }

}
