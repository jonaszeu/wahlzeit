package org.wahlzeit.utils;

/*
 * Annotation Type: PatternInstance
 *
 * Version information: v1
 *
 * Date: 13.01.2019
 *
 * Copyright notice: AGPLv3
 */

public @interface PatternInstance{
    String patternName();
    String[] participants();
}