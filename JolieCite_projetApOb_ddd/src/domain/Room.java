package domain;

import java.util.*;

public class Room { //Aggregate
    private static int globalId = 0;
    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private int capacity;
//    private RoomSchedule roomSchedule;
    private Map<Calendar, RoomSchedule> roomSchedule; //un roomschedule pour chaque jour de l'annee
//    private Date openingDate;

    private List<Event> eventList;

    public Room(int capacity, RoomSchedule roomSchedule) {
        //Initialize id
        id = globalId++;

        this.capacity = capacity;
//        this.roomSchedule = roomSchedule;
        this.roomSchedule = new HashMap<>();

        this.eventList = new ArrayList<>();
    }

    public Room(int capacity, RoomSchedule roomSchedule, List<Event> eventList) {
        //Initialize id
        id = globalId++;

        this.capacity = capacity;
//        this.roomSchedule = roomSchedule;
        this.roomSchedule = new HashMap<>();
        this.eventList = eventList;
    }

    public int getId() {
        return id;
    }

    public void addEvent(Event event) {
        this.eventList.add(event);
    }
}
