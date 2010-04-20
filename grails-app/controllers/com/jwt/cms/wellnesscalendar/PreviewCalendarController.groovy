package com.jwt.cms.wellnesscalendar

import java.text.*
import java.util.*

class PreviewCalendarCommand {
    List activityCategories // TODO Seems to be need for assignets below.
    List ids
    String month
    String year

    static hasMany = [activityCategories: ActivityCategory]

    static constraints = {
        // At least one id must be selected.
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

    def fullCalendar = {
        def idTokenString = params.ids
        def startDate = params.startDate

        return getEventsViewInfo(idTokenString, startDate)
    }

    def calendar = {
        def idTokenString = params.ids
        def startDate = params.startDate

        return getEventsViewInfo(idTokenString, startDate)
    }

    def previewCalendar = {
        return [viewInfo: getPreviewViewInfo()]
    }

    def previewCalendarSubmit = {PreviewCalendarCommand command ->
        if (command.hasErrors()) {
            render(view: 'previewCalendar', model: [previewCalendar: command, viewInfo: getPreviewViewInfo()])
        } else {
            def ids = command.activityCategories.collect {it.id}.join(";")
            def month = command.month as int
            def year = command.year as int
            def startDate = (month + 1) + "/01/" + year

            redirect(action: "calendar", params: [ids: ids, startDate: startDate])
        }
    }

    def getEventsViewInfo(idTokenString, startDate) {
        def ids = idTokenString.split(";")

        def activityCategories = ids.collect { ActivityCategory.findById(it) }

        def activities = Activity.findAllByActivityCategoryInList(activityCategories).flatten()

        Date utilDate = parseDateString(startDate)

        def events = []
        activities.each() {
            def event = [:]
            if (it) {
                // TODO calc real date i.e. start date from activity
                event.put("startDate", utilDate)
                event.put("endDate", utilDate)
                event.put("title", it ? it?.title : "blank") // TODO blank is temporary
                event.put("description", it ? it?.title : "blank")

                events.add(event)
            }
        }

        def viewInfo = [:]
        viewInfo.put("events", events)
        viewInfo.put("utilDate", utilDate)

        return ["viewInfo": viewInfo]
    }

    def getPreviewViewInfo() {
        def activityCategories = ActivityCategory.listOrderByTitle()

        return ["activityCategories": activityCategories]
    }

    def parseDateString(date) {
        Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        } catch (ParseException e) {
            log e.toString()
            log e.printStackTrace();
        }

        return utilDate
    }
}