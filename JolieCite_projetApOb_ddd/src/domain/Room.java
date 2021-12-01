package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room { //Aggregate
    private static int globalId = 0;
    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private int capacity;
    private RoomSchedule roomSchedule;
    private Date openingDate; //TODO check that there is only one by days
    //TODO could be many opening date ?

    private List<Event> eventList;

    public Room(int capacity, RoomSchedule roomSchedule) {
        //Initialize id
        id = globalId++;

        this.capacity = capacity;
        this.roomSchedule = roomSchedule;

        this.eventList = new ArrayList<>();
    }

    public Room(int capacity, RoomSchedule roomSchedule, List<Event> eventList) {
        //Initialize id
        id = globalId++;

        this.capacity = capacity;
        this.roomSchedule = roomSchedule;
        this.eventList = eventList;
    }

    public int getId() {
        return id;
    }
}
