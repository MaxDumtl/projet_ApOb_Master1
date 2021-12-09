package domain;

import java.util.Calendar;

public class Event { //Entity
    private static int globalId = 0;
    private final int id;

    private int capacity;
    private Calendar programmedDay;

    public Event(int capacity) {
        //initialize id
        this.id = ++globalId;
        this.capacity = capacity;

        this.programmedDay = null;
    }

    public Event(int capacity, Calendar programmedDay) {
        //initialize id
        this.id = ++globalId;
        this.capacity = capacity;

        this.programmedDay = programmedDay;
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

        boolean isSameYear = this.programmedDay.get(Calendar.YEAR) == year;
        boolean isSameMonth = this.programmedDay.get(Calendar.MONTH) == month;
        boolean isSameDay = this.programmedDay.get(Calendar.DAY_OF_MONTH) == day;

        return isSameDay && isSameMonth && isSameYear && isSameYear;
    }
}
