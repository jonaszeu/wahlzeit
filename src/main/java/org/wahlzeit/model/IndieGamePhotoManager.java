package org.wahlzeit.model;

/*
 * Classname: IndieGamePhotoManager.java
 *
 * Version information: v1.0
 *
 * Date: 10.11.2018
 *
 * Copyright notice: AGPLv3
 */

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class IndieGamePhotoManager extends PhotoManager {

    /**
     *
     */
    protected static final IndieGamePhotoManager instance = new IndieGamePhotoManager();

    private static final Logger log = Logger.getLogger(IndieGamePhotoManager.class.getName());

    /**
     *
     */
    public IndieGamePhotoManager(){
        photoTagCollector = IndieGamePhotoFactory.getInstance().createPhotoTagCollector();
    }

}