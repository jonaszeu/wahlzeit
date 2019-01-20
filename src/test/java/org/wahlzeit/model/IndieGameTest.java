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

        IndieGame indieGame1 = new IndieGame(this.indieGameType, "Title", "Developer", "Publisher", 4, 5, 6);
        assertEquals(indieGame1.getIndieGameType(), this.indieGameType);
        assertEquals(indieGame1.getTitle(), "Title");
        assertEquals(indieGame1.getDeveloper(), "Developer");
        assertEquals(indieGame1.getPublisher(), "Publisher");
        assertEquals(indieGame1.getReleaseDay(), 4);
        assertEquals(indieGame1.getReleaseMonth(), 5);
        assertEquals(indieGame1.getReleaseYear(), 6);
    }

    @Test
    public void testGetterSetter(){
        testGame.setIndieGameType(this.indieGameType);
        testGame.setTitle("Title");
        testGame.setDeveloper("Developer");
        testGame.setPublisher("Publisher");
        testGame.setReleaseDay(4);
        testGame.setReleaseMonth(5);
        testGame.setReleaseYear(6);

        assertEquals(testGame.getIndieGameType(), this.indieGameType);
        assertEquals(testGame.getTitle(), "Title");
        assertEquals(testGame.getDeveloper(), "Developer");
        assertEquals(testGame.getPublisher(), "Publisher");
        assertEquals(testGame.getReleaseDay(), 4);
        assertEquals(testGame.getReleaseMonth(), 5);
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
    public void testIlleagleReleaseDay() {
        testGame.setReleaseDay(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseDay2() {
        testGame.setReleaseDay(33);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseMonth() {
        testGame.setReleaseMonth(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseMonth2() {
        testGame.setReleaseMonth(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseYear() {
        testGame.setReleaseYear(-1);
    }

}

