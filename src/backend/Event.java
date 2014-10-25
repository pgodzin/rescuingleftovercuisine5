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
    public Event(){

    }

    public int getEventSpace(){
        return 0;
    }

    public int getWaitingListEventSpace(){
        return 0;
    }

    public String getEventTitle(){
        return null;
    }

    public String getEventTime() {
        return null;
    }

}
