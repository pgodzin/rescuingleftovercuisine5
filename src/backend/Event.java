package backend;

import java.util.Date;

/**
 * Created by Damas on 10/24/14.
 */
public class Event {

    private String eventTitle;
    private String eventTime;
    private String eventDescription;
    private int eventSpace;
    private int waitingListEventSpace;
    private String leadRescuer;
    private String eventLocation;

    //initialize event from the website
    public Event(String title, String time){
        this.eventTitle = title;
        this.eventTime = time;
    }

    public void setEventDescription(String desc){
        this.eventDescription = desc;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription(){
        return eventDescription;
    }

    public String getEventLocation(){
        return eventLocation;
    }

    public int getEventSpace(){
        return 0;
    }

    public int getWaitingListEventSpace(){
        return 0;
    }

    public String getEventTitle(){
        return eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

}
