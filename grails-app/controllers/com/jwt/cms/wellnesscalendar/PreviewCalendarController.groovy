package com.jwt.cms.wellnesscalendar

import java.text.SimpleDateFormat

class PreviewCalendarCommand {
    List activityCategories
    List ids
    String month
    String year

    static hasMany = [activityCategories: ActivityCategory]

    static constraints = {
        // At least one id must be selected
        ids(validator: {
            (it != null)
        })
        month(blank: false)
        year(blank: false)
    }

    // Setter used for checkbox list to convert the ids selected to domain objects.
    public void setIds(List ids) {
        this.ids = ids
        this.activityCategories = ids.collect { ActivityCategory.get(it) }
    }
}

class PreviewCalendarController {
    def index = {
        redirect(action: 'previewCalendar')
    }

    def calendar = {
        // Generate month view YUI calendar from activites
        def idsString = params.ids
        def month = params.month
        def year = params.year

        def ids = idsString.split(";")

        def activityCategories = ids.collect { ActivityCategory.get(it) }
        // Find activity(s) by above criteria
//      def activities = Activity.findAllByActivityCategoryInList(activityCategories)
        def activities = activityCategories.collect{ Activity.findAllByActivityCategory(it) }

        def startDate = new Date(Integer.parseInt(year), Integer.parseInt(month), 1)

        def viewInfo = [:]

        def events = []
        def i = 0; // TODO temp
        activities.each() {
            def event = [:]
            // TODO calc real date i.e. start date from activity
            event.put("startDate", startDate + i)
            event.put("endDate", startDate + i)
            event.put("title", it ? it?.title : "blank" ) // TODO blank is temporary

            events.add(event)
        }

        viewInfo.put("events", events)

        // Generate month view YUI calendar from activites
        return ["viewInfo": viewInfo]
    }

    def previewCalendar = {
        return [viewInfo: getPreviewViewInfo()]
    }

    def previewCalendarSubmit = {PreviewCalendarCommand command ->
        if (command.hasErrors()) {
            render(view: 'previewCalendar', model: [previewCalendar: command, viewInfo: getPreviewViewInfo()])
        } else {
            def ids = command.activityCategories.collect{it.id}.join(";")
            def month = command.month
            def year = command.year

            redirect(action: "calendar", params: [ids: ids, month: month, year: year])
        }
    }

    def getPreviewViewInfo() {
        def activityCategories = ActivityCategory.listOrderByTitle()

        // TODO better way?
        def monthIds = Calendar.JANUARY..Calendar.DECEMBER
        def monthValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        Map months = [:]
        def i = 0;
        monthIds.each {it ->
            months.put(it, monthValues[i++])
        }

        def years = Calendar.getInstance().get(Calendar.YEAR)..Calendar.getInstance().get(Calendar.YEAR) + 5

        return ["activityCategories": activityCategories, "months": months, "years": years]
    }
}