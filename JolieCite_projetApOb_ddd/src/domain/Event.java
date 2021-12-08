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

    public boolean isSameDay(int year, int month, int numWeek, int day) {
        //if the day is not programmed
        if(this.programmedDay == null){
            return false;
        }

        //TODO debugg it
        boolean isSameYear = this.programmedDay.get(Calendar.YEAR) == year;
        boolean isSameMonth = this.programmedDay.get(Calendar.MONTH) == month;
        boolean isSameWeek = this.programmedDay.get(Calendar.WEEK_OF_YEAR) == numWeek; //TODO is it number of week in the year right ?
        boolean isSameDay = this.programmedDay.get(Calendar.DAY_OF_WEEK) == day;

        return isSameDay && isSameMonth && isSameYear && isSameYear && isSameWeek;
    }
}
