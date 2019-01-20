package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IndieGamePhotoTest {

    private IndieGameType indieGameType = new IndieGameType("TestType");
    private IndieGame indieGame = null;


    @Before
    public void setUp(){
        this.indieGame = new IndieGame(this.indieGameType);
    }


    @Test
    public void testCreation(){
        IndieGamePhoto testPhoto0 = new IndieGamePhoto();
        IndieGamePhoto testPhoto1 = new IndieGamePhoto(this.indieGame);

        assertEquals(testPhoto0.getIndieGame(), null);
        assertEquals(testPhoto1.getIndieGame(), this.indieGame);
    }

    @Test
    public void testGetterSetter(){
        IndieGamePhoto testPhoto1 = new IndieGamePhoto();

        testPhoto1.setIndieGame(this.indieGame);
        assertEquals(testPhoto1.getIndieGame(), this.indieGame);
    }
}