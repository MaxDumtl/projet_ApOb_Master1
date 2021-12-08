package domain;

import java.util.Date;

public class Concert extends Event{ //Entity

    private Date date;
    private Artist artist;

    public Concert(Date date, Artist artist, int capacity) {
        super(capacity);

//        //initialize id //concert.id == event.id
//        id = globalId++;

        this.date = date;
        this.artist = artist;
    }

    public Date getDate() {
        return date;
    }

    public Artist getArtist() {
        return artist;
    }
}
