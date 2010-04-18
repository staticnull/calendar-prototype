package com.jwt.cms.wellnesscalendar

class Activity {
    String title
    String description

    // Daily, weekly, monthly, yearly (radio buttons)
    String recurranceFrequency

    // Weekly specific fields
    // Recur every __ week(s)
    int weeklyNumberOfWeeks

    // on:
    //  Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday checkboxes
    boolean weeklyOnSunday, weeklyOnMonday, weeklyOnTuesday, weeklyOnThursday, weeklyOnFriday, weeklyOnSaturday

    // Monthly specific fields
    // day __ of every __ month(s)
    int monthlyDayValue
    int monthlyNumberOfMonths

    Date dateCreated
    Date lastUpdated

    static belongsTo = [activityCategory: ActivityCategory, activityType: ActivityType]

    static constraints = {
        title(blank: false, unique: true)
        description(nullable: true)
        recurranceFrequency(nullable: true)
        // Weekly field constraints
        weeklyNumberOfWeeks()
        weeklyOnSunday()
        weeklyOnMonday()
        weeklyOnTuesday()
        weeklyOnThursday()
        weeklyOnFriday()
        weeklyOnSaturday()
        // Montly field constraints
        monthlyDayValue()
        monthlyNumberOfMonths()
        activityCategory(blank: false)
        activityType(blank: false)
        dateCreated()
        lastUpdated()
    }
}
