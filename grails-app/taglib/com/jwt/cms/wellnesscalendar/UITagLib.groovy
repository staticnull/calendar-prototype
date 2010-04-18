package com.jwt.cms.wellnesscalendar

class UITagLib {
    //  Checkbox list that can be used as a more user-friendly alternative to a multiselect list box.
    def checkBoxList = {attrs, body ->
        def name = attrs.name
        def from = attrs.from
        def optionKey = attrs.optionKey
        def optionValue = attrs.optionValue
        def value = attrs.value

        def isChecked, ht, wd, style, html

        html = "<ul style='list-style: none'>"

        from.each {obj ->

            isChecked = (value?.contains(obj."${optionKey}"))

            out << "<li>"
            out << checkBox(name: name, value: obj."${optionKey}", checked: isChecked)
            out << "&nbsp;" << obj."${optionValue}"
            out << "</li>"
        }

        out << "</ul>"
    }
}
