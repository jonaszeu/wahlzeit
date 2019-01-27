package org.wahlzeit.model;

/*
 * Classname: IndieGame
 *
 * Version information: v1.0
 *
 * Date: 19.01.2019
 *
 * Copyright notice: AGPLv3
 */

/*
 *  adap-hw13 Trace and document the instantiation
 *
 *  For IndieGame
 *
 *  The intended way to create an IndieGame is to use the constructors of IndieGame.
 *
 *  public IndieGame(IndieGameType indieGameType)
 *
 *  public IndieGame(IndieGameType indieGameType, String title, String developer, String publisher, int releaseYear)
 *
 *  Both constructors use an IndieGameType, that should be created with the IndieGameManager (see IndieGameType.java)
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

public class IndieGame{

    /**
     *
     */
    public static IndieGameManager indieGameManager = IndieGameManager.getInstance();

    /**
     *
     */
    private IndieGameType indieGameType;

    /**
     *
     */
    private String title = "";
    private String developer = "";
    private String publisher = "";
    private int releaseYear = 1;

    /**
     * @methodtype constructor
     */
    public IndieGame(IndieGameType indieGameType){
        setIndieGameType(indieGameType);
    }

    /**
     * @methodtype constructor
     */
    public IndieGame(IndieGameType indieGameType, String title, String developer, String publisher, int releaseYear){
        setIndieGameType(indieGameType);

        setTitle(title);
        setDeveloper(developer);
        setPublisher(publisher);
        setReleaseYear(releaseYear);
    }

    /**
     * @methodtype get
     */
    public IndieGameType getIndieGameType() { return indieGameType; }

    /**
     * @methodtype get
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * @methodtype get
     */
    public String getDeveloper() {
        return this.developer;
    }

    /**
     * @methodtype get
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * @methodtype get
     */
    public int getReleaseYear() {
        return this.releaseYear;
    }

    /**
     * @methodtype set
     */
    public void setIndieGameType(IndieGameType indieGameType) {
        assertIsNonNullArgumentIndieGameType("IndieGameType", indieGameType);

        this.indieGameType = indieGameType;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setDeveloper(String developer) {
        assertIsNonNullArgument("developer", developer);
        assertClassInvariants();

        this.developer = developer;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setPublisher(String publisher) {
        assertIsNonNullArgument("publisher", publisher);
        assertClassInvariants();

        this.publisher = publisher;

        assertClassInvariants();
    }


    /**
     * @methodtype set
     */
    public void setReleaseYear(int releaseYear) {
        assertIsValidReleaseYear(releaseYear);
        assertClassInvariants();

        this.releaseYear = releaseYear;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setTitle(String title) {
        assertIsNonNullArgument("title", title);
        assertClassInvariants();

        this.title = title;

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
    protected void assertIsNonNullArgumentIndieGameType(String stringAttribute, IndieGameType indieGameType) throws NullPointerException{
        if(indieGameType == null){
            throw new NullPointerException("Null is no acceptable argument for " + stringAttribute);
        }
    }


    /**
     * @methodtype assertion
     */
    protected void assertIsValidReleaseYear(int releaseYear) throws IllegalArgumentException{
        if(releaseYear <= 0) {
            throw new IllegalArgumentException("Illeagle argument for releaseYear");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants(){
        assertIsNonNullArgumentIndieGameType("IndieGameType", this.indieGameType);
        assertIsNonNullArgument("title", this.title);
        assertIsNonNullArgument("publisher", this.publisher);
        assertIsNonNullArgument("developer", this.developer);
        assertIsValidReleaseYear(this.releaseYear);
    }
}