package com.jwt.cms.wellnesscalendar

import grails.test.*

class ActivityCategoryTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testConstraints() {
        def healthy = new ActivityCategory(title: "Healthy Eating")
        mockForConstraintsTests(ActivityCategory, [healthy])

        def testActivityCategory = new ActivityCategory()
        assertFalse testActivityCategory.validate()
        assertEquals "nullable", testActivityCategory.errors["title"]

        testActivityCategory = new ActivityCategory(title: "Healthy Eating")
        assertFalse testActivityCategory.validate()
        assertEquals "unique", testActivityCategory.errors["title"]

        testActivityCategory = new ActivityCategory(title: "Physical Health")
        assertTrue testActivityCategory.validate()
    }
}
