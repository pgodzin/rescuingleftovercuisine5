package backend;

public class Event {

    private int id;
    private String eventTitle;
    private String eventTime;
    private String eventDate;
    private String eventDescription;
    private int currentNum;
    private int maxNum;
    private String leadRescuer;
    private String eventLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getLeadRescuer() {
        return leadRescuer;
    }

    public void setLeadRescuer(String leadRescuer) {
        this.leadRescuer = leadRescuer;
    }

    public void setEventDescription(String desc) {
        this.eventDescription = desc;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

}
