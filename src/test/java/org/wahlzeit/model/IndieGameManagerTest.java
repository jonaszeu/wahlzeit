package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IndieGameManagerTest {

    @Test
    public void testGetInstance(){
        assertNotNull(IndieGameManager.getInstance());
    }

    @Test
    public void testGetIndieGameType(){
        assertEquals(IndieGameManager.getInstance().getIndieGameType("Unknown").getGenre(), "Unknown");
        assertEquals(IndieGameManager.getInstance().getIndieGameType("Unknown").getGenre(), "Unknown");

        assertEquals(IndieGameManager.getInstance().getIndieGameType("Test1").getGenre(), "Test1");
        assertEquals(IndieGameManager.getInstance().getIndieGameType("Test2").getGenre(), "Test2");
    }

    @Test(expected = NullPointerException.class)
    public void testIlleagleGenre() {
        IndieGameType indieGameType = IndieGameManager.getInstance().getIndieGameType(null);
    }

}