package application;

import domain.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

public class CommandAddEventToRoom extends Command {

    private RoomRepository repository;
    private int eventId;
    private int hour;

    //COnstructor help to get necessarry object to execute its "mission"
    public CommandAddEventToRoom(RoomRepository repository, int eventId, int hour) {
        this.repository = repository;
        this.eventId = eventId;
        this.hour = hour;
    }

    @Override
    public void execute() {
        //get the room & the event
        Event event = this.repository.finEventdById(eventId);
        Room room = getSelectedRoom();

        //add the event to the room
        if (event instanceof Concert) {
            Concert concert = (Concert) event;
            room.addEvent(concert.getDate(), concert.getArtist(), concert.getCapacity());
        } else {
            PieceTheatre piece = (PieceTheatre) event;
            room.addEvent(piece.getBeginDate(), piece.getEndingDate(), piece.getTitle(), piece.getCapacity());
        }

    }

    private Room getSelectedRoom() {
        Room selectedRoom = null;
        Event event = this.repository.finEventdById(this.eventId);
        int eventCapacity = event.getCapacity();

        for (Room currentRoom : this.repository.getRooms()) { // Loop on every loop
            //check if the room capacity is correct
            if (!(eventCapacity > currentRoom.getCapacity())) {

                //check hour
                Calendar programmedDay = null;
                if (event instanceof Concert) {
                    Concert currentConcert = (Concert) event;
                    programmedDay = currentConcert.getDate();

                } else if (event instanceof PieceTheatre) {
                    PieceTheatre currentPieceTheatre = (PieceTheatre) event;
                    programmedDay = currentPieceTheatre.getBeginDate();
                }

                int programmedDayOpeningHour = currentRoom.getSchedule(programmedDay).getOpeningHour();
                int programmedDayEndingHour = currentRoom.getSchedule(programmedDay).getEndingHour();

                //check if the hour schedule is correct
                if (!(this.hour > programmedDayEndingHour && this.hour < programmedDayOpeningHour)) {
                    //check the other constraints
                    //TODO

                    selectedRoom = currentRoom;
                }
            }
        }

        return selectedRoom;
    }
}
