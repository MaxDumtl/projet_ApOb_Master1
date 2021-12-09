package domain;

import java.util.Calendar;
import java.util.*;

public class RoomSchedule { // Value Object

    private int openingHour;
    private int openingMinute;
    private int endingHour;
    private int endingMinute;

    public RoomSchedule(int hourStart, int minuteStart, int hourEnd, int minuteEnd) {
        int openingHour = hourStart;
        int openingMinute = minuteStart;
        int endingHour = hourEnd;
        int endingMinute = minuteEnd;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public int getOpeningMinute() {
        return openingMinute;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public int getEndingMinute() {
        return endingMinute;
    }

}
