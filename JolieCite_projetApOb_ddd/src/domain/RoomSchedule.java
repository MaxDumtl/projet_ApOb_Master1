package domain;

import java.util.Calendar;
import java.util.*;

public class RoomSchedule { // Value Object
    // private static int globalId = 0;
    // private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    //first element of the array is the hour
    //second element of the array is the minute
    private int openingHour;
    private int openingMinute;
    private int endingHour;
    private int endingMinute;

    //il faut que se soit un calendirer complet :
    //"a chaque jour de lannee on va avoir des dates d'ouvertures et de fermeture"
    //faire un map qui a chaqe date donne un couple debut fin

    public RoomSchedule(int hourStart, int minuteStart, int hourEnd, int minuteEnd) {
        //initialize id
        // id = ++globalId;
        int openingHour = hourStart;
        int openingMinute = minuteStart;
        int endingHour = hourEnd;
        int endingMinute = minuteEnd;
    }

    public int getHourStart(){
        return this.openingHour;
    }
    public int getMinuteStart(){
        return this.openingMinute;
    }
    public int getHourEnd(){
        return this.endingHour;
    }
    public int getMinuteEnd(){
        return this.endingMinute;
    }
    
    // public RoomSchedule(Calendar openingTime, int hourOpened) {
    //     //initialize id
    //     id = globalId++;

    //     this.openingTime = openingTime;

    //     //intialize ending time by adding number of hours opened to ending time
    //     Calendar calendar = Calendar.getInstance();
    //     calendar.setTime(openingTime.getTime());
    //     calendar.add(Calendar.HOUR_OF_DAY, hourOpened);
    //     this.endingTime = calendar;
    // }
}
