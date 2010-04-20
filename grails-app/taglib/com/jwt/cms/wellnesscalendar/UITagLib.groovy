package com.jwt.cms.wellnesscalendar

import java.text.*

class UITagLib {
    // Checkbox list that can be used as a more user-friendly alternative to a multiselect list box.
    // Reworked from http://www.grails.org/Contribute+a+Tag#checkBoxList
    def checkBoxList = {attrs, body ->
        def name = attrs.name
        def from = attrs.from
        def optionKey = attrs.optionKey
        def optionValue = attrs.optionValue
        def value = attrs.value

        out << "<ul style='list-style: none; overflow: auto; overflow-x: hidden; border: 0px solid #000; margin: 0; padding: 0px'>"

        from.each {obj ->

            def isChecked = (value?.contains(obj."${optionKey}"))

            out << "<li>"
            out << checkBox(name: name, value: obj."${optionKey}", checked: isChecked)
            out << "&nbsp;" << obj."${optionValue}"
            out << "</li>"
        }

        out << "</ul>"
    }

    def formatMonth = {attrs ->
        out << new SimpleDateFormat(attrs.format).format(attrs.value)
    }

    def formatDate = {attrs ->
        out << new SimpleDateFormat(attrs.format).format(attrs.value)
    }

    def selectMonth = {attrs ->
        def monthKeys = Calendar.JANUARY..Calendar.DECEMBER
        def monthValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        Map months = [:]
        def i = 0;
        monthKeys.each {it ->
            months.put(it, monthValues[i++])
        }

        out << g.select(from: months, name: attrs.name, value: attrs.value, optionKey: "key", optionValue: "value", noSelection: attrs.noSelection)
    }
}
