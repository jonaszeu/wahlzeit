package org.wahlzeit.model;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersistenceTestSuite.class,
        AccessRightsTest.class,
        SphericCoordinateTest.class,
        CartesianCoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        IndieGamePhotoTest.class,
        IndieGamePhotoFactoryTest.class,
        IndieGamePhotoManagerTest.class,
        IndieGameTest.class,
        IndieGameTypeTest.class,
        IndieGameManagerTest.class,
})

public class ModelTestSuite { /** do nothing **/ }
