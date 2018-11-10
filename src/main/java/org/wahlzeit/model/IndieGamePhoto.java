package org.wahlzeit.model;

/*
 * Classname: IndieGamePhoto
 *
 * Version information: v1.0
 *
 * Date: 10.11.2018
 *
 * Copyright notice: AGPLv3
 */

public class IndieGamePhoto extends Photo{

    /**
     *
     */
    private String title;
    private String genre;
    private String developer;
    private String publisher;
    private int releaseDay;
    private int releaseMonth;
    private int releaseYear;


    /**
     * @methodtype constructor
     */
    public IndieGamePhoto(){
        super();
    }

    /**
     * @methodtype constructor
     */
    public IndieGamePhoto(String title, String genre, String developer, String publisher, int releaseDay, int releaseMonth, int releaseYear){
        super();

        setTitle(title);
        setGenre(genre);
        setDeveloper(developer);
        setPublisher(publisher);
        setReleaseDay(releaseDay);
        setReleaseMonth(releaseMonth);
        setReleaseYear(releaseYear);
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
    public String getTitle(){
        return this.title;
    }

    /**
     * @methodtype get
     */
    public String getGenre(){
        return this.genre;
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
    public void setDeveloper(String developer) {
        if(developer == null) {
            throw new IllegalArgumentException("Null is illeagle argument for developer");
        }
        this.developer = developer;
    }

    /**
     * @methodtype set
     */
    public void setGenre(String genre) {
        if(genre == null) {
            throw new IllegalArgumentException("Null is illeagle argument for genre");
        }
        this.genre = genre;
    }

    /**
     * @methodtype set
     */
    public void setPublisher(String publisher) {
        if(publisher == null) {
            throw new IllegalArgumentException("Null is illeagle argument for publisher");
        }
        this.publisher = publisher;
    }

    /**
     * @methodtype set
     */
    public void setReleaseDay(int releaseDay) {
        if(releaseDay <= 0 || releaseDay > 31) {
            throw new IllegalArgumentException("Illeagle argument for releaseDay");
        }
        this.releaseDay = releaseDay;
    }

    /**
     * @methodtype set
     */
    public void setReleaseMonth(int releaseMonth) {
        if(releaseMonth <= 0 || releaseMonth > 12) {
            throw new IllegalArgumentException("Illeagle argument for releaseMonth");
        }
        this.releaseMonth = releaseMonth;
    }

    /**
     * @methodtype set
     */
    public void setReleaseYear(int releaseYear) {
        if(releaseYear <= 0) {
            throw new IllegalArgumentException("Illeagle argument for releaseYear");
        }
        this.releaseYear = releaseYear;
    }

    /**
     * @methodtype set
     */
    public void setTitle(String title) {
        if(title == null) {
            throw new IllegalArgumentException("Null is illeagle argument for title");
        }
        this.title = title;
    }

}