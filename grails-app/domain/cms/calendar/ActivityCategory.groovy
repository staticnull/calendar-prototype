package cms.calendar

class ActivityCategory {
    String title

    Date dateCreated
    Date lastUpdated

    static constraints = {
        title(blank: false, unique: true)
    }
}
