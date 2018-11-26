package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IndieGamePhotoTest {

    private IndieGamePhoto testPhoto;


    @Before
    public void setUp(){
        this.testPhoto = new IndieGamePhoto("str_titel", "str_genre", "str_developer", "str_publisher", 4, 4, 4);
    }


    @Test
    public void testCreation(){
        IndieGamePhoto testComplexPhoto = new IndieGamePhoto("title", "genre", "developer", "publisher", 1, 2, 2011);
        assertEquals(testComplexPhoto.getTitle(), "title");
        assertEquals(testComplexPhoto.getGenre(), "genre");
        assertEquals(testComplexPhoto.getDeveloper(), "developer");
        assertEquals(testComplexPhoto.getPublisher(), "publisher");
        assertEquals(testComplexPhoto.getReleaseDay(), 1);
        assertEquals(testComplexPhoto.getReleaseMonth(), 2);
        assertEquals(testComplexPhoto.getReleaseYear(), 2011);
    }

    @Test
    public void testGetterSetter(){
        testPhoto.setTitle("title");
        testPhoto.setGenre("genre");
        testPhoto.setDeveloper("developer");
        testPhoto.setPublisher("publisher");
        testPhoto.setReleaseDay(1);
        testPhoto.setReleaseMonth(2);
        testPhoto.setReleaseYear(2011);

        assertEquals(testPhoto.getTitle(), "title");
        assertEquals(testPhoto.getGenre(), "genre");
        assertEquals(testPhoto.getDeveloper(), "developer");
        assertEquals(testPhoto.getPublisher(), "publisher");
        assertEquals(testPhoto.getReleaseDay(), 1);
        assertEquals(testPhoto.getReleaseMonth(), 2);
        assertEquals(testPhoto.getReleaseYear(), 2011);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleTitle() {
        testPhoto.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleGenre() {
        testPhoto.setGenre(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleDeveloper() {
        testPhoto.setDeveloper(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleaglePublisher() {
        testPhoto.setPublisher(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseDay() {
        testPhoto.setReleaseDay(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseMonth() {
        testPhoto.setReleaseMonth(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIlleagleReleaseYear() {
        testPhoto.setReleaseYear(-1);
    }
}