package org.wahlzeit.model;

/*
 * Classname: IndieGamePhoto
 *
 * Version information: v2.2
 *
 * Date: 19.01.2019
 *
 * Copyright notice: AGPLv3
 */

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "IndieGamePhotoFactory", "IndieGamePhoto",
        }
)

public class IndieGamePhoto extends Photo{

    /**
     *
     */
    private IndieGame indieGame = null;

    /**
     * @methodtype constructor
     */
    public IndieGamePhoto(){
        super();
    }

    /**
     * @methodtype constructor
     */
    public IndieGamePhoto(IndieGame indieGame){
        super();

        setIndieGame(indieGame);
    }

    /**
     * @methodtype constructor
     */
    public IndieGamePhoto(PhotoId myId){
        super(myId);
    }

    public IndieGame getIndieGame() {
        return indieGame;
    }

    public void setIndieGame(IndieGame indieGame){
        this.indieGame = indieGame;
    }
}