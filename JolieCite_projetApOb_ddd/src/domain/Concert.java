package domain;

import java.util.Date;

public class Concert { //Entity
    private static int globalId = 0;
    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private Date date;
    private Artist artist;

    public Concert(Date date, Artist artist) {
        //initialize id
        id = globalId++;

        this.date = date;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Artist getArtist() {
        return artist;
    }
}
