package domain;

import java.util.*;

public class PieceTheatre extends Event{ //Entity

    private Calendar beginDate;
    private Calendar endingDate;
    private String title;

    public PieceTheatre(Calendar beginDate, Calendar endingDate, String title, int capacity) {

        super(capacity);

        //initialize attributes
        this.beginDate = beginDate;
        this.endingDate = endingDate;
        this.title = title;
    }

    public Calendar getBeginDate() {
        return beginDate;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public String getTitle() {
        return title;
    }
}
