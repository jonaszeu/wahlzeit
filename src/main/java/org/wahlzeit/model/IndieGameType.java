package org.wahlzeit.model;

/*
 * Classname: IndieGameType
 *
 * Version information: v1.0
 *
 * Date: 19.01.2019
 *
 * Copyright notice: AGPLv3
 */

public class IndieGameType{

    /**
     *
     */
    public static final String DEFAULT_GENRE = "Unknown";

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