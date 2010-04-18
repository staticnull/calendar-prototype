package com.jwt.cms.wellnesscalendar

import grails.test.*

class ActivityTypeTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testConstraints() {
        def wellness = new ActivityType(title: "Wellness Emails")
        mockForConstraintsTests(ActivityType, [wellness])

        def testActivityType = new ActivityType()
        assertFalse testActivityType.validate()
        assertEquals "nullable", testActivityType.errors["title"]

        testActivityType = new ActivityType(title: "Wellness Emails")
        assertFalse testActivityType.validate()
        assertEquals "unique", testActivityType.errors["title"]

        testActivityType = new ActivityType(title: "Onsite Activity")
        assertTrue testActivityType.validate()
    }
}
