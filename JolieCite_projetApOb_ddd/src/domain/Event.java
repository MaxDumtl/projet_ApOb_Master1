package domain;

public class Event { //Entity //TODO or maybe an Aggregate ???
    private static int globalId = 0;
    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private int capacity;

    public Event(int capacity) {
        //initialize id
        this.id = globalId++;

        this.capacity = capacity;
    }
}
