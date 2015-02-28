package cms.calendar

class ActivityType {
    String title

    Date dateCreated
    Date lastUpdated

    static constraints = {
        title(blank: false, unique: true)
    }
}
