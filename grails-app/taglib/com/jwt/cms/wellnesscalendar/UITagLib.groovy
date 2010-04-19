package com.jwt.cms.wellnesscalendar

import java.text.*

class UITagLib {
    //  Checkbox list that can be used as a more user-friendly alternative to a multiselect list box.
    def checkBoxList = {attrs, body ->
        def name = attrs.name
        def from = attrs.from
        def optionKey = attrs.optionKey
        def optionValue = attrs.optionValue
        def value = attrs.value

        out << "<ul style='list-style: none'>"

        from.each {obj ->

            def isChecked = (value?.contains(obj."${optionKey}"))

            out << "<li>"
            out << checkBox(name: name, value: obj."${optionKey}", checked: isChecked)
            out << "&nbsp;" << obj."${optionValue}"
            out << "</li>"
        }

        out << "</ul>"
    }

    def formatDate = {attrs ->
        out << new SimpleDateFormat("MM/dd/yyyy").format(attrs.date)
    }

    def formatMonth = {attrs ->
        out << new SimpleDateFormat("MM/yyyy").format(attrs.date)
    }

    def selectMonth = {attrs ->
        // TODO better way?
        def monthIds = Calendar.JANUARY..Calendar.DECEMBER
        def monthValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        Map months = [:]
        def i = 0;
        monthIds.each {it ->
            months.put(it, monthValues[i++])
        }

        out << g.select(from: months, name: attrs.name, value: attrs.value, optionKey: "key", optionValue: "value", noSelection: attrs.noSelection)
    }

    def selectState = {attrs ->
        def stateList = [
                AL: "Alabama",
                AK: "Alaska",
                AZ: "Arizona",
                AR: "Arkansas",
                CA: "California",
                CO: "Colorado",
                CT: "Connecticut",
                DC: "District of Columbia",
                DE: "Delaware",
                FL: "Florida",
                GA: "Georgia",
                HI: "Hawaii",
                ID: "Idaho",
                IL: "Illinois",
                IN: "Indiana",
                IA: "Iowa",
                KS: "Kansas",
                KY: "Kentucky",
                LA: "Louisiana",
                ME: "Maine",
                MD: "Maryland",
                MA: "Massachusetts",
                MI: "Michigan",
                MN: "Minnesota",
                MS: "Mississippi",
                MO: "Missouri",
                MT: "Montana",
                NE: "Nebraska",
                NV: "Nevada",
                NH: "New Hampshire",
                NJ: "New Jersey",
                NM: "New Mexico",
                NY: "New York",
                NC: "North Carolina",
                ND: "North Dakota",
                OH: "Ohio",
                OK: "Oklahoma",
                OR: "Oregon",
                PA: "Pennsylvania",
                RI: "Rhode Island",
                SC: "South Carolina",
                SD: "South Dakota",
                TN: "Tennessee",
                TX: "Texas",
                UT: "Utah",
                VT: "Vermont",
                VA: "Virginia",
                WA: "Washington",
                WI: "Wisconsin",
                WV: "West Virginia",
                WY: "Wyoming"]

        out << "<select name='${attrs.name}' id='${attrs.id}'>"
        out << "<option value=''>Select...</option>"
        stateList.each {
            out << "<option value='${it.key}'"
            if (attrs.selectedValue == it.key) {
                out << " selected='selected'"
            }
            out << ">${it.value}</option>"
        }
        out << "</select>"
    }
}
