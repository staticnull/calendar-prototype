package cms.calendar

import grails.test.*

class ActivityTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testConstraints() {
        def cat = new ActivityCategory(title: "foo")
        def type = new ActivityType(title: "bar")

        def healthy = new Activity(title: "Healthy Eating Seminars", activityCategory: cat, activityType: type)
        mockForConstraintsTests(Activity, [healthy])

        def testActivity = new Activity()
        assertFalse testActivity.validate()
        assertEquals "nullable", testActivity.errors["title"]
        assertEquals "nullable", testActivity.errors["activityCategory"]
        assertEquals "nullable", testActivity.errors["activityType"]

        testActivity = new Activity(title: "Healthy Eating Seminars", activityCategory: cat, activityType: type)
        assertFalse testActivity.validate()
        assertEquals "unique", testActivity.errors["title"]

        testActivity = new Activity(title: "Welness Email About Healthy Eating", activityCategory: cat, activityType: type)
        assertTrue testActivity.validate()
    }
}
