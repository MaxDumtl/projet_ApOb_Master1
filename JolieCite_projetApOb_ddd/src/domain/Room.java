package domain;

import java.util.*;

public class Room { //Aggregate
    private static int globalId = 0;
    private final int id;

    private String name;
    private int capacity;
    private Map<Calendar, RoomSchedule> roomSchedule; //one RoomSchedule for each day

    private List<Event> eventList;

    public Room(String name, int capacity) {
        //Initialize id
        id = ++globalId;

        this.name = name;
        this.capacity = capacity;
        this.roomSchedule = new HashMap<>();
        this.eventList = new ArrayList<>();
    }

    public Room(int capacity, RoomSchedule roomSchedule, List<Event> eventList) {
        //Initialize id
        id = globalId++;

        this.capacity = capacity;
        this.roomSchedule = new HashMap<>();
        this.eventList = eventList;
    }

    public void addSchedule(Calendar date, int hourStart, int minuteStart, int hourEnd, int minuteEnd){
        RoomSchedule newRoomSchedule = new RoomSchedule(hourStart, minuteStart, hourEnd, minuteEnd);
        this.roomSchedule.put(date, newRoomSchedule);
    }

    public void addEvent(Calendar date, Artist artist, int capacity) {
        Event newEvent = new Concert(date, artist, capacity);
        this.eventList.add(newEvent);
    }

    public void addEvent(Calendar beginDate, Calendar endingDate, String title, int capacity) {
        Event newEvent = new PieceTheatre(beginDate,  endingDate, title, capacity);
        this.eventList.add(newEvent);
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }


    public List<Event> getEvent() {
        return this.eventList;
    }

    public RoomSchedule getSchedule(Calendar day) {
        return this.roomSchedule.get(day);
    }
}
