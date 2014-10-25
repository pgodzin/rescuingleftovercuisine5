package backend;

public class Data_Array {

    public static Event[] events() {


        Event[] arr = new Event[6];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Event();
        }

        int i = 0;
        arr[i].setId(0);
        arr[i].setEventTitle("Starbucks");
        arr[i].setEventTime("4:00pm");
        arr[i].setEventDate("October 25, 2014");
        arr[i].setEventLocation("2 Columbus Cir, New York, NY 10023");
        arr[i].setEventDescription("Food at Starbucks");
        arr[i].setMaxNum(6);
        arr[i].setCurrentNum(3);
        arr[i].setLeadRescuer("Bob Bie");
        i++;

        arr[i].setId(1);
        arr[i].setEventTitle("Mcdonalds");
        arr[i].setEventTime("7:00pm");
        arr[i].setEventDate("October 25, 2014");
        arr[i].setEventLocation("1188 Avenue of the Americas, New York, NY 10036");
        arr[i].setEventDescription("Food at Mcdonalds");
        arr[i].setMaxNum(7);
        arr[i].setCurrentNum(3);
        arr[i].setLeadRescuer("Test Ing");

        i++;
        arr[i].setId(2);
        arr[i].setEventTitle("Wendy's");
        arr[i].setEventTime("7:45pm");
        arr[i].setEventDate("October 26, 2014");
        arr[i].setEventLocation("938 8th Ave, New York, NY 10019");
        arr[i].setEventDescription("Food at Wendy's");
        arr[i].setMaxNum(8);
        arr[i].setCurrentNum(3);
        arr[i].setLeadRescuer("Some One");

        i++;
        arr[i].setId(3);
        arr[i].setEventTitle("KFC");
        arr[i].setEventTime("5:30pm");
        arr[i].setEventDate("October 28, 2014");
        arr[i].setEventLocation("761 7th Ave, New York, NY 10019");
        arr[i].setEventDescription("Food at KFC");
        arr[i].setMaxNum(4);
        arr[i].setCurrentNum(3);
        arr[i].setLeadRescuer("Bobby");

        i++;
        arr[i].setId(4);
        arr[i].setEventTitle("Five Guys Burgers and Fries");
        arr[i].setEventTime("4:40pm");
        arr[i].setEventDate("October 29, 2014");
        arr[i].setEventLocation("43 W 55th St, New York, NY 10019");
        arr[i].setEventDescription("Food at five guys");
        arr[i].setMaxNum(3);
        arr[i].setCurrentNum(3);
        arr[i].setLeadRescuer("Person Test");

        i++;
        arr[i].setId(5);
        arr[i].setEventTitle("Panera");
        arr[i].setEventTime("4:50pm");
        arr[i].setEventDate("October 29, 2014");
        arr[i].setEventLocation("300 Park Ave S, New York, NY");
        arr[i].setEventDescription("Food at Panera");
        arr[i].setMaxNum(10);
        arr[i].setCurrentNum(3);

        return arr;
    }
}