package org.wahlzeit.model;

/*
 * Classname: IndieGamePhotoFactory
 *
 * Version information: v1.1
 *
 * Date: 13.01.2019
 *
 * Copyright notice: AGPLv3
 */

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

import java.util.logging.Logger;


@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "IndieGamePhotoFactory", "IndieGamePhoto",
        }
)

public class IndieGamePhotoFactory extends PhotoFactory{

    private static final Logger log = Logger.getLogger(IndieGamePhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static IndieGamePhotoFactory instance = null;

    protected IndieGamePhotoFactory(){
        super();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized IndieGamePhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic IndieGamePhotoFactory").toString());
            setInstance(new IndieGamePhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of IndieGamePhotoFactory.
     */
    protected static synchronized void setInstance(IndieGamePhotoFactory indieGamePhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize IndieGamePhotoFactory twice");
        }

        instance = indieGamePhotoFactory;
    }

    /**
     * @methodtype factory
     */
    public IndieGamePhoto createPhoto() {

        return new IndieGamePhoto();
    }

    /**
     * Creates a new IndieGamePhoto with the specified id
     */
    public IndieGamePhoto createPhoto(PhotoId id) {

        return new IndieGamePhoto(id);
    }
    /**
     * Creates a new IndieGamePhoto with the specified attirbutes
     */
    public IndieGamePhoto createPhoto(String title, String genre, String developer, String publisher, int releaseDay, int releaseMonth, int releaseYear) {
        IndieGameType indieGametype = IndieGameManager.getInstance().getIndieGameType(genre);
        IndieGame indieGame = new IndieGame(indieGametype, title, developer, publisher, releaseDay, releaseMonth, releaseYear);
        return new IndieGamePhoto(indieGame);
    }
}