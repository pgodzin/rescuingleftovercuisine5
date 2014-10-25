/*

    Risham and Helen

    Hard coded data
 */

public class Data_Array {

    public static void main(String[] args) {


        Event [] arr = new Event[8]; //created an array of event


        int i =0 ;// this is the counter
        arr[0].id= 0;
        arr[i].name= "Starbucks";
        arr[i].time_start = "4:00pm";
        arr[i].time_end= "4:30pm";
        arr[i].date= "October 1, 2014";
        arr[i].day= "Wednesday";
        arr[i].location= "2 Columbus Cir, New York, NY 10023";
        arr[i].description= "Food at Starbucks";
        arr[i].event_space= 3;
        arr[i].wait_list= 1;
        arr[i].lead_rescuer = "Bob Bie";
        i++; //incrementing i for the next round

        arr[i].id = 1;
        arr[i].name = "Mcdonalds";
        arr[i].time_start =  "7:00pm";
        arr[i].time_end =  "7:30pm";
        arr[i].date = "October 11, 2014";
        arr[i].day = "Saturday";
        arr[i].location =  "1188 Avenue of the Americas, New York, NY 10036";
        arr[i].description = "Food at Mcdonalds";
        arr[i].event_space =  2;
        arr[i].wait_list = 1;
        arr[i].lead_rescuer =  "Test Ing";

        i++;
        arr[i].id =  2;
        arr[i].name = "Wendy's";
        arr[i].time_start = "7:45pm";
        arr[i].time_end = "8:00pm";
        arr[i].date =  "October 16, 2014";
        arr[i].day = "Thursday";
        arr[i].location = "938 8th Ave, New York, NY 10019";
        arr[i].description = "Food at Wendy's";
        arr[i].event_space = 3;
        arr[i].wait_list = 1;
        arr[i].lead_rescuer = "Some One";

        i++;
        arr[i].id = 3;
        arr[i].name = "KFC";
        arr[i].time_start = "5:30pm";
        arr[i].time_end = "6:00pm";
        arr[i].date = "October 20, 2014";
        arr[i].day =  "Monday";
        arr[i].location = "761 7th Ave, New York, NY 10019";
        arr[i].description = "Food at KFC";
        arr[i].event_space =  4;
        arr[i].wait_list =  2;
        arr[i].lead_rescuer = "Bobby";

        i++;
        arr[i].id = 4,
        arr[i].name = "Five Guys Burgers and Fries";
        arr[i].time_start = "4:40pm";
        arr[i].time_end = "5:30pm";
        arr[i].date = "October 23, 2014";
        arr[i].day = "Thursday";
        arr[i].location = "43 W 55th St, New York, NY 10019";
        arr[i].description = "Food at five guys";
        arr[i].event_space = 3;
        arr[i].wait_list = 1;
        arr[i].lead_rescue = "Person Test";

        i++;
        arr[i].id = 5;
        arr[i].name = "Panera"
        arr[i].time_start = "4:30pm";
        arr[i].time_end = "5:30pm";
        arr[i].date = "October 21";
        arr[i].day = "Tuesday";
        arr[i].location = "300 Park Ave S, New York, NY";
        arr[i].description = "Food at Panera";
        arr[i].event_space = 2;
        arr[i].wait_list = 1;
        arr[i].lead_rescuer = "Bob";

        i++;
        arr[i].id = 6;
        arr[i].name = "Subway";
        arr[i].time_start = "1:30pm";
        arr[i].time_end = "2:30pm";
        arr[i].date = "October 22";
        arr[i].day = "Wednesday";
        arr[i].location = "304 Park Ave S, New York, NY";
        arr[i].description = "Food at Subway";
        arr[i].event_space = 2;
        arr[i].wait_list = 1;
        arr[i].lead_rescuer = "Jasmine";

        i++;
        arr[i].id = 7;
        arr[i].name = "Tacobell";
        arr[i].time_start = "3:30pm";
        arr[i].time_end = "4:30pm";
        arr[i].date = "October 23";
        arr[i].day = "Thursday";
        arr[i].location = "310 Park Ave S, New York, NY";
        arr[i].description = "Food at Tacobell";
        arr[i].event_space = 2;
        arr[i].wait_list = 1;
        arr[i].lead_rescuer = "hello";

        int total = i;
        for(i=0; i <= total; i++){
            System.out.println(EventClass.toString(arr[i]));
        }
     }

}