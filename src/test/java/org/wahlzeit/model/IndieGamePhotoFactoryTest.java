package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IndieGamePhotoFactoryTest {

    @Before
    public void setUp(){
        IndieGamePhotoFactory.initialize();
    }

    @Test
    public void testGetInstance(){
        assertNotNull(IndieGamePhotoFactory.getInstance());
    }

    @Test(expected = IllegalStateException.class)
    public void testSetInstanceTwice(){
        IndieGamePhotoFactory.setInstance(new IndieGamePhotoFactory());
    }

    @Test
    public void testCreatePhoto(){
        PhotoId id = new PhotoId(42);
        assertNotNull(IndieGamePhotoFactory.getInstance().createPhoto());
        assertNotNull(IndieGamePhotoFactory.getInstance().createPhoto(id));
        assertNotNull(IndieGamePhotoFactory.getInstance().createPhoto("title", "genre", "developer", "publisher", 1, 2, 2011));
    }
}