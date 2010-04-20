package com.jwt.cms.wellnesscalendar

// TODO asserts don't seem to be working within pacakage
class UrlMappingsTests extends grails.test.GrailsUrlMappingsTestCase {
    void testPreviewCalendarPage() {
        assertUrlMapping("/", controller: 'previewCalendar', action: 'index')
        assertUrlMapping("/", controller: 'previewCalendar', action: 'previewCalendar')
        assertUrlMapping("/", controller: 'previewCalendar', action: 'previewCalendarSubmit')
    }

    void testErrorMappings() {
        assertUrlMapping(500, view: "error")
    }
  }