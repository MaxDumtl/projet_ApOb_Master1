package domain;

import java.util.Date;

public class PieceTheatre extends Event{ //Entity
//    private static int globalId = 0;
//    private final int id; //TODO check if necessary to encapsule ConcertId in a ValueObject if it's another thing than an int

    private Date beginDate;
    private Date endingDate;
    private String title;

    public PieceTheatre(Date beginDate, Date endingDate, String title, int capacity) {

        super(capacity);

//
//        //initialize id
//        this.id = globalId++;

        //initialize attributes
        this.beginDate = beginDate;
        this.endingDate = endingDate;
        this.title = title;
    }
//
//    public int getId() {
//        return id;
//    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public String getTitle() {
        return title;
    }
}
