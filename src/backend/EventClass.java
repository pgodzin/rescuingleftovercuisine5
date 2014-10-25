/*

    Risham and Helen

 */
package backend;
public class EventClass{
    int id;
    String name;
    String time_start;
    String time_end;
    String date;
    String day;
    String location;
    String description;
    int event_space;
    int wait_list;
    String lead_rescuer;
 
    
    
    public static String toString(EventClass printing){
        return "Name: " + printing.name+"\n"+ "Location: " + printing.location + "\n" + "Time: " + printing.time_start + " - " + printing.time_end;

    }


}