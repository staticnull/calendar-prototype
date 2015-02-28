import cms.calendar.*

class BootStrap {
    def init = {servletContext ->
        if (grails.util.GrailsUtil.isDevelopmentEnv()) {
            createActivities()
        }
    }

    def destroy = {}

    def createActivities() {
        def healthyEatingCategory = new ActivityCategory(title: "Healthy Eating").save()
        new ActivityCategory(title: "Physical Health").save()
        new ActivityCategory(title: "Stress Management/Well Being").save()

        def wellnessEmailType = new ActivityType(title: "Wellness Emails").save()
        def onsiteActivityType = new ActivityType(title: "Onsite Activity").save()
        new ActivityType(title: "Turnkey Programs").save()
        new ActivityType(title: "Health Screenings").save()
        new ActivityType(title: "Health Assessment").save()
        new ActivityType(title: "Custom Newsletter").save()

        def healthyEatingSeminarActivity = new Activity(title: "Healthy Eating Seminars", description: "Lorem ipsum dolor sit amet", activityCategory: healthyEatingCategory, activityType: onsiteActivityType).save()
        def wellnessEmailHealthyActivity = new Activity(title: "Welness Email About Healthy Eating", activityCategory: healthyEatingCategory, activityType: wellnessEmailType).save()

        // TODO remove?
        if (healthyEatingSeminarActivity?.hasErrors()) {
            System.out.println "bootstrap activity errors =" + healthyEatingSeminarActivity.errors.allErrors[0].toString()
        } else {
            System.out.println "healthy " + ((healthyEatingSeminarActivity == null) ? "is null" : "has no errors")
        }

        if (wellnessEmailHealthyActivity?.hasErrors()) {
            System.out.println "bootstrap activity errors =" + wellnessEmailHealthyActivity.errors.allErrors[0].toString()
        } else {
            System.out.println "wellness " + ((wellnessEmailHealthyActivity == null) ? "is null" : "has no errors")
        }
    }
}
