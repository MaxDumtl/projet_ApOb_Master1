package domain;

import java.util.Calendar;
import java.util.Date;

public class Concert extends Event{ //Entity

    private Calendar date;
    private Artist artist;

    public Concert(Calendar date, Artist artist, int capacity) {
        super(capacity);

        this.date = date;
        this.artist = artist;
    }

    public Concert(Calendar date, Artist artist, int capacity, Calendar programmedDay) {
        super(capacity, programmedDay);

        this.date = date;
        this.artist = artist;
    }

    public Calendar getDate() {
        return date;
    }

    public Artist getArtist() {
        return artist;
    }
}
