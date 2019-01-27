package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IndieGameTest {

    private IndieGame testGame = null;
    private IndieGameType indieGameType = null;

    @Before
    public void setUp(){
        this.indieGameType = new IndieGameType("TestType");
        this.testGame = new IndieGame(this.indieGameType);
    }

    @Test
    public void testCreation(){
        IndieGame indieGame0 = new IndieGame(this.indieGameType);
        assertEquals(indieGame0.getIndieGameType(), this.indieGameType);

        IndieGame indieGame1 = new IndieGame(this.indieGameType, "Title", "Developer", "Publisher", 6);
        assertEquals(indieGame1.getIndieGameType(), this.indieGameType);
        assertEquals(indieGame1.getTitle(), "Title");
        assertEquals(indieGame1.getDeveloper(), "Developer");
        assertEquals(indieGame1.getPublisher(), "Publisher");
        assertEquals(indieGame1.getReleaseYear(), 6);
    }

    @Test
    public void testGetterSetter(){
        testGame.setIndieGameType(this.indieGameType);
        testGame.setTitle("Title");
        testGame.setDeveloper("Developer");
        testGame.setPublisher("Publisher");
        testGame.setReleaseYear(6);

        assertEquals(testGame.getIndieGameType(), this.indieGameType);
        assertEquals(testGame.getTitle(), "Title");
        assertEquals(testGame.getDeveloper(), "Developer");
        assertEquals(testGame.getPublisher(), "Publisher");
        assertEquals(testGame.getReleaseYear(), 6);
    }

    @Test(expected = NullPointerException.class)
    public void testIlleagleTitle() {
        testGame.setTitle(null);
    }

    @Test(expected = NullPointerException.class)
    public void testIlleagleDeveloper() {
        testGame.setDeveloper(null);
    }

    @Test(expected = NullPointerException.class)
    public void testIlleaglePublisher() {
        testGame.setPublisher(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseYear() {
        testGame.setReleaseYear(-1);
    }

}

