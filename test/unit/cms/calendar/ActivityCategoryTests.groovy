package cms.calendar

import grails.test.*
import junit.framework.Assert

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
        Assert.assertFalse testActivityCategory.validate()
        assertEquals "nullable", testActivityCategory.errors["title"]

        testActivityCategory = new ActivityCategory(title: "Healthy Eating")
        Assert.assertFalse testActivityCategory.validate()
        assertEquals "unique", testActivityCategory.errors["title"]

        testActivityCategory = new ActivityCategory(title: "Physical Health")
        Assert.assertTrue testActivityCategory.validate()
    }
}
