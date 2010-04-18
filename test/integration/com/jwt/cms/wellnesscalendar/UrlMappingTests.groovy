package com.jwt.cms.wellnesscalendar

import grails.test.*

class UrlMappingTests extends GrailsUnitTestCase {
    // TODO fix both throwing errors, were passing in previous projects
    void testPreviewCalendarPage() {
        assertUrlMapping("/", controller: 'previewCalendar', action: 'index')
        assertUrlMapping("/", controller: 'previewCalendar', action: 'previewCalendar')
        assertUrlMapping("/", controller: 'previewCalendar', action: 'previewCalendarSubmit')
    }

    void testErrorPages() {
        assertForwardUrlMapping(500, view: "error")
    }
  }