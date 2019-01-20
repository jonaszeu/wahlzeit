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

public class IndieGame{

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
    private int releaseDay = 1;
    private int releaseMonth = 1;
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
    public IndieGame(IndieGameType indieGameType, String title, String developer, String publisher, int releaseDay, int releaseMonth, int releaseYear){
        setIndieGameType(indieGameType);

        setTitle(title);
        setDeveloper(developer);
        setPublisher(publisher);
        setReleaseDay(releaseDay);
        setReleaseMonth(releaseMonth);
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
    public int getReleaseDay() {
        return this.releaseDay;
    }

    /**
     * @methodtype get
     */
    public int getReleaseMonth() {
        return this.releaseMonth;
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
    public void setReleaseDay(int releaseDay) {
        assertIsValidReleaseDay(releaseDay);
        assertClassInvariants();

        this.releaseDay = releaseDay;

        assertClassInvariants();
    }

    /**
     * @methodtype set
     */
    public void setReleaseMonth(int releaseMonth) {
        assertIsValidReleaseMonth(releaseMonth);
        assertClassInvariants();

        this.releaseMonth = releaseMonth;

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
    protected void assertIsValidReleaseDay(int releaseDay) throws IllegalArgumentException{
        if(releaseDay <= 0 || releaseDay > 31) {
            throw new IllegalArgumentException("Illeagle argument for releaseDay");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidReleaseMonth(int releaseMonth) throws IllegalArgumentException{
        if(releaseMonth <= 0 || releaseMonth > 12) {
            throw new IllegalArgumentException("Illeagle argument for releaseMonth");
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
        assertIsValidReleaseDay(this.releaseDay);
        assertIsValidReleaseMonth(this.releaseMonth);
        assertIsValidReleaseYear(this.releaseYear);
    }
}