package org.wahlzeit.model;

/*
 * Classname: IndieGameManager
 *
 * Version information: v1.0
 *
 * Date: 19.01.2019
 *
 * Copyright notice: AGPLv3
 */

import java.util.HashMap;

public class IndieGameManager{

    /**
     *
     */
    private static final IndieGameManager instance = new IndieGameManager();

    /**
     *
     */
    private static final HashMap<String, IndieGameType> INDIE_GAME_TYPE_HASH_MAP = new HashMap<>();

    /**
     * @methodtype constructor
     */
    private IndieGameManager(){}

    /**
     * @methodtype get
     */
    public static IndieGameManager getInstance(){
        return IndieGameManager.instance;
    }

    /**
     * @methodtype get
     */
    public synchronized IndieGameType getIndieGameType(String genre){
        assertIsNonNullArgument("genre", genre);
        IndieGameType type = INDIE_GAME_TYPE_HASH_MAP.get(genre);
        if(type != null){
            return type;
        }else {
            type = new IndieGameType(genre);
            INDIE_GAME_TYPE_HASH_MAP.put(genre, type);
            return type;
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNonNullArgument(String stringAttribute, String value) throws NullPointerException{
        if(value == null){
            throw new NullPointerException("Null is no acceptable argument for " + stringAttribute);
        }
    }
}