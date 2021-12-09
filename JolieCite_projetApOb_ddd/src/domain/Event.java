package domain;

import java.util.Calendar;

public class Event { //Entity
    private static int globalId = 0;
    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private int capacity;
    private Calendar programmedDay;

    public Event(int capacity) {
        //initialize id
        this.id = globalId++;
        this.capacity = capacity;

        this.programmedDay = null;
    }

    public int getId() {
        return id;
    }

    public Calendar getProgrammedDay(){
        return this.programmedDay;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean isSameDay(int year, int month, int day) {
        //if the day is not programmed
        if(this.programmedDay == null){
            return false;
        }

        //TODO debugg it
        boolean isSameYear = this.programmedDay.get(Calendar.YEAR) == year;
        boolean isSameMonth = this.programmedDay.get(Calendar.MONTH) == month;
        boolean isSameDay = this.programmedDay.get(Calendar.DAY_OF_MONTH) == day;

        return isSameDay && isSameMonth && isSameYear && isSameYear;
    }
}
