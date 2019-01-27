package org.wahlzeit.model;

/*
 * Classname: IndieGamePhoto
 *
 * Version information: v2.3
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


/*
 *  adap-hw13 Trace and document the instantiation
 *
 *  For IndieGamePhoto
 *
 *  The intended way to create an IndieGamePhoto is to use the IndieGamePhotoFactory.
 *  This class has several functions to create an IndieGamePhoto.
 *
 *  public IndieGamePhoto createPhoto() -> Creates default IndieGamePhoto
 *
 *  IndieGamePhoto createPhoto(PhotoId id) -> Creates a new IndieGamePhoto with the specified id
 *
 *  public IndieGamePhoto createPhoto(String title, String genre, String developer, String publisher, int releaseYear) -> Creates a new IndieGamePhoto with explict IndieGame and IndieGameType
 *
 *  The last function first creates a new IndieGameType with the IndieGameManager. Then it creates an IndieGame with this type.
 *
 *  All three functions use the constructors of the IndieGamePhoto.
 *
 *
 *  Object creation table:
 *  1. Delegation: seperate-object
 *  2. Selection: by-subclassing
 *  3. Configuration: in-code
 *  4. Instantiation: in-code
 *  5. Initialization: default
 *  6. Building: default
 *
 */

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

    /**
     * @methodtype get
     */
    public IndieGame getIndieGame() {
        return indieGame;
    }

    /**
     * @methodtype set
     */
    public void setIndieGame(IndieGame indieGame){
        this.indieGame = indieGame;
    }
}