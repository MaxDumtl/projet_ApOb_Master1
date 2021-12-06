package domain;

import java.util.Calendar;
import java.util.Date;

public class RoomSchedule { // Entity
    private static int globalId = 0;
    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private Date openingDate;
    private Date endingTime;

    //il faut que se soit un calendirer complet :
    //"a chaque jour de lannee on va avoir des dates d'ouvertures et de fermeture"
    //faire un map qui a chaqe date donne un couple debut fin

    public RoomSchedule(Date openingDate, Date endingTime) {
        //initialize id
        id = globalId++;

        this.openingDate = openingDate;
        this.endingTime = endingTime;
    }

    public RoomSchedule(Date openingDate, int hourOpened) {
        //initialize id
        id = globalId++;

        this.openingDate = openingDate;

        //intialize ending time by adding number of hours opened to ending time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(openingDate);
        calendar.add(Calendar.HOUR_OF_DAY, hourOpened);
        this.endingTime = calendar.getTime();
    }
}
