package org.wahlzeit.model;

/*
 * Classname: IndieGameType
 *
 * Version information: v2.0
 *
 * Date: 27.01.2019
 *
 * Copyright notice: AGPLv3
 */

/*
 *  adap-hw13 Trace and document the instantiation
 *
 *  For IndieGameType
 *
 *  The intended way to create an IndieGameType is to use the IndieGameManager.
 *
 *  IndieGameManager: public synchronized IndieGameType getIndieGameType(String genre) -> Returns an existing IndieGameType or instanciate a new one
 *
 *  IndieGameManager: If the INDIE_GAME_TYPE_HASH_MAP doesnt include this IndieGameType the constructor of IndieGameType is called.
 *
 *  IndieGameType: IndieGameType(String genre) -> Returns a new instance of IndieGameType if the genre is not null
 *
 *  A way to create a default IndieGameType you can use the DEFAULT_GENRE string from IndieGameType
 *
 *  Object creation table:
 *  1. Delegation: separate-object
 *  2. Selection: by-subclassing
 *  3. Configuration: in-code
 *  4. Instantiation: in-code
 *  5. Initialization: default
 *  6. Building: deafault
 *
 *  adap-hw14 Describe three collaborations
 *
 *  For IndieGame and IndieGameType
 *
 *  collaboration: IndieGame / IndieGameType Collaboration
 *  collaboration-type: Type Object
 *  role: Type Object
 *
 *  Purpose: Provide information common to all isntances of a type (from lecture slides)
 *
 */

public class IndieGameType{

    /**
     * Default value
     */
    public static final String DEFAULT_GENRE = "Unknown";

    /**
     *
     */
    public static IndieGameManager indieGameManager = IndieGameManager.getInstance();

    /**
     * Change to true if class is subclass of IndieGameType
     */
    private final boolean IS_SUBTYPE = false;

    /**
     *
     */
    private String genre = "";

    /**
     * @methodtype constructor
     */
    public IndieGameType(String genre){
        setGenre(genre);
    }

    /**
     * @methodtype get
     */
    public static String getDefaultGenre(){ return IndieGameType.DEFAULT_GENRE; }

    /**
     * @methodtype get
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * @methodtype set
     */
    private void setGenre(String genre) {
        assertIsNonNullArgument("genre", genre);
        assertClassInvariants();

        this.genre = genre;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     */
    public boolean isSubtype(){
        return IS_SUBTYPE;
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNonNullArgument(String stringAttribute, String value) throws NullPointerException{
        if(value == null){
            throw new NullPointerException("Null is no acceptable argument for " + stringAttribute);
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants(){
        assertIsNonNullArgument("genre", this.genre);
    }
}