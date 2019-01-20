package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IndieGameTypeTest {

    @Test
    public void testCreation(){
        IndieGameType indieGameType = new IndieGameType("TestType");
        assertEquals(indieGameType.getGenre(), "TestType");
    }

    @Test
    public void testGetterSetter(){
        IndieGameType indieGameType = new IndieGameType("TestType");
        assertEquals(indieGameType.getGenre(), "TestType");
    }

    @Test
    public void testGetDefaultGenre(){
        assertEquals(IndieGameType.getDefaultGenre(), "Unknown");
        assertEquals(IndieGameType.getDefaultGenre(), IndieGameType.DEFAULT_GENRE);
    }

    @Test(expected = NullPointerException.class)
    public void testIlleagleGenre() {
        IndieGameType indieGameType = new IndieGameType(null);
    }

}